package M2;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface y0 extends Closeable {
    void C();

    void Q(OutputStream outputStream, int i4);

    void Z(ByteBuffer byteBuffer);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int d();

    boolean markSupported();

    y0 o(int i4);

    int readUnsignedByte();

    void reset();

    void skipBytes(int i4);

    void z(byte[] bArr, int i4, int i5);

    default void O() {
    }
}
