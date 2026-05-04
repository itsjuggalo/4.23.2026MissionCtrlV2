package p0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f18170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f18171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f18172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f18173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f18174e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f18170a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f18171b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f18172c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f18173d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f18174e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e10) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e10);
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
