# ImageStudio

Version-specific work is maintained on branch [`4.5`](https://github.com/pavan3999/ImageStudio/tree/4.5).

## Image Studio 4.5 source changes

This branch contains a source-change set derived from the decompiled Image Studio 4.4.2 APK. It is **not yet a complete Android Studio/Gradle project** and does not currently produce an installable APK.

### Current contents

- Engine scripts for boot-image unpack/repack and root ext4 mount/unmount.
- Java image-format detector and engine installer.
- Updated decompiled `MainActivity.java` and menu resource in the source-change bundle.
- A unified MainActivity patch for review/application.
- Detector fixture tests.
- MagiskBoot setup notes.
- GitHub Actions source validation workflow.

### Boot-image strategy

- MagiskBoot is preferred for Android boot images and MTK header preservation.
- Legacy AIK is an explicit fallback only when MagiskBoot is absent and the user selects it.
- A MagiskBoot parse failure does not trigger a silent AIK fallback.
- Vendor boot ramdisk fragments remain separate; they must not be flattened into one generic ramdisk.

### Validation

The GitHub Actions workflow checks shell syntax and compiles/runs the pure-Java image format detector tests. It is not an APK build workflow.

### Not included yet

- Original Image Studio 4.4.2 APK (awaiting the original APK file being re-uploaded).
- Official ARM64 MagiskBoot executable (must be extracted from a pinned official Magisk release and verified).
- Complete original Gradle project/build files and resources.
- Verified Android APK build, MTK boot-image round-trip, vendor_boot round-trip, or device mount test.

See [`docs/STATUS.md`](docs/STATUS.md), [`docs/MAGISKBOOT-SETUP.md`](docs/MAGISKBOOT-SETUP.md), and [`patches/MainActivity-4.5.patch`](patches/MainActivity-4.5.patch).
