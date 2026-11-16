package g.a.a.a.c;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    private final String[] c;

    public c(a.f fVar, String... strArr) {
        super(fVar);
        String[] strArr2 = strArr != null ? (String[]) strArr.clone() : b.b;
        Arrays.sort(strArr2);
        this.c = strArr2;
    }

    private boolean e(Path path) {
        return Arrays.binarySearch(this.c, defpackage.c.a(path.getFileName(), null)) < 0;
    }

    public static c g() {
        return new c(a.b(), new String[0]);
    }

    @Override // g.a.a.a.c.b, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: b */
    public FileVisitResult postVisitDirectory(Path path, IOException iOException) throws IOException {
        if (d.d(path)) {
            Files.deleteIfExists(path);
        }
        return super.postVisitDirectory(path, iOException);
    }

    @Override // g.a.a.a.c.b, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: d */
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (e(path) && Files.exists(path, new LinkOption[0])) {
            Files.deleteIfExists(path);
        }
        c(path, basicFileAttributes);
        return FileVisitResult.CONTINUE;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        super.preVisitDirectory(path, basicFileAttributes);
        return e(path) ? FileVisitResult.CONTINUE : FileVisitResult.SKIP_SUBTREE;
    }
}
