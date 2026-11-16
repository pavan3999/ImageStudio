package g.a.a.a.c;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b extends e {
    static final String[] b = new String[0];
    private final a.f a;

    public b(a.f fVar) {
        this.a = (a.f) defpackage.b.a(fVar, "pathCounter");
    }

    public a.f a() {
        return this.a;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
        this.a.b().a();
        return FileVisitResult.CONTINUE;
    }

    protected void c(Path path, BasicFileAttributes basicFileAttributes) {
        this.a.a().a();
        this.a.c().c(basicFileAttributes.size());
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        if (Files.exists(path, new LinkOption[0])) {
            c(path, basicFileAttributes);
        }
        return FileVisitResult.CONTINUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return defpackage.a.a(this.a, ((b) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public String toString() {
        return this.a.toString();
    }
}
