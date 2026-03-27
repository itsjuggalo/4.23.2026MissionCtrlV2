package l2;

import A.o;
import io.flutter.plugin.platform.p;
import java.io.Serializable;
import java.lang.Thread;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import s3.D;
import u4.m0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Serializable f8089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Serializable f8090d;

    public h(Executor executor, int i) {
        this.f8087a = 0;
        this.f8090d = new LinkedBlockingQueue();
        if (!(i > 0)) {
            throw new IllegalArgumentException("concurrency must be positive.");
        }
        this.f8088b = executor;
        this.f8089c = new Semaphore(i, true);
    }

    public void a() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        do {
            AtomicReference atomicReference = (AtomicReference) this.f8090d;
            Thread threadCurrentThread = Thread.currentThread();
            while (!atomicReference.compareAndSet(null, threadCurrentThread)) {
                if (atomicReference.get() != null) {
                    return;
                }
            }
            while (true) {
                concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f8089c;
                try {
                    Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        ((Thread.UncaughtExceptionHandler) this.f8088b).uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    atomicReference.set(null);
                    throw th2;
                }
            }
            atomicReference.set(null);
        } while (!concurrentLinkedQueue.isEmpty());
    }

    public void b(Runnable runnable) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f8089c;
        D.j(runnable, "runnable is null");
        concurrentLinkedQueue.add(runnable);
    }

    public void c() {
        while (true) {
            Semaphore semaphore = (Semaphore) this.f8089c;
            if (!semaphore.tryAcquire()) {
                return;
            }
            Runnable runnable = (Runnable) ((LinkedBlockingQueue) this.f8090d).poll();
            if (runnable == null) {
                semaphore.release();
                return;
            } else {
                ((Executor) this.f8088b).execute(new f4.c(14, this, runnable));
            }
        }
    }

    public p d(Runnable runnable, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        m0 m0Var = new m0(runnable);
        return new p(m0Var, scheduledExecutorService.schedule(new o(this, m0Var, runnable, 14), j4, timeUnit));
    }

    public void e() {
        D.p("Not called from the SynchronizationContext", Thread.currentThread() == ((AtomicReference) this.f8090d).get());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f8087a) {
            case 0:
                ((LinkedBlockingQueue) this.f8090d).offer(runnable);
                c();
                break;
            default:
                b(runnable);
                a();
                break;
        }
    }

    public h(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f8087a = 1;
        this.f8089c = new ConcurrentLinkedQueue();
        this.f8090d = new AtomicReference();
        this.f8088b = uncaughtExceptionHandler;
    }
}
