package rb;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f19658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f19659b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f19660c = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f19662b;

        public a(c cVar, Runnable runnable) {
            this.f19661a = cVar;
            this.f19662b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.this.execute(this.f19661a);
        }

        public String toString() {
            return this.f19662b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f19665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f19666c;

        public b(c cVar, Runnable runnable, long j10) {
            this.f19664a = cVar;
            this.f19665b = runnable;
            this.f19666c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.this.execute(this.f19664a);
        }

        public String toString() {
            return this.f19665b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f19666c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f19668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19670c;

        public c(Runnable runnable) {
            this.f19668a = (Runnable) p6.n.o(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19669b) {
                return;
            }
            this.f19670c = true;
            this.f19668a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledFuture f19672b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f19671a.f19669b = true;
            this.f19672b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f19671a;
            return (cVar.f19670c || cVar.f19669b) ? false : true;
        }

        public d(c cVar, ScheduledFuture scheduledFuture) {
            this.f19671a = (c) p6.n.o(cVar, "runnable");
            this.f19672b = (ScheduledFuture) p6.n.o(scheduledFuture, "future");
        }
    }

    public o1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f19658a = (Thread.UncaughtExceptionHandler) p6.n.o(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (com.amazon.a.a.l.d.a(this.f19660c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f19659b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.f19658a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f19660c.set(null);
                    throw th2;
                }
            }
            this.f19660c.set(null);
            if (this.f19659b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f19659b.add((Runnable) p6.n.o(runnable, "runnable is null"));
    }

    public final d d(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j10, timeUnit), null);
    }

    public final d e(Runnable runnable, long j10, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j11), j10, j11, timeUnit), null);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }

    public void f() {
        p6.n.u(Thread.currentThread() == this.f19660c.get(), "Not called from the SynchronizationContext");
    }
}
