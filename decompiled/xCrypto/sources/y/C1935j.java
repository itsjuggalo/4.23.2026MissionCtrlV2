package y;

/* JADX INFO: renamed from: y.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1935j {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C1935j f15833k = k(AbstractC1927b.f15807c, (float) ((((double) AbstractC1927b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f15836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f15837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f15838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f15839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f15840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f15841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f15842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f15843j;

    public C1935j(float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, float f10, float f11, float f12) {
        this.f15839f = f4;
        this.f15834a = f5;
        this.f15835b = f6;
        this.f15836c = f7;
        this.f15837d = f8;
        this.f15838e = f9;
        this.f15840g = fArr;
        this.f15841h = f10;
        this.f15842i = f11;
        this.f15843j = f12;
    }

    public static C1935j k(float[] fArr, float f4, float f5, float f6, boolean z4) {
        float[][] fArr2 = AbstractC1927b.f15805a;
        float f7 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f8 = fArr3[0] * f7;
        float f9 = fArr[1];
        float f10 = f8 + (fArr3[1] * f9);
        float f11 = fArr[2];
        float f12 = f10 + (fArr3[2] * f11);
        float[] fArr4 = fArr2[1];
        float f13 = (fArr4[0] * f7) + (fArr4[1] * f9) + (fArr4[2] * f11);
        float[] fArr5 = fArr2[2];
        float f14 = (f7 * fArr5[0]) + (f9 * fArr5[1]) + (f11 * fArr5[2]);
        float f15 = (f6 / 10.0f) + 0.8f;
        float fD = ((double) f15) >= 0.9d ? AbstractC1927b.d(0.59f, 0.69f, (f15 - 0.9f) * 10.0f) : AbstractC1927b.d(0.525f, 0.59f, (f15 - 0.8f) * 10.0f);
        float fExp = z4 ? 1.0f : (1.0f - (((float) Math.exp(((-f4) - 42.0f) / 92.0f)) * 0.2777778f)) * f15;
        double d4 = fExp;
        if (d4 > 1.0d) {
            fExp = 1.0f;
        } else if (d4 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f12) * fExp) + 1.0f) - fExp, (((100.0f / f13) * fExp) + 1.0f) - fExp, (((100.0f / f14) * fExp) + 1.0f) - fExp};
        float f16 = 1.0f / ((5.0f * f4) + 1.0f);
        float f17 = f16 * f16 * f16 * f16;
        float f18 = 1.0f - f17;
        float fCbrt = (f17 * f4) + (0.1f * f18 * f18 * ((float) Math.cbrt(((double) f4) * 5.0d)));
        float fH = AbstractC1927b.h(f5) / fArr[1];
        double d5 = fH;
        float fSqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d5, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f13)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f14)) / 100.0d, 0.42d)};
        float f19 = fArr7[0];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr7[1];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr7[2];
        float[] fArr8 = {f20, f22, (400.0f * f23) / (f23 + 27.13f)};
        return new C1935j(fH, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * fPow, fPow, fPow, fD, f15, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float a() {
        return this.f15834a;
    }

    public float b() {
        return this.f15837d;
    }

    public float c() {
        return this.f15841h;
    }

    public float d() {
        return this.f15842i;
    }

    public float e() {
        return this.f15839f;
    }

    public float f() {
        return this.f15835b;
    }

    public float g() {
        return this.f15838e;
    }

    public float h() {
        return this.f15836c;
    }

    public float[] i() {
        return this.f15840g;
    }

    public float j() {
        return this.f15843j;
    }
}
