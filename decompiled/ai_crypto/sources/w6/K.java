package w6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import w6.Q;

/* JADX INFO: loaded from: classes2.dex */
public class K extends C2805s {
    @Override // w6.C2805s, w6.AbstractC2798k
    public void a(Q source, Q target) throws IOException {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(target, "target");
        try {
            Files.move(source.r(), target.r(), AbstractC2809w.a(StandardCopyOption.ATOMIC_MOVE), AbstractC2809w.a(StandardCopyOption.REPLACE_EXISTING));
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e7) {
            throw new FileNotFoundException(e7.getMessage());
        }
    }

    @Override // w6.C2805s, w6.AbstractC2798k
    public C2797j h(Q path) {
        kotlin.jvm.internal.r.f(path, "path");
        return o(path.r());
    }

    public final C2797j o(Path nioPath) {
        kotlin.jvm.internal.r.f(nioPath, "nioPath");
        try {
            BasicFileAttributes attributes = Files.readAttributes(nioPath, (Class<BasicFileAttributes>) AbstractC2806t.a(), LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(nioPath) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            Q qF = symbolicLink != null ? Q.a.f(Q.f25040b, symbolicLink, false, 1, null) : null;
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lP = fileTimeCreationTime != null ? p(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lP2 = fileTimeLastModifiedTime != null ? p(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new C2797j(zIsRegularFile, zIsDirectory, qF, lValueOf, lP, lP2, fileTimeLastAccessTime != null ? p(fileTimeLastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    public final Long p(FileTime fileTime) {
        Long lValueOf = Long.valueOf(fileTime.toMillis());
        if (lValueOf.longValue() != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // w6.C2805s
    public String toString() {
        return "NioSystemFileSystem";
    }
}
