# Add the ARM64 MagiskBoot executable

The repository intentionally does not bundle an unverified executable.

1. Download the pinned official Magisk release APK from:
   https://github.com/topjohnwu/Magisk/releases/tag/v31.1
2. Extract the ARM64 executable:
   ```sh
   unzip -p Magisk-v31.1.apk lib/arm64-v8a/libmagiskboot.so > app/src/main/assets/engine/magiskboot
   chmod 755 app/src/main/assets/engine/magiskboot
   file app/src/main/assets/engine/magiskboot
   sha256sum Magisk-v31.1.apk app/src/main/assets/engine/magiskboot
   ```
3. Confirm it is an ELF 64-bit AArch64 executable and record the SHA-256 values in the build notes.

Do not download an executable from an unofficial mirror at runtime. Verify the upstream release and keep provenance information with the build inputs.
