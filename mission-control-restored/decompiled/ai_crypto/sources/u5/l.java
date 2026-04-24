package u5;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import t5.AbstractC2665b;
import t5.y0;
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public class l extends AbstractC2665b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2792e f24670a;

    public l(C2792e c2792e) {
        this.f24670a = c2792e;
    }

    @Override // t5.y0
    public void J(byte[] bArr, int i7, int i8) {
        while (i8 > 0) {
            int i9 = this.f24670a.read(bArr, i7, i8);
            if (i9 == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i8 + " bytes");
            }
            i8 -= i9;
            i7 += i9;
        }
    }

    @Override // t5.AbstractC2665b, t5.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.f24670a.i();
    }

    @Override // t5.y0
    public int e() {
        return (int) this.f24670a.E0();
    }

    @Override // t5.y0
    public void f0(OutputStream outputStream, int i7) throws IOException {
        this.f24670a.S0(outputStream, i7);
    }

    @Override // t5.y0
    public void p0(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // t5.y0
    public int readUnsignedByte() {
        try {
            i();
            return this.f24670a.readByte() & 255;
        } catch (EOFException e7) {
            throw new IndexOutOfBoundsException(e7.getMessage());
        }
    }

    @Override // t5.y0
    public y0 s(int i7) {
        C2792e c2792e = new C2792e();
        c2792e.L(this.f24670a, i7);
        return new l(c2792e);
    }

    @Override // t5.y0
    public void skipBytes(int i7) {
        try {
            this.f24670a.skip(i7);
        } catch (EOFException e7) {
            throw new IndexOutOfBoundsException(e7.getMessage());
        }
    }

    public final void i() {
    }
}
