package h5;

import f5.u;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f6692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6694d;
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f6695f;

    static {
        String property;
        int i = u.f6535a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f6691a = property;
        f6692b = f5.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i6 = u.f6535a;
        if (i6 < 2) {
            i6 = 2;
        }
        f6693c = f5.a.j(i6, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f6694d = f5.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(f5.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f6695f = g.f6686a;
    }
}
