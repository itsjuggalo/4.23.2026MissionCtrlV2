package uc;

import cc.r;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f22926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f22927f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0394c f22930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f22931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f22932k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f22933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f22934d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TimeUnit f22929h = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f22928g = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue f22936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final fc.a f22937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f22938d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Future f22939e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ThreadFactory f22940f;

        public a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f22935a = nanos;
            this.f22936b = new ConcurrentLinkedQueue();
            this.f22937c = new fc.a();
            this.f22940f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, c.f22927f);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.f22938d = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.f22939e = scheduledFutureScheduleWithFixedDelay;
        }

        public void a() {
            if (this.f22936b.isEmpty()) {
                return;
            }
            long jC = c();
            for (C0394c c0394c : this.f22936b) {
                if (c0394c.h() > jC) {
                    return;
                }
                if (this.f22936b.remove(c0394c)) {
                    this.f22937c.a(c0394c);
                }
            }
        }

        public C0394c b() {
            if (this.f22937c.c()) {
                return c.f22930i;
            }
            while (!this.f22936b.isEmpty()) {
                C0394c c0394c = (C0394c) this.f22936b.poll();
                if (c0394c != null) {
                    return c0394c;
                }
            }
            C0394c c0394c2 = new C0394c(this.f22940f);
            this.f22937c.d(c0394c2);
            return c0394c2;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(C0394c c0394c) {
            c0394c.i(c() + this.f22935a);
            this.f22936b.offer(c0394c);
        }

        public void e() {
            this.f22937c.dispose();
            Future future = this.f22939e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f22938d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends r.b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f22942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0394c f22943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f22944d = new AtomicBoolean();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fc.a f22941a = new fc.a();

        public b(a aVar) {
            this.f22942b = aVar;
            this.f22943c = aVar.b();
        }

        @Override // fc.b
        public boolean c() {
            return this.f22944d.get();
        }

        @Override // cc.r.b
        public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f22941a.c() ? jc.c.INSTANCE : this.f22943c.e(runnable, j10, timeUnit, this.f22941a);
        }

        @Override // fc.b
        public void dispose() {
            if (this.f22944d.compareAndSet(false, true)) {
                this.f22941a.dispose();
                if (c.f22931j) {
                    this.f22943c.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f22942b.d(this.f22943c);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22942b.d(this.f22943c);
        }
    }

    /* JADX INFO: renamed from: uc.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0394c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f22945c;

        public C0394c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f22945c = 0L;
        }

        public long h() {
            return this.f22945c;
        }

        public void i(long j10) {
            this.f22945c = j10;
        }
    }

    static {
        C0394c c0394c = new C0394c(new f("RxCachedThreadSchedulerShutdown"));
        f22930i = c0394c;
        c0394c.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f fVar = new f("RxCachedThreadScheduler", iMax);
        f22926e = fVar;
        f22927f = new f("RxCachedWorkerPoolEvictor", iMax);
        f22931j = Boolean.getBoolean("rx2.io-scheduled-release");
        a aVar = new a(0L, null, fVar);
        f22932k = aVar;
        aVar.e();
    }

    public c() {
        this(f22926e);
    }

    @Override // cc.r
    public r.b b() {
        return new b((a) this.f22934d.get());
    }

    public void e() {
        a aVar = new a(f22928g, f22929h, this.f22933c);
        if (com.amazon.a.a.l.d.a(this.f22934d, f22932k, aVar)) {
            return;
        }
        aVar.e();
    }

    public c(ThreadFactory threadFactory) {
        this.f22933c = threadFactory;
        this.f22934d = new AtomicReference(f22932k);
        e();
    }
}
