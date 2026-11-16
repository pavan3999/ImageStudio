#!/system/bin/sh
# Args: BIN_DIR WORK_DIR IMAGE
set -eu
BIN_DIR=${1:?missing binary directory}
WORK_DIR=${2:?missing work directory}
IMAGE=${3:?missing ext4 image}
STATE="$WORK_DIR/.image-studio-loop-device"
[ "$(id -u)" = 0 ] || { echo "Root privileges are required for ext4 mounting." >&2; exit 10; }
[ -f "$IMAGE" ] || { echo "Image not found." >&2; exit 2; }
[ ! -e "$STATE" ] || { echo "A loop device is already recorded for this workspace." >&2; exit 11; }
mkdir -p "$WORK_DIR/mounted"
BB="$BIN_DIR/busybox"
LOOP=""
if [ -x "$BB" ]; then LOOP=$("$BB" losetup -f --show "$IMAGE" 2>/dev/null || true); fi
if [ -z "$LOOP" ] && command -v losetup >/dev/null 2>&1; then LOOP=$(losetup -f --show "$IMAGE" 2>/dev/null || true); fi
[ -n "$LOOP" ] || { echo "Unable to allocate a free loop device." >&2; exit 12; }
printf '%s\n' "$LOOP" > "$STATE"
if ! mount -t ext4 -o rw,nosuid,nodev,noexec "$LOOP" "$WORK_DIR/mounted"; then
    umount "$WORK_DIR/mounted" 2>/dev/null || true
    if [ -x "$BB" ]; then "$BB" losetup -d "$LOOP" 2>/dev/null || true; else losetup -d "$LOOP" 2>/dev/null || true; fi
    rm -f "$STATE"
    echo "ext4 mount failed; loop device released." >&2
    exit 13
fi
echo "Mounted $IMAGE on $LOOP"
