package S2;

import K2.C0355c;
import Z1.q;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5094a = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0355c.C0031c f5096c;

    public enum a {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    static {
        f5095b = !q.a(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f5096c = C0355c.C0031c.b("internal-stub-type");
    }
}
