package M2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f2675a = new c(new byte[0]);

    public static class c extends AbstractC0410b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f2679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2680d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // M2.AbstractC0410b, M2.y0
        public void C() {
            this.f2680d = this.f2677a;
        }

        @Override // M2.y0
        public void Q(OutputStream outputStream, int i4) throws IOException {
            e(i4);
            outputStream.write(this.f2679c, this.f2677a, i4);
            this.f2677a += i4;
        }

        @Override // M2.y0
        public void Z(ByteBuffer byteBuffer) {
            Z1.m.o(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            e(iRemaining);
            byteBuffer.put(this.f2679c, this.f2677a, iRemaining);
            this.f2677a += iRemaining;
        }

        @Override // M2.y0
        public int d() {
            return this.f2678b - this.f2677a;
        }

        @Override // M2.y0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public c o(int i4) {
            e(i4);
            int i5 = this.f2677a;
            this.f2677a = i5 + i4;
            return new c(this.f2679c, i5, i4);
        }

        @Override // M2.AbstractC0410b, M2.y0
        public boolean markSupported() {
            return true;
        }

        @Override // M2.y0
        public int readUnsignedByte() {
            e(1);
            byte[] bArr = this.f2679c;
            int i4 = this.f2677a;
            this.f2677a = i4 + 1;
            return bArr[i4] & 255;
        }

        @Override // M2.AbstractC0410b, M2.y0
        public void reset() {
            int i4 = this.f2680d;
            if (i4 == -1) {
                throw new InvalidMarkException();
            }
            this.f2677a = i4;
        }

        @Override // M2.y0
        public void skipBytes(int i4) {
            e(i4);
            this.f2677a += i4;
        }

        @Override // M2.y0
        public void z(byte[] bArr, int i4, int i5) {
            System.arraycopy(this.f2679c, this.f2677a, bArr, i4, i5);
            this.f2677a += i5;
        }

        public c(byte[] bArr, int i4, int i5) {
            this.f2680d = -1;
            Z1.m.e(i4 >= 0, "offset must be >= 0");
            Z1.m.e(i5 >= 0, "length must be >= 0");
            int i6 = i5 + i4;
            Z1.m.e(i6 <= bArr.length, "offset + length exceeds array boundary");
            this.f2679c = (byte[]) Z1.m.o(bArr, "bytes");
            this.f2677a = i4;
            this.f2678b = i6;
        }
    }

    public static y0 a() {
        return f2675a;
    }

    public static y0 b(y0 y0Var) {
        return new a(y0Var);
    }

    public static InputStream c(y0 y0Var, boolean z4) {
        if (!z4) {
            y0Var = b(y0Var);
        }
        return new b(y0Var);
    }

    public static byte[] d(y0 y0Var) {
        Z1.m.o(y0Var, "buffer");
        int iD = y0Var.d();
        byte[] bArr = new byte[iD];
        y0Var.z(bArr, 0, iD);
        return bArr;
    }

    public static String e(y0 y0Var, Charset charset) {
        Z1.m.o(charset, "charset");
        return new String(d(y0Var), charset);
    }

    public static y0 f(byte[] bArr, int i4, int i5) {
        return new c(bArr, i4, i5);
    }

    public static final class b extends InputStream implements K2.Q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y0 f2676a;

        public b(y0 y0Var) {
            this.f2676a = (y0) Z1.m.o(y0Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f2676a.d();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f2676a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
            this.f2676a.C();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f2676a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f2676a.d() == 0) {
                return -1;
            }
            return this.f2676a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f2676a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j4) {
            int iMin = (int) Math.min(this.f2676a.d(), j4);
            this.f2676a.skipBytes(iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) {
            if (this.f2676a.d() == 0) {
                return -1;
            }
            int iMin = Math.min(this.f2676a.d(), i5);
            this.f2676a.z(bArr, i4, iMin);
            return iMin;
        }
    }

    public class a extends O {
        public a(y0 y0Var) {
            super(y0Var);
        }

        @Override // M2.y0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
