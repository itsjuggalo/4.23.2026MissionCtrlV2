package G4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f3251a = new c(new byte[0]);

    public static final class b extends InputStream implements F4.O {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y0 f3252a;

        public b(y0 y0Var) {
            this.f3252a = (y0) AbstractC2848n.o(y0Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f3252a.d();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f3252a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i8) {
            this.f3252a.P();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f3252a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f3252a.d() == 0) {
                return -1;
            }
            return this.f3252a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f3252a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j8) {
            int iMin = (int) Math.min(this.f3252a.d(), j8);
            this.f3252a.skipBytes(iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) {
            if (this.f3252a.d() == 0) {
                return -1;
            }
            int iMin = Math.min(this.f3252a.d(), i9);
            this.f3252a.J(bArr, i8, iMin);
            return iMin;
        }
    }

    public static class c extends AbstractC0518b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f3255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3256d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // G4.y0
        public void J(byte[] bArr, int i8, int i9) {
            System.arraycopy(this.f3255c, this.f3253a, bArr, i8, i9);
            this.f3253a += i9;
        }

        @Override // G4.AbstractC0518b, G4.y0
        public void P() {
            this.f3256d = this.f3253a;
        }

        @Override // G4.y0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c t(int i8) {
            a(i8);
            int i9 = this.f3253a;
            this.f3253a = i9 + i8;
            return new c(this.f3255c, i9, i8);
        }

        @Override // G4.y0
        public int d() {
            return this.f3254b - this.f3253a;
        }

        @Override // G4.y0
        public void e0(OutputStream outputStream, int i8) throws IOException {
            a(i8);
            outputStream.write(this.f3255c, this.f3253a, i8);
            this.f3253a += i8;
        }

        @Override // G4.AbstractC0518b, G4.y0
        public boolean markSupported() {
            return true;
        }

        @Override // G4.y0
        public void p0(ByteBuffer byteBuffer) {
            AbstractC2848n.o(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            a(iRemaining);
            byteBuffer.put(this.f3255c, this.f3253a, iRemaining);
            this.f3253a += iRemaining;
        }

        @Override // G4.y0
        public int readUnsignedByte() {
            a(1);
            byte[] bArr = this.f3255c;
            int i8 = this.f3253a;
            this.f3253a = i8 + 1;
            return bArr[i8] & 255;
        }

        @Override // G4.AbstractC0518b, G4.y0
        public void reset() {
            int i8 = this.f3256d;
            if (i8 == -1) {
                throw new InvalidMarkException();
            }
            this.f3253a = i8;
        }

        @Override // G4.y0
        public void skipBytes(int i8) {
            a(i8);
            this.f3253a += i8;
        }

        public c(byte[] bArr, int i8, int i9) {
            this.f3256d = -1;
            AbstractC2848n.e(i8 >= 0, "offset must be >= 0");
            AbstractC2848n.e(i9 >= 0, "length must be >= 0");
            int i10 = i9 + i8;
            AbstractC2848n.e(i10 <= bArr.length, "offset + length exceeds array boundary");
            this.f3255c = (byte[]) AbstractC2848n.o(bArr, "bytes");
            this.f3253a = i8;
            this.f3254b = i10;
        }
    }

    public static y0 a() {
        return f3251a;
    }

    public static y0 b(y0 y0Var) {
        return new a(y0Var);
    }

    public static InputStream c(y0 y0Var, boolean z7) {
        if (!z7) {
            y0Var = b(y0Var);
        }
        return new b(y0Var);
    }

    public static byte[] d(y0 y0Var) {
        AbstractC2848n.o(y0Var, "buffer");
        int iD = y0Var.d();
        byte[] bArr = new byte[iD];
        y0Var.J(bArr, 0, iD);
        return bArr;
    }

    public static String e(y0 y0Var, Charset charset) {
        AbstractC2848n.o(charset, "charset");
        return new String(d(y0Var), charset);
    }

    public static y0 f(byte[] bArr, int i8, int i9) {
        return new c(bArr, i8, i9);
    }

    public class a extends O {
        public a(y0 y0Var) {
            super(y0Var);
        }

        @Override // G4.y0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
