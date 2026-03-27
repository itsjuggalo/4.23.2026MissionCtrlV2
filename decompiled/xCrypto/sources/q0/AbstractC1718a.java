package q0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: q0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1718a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f14164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f14165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f14166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f14167d;

    public static void a(String str, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.a(j(str), i4);
        } else {
            b(j(str), i4);
        }
    }

    public static void b(String str, int i4) {
        try {
            if (f14166c == null) {
                f14166c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f14166c.invoke(null, Long.valueOf(f14164a), str, Integer.valueOf(i4));
        } catch (Exception e4) {
            g("asyncTraceBegin", e4);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.b(j(str), i4);
        } else {
            e(j(str), i4);
        }
    }

    public static void e(String str, int i4) {
        try {
            if (f14167d == null) {
                f14167d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f14167d.invoke(null, Long.valueOf(f14164a), str, Integer.valueOf(i4));
        } catch (Exception e4) {
            g("asyncTraceEnd", e4);
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
            if (f14165b == null) {
                f14164a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f14165b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f14165b.invoke(null, Long.valueOf(f14164a))).booleanValue();
        } catch (Exception e4) {
            g("isTagEnabled", e4);
            return false;
        }
    }

    public static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
