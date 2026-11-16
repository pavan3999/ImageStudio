#!/system/bin/sh
# Image Studio 4.5 - dual boot-image repacker.
# Args: BIN_DIR WORK_DIR [mode] [level] [reserved] [--legacy]
set -eu
BIN_DIR=${1:?missing binary directory}
WORK_DIR=${2:?missing work directory}
MODE=${3:-normal}
LEVEL=${4:-}
MAGISKBOOT="$BIN_DIR/magiskboot"
BB="$BIN_DIR/busybox"
if [ -x "$MAGISKBOOT" ] && [ -s "$WORK_DIR/original-boot.img" ] && [ -d "$WORK_DIR/magiskboot-work" ]; then
    cd "$WORK_DIR/magiskboot-work"
    for part in kernel kernel_dtb dtb second extra recovery_dtbo vendor_bootconfig; do
        if [ -s "$WORK_DIR/$part" ]; then cp -f "$WORK_DIR/$part" "$part"; else rm -f "$part"; fi
    done
    rm -rf vendor_ramdisk
    if [ -d "$WORK_DIR/vendor_ramdisk" ]; then cp -R "$WORK_DIR/vendor_ramdisk" vendor_ramdisk; fi
    if [ -d "$WORK_DIR/ramdisk" ]; then
        rm -f ramdisk.cpio
        (cd "$WORK_DIR/ramdisk" && "$BB" find . -print | "$BB" cpio -o -H newc) > ramdisk.cpio
    elif [ -s "$WORK_DIR/ramdisk.cpio" ]; then
        cp -f "$WORK_DIR/ramdisk.cpio" ramdisk.cpio
    fi
    OUT="$WORK_DIR/image-new.img"
    "$MAGISKBOOT" repack "$WORK_DIR/original-boot.img" "$OUT"
    [ -s "$OUT" ] || { echo "MagiskBoot did not produce an output image." >&2; exit 5; }
    echo "Repacked image: $OUT"
    exit 0
fi
# Legacy AIK is an explicit fallback, never automatic.
if [ "${6:-}" = "--legacy" ] && [ -x "$BIN_DIR/repack" ] && [ -x "$BIN_DIR/mkbootfs" ] && \
   [ -d "$WORK_DIR/split_img" ] && [ -d "$WORK_DIR/ramdisk" ]; then
    SPLIT="$WORK_DIR/split_img"
    set -- "$SPLIT"/*-zImage
    [ -f "$1" ] || { echo "Legacy kernel component missing." >&2; exit 6; }
    KERNEL=${1##*/}
    read_meta() {
        pattern=$1
        for f in "$SPLIT"/$pattern; do
            [ -f "$f" ] && { cat "$f"; return 0; }
        done
        echo "Missing legacy metadata: $pattern" >&2
        return 1
    }
    RAMDISKCOMP=$(read_meta '*-ramdiskcomp')
    RAMDISKTYPE=$(read_meta '*-ramdisktype')
    CMDLINE=$(read_meta '*-cmdline')
    BOARD=$(read_meta '*-board')
    BASE=$(read_meta '*-base')
    PAGESIZE=$(read_meta '*-pagesize')
    KERNELOFF=$(read_meta '*-kerneloff')
    RAMDISKOFF=$(read_meta '*-ramdiskoff')
    TAGSOFF=$(read_meta '*-tagsoff')
    if [ "$MODE" = "--original" ]; then
        set -- "$SPLIT"/*-ramdisk.cpio*
        [ -f "$1" ] || { echo "Original ramdisk component missing." >&2; exit 6; }
        RAMDISK_PATH=$1
    else
        case "$MODE" in
            normal) ;;
            --level) [ -n "$LEVEL" ] || { echo "--level requires a compression level." >&2; exit 2; } ;;
            *) echo "Unknown repack mode: $MODE" >&2; exit 2 ;;
        esac
        rm -f "$WORK_DIR"/ramdisk-new.cpio.*
        case "$RAMDISKCOMP" in
            gzip) EXT=gz ;;
            xz) EXT=xz ;;
            lzma) EXT=lzma ;;
            bzip2) EXT=bz2 ;;
            lz4) EXT=lz4 ;;
            lzop) EXT=lzo ;;
            *) echo "Unsupported legacy ramdisk compression: $RAMDISKCOMP" >&2; exit 7 ;;
        esac
        "$BIN_DIR/mkbootfs" "$WORK_DIR/ramdisk" > "$WORK_DIR/ramdisk-new.cpio"
        case "$RAMDISKCOMP" in
            gzip) "$BB" gzip -n -c "$WORK_DIR/ramdisk-new.cpio" > "$WORK_DIR/ramdisk-new.cpio.$EXT" ;;
            xz) "$BIN_DIR/xz" "${LEVEL:--1}" -Ccrc32 -c "$WORK_DIR/ramdisk-new.cpio" > "$WORK_DIR/ramdisk-new.cpio.$EXT" ;;
            lzma) "$BIN_DIR/xz" "${LEVEL:--1}" -Flzma -c "$WORK_DIR/ramdisk-new.cpio" > "$WORK_DIR/ramdisk-new.cpio.$EXT" ;;
            bzip2) "$BB" bzip2 -c "$WORK_DIR/ramdisk-new.cpio" > "$WORK_DIR/ramdisk-new.cpio.$EXT" ;;
            lz4) "$BIN_DIR/lz4" "${LEVEL:+-$LEVEL}" -l "$WORK_DIR/ramdisk-new.cpio" "$WORK_DIR/ramdisk-new.cpio.$EXT" ;;
            lzop) "$BB" lzop -c "$WORK_DIR/ramdisk-new.cpio" > "$WORK_DIR/ramdisk-new.cpio.$EXT" ;;
        esac
        RAMDISK_PATH="$WORK_DIR/ramdisk-new.cpio.$EXT"
    fi
    set -- "$SPLIT"/*-second
    SECOND_ARGS=""
    if [ -f "$1" ]; then
        SECOND_FILE=${1##*/}
        SECOND_OFF=$(read_meta '*-secondoff')
        SECOND_ARGS="--second $SPLIT/$SECOND_FILE --second_offset $SECOND_OFF"
    fi
    set -- "$SPLIT"/*-dtb
    DT_ARGS=""
    if [ -f "$1" ]; then DT_FILE=${1##*/}; DT_ARGS="--dt $SPLIT/$DT_FILE"; fi
    # shellcheck disable=SC2086
    "$BIN_DIR/repack" --kernel "$SPLIT/$KERNEL" --ramdisk "$RAMDISK_PATH" \
        $SECOND_ARGS --cmdline "$CMDLINE" --board "$BOARD" --base "$BASE" \
        --pagesize "$PAGESIZE" --kernel_offset "$KERNELOFF" \
        --ramdisk_offset "$RAMDISKOFF" --tags_offset "$TAGSOFF" \
        --ramdisktype "$RAMDISKTYPE" $DT_ARGS -o "$WORK_DIR/image-new.img"
    [ -s "$WORK_DIR/image-new.img" ] || { echo "Legacy repacker did not create output." >&2; exit 8; }
    echo "Repacked image: $WORK_DIR/image-new.img"
    exit 0
fi
echo "No compatible repack engine or original image metadata found." >&2
exit 9
