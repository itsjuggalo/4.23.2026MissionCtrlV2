package kotlin.jvm.internal;

import java.util.Arrays;
import o5.C2469G;

/* JADX INFO: renamed from: kotlin.jvm.internal.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2304t {
    public static boolean a(Double d8, Double d9) {
        if (d8 == null) {
            if (d9 != null) {
                return false;
            }
        } else if (d9 == null || d8.doubleValue() != d9.doubleValue()) {
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

    public static int g(int i8, int i9) {
        if (i8 < i9) {
            return -1;
        }
        return i8 == i9 ? 0 : 1;
    }

    public static int h(long j8, long j9) {
        if (j8 < j9) {
            return -1;
        }
        return j8 == j9 ? 0 : 1;
    }

    public static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = AbstractC2304t.class.getName();
        int i8 = 0;
        while (!stackTrace[i8].getClassName().equals(name)) {
            i8++;
        }
        while (stackTrace[i8].getClassName().equals(name)) {
            i8++;
        }
        StackTraceElement stackTraceElement = stackTrace[i8];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void j(int i8, String str) {
        p();
    }

    public static Throwable k(Throwable th) {
        return l(th, AbstractC2304t.class.getName());
    }

    public static Throwable l(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i8 = -1;
        for (int i9 = 0; i9 < length; i9++) {
            if (str.equals(stackTrace[i9].getClassName())) {
                i8 = i9;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i8 + 1, length));
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
        throw ((C2469G) k(new C2469G(str)));
    }

    public static void s(String str) {
        r("lateinit property " + str + " has not been initialized");
    }
}
