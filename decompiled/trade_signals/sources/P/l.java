package P;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f6256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f6257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f6258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f6259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f6260e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f6256a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f6257b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f6258c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f6259d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f6260e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e8) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e8);
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
