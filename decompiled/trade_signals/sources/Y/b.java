package Y;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a {
        public static void a(EdgeEffect edgeEffect, float f8, float f9) {
            edgeEffect.onPull(f8, f9);
        }
    }

    /* JADX INFO: renamed from: Y.b$b, reason: collision with other inner class name */
    public static class C0154b {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f8, float f9) {
            try {
                return edgeEffect.onPullDistance(f8, f9);
            } catch (Throwable unused) {
                edgeEffect.onPull(f8, f9);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? C0154b.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C0154b.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void c(EdgeEffect edgeEffect, float f8, float f9) {
        a.a(edgeEffect, f8, f9);
    }

    public static float d(EdgeEffect edgeEffect, float f8, float f9) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C0154b.c(edgeEffect, f8, f9);
        }
        c(edgeEffect, f8, f9);
        return f8;
    }
}
