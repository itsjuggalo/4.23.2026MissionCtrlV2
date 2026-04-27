package g3;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import o3.C2460c;
import o3.InterfaceC2461d;

/* JADX INFO: renamed from: g3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1784a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f17982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2460c f17983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f17986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f17987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Random f17988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScheduledFuture f17989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f17990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17991j;

    /* JADX INFO: renamed from: g3.a$a, reason: collision with other inner class name */
    public class RunnableC0305a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17992a;

        public RunnableC0305a(Runnable runnable) {
            this.f17992a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1784a.this.f17989h = null;
            this.f17992a.run();
        }
    }

    /* JADX INFO: renamed from: g3.a$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f17994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17995b = 1000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f17996c = 0.5d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17997d = 30000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f17998e = 1.3d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C2460c f17999f;

        public b(ScheduledExecutorService scheduledExecutorService, InterfaceC2461d interfaceC2461d, String str) {
            this.f17994a = scheduledExecutorService;
            this.f17999f = new C2460c(interfaceC2461d, str);
        }

        public C1784a a() {
            return new C1784a(this.f17994a, this.f17999f, this.f17995b, this.f17997d, this.f17998e, this.f17996c, null);
        }

        public b b(double d8) {
            if (d8 >= 0.0d && d8 <= 1.0d) {
                this.f17996c = d8;
                return this;
            }
            throw new IllegalArgumentException("Argument out of range: " + d8);
        }

        public b c(long j8) {
            this.f17997d = j8;
            return this;
        }

        public b d(long j8) {
            this.f17995b = j8;
            return this;
        }

        public b e(double d8) {
            this.f17998e = d8;
            return this;
        }
    }

    public C1784a(ScheduledExecutorService scheduledExecutorService, C2460c c2460c, long j8, long j9, double d8, double d9) {
        this.f17988g = new Random();
        this.f17991j = true;
        this.f17982a = scheduledExecutorService;
        this.f17983b = c2460c;
        this.f17984c = j8;
        this.f17985d = j9;
        this.f17987f = d8;
        this.f17986e = d9;
    }

    public void b() {
        if (this.f17989h != null) {
            this.f17983b.b("Cancelling existing retry attempt", new Object[0]);
            this.f17989h.cancel(false);
            this.f17989h = null;
        } else {
            this.f17983b.b("No existing retry attempt to cancel", new Object[0]);
        }
        this.f17990i = 0L;
    }

    public void c(Runnable runnable) {
        RunnableC0305a runnableC0305a = new RunnableC0305a(runnable);
        if (this.f17989h != null) {
            this.f17983b.b("Cancelling previous scheduled retry", new Object[0]);
            this.f17989h.cancel(false);
            this.f17989h = null;
        }
        long jNextDouble = 0;
        if (!this.f17991j) {
            long j8 = this.f17990i;
            this.f17990i = j8 == 0 ? this.f17984c : Math.min((long) (j8 * this.f17987f), this.f17985d);
            double d8 = this.f17986e;
            long j9 = this.f17990i;
            jNextDouble = (long) (((1.0d - d8) * j9) + (d8 * j9 * this.f17988g.nextDouble()));
        }
        this.f17991j = false;
        this.f17983b.b("Scheduling retry in %dms", Long.valueOf(jNextDouble));
        this.f17989h = this.f17982a.schedule(runnableC0305a, jNextDouble, TimeUnit.MILLISECONDS);
    }

    public void d() {
        this.f17990i = this.f17985d;
    }

    public void e() {
        this.f17991j = true;
        this.f17990i = 0L;
    }

    public /* synthetic */ C1784a(ScheduledExecutorService scheduledExecutorService, C2460c c2460c, long j8, long j9, double d8, double d9, RunnableC0305a runnableC0305a) {
        this(scheduledExecutorService, c2460c, j8, j9, d8, d9);
    }
}
