package uc;

import cc.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f22962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f22963f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f22964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f22965d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f22966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fc.a f22967b = new fc.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f22968c;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f22966a = scheduledExecutorService;
        }

        @Override // fc.b
        public boolean c() {
            return this.f22968c;
        }

        @Override // cc.r.b
        public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f22968c) {
                return jc.c.INSTANCE;
            }
            h hVar = new h(yc.a.s(runnable), this.f22967b);
            this.f22967b.d(hVar);
            try {
                hVar.a(j10 <= 0 ? this.f22966a.submit((Callable) hVar) : this.f22966a.schedule((Callable) hVar, j10, timeUnit));
                return hVar;
            } catch (RejectedExecutionException e10) {
                dispose();
                yc.a.q(e10);
                return jc.c.INSTANCE;
            }
        }

        @Override // fc.b
        public void dispose() {
            if (this.f22968c) {
                return;
            }
            this.f22968c = true;
            this.f22967b.dispose();
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f22963f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f22962e = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(f22962e);
    }

    public static ScheduledExecutorService e(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // cc.r
    public r.b b() {
        return new a((ScheduledExecutorService) this.f22965d.get());
    }

    @Override // cc.r
    public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        g gVar = new g(yc.a.s(runnable));
        try {
            gVar.a(j10 <= 0 ? ((ScheduledExecutorService) this.f22965d.get()).submit(gVar) : ((ScheduledExecutorService) this.f22965d.get()).schedule(gVar, j10, timeUnit));
            return gVar;
        } catch (RejectedExecutionException e10) {
            yc.a.q(e10);
            return jc.c.INSTANCE;
        }
    }

    public j(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f22965d = atomicReference;
        this.f22964c = threadFactory;
        atomicReference.lazySet(e(threadFactory));
    }
}
