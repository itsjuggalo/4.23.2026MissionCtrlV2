package tb;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface x1 extends Closeable {
    void D();

    void P(OutputStream outputStream, int i10);

    void W(ByteBuffer byteBuffer);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int d();

    boolean markSupported();

    x1 n(int i10);

    int readUnsignedByte();

    void reset();

    void skipBytes(int i10);

    void z(byte[] bArr, int i10, int i11);

    default void M() {
    }
}
