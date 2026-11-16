#!/system/bin/sh
# Args: BIN_DIR WORK_DIR
set -eu
BIN_DIR=${1:?missing binary directory}
WORK_DIR=${2:?missing work directory}
STATE="$WORK_DIR/.image-studio-loop-device"
[ "$(id -u)" = 0 ] || { echo "Root privileges are required." >&2; exit 10; }
[ -f "$STATE" ] || { echo "No loop device is recorded for this workspace." >&2; exit 0; }
LOOP=$(cat "$STATE")
case "$LOOP" in /dev/block/loop[0-9]*|/dev/loop[0-9]*) ;; *) echo "Invalid recorded loop device." >&2; exit 14 ;; esac
umount "$WORK_DIR/mounted" 2>/dev/null || umount "$LOOP" 2>/dev/null || true
if [ -x "$BIN_DIR/busybox" ]; then "$BIN_DIR/busybox" losetup -d "$LOOP"; else losetup -d "$LOOP"; fi
rm -f "$STATE"
echo "Unmounted and detached $LOOP"
