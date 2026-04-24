package u5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class s extends n {
    @Override // u5.n
    public m b(v path) {
        kotlin.jvm.internal.j.e(path, "path");
        File fileE = path.e();
        boolean zIsFile = fileE.isFile();
        boolean zIsDirectory = fileE.isDirectory();
        long jLastModified = fileE.lastModified();
        long length = fileE.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || fileE.exists()) {
            return new m(zIsFile, zIsDirectory, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    public void c(v vVar, v target) throws IOException {
        kotlin.jvm.internal.j.e(target, "target");
        if (vVar.e().renameTo(target.e())) {
            return;
        }
        throw new IOException("failed to move " + vVar + " to " + target);
    }

    public final void d(v vVar) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File fileE = vVar.e();
        if (fileE.delete() || !fileE.exists()) {
            return;
        }
        throw new IOException("failed to delete " + vVar);
    }

    public final r e(v vVar) {
        return new r(false, new RandomAccessFile(vVar.e(), "r"));
    }

    public final E f(v file) {
        kotlin.jvm.internal.j.e(file, "file");
        File fileE = file.e();
        Logger logger = u.f10548a;
        kotlin.jvm.internal.j.e(fileE, "<this>");
        return new C1247d(1, new FileInputStream(fileE), G.f10504d);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
