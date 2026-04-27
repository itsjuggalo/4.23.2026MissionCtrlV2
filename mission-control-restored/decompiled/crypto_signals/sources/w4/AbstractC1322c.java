package w4;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: w4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1322c implements Closeable {
    public final void d(int i) {
        if (m() < i) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean g() {
        return this instanceof C1377u1;
    }

    public abstract AbstractC1322c h(int i);

    public abstract void i(OutputStream outputStream, int i);

    public abstract void j(ByteBuffer byteBuffer);

    public abstract void k(byte[] bArr, int i, int i6);

    public abstract int l();

    public abstract int m();

    public void n() {
        throw new UnsupportedOperationException();
    }

    public abstract void o(int i);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void f() {
    }
}
