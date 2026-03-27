package u7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u7.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2822o extends AbstractC2817j {
    @Override // u7.AbstractC2817j
    public void a(M source, M target) throws IOException {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(target, "target");
        if (source.B().renameTo(target.B())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // u7.AbstractC2817j
    public void d(M dir, boolean z7) throws IOException {
        AbstractC2304t.f(dir, "dir");
        if (dir.B().mkdir()) {
            return;
        }
        C2816i c2816iH = h(dir);
        if (c2816iH == null || !c2816iH.c()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (z7) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // u7.AbstractC2817j
    public void f(M path, boolean z7) throws IOException {
        AbstractC2304t.f(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File fileB = path.B();
        if (fileB.delete()) {
            return;
        }
        if (fileB.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (z7) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override // u7.AbstractC2817j
    public C2816i h(M path) {
        AbstractC2304t.f(path, "path");
        File fileB = path.B();
        boolean zIsFile = fileB.isFile();
        boolean zIsDirectory = fileB.isDirectory();
        long jLastModified = fileB.lastModified();
        long length = fileB.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || fileB.exists()) {
            return new C2816i(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // u7.AbstractC2817j
    public AbstractC2815h i(M file) {
        AbstractC2304t.f(file, "file");
        return new C2821n(false, new RandomAccessFile(file.B(), "r"));
    }

    @Override // u7.AbstractC2817j
    public AbstractC2815h k(M file, boolean z7, boolean z8) throws IOException {
        AbstractC2304t.f(file, "file");
        if (z7 && z8) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
        }
        if (z7) {
            m(file);
        }
        if (z8) {
            n(file);
        }
        return new C2821n(true, new RandomAccessFile(file.B(), "rw"));
    }

    @Override // u7.AbstractC2817j
    public V l(M file) {
        AbstractC2304t.f(file, "file");
        return H.e(file.B());
    }

    public final void m(M m8) throws IOException {
        if (g(m8)) {
            throw new IOException(m8 + " already exists.");
        }
    }

    public final void n(M m8) throws IOException {
        if (g(m8)) {
            return;
        }
        throw new IOException(m8 + " doesn't exist.");
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
