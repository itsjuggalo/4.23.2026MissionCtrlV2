package v;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f23705a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f8, float f9, boolean z7) {
        return z7 ? (float) (((double) f8) + ((1.0d - f23705a) * ((double) f9))) : f8;
    }

    public static float b(float f8, float f9, boolean z7) {
        float f10 = f8 * 1.5f;
        return z7 ? (float) (((double) f10) + ((1.0d - f23705a) * ((double) f9))) : f10;
    }
}
