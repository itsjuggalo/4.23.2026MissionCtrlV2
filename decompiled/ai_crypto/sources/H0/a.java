package H0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f2549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f2551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f2552d;

    public static void a(String str, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.a(j(str), i7);
        } else {
            b(j(str), i7);
        }
    }

    public static void b(String str, int i7) {
        try {
            if (f2551c == null) {
                f2551c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f2551c.invoke(null, Long.valueOf(f2549a), str, Integer.valueOf(i7));
        } catch (Exception e7) {
            g("asyncTraceBegin", e7);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.b(j(str), i7);
        } else {
            e(j(str), i7);
        }
    }

    public static void e(String str, int i7) {
        try {
            if (f2552d == null) {
                f2552d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f2552d.invoke(null, Long.valueOf(f2549a), str, Integer.valueOf(i7));
        } catch (Exception e7) {
            g("asyncTraceEnd", e7);
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
            if (f2550b == null) {
                f2549a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2550b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2550b.invoke(null, Long.valueOf(f2549a))).booleanValue();
        } catch (Exception e7) {
            g("isTagEnabled", e7);
            return false;
        }
    }

    public static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
