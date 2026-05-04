package com.google.protobuf;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f6970a = 100;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f6972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f6973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q f6974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6975e;

        public a(q qVar) {
            qVar.getClass();
            this.f6974d = qVar;
        }
    }

    public static int A(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        b0 b0Var = (b0) eVar;
        int I = I(bArr, i11, aVar);
        b0Var.e(j.c(aVar.f6971a));
        while (I < i12) {
            int I2 = I(bArr, I, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            I = I(bArr, I2, aVar);
            b0Var.e(j.c(aVar.f6971a));
        }
        return I;
    }

    public static int B(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        l0 l0Var = (l0) eVar;
        int iL = L(bArr, i11, aVar);
        l0Var.c(j.d(aVar.f6972b));
        while (iL < i12) {
            int I = I(bArr, iL, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            iL = L(bArr, I, aVar);
            l0Var.c(j.d(aVar.f6972b));
        }
        return iL;
    }

    public static int C(byte[] bArr, int i10, a aVar) throws d0 {
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a;
        if (i11 < 0) {
            throw d0.g();
        }
        if (i11 == 0) {
            aVar.f6973c = "";
            return I;
        }
        aVar.f6973c = new String(bArr, I, i11, c0.f6944b);
        return I + i11;
    }

    public static int D(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) throws d0 {
        int I = I(bArr, i11, aVar);
        int i13 = aVar.f6971a;
        if (i13 < 0) {
            throw d0.g();
        }
        if (i13 == 0) {
            eVar.add("");
        } else {
            eVar.add(new String(bArr, I, i13, c0.f6944b));
            I += i13;
        }
        while (I < i12) {
            int I2 = I(bArr, I, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i14 = aVar.f6971a;
            if (i14 < 0) {
                throw d0.g();
            }
            if (i14 == 0) {
                eVar.add("");
            } else {
                eVar.add(new String(bArr, I, i14, c0.f6944b));
                I += i14;
            }
        }
        return I;
    }

    public static int E(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) throws d0 {
        int I = I(bArr, i11, aVar);
        int i13 = aVar.f6971a;
        if (i13 < 0) {
            throw d0.g();
        }
        if (i13 == 0) {
            eVar.add("");
        } else {
            int i14 = I + i13;
            if (!z1.t(bArr, I, i14)) {
                throw d0.d();
            }
            eVar.add(new String(bArr, I, i13, c0.f6944b));
            I = i14;
        }
        while (I < i12) {
            int I2 = I(bArr, I, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i15 = aVar.f6971a;
            if (i15 < 0) {
                throw d0.g();
            }
            if (i15 == 0) {
                eVar.add("");
            } else {
                int i16 = I + i15;
                if (!z1.t(bArr, I, i16)) {
                    throw d0.d();
                }
                eVar.add(new String(bArr, I, i15, c0.f6944b));
                I = i16;
            }
        }
        return I;
    }

    public static int F(byte[] bArr, int i10, a aVar) throws d0 {
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a;
        if (i11 < 0) {
            throw d0.g();
        }
        if (i11 == 0) {
            aVar.f6973c = "";
            return I;
        }
        aVar.f6973c = z1.h(bArr, I, i11);
        return I + i11;
    }

    public static int G(int i10, byte[] bArr, int i11, int i12, v1 v1Var, a aVar) throws d0 {
        if (a2.a(i10) == 0) {
            throw d0.c();
        }
        int iB = a2.b(i10);
        if (iB == 0) {
            int iL = L(bArr, i11, aVar);
            v1Var.n(i10, Long.valueOf(aVar.f6972b));
            return iL;
        }
        if (iB == 1) {
            v1Var.n(i10, Long.valueOf(j(bArr, i11)));
            return i11 + 8;
        }
        if (iB == 2) {
            int I = I(bArr, i11, aVar);
            int i13 = aVar.f6971a;
            if (i13 < 0) {
                throw d0.g();
            }
            if (i13 > bArr.length - I) {
                throw d0.m();
            }
            if (i13 == 0) {
                v1Var.n(i10, i.f6998b);
            } else {
                v1Var.n(i10, i.s(bArr, I, i13));
            }
            return I + i13;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw d0.c();
            }
            v1Var.n(i10, Integer.valueOf(h(bArr, i11)));
            return i11 + 4;
        }
        v1 v1VarK = v1.k();
        int i14 = (i10 & (-8)) | 4;
        int i15 = aVar.f6975e + 1;
        aVar.f6975e = i15;
        a(i15);
        int i16 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int I2 = I(bArr, i11, aVar);
            i16 = aVar.f6971a;
            if (i16 == i14) {
                i11 = I2;
                break;
            }
            i11 = G(i16, bArr, I2, i12, v1VarK, aVar);
        }
        aVar.f6975e--;
        if (i11 > i12 || i16 != i14) {
            throw d0.h();
        }
        v1Var.n(i10, v1VarK);
        return i11;
    }

    public static int H(int i10, byte[] bArr, int i11, a aVar) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            aVar.f6971a = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            aVar.f6971a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            aVar.f6971a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            aVar.f6971a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                aVar.f6971a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int I(byte[] bArr, int i10, a aVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return H(b10, bArr, i11, aVar);
        }
        aVar.f6971a = b10;
        return i11;
    }

    public static int J(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        b0 b0Var = (b0) eVar;
        int I = I(bArr, i11, aVar);
        b0Var.e(aVar.f6971a);
        while (I < i12) {
            int I2 = I(bArr, I, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            I = I(bArr, I2, aVar);
            b0Var.e(aVar.f6971a);
        }
        return I;
    }

    public static int K(long j10, byte[] bArr, int i10, a aVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        long j11 = (j10 & 127) | (((long) (b10 & 127)) << 7);
        int i12 = 7;
        while (b10 < 0) {
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            i12 += 7;
            j11 |= ((long) (b11 & 127)) << i12;
            i11 = i13;
            b10 = b11;
        }
        aVar.f6972b = j11;
        return i11;
    }

    public static int L(byte[] bArr, int i10, a aVar) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 < 0) {
            return K(j10, bArr, i11, aVar);
        }
        aVar.f6972b = j10;
        return i11;
    }

    public static int M(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        l0 l0Var = (l0) eVar;
        int iL = L(bArr, i11, aVar);
        l0Var.c(aVar.f6972b);
        while (iL < i12) {
            int I = I(bArr, iL, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            iL = L(bArr, I, aVar);
            l0Var.c(aVar.f6972b);
        }
        return iL;
    }

    public static int N(Object obj, m1 m1Var, byte[] bArr, int i10, int i11, int i12, a aVar) throws d0 {
        int i13 = aVar.f6975e + 1;
        aVar.f6975e = i13;
        a(i13);
        int iE0 = ((x0) m1Var).e0(obj, bArr, i10, i11, i12, aVar);
        aVar.f6975e--;
        aVar.f6973c = obj;
        return iE0;
    }

    public static int O(Object obj, m1 m1Var, byte[] bArr, int i10, int i11, a aVar) throws d0 {
        int iH = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iH = H(i12, bArr, iH, aVar);
            i12 = aVar.f6971a;
        }
        int i13 = iH;
        if (i12 < 0 || i12 > i11 - i13) {
            throw d0.m();
        }
        int i14 = aVar.f6975e + 1;
        aVar.f6975e = i14;
        a(i14);
        int i15 = i13 + i12;
        m1Var.j(obj, bArr, i13, i15, aVar);
        aVar.f6975e--;
        aVar.f6973c = obj;
        return i15;
    }

    public static int P(int i10, byte[] bArr, int i11, int i12, a aVar) throws d0 {
        if (a2.a(i10) == 0) {
            throw d0.c();
        }
        int iB = a2.b(i10);
        if (iB == 0) {
            return L(bArr, i11, aVar);
        }
        if (iB == 1) {
            return i11 + 8;
        }
        if (iB == 2) {
            return I(bArr, i11, aVar) + aVar.f6971a;
        }
        if (iB != 3) {
            if (iB == 5) {
                return i11 + 4;
            }
            throw d0.c();
        }
        int i13 = (i10 & (-8)) | 4;
        int i14 = 0;
        while (i11 < i12) {
            i11 = I(bArr, i11, aVar);
            i14 = aVar.f6971a;
            if (i14 == i13) {
                break;
            }
            i11 = P(i14, bArr, i11, i12, aVar);
        }
        if (i11 > i12 || i14 != i13) {
            throw d0.h();
        }
        return i11;
    }

    public static void a(int i10) throws d0 {
        if (i10 >= f6970a) {
            throw d0.i();
        }
    }

    public static int b(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        g gVar = (g) eVar;
        int iL = L(bArr, i11, aVar);
        gVar.c(aVar.f6972b != 0);
        while (iL < i12) {
            int I = I(bArr, iL, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            iL = L(bArr, I, aVar);
            gVar.c(aVar.f6972b != 0);
        }
        return iL;
    }

    public static int c(byte[] bArr, int i10, a aVar) throws d0 {
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a;
        if (i11 < 0) {
            throw d0.g();
        }
        if (i11 > bArr.length - I) {
            throw d0.m();
        }
        if (i11 == 0) {
            aVar.f6973c = i.f6998b;
            return I;
        }
        aVar.f6973c = i.s(bArr, I, i11);
        return I + i11;
    }

    public static int d(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) throws d0 {
        int I = I(bArr, i11, aVar);
        int i13 = aVar.f6971a;
        if (i13 < 0) {
            throw d0.g();
        }
        if (i13 > bArr.length - I) {
            throw d0.m();
        }
        if (i13 == 0) {
            eVar.add(i.f6998b);
        } else {
            eVar.add(i.s(bArr, I, i13));
            I += i13;
        }
        while (I < i12) {
            int I2 = I(bArr, I, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i14 = aVar.f6971a;
            if (i14 < 0) {
                throw d0.g();
            }
            if (i14 > bArr.length - I) {
                throw d0.m();
            }
            if (i14 == 0) {
                eVar.add(i.f6998b);
            } else {
                eVar.add(i.s(bArr, I, i14));
                I += i14;
            }
        }
        return I;
    }

    public static double e(byte[] bArr, int i10) {
        return Double.longBitsToDouble(j(bArr, i10));
    }

    public static int f(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        n nVar = (n) eVar;
        nVar.c(e(bArr, i11));
        int i13 = i11 + 8;
        while (i13 < i12) {
            int I = I(bArr, i13, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            nVar.c(e(bArr, I));
            i13 = I + 8;
        }
        return i13;
    }

    public static int g(int i10, byte[] bArr, int i11, int i12, Object obj, u0 u0Var, u1 u1Var, a aVar) {
        aVar.f6974d.a(u0Var, i10 >>> 3);
        return G(i10, bArr, i11, i12, x0.x(obj), aVar);
    }

    public static int h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static int i(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        b0 b0Var = (b0) eVar;
        b0Var.e(h(bArr, i11));
        int i13 = i11 + 4;
        while (i13 < i12) {
            int I = I(bArr, i13, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            b0Var.e(h(bArr, I));
            i13 = I + 4;
        }
        return i13;
    }

    public static long j(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    public static int k(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        l0 l0Var = (l0) eVar;
        l0Var.c(j(bArr, i11));
        int i13 = i11 + 8;
        while (i13 < i12) {
            int I = I(bArr, i13, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            l0Var.c(j(bArr, I));
            i13 = I + 8;
        }
        return i13;
    }

    public static float l(byte[] bArr, int i10) {
        return Float.intBitsToFloat(h(bArr, i10));
    }

    public static int m(int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) {
        w wVar = (w) eVar;
        wVar.c(l(bArr, i11));
        int i13 = i11 + 4;
        while (i13 < i12) {
            int I = I(bArr, i13, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            wVar.c(l(bArr, I));
            i13 = I + 4;
        }
        return i13;
    }

    public static int n(m1 m1Var, byte[] bArr, int i10, int i11, int i12, a aVar) throws d0 {
        Object objF = m1Var.f();
        int iN = N(objF, m1Var, bArr, i10, i11, i12, aVar);
        m1Var.b(objF);
        aVar.f6973c = objF;
        return iN;
    }

    public static int o(m1 m1Var, int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) throws d0 {
        int i13 = (i10 & (-8)) | 4;
        int iN = n(m1Var, bArr, i11, i12, i13, aVar);
        eVar.add(aVar.f6973c);
        while (iN < i12) {
            int I = I(bArr, iN, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            iN = n(m1Var, bArr, I, i12, i13, aVar);
            eVar.add(aVar.f6973c);
        }
        return iN;
    }

    public static int p(m1 m1Var, byte[] bArr, int i10, int i11, a aVar) throws d0 {
        Object objF = m1Var.f();
        int iO = O(objF, m1Var, bArr, i10, i11, aVar);
        m1Var.b(objF);
        aVar.f6973c = objF;
        return iO;
    }

    public static int q(m1 m1Var, int i10, byte[] bArr, int i11, int i12, c0.e eVar, a aVar) throws d0 {
        int iP = p(m1Var, bArr, i11, i12, aVar);
        eVar.add(aVar.f6973c);
        while (iP < i12) {
            int I = I(bArr, iP, aVar);
            if (i10 != aVar.f6971a) {
                break;
            }
            iP = p(m1Var, bArr, I, i12, aVar);
            eVar.add(aVar.f6973c);
        }
        return iP;
    }

    public static int r(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        g gVar = (g) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            I = L(bArr, I, aVar);
            gVar.c(aVar.f6972b != 0);
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int s(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        n nVar = (n) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            nVar.c(e(bArr, I));
            I += 8;
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int t(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        b0 b0Var = (b0) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            b0Var.e(h(bArr, I));
            I += 4;
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int u(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        l0 l0Var = (l0) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            l0Var.c(j(bArr, I));
            I += 8;
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int v(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        w wVar = (w) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            wVar.c(l(bArr, I));
            I += 4;
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int w(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        b0 b0Var = (b0) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            I = I(bArr, I, aVar);
            b0Var.e(j.c(aVar.f6971a));
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int x(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        l0 l0Var = (l0) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            I = L(bArr, I, aVar);
            l0Var.c(j.d(aVar.f6972b));
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int y(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        b0 b0Var = (b0) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            I = I(bArr, I, aVar);
            b0Var.e(aVar.f6971a);
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }

    public static int z(byte[] bArr, int i10, c0.e eVar, a aVar) throws d0 {
        l0 l0Var = (l0) eVar;
        int I = I(bArr, i10, aVar);
        int i11 = aVar.f6971a + I;
        while (I < i11) {
            I = L(bArr, I, aVar);
            l0Var.c(aVar.f6972b);
        }
        if (I == i11) {
            return I;
        }
        throw d0.m();
    }
}
