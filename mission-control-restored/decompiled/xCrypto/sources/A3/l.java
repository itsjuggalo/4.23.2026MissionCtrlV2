package A3;

import java.util.concurrent.TimeUnit;
import o3.AbstractC1681l;
import y3.G;
import y3.I;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f95a = G.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f96b = I.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f97c = I.e("kotlinx.coroutines.scheduler.core.pool.size", AbstractC1681l.b(G.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f98d = I.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f99e = TimeUnit.SECONDS.toNanos(I.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g f100f = e.f85a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f101g = new j(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f102h = new j(1);
}
