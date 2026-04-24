package s6;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: s6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2719f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f23148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23149b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OutputStream f23152e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23151d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23150c = 0;

    /* JADX INFO: renamed from: s6.f$a */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public C2719f(OutputStream outputStream, byte[] bArr) {
        this.f23152e = outputStream;
        this.f23148a = bArr;
        this.f23149b = bArr.length;
    }

    public static int A(long j8) {
        return v(G(j8));
    }

    public static int B(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return u(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException("UTF-8 not supported.", e8);
        }
    }

    public static int C(int i8) {
        return u(y.c(i8, 0));
    }

    public static int D(int i8) {
        return u(i8);
    }

    public static int E(long j8) {
        return v(j8);
    }

    public static int F(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long G(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static C2719f I(OutputStream outputStream, int i8) {
        return new C2719f(outputStream, new byte[i8]);
    }

    public static int a(int i8, boolean z7) {
        return C(i8) + b(z7);
    }

    public static int b(boolean z7) {
        return 1;
    }

    public static int c(byte[] bArr) {
        return u(bArr.length) + bArr.length;
    }

    public static int d(int i8, AbstractC2717d abstractC2717d) {
        return C(i8) + e(abstractC2717d);
    }

    public static int e(AbstractC2717d abstractC2717d) {
        return u(abstractC2717d.size()) + abstractC2717d.size();
    }

    public static int f(int i8, double d8) {
        return C(i8) + g(d8);
    }

    public static int g(double d8) {
        return 8;
    }

    public static int h(int i8, int i9) {
        return C(i8) + i(i9);
    }

    public static int i(int i8) {
        return p(i8);
    }

    public static int j(int i8) {
        return 4;
    }

    public static int k(long j8) {
        return 8;
    }

    public static int l(int i8, float f8) {
        return C(i8) + m(f8);
    }

    public static int m(float f8) {
        return 4;
    }

    public static int n(p pVar) {
        return pVar.c();
    }

    public static int o(int i8, int i9) {
        return C(i8) + p(i9);
    }

    public static int p(int i8) {
        if (i8 >= 0) {
            return u(i8);
        }
        return 10;
    }

    public static int q(long j8) {
        return v(j8);
    }

    public static int r(int i8, p pVar) {
        return C(i8) + s(pVar);
    }

    public static int s(p pVar) {
        int iC = pVar.c();
        return u(iC) + iC;
    }

    public static int t(int i8) {
        if (i8 > 4096) {
            return 4096;
        }
        return i8;
    }

    public static int u(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int v(long j8) {
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (((-16384) & j8) == 0) {
            return 2;
        }
        if (((-2097152) & j8) == 0) {
            return 3;
        }
        if (((-268435456) & j8) == 0) {
            return 4;
        }
        if (((-34359738368L) & j8) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j8) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j8) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j8) == 0) {
            return 8;
        }
        return (j8 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int w(int i8) {
        return 4;
    }

    public static int x(long j8) {
        return 8;
    }

    public static int y(int i8) {
        return u(F(i8));
    }

    public static int z(int i8, long j8) {
        return C(i8) + A(j8);
    }

    public void H() throws IOException {
        if (this.f23152e != null) {
            J();
        }
    }

    public final void J() throws IOException {
        OutputStream outputStream = this.f23152e;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f23148a, 0, this.f23150c);
        this.f23150c = 0;
    }

    public void K(int i8, boolean z7) throws IOException {
        v0(i8, 0);
        L(z7);
    }

    public void L(boolean z7) throws IOException {
        g0(z7 ? 1 : 0);
    }

    public void M(byte[] bArr) throws IOException {
        n0(bArr.length);
        j0(bArr);
    }

    public void N(int i8, AbstractC2717d abstractC2717d) {
        v0(i8, 2);
        O(abstractC2717d);
    }

    public void O(AbstractC2717d abstractC2717d) {
        n0(abstractC2717d.size());
        h0(abstractC2717d);
    }

    public void P(int i8, double d8) throws IOException {
        v0(i8, 1);
        Q(d8);
    }

    public void Q(double d8) throws IOException {
        m0(Double.doubleToRawLongBits(d8));
    }

    public void R(int i8, int i9) throws IOException {
        v0(i8, 0);
        S(i9);
    }

    public void S(int i8) throws IOException {
        a0(i8);
    }

    public void T(int i8) {
        l0(i8);
    }

    public void U(long j8) {
        m0(j8);
    }

    public void V(int i8, float f8) throws IOException {
        v0(i8, 5);
        W(f8);
    }

    public void W(float f8) throws IOException {
        l0(Float.floatToRawIntBits(f8));
    }

    public void X(int i8, p pVar) {
        v0(i8, 3);
        Y(pVar);
        v0(i8, 4);
    }

    public void Y(p pVar) {
        pVar.h(this);
    }

    public void Z(int i8, int i9) throws IOException {
        v0(i8, 0);
        a0(i9);
    }

    public void a0(int i8) throws IOException {
        if (i8 >= 0) {
            n0(i8);
        } else {
            o0(i8);
        }
    }

    public void b0(long j8) throws IOException {
        o0(j8);
    }

    public void c0(int i8, p pVar) {
        v0(i8, 2);
        d0(pVar);
    }

    public void d0(p pVar) {
        n0(pVar.c());
        pVar.h(this);
    }

    public void e0(int i8, p pVar) {
        v0(1, 3);
        w0(2, i8);
        c0(3, pVar);
        v0(1, 4);
    }

    public void f0(byte b8) throws IOException {
        if (this.f23150c == this.f23149b) {
            J();
        }
        byte[] bArr = this.f23148a;
        int i8 = this.f23150c;
        this.f23150c = i8 + 1;
        bArr[i8] = b8;
        this.f23151d++;
    }

    public void g0(int i8) throws IOException {
        f0((byte) i8);
    }

    public void h0(AbstractC2717d abstractC2717d) throws IOException {
        i0(abstractC2717d, 0, abstractC2717d.size());
    }

    public void i0(AbstractC2717d abstractC2717d, int i8, int i9) throws IOException {
        int i10 = this.f23149b;
        int i11 = this.f23150c;
        if (i10 - i11 >= i9) {
            abstractC2717d.C(this.f23148a, i8, i11, i9);
            this.f23150c += i9;
        } else {
            int i12 = i10 - i11;
            abstractC2717d.C(this.f23148a, i8, i11, i12);
            int i13 = i8 + i12;
            i9 -= i12;
            this.f23150c = this.f23149b;
            this.f23151d += i12;
            J();
            if (i9 <= this.f23149b) {
                abstractC2717d.C(this.f23148a, i13, 0, i9);
                this.f23150c = i9;
            } else {
                abstractC2717d.R(this.f23152e, i13, i9);
            }
        }
        this.f23151d += i9;
    }

    public void j0(byte[] bArr) throws IOException {
        k0(bArr, 0, bArr.length);
    }

    public void k0(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = this.f23149b;
        int i11 = this.f23150c;
        if (i10 - i11 >= i9) {
            System.arraycopy(bArr, i8, this.f23148a, i11, i9);
            this.f23150c += i9;
        } else {
            int i12 = i10 - i11;
            System.arraycopy(bArr, i8, this.f23148a, i11, i12);
            int i13 = i8 + i12;
            i9 -= i12;
            this.f23150c = this.f23149b;
            this.f23151d += i12;
            J();
            if (i9 <= this.f23149b) {
                System.arraycopy(bArr, i13, this.f23148a, 0, i9);
                this.f23150c = i9;
            } else {
                this.f23152e.write(bArr, i13, i9);
            }
        }
        this.f23151d += i9;
    }

    public void l0(int i8) throws IOException {
        g0(i8 & 255);
        g0((i8 >> 8) & 255);
        g0((i8 >> 16) & 255);
        g0((i8 >> 24) & 255);
    }

    public void m0(long j8) throws IOException {
        g0(((int) j8) & 255);
        g0(((int) (j8 >> 8)) & 255);
        g0(((int) (j8 >> 16)) & 255);
        g0(((int) (j8 >> 24)) & 255);
        g0(((int) (j8 >> 32)) & 255);
        g0(((int) (j8 >> 40)) & 255);
        g0(((int) (j8 >> 48)) & 255);
        g0(((int) (j8 >> 56)) & 255);
    }

    public void n0(int i8) {
        while ((i8 & (-128)) != 0) {
            g0((i8 & 127) | 128);
            i8 >>>= 7;
        }
        g0(i8);
    }

    public void o0(long j8) throws IOException {
        while (((-128) & j8) != 0) {
            g0((((int) j8) & 127) | 128);
            j8 >>>= 7;
        }
        g0((int) j8);
    }

    public void p0(int i8) throws IOException {
        l0(i8);
    }

    public void q0(long j8) throws IOException {
        m0(j8);
    }

    public void r0(int i8) {
        n0(F(i8));
    }

    public void s0(int i8, long j8) throws IOException {
        v0(i8, 0);
        t0(j8);
    }

    public void t0(long j8) throws IOException {
        o0(G(j8));
    }

    public void u0(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        n0(bytes.length);
        j0(bytes);
    }

    public void v0(int i8, int i9) {
        n0(y.c(i8, i9));
    }

    public void w0(int i8, int i9) {
        v0(i8, 0);
        x0(i9);
    }

    public void x0(int i8) {
        n0(i8);
    }

    public void y0(long j8) {
        o0(j8);
    }
}
