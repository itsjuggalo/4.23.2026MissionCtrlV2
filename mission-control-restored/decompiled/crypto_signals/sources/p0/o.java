package p0;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        float f7 = f6 - 1.0f;
        return (f7 * f7 * f7 * f7 * f7) + 1.0f;
    }
}
