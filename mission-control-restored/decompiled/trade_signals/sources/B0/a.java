package B0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f124d;

    public static void a(String str, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        String strJ = j(str);
        if (i9 >= 29) {
            c.a(strJ, i8);
        } else {
            b(strJ, i8);
        }
    }

    public static void b(String str, int i8) {
        try {
            if (f123c == null) {
                f123c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f123c.invoke(null, Long.valueOf(f121a), str, Integer.valueOf(i8));
        } catch (Exception e8) {
            g("asyncTraceBegin", e8);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        String strJ = j(str);
        if (i9 >= 29) {
            c.b(strJ, i8);
        } else {
            e(strJ, i8);
        }
    }

    public static void e(String str, int i8) {
        try {
            if (f124d == null) {
                f124d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f124d.invoke(null, Long.valueOf(f121a), str, Integer.valueOf(i8));
        } catch (Exception e8) {
            g("asyncTraceEnd", e8);
        }
    }

    public static void f() {
        b.b();
    }

    public static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29 ? c.c() : i();
    }

    public static boolean i() {
        try {
            if (f122b == null) {
                f121a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f122b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f122b.invoke(null, Long.valueOf(f121a))).booleanValue();
        } catch (Exception e8) {
            g("isTagEnabled", e8);
            return false;
        }
    }

    public static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
