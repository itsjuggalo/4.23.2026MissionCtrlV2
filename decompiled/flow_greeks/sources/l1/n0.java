package l1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f15220a;

    public n0(FileOutputStream fileOutputStream) {
        kotlin.jvm.internal.t.f(fileOutputStream, "fileOutputStream");
        this.f15220a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f15220a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f15220a.write(i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b10) throws IOException {
        kotlin.jvm.internal.t.f(b10, "b");
        this.f15220a.write(b10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int i10, int i11) throws IOException {
        kotlin.jvm.internal.t.f(bytes, "bytes");
        this.f15220a.write(bytes, i10, i11);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
