package y;

import z.AbstractC1962a;

/* JADX INFO: renamed from: y.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1926a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f15798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f15799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f15800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f15801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f15802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f15803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f15804i;

    public C1926a(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.f15796a = f4;
        this.f15797b = f5;
        this.f15798c = f6;
        this.f15799d = f7;
        this.f15800e = f8;
        this.f15801f = f9;
        this.f15802g = f10;
        this.f15803h = f11;
        this.f15804i = f12;
    }

    public static C1926a b(float f4, float f5, float f6) {
        float f7 = 100.0f;
        float f8 = 1000.0f;
        float f9 = 0.0f;
        C1926a c1926a = null;
        float f10 = 1000.0f;
        while (Math.abs(f9 - f7) > 0.01f) {
            float f11 = ((f7 - f9) / 2.0f) + f9;
            int iP = e(f11, f5, f4).p();
            float fB = AbstractC1927b.b(iP);
            float fAbs = Math.abs(f6 - fB);
            if (fAbs < 0.2f) {
                C1926a c1926aC = c(iP);
                float fA = c1926aC.a(e(c1926aC.k(), c1926aC.i(), f4));
                if (fA <= 1.0f) {
                    c1926a = c1926aC;
                    f8 = fAbs;
                    f10 = fA;
                }
            }
            if (f8 == 0.0f && f10 == 0.0f) {
                return c1926a;
            }
            if (fB < f6) {
                f9 = f11;
            } else {
                f7 = f11;
            }
        }
        return c1926a;
    }

    public static C1926a c(int i4) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i4, C1935j.f15833k, fArr, fArr2);
        return new C1926a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void d(int i4, C1935j c1935j, float[] fArr, float[] fArr2) {
        AbstractC1927b.f(i4, fArr2);
        float[][] fArr3 = AbstractC1927b.f15805a;
        float f4 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f5 = fArr4[0] * f4;
        float f6 = fArr2[1];
        float f7 = f5 + (fArr4[1] * f6);
        float f8 = fArr2[2];
        float f9 = f7 + (fArr4[2] * f8);
        float[] fArr5 = fArr3[1];
        float f10 = (fArr5[0] * f4) + (fArr5[1] * f6) + (fArr5[2] * f8);
        float[] fArr6 = fArr3[2];
        float f11 = (f4 * fArr6[0]) + (f6 * fArr6[1]) + (f8 * fArr6[2]);
        float f12 = c1935j.i()[0] * f9;
        float f13 = c1935j.i()[1] * f10;
        float f14 = c1935j.i()[2] * f11;
        float fPow = (float) Math.pow(((double) (c1935j.c() * Math.abs(f12))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (c1935j.c() * Math.abs(f13))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (c1935j.c() * Math.abs(f14))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f12) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f13) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f14) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d4 = fSignum3;
        float f15 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d4)) / 11.0f;
        float f16 = ((float) (((double) (fSignum + fSignum2)) - (d4 * 2.0d))) / 9.0f;
        float f17 = fSignum2 * 20.0f;
        float f18 = (((fSignum * 20.0f) + f17) + (21.0f * fSignum3)) / 20.0f;
        float f19 = (((fSignum * 40.0f) + f17) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f16, f15)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f20 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f19 * c1935j.f()) / c1935j.a(), c1935j.b() * c1935j.j())) * 100.0f;
        float fB = (4.0f / c1935j.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (c1935j.a() + 4.0f) * c1935j.d();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, c1935j.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * c1935j.g()) * c1935j.h()) * ((float) Math.sqrt((f15 * f15) + (f16 * f16)))) / (f18 + 0.305f), 0.9d));
        float fD = c1935j.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r4 * c1935j.b()) / (c1935j.a() + 4.0f))) * 50.0f;
        float f21 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d5 = f20;
        float fCos = ((float) Math.cos(d5)) * fLog;
        float fSin = fLog * ((float) Math.sin(d5));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f21;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    public static C1926a e(float f4, float f5, float f6) {
        return f(f4, f5, f6, C1935j.f15833k);
    }

    public static C1926a f(float f4, float f5, float f6, C1935j c1935j) {
        float fB = (4.0f / c1935j.b()) * ((float) Math.sqrt(((double) f4) / 100.0d)) * (c1935j.a() + 4.0f) * c1935j.d();
        float fD = c1935j.d() * f5;
        float fSqrt = ((float) Math.sqrt(((f5 / ((float) Math.sqrt(r4))) * c1935j.b()) / (c1935j.a() + 4.0f))) * 50.0f;
        float f7 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (3.1415927f * f6) / 180.0f;
        return new C1926a(f6, f5, f4, fB, fD, fSqrt, f7, ((float) Math.cos(d4)) * fLog, fLog * ((float) Math.sin(d4)));
    }

    public static int m(float f4, float f5, float f6) {
        return n(f4, f5, f6, C1935j.f15833k);
    }

    public static int n(float f4, float f5, float f6, C1935j c1935j) {
        if (f5 < 1.0d || Math.round(f6) <= 0.0d || Math.round(f6) >= 100.0d) {
            return AbstractC1927b.a(f6);
        }
        float fMin = f4 < 0.0f ? 0.0f : Math.min(360.0f, f4);
        C1926a c1926a = null;
        boolean z4 = true;
        float f7 = 0.0f;
        float f8 = f5;
        while (Math.abs(f7 - f5) >= 0.4f) {
            C1926a c1926aB = b(fMin, f8, f6);
            if (!z4) {
                if (c1926aB == null) {
                    f5 = f8;
                } else {
                    f7 = f8;
                    c1926a = c1926aB;
                }
                f8 = ((f5 - f7) / 2.0f) + f7;
            } else {
                if (c1926aB != null) {
                    return c1926aB.o(c1935j);
                }
                f8 = ((f5 - f7) / 2.0f) + f7;
                z4 = false;
            }
        }
        return c1926a == null ? AbstractC1927b.a(f6) : c1926a.o(c1935j);
    }

    public float a(C1926a c1926a) {
        float fL = l() - c1926a.l();
        float fG = g() - c1926a.g();
        float fH = h() - c1926a.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f15803h;
    }

    public float h() {
        return this.f15804i;
    }

    public float i() {
        return this.f15797b;
    }

    public float j() {
        return this.f15796a;
    }

    public float k() {
        return this.f15798c;
    }

    public float l() {
        return this.f15802g;
    }

    public int o(C1935j c1935j) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, c1935j.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = c1935j.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) c1935j.b())) / ((double) c1935j.j())));
        float fG = fCos * 3846.1538f * c1935j.g() * c1935j.h();
        float f4 = fA / c1935j.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f5 = (((0.305f + f4) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f6 = fCos2 * f5;
        float f7 = f5 * fSin;
        float f8 = f4 * 460.0f;
        float f9 = (((451.0f * f6) + f8) + (288.0f * f7)) / 1403.0f;
        float f10 = ((f8 - (891.0f * f6)) - (261.0f * f7)) / 1403.0f;
        float fSignum = Math.signum(f9) * (100.0f / c1935j.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f9)) * 27.13d) / (400.0d - ((double) Math.abs(f9)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f10) * (100.0f / c1935j.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f10)) * 27.13d) / (400.0d - ((double) Math.abs(f10)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f8 - (f6 * 220.0f)) - (f7 * 6300.0f)) / 1403.0f) * (100.0f / c1935j.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r8)) * 27.13d) / (400.0d - ((double) Math.abs(r8)))), 2.380952380952381d));
        float f11 = fSignum / c1935j.i()[0];
        float f12 = fSignum2 / c1935j.i()[1];
        float f13 = fSignum3 / c1935j.i()[2];
        float[][] fArr = AbstractC1927b.f15806b;
        float[] fArr2 = fArr[0];
        float f14 = (fArr2[0] * f11) + (fArr2[1] * f12) + (fArr2[2] * f13);
        float[] fArr3 = fArr[1];
        float f15 = (fArr3[0] * f11) + (fArr3[1] * f12) + (fArr3[2] * f13);
        float[] fArr4 = fArr[2];
        return AbstractC1962a.a(f14, f15, (f11 * fArr4[0]) + (f12 * fArr4[1]) + (f13 * fArr4[2]));
    }

    public int p() {
        return o(C1935j.f15833k);
    }
}
