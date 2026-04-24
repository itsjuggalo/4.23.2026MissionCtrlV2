package t5;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface y0 extends Closeable {
    void J(byte[] bArr, int i7, int i8);

    void Q();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int e();

    void f0(OutputStream outputStream, int i7);

    boolean markSupported();

    void p0(ByteBuffer byteBuffer);

    int readUnsignedByte();

    void reset();

    y0 s(int i7);

    void skipBytes(int i7);

    default void b0() {
    }
}
