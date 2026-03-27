package v2;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: renamed from: v2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2848n {
    public static String a(int i8, int i9, String str) {
        if (i8 < 0) {
            return AbstractC2852r.c("%s (%s) must not be negative", str, Integer.valueOf(i8));
        }
        if (i9 >= 0) {
            return AbstractC2852r.c("%s (%s) must be less than size (%s)", str, Integer.valueOf(i8), Integer.valueOf(i9));
        }
        throw new IllegalArgumentException("negative size: " + i9);
    }

    public static String b(int i8, int i9, String str) {
        if (i8 < 0) {
            return AbstractC2852r.c("%s (%s) must not be negative", str, Integer.valueOf(i8));
        }
        if (i9 >= 0) {
            return AbstractC2852r.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i8), Integer.valueOf(i9));
        }
        throw new IllegalArgumentException("negative size: " + i9);
    }

    public static String c(int i8, int i9, int i10) {
        return (i8 < 0 || i8 > i10) ? b(i8, i10, "start index") : (i9 < 0 || i9 > i10) ? b(i9, i10, "end index") : AbstractC2852r.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i9), Integer.valueOf(i8));
    }

    public static void d(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z7, String str, char c8) {
        if (!z7) {
            throw new IllegalArgumentException(AbstractC2852r.c(str, Character.valueOf(c8)));
        }
    }

    public static void g(boolean z7, String str, char c8, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(AbstractC2852r.c(str, Character.valueOf(c8), obj));
        }
    }

    public static void h(boolean z7, String str, int i8) {
        if (!z7) {
            throw new IllegalArgumentException(AbstractC2852r.c(str, Integer.valueOf(i8)));
        }
    }

    public static void i(boolean z7, String str, long j8) {
        if (!z7) {
            throw new IllegalArgumentException(AbstractC2852r.c(str, Long.valueOf(j8)));
        }
    }

    public static void j(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(AbstractC2852r.c(str, obj));
        }
    }

    public static void k(boolean z7, String str, Object obj, Object obj2) {
        if (!z7) {
            throw new IllegalArgumentException(AbstractC2852r.c(str, obj, obj2));
        }
    }

    public static int l(int i8, int i9) {
        return m(i8, i9, FirebaseAnalytics.Param.INDEX);
    }

    public static int m(int i8, int i9, String str) {
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a(i8, i9, str));
        }
        return i8;
    }

    public static Object n(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object o(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static Object p(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(AbstractC2852r.c(str, obj2));
    }

    public static int q(int i8, int i9) {
        return r(i8, i9, FirebaseAnalytics.Param.INDEX);
    }

    public static int r(int i8, int i9, String str) {
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(b(i8, i9, str));
        }
        return i8;
    }

    public static void s(int i8, int i9, int i10) {
        if (i8 < 0 || i9 < i8 || i9 > i10) {
            throw new IndexOutOfBoundsException(c(i8, i9, i10));
        }
    }

    public static void t(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    public static void u(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void v(boolean z7, String str, char c8, char c9) {
        if (!z7) {
            throw new IllegalStateException(AbstractC2852r.c(str, Character.valueOf(c8), Character.valueOf(c9)));
        }
    }

    public static void w(boolean z7, String str, int i8) {
        if (!z7) {
            throw new IllegalStateException(AbstractC2852r.c(str, Integer.valueOf(i8)));
        }
    }

    public static void x(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new IllegalStateException(AbstractC2852r.c(str, obj));
        }
    }
}
