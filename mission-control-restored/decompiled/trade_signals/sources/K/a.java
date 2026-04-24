package K;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f4688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f4690i;

    public a(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f4682a = f8;
        this.f4683b = f9;
        this.f4684c = f10;
        this.f4685d = f11;
        this.f4686e = f12;
        this.f4687f = f13;
        this.f4688g = f14;
        this.f4689h = f15;
        this.f4690i = f16;
    }

    public static a b(float f8, float f9, float f10) {
        float f11 = 100.0f;
        float f12 = 1000.0f;
        float f13 = 0.0f;
        a aVar = null;
        float f14 = 1000.0f;
        while (Math.abs(f13 - f11) > 0.01f) {
            float f15 = ((f11 - f13) / 2.0f) + f13;
            int iP = e(f15, f9, f8).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f10 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f8));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f12 = fAbs;
                    f14 = fA;
                }
            }
            if (f12 == 0.0f && f14 == 0.0f) {
                break;
            }
            if (fB < f10) {
                f13 = f15;
            } else {
                f11 = f15;
            }
        }
        return aVar;
    }

    public static a c(int i8) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i8, j.f4719k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void d(int i8, j jVar, float[] fArr, float[] fArr2) {
        b.f(i8, fArr2);
        float[][] fArr3 = b.f4691a;
        float f8 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f9 = fArr4[0] * f8;
        float f10 = fArr2[1];
        float f11 = f9 + (fArr4[1] * f10);
        float f12 = fArr2[2];
        float f13 = f11 + (fArr4[2] * f12);
        float[] fArr5 = fArr3[1];
        float f14 = (fArr5[0] * f8) + (fArr5[1] * f10) + (fArr5[2] * f12);
        float[] fArr6 = fArr3[2];
        float f15 = (f8 * fArr6[0]) + (f10 * fArr6[1]) + (f12 * fArr6[2]);
        float f16 = jVar.i()[0] * f13;
        float f17 = jVar.i()[1] * f14;
        float f18 = jVar.i()[2] * f15;
        float fPow = (float) Math.pow(((double) (jVar.c() * Math.abs(f16))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (jVar.c() * Math.abs(f17))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (jVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f16) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f17) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f18) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d8 = fSignum3;
        float f19 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d8)) / 11.0f;
        float f20 = ((float) (((double) (fSignum + fSignum2)) - (d8 * 2.0d))) / 9.0f;
        float f21 = fSignum2 * 20.0f;
        float f22 = (((fSignum * 20.0f) + f21) + (21.0f * fSignum3)) / 20.0f;
        float f23 = (((fSignum * 40.0f) + f21) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f20, f19)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f24 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f23 * jVar.f()) / jVar.a(), jVar.b() * jVar.j())) * 100.0f;
        float fB = (4.0f / jVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (jVar.a() + 4.0f) * jVar.d();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, jVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.g()) * jVar.h()) * ((float) Math.sqrt((f19 * f19) + (f20 * f20)))) / (f22 + 0.305f), 0.9d));
        float fD = jVar.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r7 * jVar.b()) / (jVar.a() + 4.0f))) * 50.0f;
        float f25 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d9 = f24;
        float fCos = ((float) Math.cos(d9)) * fLog;
        float fSin = fLog * ((float) Math.sin(d9));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f25;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    public static a e(float f8, float f9, float f10) {
        return f(f8, f9, f10, j.f4719k);
    }

    public static a f(float f8, float f9, float f10, j jVar) {
        float fB = (4.0f / jVar.b()) * ((float) Math.sqrt(((double) f8) / 100.0d)) * (jVar.a() + 4.0f) * jVar.d();
        float fD = f9 * jVar.d();
        float fSqrt = ((float) Math.sqrt(((f9 / ((float) Math.sqrt(r4))) * jVar.b()) / (jVar.a() + 4.0f))) * 50.0f;
        float f11 = (1.7f * f8) / ((0.007f * f8) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d8 = (3.1415927f * f10) / 180.0f;
        return new a(f10, f9, f8, fB, fD, fSqrt, f11, fLog * ((float) Math.cos(d8)), fLog * ((float) Math.sin(d8)));
    }

    public static int m(float f8, float f9, float f10) {
        return n(f8, f9, f10, j.f4719k);
    }

    public static int n(float f8, float f9, float f10, j jVar) {
        if (f9 < 1.0d || Math.round(f10) <= 0.0d || Math.round(f10) >= 100.0d) {
            return b.a(f10);
        }
        float fMin = f8 < 0.0f ? 0.0f : Math.min(360.0f, f8);
        a aVar = null;
        boolean z7 = true;
        float f11 = 0.0f;
        float f12 = f9;
        while (Math.abs(f11 - f9) >= 0.4f) {
            a aVarB = b(fMin, f12, f10);
            if (!z7) {
                if (aVarB == null) {
                    f9 = f12;
                } else {
                    f11 = f12;
                    aVar = aVarB;
                }
                f12 = ((f9 - f11) / 2.0f) + f11;
            } else {
                if (aVarB != null) {
                    return aVarB.o(jVar);
                }
                f12 = ((f9 - f11) / 2.0f) + f11;
                z7 = false;
            }
        }
        return aVar == null ? b.a(f10) : aVar.o(jVar);
    }

    public float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f4689h;
    }

    public float h() {
        return this.f4690i;
    }

    public float i() {
        return this.f4683b;
    }

    public float j() {
        return this.f4682a;
    }

    public float k() {
        return this.f4684c;
    }

    public float l() {
        return this.f4688g;
    }

    public int o(j jVar) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, jVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = jVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) jVar.b())) / ((double) jVar.j())));
        float fG = fCos * 3846.1538f * jVar.g() * jVar.h();
        float f8 = fA / jVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f9 = (((0.305f + f8) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f10 = fCos2 * f9;
        float f11 = f9 * fSin;
        float f12 = f8 * 460.0f;
        float f13 = (((451.0f * f10) + f12) + (288.0f * f11)) / 1403.0f;
        float f14 = ((f12 - (891.0f * f10)) - (261.0f * f11)) / 1403.0f;
        float fSignum = Math.signum(f13) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f13)) * 27.13d) / (400.0d - ((double) Math.abs(f13)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f14) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f14)) * 27.13d) / (400.0d - ((double) Math.abs(f14)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f12 - (f10 * 220.0f)) - (f11 * 6300.0f)) / 1403.0f) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r8)) * 27.13d) / (400.0d - ((double) Math.abs(r8)))), 2.380952380952381d));
        float f15 = fSignum / jVar.i()[0];
        float f16 = fSignum2 / jVar.i()[1];
        float f17 = fSignum3 / jVar.i()[2];
        float[][] fArr = b.f4692b;
        float[] fArr2 = fArr[0];
        float f18 = (fArr2[0] * f15) + (fArr2[1] * f16) + (fArr2[2] * f17);
        float[] fArr3 = fArr[1];
        float f19 = (fArr3[0] * f15) + (fArr3[1] * f16) + (fArr3[2] * f17);
        float[] fArr4 = fArr[2];
        return L.a.a(f18, f19, (f15 * fArr4[0]) + (f16 * fArr4[1]) + (f17 * fArr4[2]));
    }

    public int p() {
        return o(j.f4719k);
    }
}
