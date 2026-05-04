package tb;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f20929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f20930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f20931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p6.q f20932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f20933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f20935g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a2.this.f20934f) {
                a2.this.f20935g = null;
                return;
            }
            long j10 = a2.this.j();
            if (a2.this.f20933e - j10 > 0) {
                a2 a2Var = a2.this;
                a2Var.f20935g = a2Var.f20929a.schedule(new c(), a2.this.f20933e - j10, TimeUnit.NANOSECONDS);
            } else {
                a2.this.f20934f = false;
                a2.this.f20935g = null;
                a2.this.f20931c.run();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a2.this.f20930b.execute(new b());
        }
    }

    public a2(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, p6.q qVar) {
        this.f20931c = runnable;
        this.f20930b = executor;
        this.f20929a = scheduledExecutorService;
        this.f20932d = qVar;
        qVar.g();
    }

    public void i(boolean z10) {
        ScheduledFuture scheduledFuture;
        this.f20934f = false;
        if (!z10 || (scheduledFuture = this.f20935g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f20935g = null;
    }

    public final long j() {
        return this.f20932d.d(TimeUnit.NANOSECONDS);
    }

    public void k(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        long j11 = j() + nanos;
        this.f20934f = true;
        if (j11 - this.f20933e < 0 || this.f20935g == null) {
            ScheduledFuture scheduledFuture = this.f20935g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f20935g = this.f20929a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f20933e = j11;
    }
}
