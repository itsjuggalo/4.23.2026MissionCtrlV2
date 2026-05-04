package com.google.protobuf;

import com.google.protobuf.z1;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f7076c = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7077d = y1.I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f7078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7079b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b extends l {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7080e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7082g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7083h;

        public b(int i10) {
            super();
            if (i10 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i10, 20)];
            this.f7080e = bArr;
            this.f7081f = bArr.length;
        }

        public final void W0(byte b10) {
            byte[] bArr = this.f7080e;
            int i10 = this.f7082g;
            this.f7082g = i10 + 1;
            bArr[i10] = b10;
            this.f7083h++;
        }

        public final void X0(int i10) {
            byte[] bArr = this.f7080e;
            int i11 = this.f7082g;
            int i12 = i11 + 1;
            this.f7082g = i12;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i11 + 2;
            this.f7082g = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i11 + 3;
            this.f7082g = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f7082g = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
            this.f7083h += 4;
        }

        public final void Y0(long j10) {
            byte[] bArr = this.f7080e;
            int i10 = this.f7082g;
            int i11 = i10 + 1;
            this.f7082g = i11;
            bArr[i10] = (byte) (j10 & 255);
            int i12 = i10 + 2;
            this.f7082g = i12;
            bArr[i11] = (byte) ((j10 >> 8) & 255);
            int i13 = i10 + 3;
            this.f7082g = i13;
            bArr[i12] = (byte) ((j10 >> 16) & 255);
            int i14 = i10 + 4;
            this.f7082g = i14;
            bArr[i13] = (byte) (255 & (j10 >> 24));
            int i15 = i10 + 5;
            this.f7082g = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i10 + 6;
            this.f7082g = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i10 + 7;
            this.f7082g = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f7082g = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            this.f7083h += 8;
        }

        public final void Z0(int i10) {
            if (i10 >= 0) {
                b1(i10);
            } else {
                c1(i10);
            }
        }

        public final void a1(int i10, int i11) {
            b1(a2.c(i10, i11));
        }

        public final void b1(int i10) {
            if (!l.f7077d) {
                while ((i10 & (-128)) != 0) {
                    byte[] bArr = this.f7080e;
                    int i11 = this.f7082g;
                    this.f7082g = i11 + 1;
                    bArr[i11] = (byte) ((i10 & 127) | 128);
                    this.f7083h++;
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.f7080e;
                int i12 = this.f7082g;
                this.f7082g = i12 + 1;
                bArr2[i12] = (byte) i10;
                this.f7083h++;
                return;
            }
            long j10 = this.f7082g;
            while ((i10 & (-128)) != 0) {
                byte[] bArr3 = this.f7080e;
                int i13 = this.f7082g;
                this.f7082g = i13 + 1;
                y1.O(bArr3, i13, (byte) ((i10 & 127) | 128));
                i10 >>>= 7;
            }
            byte[] bArr4 = this.f7080e;
            int i14 = this.f7082g;
            this.f7082g = i14 + 1;
            y1.O(bArr4, i14, (byte) i10);
            this.f7083h += (int) (((long) this.f7082g) - j10);
        }

        public final void c1(long j10) {
            if (!l.f7077d) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f7080e;
                    int i10 = this.f7082g;
                    this.f7082g = i10 + 1;
                    bArr[i10] = (byte) ((((int) j10) & 127) | 128);
                    this.f7083h++;
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f7080e;
                int i11 = this.f7082g;
                this.f7082g = i11 + 1;
                bArr2[i11] = (byte) j10;
                this.f7083h++;
                return;
            }
            long j11 = this.f7082g;
            while ((j10 & (-128)) != 0) {
                byte[] bArr3 = this.f7080e;
                int i12 = this.f7082g;
                this.f7082g = i12 + 1;
                y1.O(bArr3, i12, (byte) ((((int) j10) & 127) | 128));
                j10 >>>= 7;
            }
            byte[] bArr4 = this.f7080e;
            int i13 = this.f7082g;
            this.f7082g = i13 + 1;
            y1.O(bArr4, i13, (byte) j10);
            this.f7083h += (int) (((long) this.f7082g) - j11);
        }

        @Override // com.google.protobuf.l
        public final int d0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends IOException {
        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final OutputStream f7088i;

        public e(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f7088i = outputStream;
        }

        @Override // com.google.protobuf.l
        public void A0(int i10) throws IOException {
            if (i10 >= 0) {
                T0(i10);
            } else {
                V0(i10);
            }
        }

        @Override // com.google.protobuf.l
        public void D0(int i10, u0 u0Var, m1 m1Var) throws IOException {
            R0(i10, 2);
            i1(u0Var, m1Var);
        }

        @Override // com.google.protobuf.l
        public void E0(u0 u0Var) throws IOException {
            T0(u0Var.b());
            u0Var.g(this);
        }

        @Override // com.google.protobuf.l
        public void F0(int i10, u0 u0Var) throws IOException {
            R0(1, 3);
            S0(2, i10);
            h1(3, u0Var);
            R0(1, 4);
        }

        @Override // com.google.protobuf.l
        public void G0(int i10, i iVar) throws IOException {
            R0(1, 3);
            S0(2, i10);
            j0(3, iVar);
            R0(1, 4);
        }

        @Override // com.google.protobuf.l
        public void P0(int i10, String str) throws IOException {
            R0(i10, 2);
            Q0(str);
        }

        @Override // com.google.protobuf.l
        public void Q0(String str) throws IOException {
            int iJ;
            try {
                int length = str.length() * 3;
                int iS = l.S(length);
                int i10 = iS + length;
                int i11 = this.f7081f;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int i12 = z1.i(str, bArr, 0, length);
                    T0(i12);
                    b(bArr, 0, i12);
                    return;
                }
                if (i10 > i11 - this.f7082g) {
                    d1();
                }
                int iS2 = l.S(str.length());
                int i13 = this.f7082g;
                try {
                    if (iS2 == iS) {
                        int i14 = i13 + iS2;
                        this.f7082g = i14;
                        int i15 = z1.i(str, this.f7080e, i14, this.f7081f - i14);
                        this.f7082g = i13;
                        iJ = (i15 - i13) - iS2;
                        b1(iJ);
                        this.f7082g = i15;
                    } else {
                        iJ = z1.j(str);
                        b1(iJ);
                        this.f7082g = z1.i(str, this.f7080e, this.f7082g, iJ);
                    }
                    this.f7083h += iJ;
                } catch (z1.d e10) {
                    this.f7083h -= this.f7082g - i13;
                    this.f7082g = i13;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new d(e11);
                }
            } catch (z1.d e12) {
                Y(str, e12);
            }
        }

        @Override // com.google.protobuf.l
        public void R0(int i10, int i11) throws IOException {
            T0(a2.c(i10, i11));
        }

        @Override // com.google.protobuf.l
        public void S0(int i10, int i11) throws IOException {
            e1(20);
            a1(i10, 0);
            b1(i11);
        }

        @Override // com.google.protobuf.l
        public void T0(int i10) throws IOException {
            e1(5);
            b1(i10);
        }

        @Override // com.google.protobuf.l
        public void U0(int i10, long j10) throws IOException {
            e1(20);
            a1(i10, 0);
            c1(j10);
        }

        @Override // com.google.protobuf.l
        public void V0(long j10) throws IOException {
            e1(10);
            c1(j10);
        }

        @Override // com.google.protobuf.l
        public void X() throws IOException {
            if (this.f7082g > 0) {
                d1();
            }
        }

        @Override // com.google.protobuf.h
        public void a(ByteBuffer byteBuffer) throws IOException {
            f1(byteBuffer);
        }

        @Override // com.google.protobuf.l, com.google.protobuf.h
        public void b(byte[] bArr, int i10, int i11) throws IOException {
            g1(bArr, i10, i11);
        }

        public final void d1() throws IOException {
            this.f7088i.write(this.f7080e, 0, this.f7082g);
            this.f7082g = 0;
        }

        @Override // com.google.protobuf.l
        public void e0(byte b10) throws IOException {
            if (this.f7082g == this.f7081f) {
                d1();
            }
            W0(b10);
        }

        public final void e1(int i10) throws IOException {
            if (this.f7081f - this.f7082g < i10) {
                d1();
            }
        }

        @Override // com.google.protobuf.l
        public void f0(int i10, boolean z10) throws IOException {
            e1(11);
            a1(i10, 0);
            W0(z10 ? (byte) 1 : (byte) 0);
        }

        public void f1(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i10 = this.f7081f;
            int i11 = this.f7082g;
            if (i10 - i11 >= iRemaining) {
                byteBuffer.get(this.f7080e, i11, iRemaining);
                this.f7082g += iRemaining;
                this.f7083h += iRemaining;
                return;
            }
            int i12 = i10 - i11;
            byteBuffer.get(this.f7080e, i11, i12);
            int i13 = iRemaining - i12;
            this.f7082g = this.f7081f;
            this.f7083h += i12;
            d1();
            while (true) {
                int i14 = this.f7081f;
                if (i13 <= i14) {
                    byteBuffer.get(this.f7080e, 0, i13);
                    this.f7082g = i13;
                    this.f7083h += i13;
                    return;
                } else {
                    byteBuffer.get(this.f7080e, 0, i14);
                    this.f7088i.write(this.f7080e, 0, this.f7081f);
                    int i15 = this.f7081f;
                    i13 -= i15;
                    this.f7083h += i15;
                }
            }
        }

        public void g1(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f7081f;
            int i13 = this.f7082g;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.f7080e, i13, i11);
                this.f7082g += i11;
                this.f7083h += i11;
                return;
            }
            int i14 = i12 - i13;
            System.arraycopy(bArr, i10, this.f7080e, i13, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f7082g = this.f7081f;
            this.f7083h += i14;
            d1();
            if (i16 <= this.f7081f) {
                System.arraycopy(bArr, i15, this.f7080e, 0, i16);
                this.f7082g = i16;
            } else {
                this.f7088i.write(bArr, i15, i16);
            }
            this.f7083h += i16;
        }

        public void h1(int i10, u0 u0Var) throws IOException {
            R0(i10, 2);
            E0(u0Var);
        }

        @Override // com.google.protobuf.l
        public void i0(byte[] bArr, int i10, int i11) throws IOException {
            T0(i11);
            g1(bArr, i10, i11);
        }

        public void i1(u0 u0Var, m1 m1Var) throws IOException {
            T0(((com.google.protobuf.a) u0Var).l(m1Var));
            m1Var.h(u0Var, this.f7078a);
        }

        @Override // com.google.protobuf.l
        public void j0(int i10, i iVar) throws IOException {
            R0(i10, 2);
            k0(iVar);
        }

        @Override // com.google.protobuf.l
        public void k0(i iVar) throws IOException {
            T0(iVar.size());
            iVar.h0(this);
        }

        @Override // com.google.protobuf.l
        public void p0(int i10, int i11) throws IOException {
            e1(14);
            a1(i10, 5);
            X0(i11);
        }

        @Override // com.google.protobuf.l
        public void q0(int i10) throws IOException {
            e1(4);
            X0(i10);
        }

        @Override // com.google.protobuf.l
        public void r0(int i10, long j10) throws IOException {
            e1(18);
            a1(i10, 1);
            Y0(j10);
        }

        @Override // com.google.protobuf.l
        public void s0(long j10) throws IOException {
            e1(8);
            Y0(j10);
        }

        @Override // com.google.protobuf.l
        public void z0(int i10, int i11) throws IOException {
            e1(20);
            a1(i10, 0);
            Z0(i11);
        }
    }

    public static int A(int i10) {
        return S(i10) + i10;
    }

    public static int B(int i10, u0 u0Var, m1 m1Var) {
        return Q(i10) + D(u0Var, m1Var);
    }

    public static int C(u0 u0Var) {
        return A(u0Var.b());
    }

    public static int D(u0 u0Var, m1 m1Var) {
        return A(((com.google.protobuf.a) u0Var).l(m1Var));
    }

    public static int E(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int F(int i10, i iVar) {
        return (Q(1) * 2) + R(2, i10) + h(3, iVar);
    }

    public static int G(int i10, int i11) {
        return Q(i10) + H(i11);
    }

    public static int H(int i10) {
        return 4;
    }

    public static int I(int i10, long j10) {
        return Q(i10) + J(j10);
    }

    public static int J(long j10) {
        return 8;
    }

    public static int K(int i10, int i11) {
        return Q(i10) + L(i11);
    }

    public static int L(int i10) {
        return S(V(i10));
    }

    public static int M(int i10, long j10) {
        return Q(i10) + N(j10);
    }

    public static int N(long j10) {
        return U(W(j10));
    }

    public static int O(int i10, String str) {
        return Q(i10) + P(str);
    }

    public static int P(String str) {
        int length;
        try {
            length = z1.j(str);
        } catch (z1.d unused) {
            length = str.getBytes(c0.f6944b).length;
        }
        return A(length);
    }

    public static int Q(int i10) {
        return S(a2.c(i10, 0));
    }

    public static int R(int i10, int i11) {
        return Q(i10) + S(i11);
    }

    public static int S(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int T(int i10, long j10) {
        return Q(i10) + U(j10);
    }

    public static int U(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int V(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long W(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static l a0(OutputStream outputStream, int i10) {
        return new e(outputStream, i10);
    }

    public static l b0(byte[] bArr) {
        return c0(bArr, 0, bArr.length);
    }

    public static l c0(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static int e(int i10, boolean z10) {
        return Q(i10) + f(z10);
    }

    public static int f(boolean z10) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return A(bArr.length);
    }

    public static int h(int i10, i iVar) {
        return Q(i10) + i(iVar);
    }

    public static int i(i iVar) {
        return A(iVar.size());
    }

    public static int j(int i10, double d10) {
        return Q(i10) + k(d10);
    }

    public static int k(double d10) {
        return 8;
    }

    public static int l(int i10, int i11) {
        return Q(i10) + m(i11);
    }

    public static int m(int i10) {
        return x(i10);
    }

    public static int n(int i10, int i11) {
        return Q(i10) + o(i11);
    }

    public static int o(int i10) {
        return 4;
    }

    public static int p(int i10, long j10) {
        return Q(i10) + q(j10);
    }

    public static int q(long j10) {
        return 8;
    }

    public static int r(int i10, float f10) {
        return Q(i10) + s(f10);
    }

    public static int s(float f10) {
        return 4;
    }

    public static int t(int i10, u0 u0Var, m1 m1Var) {
        return (Q(i10) * 2) + v(u0Var, m1Var);
    }

    public static int u(u0 u0Var) {
        return u0Var.b();
    }

    public static int v(u0 u0Var, m1 m1Var) {
        return ((com.google.protobuf.a) u0Var).l(m1Var);
    }

    public static int w(int i10, int i11) {
        return Q(i10) + x(i11);
    }

    public static int x(int i10) {
        if (i10 >= 0) {
            return S(i10);
        }
        return 10;
    }

    public static int y(int i10, long j10) {
        return Q(i10) + z(j10);
    }

    public static int z(long j10) {
        return U(j10);
    }

    public abstract void A0(int i10);

    public final void B0(int i10, long j10) {
        U0(i10, j10);
    }

    public final void C0(long j10) {
        V0(j10);
    }

    public abstract void D0(int i10, u0 u0Var, m1 m1Var);

    public abstract void E0(u0 u0Var);

    public abstract void F0(int i10, u0 u0Var);

    public abstract void G0(int i10, i iVar);

    public final void H0(int i10, int i11) {
        p0(i10, i11);
    }

    public final void I0(int i10) {
        q0(i10);
    }

    public final void J0(int i10, long j10) {
        r0(i10, j10);
    }

    public final void K0(long j10) {
        s0(j10);
    }

    public final void L0(int i10, int i11) {
        S0(i10, V(i11));
    }

    public final void M0(int i10) {
        T0(V(i10));
    }

    public final void N0(int i10, long j10) {
        U0(i10, W(j10));
    }

    public final void O0(long j10) {
        V0(W(j10));
    }

    public abstract void P0(int i10, String str);

    public abstract void Q0(String str);

    public abstract void R0(int i10, int i11);

    public abstract void S0(int i10, int i11);

    public abstract void T0(int i10);

    public abstract void U0(int i10, long j10);

    public abstract void V0(long j10);

    public abstract void X();

    public final void Y(String str, z1.d dVar) throws d {
        f7076c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(c0.f6944b);
        try {
            T0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new d(e10);
        }
    }

    public boolean Z() {
        return this.f7079b;
    }

    @Override // com.google.protobuf.h
    public abstract void b(byte[] bArr, int i10, int i11);

    public final void d() {
        if (d0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int d0();

    public abstract void e0(byte b10);

    public abstract void f0(int i10, boolean z10);

    public final void g0(boolean z10) {
        e0(z10 ? (byte) 1 : (byte) 0);
    }

    public final void h0(byte[] bArr) {
        i0(bArr, 0, bArr.length);
    }

    public abstract void i0(byte[] bArr, int i10, int i11);

    public abstract void j0(int i10, i iVar);

    public abstract void k0(i iVar);

    public final void l0(int i10, double d10) {
        r0(i10, Double.doubleToRawLongBits(d10));
    }

    public final void m0(double d10) {
        s0(Double.doubleToRawLongBits(d10));
    }

    public final void n0(int i10, int i11) {
        z0(i10, i11);
    }

    public final void o0(int i10) {
        A0(i10);
    }

    public abstract void p0(int i10, int i11);

    public abstract void q0(int i10);

    public abstract void r0(int i10, long j10);

    public abstract void s0(long j10);

    public final void t0(int i10, float f10) {
        p0(i10, Float.floatToRawIntBits(f10));
    }

    public final void u0(float f10) {
        q0(Float.floatToRawIntBits(f10));
    }

    public final void v0(int i10, u0 u0Var) {
        R0(i10, 3);
        x0(u0Var);
        R0(i10, 4);
    }

    public final void w0(int i10, u0 u0Var, m1 m1Var) {
        R0(i10, 3);
        y0(u0Var, m1Var);
        R0(i10, 4);
    }

    public final void x0(u0 u0Var) {
        u0Var.g(this);
    }

    public final void y0(u0 u0Var, m1 m1Var) {
        m1Var.h(u0Var, this.f7078a);
    }

    public abstract void z0(int i10, int i11);

    public l() {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends l {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7084e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7085f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7086g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7087h;

        public c(byte[] bArr, int i10, int i11) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i12 = i10 + i11;
            if ((i10 | i11 | (bArr.length - i12)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            this.f7084e = bArr;
            this.f7085f = i10;
            this.f7087h = i10;
            this.f7086g = i12;
        }

        @Override // com.google.protobuf.l
        public final void A0(int i10) throws d {
            if (i10 >= 0) {
                T0(i10);
            } else {
                V0(i10);
            }
        }

        @Override // com.google.protobuf.l
        public final void D0(int i10, u0 u0Var, m1 m1Var) throws d {
            R0(i10, 2);
            T0(((com.google.protobuf.a) u0Var).l(m1Var));
            m1Var.h(u0Var, this.f7078a);
        }

        @Override // com.google.protobuf.l
        public final void E0(u0 u0Var) throws d {
            T0(u0Var.b());
            u0Var.g(this);
        }

        @Override // com.google.protobuf.l
        public final void F0(int i10, u0 u0Var) throws d {
            R0(1, 3);
            S0(2, i10);
            Y0(3, u0Var);
            R0(1, 4);
        }

        @Override // com.google.protobuf.l
        public final void G0(int i10, i iVar) throws d {
            R0(1, 3);
            S0(2, i10);
            j0(3, iVar);
            R0(1, 4);
        }

        @Override // com.google.protobuf.l
        public final void P0(int i10, String str) throws d {
            R0(i10, 2);
            Q0(str);
        }

        @Override // com.google.protobuf.l
        public final void Q0(String str) throws d {
            int i10 = this.f7087h;
            try {
                int iS = l.S(str.length() * 3);
                int iS2 = l.S(str.length());
                if (iS2 != iS) {
                    T0(z1.j(str));
                    this.f7087h = z1.i(str, this.f7084e, this.f7087h, d0());
                    return;
                }
                int i11 = i10 + iS2;
                this.f7087h = i11;
                int i12 = z1.i(str, this.f7084e, i11, d0());
                this.f7087h = i10;
                T0((i12 - i10) - iS2);
                this.f7087h = i12;
            } catch (z1.d e10) {
                this.f7087h = i10;
                Y(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new d(e11);
            }
        }

        @Override // com.google.protobuf.l
        public final void R0(int i10, int i11) throws d {
            T0(a2.c(i10, i11));
        }

        @Override // com.google.protobuf.l
        public final void S0(int i10, int i11) throws d {
            R0(i10, 0);
            T0(i11);
        }

        @Override // com.google.protobuf.l
        public final void T0(int i10) throws d {
            while ((i10 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f7084e;
                    int i11 = this.f7087h;
                    this.f7087h = i11 + 1;
                    bArr[i11] = (byte) ((i10 & 127) | 128);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), 1), e10);
                }
            }
            byte[] bArr2 = this.f7084e;
            int i12 = this.f7087h;
            this.f7087h = i12 + 1;
            bArr2[i12] = (byte) i10;
        }

        @Override // com.google.protobuf.l
        public final void U0(int i10, long j10) throws d {
            R0(i10, 0);
            V0(j10);
        }

        @Override // com.google.protobuf.l
        public final void V0(long j10) throws d {
            if (l.f7077d && d0() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f7084e;
                    int i10 = this.f7087h;
                    this.f7087h = i10 + 1;
                    y1.O(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f7084e;
                int i11 = this.f7087h;
                this.f7087h = i11 + 1;
                y1.O(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f7084e;
                    int i12 = this.f7087h;
                    this.f7087h = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), 1), e10);
                }
            }
            byte[] bArr4 = this.f7084e;
            int i13 = this.f7087h;
            this.f7087h = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        public final void W0(ByteBuffer byteBuffer) throws d {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f7084e, this.f7087h, iRemaining);
                this.f7087h += iRemaining;
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), Integer.valueOf(iRemaining)), e10);
            }
        }

        public final void X0(byte[] bArr, int i10, int i11) throws d {
            try {
                System.arraycopy(bArr, i10, this.f7084e, this.f7087h, i11);
                this.f7087h += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), Integer.valueOf(i11)), e10);
            }
        }

        public final void Y0(int i10, u0 u0Var) throws d {
            R0(i10, 2);
            E0(u0Var);
        }

        @Override // com.google.protobuf.h
        public final void a(ByteBuffer byteBuffer) throws d {
            W0(byteBuffer);
        }

        @Override // com.google.protobuf.l, com.google.protobuf.h
        public final void b(byte[] bArr, int i10, int i11) throws d {
            X0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.l
        public final int d0() {
            return this.f7086g - this.f7087h;
        }

        @Override // com.google.protobuf.l
        public final void e0(byte b10) throws d {
            try {
                byte[] bArr = this.f7084e;
                int i10 = this.f7087h;
                this.f7087h = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), 1), e10);
            }
        }

        @Override // com.google.protobuf.l
        public final void f0(int i10, boolean z10) throws d {
            R0(i10, 0);
            e0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.l
        public final void i0(byte[] bArr, int i10, int i11) throws d {
            T0(i11);
            X0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.l
        public final void j0(int i10, i iVar) throws d {
            R0(i10, 2);
            k0(iVar);
        }

        @Override // com.google.protobuf.l
        public final void k0(i iVar) throws d {
            T0(iVar.size());
            iVar.h0(this);
        }

        @Override // com.google.protobuf.l
        public final void p0(int i10, int i11) throws d {
            R0(i10, 5);
            q0(i11);
        }

        @Override // com.google.protobuf.l
        public final void q0(int i10) throws d {
            try {
                byte[] bArr = this.f7084e;
                int i11 = this.f7087h;
                int i12 = i11 + 1;
                this.f7087h = i12;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i11 + 2;
                this.f7087h = i13;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i11 + 3;
                this.f7087h = i14;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f7087h = i11 + 4;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), 1), e10);
            }
        }

        @Override // com.google.protobuf.l
        public final void r0(int i10, long j10) throws d {
            R0(i10, 1);
            s0(j10);
        }

        @Override // com.google.protobuf.l
        public final void s0(long j10) throws d {
            try {
                byte[] bArr = this.f7084e;
                int i10 = this.f7087h;
                int i11 = i10 + 1;
                this.f7087h = i11;
                bArr[i10] = (byte) (((int) j10) & 255);
                int i12 = i10 + 2;
                this.f7087h = i12;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
                int i13 = i10 + 3;
                this.f7087h = i13;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
                int i14 = i10 + 4;
                this.f7087h = i14;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
                int i15 = i10 + 5;
                this.f7087h = i15;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
                int i16 = i10 + 6;
                this.f7087h = i16;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
                int i17 = i10 + 7;
                this.f7087h = i17;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
                this.f7087h = i10 + 8;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7087h), Integer.valueOf(this.f7086g), 1), e10);
            }
        }

        @Override // com.google.protobuf.l
        public final void z0(int i10, int i11) throws d {
            R0(i10, 0);
            A0(i11);
        }

        @Override // com.google.protobuf.l
        public void X() {
        }
    }
}
