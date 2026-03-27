package kotlin.jvm.internal;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public static boolean a(Double d7, Double d8) {
        if (d7 == null) {
            if (d8 != null) {
                return false;
            }
        } else if (d8 == null || d7.doubleValue() != d8.doubleValue()) {
            return false;
        }
        return true;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void c(Object obj) {
        if (obj == null) {
            m();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            n(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) k(new NullPointerException(str + " must not be null")));
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            o(str);
        }
    }

    public static int g(int i7, int i8) {
        if (i7 < i8) {
            return -1;
        }
        return i7 == i8 ? 0 : 1;
    }

    public static int h(long j7, long j8) {
        if (j7 < j8) {
            return -1;
        }
        return j7 == j8 ? 0 : 1;
    }

    public static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = r.class.getName();
        int i7 = 0;
        while (!stackTrace[i7].getClassName().equals(name)) {
            i7++;
        }
        while (stackTrace[i7].getClassName().equals(name)) {
            i7++;
        }
        StackTraceElement stackTraceElement = stackTrace[i7];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void j(int i7, String str) {
        p();
    }

    public static Throwable k(Throwable th) {
        return l(th, r.class.getName());
    }

    public static Throwable l(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.equals(stackTrace[i8].getClassName())) {
                i7 = i8;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i7 + 1, length));
        return th;
    }

    public static void m() {
        throw ((NullPointerException) k(new NullPointerException()));
    }

    public static void n(String str) {
        throw ((NullPointerException) k(new NullPointerException(str)));
    }

    public static void o(String str) {
        throw ((NullPointerException) k(new NullPointerException(i(str))));
    }

    public static void p() {
        q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void q(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void r(String str) {
        throw ((E5.D) k(new E5.D(str)));
    }

    public static void s(String str) {
        r("lateinit property " + str + " has not been initialized");
    }
}
