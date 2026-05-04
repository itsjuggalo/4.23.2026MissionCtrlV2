package v;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f23062a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) f10) + ((1.0d - f23062a) * ((double) f11))) : f10;
    }

    public static float b(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) (f10 * 1.5f)) + ((1.0d - f23062a) * ((double) f11))) : f10 * 1.5f;
    }
}
