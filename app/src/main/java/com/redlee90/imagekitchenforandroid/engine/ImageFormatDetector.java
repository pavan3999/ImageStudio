package com.redlee90.imagekitchenforandroid.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/** Bounds-checked image signature detection. This class deliberately does not
 * guess that every image from a MediaTek device has a unique file signature.
 * MediaTek boot-header extensions are preserved by the selected boot engine. */
public final class ImageFormatDetector {
    private static final byte[] ANDROID = new byte[] {'A','N','D','R','O','I','D','!'};
    private static final byte[] VENDOR_BOOT = new byte[] {'V','N','D','R','B','O','O','T'};
    private static final byte[] SPARSE = new byte[] {0x3a, (byte) 0xff, 0x26, (byte) 0xed};

    public enum Type { ANDROID_BOOT, VENDOR_BOOT, SPARSE, EXT4, UNKNOWN }

    private ImageFormatDetector() { }

    public static Type detect(File file) throws IOException {
        if (file == null || !file.isFile() || !file.canRead()) return Type.UNKNOWN;
        long length = file.length();
        if (length < 4) return Type.UNKNOWN;
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] first = new byte[8];
            int count = readFully(in, first, 0, first.length);
            if (count >= ANDROID.length && matches(first, ANDROID)) return Type.ANDROID_BOOT;
            if (count >= VENDOR_BOOT.length && matches(first, VENDOR_BOOT)) return Type.VENDOR_BOOT;
            if (count >= SPARSE.length && matches(first, SPARSE)) return Type.SPARSE;
        }
        // ext4 superblock magic is at byte offset 1024 + 56 (little endian).
        if (length >= 1082) {
            try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                raf.seek(1080);
                int lo = raf.read();
                int hi = raf.read();
                if (lo == 0x53 && hi == 0xef) return Type.EXT4;
            }
        }
        return Type.UNKNOWN;
    }

    private static int readFully(FileInputStream in, byte[] out, int off, int len) throws IOException {
        int total = 0;
        while (total < len) {
            int n = in.read(out, off + total, len - total);
            if (n < 0) break;
            if (n == 0) continue;
            total += n;
        }
        return total;
    }

    private static boolean matches(byte[] actual, byte[] expected) {
        if (actual.length < expected.length) return false;
        for (int i = 0; i < expected.length; i++) if (actual[i] != expected[i]) return false;
        return true;
    }
}
