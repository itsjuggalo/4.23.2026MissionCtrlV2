package D;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f302e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f298a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f299b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f300c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f301d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f302e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e4) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e4);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
