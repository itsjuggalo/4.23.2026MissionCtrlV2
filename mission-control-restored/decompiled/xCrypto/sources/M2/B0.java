package M2;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f1680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f1682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Z1.p f1683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f1686g;

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!B0.this.f1685f) {
                B0.this.f1686g = null;
                return;
            }
            long j4 = B0.this.j();
            if (B0.this.f1684e - j4 > 0) {
                B0 b02 = B0.this;
                b02.f1686g = b02.f1680a.schedule(new c(), B0.this.f1684e - j4, TimeUnit.NANOSECONDS);
            } else {
                B0.this.f1685f = false;
                B0.this.f1686g = null;
                B0.this.f1682c.run();
            }
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            B0.this.f1681b.execute(new b());
        }
    }

    public B0(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Z1.p pVar) {
        this.f1682c = runnable;
        this.f1681b = executor;
        this.f1680a = scheduledExecutorService;
        this.f1683d = pVar;
        pVar.g();
    }

    public void i(boolean z4) {
        ScheduledFuture scheduledFuture;
        this.f1685f = false;
        if (!z4 || (scheduledFuture = this.f1686g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f1686g = null;
    }

    public final long j() {
        return this.f1683d.d(TimeUnit.NANOSECONDS);
    }

    public void k(long j4, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j4);
        long j5 = j() + nanos;
        this.f1685f = true;
        if (j5 - this.f1684e < 0 || this.f1686g == null) {
            ScheduledFuture scheduledFuture = this.f1686g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f1686g = this.f1680a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f1684e = j5;
    }
}
