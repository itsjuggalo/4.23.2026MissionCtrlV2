package f7;

import d7.E;
import d7.G;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17638a = E.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f17639b = G.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17640c = G.e("kotlinx.coroutines.scheduler.core.pool.size", H5.i.b(E.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f17641d = G.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f17642e = TimeUnit.SECONDS.toNanos(G.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g f17643f = e.f17629a;

    public static final h b(Runnable runnable, long j8, boolean z7) {
        return new i(runnable, j8, z7);
    }

    public static final String c(boolean z7) {
        return z7 ? "Blocking" : "Non-blocking";
    }
}
