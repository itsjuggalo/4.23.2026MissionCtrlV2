package m2;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f15739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f15740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f15741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f15742d;

    public static void a(String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.a(j(str), i10);
        } else {
            b(j(str), i10);
        }
    }

    public static void b(String str, int i10) {
        try {
            if (f15741c == null) {
                f15741c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f15741c.invoke(null, Long.valueOf(f15739a), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("asyncTraceBegin", e10);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.b(j(str), i10);
        } else {
            e(j(str), i10);
        }
    }

    public static void e(String str, int i10) {
        try {
            if (f15742d == null) {
                f15742d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f15742d.invoke(null, Long.valueOf(f15739a), str, Integer.valueOf(i10));
        } catch (Exception e10) {
            g("asyncTraceEnd", e10);
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
            if (f15740b == null) {
                f15739a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f15740b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f15740b.invoke(null, Long.valueOf(f15739a))).booleanValue();
        } catch (Exception e10) {
            g("isTagEnabled", e10);
            return false;
        }
    }

    public static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
