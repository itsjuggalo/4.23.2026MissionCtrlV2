package b0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class N extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f12589a;

    public N(FileOutputStream fileOutputStream) {
        AbstractC2304t.f(fileOutputStream, "fileOutputStream");
        this.f12589a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f12589a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        this.f12589a.write(i8);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b8) throws IOException {
        AbstractC2304t.f(b8, "b");
        this.f12589a.write(b8);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int i8, int i9) throws IOException {
        AbstractC2304t.f(bytes, "bytes");
        this.f12589a.write(bytes, i8, i9);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
