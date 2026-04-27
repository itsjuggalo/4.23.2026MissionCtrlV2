package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0796i extends AbstractC0792e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f7039c = Logger.getLogger(AbstractC0796i.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7040d = i0.B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0797j f7041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7042b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.i$b */
    public static abstract class b extends AbstractC0796i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7045g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7046h;

        public b(int i4) {
            super();
            if (i4 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i4, 20)];
            this.f7043e = bArr;
            this.f7044f = bArr.length;
        }

        public final void R0(byte b4) {
            byte[] bArr = this.f7043e;
            int i4 = this.f7045g;
            this.f7045g = i4 + 1;
            bArr[i4] = b4;
            this.f7046h++;
        }

        public final void S0(int i4) {
            byte[] bArr = this.f7043e;
            int i5 = this.f7045g;
            int i6 = i5 + 1;
            this.f7045g = i6;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i5 + 2;
            this.f7045g = i7;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i5 + 3;
            this.f7045g = i8;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.f7045g = i5 + 4;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
            this.f7046h += 4;
        }

        public final void T0(long j4) {
            byte[] bArr = this.f7043e;
            int i4 = this.f7045g;
            int i5 = i4 + 1;
            this.f7045g = i5;
            bArr[i4] = (byte) (j4 & 255);
            int i6 = i4 + 2;
            this.f7045g = i6;
            bArr[i5] = (byte) ((j4 >> 8) & 255);
            int i7 = i4 + 3;
            this.f7045g = i7;
            bArr[i6] = (byte) ((j4 >> 16) & 255);
            int i8 = i4 + 4;
            this.f7045g = i8;
            bArr[i7] = (byte) (255 & (j4 >> 24));
            int i9 = i4 + 5;
            this.f7045g = i9;
            bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
            int i10 = i4 + 6;
            this.f7045g = i10;
            bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
            int i11 = i4 + 7;
            this.f7045g = i11;
            bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
            this.f7045g = i4 + 8;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            this.f7046h += 8;
        }

        public final void U0(int i4) {
            if (i4 >= 0) {
                W0(i4);
            } else {
                X0(i4);
            }
        }

        public final void V0(int i4, int i5) {
            W0(k0.c(i4, i5));
        }

        public final void W0(int i4) {
            if (!AbstractC0796i.f7040d) {
                while ((i4 & (-128)) != 0) {
                    byte[] bArr = this.f7043e;
                    int i5 = this.f7045g;
                    this.f7045g = i5 + 1;
                    bArr[i5] = (byte) ((i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255);
                    this.f7046h++;
                    i4 >>>= 7;
                }
                byte[] bArr2 = this.f7043e;
                int i6 = this.f7045g;
                this.f7045g = i6 + 1;
                bArr2[i6] = (byte) i4;
                this.f7046h++;
                return;
            }
            long j4 = this.f7045g;
            while ((i4 & (-128)) != 0) {
                byte[] bArr3 = this.f7043e;
                int i7 = this.f7045g;
                this.f7045g = i7 + 1;
                i0.H(bArr3, i7, (byte) ((i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255));
                i4 >>>= 7;
            }
            byte[] bArr4 = this.f7043e;
            int i8 = this.f7045g;
            this.f7045g = i8 + 1;
            i0.H(bArr4, i8, (byte) i4);
            this.f7046h += (int) (((long) this.f7045g) - j4);
        }

        public final void X0(long j4) {
            if (!AbstractC0796i.f7040d) {
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.f7043e;
                    int i4 = this.f7045g;
                    this.f7045g = i4 + 1;
                    bArr[i4] = (byte) ((((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255);
                    this.f7046h++;
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.f7043e;
                int i5 = this.f7045g;
                this.f7045g = i5 + 1;
                bArr2[i5] = (byte) j4;
                this.f7046h++;
                return;
            }
            long j5 = this.f7045g;
            while ((j4 & (-128)) != 0) {
                byte[] bArr3 = this.f7043e;
                int i6 = this.f7045g;
                this.f7045g = i6 + 1;
                i0.H(bArr3, i6, (byte) ((((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255));
                j4 >>>= 7;
            }
            byte[] bArr4 = this.f7043e;
            int i7 = this.f7045g;
            this.f7045g = i7 + 1;
            i0.H(bArr4, i7, (byte) j4);
            this.f7046h += (int) (((long) this.f7045g) - j5);
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
        public final OutputStream f7047i;

        public d(OutputStream outputStream, int i4) {
            super(i4);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f7047i = outputStream;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void A0(int i4, J j4) throws IOException {
            M0(1, 3);
            N0(2, i4);
            b1(3, j4);
            M0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void B0(int i4, AbstractC0793f abstractC0793f) throws IOException {
            M0(1, 3);
            N0(2, i4);
            e0(3, abstractC0793f);
            M0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void K0(int i4, String str) throws IOException {
            M0(i4, 2);
            L0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void L0(String str) throws IOException {
            int iC;
            try {
                int length = str.length() * 3;
                int iQ = AbstractC0796i.Q(length);
                int i4 = iQ + length;
                int i5 = this.f7044f;
                if (i4 > i5) {
                    byte[] bArr = new byte[length];
                    int iB = j0.b(str, bArr, 0, length);
                    O0(iB);
                    a(bArr, 0, iB);
                    return;
                }
                if (i4 > i5 - this.f7045g) {
                    Y0();
                }
                int iQ2 = AbstractC0796i.Q(str.length());
                int i6 = this.f7045g;
                try {
                    if (iQ2 == iQ) {
                        int i7 = i6 + iQ2;
                        this.f7045g = i7;
                        int iB2 = j0.b(str, this.f7043e, i7, this.f7044f - i7);
                        this.f7045g = i6;
                        iC = (iB2 - i6) - iQ2;
                        W0(iC);
                        this.f7045g = iB2;
                    } else {
                        iC = j0.c(str);
                        W0(iC);
                        this.f7045g = j0.b(str, this.f7043e, this.f7045g, iC);
                    }
                    this.f7046h += iC;
                } catch (j0.d e4) {
                    this.f7046h -= this.f7045g - i6;
                    this.f7045g = i6;
                    throw e4;
                } catch (ArrayIndexOutOfBoundsException e5) {
                    throw new c(e5);
                }
            } catch (j0.d e6) {
                W(str, e6);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void M0(int i4, int i5) throws IOException {
            O0(k0.c(i4, i5));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void N0(int i4, int i5) throws IOException {
            Z0(20);
            V0(i4, 0);
            W0(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void O0(int i4) throws IOException {
            Z0(5);
            W0(i4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void P0(int i4, long j4) throws IOException {
            Z0(20);
            V0(i4, 0);
            X0(j4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void Q0(long j4) throws IOException {
            Z0(10);
            X0(j4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void V() throws IOException {
            if (this.f7045g > 0) {
                Y0();
            }
        }

        public final void Y0() throws IOException {
            this.f7047i.write(this.f7043e, 0, this.f7045g);
            this.f7045g = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void Z(byte b4) throws IOException {
            if (this.f7045g == this.f7044f) {
                Y0();
            }
            R0(b4);
        }

        public final void Z0(int i4) throws IOException {
            if (this.f7044f - this.f7045g < i4) {
                Y0();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i, androidx.datastore.preferences.protobuf.AbstractC0792e
        public void a(byte[] bArr, int i4, int i5) throws IOException {
            a1(bArr, i4, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void a0(int i4, boolean z4) throws IOException {
            Z0(11);
            V0(i4, 0);
            R0(z4 ? (byte) 1 : (byte) 0);
        }

        public void a1(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = this.f7044f;
            int i7 = this.f7045g;
            if (i6 - i7 >= i5) {
                System.arraycopy(bArr, i4, this.f7043e, i7, i5);
                this.f7045g += i5;
                this.f7046h += i5;
                return;
            }
            int i8 = i6 - i7;
            System.arraycopy(bArr, i4, this.f7043e, i7, i8);
            int i9 = i4 + i8;
            int i10 = i5 - i8;
            this.f7045g = this.f7044f;
            this.f7046h += i8;
            Y0();
            if (i10 <= this.f7044f) {
                System.arraycopy(bArr, i9, this.f7043e, 0, i10);
                this.f7045g = i10;
            } else {
                this.f7047i.write(bArr, i9, i10);
            }
            this.f7046h += i10;
        }

        public void b1(int i4, J j4) throws IOException {
            M0(i4, 2);
            z0(j4);
        }

        public void c1(J j4, Y y4) throws IOException {
            O0(((AbstractC0788a) j4).c(y4));
            y4.i(j4, this.f7041a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void d0(byte[] bArr, int i4, int i5) throws IOException {
            O0(i5);
            a1(bArr, i4, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void e0(int i4, AbstractC0793f abstractC0793f) throws IOException {
            M0(i4, 2);
            f0(abstractC0793f);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void f0(AbstractC0793f abstractC0793f) throws IOException {
            O0(abstractC0793f.size());
            abstractC0793f.z(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void k0(int i4, int i5) throws IOException {
            Z0(14);
            V0(i4, 5);
            S0(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void l0(int i4) throws IOException {
            Z0(4);
            S0(i4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void m0(int i4, long j4) throws IOException {
            Z0(18);
            V0(i4, 1);
            T0(j4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void n0(long j4) throws IOException {
            Z0(8);
            T0(j4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void u0(int i4, int i5) throws IOException {
            Z0(20);
            V0(i4, 0);
            U0(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void v0(int i4) throws IOException {
            if (i4 >= 0) {
                O0(i4);
            } else {
                Q0(i4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void y0(int i4, J j4, Y y4) throws IOException {
            M0(i4, 2);
            c1(j4, y4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0796i
        public void z0(J j4) throws IOException {
            O0(j4.getSerializedSize());
            j4.a(this);
        }
    }

    public static int A(J j4) {
        return y(j4.getSerializedSize());
    }

    public static int B(J j4, Y y4) {
        return y(((AbstractC0788a) j4).c(y4));
    }

    public static int C(int i4) {
        if (i4 > 4096) {
            return 4096;
        }
        return i4;
    }

    public static int D(int i4, AbstractC0793f abstractC0793f) {
        return (O(1) * 2) + P(2, i4) + f(3, abstractC0793f);
    }

    public static int E(int i4, int i5) {
        return O(i4) + F(i5);
    }

    public static int F(int i4) {
        return 4;
    }

    public static int G(int i4, long j4) {
        return O(i4) + H(j4);
    }

    public static int H(long j4) {
        return 8;
    }

    public static int I(int i4, int i5) {
        return O(i4) + J(i5);
    }

    public static int J(int i4) {
        return Q(T(i4));
    }

    public static int K(int i4, long j4) {
        return O(i4) + L(j4);
    }

    public static int L(long j4) {
        return S(U(j4));
    }

    public static int M(int i4, String str) {
        return O(i4) + N(str);
    }

    public static int N(String str) {
        int length;
        try {
            length = j0.c(str);
        } catch (j0.d unused) {
            length = str.getBytes(AbstractC0807u.f7208b).length;
        }
        return y(length);
    }

    public static int O(int i4) {
        return Q(k0.c(i4, 0));
    }

    public static int P(int i4, int i5) {
        return O(i4) + Q(i5);
    }

    public static int Q(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
    }

    public static int R(int i4, long j4) {
        return O(i4) + S(j4);
    }

    public static int S(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public static int T(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public static long U(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static AbstractC0796i Y(OutputStream outputStream, int i4) {
        return new d(outputStream, i4);
    }

    public static int c(int i4, boolean z4) {
        return O(i4) + d(z4);
    }

    public static int d(boolean z4) {
        return 1;
    }

    public static int e(byte[] bArr) {
        return y(bArr.length);
    }

    public static int f(int i4, AbstractC0793f abstractC0793f) {
        return O(i4) + g(abstractC0793f);
    }

    public static int g(AbstractC0793f abstractC0793f) {
        return y(abstractC0793f.size());
    }

    public static int h(int i4, double d4) {
        return O(i4) + i(d4);
    }

    public static int i(double d4) {
        return 8;
    }

    public static int j(int i4, int i5) {
        return O(i4) + k(i5);
    }

    public static int k(int i4) {
        return v(i4);
    }

    public static int l(int i4, int i5) {
        return O(i4) + m(i5);
    }

    public static int m(int i4) {
        return 4;
    }

    public static int n(int i4, long j4) {
        return O(i4) + o(j4);
    }

    public static int o(long j4) {
        return 8;
    }

    public static int p(int i4, float f4) {
        return O(i4) + q(f4);
    }

    public static int q(float f4) {
        return 4;
    }

    public static int r(int i4, J j4, Y y4) {
        return (O(i4) * 2) + t(j4, y4);
    }

    public static int s(J j4) {
        return j4.getSerializedSize();
    }

    public static int t(J j4, Y y4) {
        return ((AbstractC0788a) j4).c(y4);
    }

    public static int u(int i4, int i5) {
        return O(i4) + v(i5);
    }

    public static int v(int i4) {
        return S(i4);
    }

    public static int w(int i4, long j4) {
        return O(i4) + x(j4);
    }

    public static int x(long j4) {
        return S(j4);
    }

    public static int y(int i4) {
        return Q(i4) + i4;
    }

    public static int z(int i4, J j4, Y y4) {
        return O(i4) + B(j4, y4);
    }

    public abstract void A0(int i4, J j4);

    public abstract void B0(int i4, AbstractC0793f abstractC0793f);

    public final void C0(int i4, int i5) {
        k0(i4, i5);
    }

    public final void D0(int i4) {
        l0(i4);
    }

    public final void E0(int i4, long j4) {
        m0(i4, j4);
    }

    public final void F0(long j4) {
        n0(j4);
    }

    public final void G0(int i4, int i5) {
        N0(i4, T(i5));
    }

    public final void H0(int i4) {
        O0(T(i4));
    }

    public final void I0(int i4, long j4) {
        P0(i4, U(j4));
    }

    public final void J0(long j4) {
        Q0(U(j4));
    }

    public abstract void K0(int i4, String str);

    public abstract void L0(String str);

    public abstract void M0(int i4, int i5);

    public abstract void N0(int i4, int i5);

    public abstract void O0(int i4);

    public abstract void P0(int i4, long j4);

    public abstract void Q0(long j4);

    public abstract void V();

    public final void W(String str, j0.d dVar) throws c {
        f7039c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(AbstractC0807u.f7208b);
        try {
            O0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e4) {
            throw new c(e4);
        }
    }

    public boolean X() {
        return this.f7042b;
    }

    public abstract void Z(byte b4);

    @Override // androidx.datastore.preferences.protobuf.AbstractC0792e
    public abstract void a(byte[] bArr, int i4, int i5);

    public abstract void a0(int i4, boolean z4);

    public final void b0(boolean z4) {
        Z(z4 ? (byte) 1 : (byte) 0);
    }

    public final void c0(byte[] bArr) {
        d0(bArr, 0, bArr.length);
    }

    public abstract void d0(byte[] bArr, int i4, int i5);

    public abstract void e0(int i4, AbstractC0793f abstractC0793f);

    public abstract void f0(AbstractC0793f abstractC0793f);

    public final void g0(int i4, double d4) {
        m0(i4, Double.doubleToRawLongBits(d4));
    }

    public final void h0(double d4) {
        n0(Double.doubleToRawLongBits(d4));
    }

    public final void i0(int i4, int i5) {
        u0(i4, i5);
    }

    public final void j0(int i4) {
        v0(i4);
    }

    public abstract void k0(int i4, int i5);

    public abstract void l0(int i4);

    public abstract void m0(int i4, long j4);

    public abstract void n0(long j4);

    public final void o0(int i4, float f4) {
        k0(i4, Float.floatToRawIntBits(f4));
    }

    public final void p0(float f4) {
        l0(Float.floatToRawIntBits(f4));
    }

    public final void q0(int i4, J j4) {
        M0(i4, 3);
        s0(j4);
        M0(i4, 4);
    }

    public final void r0(int i4, J j4, Y y4) {
        M0(i4, 3);
        t0(j4, y4);
        M0(i4, 4);
    }

    public final void s0(J j4) {
        j4.a(this);
    }

    public final void t0(J j4, Y y4) {
        y4.i(j4, this.f7041a);
    }

    public abstract void u0(int i4, int i5);

    public abstract void v0(int i4);

    public final void w0(int i4, long j4) {
        P0(i4, j4);
    }

    public final void x0(long j4) {
        Q0(j4);
    }

    public abstract void y0(int i4, J j4, Y y4);

    public abstract void z0(J j4);

    public AbstractC0796i() {
    }
}
