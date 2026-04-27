package F4;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f1862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f1863b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f1864c = new AtomicReference();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f1866b;

        public a(c cVar, Runnable runnable) {
            this.f1865a = cVar;
            this.f1866b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            n0.this.execute(this.f1865a);
        }

        public String toString() {
            return this.f1866b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f1869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f1870c;

        public b(c cVar, Runnable runnable, long j8) {
            this.f1868a = cVar;
            this.f1869b = runnable;
            this.f1870c = j8;
        }

        @Override // java.lang.Runnable
        public void run() {
            n0.this.execute(this.f1868a);
        }

        public String toString() {
            return this.f1869b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f1870c + ")";
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f1872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1874c;

        public c(Runnable runnable) {
            this.f1872a = (Runnable) AbstractC2848n.o(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1873b) {
                return;
            }
            this.f1874c = true;
            this.f1872a.run();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f1875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledFuture f1876b;

        public d(c cVar, ScheduledFuture scheduledFuture) {
            this.f1875a = (c) AbstractC2848n.o(cVar, "runnable");
            this.f1876b = (ScheduledFuture) AbstractC2848n.o(scheduledFuture, "future");
        }

        public void a() {
            this.f1875a.f1873b = true;
            this.f1876b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f1875a;
            return (cVar.f1874c || cVar.f1873b) ? false : true;
        }

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }
    }

    public n0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1862a = (Thread.UncaughtExceptionHandler) AbstractC2848n.o(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (com.amazon.a.a.l.d.a(this.f1864c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f1863b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.f1862a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f1864c.set(null);
                    throw th2;
                }
            }
            this.f1864c.set(null);
            if (this.f1863b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f1863b.add((Runnable) AbstractC2848n.o(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j8, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j8, timeUnit), null);
    }

    public final d d(Runnable runnable, long j8, long j9, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j9), j8, j9, timeUnit), null);
    }

    public void e() {
        AbstractC2848n.u(Thread.currentThread() == this.f1864c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
