package p5;

import F5.AbstractC0555m;
import F5.AbstractC0556n;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Q f21674a = new Q();

    public final C2379a a(String channelName) {
        kotlin.jvm.internal.r.f(channelName, "channelName");
        return new C2379a("channel-error", "Unable to establish connection on channel: '" + channelName + "'.", "");
    }

    public final List b(Throwable exception) {
        kotlin.jvm.internal.r.f(exception, "exception");
        if (exception instanceof C2379a) {
            C2379a c2379a = (C2379a) exception;
            return AbstractC0556n.j(c2379a.a(), c2379a.getMessage(), c2379a.b());
        }
        return AbstractC0556n.j(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List c(Object obj) {
        return AbstractC0555m.b(obj);
    }
}
