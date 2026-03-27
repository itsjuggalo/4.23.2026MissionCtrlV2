package w6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;

/* JADX INFO: renamed from: w6.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2805s extends AbstractC2798k {
    @Override // w6.AbstractC2798k
    public void a(Q source, Q target) throws IOException {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(target, "target");
        if (source.q().renameTo(target.q())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // w6.AbstractC2798k
    public void d(Q dir, boolean z7) throws IOException {
        kotlin.jvm.internal.r.f(dir, "dir");
        if (dir.q().mkdir()) {
            return;
        }
        C2797j c2797jH = h(dir);
        if (c2797jH == null || !c2797jH.c()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (z7) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // w6.AbstractC2798k
    public void f(Q path, boolean z7) throws IOException {
        kotlin.jvm.internal.r.f(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File fileQ = path.q();
        if (fileQ.delete()) {
            return;
        }
        if (fileQ.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (z7) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override // w6.AbstractC2798k
    public C2797j h(Q path) {
        kotlin.jvm.internal.r.f(path, "path");
        File fileQ = path.q();
        boolean zIsFile = fileQ.isFile();
        boolean zIsDirectory = fileQ.isDirectory();
        long jLastModified = fileQ.lastModified();
        long length = fileQ.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || fileQ.exists()) {
            return new C2797j(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // w6.AbstractC2798k
    public AbstractC2796i i(Q file) {
        kotlin.jvm.internal.r.f(file, "file");
        return new r(false, new RandomAccessFile(file.q(), "r"));
    }

    @Override // w6.AbstractC2798k
    public AbstractC2796i k(Q file, boolean z7, boolean z8) throws IOException {
        kotlin.jvm.internal.r.f(file, "file");
        if (z7 && z8) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z7) {
            m(file);
        }
        if (z8) {
            n(file);
        }
        return new r(true, new RandomAccessFile(file.q(), "rw"));
    }

    @Override // w6.AbstractC2798k
    public Z l(Q file) {
        kotlin.jvm.internal.r.f(file, "file");
        return L.k(file.q());
    }

    public final void m(Q q7) throws IOException {
        if (g(q7)) {
            throw new IOException(q7 + " already exists.");
        }
    }

    public final void n(Q q7) throws IOException {
        if (g(q7)) {
            return;
        }
        throw new IOException(q7 + " doesn't exist.");
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
