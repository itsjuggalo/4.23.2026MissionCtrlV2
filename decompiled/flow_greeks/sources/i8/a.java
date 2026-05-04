package i8;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import q8.c;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f11838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f11839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f11842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f11843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Random f11844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScheduledFuture f11845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11847j;

    /* JADX INFO: renamed from: i8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class RunnableC0225a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11848a;

        public RunnableC0225a(Runnable runnable) {
            this.f11848a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f11845h = null;
            this.f11848a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f11850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11851b = 1000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f11852c = 0.5d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f11853d = HTTPTimeoutManager.DEFAULT_TIMEOUT_MS;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f11854e = 1.3d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f11855f;

        public b(ScheduledExecutorService scheduledExecutorService, d dVar, String str) {
            this.f11850a = scheduledExecutorService;
            this.f11855f = new c(dVar, str);
        }

        public a a() {
            return new a(this.f11850a, this.f11855f, this.f11851b, this.f11853d, this.f11854e, this.f11852c, null);
        }

        public b b(double d10) {
            if (d10 >= 0.0d && d10 <= 1.0d) {
                this.f11852c = d10;
                return this;
            }
            throw new IllegalArgumentException("Argument out of range: " + d10);
        }

        public b c(long j10) {
            this.f11853d = j10;
            return this;
        }

        public b d(long j10) {
            this.f11851b = j10;
            return this;
        }

        public b e(double d10) {
            this.f11854e = d10;
            return this;
        }
    }

    public /* synthetic */ a(ScheduledExecutorService scheduledExecutorService, c cVar, long j10, long j11, double d10, double d11, RunnableC0225a runnableC0225a) {
        this(scheduledExecutorService, cVar, j10, j11, d10, d11);
    }

    public void b() {
        if (this.f11845h != null) {
            this.f11839b.b("Cancelling existing retry attempt", new Object[0]);
            this.f11845h.cancel(false);
            this.f11845h = null;
        } else {
            this.f11839b.b("No existing retry attempt to cancel", new Object[0]);
        }
        this.f11846i = 0L;
    }

    public void c(Runnable runnable) {
        RunnableC0225a runnableC0225a = new RunnableC0225a(runnable);
        if (this.f11845h != null) {
            this.f11839b.b("Cancelling previous scheduled retry", new Object[0]);
            this.f11845h.cancel(false);
            this.f11845h = null;
        }
        long jNextDouble = 0;
        if (!this.f11847j) {
            long j10 = this.f11846i;
            if (j10 == 0) {
                this.f11846i = this.f11840c;
            } else {
                this.f11846i = Math.min((long) (j10 * this.f11843f), this.f11841d);
            }
            double d10 = this.f11842e;
            long j11 = this.f11846i;
            jNextDouble = (long) (((1.0d - d10) * j11) + (d10 * j11 * this.f11844g.nextDouble()));
        }
        this.f11847j = false;
        this.f11839b.b("Scheduling retry in %dms", Long.valueOf(jNextDouble));
        this.f11845h = this.f11838a.schedule(runnableC0225a, jNextDouble, TimeUnit.MILLISECONDS);
    }

    public void d() {
        this.f11846i = this.f11841d;
    }

    public void e() {
        this.f11847j = true;
        this.f11846i = 0L;
    }

    public a(ScheduledExecutorService scheduledExecutorService, c cVar, long j10, long j11, double d10, double d11) {
        this.f11844g = new Random();
        this.f11847j = true;
        this.f11838a = scheduledExecutorService;
        this.f11839b = cVar;
        this.f11840c = j10;
        this.f11841d = j11;
        this.f11843f = d10;
        this.f11842e = d11;
    }
}
