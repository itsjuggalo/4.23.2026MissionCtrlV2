package H;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f2504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f2507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f2508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f2509i;

    public a(float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f2501a = f7;
        this.f2502b = f8;
        this.f2503c = f9;
        this.f2504d = f10;
        this.f2505e = f11;
        this.f2506f = f12;
        this.f2507g = f13;
        this.f2508h = f14;
        this.f2509i = f15;
    }

    public static a b(float f7, float f8, float f9) {
        float f10 = 100.0f;
        float f11 = 1000.0f;
        float f12 = 0.0f;
        a aVar = null;
        float f13 = 1000.0f;
        while (Math.abs(f12 - f10) > 0.01f) {
            float f14 = ((f10 - f12) / 2.0f) + f12;
            int iP = e(f14, f8, f7).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f9 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f7));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f11 = fAbs;
                    f13 = fA;
                }
            }
            if (f11 == 0.0f && f13 == 0.0f) {
                break;
            }
            if (fB < f9) {
                f12 = f14;
            } else {
                f10 = f14;
            }
        }
        return aVar;
    }

    public static a c(int i7) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i7, j.f2538k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void d(int i7, j jVar, float[] fArr, float[] fArr2) {
        b.f(i7, fArr2);
        float[][] fArr3 = b.f2510a;
        float f7 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f8 = fArr4[0] * f7;
        float f9 = fArr2[1];
        float f10 = f8 + (fArr4[1] * f9);
        float f11 = fArr2[2];
        float f12 = f10 + (fArr4[2] * f11);
        float[] fArr5 = fArr3[1];
        float f13 = (fArr5[0] * f7) + (fArr5[1] * f9) + (fArr5[2] * f11);
        float[] fArr6 = fArr3[2];
        float f14 = (f7 * fArr6[0]) + (f9 * fArr6[1]) + (f11 * fArr6[2]);
        float f15 = jVar.i()[0] * f12;
        float f16 = jVar.i()[1] * f13;
        float f17 = jVar.i()[2] * f14;
        float fPow = (float) Math.pow(((double) (jVar.c() * Math.abs(f15))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (jVar.c() * Math.abs(f16))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (jVar.c() * Math.abs(f17))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f15) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f16) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f17) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d7 = fSignum3;
        float f18 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d7)) / 11.0f;
        float f19 = ((float) (((double) (fSignum + fSignum2)) - (d7 * 2.0d))) / 9.0f;
        float f20 = fSignum2 * 20.0f;
        float f21 = (((fSignum * 20.0f) + f20) + (21.0f * fSignum3)) / 20.0f;
        float f22 = (((fSignum * 40.0f) + f20) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f19, f18)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f23 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f22 * jVar.f()) / jVar.a(), jVar.b() * jVar.j())) * 100.0f;
        float fB = (4.0f / jVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (jVar.a() + 4.0f) * jVar.d();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, jVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.g()) * jVar.h()) * ((float) Math.sqrt((f18 * f18) + (f19 * f19)))) / (f21 + 0.305f), 0.9d));
        float fD = jVar.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r7 * jVar.b()) / (jVar.a() + 4.0f))) * 50.0f;
        float f24 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d8 = f23;
        float fCos = ((float) Math.cos(d8)) * fLog;
        float fSin = fLog * ((float) Math.sin(d8));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f24;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    public static a e(float f7, float f8, float f9) {
        return f(f7, f8, f9, j.f2538k);
    }

    public static a f(float f7, float f8, float f9, j jVar) {
        float fB = (4.0f / jVar.b()) * ((float) Math.sqrt(((double) f7) / 100.0d)) * (jVar.a() + 4.0f) * jVar.d();
        float fD = f8 * jVar.d();
        float fSqrt = ((float) Math.sqrt(((f8 / ((float) Math.sqrt(r4))) * jVar.b()) / (jVar.a() + 4.0f))) * 50.0f;
        float f10 = (1.7f * f7) / ((0.007f * f7) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d7 = (3.1415927f * f9) / 180.0f;
        return new a(f9, f8, f7, fB, fD, fSqrt, f10, fLog * ((float) Math.cos(d7)), fLog * ((float) Math.sin(d7)));
    }

    public static int m(float f7, float f8, float f9) {
        return n(f7, f8, f9, j.f2538k);
    }

    public static int n(float f7, float f8, float f9, j jVar) {
        if (f8 < 1.0d || Math.round(f9) <= 0.0d || Math.round(f9) >= 100.0d) {
            return b.a(f9);
        }
        float fMin = f7 < 0.0f ? 0.0f : Math.min(360.0f, f7);
        a aVar = null;
        boolean z7 = true;
        float f10 = 0.0f;
        float f11 = f8;
        while (Math.abs(f10 - f8) >= 0.4f) {
            a aVarB = b(fMin, f11, f9);
            if (!z7) {
                if (aVarB == null) {
                    f8 = f11;
                } else {
                    f10 = f11;
                    aVar = aVarB;
                }
                f11 = ((f8 - f10) / 2.0f) + f10;
            } else {
                if (aVarB != null) {
                    return aVarB.o(jVar);
                }
                f11 = ((f8 - f10) / 2.0f) + f10;
                z7 = false;
            }
        }
        return aVar == null ? b.a(f9) : aVar.o(jVar);
    }

    public float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f2508h;
    }

    public float h() {
        return this.f2509i;
    }

    public float i() {
        return this.f2502b;
    }

    public float j() {
        return this.f2501a;
    }

    public float k() {
        return this.f2503c;
    }

    public float l() {
        return this.f2507g;
    }

    public int o(j jVar) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, jVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = jVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) jVar.b())) / ((double) jVar.j())));
        float fG = fCos * 3846.1538f * jVar.g() * jVar.h();
        float f7 = fA / jVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f8 = (((0.305f + f7) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f9 = fCos2 * f8;
        float f10 = f8 * fSin;
        float f11 = f7 * 460.0f;
        float f12 = (((451.0f * f9) + f11) + (288.0f * f10)) / 1403.0f;
        float f13 = ((f11 - (891.0f * f9)) - (261.0f * f10)) / 1403.0f;
        float fSignum = Math.signum(f12) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f12)) * 27.13d) / (400.0d - ((double) Math.abs(f12)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f13) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f13)) * 27.13d) / (400.0d - ((double) Math.abs(f13)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f11 - (f9 * 220.0f)) - (f10 * 6300.0f)) / 1403.0f) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r8)) * 27.13d) / (400.0d - ((double) Math.abs(r8)))), 2.380952380952381d));
        float f14 = fSignum / jVar.i()[0];
        float f15 = fSignum2 / jVar.i()[1];
        float f16 = fSignum3 / jVar.i()[2];
        float[][] fArr = b.f2511b;
        float[] fArr2 = fArr[0];
        float f17 = (fArr2[0] * f14) + (fArr2[1] * f15) + (fArr2[2] * f16);
        float[] fArr3 = fArr[1];
        float f18 = (fArr3[0] * f14) + (fArr3[1] * f15) + (fArr3[2] * f16);
        float[] fArr4 = fArr[2];
        return I.a.b(f17, f18, (f14 * fArr4[0]) + (f15 * fArr4[1]) + (f16 * fArr4[2]));
    }

    public int p() {
        return o(j.f2538k);
    }
}
