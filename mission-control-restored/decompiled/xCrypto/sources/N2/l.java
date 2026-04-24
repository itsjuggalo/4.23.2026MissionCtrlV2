package N2;

import M2.AbstractC0410b;
import M2.y0;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class l extends AbstractC0410b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O3.d f3078a;

    public l(O3.d dVar) {
        this.f3078a = dVar;
    }

    @Override // M2.y0
    public void Q(OutputStream outputStream, int i4) throws IOException {
        this.f3078a.t0(outputStream, i4);
    }

    @Override // M2.y0
    public void Z(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // M2.AbstractC0410b, M2.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.f3078a.f();
    }

    @Override // M2.y0
    public int d() {
        return (int) this.f3078a.i0();
    }

    @Override // M2.y0
    public y0 o(int i4) {
        O3.d dVar = new O3.d();
        dVar.c0(this.f3078a, i4);
        return new l(dVar);
    }

    @Override // M2.y0
    public int readUnsignedByte() {
        try {
            f();
            return this.f3078a.readByte() & 255;
        } catch (EOFException e4) {
            throw new IndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // M2.y0
    public void skipBytes(int i4) {
        try {
            this.f3078a.skip(i4);
        } catch (EOFException e4) {
            throw new IndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // M2.y0
    public void z(byte[] bArr, int i4, int i5) {
        while (i5 > 0) {
            int i6 = this.f3078a.read(bArr, i4, i5);
            if (i6 == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i5 + " bytes");
            }
            i5 -= i6;
            i4 += i6;
        }
    }

    public final void f() {
    }
}
