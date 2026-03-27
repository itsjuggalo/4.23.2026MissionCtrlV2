package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1107i extends AbstractC1103e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11259c = Logger.getLogger(AbstractC1107i.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f11260d = i0.B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1108j f11261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11262b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i$b */
    public static abstract class b extends AbstractC1107i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f11263e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f11264f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11265g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11266h;

        public b(int i8) {
            super();
            if (i8 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i8, 20)];
            this.f11263e = bArr;
            this.f11264f = bArr.length;
        }

        public final void R0(byte b8) {
            byte[] bArr = this.f11263e;
            int i8 = this.f11265g;
            this.f11265g = i8 + 1;
            bArr[i8] = b8;
            this.f11266h++;
        }

        public final void S0(int i8) {
            byte[] bArr = this.f11263e;
            int i9 = this.f11265g;
            int i10 = i9 + 1;
            this.f11265g = i10;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i9 + 2;
            this.f11265g = i11;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i9 + 3;
            this.f11265g = i12;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.f11265g = i9 + 4;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
            this.f11266h += 4;
        }

        public final void T0(long j8) {
            byte[] bArr = this.f11263e;
            int i8 = this.f11265g;
            int i9 = i8 + 1;
            this.f11265g = i9;
            bArr[i8] = (byte) (j8 & 255);
            int i10 = i8 + 2;
            this.f11265g = i10;
            bArr[i9] = (byte) ((j8 >> 8) & 255);
            int i11 = i8 + 3;
            this.f11265g = i11;
            bArr[i10] = (byte) ((j8 >> 16) & 255);
            int i12 = i8 + 4;
            this.f11265g = i12;
            bArr[i11] = (byte) (255 & (j8 >> 24));
            int i13 = i8 + 5;
            this.f11265g = i13;
            bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
            int i14 = i8 + 6;
            this.f11265g = i14;
            bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
            int i15 = i8 + 7;
            this.f11265g = i15;
            bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
            this.f11265g = i8 + 8;
            bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            this.f11266h += 8;
        }

        public final void U0(int i8) {
            if (i8 >= 0) {
                W0(i8);
            } else {
                X0(i8);
            }
        }

        public final void V0(int i8, int i9) {
            W0(k0.c(i8, i9));
        }

        public final void W0(int i8) {
            if (!AbstractC1107i.f11260d) {
                while ((i8 & (-128)) != 0) {
                    byte[] bArr = this.f11263e;
                    int i9 = this.f11265g;
                    this.f11265g = i9 + 1;
                    bArr[i9] = (byte) ((i8 | 128) & 255);
                    this.f11266h++;
                    i8 >>>= 7;
                }
                byte[] bArr2 = this.f11263e;
                int i10 = this.f11265g;
                this.f11265g = i10 + 1;
                bArr2[i10] = (byte) i8;
                this.f11266h++;
                return;
            }
            long j8 = this.f11265g;
            while ((i8 & (-128)) != 0) {
                byte[] bArr3 = this.f11263e;
                int i11 = this.f11265g;
                this.f11265g = i11 + 1;
                i0.H(bArr3, i11, (byte) ((i8 | 128) & 255));
                i8 >>>= 7;
            }
            byte[] bArr4 = this.f11263e;
            int i12 = this.f11265g;
            this.f11265g = i12 + 1;
            i0.H(bArr4, i12, (byte) i8);
            this.f11266h += (int) (((long) this.f11265g) - j8);
        }

        public final void X0(long j8) {
            if (!AbstractC1107i.f11260d) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.f11263e;
                    int i8 = this.f11265g;
                    this.f11265g = i8 + 1;
                    bArr[i8] = (byte) ((((int) j8) | 128) & 255);
                    this.f11266h++;
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.f11263e;
                int i9 = this.f11265g;
                this.f11265g = i9 + 1;
                bArr2[i9] = (byte) j8;
                this.f11266h++;
                return;
            }
            long j9 = this.f11265g;
            while ((j8 & (-128)) != 0) {
                byte[] bArr3 = this.f11263e;
                int i10 = this.f11265g;
                this.f11265g = i10 + 1;
                i0.H(bArr3, i10, (byte) ((((int) j8) | 128) & 255));
                j8 >>>= 7;
            }
            byte[] bArr4 = this.f11263e;
            int i11 = this.f11265g;
            this.f11265g = i11 + 1;
            i0.H(bArr4, i11, (byte) j8);
            this.f11266h += (int) (((long) this.f11265g) - j9);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i$c */
    public static class c extends IOException {
        public c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i$d */
    public static final class d extends b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final OutputStream f11267i;

        public d(OutputStream outputStream, int i8) {
            super(i8);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f11267i = outputStream;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void A0(int i8, J j8) throws IOException {
            M0(1, 3);
            N0(2, i8);
            b1(3, j8);
            M0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void B0(int i8, AbstractC1104f abstractC1104f) throws IOException {
            M0(1, 3);
            N0(2, i8);
            e0(3, abstractC1104f);
            M0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void K0(int i8, String str) throws IOException {
            M0(i8, 2);
            L0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void L0(String str) throws IOException {
            int iC;
            try {
                int length = str.length() * 3;
                int iQ = AbstractC1107i.Q(length);
                int i8 = iQ + length;
                int i9 = this.f11264f;
                if (i8 > i9) {
                    byte[] bArr = new byte[length];
                    int iB = j0.b(str, bArr, 0, length);
                    O0(iB);
                    a(bArr, 0, iB);
                    return;
                }
                if (i8 > i9 - this.f11265g) {
                    Y0();
                }
                int iQ2 = AbstractC1107i.Q(str.length());
                int i10 = this.f11265g;
                try {
                    if (iQ2 == iQ) {
                        int i11 = i10 + iQ2;
                        this.f11265g = i11;
                        int iB2 = j0.b(str, this.f11263e, i11, this.f11264f - i11);
                        this.f11265g = i10;
                        iC = (iB2 - i10) - iQ2;
                        W0(iC);
                        this.f11265g = iB2;
                    } else {
                        iC = j0.c(str);
                        W0(iC);
                        this.f11265g = j0.b(str, this.f11263e, this.f11265g, iC);
                    }
                    this.f11266h += iC;
                } catch (j0.d e8) {
                    this.f11266h -= this.f11265g - i10;
                    this.f11265g = i10;
                    throw e8;
                } catch (ArrayIndexOutOfBoundsException e9) {
                    throw new c(e9);
                }
            } catch (j0.d e10) {
                W(str, e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void M0(int i8, int i9) throws IOException {
            O0(k0.c(i8, i9));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void N0(int i8, int i9) throws IOException {
            Z0(20);
            V0(i8, 0);
            W0(i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void O0(int i8) throws IOException {
            Z0(5);
            W0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void P0(int i8, long j8) throws IOException {
            Z0(20);
            V0(i8, 0);
            X0(j8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void Q0(long j8) throws IOException {
            Z0(10);
            X0(j8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void V() throws IOException {
            if (this.f11265g > 0) {
                Y0();
            }
        }

        public final void Y0() throws IOException {
            this.f11267i.write(this.f11263e, 0, this.f11265g);
            this.f11265g = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void Z(byte b8) throws IOException {
            if (this.f11265g == this.f11264f) {
                Y0();
            }
            R0(b8);
        }

        public final void Z0(int i8) throws IOException {
            if (this.f11264f - this.f11265g < i8) {
                Y0();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i, androidx.datastore.preferences.protobuf.AbstractC1103e
        public void a(byte[] bArr, int i8, int i9) throws IOException {
            a1(bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void a0(int i8, boolean z7) throws IOException {
            Z0(11);
            V0(i8, 0);
            R0(z7 ? (byte) 1 : (byte) 0);
        }

        public void a1(byte[] bArr, int i8, int i9) throws IOException {
            int i10 = this.f11264f;
            int i11 = this.f11265g;
            if (i10 - i11 >= i9) {
                System.arraycopy(bArr, i8, this.f11263e, i11, i9);
                this.f11265g += i9;
            } else {
                int i12 = i10 - i11;
                System.arraycopy(bArr, i8, this.f11263e, i11, i12);
                int i13 = i8 + i12;
                i9 -= i12;
                this.f11265g = this.f11264f;
                this.f11266h += i12;
                Y0();
                if (i9 <= this.f11264f) {
                    System.arraycopy(bArr, i13, this.f11263e, 0, i9);
                    this.f11265g = i9;
                } else {
                    this.f11267i.write(bArr, i13, i9);
                }
            }
            this.f11266h += i9;
        }

        public void b1(int i8, J j8) throws IOException {
            M0(i8, 2);
            z0(j8);
        }

        public void c1(J j8, Y y7) throws IOException {
            O0(((AbstractC1099a) j8).g(y7));
            y7.i(j8, this.f11261a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void d0(byte[] bArr, int i8, int i9) throws IOException {
            O0(i9);
            a1(bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void e0(int i8, AbstractC1104f abstractC1104f) throws IOException {
            M0(i8, 2);
            f0(abstractC1104f);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void f0(AbstractC1104f abstractC1104f) throws IOException {
            O0(abstractC1104f.size());
            abstractC1104f.R(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void k0(int i8, int i9) throws IOException {
            Z0(14);
            V0(i8, 5);
            S0(i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void l0(int i8) throws IOException {
            Z0(4);
            S0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void m0(int i8, long j8) throws IOException {
            Z0(18);
            V0(i8, 1);
            T0(j8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void n0(long j8) throws IOException {
            Z0(8);
            T0(j8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void u0(int i8, int i9) throws IOException {
            Z0(20);
            V0(i8, 0);
            U0(i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void v0(int i8) throws IOException {
            if (i8 >= 0) {
                O0(i8);
            } else {
                Q0(i8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void y0(int i8, J j8, Y y7) throws IOException {
            M0(i8, 2);
            c1(j8, y7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1107i
        public void z0(J j8) throws IOException {
            O0(j8.c());
            j8.e(this);
        }
    }

    public AbstractC1107i() {
    }

    public static int A(J j8) {
        return y(j8.c());
    }

    public static int B(J j8, Y y7) {
        return y(((AbstractC1099a) j8).g(y7));
    }

    public static int C(int i8) {
        if (i8 > 4096) {
            return 4096;
        }
        return i8;
    }

    public static int D(int i8, AbstractC1104f abstractC1104f) {
        return (O(1) * 2) + P(2, i8) + f(3, abstractC1104f);
    }

    public static int E(int i8, int i9) {
        return O(i8) + F(i9);
    }

    public static int F(int i8) {
        return 4;
    }

    public static int G(int i8, long j8) {
        return O(i8) + H(j8);
    }

    public static int H(long j8) {
        return 8;
    }

    public static int I(int i8, int i9) {
        return O(i8) + J(i9);
    }

    public static int J(int i8) {
        return Q(T(i8));
    }

    public static int K(int i8, long j8) {
        return O(i8) + L(j8);
    }

    public static int L(long j8) {
        return S(U(j8));
    }

    public static int M(int i8, String str) {
        return O(i8) + N(str);
    }

    public static int N(String str) {
        int length;
        try {
            length = j0.c(str);
        } catch (j0.d unused) {
            length = str.getBytes(AbstractC1118u.f11428b).length;
        }
        return y(length);
    }

    public static int O(int i8) {
        return Q(k0.c(i8, 0));
    }

    public static int P(int i8, int i9) {
        return O(i8) + Q(i9);
    }

    public static int Q(int i8) {
        return (352 - (Integer.numberOfLeadingZeros(i8) * 9)) >>> 6;
    }

    public static int R(int i8, long j8) {
        return O(i8) + S(j8);
    }

    public static int S(long j8) {
        return (640 - (Long.numberOfLeadingZeros(j8) * 9)) >>> 6;
    }

    public static int T(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long U(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static AbstractC1107i Y(OutputStream outputStream, int i8) {
        return new d(outputStream, i8);
    }

    public static int c(int i8, boolean z7) {
        return O(i8) + d(z7);
    }

    public static int d(boolean z7) {
        return 1;
    }

    public static int e(byte[] bArr) {
        return y(bArr.length);
    }

    public static int f(int i8, AbstractC1104f abstractC1104f) {
        return O(i8) + g(abstractC1104f);
    }

    public static int g(AbstractC1104f abstractC1104f) {
        return y(abstractC1104f.size());
    }

    public static int h(int i8, double d8) {
        return O(i8) + i(d8);
    }

    public static int i(double d8) {
        return 8;
    }

    public static int j(int i8, int i9) {
        return O(i8) + k(i9);
    }

    public static int k(int i8) {
        return v(i8);
    }

    public static int l(int i8, int i9) {
        return O(i8) + m(i9);
    }

    public static int m(int i8) {
        return 4;
    }

    public static int n(int i8, long j8) {
        return O(i8) + o(j8);
    }

    public static int o(long j8) {
        return 8;
    }

    public static int p(int i8, float f8) {
        return O(i8) + q(f8);
    }

    public static int q(float f8) {
        return 4;
    }

    public static int r(int i8, J j8, Y y7) {
        return (O(i8) * 2) + t(j8, y7);
    }

    public static int s(J j8) {
        return j8.c();
    }

    public static int t(J j8, Y y7) {
        return ((AbstractC1099a) j8).g(y7);
    }

    public static int u(int i8, int i9) {
        return O(i8) + v(i9);
    }

    public static int v(int i8) {
        return S(i8);
    }

    public static int w(int i8, long j8) {
        return O(i8) + x(j8);
    }

    public static int x(long j8) {
        return S(j8);
    }

    public static int y(int i8) {
        return Q(i8) + i8;
    }

    public static int z(int i8, J j8, Y y7) {
        return O(i8) + B(j8, y7);
    }

    public abstract void A0(int i8, J j8);

    public abstract void B0(int i8, AbstractC1104f abstractC1104f);

    public final void C0(int i8, int i9) {
        k0(i8, i9);
    }

    public final void D0(int i8) {
        l0(i8);
    }

    public final void E0(int i8, long j8) {
        m0(i8, j8);
    }

    public final void F0(long j8) {
        n0(j8);
    }

    public final void G0(int i8, int i9) {
        N0(i8, T(i9));
    }

    public final void H0(int i8) {
        O0(T(i8));
    }

    public final void I0(int i8, long j8) {
        P0(i8, U(j8));
    }

    public final void J0(long j8) {
        Q0(U(j8));
    }

    public abstract void K0(int i8, String str);

    public abstract void L0(String str);

    public abstract void M0(int i8, int i9);

    public abstract void N0(int i8, int i9);

    public abstract void O0(int i8);

    public abstract void P0(int i8, long j8);

    public abstract void Q0(long j8);

    public abstract void V();

    public final void W(String str, j0.d dVar) throws c {
        f11259c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(AbstractC1118u.f11428b);
        try {
            O0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e8) {
            throw new c(e8);
        }
    }

    public boolean X() {
        return this.f11262b;
    }

    public abstract void Z(byte b8);

    @Override // androidx.datastore.preferences.protobuf.AbstractC1103e
    public abstract void a(byte[] bArr, int i8, int i9);

    public abstract void a0(int i8, boolean z7);

    public final void b0(boolean z7) {
        Z(z7 ? (byte) 1 : (byte) 0);
    }

    public final void c0(byte[] bArr) {
        d0(bArr, 0, bArr.length);
    }

    public abstract void d0(byte[] bArr, int i8, int i9);

    public abstract void e0(int i8, AbstractC1104f abstractC1104f);

    public abstract void f0(AbstractC1104f abstractC1104f);

    public final void g0(int i8, double d8) {
        m0(i8, Double.doubleToRawLongBits(d8));
    }

    public final void h0(double d8) {
        n0(Double.doubleToRawLongBits(d8));
    }

    public final void i0(int i8, int i9) {
        u0(i8, i9);
    }

    public final void j0(int i8) {
        v0(i8);
    }

    public abstract void k0(int i8, int i9);

    public abstract void l0(int i8);

    public abstract void m0(int i8, long j8);

    public abstract void n0(long j8);

    public final void o0(int i8, float f8) {
        k0(i8, Float.floatToRawIntBits(f8));
    }

    public final void p0(float f8) {
        l0(Float.floatToRawIntBits(f8));
    }

    public final void q0(int i8, J j8) {
        M0(i8, 3);
        s0(j8);
        M0(i8, 4);
    }

    public final void r0(int i8, J j8, Y y7) {
        M0(i8, 3);
        t0(j8, y7);
        M0(i8, 4);
    }

    public final void s0(J j8) {
        j8.e(this);
    }

    public final void t0(J j8, Y y7) {
        y7.i(j8, this.f11261a);
    }

    public abstract void u0(int i8, int i9);

    public abstract void v0(int i8);

    public final void w0(int i8, long j8) {
        P0(i8, j8);
    }

    public final void x0(long j8) {
        Q0(j8);
    }

    public abstract void y0(int i8, J j8, Y y7);

    public abstract void z0(J j8);
}
