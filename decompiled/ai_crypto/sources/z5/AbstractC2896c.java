package z5;

import H2.q;
import java.util.logging.Logger;
import r5.C2587c;

/* JADX INFO: renamed from: z5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2896c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f26064a = Logger.getLogger(AbstractC2896c.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f26065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2587c.C0351c f26066c;

    /* JADX INFO: renamed from: z5.c$a */
    public enum a {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    static {
        f26065b = !q.a(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f26066c = C2587c.C0351c.b("internal-stub-type");
    }
}
