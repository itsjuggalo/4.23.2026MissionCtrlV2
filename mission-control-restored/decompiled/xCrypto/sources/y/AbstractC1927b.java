package y;

import android.graphics.Color;
import z.AbstractC1962a;

/* JADX INFO: renamed from: y.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1927b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f15805a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[][] f15806b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f15807c = {95.047f, 100.0f, 108.883f};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[][] f15808d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int a(float f4) {
        if (f4 < 1.0f) {
            return -16777216;
        }
        if (f4 > 99.0f) {
            return -1;
        }
        float f5 = (f4 + 16.0f) / 116.0f;
        float f6 = f4 > 8.0f ? f5 * f5 * f5 : f4 / 903.2963f;
        float f7 = f5 * f5 * f5;
        boolean z4 = f7 > 0.008856452f;
        float f8 = z4 ? f7 : ((f5 * 116.0f) - 16.0f) / 903.2963f;
        if (!z4) {
            f7 = ((f5 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f15807c;
        return AbstractC1962a.a(f8 * fArr[0], f6 * fArr[1], f7 * fArr[2]);
    }

    public static float b(int i4) {
        return c(g(i4));
    }

    public static float c(float f4) {
        float f5 = f4 / 100.0f;
        return f5 <= 0.008856452f ? f5 * 903.2963f : (((float) Math.cbrt(f5)) * 116.0f) - 16.0f;
    }

    public static float d(float f4, float f5, float f6) {
        return f4 + ((f5 - f4) * f6);
    }

    public static float e(int i4) {
        float f4 = i4 / 255.0f;
        return (f4 <= 0.04045f ? f4 / 12.92f : (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static void f(int i4, float[] fArr) {
        float fE = e(Color.red(i4));
        float fE2 = e(Color.green(i4));
        float fE3 = e(Color.blue(i4));
        float[][] fArr2 = f15808d;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[0] * fE) + (fArr3[1] * fE2) + (fArr3[2] * fE3);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[0] * fE) + (fArr4[1] * fE2) + (fArr4[2] * fE3);
        float[] fArr5 = fArr2[2];
        fArr[2] = (fE * fArr5[0]) + (fE2 * fArr5[1]) + (fE3 * fArr5[2]);
    }

    public static float g(int i4) {
        float fE = e(Color.red(i4));
        float fE2 = e(Color.green(i4));
        float fE3 = e(Color.blue(i4));
        float[] fArr = f15808d[1];
        return (fE * fArr[0]) + (fE2 * fArr[1]) + (fE3 * fArr[2]);
    }

    public static float h(float f4) {
        return (f4 > 8.0f ? (float) Math.pow((((double) f4) + 16.0d) / 116.0d, 3.0d) : f4 / 903.2963f) * 100.0f;
    }
}
