package E4;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static float[] a(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] b(RectF rectF) {
        float f7 = rectF.left;
        float f8 = rectF.top;
        float f9 = rectF.right;
        float f10 = rectF.bottom;
        return new float[]{f7, f8, f9, f8, f9, f10, f7, f10};
    }

    public static float[] c(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow(fArr[0] - fArr[2], 2.0d) + Math.pow(fArr[1] - fArr[3], 2.0d)), (float) Math.sqrt(Math.pow(fArr[2] - fArr[4], 2.0d) + Math.pow(fArr[3] - fArr[5], 2.0d))};
    }

    public static RectF d(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i7 = 1; i7 < fArr.length; i7 += 2) {
            float fRound = Math.round(fArr[i7 - 1] * 10.0f) / 10.0f;
            float fRound2 = Math.round(fArr[i7] * 10.0f) / 10.0f;
            float f7 = rectF.left;
            if (fRound < f7) {
                f7 = fRound;
            }
            rectF.left = f7;
            float f8 = rectF.top;
            if (fRound2 < f8) {
                f8 = fRound2;
            }
            rectF.top = f8;
            float f9 = rectF.right;
            if (fRound <= f9) {
                fRound = f9;
            }
            rectF.right = fRound;
            float f10 = rectF.bottom;
            if (fRound2 <= f10) {
                fRound2 = f10;
            }
            rectF.bottom = fRound2;
        }
        rectF.sort();
        return rectF;
    }
}
