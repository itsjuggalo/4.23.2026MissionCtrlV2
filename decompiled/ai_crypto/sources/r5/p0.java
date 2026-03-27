package r5;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f22772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f22773b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f22774c = new AtomicReference();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f22776b;

        public a(c cVar, Runnable runnable) {
            this.f22775a = cVar;
            this.f22776b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.execute(this.f22775a);
        }

        public String toString() {
            return this.f22776b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f22779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f22780c;

        public b(c cVar, Runnable runnable, long j7) {
            this.f22778a = cVar;
            this.f22779b = runnable;
            this.f22780c = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.execute(this.f22778a);
        }

        public String toString() {
            return this.f22779b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f22780c + ")";
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f22782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22784c;

        public c(Runnable runnable) {
            this.f22782a = (Runnable) H2.m.o(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22783b) {
                return;
            }
            this.f22784c = true;
            this.f22782a.run();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f22785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledFuture f22786b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f22785a.f22783b = true;
            this.f22786b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f22785a;
            return (cVar.f22784c || cVar.f22783b) ? false : true;
        }

        public d(c cVar, ScheduledFuture scheduledFuture) {
            this.f22785a = (c) H2.m.o(cVar, "runnable");
            this.f22786b = (ScheduledFuture) H2.m.o(scheduledFuture, "future");
        }
    }

    public p0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f22772a = (Thread.UncaughtExceptionHandler) H2.m.o(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (com.amazon.a.a.l.d.a(this.f22774c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f22773b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.f22772a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f22774c.set(null);
                    throw th2;
                }
            }
            this.f22774c.set(null);
            if (this.f22773b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f22773b.add((Runnable) H2.m.o(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j7, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j7, timeUnit), null);
    }

    public final d d(Runnable runnable, long j7, long j8, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j8), j7, j8, timeUnit), null);
    }

    public void e() {
        H2.m.u(Thread.currentThread() == this.f22774c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
