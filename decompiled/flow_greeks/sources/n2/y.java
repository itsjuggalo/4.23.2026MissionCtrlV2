package n2;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f16605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property f16606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property f16607c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            y.g(view, f10.floatValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return t0.c0.m(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            t0.c0.O(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f16605a = new d0();
        } else {
            f16605a = new c0();
        }
        f16606b = new a(Float.class, "translationAlpha");
        f16607c = new b(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f16605a.a(view);
    }

    public static x b(View view) {
        return new w(view);
    }

    public static float c(View view) {
        return f16605a.b(view);
    }

    public static h0 d(View view) {
        return new g0(view);
    }

    public static void e(View view) {
        f16605a.c(view);
    }

    public static void f(View view, int i10, int i11, int i12, int i13) {
        f16605a.d(view, i10, i11, i12, i13);
    }

    public static void g(View view, float f10) {
        f16605a.e(view, f10);
    }

    public static void h(View view, int i10) {
        f16605a.f(view, i10);
    }

    public static void i(View view, Matrix matrix) {
        f16605a.g(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f16605a.h(view, matrix);
    }
}
