package S;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class I extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f3599a;

    public I(FileOutputStream fileOutputStream) {
        kotlin.jvm.internal.r.f(fileOutputStream, "fileOutputStream");
        this.f3599a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f3599a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        this.f3599a.write(i4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4) throws IOException {
        kotlin.jvm.internal.r.f(b4, "b");
        this.f3599a.write(b4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int i4, int i5) throws IOException {
        kotlin.jvm.internal.r.f(bytes, "bytes");
        this.f3599a.write(bytes, i4, i5);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
