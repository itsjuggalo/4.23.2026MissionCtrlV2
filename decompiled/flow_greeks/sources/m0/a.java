package m0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: m0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0283a {
        public static void a(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        public static void b(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        public static void c(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        public static void d(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void e(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void b(Drawable drawable, boolean z10) {
        drawable.setAutoMirrored(z10);
    }

    public static void c(Drawable drawable, float f10, float f11) {
        C0283a.a(drawable, f10, f11);
    }

    public static void d(Drawable drawable, int i10, int i11, int i12, int i13) {
        C0283a.b(drawable, i10, i11, i12, i13);
    }

    public static void e(Drawable drawable, int i10) {
        C0283a.c(drawable, i10);
    }

    public static void f(Drawable drawable, ColorStateList colorStateList) {
        C0283a.d(drawable, colorStateList);
    }

    public static void g(Drawable drawable, PorterDuff.Mode mode) {
        C0283a.e(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable h(Drawable drawable) {
        return drawable instanceof b ? ((b) drawable).a() : drawable;
    }

    public static Drawable i(Drawable drawable) {
        return drawable;
    }
}
