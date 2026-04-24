package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0938i extends AbstractC0934e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f7447c = Logger.getLogger(AbstractC0938i.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7448d = i0.B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0939j f7449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7450b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i$b */
    public static abstract class b extends AbstractC0938i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7451e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7452f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7453g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7454h;

        public b(int i7) {
            super();
            if (i7 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i7, 20)];
            this.f7451e = bArr;
            this.f7452f = bArr.length;
        }

        public final void R0(byte b7) {
            byte[] bArr = this.f7451e;
            int i7 = this.f7453g;
            this.f7453g = i7 + 1;
            bArr[i7] = b7;
            this.f7454h++;
        }

        public final void S0(int i7) {
            byte[] bArr = this.f7451e;
            int i8 = this.f7453g;
            int i9 = i8 + 1;
            this.f7453g = i9;
            bArr[i8] = (byte) (i7 & 255);
            int i10 = i8 + 2;
            this.f7453g = i10;
            bArr[i9] = (byte) ((i7 >> 8) & 255);
            int i11 = i8 + 3;
            this.f7453g = i11;
            bArr[i10] = (byte) ((i7 >> 16) & 255);
            this.f7453g = i8 + 4;
            bArr[i11] = (byte) ((i7 >> 24) & 255);
            this.f7454h += 4;
        }

        public final void T0(long j7) {
            byte[] bArr = this.f7451e;
            int i7 = this.f7453g;
            int i8 = i7 + 1;
            this.f7453g = i8;
            bArr[i7] = (byte) (j7 & 255);
            int i9 = i7 + 2;
            this.f7453g = i9;
            bArr[i8] = (byte) ((j7 >> 8) & 255);
            int i10 = i7 + 3;
            this.f7453g = i10;
            bArr[i9] = (byte) ((j7 >> 16) & 255);
            int i11 = i7 + 4;
            this.f7453g = i11;
            bArr[i10] = (byte) (255 & (j7 >> 24));
            int i12 = i7 + 5;
            this.f7453g = i12;
            bArr[i11] = (byte) (((int) (j7 >> 32)) & 255);
            int i13 = i7 + 6;
            this.f7453g = i13;
            bArr[i12] = (byte) (((int) (j7 >> 40)) & 255);
            int i14 = i7 + 7;
            this.f7453g = i14;
            bArr[i13] = (byte) (((int) (j7 >> 48)) & 255);
            this.f7453g = i7 + 8;
            bArr[i14] = (byte) (((int) (j7 >> 56)) & 255);
            this.f7454h += 8;
        }

        public final void U0(int i7) {
            if (i7 >= 0) {
                W0(i7);
            } else {
                X0(i7);
            }
        }

        public final void V0(int i7, int i8) {
            W0(k0.c(i7, i8));
        }

        public final void W0(int i7) {
            if (!AbstractC0938i.f7448d) {
                while ((i7 & (-128)) != 0) {
                    byte[] bArr = this.f7451e;
                    int i8 = this.f7453g;
                    this.f7453g = i8 + 1;
                    bArr[i8] = (byte) ((i7 | 128) & 255);
                    this.f7454h++;
                    i7 >>>= 7;
                }
                byte[] bArr2 = this.f7451e;
                int i9 = this.f7453g;
                this.f7453g = i9 + 1;
                bArr2[i9] = (byte) i7;
                this.f7454h++;
                return;
            }
            long j7 = this.f7453g;
            while ((i7 & (-128)) != 0) {
                byte[] bArr3 = this.f7451e;
                int i10 = this.f7453g;
                this.f7453g = i10 + 1;
                i0.H(bArr3, i10, (byte) ((i7 | 128) & 255));
                i7 >>>= 7;
            }
            byte[] bArr4 = this.f7451e;
            int i11 = this.f7453g;
            this.f7453g = i11 + 1;
            i0.H(bArr4, i11, (byte) i7);
            this.f7454h += (int) (((long) this.f7453g) - j7);
        }

        public final void X0(long j7) {
            if (!AbstractC0938i.f7448d) {
                while ((j7 & (-128)) != 0) {
                    byte[] bArr = this.f7451e;
                    int i7 = this.f7453g;
                    this.f7453g = i7 + 1;
                    bArr[i7] = (byte) ((((int) j7) | 128) & 255);
                    this.f7454h++;
                    j7 >>>= 7;
                }
                byte[] bArr2 = this.f7451e;
                int i8 = this.f7453g;
                this.f7453g = i8 + 1;
                bArr2[i8] = (byte) j7;
                this.f7454h++;
                return;
            }
            long j8 = this.f7453g;
            while ((j7 & (-128)) != 0) {
                byte[] bArr3 = this.f7451e;
                int i9 = this.f7453g;
                this.f7453g = i9 + 1;
                i0.H(bArr3, i9, (byte) ((((int) j7) | 128) & 255));
                j7 >>>= 7;
            }
            byte[] bArr4 = this.f7451e;
            int i10 = this.f7453g;
            this.f7453g = i10 + 1;
            i0.H(bArr4, i10, (byte) j7);
            this.f7454h += (int) (((long) this.f7453g) - j8);
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
        public final OutputStream f7455i;

        public d(OutputStream outputStream, int i7) {
            super(i7);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f7455i = outputStream;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void A0(int i7, J j7) throws IOException {
            M0(1, 3);
            N0(2, i7);
            b1(3, j7);
            M0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void B0(int i7, AbstractC0935f abstractC0935f) throws IOException {
            M0(1, 3);
            N0(2, i7);
            e0(3, abstractC0935f);
            M0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void K0(int i7, String str) throws IOException {
            M0(i7, 2);
            L0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void L0(String str) throws IOException {
            int iC;
            try {
                int length = str.length() * 3;
                int iQ = AbstractC0938i.Q(length);
                int i7 = iQ + length;
                int i8 = this.f7452f;
                if (i7 > i8) {
                    byte[] bArr = new byte[length];
                    int iB = j0.b(str, bArr, 0, length);
                    O0(iB);
                    a(bArr, 0, iB);
                    return;
                }
                if (i7 > i8 - this.f7453g) {
                    Y0();
                }
                int iQ2 = AbstractC0938i.Q(str.length());
                int i9 = this.f7453g;
                try {
                    if (iQ2 == iQ) {
                        int i10 = i9 + iQ2;
                        this.f7453g = i10;
                        int iB2 = j0.b(str, this.f7451e, i10, this.f7452f - i10);
                        this.f7453g = i9;
                        iC = (iB2 - i9) - iQ2;
                        W0(iC);
                        this.f7453g = iB2;
                    } else {
                        iC = j0.c(str);
                        W0(iC);
                        this.f7453g = j0.b(str, this.f7451e, this.f7453g, iC);
                    }
                    this.f7454h += iC;
                } catch (j0.d e7) {
                    this.f7454h -= this.f7453g - i9;
                    this.f7453g = i9;
                    throw e7;
                } catch (ArrayIndexOutOfBoundsException e8) {
                    throw new c(e8);
                }
            } catch (j0.d e9) {
                W(str, e9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void M0(int i7, int i8) throws IOException {
            O0(k0.c(i7, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void N0(int i7, int i8) throws IOException {
            Z0(20);
            V0(i7, 0);
            W0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void O0(int i7) throws IOException {
            Z0(5);
            W0(i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void P0(int i7, long j7) throws IOException {
            Z0(20);
            V0(i7, 0);
            X0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void Q0(long j7) throws IOException {
            Z0(10);
            X0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void V() throws IOException {
            if (this.f7453g > 0) {
                Y0();
            }
        }

        public final void Y0() throws IOException {
            this.f7455i.write(this.f7451e, 0, this.f7453g);
            this.f7453g = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void Z(byte b7) throws IOException {
            if (this.f7453g == this.f7452f) {
                Y0();
            }
            R0(b7);
        }

        public final void Z0(int i7) throws IOException {
            if (this.f7452f - this.f7453g < i7) {
                Y0();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i, androidx.datastore.preferences.protobuf.AbstractC0934e
        public void a(byte[] bArr, int i7, int i8) throws IOException {
            a1(bArr, i7, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void a0(int i7, boolean z7) throws IOException {
            Z0(11);
            V0(i7, 0);
            R0(z7 ? (byte) 1 : (byte) 0);
        }

        public void a1(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = this.f7452f;
            int i10 = this.f7453g;
            if (i9 - i10 >= i8) {
                System.arraycopy(bArr, i7, this.f7451e, i10, i8);
                this.f7453g += i8;
                this.f7454h += i8;
                return;
            }
            int i11 = i9 - i10;
            System.arraycopy(bArr, i7, this.f7451e, i10, i11);
            int i12 = i7 + i11;
            int i13 = i8 - i11;
            this.f7453g = this.f7452f;
            this.f7454h += i11;
            Y0();
            if (i13 <= this.f7452f) {
                System.arraycopy(bArr, i12, this.f7451e, 0, i13);
                this.f7453g = i13;
            } else {
                this.f7455i.write(bArr, i12, i13);
            }
            this.f7454h += i13;
        }

        public void b1(int i7, J j7) throws IOException {
            M0(i7, 2);
            z0(j7);
        }

        public void c1(J j7, Y y7) throws IOException {
            O0(((AbstractC0930a) j7).f(y7));
            y7.i(j7, this.f7449a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void d0(byte[] bArr, int i7, int i8) throws IOException {
            O0(i8);
            a1(bArr, i7, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void e0(int i7, AbstractC0935f abstractC0935f) throws IOException {
            M0(i7, 2);
            f0(abstractC0935f);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void f0(AbstractC0935f abstractC0935f) throws IOException {
            O0(abstractC0935f.size());
            abstractC0935f.y(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void k0(int i7, int i8) throws IOException {
            Z0(14);
            V0(i7, 5);
            S0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void l0(int i7) throws IOException {
            Z0(4);
            S0(i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void m0(int i7, long j7) throws IOException {
            Z0(18);
            V0(i7, 1);
            T0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void n0(long j7) throws IOException {
            Z0(8);
            T0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void u0(int i7, int i8) throws IOException {
            Z0(20);
            V0(i7, 0);
            U0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void v0(int i7) throws IOException {
            if (i7 >= 0) {
                O0(i7);
            } else {
                Q0(i7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void y0(int i7, J j7, Y y7) throws IOException {
            M0(i7, 2);
            c1(j7, y7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0938i
        public void z0(J j7) throws IOException {
            O0(j7.b());
            j7.d(this);
        }
    }

    public static int A(J j7) {
        return y(j7.b());
    }

    public static int B(J j7, Y y7) {
        return y(((AbstractC0930a) j7).f(y7));
    }

    public static int C(int i7) {
        if (i7 > 4096) {
            return 4096;
        }
        return i7;
    }

    public static int D(int i7, AbstractC0935f abstractC0935f) {
        return (O(1) * 2) + P(2, i7) + f(3, abstractC0935f);
    }

    public static int E(int i7, int i8) {
        return O(i7) + F(i8);
    }

    public static int F(int i7) {
        return 4;
    }

    public static int G(int i7, long j7) {
        return O(i7) + H(j7);
    }

    public static int H(long j7) {
        return 8;
    }

    public static int I(int i7, int i8) {
        return O(i7) + J(i8);
    }

    public static int J(int i7) {
        return Q(T(i7));
    }

    public static int K(int i7, long j7) {
        return O(i7) + L(j7);
    }

    public static int L(long j7) {
        return S(U(j7));
    }

    public static int M(int i7, String str) {
        return O(i7) + N(str);
    }

    public static int N(String str) {
        int length;
        try {
            length = j0.c(str);
        } catch (j0.d unused) {
            length = str.getBytes(AbstractC0949u.f7616b).length;
        }
        return y(length);
    }

    public static int O(int i7) {
        return Q(k0.c(i7, 0));
    }

    public static int P(int i7, int i8) {
        return O(i7) + Q(i8);
    }

    public static int Q(int i7) {
        return (352 - (Integer.numberOfLeadingZeros(i7) * 9)) >>> 6;
    }

    public static int R(int i7, long j7) {
        return O(i7) + S(j7);
    }

    public static int S(long j7) {
        return (640 - (Long.numberOfLeadingZeros(j7) * 9)) >>> 6;
    }

    public static int T(int i7) {
        return (i7 >> 31) ^ (i7 << 1);
    }

    public static long U(long j7) {
        return (j7 >> 63) ^ (j7 << 1);
    }

    public static AbstractC0938i Y(OutputStream outputStream, int i7) {
        return new d(outputStream, i7);
    }

    public static int c(int i7, boolean z7) {
        return O(i7) + d(z7);
    }

    public static int d(boolean z7) {
        return 1;
    }

    public static int e(byte[] bArr) {
        return y(bArr.length);
    }

    public static int f(int i7, AbstractC0935f abstractC0935f) {
        return O(i7) + g(abstractC0935f);
    }

    public static int g(AbstractC0935f abstractC0935f) {
        return y(abstractC0935f.size());
    }

    public static int h(int i7, double d7) {
        return O(i7) + i(d7);
    }

    public static int i(double d7) {
        return 8;
    }

    public static int j(int i7, int i8) {
        return O(i7) + k(i8);
    }

    public static int k(int i7) {
        return v(i7);
    }

    public static int l(int i7, int i8) {
        return O(i7) + m(i8);
    }

    public static int m(int i7) {
        return 4;
    }

    public static int n(int i7, long j7) {
        return O(i7) + o(j7);
    }

    public static int o(long j7) {
        return 8;
    }

    public static int p(int i7, float f7) {
        return O(i7) + q(f7);
    }

    public static int q(float f7) {
        return 4;
    }

    public static int r(int i7, J j7, Y y7) {
        return (O(i7) * 2) + t(j7, y7);
    }

    public static int s(J j7) {
        return j7.b();
    }

    public static int t(J j7, Y y7) {
        return ((AbstractC0930a) j7).f(y7);
    }

    public static int u(int i7, int i8) {
        return O(i7) + v(i8);
    }

    public static int v(int i7) {
        return S(i7);
    }

    public static int w(int i7, long j7) {
        return O(i7) + x(j7);
    }

    public static int x(long j7) {
        return S(j7);
    }

    public static int y(int i7) {
        return Q(i7) + i7;
    }

    public static int z(int i7, J j7, Y y7) {
        return O(i7) + B(j7, y7);
    }

    public abstract void A0(int i7, J j7);

    public abstract void B0(int i7, AbstractC0935f abstractC0935f);

    public final void C0(int i7, int i8) {
        k0(i7, i8);
    }

    public final void D0(int i7) {
        l0(i7);
    }

    public final void E0(int i7, long j7) {
        m0(i7, j7);
    }

    public final void F0(long j7) {
        n0(j7);
    }

    public final void G0(int i7, int i8) {
        N0(i7, T(i8));
    }

    public final void H0(int i7) {
        O0(T(i7));
    }

    public final void I0(int i7, long j7) {
        P0(i7, U(j7));
    }

    public final void J0(long j7) {
        Q0(U(j7));
    }

    public abstract void K0(int i7, String str);

    public abstract void L0(String str);

    public abstract void M0(int i7, int i8);

    public abstract void N0(int i7, int i8);

    public abstract void O0(int i7);

    public abstract void P0(int i7, long j7);

    public abstract void Q0(long j7);

    public abstract void V();

    public final void W(String str, j0.d dVar) throws c {
        f7447c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(AbstractC0949u.f7616b);
        try {
            O0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e7) {
            throw new c(e7);
        }
    }

    public boolean X() {
        return this.f7450b;
    }

    public abstract void Z(byte b7);

    @Override // androidx.datastore.preferences.protobuf.AbstractC0934e
    public abstract void a(byte[] bArr, int i7, int i8);

    public abstract void a0(int i7, boolean z7);

    public final void b0(boolean z7) {
        Z(z7 ? (byte) 1 : (byte) 0);
    }

    public final void c0(byte[] bArr) {
        d0(bArr, 0, bArr.length);
    }

    public abstract void d0(byte[] bArr, int i7, int i8);

    public abstract void e0(int i7, AbstractC0935f abstractC0935f);

    public abstract void f0(AbstractC0935f abstractC0935f);

    public final void g0(int i7, double d7) {
        m0(i7, Double.doubleToRawLongBits(d7));
    }

    public final void h0(double d7) {
        n0(Double.doubleToRawLongBits(d7));
    }

    public final void i0(int i7, int i8) {
        u0(i7, i8);
    }

    public final void j0(int i7) {
        v0(i7);
    }

    public abstract void k0(int i7, int i8);

    public abstract void l0(int i7);

    public abstract void m0(int i7, long j7);

    public abstract void n0(long j7);

    public final void o0(int i7, float f7) {
        k0(i7, Float.floatToRawIntBits(f7));
    }

    public final void p0(float f7) {
        l0(Float.floatToRawIntBits(f7));
    }

    public final void q0(int i7, J j7) {
        M0(i7, 3);
        s0(j7);
        M0(i7, 4);
    }

    public final void r0(int i7, J j7, Y y7) {
        M0(i7, 3);
        t0(j7, y7);
        M0(i7, 4);
    }

    public final void s0(J j7) {
        j7.d(this);
    }

    public final void t0(J j7, Y y7) {
        y7.i(j7, this.f7449a);
    }

    public abstract void u0(int i7, int i8);

    public abstract void v0(int i7);

    public final void w0(int i7, long j7) {
        P0(i7, j7);
    }

    public final void x0(long j7) {
        Q0(j7);
    }

    public abstract void y0(int i7, J j7, Y y7);

    public abstract void z0(J j7);

    public AbstractC0938i() {
    }
}
