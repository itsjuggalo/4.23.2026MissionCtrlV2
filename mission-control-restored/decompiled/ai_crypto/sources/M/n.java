package M;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f3720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f3721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f3722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f3723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f3724e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f3720a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f3721b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f3722c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f3723d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f3724e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e7) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e7);
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
