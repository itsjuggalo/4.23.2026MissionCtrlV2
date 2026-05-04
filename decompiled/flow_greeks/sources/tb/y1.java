package tb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f21863a = new c(new byte[0]);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends tb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f21867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21868d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // tb.b, tb.x1
        public void D() {
            this.f21868d = this.f21865a;
        }

        @Override // tb.x1
        public void P(OutputStream outputStream, int i10) throws IOException {
            b(i10);
            outputStream.write(this.f21867c, this.f21865a, i10);
            this.f21865a += i10;
        }

        @Override // tb.x1
        public void W(ByteBuffer byteBuffer) {
            p6.n.o(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            b(iRemaining);
            byteBuffer.put(this.f21867c, this.f21865a, iRemaining);
            this.f21865a += iRemaining;
        }

        @Override // tb.x1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c n(int i10) {
            b(i10);
            int i11 = this.f21865a;
            this.f21865a = i11 + i10;
            return new c(this.f21867c, i11, i10);
        }

        @Override // tb.x1
        public int d() {
            return this.f21866b - this.f21865a;
        }

        @Override // tb.b, tb.x1
        public boolean markSupported() {
            return true;
        }

        @Override // tb.x1
        public int readUnsignedByte() {
            b(1);
            byte[] bArr = this.f21867c;
            int i10 = this.f21865a;
            this.f21865a = i10 + 1;
            return bArr[i10] & 255;
        }

        @Override // tb.b, tb.x1
        public void reset() {
            int i10 = this.f21868d;
            if (i10 == -1) {
                throw new InvalidMarkException();
            }
            this.f21865a = i10;
        }

        @Override // tb.x1
        public void skipBytes(int i10) {
            b(i10);
            this.f21865a += i10;
        }

        @Override // tb.x1
        public void z(byte[] bArr, int i10, int i11) {
            System.arraycopy(this.f21867c, this.f21865a, bArr, i10, i11);
            this.f21865a += i11;
        }

        public c(byte[] bArr, int i10, int i11) {
            this.f21868d = -1;
            p6.n.e(i10 >= 0, "offset must be >= 0");
            p6.n.e(i11 >= 0, "length must be >= 0");
            int i12 = i11 + i10;
            p6.n.e(i12 <= bArr.length, "offset + length exceeds array boundary");
            this.f21867c = (byte[]) p6.n.o(bArr, "bytes");
            this.f21865a = i10;
            this.f21866b = i12;
        }
    }

    public static x1 a() {
        return f21863a;
    }

    public static x1 b(x1 x1Var) {
        return new a(x1Var);
    }

    public static InputStream c(x1 x1Var, boolean z10) {
        if (!z10) {
            x1Var = b(x1Var);
        }
        return new b(x1Var);
    }

    public static byte[] d(x1 x1Var) {
        p6.n.o(x1Var, "buffer");
        int iD = x1Var.d();
        byte[] bArr = new byte[iD];
        x1Var.z(bArr, 0, iD);
        return bArr;
    }

    public static String e(x1 x1Var, Charset charset) {
        p6.n.o(charset, "charset");
        return new String(d(x1Var), charset);
    }

    public static x1 f(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends InputStream implements rb.q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x1 f21864a;

        public b(x1 x1Var) {
            this.f21864a = (x1) p6.n.o(x1Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f21864a.d();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f21864a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f21864a.D();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f21864a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f21864a.d() == 0) {
                return -1;
            }
            return this.f21864a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f21864a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            int iMin = (int) Math.min(this.f21864a.d(), j10);
            this.f21864a.skipBytes(iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            if (this.f21864a.d() == 0) {
                return -1;
            }
            int iMin = Math.min(this.f21864a.d(), i11);
            this.f21864a.z(bArr, i10, iMin);
            return iMin;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends o0 {
        public a(x1 x1Var) {
            super(x1Var);
        }

        @Override // tb.x1, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
