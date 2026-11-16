package g.a.a.a;

import g.a.a.a.c.d;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final BigInteger a;
    public static final BigInteger b;
    public static final BigInteger c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f997f;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        a = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        b = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = a.multiply(bigIntegerMultiply);
        c = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = a.multiply(bigIntegerMultiply2);
        f995d = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = a.multiply(bigIntegerMultiply3);
        f996e = bigIntegerMultiply4;
        a.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        f997f = bigIntegerMultiply5;
        a.multiply(bigIntegerMultiply5);
    }

    private static void a(File file, File file2, long j, long j2) throws IOException {
        if (j == j2) {
            return;
        }
        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + j + " Actual: " + j2);
    }

    private static void b(File file, File file2) throws FileNotFoundException {
        defpackage.b.a(file, "source");
        defpackage.b.a(file2, "target");
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static void c(File file) throws IOException {
        IOException e2 = null;
        for (File file2 : s(file)) {
            try {
                o(file2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public static void d(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        b(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        ArrayList arrayList = null;
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                arrayList = new ArrayList(fileArrListFiles.length);
                for (File file3 : fileArrListFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
            }
        }
        m(file, file2, fileFilter, z, arrayList);
    }

    public static void e(File file, File file2, boolean z) throws IOException {
        d(file, file2, null, z);
    }

    public static void f(File file, File file2) throws IOException {
        defpackage.b.a(file, "sourceDir");
        if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + file + "' is not a directory");
        }
        defpackage.b.a(file2, "destinationDir");
        if (!file2.exists() || file2.isDirectory()) {
            e(file, new File(file2, file.getName()), true);
            return;
        }
        throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static void g(File file, File file2) throws IOException {
        h(file, file2, true);
    }

    public static void h(File file, File file2, boolean z) throws IOException {
        b(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            n(file, file2, z);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    public static void i(File file, File file2) throws IOException {
        j(file, file2, true);
    }

    public static void j(File file, File file2, boolean z) throws IOException {
        defpackage.b.a(file2, "destinationDir");
        if (!file2.exists() || file2.isDirectory()) {
            h(file, new File(file2, file.getName()), z);
            return;
        }
        throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static void k(File file) throws IOException {
        if (file.exists()) {
            if (!p(file)) {
                c(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean l(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                c(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    private static void m(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws IOException {
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : fileArrListFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    m(file3, file4, fileFilter, z, list);
                } else {
                    n(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    private static void n(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        Path path = file.toPath();
        Path path2 = file2.toPath();
        long jLastModified = z ? file.lastModified() : file2.lastModified();
        Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
        a(file, file2, Files.size(path), Files.size(path2));
        a(file, file2, file.length(), file2.length());
        file2.setLastModified(jLastModified);
    }

    public static void o(File file) throws IOException {
        try {
            g.a.a.a.c.a.f fVarA = d.a(file.toPath());
            if (fVarA.a().b() >= 1 || fVarA.b().b() >= 1) {
                return;
            }
            throw new FileNotFoundException("File does not exist: " + file);
        } catch (IOException e2) {
            throw new IOException("Unable to delete file: " + file, e2);
        }
    }

    public static boolean p(File file) {
        defpackage.b.a(file, "file");
        return Files.isSymbolicLink(file.toPath());
    }

    public static void q(File file, File file2) throws IOException {
        r(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        }
        if (file2.exists()) {
            throw new a("Destination '" + file2 + "' already exists");
        }
        if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        }
        if (file.renameTo(file2)) {
            return;
        }
        g(file, file2);
        if (file.delete()) {
            return;
        }
        l(file2);
        throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    private static void r(File file, File file2) throws FileNotFoundException {
        defpackage.b.a(file, "source");
        defpackage.b.a(file2, "destination");
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    private static File[] s(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            return fileArrListFiles;
        }
        throw new IOException("Failed to list contents of " + file);
    }
}
