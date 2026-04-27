package p0;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f21448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f21449b;

    public d(float[] fArr) {
        this.f21448a = fArr;
        this.f21449b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f7) {
        if (f7 >= 1.0f) {
            return 1.0f;
        }
        if (f7 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f21448a;
        int iMin = Math.min((int) ((fArr.length - 1) * f7), fArr.length - 2);
        float f8 = this.f21449b;
        float f9 = (f7 - (iMin * f8)) / f8;
        float[] fArr2 = this.f21448a;
        float f10 = fArr2[iMin];
        return f10 + (f9 * (fArr2[iMin + 1] - f10));
    }
}
