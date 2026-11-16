#!/system/bin/sh
# Image Studio 4.5 - dual boot-image engine.
# Args: BIN_DIR WORK_DIR IMAGE [--legacy]
set -eu
BIN_DIR=${1:?missing binary directory}
WORK_DIR=${2:?missing work directory}
IMAGE=${3:?missing input image}
ENGINE=${4:-auto}
[ -d "$BIN_DIR" ] || { echo "Binary directory not found: $BIN_DIR" >&2; exit 2; }
[ -f "$IMAGE" ] || { echo "Image not found: $IMAGE" >&2; exit 2; }
mkdir -p "$WORK_DIR"
MAGISKBOOT="$BIN_DIR/magiskboot"
LEGACY_UNPACK="$BIN_DIR/unpack"
BB="$BIN_DIR/busybox"
cp -f "$IMAGE" "$WORK_DIR/original-boot.img"
if [ -x "$MAGISKBOOT" ]; then
    mkdir -p "$WORK_DIR/magiskboot-work"
    cd "$WORK_DIR/magiskboot-work"
    rm -f kernel kernel_dtb ramdisk.cpio second dtb extra recovery_dtbo header
    set +e
    "$MAGISKBOOT" unpack -h "$WORK_DIR/original-boot.img"
    rc=$?
    set -e
    case "$rc" in
        0)
            echo "Engine: MagiskBoot"
            for part in kernel kernel_dtb ramdisk.cpio second dtb extra recovery_dtbo header; do
                [ ! -f "$part" ] || cp -f "$part" "$WORK_DIR/$part"
            done
            if [ -f "$WORK_DIR/ramdisk.cpio" ]; then
                rm -rf "$WORK_DIR/ramdisk"
                mkdir -p "$WORK_DIR/ramdisk"
                (cd "$WORK_DIR/ramdisk" && "$BB" cpio -idm < "$WORK_DIR/ramdisk.cpio")
            fi
            echo "Done! Components are in $WORK_DIR"
            exit 0 ;;
        3)
            echo "Engine: MagiskBoot (vendor_boot)"
            for part in kernel kernel_dtb ramdisk.cpio second dtb extra recovery_dtbo header vendor_bootconfig; do
                [ ! -f "$part" ] || cp -f "$part" "$WORK_DIR/$part"
            done
            if [ -d vendor_ramdisk ]; then
                rm -rf "$WORK_DIR/vendor_ramdisk"
                cp -R vendor_ramdisk "$WORK_DIR/vendor_ramdisk"
            fi
            echo "Vendor boot components are in $WORK_DIR/vendor_ramdisk (when present). Keep each ramdisk fragment separate."
            exit 0 ;;
        *)
            echo "MagiskBoot could not parse this image (exit $rc)." >&2
            exit 4 ;;
    esac
fi
# Explicit legacy fallback only; never fallback after MagiskBoot parse failure.
MAGIC=$(dd if="$IMAGE" bs=1 count=8 2>/dev/null || true)
if [ "$ENGINE" = "--legacy" ] && [ "$MAGIC" = "ANDROID!" ] && \
   [ -x "$LEGACY_UNPACK" ] && [ -x "$BIN_DIR/file" ] && [ -f "$BIN_DIR/magic" ]; then
    echo "Engine: explicitly selected legacy AIK"
    rm -rf "$WORK_DIR/ramdisk" "$WORK_DIR/split_img"
    mkdir -p "$WORK_DIR/ramdisk" "$WORK_DIR/split_img"
    (cd "$WORK_DIR/split_img" && "$LEGACY_UNPACK" -i "$WORK_DIR/original-boot.img")
    set -- "$WORK_DIR"/split_img/*-ramdisk.gz
    [ -f "$1" ] || { echo "Legacy ramdisk component missing." >&2; exit 5; }
    RAMDISK_GZ=$1
    DESC=$("$BIN_DIR/file" -m "$BIN_DIR/magic" "$RAMDISK_GZ")
    COMP=$(printf '%s\n' "$DESC" | "$BB" cut -d: -f2 | "$BB" cut -d' ' -f2)
    RAMDISK_CPIO="$WORK_DIR/ramdisk.cpio"
    case "$COMP" in
        gzip) "$BB" gzip -dc "$RAMDISK_GZ" > "$RAMDISK_CPIO" ;;
        xz) "$BIN_DIR/xz" -dc "$RAMDISK_GZ" > "$RAMDISK_CPIO" ;;
        lzma) "$BIN_DIR/xz" --format=lzma -dc "$RAMDISK_GZ" > "$RAMDISK_CPIO" ;;
        bzip2) "$BB" bzip2 -dc "$RAMDISK_GZ" > "$RAMDISK_CPIO" ;;
        lz4) "$BIN_DIR/lz4" -dq "$RAMDISK_GZ" stdout > "$RAMDISK_CPIO" ;;
        lzop) "$BB" lzop -dc "$RAMDISK_GZ" > "$RAMDISK_CPIO" ;;
        *) echo "Unsupported legacy ramdisk compression: $COMP" >&2; exit 6 ;;
    esac
    (cd "$WORK_DIR/ramdisk" && "$BB" cpio -idmv < "$RAMDISK_CPIO")
    echo "Legacy unpack completed using $COMP."
    exit 0
fi
echo "MagiskBoot is unavailable. Install the ARM64 MagiskBoot binary, or explicitly select the legacy AIK engine for a known-compatible legacy image." >&2
exit 4
