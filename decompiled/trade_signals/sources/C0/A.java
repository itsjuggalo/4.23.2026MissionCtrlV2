package C0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M f425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property f426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property f427c;

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(A.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f8) {
            A.g(view, f8.floatValue());
        }
    }

    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return T.D.m(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            T.D.O(view, rect);
        }
    }

    static {
        f425a = Build.VERSION.SDK_INT >= 29 ? new L() : new K();
        f426b = new a(Float.class, "translationAlpha");
        f427c = new b(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f425a.a(view);
    }

    public static z b(View view) {
        return new y(view);
    }

    public static float c(View view) {
        return f425a.b(view);
    }

    public static P d(View view) {
        return new O(view);
    }

    public static void e(View view) {
        f425a.c(view);
    }

    public static void f(View view, int i8, int i9, int i10, int i11) {
        f425a.d(view, i8, i9, i10, i11);
    }

    public static void g(View view, float f8) {
        f425a.e(view, f8);
    }

    public static void h(View view, int i8) {
        f425a.f(view, i8);
    }

    public static void i(View view, Matrix matrix) {
        f425a.g(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f425a.h(view, matrix);
    }
}
