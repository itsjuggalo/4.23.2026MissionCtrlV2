package H2;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static String a(int i7, int i8, String str) {
        if (i7 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return q.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException("negative size: " + i8);
    }

    public static String b(int i7, int i8, String str) {
        if (i7 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return q.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException("negative size: " + i8);
    }

    public static String c(int i7, int i8, int i9) {
        return (i7 < 0 || i7 > i9) ? b(i7, i9, "start index") : (i8 < 0 || i8 > i9) ? b(i8, i9, "end index") : q.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i7));
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

    public static void f(boolean z7, String str, char c7) {
        if (!z7) {
            throw new IllegalArgumentException(q.b(str, Character.valueOf(c7)));
        }
    }

    public static void g(boolean z7, String str, char c7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(q.b(str, Character.valueOf(c7), obj));
        }
    }

    public static void h(boolean z7, String str, int i7) {
        if (!z7) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i7)));
        }
    }

    public static void i(boolean z7, String str, long j7) {
        if (!z7) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j7)));
        }
    }

    public static void j(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(q.b(str, obj));
        }
    }

    public static void k(boolean z7, String str, Object obj, Object obj2) {
        if (!z7) {
            throw new IllegalArgumentException(q.b(str, obj, obj2));
        }
    }

    public static int l(int i7, int i8) {
        return m(i7, i8, "index");
    }

    public static int m(int i7, int i8, String str) {
        if (i7 < 0 || i7 >= i8) {
            throw new IndexOutOfBoundsException(a(i7, i8, str));
        }
        return i7;
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

    public static int q(int i7, int i8) {
        return r(i7, i8, "index");
    }

    public static int r(int i7, int i8, String str) {
        if (i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException(b(i7, i8, str));
        }
        return i7;
    }

    public static void s(int i7, int i8, int i9) {
        if (i7 < 0 || i8 < i7 || i8 > i9) {
            throw new IndexOutOfBoundsException(c(i7, i8, i9));
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

    public static void v(boolean z7, String str, int i7) {
        if (!z7) {
            throw new IllegalStateException(q.b(str, Integer.valueOf(i7)));
        }
    }

    public static void w(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new IllegalStateException(q.b(str, obj));
        }
    }
}
