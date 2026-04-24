package J;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: J.a$a, reason: collision with other inner class name */
    public static class C0039a {
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public static void e(Drawable drawable, float f7, float f8) {
            drawable.setHotspot(f7, f8);
        }

        public static void f(Drawable drawable, int i7, int i8, int i9, int i10) {
            drawable.setHotspotBounds(i7, i8, i9, i10);
        }

        public static void g(Drawable drawable, int i7) {
            drawable.setTint(i7);
        }

        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    public static class b {
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public static boolean b(Drawable drawable, int i7) {
            return drawable.setLayoutDirection(i7);
        }
    }

    public static void a(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int b(Drawable drawable) {
        return b.a(drawable);
    }

    public static boolean c(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void d(Drawable drawable, boolean z7) {
        drawable.setAutoMirrored(z7);
    }

    public static void e(Drawable drawable, float f7, float f8) {
        C0039a.e(drawable, f7, f8);
    }

    public static void f(Drawable drawable, int i7, int i8, int i9, int i10) {
        C0039a.f(drawable, i7, i8, i9, i10);
    }

    public static boolean g(Drawable drawable, int i7) {
        return b.b(drawable, i7);
    }

    public static void h(Drawable drawable, int i7) {
        C0039a.g(drawable, i7);
    }

    public static void i(Drawable drawable, ColorStateList colorStateList) {
        C0039a.h(drawable, colorStateList);
    }

    public static void j(Drawable drawable, PorterDuff.Mode mode) {
        C0039a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable k(Drawable drawable) {
        return drawable instanceof J.b ? ((J.b) drawable).a() : drawable;
    }

    public static Drawable l(Drawable drawable) {
        return drawable;
    }
}
