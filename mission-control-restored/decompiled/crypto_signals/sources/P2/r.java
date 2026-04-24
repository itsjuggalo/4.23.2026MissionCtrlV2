package P2;

import N1.C0091f0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f2479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f2480d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N2.A f2482b;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f2479c = timeUnit.toMillis(1L);
        f2480d = timeUnit.toMillis(5L);
    }

    public r(C0091f0 c0091f0, N2.A a6) {
        this.f2481a = c0091f0;
        this.f2482b = a6;
    }
}
