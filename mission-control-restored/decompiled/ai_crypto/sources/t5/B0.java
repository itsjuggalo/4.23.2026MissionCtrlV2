package t5;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f23235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f23236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f23237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H2.p f23238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f23239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f23241g;

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!B0.this.f23240f) {
                B0.this.f23241g = null;
                return;
            }
            long j7 = B0.this.j();
            if (B0.this.f23239e - j7 > 0) {
                B0 b02 = B0.this;
                b02.f23241g = b02.f23235a.schedule(new c(), B0.this.f23239e - j7, TimeUnit.NANOSECONDS);
            } else {
                B0.this.f23240f = false;
                B0.this.f23241g = null;
                B0.this.f23237c.run();
            }
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            B0.this.f23236b.execute(new b());
        }
    }

    public B0(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, H2.p pVar) {
        this.f23237c = runnable;
        this.f23236b = executor;
        this.f23235a = scheduledExecutorService;
        this.f23238d = pVar;
        pVar.g();
    }

    public void i(boolean z7) {
        ScheduledFuture scheduledFuture;
        this.f23240f = false;
        if (!z7 || (scheduledFuture = this.f23241g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f23241g = null;
    }

    public final long j() {
        return this.f23238d.d(TimeUnit.NANOSECONDS);
    }

    public void k(long j7, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j7);
        long j8 = j() + nanos;
        this.f23240f = true;
        if (j8 - this.f23239e < 0 || this.f23241g == null) {
            ScheduledFuture scheduledFuture = this.f23241g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f23241g = this.f23235a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f23239e = j8;
    }
}
