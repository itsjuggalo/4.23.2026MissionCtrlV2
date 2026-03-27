package com.google.protobuf;

import com.google.protobuf.C;

/* JADX INFO: renamed from: com.google.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1059f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f11011a = 100;

    /* JADX INFO: renamed from: com.google.protobuf.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f11014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C1070q f11015d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11016e;

        public a(C1070q c1070q) {
            c1070q.getClass();
            this.f11015d = c1070q;
        }
    }

    public static int A(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        B b4 = (B) iVar;
        int I4 = I(bArr, i5, aVar);
        b4.k(AbstractC1063j.c(aVar.f11012a));
        while (I4 < i6) {
            int I5 = I(bArr, I4, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            I4 = I(bArr, I5, aVar);
            b4.k(AbstractC1063j.c(aVar.f11012a));
        }
        return I4;
    }

    public static int B(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        M m4 = (M) iVar;
        int iL = L(bArr, i5, aVar);
        m4.l(AbstractC1063j.d(aVar.f11013b));
        while (iL < i6) {
            int I4 = I(bArr, iL, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            iL = L(bArr, I4, aVar);
            m4.l(AbstractC1063j.d(aVar.f11013b));
        }
        return iL;
    }

    public static int C(byte[] bArr, int i4, a aVar) throws D {
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a;
        if (i5 < 0) {
            throw D.g();
        }
        if (i5 == 0) {
            aVar.f11014c = "";
            return I4;
        }
        aVar.f11014c = new String(bArr, I4, i5, C.f10882b);
        return I4 + i5;
    }

    public static int D(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) throws D {
        int I4 = I(bArr, i5, aVar);
        int i7 = aVar.f11012a;
        if (i7 < 0) {
            throw D.g();
        }
        if (i7 == 0) {
            iVar.add("");
        } else {
            iVar.add(new String(bArr, I4, i7, C.f10882b));
            I4 += i7;
        }
        while (I4 < i6) {
            int I5 = I(bArr, I4, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            I4 = I(bArr, I5, aVar);
            int i8 = aVar.f11012a;
            if (i8 < 0) {
                throw D.g();
            }
            if (i8 == 0) {
                iVar.add("");
            } else {
                iVar.add(new String(bArr, I4, i8, C.f10882b));
                I4 += i8;
            }
        }
        return I4;
    }

    public static int E(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) throws D {
        int I4 = I(bArr, i5, aVar);
        int i7 = aVar.f11012a;
        if (i7 < 0) {
            throw D.g();
        }
        if (i7 == 0) {
            iVar.add("");
        } else {
            int i8 = I4 + i7;
            if (!B0.t(bArr, I4, i8)) {
                throw D.d();
            }
            iVar.add(new String(bArr, I4, i7, C.f10882b));
            I4 = i8;
        }
        while (I4 < i6) {
            int I5 = I(bArr, I4, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            I4 = I(bArr, I5, aVar);
            int i9 = aVar.f11012a;
            if (i9 < 0) {
                throw D.g();
            }
            if (i9 == 0) {
                iVar.add("");
            } else {
                int i10 = I4 + i9;
                if (!B0.t(bArr, I4, i10)) {
                    throw D.d();
                }
                iVar.add(new String(bArr, I4, i9, C.f10882b));
                I4 = i10;
            }
        }
        return I4;
    }

    public static int F(byte[] bArr, int i4, a aVar) throws D {
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a;
        if (i5 < 0) {
            throw D.g();
        }
        if (i5 == 0) {
            aVar.f11014c = "";
            return I4;
        }
        aVar.f11014c = B0.h(bArr, I4, i5);
        return I4 + i5;
    }

    public static int G(int i4, byte[] bArr, int i5, int i6, x0 x0Var, a aVar) throws D {
        if (C0.a(i4) == 0) {
            throw D.c();
        }
        int iB = C0.b(i4);
        if (iB == 0) {
            int iL = L(bArr, i5, aVar);
            x0Var.r(i4, Long.valueOf(aVar.f11013b));
            return iL;
        }
        if (iB == 1) {
            x0Var.r(i4, Long.valueOf(j(bArr, i5)));
            return i5 + 8;
        }
        if (iB == 2) {
            int I4 = I(bArr, i5, aVar);
            int i7 = aVar.f11012a;
            if (i7 < 0) {
                throw D.g();
            }
            if (i7 > bArr.length - I4) {
                throw D.m();
            }
            if (i7 == 0) {
                x0Var.r(i4, AbstractC1062i.f11025b);
            } else {
                x0Var.r(i4, AbstractC1062i.q(bArr, I4, i7));
            }
            return I4 + i7;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw D.c();
            }
            x0Var.r(i4, Integer.valueOf(h(bArr, i5)));
            return i5 + 4;
        }
        x0 x0VarO = x0.o();
        int i8 = (i4 & (-8)) | 4;
        int i9 = aVar.f11016e + 1;
        aVar.f11016e = i9;
        a(i9);
        int i10 = 0;
        while (true) {
            if (i5 >= i6) {
                break;
            }
            int I5 = I(bArr, i5, aVar);
            i10 = aVar.f11012a;
            if (i10 == i8) {
                i5 = I5;
                break;
            }
            i5 = G(i10, bArr, I5, i6, x0VarO, aVar);
        }
        aVar.f11016e--;
        if (i5 > i6 || i10 != i8) {
            throw D.h();
        }
        x0Var.r(i4, x0VarO);
        return i5;
    }

    public static int H(int i4, byte[] bArr, int i5, a aVar) {
        int i6 = i4 & 127;
        int i7 = i5 + 1;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            aVar.f11012a = i6 | (b4 << 7);
            return i7;
        }
        int i8 = i6 | ((b4 & 127) << 7);
        int i9 = i5 + 2;
        byte b5 = bArr[i7];
        if (b5 >= 0) {
            aVar.f11012a = i8 | (b5 << 14);
            return i9;
        }
        int i10 = i8 | ((b5 & 127) << 14);
        int i11 = i5 + 3;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            aVar.f11012a = i10 | (b6 << 21);
            return i11;
        }
        int i12 = i10 | ((b6 & 127) << 21);
        int i13 = i5 + 4;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            aVar.f11012a = i12 | (b7 << 28);
            return i13;
        }
        int i14 = i12 | ((b7 & 127) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] >= 0) {
                aVar.f11012a = i14;
                return i15;
            }
            i13 = i15;
        }
    }

    public static int I(byte[] bArr, int i4, a aVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 < 0) {
            return H(b4, bArr, i5, aVar);
        }
        aVar.f11012a = b4;
        return i5;
    }

    public static int J(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        B b4 = (B) iVar;
        int I4 = I(bArr, i5, aVar);
        b4.k(aVar.f11012a);
        while (I4 < i6) {
            int I5 = I(bArr, I4, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            I4 = I(bArr, I5, aVar);
            b4.k(aVar.f11012a);
        }
        return I4;
    }

    public static int K(long j4, byte[] bArr, int i4, a aVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        long j5 = (j4 & 127) | (((long) (b4 & 127)) << 7);
        int i6 = 7;
        while (b4 < 0) {
            int i7 = i5 + 1;
            byte b5 = bArr[i5];
            i6 += 7;
            j5 |= ((long) (b5 & 127)) << i6;
            i5 = i7;
            b4 = b5;
        }
        aVar.f11013b = j5;
        return i5;
    }

    public static int L(byte[] bArr, int i4, a aVar) {
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        if (j4 < 0) {
            return K(j4, bArr, i5, aVar);
        }
        aVar.f11013b = j4;
        return i5;
    }

    public static int M(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        M m4 = (M) iVar;
        int iL = L(bArr, i5, aVar);
        m4.l(aVar.f11013b);
        while (iL < i6) {
            int I4 = I(bArr, iL, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            iL = L(bArr, I4, aVar);
            m4.l(aVar.f11013b);
        }
        return iL;
    }

    public static int N(Object obj, o0 o0Var, byte[] bArr, int i4, int i5, int i6, a aVar) throws D {
        int i7 = aVar.f11016e + 1;
        aVar.f11016e = i7;
        a(i7);
        int iD0 = ((Z) o0Var).d0(obj, bArr, i4, i5, i6, aVar);
        aVar.f11016e--;
        aVar.f11014c = obj;
        return iD0;
    }

    public static int O(Object obj, o0 o0Var, byte[] bArr, int i4, int i5, a aVar) throws D {
        int iH = i4 + 1;
        int i6 = bArr[i4];
        if (i6 < 0) {
            iH = H(i6, bArr, iH, aVar);
            i6 = aVar.f11012a;
        }
        int i7 = iH;
        if (i6 < 0 || i6 > i5 - i7) {
            throw D.m();
        }
        int i8 = aVar.f11016e + 1;
        aVar.f11016e = i8;
        a(i8);
        int i9 = i7 + i6;
        o0Var.j(obj, bArr, i7, i9, aVar);
        aVar.f11016e--;
        aVar.f11014c = obj;
        return i9;
    }

    public static int P(int i4, byte[] bArr, int i5, int i6, a aVar) throws D {
        if (C0.a(i4) == 0) {
            throw D.c();
        }
        int iB = C0.b(i4);
        if (iB == 0) {
            return L(bArr, i5, aVar);
        }
        if (iB == 1) {
            return i5 + 8;
        }
        if (iB == 2) {
            return I(bArr, i5, aVar) + aVar.f11012a;
        }
        if (iB != 3) {
            if (iB == 5) {
                return i5 + 4;
            }
            throw D.c();
        }
        int i7 = (i4 & (-8)) | 4;
        int i8 = 0;
        while (i5 < i6) {
            i5 = I(bArr, i5, aVar);
            i8 = aVar.f11012a;
            if (i8 == i7) {
                break;
            }
            i5 = P(i8, bArr, i5, i6, aVar);
        }
        if (i5 > i6 || i8 != i7) {
            throw D.h();
        }
        return i5;
    }

    public static void a(int i4) throws D {
        if (i4 >= f11011a) {
            throw D.i();
        }
    }

    public static int b(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        C1060g c1060g = (C1060g) iVar;
        int iL = L(bArr, i5, aVar);
        c1060g.l(aVar.f11013b != 0);
        while (iL < i6) {
            int I4 = I(bArr, iL, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            iL = L(bArr, I4, aVar);
            c1060g.l(aVar.f11013b != 0);
        }
        return iL;
    }

    public static int c(byte[] bArr, int i4, a aVar) throws D {
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a;
        if (i5 < 0) {
            throw D.g();
        }
        if (i5 > bArr.length - I4) {
            throw D.m();
        }
        if (i5 == 0) {
            aVar.f11014c = AbstractC1062i.f11025b;
            return I4;
        }
        aVar.f11014c = AbstractC1062i.q(bArr, I4, i5);
        return I4 + i5;
    }

    public static int d(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) throws D {
        int I4 = I(bArr, i5, aVar);
        int i7 = aVar.f11012a;
        if (i7 < 0) {
            throw D.g();
        }
        if (i7 > bArr.length - I4) {
            throw D.m();
        }
        if (i7 == 0) {
            iVar.add(AbstractC1062i.f11025b);
        } else {
            iVar.add(AbstractC1062i.q(bArr, I4, i7));
            I4 += i7;
        }
        while (I4 < i6) {
            int I5 = I(bArr, I4, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            I4 = I(bArr, I5, aVar);
            int i8 = aVar.f11012a;
            if (i8 < 0) {
                throw D.g();
            }
            if (i8 > bArr.length - I4) {
                throw D.m();
            }
            if (i8 == 0) {
                iVar.add(AbstractC1062i.f11025b);
            } else {
                iVar.add(AbstractC1062i.q(bArr, I4, i8));
                I4 += i8;
            }
        }
        return I4;
    }

    public static double e(byte[] bArr, int i4) {
        return Double.longBitsToDouble(j(bArr, i4));
    }

    public static int f(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        C1067n c1067n = (C1067n) iVar;
        c1067n.k(e(bArr, i5));
        int i7 = i5 + 8;
        while (i7 < i6) {
            int I4 = I(bArr, i7, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            c1067n.k(e(bArr, I4));
            i7 = I4 + 8;
        }
        return i7;
    }

    public static int g(int i4, byte[] bArr, int i5, int i6, Object obj, W w4, w0 w0Var, a aVar) {
        if (aVar.f11015d.a(w4, i4 >>> 3) == null) {
            return G(i4, bArr, i5, i6, Z.w(obj), aVar);
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    public static int h(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    public static int i(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        B b4 = (B) iVar;
        b4.k(h(bArr, i5));
        int i7 = i5 + 4;
        while (i7 < i6) {
            int I4 = I(bArr, i7, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            b4.k(h(bArr, I4));
            i7 = I4 + 4;
        }
        return i7;
    }

    public static long j(byte[] bArr, int i4) {
        return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
    }

    public static int k(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        M m4 = (M) iVar;
        m4.l(j(bArr, i5));
        int i7 = i5 + 8;
        while (i7 < i6) {
            int I4 = I(bArr, i7, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            m4.l(j(bArr, I4));
            i7 = I4 + 8;
        }
        return i7;
    }

    public static float l(byte[] bArr, int i4) {
        return Float.intBitsToFloat(h(bArr, i4));
    }

    public static int m(int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) {
        C1075w c1075w = (C1075w) iVar;
        c1075w.k(l(bArr, i5));
        int i7 = i5 + 4;
        while (i7 < i6) {
            int I4 = I(bArr, i7, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            c1075w.k(l(bArr, I4));
            i7 = I4 + 4;
        }
        return i7;
    }

    public static int n(o0 o0Var, byte[] bArr, int i4, int i5, int i6, a aVar) throws D {
        Object objF = o0Var.f();
        int iN = N(objF, o0Var, bArr, i4, i5, i6, aVar);
        o0Var.b(objF);
        aVar.f11014c = objF;
        return iN;
    }

    public static int o(o0 o0Var, int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) throws D {
        int i7 = (i4 & (-8)) | 4;
        int iN = n(o0Var, bArr, i5, i6, i7, aVar);
        iVar.add(aVar.f11014c);
        while (iN < i6) {
            int I4 = I(bArr, iN, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            iN = n(o0Var, bArr, I4, i6, i7, aVar);
            iVar.add(aVar.f11014c);
        }
        return iN;
    }

    public static int p(o0 o0Var, byte[] bArr, int i4, int i5, a aVar) throws D {
        Object objF = o0Var.f();
        int iO = O(objF, o0Var, bArr, i4, i5, aVar);
        o0Var.b(objF);
        aVar.f11014c = objF;
        return iO;
    }

    public static int q(o0 o0Var, int i4, byte[] bArr, int i5, int i6, C.i iVar, a aVar) throws D {
        int iP = p(o0Var, bArr, i5, i6, aVar);
        iVar.add(aVar.f11014c);
        while (iP < i6) {
            int I4 = I(bArr, iP, aVar);
            if (i4 != aVar.f11012a) {
                break;
            }
            iP = p(o0Var, bArr, I4, i6, aVar);
            iVar.add(aVar.f11014c);
        }
        return iP;
    }

    public static int r(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        C1060g c1060g = (C1060g) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            I4 = L(bArr, I4, aVar);
            c1060g.l(aVar.f11013b != 0);
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int s(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        C1067n c1067n = (C1067n) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            c1067n.k(e(bArr, I4));
            I4 += 8;
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int t(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        B b4 = (B) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            b4.k(h(bArr, I4));
            I4 += 4;
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int u(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        M m4 = (M) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            m4.l(j(bArr, I4));
            I4 += 8;
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int v(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        C1075w c1075w = (C1075w) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            c1075w.k(l(bArr, I4));
            I4 += 4;
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int w(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        B b4 = (B) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            I4 = I(bArr, I4, aVar);
            b4.k(AbstractC1063j.c(aVar.f11012a));
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int x(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        M m4 = (M) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            I4 = L(bArr, I4, aVar);
            m4.l(AbstractC1063j.d(aVar.f11013b));
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int y(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        B b4 = (B) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            I4 = I(bArr, I4, aVar);
            b4.k(aVar.f11012a);
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }

    public static int z(byte[] bArr, int i4, C.i iVar, a aVar) throws D {
        M m4 = (M) iVar;
        int I4 = I(bArr, i4, aVar);
        int i5 = aVar.f11012a + I4;
        while (I4 < i5) {
            I4 = L(bArr, I4, aVar);
            m4.l(aVar.f11013b);
        }
        if (I4 == i5) {
            return I4;
        }
        throw D.m();
    }
}
