package g5;

import P4.r;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f18251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f18252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TimeUnit f18253f = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0310c f18254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f18255h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f18256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18257c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue f18259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final S4.a f18260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f18261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Future f18262e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ThreadFactory f18263f;

        public a(long j8, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j8) : 0L;
            this.f18258a = nanos;
            this.f18259b = new ConcurrentLinkedQueue();
            this.f18260c = new S4.a();
            this.f18263f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, c.f18252e);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f18261d = scheduledExecutorServiceNewScheduledThreadPool;
            this.f18262e = scheduledFutureScheduleWithFixedDelay;
        }

        public void a() {
            if (this.f18259b.isEmpty()) {
                return;
            }
            long jC = c();
            for (C0310c c0310c : this.f18259b) {
                if (c0310c.h() > jC) {
                    return;
                }
                if (this.f18259b.remove(c0310c)) {
                    this.f18260c.b(c0310c);
                }
            }
        }

        public C0310c b() {
            if (this.f18260c.g()) {
                return c.f18254g;
            }
            while (!this.f18259b.isEmpty()) {
                C0310c c0310c = (C0310c) this.f18259b.poll();
                if (c0310c != null) {
                    return c0310c;
                }
            }
            C0310c c0310c2 = new C0310c(this.f18263f);
            this.f18260c.a(c0310c2);
            return c0310c2;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(C0310c c0310c) {
            c0310c.i(c() + this.f18258a);
            this.f18259b.offer(c0310c);
        }

        public void e() {
            this.f18260c.dispose();
            Future future = this.f18262e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f18261d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    public static final class b extends r.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f18265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0310c f18266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f18267d = new AtomicBoolean();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S4.a f18264a = new S4.a();

        public b(a aVar) {
            this.f18265b = aVar;
            this.f18266c = aVar.b();
        }

        @Override // P4.r.b
        public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
            return this.f18264a.g() ? W4.c.INSTANCE : this.f18266c.d(runnable, j8, timeUnit, this.f18264a);
        }

        @Override // S4.b
        public void dispose() {
            if (this.f18267d.compareAndSet(false, true)) {
                this.f18264a.dispose();
                this.f18265b.d(this.f18266c);
            }
        }

        @Override // S4.b
        public boolean g() {
            return this.f18267d.get();
        }
    }

    /* JADX INFO: renamed from: g5.c$c, reason: collision with other inner class name */
    public static final class C0310c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f18268c;

        public C0310c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f18268c = 0L;
        }

        public long h() {
            return this.f18268c;
        }

        public void i(long j8) {
            this.f18268c = j8;
        }
    }

    static {
        C0310c c0310c = new C0310c(new f("RxCachedThreadSchedulerShutdown"));
        f18254g = c0310c;
        c0310c.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f fVar = new f("RxCachedThreadScheduler", iMax);
        f18251d = fVar;
        f18252e = new f("RxCachedWorkerPoolEvictor", iMax);
        a aVar = new a(0L, null, fVar);
        f18255h = aVar;
        aVar.e();
    }

    public c() {
        this(f18251d);
    }

    @Override // P4.r
    public r.b a() {
        return new b((a) this.f18257c.get());
    }

    public void d() {
        a aVar = new a(60L, f18253f, this.f18256b);
        if (com.amazon.a.a.l.d.a(this.f18257c, f18255h, aVar)) {
            return;
        }
        aVar.e();
    }

    public c(ThreadFactory threadFactory) {
        this.f18256b = threadFactory;
        this.f18257c = new AtomicReference(f18255h);
        d();
    }
}
