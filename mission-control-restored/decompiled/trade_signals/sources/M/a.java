package M;

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

    /* JADX INFO: renamed from: M.a$a, reason: collision with other inner class name */
    public static class C0075a {
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

        public static void e(Drawable drawable, float f8, float f9) {
            drawable.setHotspot(f8, f9);
        }

        public static void f(Drawable drawable, int i8, int i9, int i10, int i11) {
            drawable.setHotspotBounds(i8, i9, i10, i11);
        }

        public static void g(Drawable drawable, int i8) {
            drawable.setTint(i8);
        }

        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void b(Drawable drawable, boolean z7) {
        drawable.setAutoMirrored(z7);
    }

    public static void c(Drawable drawable, float f8, float f9) {
        C0075a.e(drawable, f8, f9);
    }

    public static void d(Drawable drawable, int i8, int i9, int i10, int i11) {
        C0075a.f(drawable, i8, i9, i10, i11);
    }

    public static void e(Drawable drawable, int i8) {
        C0075a.g(drawable, i8);
    }

    public static void f(Drawable drawable, ColorStateList colorStateList) {
        C0075a.h(drawable, colorStateList);
    }

    public static void g(Drawable drawable, PorterDuff.Mode mode) {
        C0075a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable h(Drawable drawable) {
        return drawable instanceof b ? ((b) drawable).a() : drawable;
    }

    public static Drawable i(Drawable drawable) {
        return drawable;
    }
}
