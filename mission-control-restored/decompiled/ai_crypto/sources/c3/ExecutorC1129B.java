package c3;

import b3.AbstractC0981D;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: c3.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ExecutorC1129B implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f9340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f9341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f9342c = new LinkedBlockingQueue();

    public ExecutorC1129B(Executor executor, int i7) {
        AbstractC0981D.a(i7 > 0, "concurrency must be positive.");
        this.f9340a = executor;
        this.f9341b = new Semaphore(i7, true);
    }

    public final Runnable b(final Runnable runnable) {
        return new Runnable() { // from class: c3.A
            @Override // java.lang.Runnable
            public final void run() {
                this.f9338a.c(runnable);
            }
        };
    }

    public final /* synthetic */ void c(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            this.f9341b.release();
            d();
        }
    }

    public final void d() {
        while (this.f9341b.tryAcquire()) {
            Runnable runnable = (Runnable) this.f9342c.poll();
            if (runnable == null) {
                this.f9341b.release();
                return;
            }
            this.f9340a.execute(b(runnable));
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f9342c.offer(runnable);
        d();
    }
}
