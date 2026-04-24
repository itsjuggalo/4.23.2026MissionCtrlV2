package i6;

import g6.G;
import g6.I;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16480a = G.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f16481b = I.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16482c = I.e("kotlinx.coroutines.scheduler.core.pool.size", W5.l.b(G.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16483d = I.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f16484e = TimeUnit.SECONDS.toNanos(I.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g f16485f = e.f16470a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f16486g = new j(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f16487h = new j(1);
}
