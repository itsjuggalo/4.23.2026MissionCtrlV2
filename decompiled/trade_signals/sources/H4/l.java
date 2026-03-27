package H4;

import G4.AbstractC0518b;
import G4.y0;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import u7.C2811d;

/* JADX INFO: loaded from: classes2.dex */
public class l extends AbstractC0518b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2811d f3935a;

    public l(C2811d c2811d) {
        this.f3935a = c2811d;
    }

    @Override // G4.y0
    public void J(byte[] bArr, int i8, int i9) {
        while (i9 > 0) {
            int i10 = this.f3935a.read(bArr, i8, i9);
            if (i10 == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i9 + " bytes");
            }
            i9 -= i10;
            i8 += i10;
        }
    }

    @Override // G4.AbstractC0518b, G4.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.f3935a.e();
    }

    @Override // G4.y0
    public int d() {
        return (int) this.f3935a.s0();
    }

    @Override // G4.y0
    public void e0(OutputStream outputStream, int i8) throws IOException {
        this.f3935a.G0(outputStream, i8);
    }

    @Override // G4.y0
    public void p0(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // G4.y0
    public int readUnsignedByte() {
        try {
            c();
            return this.f3935a.readByte() & 255;
        } catch (EOFException e8) {
            throw new IndexOutOfBoundsException(e8.getMessage());
        }
    }

    @Override // G4.y0
    public void skipBytes(int i8) {
        try {
            this.f3935a.skip(i8);
        } catch (EOFException e8) {
            throw new IndexOutOfBoundsException(e8.getMessage());
        }
    }

    @Override // G4.y0
    public y0 t(int i8) {
        C2811d c2811d = new C2811d();
        c2811d.H(this.f3935a, i8);
        return new l(c2811d);
    }

    public final void c() {
    }
}
