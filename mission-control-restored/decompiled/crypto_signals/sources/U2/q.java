package U2;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f3167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f3168b;

    public q() {
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.f3168b = new Semaphore(4);
        this.f3167a = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (!this.f3168b.tryAcquire()) {
            runnable.run();
            return;
        }
        try {
            this.f3167a.execute(new E3.h(21, this, runnable));
        } catch (RejectedExecutionException unused) {
            runnable.run();
        }
    }
}
