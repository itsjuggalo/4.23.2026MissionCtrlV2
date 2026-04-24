package d1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: d1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1611A extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f16743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final X0.b f16748f;

    /* JADX INFO: renamed from: d1.A$a */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public C1611A(InputStream inputStream, X0.b bVar) {
        this(inputStream, bVar, 65536);
    }

    public static IOException f() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i8 = this.f16746d;
        if (i8 != -1) {
            int i9 = this.f16747e - i8;
            int i10 = this.f16745c;
            if (i9 < i10) {
                if (i8 == 0 && i10 > bArr.length && this.f16744b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i10) {
                        i10 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f16748f.e(i10, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f16743a = bArr2;
                    this.f16748f.d(bArr);
                    bArr = bArr2;
                } else if (i8 > 0) {
                    System.arraycopy(bArr, i8, bArr, 0, bArr.length - i8);
                }
                int i11 = this.f16747e - this.f16746d;
                this.f16747e = i11;
                this.f16746d = 0;
                this.f16744b = 0;
                int i12 = inputStream.read(bArr, i11, bArr.length - i11);
                int i13 = this.f16747e;
                if (i12 > 0) {
                    i13 += i12;
                }
                this.f16744b = i13;
                return i12;
            }
        }
        int i14 = inputStream.read(bArr);
        if (i14 > 0) {
            this.f16746d = -1;
            this.f16747e = 0;
            this.f16744b = i14;
        }
        return i14;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f16743a == null || inputStream == null) {
            throw f();
        }
        return (this.f16744b - this.f16747e) + inputStream.available();
    }

    public synchronized void c() {
        this.f16745c = this.f16743a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f16743a != null) {
            this.f16748f.d(this.f16743a);
            this.f16743a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void e() {
        if (this.f16743a != null) {
            this.f16748f.d(this.f16743a);
            this.f16743a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i8) {
        this.f16745c = Math.max(this.f16745c, i8);
        this.f16746d = this.f16747e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f16743a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw f();
        }
        if (this.f16747e >= this.f16744b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f16743a && (bArr = this.f16743a) == null) {
            throw f();
        }
        int i8 = this.f16744b;
        int i9 = this.f16747e;
        if (i8 - i9 <= 0) {
            return -1;
        }
        this.f16747e = i9 + 1;
        return bArr[i9] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f16743a == null) {
            throw new IOException("Stream is closed");
        }
        int i8 = this.f16746d;
        if (-1 == i8) {
            throw new a("Mark has been invalidated, pos: " + this.f16747e + " markLimit: " + this.f16745c);
        }
        this.f16747e = i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j8) {
        if (j8 < 1) {
            return 0L;
        }
        byte[] bArr = this.f16743a;
        if (bArr == null) {
            throw f();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw f();
        }
        int i8 = this.f16744b;
        int i9 = this.f16747e;
        if (i8 - i9 >= j8) {
            this.f16747e = (int) (((long) i9) + j8);
            return j8;
        }
        long j9 = ((long) i8) - ((long) i9);
        this.f16747e = i8;
        if (this.f16746d == -1 || j8 > this.f16745c) {
            long jSkip = inputStream.skip(j8 - j9);
            if (jSkip > 0) {
                this.f16746d = -1;
            }
            return j9 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j9;
        }
        int i10 = this.f16744b;
        int i11 = this.f16747e;
        if (i10 - i11 >= j8 - j9) {
            this.f16747e = (int) ((((long) i11) + j8) - j9);
            return j8;
        }
        long j10 = (j9 + ((long) i10)) - ((long) i11);
        this.f16747e = i10;
        return j10;
    }

    public C1611A(InputStream inputStream, X0.b bVar, int i8) {
        super(inputStream);
        this.f16746d = -1;
        this.f16748f = bVar;
        this.f16743a = (byte[]) bVar.e(i8, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        byte[] bArr2 = this.f16743a;
        if (bArr2 == null) {
            throw f();
        }
        if (i9 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw f();
        }
        int i12 = this.f16747e;
        int i13 = this.f16744b;
        if (i12 < i13) {
            int i14 = i13 - i12 >= i9 ? i9 : i13 - i12;
            System.arraycopy(bArr2, i12, bArr, i8, i14);
            this.f16747e += i14;
            if (i14 == i9 || inputStream.available() == 0) {
                return i14;
            }
            i8 += i14;
            i10 = i9 - i14;
        } else {
            i10 = i9;
        }
        while (true) {
            if (this.f16746d == -1 && i10 >= bArr2.length) {
                i11 = inputStream.read(bArr, i8, i10);
                if (i11 == -1) {
                    return i10 != i9 ? i9 - i10 : -1;
                }
            } else {
                if (a(inputStream, bArr2) == -1) {
                    return i10 != i9 ? i9 - i10 : -1;
                }
                if (bArr2 != this.f16743a && (bArr2 = this.f16743a) == null) {
                    throw f();
                }
                int i15 = this.f16744b;
                int i16 = this.f16747e;
                i11 = i15 - i16 >= i10 ? i10 : i15 - i16;
                System.arraycopy(bArr2, i16, bArr, i8, i11);
                this.f16747e += i11;
            }
            i10 -= i11;
            if (i10 == 0) {
                return i9;
            }
            if (inputStream.available() == 0) {
                return i9 - i10;
            }
            i8 += i11;
        }
    }
}
