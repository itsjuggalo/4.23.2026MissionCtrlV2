package t5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f24226a = new c(new byte[0]);

    public static class c extends AbstractC2665b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f24230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24231d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // t5.y0
        public void J(byte[] bArr, int i7, int i8) {
            System.arraycopy(this.f24230c, this.f24228a, bArr, i7, i8);
            this.f24228a += i8;
        }

        @Override // t5.AbstractC2665b, t5.y0
        public void Q() {
            this.f24231d = this.f24228a;
        }

        @Override // t5.y0
        public int e() {
            return this.f24229b - this.f24228a;
        }

        @Override // t5.y0
        public void f0(OutputStream outputStream, int i7) throws IOException {
            h(i7);
            outputStream.write(this.f24230c, this.f24228a, i7);
            this.f24228a += i7;
        }

        @Override // t5.y0
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public c s(int i7) {
            h(i7);
            int i8 = this.f24228a;
            this.f24228a = i8 + i7;
            return new c(this.f24230c, i8, i7);
        }

        @Override // t5.AbstractC2665b, t5.y0
        public boolean markSupported() {
            return true;
        }

        @Override // t5.y0
        public void p0(ByteBuffer byteBuffer) {
            H2.m.o(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            h(iRemaining);
            byteBuffer.put(this.f24230c, this.f24228a, iRemaining);
            this.f24228a += iRemaining;
        }

        @Override // t5.y0
        public int readUnsignedByte() {
            h(1);
            byte[] bArr = this.f24230c;
            int i7 = this.f24228a;
            this.f24228a = i7 + 1;
            return bArr[i7] & 255;
        }

        @Override // t5.AbstractC2665b, t5.y0
        public void reset() {
            int i7 = this.f24231d;
            if (i7 == -1) {
                throw new InvalidMarkException();
            }
            this.f24228a = i7;
        }

        @Override // t5.y0
        public void skipBytes(int i7) {
            h(i7);
            this.f24228a += i7;
        }

        public c(byte[] bArr, int i7, int i8) {
            this.f24231d = -1;
            H2.m.e(i7 >= 0, "offset must be >= 0");
            H2.m.e(i8 >= 0, "length must be >= 0");
            int i9 = i8 + i7;
            H2.m.e(i9 <= bArr.length, "offset + length exceeds array boundary");
            this.f24230c = (byte[]) H2.m.o(bArr, "bytes");
            this.f24228a = i7;
            this.f24229b = i9;
        }
    }

    public static y0 a() {
        return f24226a;
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
        H2.m.o(y0Var, "buffer");
        int iE = y0Var.e();
        byte[] bArr = new byte[iE];
        y0Var.J(bArr, 0, iE);
        return bArr;
    }

    public static String e(y0 y0Var, Charset charset) {
        H2.m.o(charset, "charset");
        return new String(d(y0Var), charset);
    }

    public static y0 f(byte[] bArr, int i7, int i8) {
        return new c(bArr, i7, i8);
    }

    public static final class b extends InputStream implements r5.Q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y0 f24227a;

        public b(y0 y0Var) {
            this.f24227a = (y0) H2.m.o(y0Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f24227a.e();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f24227a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i7) {
            this.f24227a.Q();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f24227a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f24227a.e() == 0) {
                return -1;
            }
            return this.f24227a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f24227a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j7) {
            int iMin = (int) Math.min(this.f24227a.e(), j7);
            this.f24227a.skipBytes(iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) {
            if (this.f24227a.e() == 0) {
                return -1;
            }
            int iMin = Math.min(this.f24227a.e(), i8);
            this.f24227a.J(bArr, i7, iMin);
            return iMin;
        }
    }

    public class a extends O {
        public a(y0 y0Var) {
            super(y0Var);
        }

        @Override // t5.y0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
