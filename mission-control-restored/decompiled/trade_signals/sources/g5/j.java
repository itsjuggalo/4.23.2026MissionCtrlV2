package g5;

import P4.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f18287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ScheduledExecutorService f18288e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f18289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18290c;

    public static final class a extends r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f18291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final S4.a f18292b = new S4.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f18293c;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f18291a = scheduledExecutorService;
        }

        @Override // P4.r.b
        public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
            if (this.f18293c) {
                return W4.c.INSTANCE;
            }
            h hVar = new h(AbstractC2283a.s(runnable), this.f18292b);
            this.f18292b.a(hVar);
            try {
                hVar.a(j8 <= 0 ? this.f18291a.submit((Callable) hVar) : this.f18291a.schedule((Callable) hVar, j8, timeUnit));
                return hVar;
            } catch (RejectedExecutionException e8) {
                dispose();
                AbstractC2283a.q(e8);
                return W4.c.INSTANCE;
            }
        }

        @Override // S4.b
        public void dispose() {
            if (this.f18293c) {
                return;
            }
            this.f18293c = true;
            this.f18292b.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f18293c;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f18288e = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f18287d = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(f18287d);
    }

    public static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // P4.r
    public r.b a() {
        return new a((ScheduledExecutorService) this.f18290c.get());
    }

    @Override // P4.r
    public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
        g gVar = new g(AbstractC2283a.s(runnable));
        try {
            gVar.a(j8 <= 0 ? ((ScheduledExecutorService) this.f18290c.get()).submit(gVar) : ((ScheduledExecutorService) this.f18290c.get()).schedule(gVar, j8, timeUnit));
            return gVar;
        } catch (RejectedExecutionException e8) {
            AbstractC2283a.q(e8);
            return W4.c.INSTANCE;
        }
    }

    public j(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f18290c = atomicReference;
        this.f18289b = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }
}
