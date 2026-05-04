package p6;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static String a(int i10, int i11, String str) {
        if (i10 < 0) {
            return r.c("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return r.c("%s (%s) must be less than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException("negative size: " + i11);
    }

    public static String b(int i10, int i11, String str) {
        if (i10 < 0) {
            return r.c("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return r.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException("negative size: " + i11);
    }

    public static String c(int i10, int i11, int i12) {
        return (i10 < 0 || i10 > i12) ? b(i10, i12, "start index") : (i11 < 0 || i11 > i12) ? b(i11, i12, "end index") : r.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public static void d(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z10, String str, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(r.c(str, Character.valueOf(c10)));
        }
    }

    public static void g(boolean z10, String str, char c10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(r.c(str, Character.valueOf(c10), obj));
        }
    }

    public static void h(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(r.c(str, Integer.valueOf(i10)));
        }
    }

    public static void i(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(r.c(str, Long.valueOf(j10)));
        }
    }

    public static void j(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(r.c(str, obj));
        }
    }

    public static void k(boolean z10, String str, Object obj, Object obj2) {
        if (!z10) {
            throw new IllegalArgumentException(r.c(str, obj, obj2));
        }
    }

    public static int l(int i10, int i11) {
        return m(i10, i11, FirebaseAnalytics.Param.INDEX);
    }

    public static int m(int i10, int i11, String str) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a(i10, i11, str));
        }
        return i10;
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
        throw new NullPointerException(r.c(str, obj2));
    }

    public static int q(int i10, int i11) {
        return r(i10, i11, FirebaseAnalytics.Param.INDEX);
    }

    public static int r(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(b(i10, i11, str));
        }
        return i10;
    }

    public static void s(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException(c(i10, i11, i12));
        }
    }

    public static void t(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void u(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void v(boolean z10, String str, char c10, char c11) {
        if (!z10) {
            throw new IllegalStateException(r.c(str, Character.valueOf(c10), Character.valueOf(c11)));
        }
    }

    public static void w(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalStateException(r.c(str, Integer.valueOf(i10)));
        }
    }

    public static void x(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalStateException(r.c(str, obj));
        }
    }
}
