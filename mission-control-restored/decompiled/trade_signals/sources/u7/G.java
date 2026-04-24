package u7;

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
import kotlin.jvm.internal.AbstractC2304t;
import u7.M;

/* JADX INFO: loaded from: classes2.dex */
public class G extends C2822o {
    @Override // u7.C2822o, u7.AbstractC2817j
    public void a(M source, M target) throws IOException {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(target, "target");
        try {
            Files.move(source.H(), target.H(), AbstractC2825s.a(StandardCopyOption.ATOMIC_MOVE), AbstractC2825s.a(StandardCopyOption.REPLACE_EXISTING));
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e8) {
            throw new FileNotFoundException(e8.getMessage());
        }
    }

    @Override // u7.C2822o, u7.AbstractC2817j
    public C2816i h(M path) {
        AbstractC2304t.f(path, "path");
        return o(path.H());
    }

    public final C2816i o(Path nioPath) {
        AbstractC2304t.f(nioPath, "nioPath");
        try {
            BasicFileAttributes attributes = Files.readAttributes(nioPath, (Class<BasicFileAttributes>) AbstractC2823p.a(), LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(nioPath) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            M mF = symbolicLink != null ? M.a.f(M.f23583b, symbolicLink, false, 1, null) : null;
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lP = fileTimeCreationTime != null ? p(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lP2 = fileTimeLastModifiedTime != null ? p(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new C2816i(zIsRegularFile, zIsDirectory, mF, lValueOf, lP, lP2, fileTimeLastAccessTime != null ? p(fileTimeLastAccessTime) : null, null, 128, null);
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

    @Override // u7.C2822o
    public String toString() {
        return "NioSystemFileSystem";
    }
}
