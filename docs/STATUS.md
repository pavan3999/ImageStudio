# Image Studio 4.5 status

## Included in branch 4.5

- [x] Branch created.
- [x] Original Image Studio 4.4.2 APK archived at `original/Android+Image+Studio_4.4.2_APKPure.apk` (8,321,816 bytes).
- [x] Original APK source URL recorded in `original/original-app_url`.
- [x] MagiskBoot-first unpack/repack shell wrappers.
- [x] Explicit legacy AIK selection path.
- [x] Dynamic loop-device ext4 mount/unmount scripts.
- [x] Java image format detection for Android boot, vendor_boot, sparse, ext4.
- [x] MainActivity integration source and menu option in the source-change bundle.
- [x] GitHub Actions source validation workflow.
- [x] Detector tests.

## Still required

- [ ] Add the complete original project/build files (Gradle wrapper, build scripts, manifest, resources, dependencies).
- [ ] Review/apply the MainActivity patch against the exact matching decompiled source.
- [ ] Add the official ARM64 MagiskBoot executable from a pinned official release and verify its checksum.
- [ ] Implement and test complete vendor_boot v3/v4 unpack/repack support.
- [ ] Run a complete Android build and APK signing workflow.
- [ ] Test on disposable images and a test device before any real-device flashing.
- [ ] Compute and publish the original APK SHA-256 checksum from the binary.

## Safety notes

Never flash an image produced by this branch until it has passed image inspection and a verified round-trip test for the exact device/image format. This repository does not claim that MTK or vendor_boot repacking is device-tested.
