package I0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M f2703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property f2704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property f2705c;

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
        public void set(View view, Float f7) {
            A.g(view, f7.floatValue());
        }
    }

    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return Q.N.s(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            Q.N.s0(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2703a = new L();
        } else {
            f2703a = new K();
        }
        f2704b = new a(Float.class, "translationAlpha");
        f2705c = new b(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f2703a.a(view);
    }

    public static z b(View view) {
        return new y(view);
    }

    public static float c(View view) {
        return f2703a.b(view);
    }

    public static P d(View view) {
        return new O(view);
    }

    public static void e(View view) {
        f2703a.c(view);
    }

    public static void f(View view, int i7, int i8, int i9, int i10) {
        f2703a.d(view, i7, i8, i9, i10);
    }

    public static void g(View view, float f7) {
        f2703a.e(view, f7);
    }

    public static void h(View view, int i7) {
        f2703a.f(view, i7);
    }

    public static void i(View view, Matrix matrix) {
        f2703a.g(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f2703a.h(view, matrix);
    }
}
