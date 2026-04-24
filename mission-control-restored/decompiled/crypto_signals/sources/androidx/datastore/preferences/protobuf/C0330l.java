package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0330l extends android.support.v4.media.session.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f4579f = Logger.getLogger(C0330l.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f4580g = i0.e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f4581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4584d;
    public final OutputStream e;

    public C0330l(OutputStream outputStream, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.f4582b = new byte[iMax];
        this.f4583c = iMax;
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.e = outputStream;
    }

    public static int U(int i, C0325g c0325g) {
        int iW = W(i);
        int size = c0325g.size();
        return X(size) + size + iW;
    }

    public static int V(String str) {
        int length;
        try {
            length = l0.a(str);
        } catch (k0 unused) {
            length = str.getBytes(AbstractC0341x.f4616a).length;
        }
        return X(length) + length;
    }

    public static int W(int i) {
        return X(i << 3);
    }

    public static int X(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int Y(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    @Override // android.support.v4.media.session.a
    public final void M(byte[] bArr, int i, int i6) throws IOException {
        c0(bArr, i, i6);
    }

    public final void P(int i) {
        int i6 = this.f4584d;
        int i7 = i6 + 1;
        this.f4584d = i7;
        byte[] bArr = this.f4582b;
        bArr[i6] = (byte) (i & 255);
        int i8 = i6 + 2;
        this.f4584d = i8;
        bArr[i7] = (byte) ((i >> 8) & 255);
        int i9 = i6 + 3;
        this.f4584d = i9;
        bArr[i8] = (byte) ((i >> 16) & 255);
        this.f4584d = i6 + 4;
        bArr[i9] = (byte) ((i >> 24) & 255);
    }

    public final void Q(long j4) {
        int i = this.f4584d;
        int i6 = i + 1;
        this.f4584d = i6;
        byte[] bArr = this.f4582b;
        bArr[i] = (byte) (j4 & 255);
        int i7 = i + 2;
        this.f4584d = i7;
        bArr[i6] = (byte) ((j4 >> 8) & 255);
        int i8 = i + 3;
        this.f4584d = i8;
        bArr[i7] = (byte) ((j4 >> 16) & 255);
        int i9 = i + 4;
        this.f4584d = i9;
        bArr[i8] = (byte) (255 & (j4 >> 24));
        int i10 = i + 5;
        this.f4584d = i10;
        bArr[i9] = (byte) (((int) (j4 >> 32)) & 255);
        int i11 = i + 6;
        this.f4584d = i11;
        bArr[i10] = (byte) (((int) (j4 >> 40)) & 255);
        int i12 = i + 7;
        this.f4584d = i12;
        bArr[i11] = (byte) (((int) (j4 >> 48)) & 255);
        this.f4584d = i + 8;
        bArr[i12] = (byte) (((int) (j4 >> 56)) & 255);
    }

    public final void R(int i, int i6) {
        S((i << 3) | i6);
    }

    public final void S(int i) {
        boolean z6 = f4580g;
        byte[] bArr = this.f4582b;
        if (z6) {
            while ((i & (-128)) != 0) {
                int i6 = this.f4584d;
                this.f4584d = i6 + 1;
                i0.j(bArr, i6, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
            int i7 = this.f4584d;
            this.f4584d = i7 + 1;
            i0.j(bArr, i7, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i8 = this.f4584d;
            this.f4584d = i8 + 1;
            bArr[i8] = (byte) ((i | 128) & 255);
            i >>>= 7;
        }
        int i9 = this.f4584d;
        this.f4584d = i9 + 1;
        bArr[i9] = (byte) i;
    }

    public final void T(long j4) {
        boolean z6 = f4580g;
        byte[] bArr = this.f4582b;
        if (z6) {
            while ((j4 & (-128)) != 0) {
                int i = this.f4584d;
                this.f4584d = i + 1;
                i0.j(bArr, i, (byte) ((((int) j4) | 128) & 255));
                j4 >>>= 7;
            }
            int i6 = this.f4584d;
            this.f4584d = i6 + 1;
            i0.j(bArr, i6, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            int i7 = this.f4584d;
            this.f4584d = i7 + 1;
            bArr[i7] = (byte) ((((int) j4) | 128) & 255);
            j4 >>>= 7;
        }
        int i8 = this.f4584d;
        this.f4584d = i8 + 1;
        bArr[i8] = (byte) j4;
    }

    public final void Z() throws IOException {
        this.e.write(this.f4582b, 0, this.f4584d);
        this.f4584d = 0;
    }

    public final void a0(int i) throws IOException {
        if (this.f4583c - this.f4584d < i) {
            Z();
        }
    }

    public final void b0(byte b3) throws IOException {
        if (this.f4584d == this.f4583c) {
            Z();
        }
        int i = this.f4584d;
        this.f4584d = i + 1;
        this.f4582b[i] = b3;
    }

    public final void c0(byte[] bArr, int i, int i6) throws IOException {
        int i7 = this.f4584d;
        int i8 = this.f4583c;
        int i9 = i8 - i7;
        byte[] bArr2 = this.f4582b;
        if (i9 >= i6) {
            System.arraycopy(bArr, i, bArr2, i7, i6);
            this.f4584d += i6;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i7, i9);
        int i10 = i + i9;
        int i11 = i6 - i9;
        this.f4584d = i8;
        Z();
        if (i11 > i8) {
            this.e.write(bArr, i10, i11);
        } else {
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            this.f4584d = i11;
        }
    }

    public final void d0(int i, boolean z6) throws IOException {
        a0(11);
        R(i, 0);
        byte b3 = z6 ? (byte) 1 : (byte) 0;
        int i6 = this.f4584d;
        this.f4584d = i6 + 1;
        this.f4582b[i6] = b3;
    }

    public final void e0(int i, C0325g c0325g) {
        p0(i, 2);
        f0(c0325g);
    }

    public final void f0(C0325g c0325g) throws IOException {
        r0(c0325g.size());
        M(c0325g.f4553b, c0325g.h(), c0325g.size());
    }

    public final void g0(int i, int i6) {
        a0(14);
        R(i, 5);
        P(i6);
    }

    public final void h0(int i) throws IOException {
        a0(4);
        P(i);
    }

    public final void i0(int i, long j4) {
        a0(18);
        R(i, 1);
        Q(j4);
    }

    public final void j0(long j4) throws IOException {
        a0(8);
        Q(j4);
    }

    public final void k0(int i, int i6) throws IOException {
        a0(20);
        R(i, 0);
        if (i6 >= 0) {
            S(i6);
        } else {
            T(i6);
        }
    }

    public final void l0(int i) throws IOException {
        if (i >= 0) {
            r0(i);
        } else {
            t0(i);
        }
    }

    public final void m0(int i, AbstractC0319a abstractC0319a, V v2) throws IOException {
        p0(i, 2);
        r0(abstractC0319a.a(v2));
        v2.e(abstractC0319a, this.f4581a);
    }

    public final void n0(int i, String str) throws IOException {
        p0(i, 2);
        o0(str);
    }

    public final void o0(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iX = X(length);
            int i = iX + length;
            int i6 = this.f4583c;
            if (i > i6) {
                byte[] bArr = new byte[length];
                int iO = l0.f4585a.o(str, bArr, 0, length);
                r0(iO);
                c0(bArr, 0, iO);
                return;
            }
            if (i > i6 - this.f4584d) {
                Z();
            }
            int iX2 = X(str.length());
            int i7 = this.f4584d;
            byte[] bArr2 = this.f4582b;
            try {
                if (iX2 == iX) {
                    int i8 = i7 + iX2;
                    this.f4584d = i8;
                    int iO2 = l0.f4585a.o(str, bArr2, i8, i6 - i8);
                    this.f4584d = i7;
                    S((iO2 - i7) - iX2);
                    this.f4584d = iO2;
                } else {
                    int iA = l0.a(str);
                    S(iA);
                    this.f4584d = l0.f4585a.o(str, bArr2, this.f4584d, iA);
                }
            } catch (k0 e) {
                this.f4584d = i7;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new P4.c(e2);
            }
        } catch (k0 e6) {
            f4579f.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e6);
            byte[] bytes = str.getBytes(AbstractC0341x.f4616a);
            try {
                r0(bytes.length);
                M(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e7) {
                throw new P4.c(e7);
            }
        }
    }

    public final void p0(int i, int i6) {
        r0((i << 3) | i6);
    }

    public final void q0(int i, int i6) throws IOException {
        a0(20);
        R(i, 0);
        S(i6);
    }

    public final void r0(int i) throws IOException {
        a0(5);
        S(i);
    }

    public final void s0(int i, long j4) {
        a0(20);
        R(i, 0);
        T(j4);
    }

    public final void t0(long j4) throws IOException {
        a0(10);
        T(j4);
    }
}
