package K2;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f1282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f1283b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f1284c = new AtomicReference();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f1286b;

        public a(c cVar, Runnable runnable) {
            this.f1285a = cVar;
            this.f1286b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.execute(this.f1285a);
        }

        public String toString() {
            return this.f1286b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f1289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f1290c;

        public b(c cVar, Runnable runnable, long j4) {
            this.f1288a = cVar;
            this.f1289b = runnable;
            this.f1290c = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.execute(this.f1288a);
        }

        public String toString() {
            return this.f1289b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f1290c + ")";
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f1292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1294c;

        public c(Runnable runnable) {
            this.f1292a = (Runnable) Z1.m.o(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1293b) {
                return;
            }
            this.f1294c = true;
            this.f1292a.run();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f1295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledFuture f1296b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f1295a.f1293b = true;
            this.f1296b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f1295a;
            return (cVar.f1294c || cVar.f1293b) ? false : true;
        }

        public d(c cVar, ScheduledFuture scheduledFuture) {
            this.f1295a = (c) Z1.m.o(cVar, "runnable");
            this.f1296b = (ScheduledFuture) Z1.m.o(scheduledFuture, "future");
        }
    }

    public p0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1282a = (Thread.UncaughtExceptionHandler) Z1.m.o(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (com.amazon.a.a.l.d.a(this.f1284c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f1283b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.f1282a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f1284c.set(null);
                    throw th2;
                }
            }
            this.f1284c.set(null);
            if (this.f1283b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f1283b.add((Runnable) Z1.m.o(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j4, timeUnit), null);
    }

    public final d d(Runnable runnable, long j4, long j5, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j5), j4, j5, timeUnit), null);
    }

    public void e() {
        Z1.m.u(Thread.currentThread() == this.f1284c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
