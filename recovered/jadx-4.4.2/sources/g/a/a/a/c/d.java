package g.a.a.a.c;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static a.f a(Path path) {
        return Files.isDirectory(path, new LinkOption[0]) ? b(path) : c(path);
    }

    public static a.f b(Path path) throws IOException {
        c cVarG = c.g();
        e(cVarG, path);
        return cVarG.a();
    }

    public static a.f c(Path path) throws NotDirectoryException {
        if (Files.isDirectory(path, new LinkOption[0])) {
            throw new NotDirectoryException(path.toString());
        }
        a.f fVarB = a.b();
        long size = Files.exists(path, new LinkOption[0]) ? Files.size(path) : 0L;
        if (Files.deleteIfExists(path)) {
            fVarB.a().a();
            fVarB.c().c(size);
        }
        return fVarB;
    }

    public static boolean d(Path path) throws IOException {
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
        try {
            if (directoryStreamNewDirectoryStream.iterator().hasNext()) {
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
                return false;
            }
            if (directoryStreamNewDirectoryStream == null) {
                return true;
            }
            directoryStreamNewDirectoryStream.close();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static <T extends FileVisitor<? super Path>> T e(T t, Path path) throws IOException {
        Files.walkFileTree(path, t);
        return t;
    }
}
