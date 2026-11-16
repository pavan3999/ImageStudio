import com.redlee90.imagekitchenforandroid.engine.ImageFormatDetector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class ImageFormatDetectorTest {
    private static File fixture(byte[] bytes) throws Exception {
        File f = File.createTempFile("ais45-", ".img");
        try (FileOutputStream out = new FileOutputStream(f)) { out.write(bytes); }
        f.deleteOnExit();
        return f;
    }
    private static void check(ImageFormatDetector.Type expected, File f) throws Exception {
        ImageFormatDetector.Type actual = ImageFormatDetector.detect(f);
        if (actual != expected) throw new AssertionError("expected " + expected + " got " + actual);
    }
    public static void main(String[] args) throws Exception {
        check(ImageFormatDetector.Type.UNKNOWN, fixture(new byte[] {1, 2, 3}));
        check(ImageFormatDetector.Type.ANDROID_BOOT, fixture("ANDROID!".getBytes("US-ASCII")));
        check(ImageFormatDetector.Type.VENDOR_BOOT, fixture("VNDRBOOT".getBytes("US-ASCII")));
        check(ImageFormatDetector.Type.SPARSE, fixture(new byte[] {0x3a, (byte)0xff, 0x26, (byte)0xed}));
        File ext4 = File.createTempFile("ais45-ext4-", ".img");
        try (RandomAccessFile raf = new RandomAccessFile(ext4, "rw")) {
            raf.setLength(1082); raf.seek(1080); raf.write(0x53); raf.write(0xef);
        }
        check(ImageFormatDetector.Type.EXT4, ext4);
        ext4.delete();
        System.out.println("ImageFormatDetector: 5 tests passed");
    }
}
