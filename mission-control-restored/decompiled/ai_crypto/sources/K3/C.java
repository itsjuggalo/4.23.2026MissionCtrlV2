package K3;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class C implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f3385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f3386b;

    public C(int i7, Executor executor) {
        this.f3386b = new Semaphore(i7);
        this.f3385a = executor;
    }

    public final /* synthetic */ void b(Runnable runnable) {
        runnable.run();
        this.f3386b.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (!this.f3386b.tryAcquire()) {
            runnable.run();
            return;
        }
        try {
            this.f3385a.execute(new Runnable() { // from class: K3.B
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3383a.b(runnable);
                }
            });
        } catch (RejectedExecutionException unused) {
            runnable.run();
        }
    }
}
