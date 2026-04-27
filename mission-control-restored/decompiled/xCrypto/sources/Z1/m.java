package Z1;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static String a(int i4, int i5, String str) {
        if (i4 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return q.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    public static String b(int i4, int i5, String str) {
        if (i4 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return q.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    public static String c(int i4, int i5, int i6) {
        return (i4 < 0 || i4 > i6) ? b(i4, i6, "start index") : (i5 < 0 || i5 > i6) ? b(i5, i6, "end index") : q.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
    }

    public static void d(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z4, String str, char c4) {
        if (!z4) {
            throw new IllegalArgumentException(q.b(str, Character.valueOf(c4)));
        }
    }

    public static void g(boolean z4, String str, char c4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(q.b(str, Character.valueOf(c4), obj));
        }
    }

    public static void h(boolean z4, String str, int i4) {
        if (!z4) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i4)));
        }
    }

    public static void i(boolean z4, String str, long j4) {
        if (!z4) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j4)));
        }
    }

    public static void j(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(q.b(str, obj));
        }
    }

    public static void k(boolean z4, String str, Object obj, Object obj2) {
        if (!z4) {
            throw new IllegalArgumentException(q.b(str, obj, obj2));
        }
    }

    public static int l(int i4, int i5) {
        return m(i4, i5, FirebaseAnalytics.Param.INDEX);
    }

    public static int m(int i4, int i5, String str) {
        if (i4 < 0 || i4 >= i5) {
            throw new IndexOutOfBoundsException(a(i4, i5, str));
        }
        return i4;
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
        throw new NullPointerException(q.b(str, obj2));
    }

    public static int q(int i4, int i5) {
        return r(i4, i5, FirebaseAnalytics.Param.INDEX);
    }

    public static int r(int i4, int i5, String str) {
        if (i4 < 0 || i4 > i5) {
            throw new IndexOutOfBoundsException(b(i4, i5, str));
        }
        return i4;
    }

    public static void s(int i4, int i5, int i6) {
        if (i4 < 0 || i5 < i4 || i5 > i6) {
            throw new IndexOutOfBoundsException(c(i4, i5, i6));
        }
    }

    public static void t(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static void u(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void v(boolean z4, String str, int i4) {
        if (!z4) {
            throw new IllegalStateException(q.b(str, Integer.valueOf(i4)));
        }
    }

    public static void w(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalStateException(q.b(str, obj));
        }
    }
}
