package ub;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import tb.x1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l extends tb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hh.d f22889a;

    public l(hh.d dVar) {
        this.f22889a = dVar;
    }

    @Override // tb.x1
    public void P(OutputStream outputStream, int i10) throws IOException {
        this.f22889a.q0(outputStream, i10);
    }

    @Override // tb.x1
    public void W(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // tb.b, tb.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.f22889a.c();
    }

    @Override // tb.x1
    public int d() {
        return (int) this.f22889a.size();
    }

    @Override // tb.x1
    public x1 n(int i10) {
        hh.d dVar = new hh.d();
        dVar.L(this.f22889a, i10);
        return new l(dVar);
    }

    @Override // tb.x1
    public int readUnsignedByte() {
        try {
            c();
            return this.f22889a.readByte() & 255;
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }

    @Override // tb.x1
    public void skipBytes(int i10) {
        try {
            this.f22889a.skip(i10);
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }

    @Override // tb.x1
    public void z(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            int i12 = this.f22889a.read(bArr, i10, i11);
            if (i12 == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i11 + " bytes");
            }
            i11 -= i12;
            i10 += i12;
        }
    }

    public final void c() {
    }
}
