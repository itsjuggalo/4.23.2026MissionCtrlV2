package p3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f18207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j3.b f18212f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public b0(InputStream inputStream, j3.b bVar) {
        this(inputStream, bVar, 65536);
    }

    public static IOException o() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f18207a == null || inputStream == null) {
            throw o();
        }
        return (this.f18208b - this.f18211e) + inputStream.available();
    }

    public final int b(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.f18210d;
        if (i10 != -1) {
            int i11 = this.f18211e - i10;
            int i12 = this.f18209c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f18208b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f18212f.d(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f18207a = bArr2;
                    this.f18212f.put(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f18211e - this.f18210d;
                this.f18211e = i13;
                this.f18210d = 0;
                this.f18208b = 0;
                int i14 = inputStream.read(bArr, i13, bArr.length - i13);
                int i15 = this.f18211e;
                if (i14 > 0) {
                    i15 += i14;
                }
                this.f18208b = i15;
                return i14;
            }
        }
        int i16 = inputStream.read(bArr);
        if (i16 > 0) {
            this.f18210d = -1;
            this.f18211e = 0;
            this.f18208b = i16;
        }
        return i16;
    }

    public synchronized void c() {
        this.f18209c = this.f18207a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f18207a != null) {
            this.f18212f.put(this.f18207a);
            this.f18207a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void e() {
        if (this.f18207a != null) {
            this.f18212f.put(this.f18207a);
            this.f18207a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f18209c = Math.max(this.f18209c, i10);
        this.f18210d = this.f18211e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f18207a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw o();
        }
        if (this.f18211e >= this.f18208b && b(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f18207a && (bArr = this.f18207a) == null) {
            throw o();
        }
        int i10 = this.f18208b;
        int i11 = this.f18211e;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.f18211e = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f18207a == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.f18210d;
        if (-1 == i10) {
            throw new a("Mark has been invalidated, pos: " + this.f18211e + " markLimit: " + this.f18209c);
        }
        this.f18211e = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f18207a;
        if (bArr == null) {
            throw o();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw o();
        }
        int i10 = this.f18208b;
        int i11 = this.f18211e;
        if (i10 - i11 >= j10) {
            this.f18211e = (int) (((long) i11) + j10);
            return j10;
        }
        long j11 = ((long) i10) - ((long) i11);
        this.f18211e = i10;
        if (this.f18210d == -1 || j10 > this.f18209c) {
            long jSkip = inputStream.skip(j10 - j11);
            if (jSkip > 0) {
                this.f18210d = -1;
            }
            return j11 + jSkip;
        }
        if (b(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.f18208b;
        int i13 = this.f18211e;
        if (i12 - i13 >= j10 - j11) {
            this.f18211e = (int) ((((long) i13) + j10) - j11);
            return j10;
        }
        long j12 = (j11 + ((long) i12)) - ((long) i13);
        this.f18211e = i12;
        return j12;
    }

    public b0(InputStream inputStream, j3.b bVar, int i10) {
        super(inputStream);
        this.f18210d = -1;
        this.f18212f = bVar;
        this.f18207a = (byte[]) bVar.d(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        byte[] bArr2 = this.f18207a;
        if (bArr2 == null) {
            throw o();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f18211e;
            int i15 = this.f18208b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f18211e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f18210d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (b(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f18207a && (bArr2 = this.f18207a) == null) {
                        throw o();
                    }
                    int i17 = this.f18208b;
                    int i18 = this.f18211e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f18211e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw o();
        }
    }
}
