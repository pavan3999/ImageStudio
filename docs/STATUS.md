# Image Studio 4.5 status

## Included in branch 4.5

- [x] Original Image Studio 4.4.2 APK archived at `original/Android+Image+Studio_4.4.2_APKPure.apk` (8,321,816 bytes).
- [x] Original APK source URL recorded in `original/original-app_url`.
- [x] Owner-supplied SHA-256 recorded in `original/SHA256SUMS.txt`.
- [x] GitHub Actions independently verified the archived APK against that SHA-256 (run #43831628172).
- [x] MagiskBoot-first unpack/repack shell wrappers.
- [x] Explicit legacy AIK selection path.
- [x] Dynamic loop-device ext4 mount/unmount scripts.
- [x] Java image format detection for Android boot, vendor_boot, sparse, ext4.
- [x] MainActivity integration source and menu resource in the source-change set.
- [x] GitHub Actions validation for APK integrity, shell syntax, Java detector tests, and patch presence.

## Remaining project work

- [ ] Obtain and inspect the complete decompiled project export, including manifest, resources, assets, and all Java sources.
- [ ] Reconcile the MainActivity patch against the exact decompiled source and resolve compile errors.
- [ ] Reconstruct Gradle settings, Android Gradle Plugin version, dependencies, SDK levels, and wrapper from the original app/build evidence rather than guessing.
- [ ] Add the verified ARM64 MagiskBoot executable from a pinned official release and record its provenance and checksum.
- [ ] Validate vendor_boot v3/v4 behavior with known-good fixtures and round-trip tests.
- [ ] Build, sign, install, and test an APK in a disposable test environment.
- [ ] Add a release workflow only after a reproducible debug build succeeds.

## Current build limitation

This repository is a source-change set, not yet a complete Android Studio/Gradle project. The current CI validates scripts and a pure-Java detector; it does not compile the Android application or produce an APK. Do not add placeholder Gradle files or claim a build until the original manifest, resources, dependency versions, and project configuration have been recovered.

## Device safety

Never flash an image produced by this branch until it has passed image inspection and a verified round-trip test for the exact device and image format. MTK preservation, vendor_boot repacking, and root ext4 mounting are not yet device-tested.
