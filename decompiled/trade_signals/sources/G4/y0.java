package G4;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface y0 extends Closeable {
    void J(byte[] bArr, int i8, int i9);

    void P();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int d();

    void e0(OutputStream outputStream, int i8);

    boolean markSupported();

    void p0(ByteBuffer byteBuffer);

    int readUnsignedByte();

    void reset();

    void skipBytes(int i8);

    y0 t(int i8);

    default void a0() {
    }
}
