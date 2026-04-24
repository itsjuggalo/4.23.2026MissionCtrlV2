package G4;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import v2.C2851q;

/* JADX INFO: loaded from: classes2.dex */
public final class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f2272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f2273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f2274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2851q f2275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f2278g;

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!B0.this.f2277f) {
                B0.this.f2278g = null;
                return;
            }
            long j8 = B0.this.j();
            if (B0.this.f2276e - j8 > 0) {
                B0 b02 = B0.this;
                b02.f2278g = b02.f2272a.schedule(new c(), B0.this.f2276e - j8, TimeUnit.NANOSECONDS);
            } else {
                B0.this.f2277f = false;
                B0.this.f2278g = null;
                B0.this.f2274c.run();
            }
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            B0.this.f2273b.execute(new b());
        }
    }

    public B0(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, C2851q c2851q) {
        this.f2274c = runnable;
        this.f2273b = executor;
        this.f2272a = scheduledExecutorService;
        this.f2275d = c2851q;
        c2851q.g();
    }

    public void i(boolean z7) {
        ScheduledFuture scheduledFuture;
        this.f2277f = false;
        if (!z7 || (scheduledFuture = this.f2278g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f2278g = null;
    }

    public final long j() {
        return this.f2275d.d(TimeUnit.NANOSECONDS);
    }

    public void k(long j8, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j8);
        long j9 = j() + nanos;
        this.f2277f = true;
        if (j9 - this.f2276e < 0 || this.f2278g == null) {
            ScheduledFuture scheduledFuture = this.f2278g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f2278g = this.f2272a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f2276e = j9;
    }
}
