package K3;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Semaphore f3433a = new Semaphore(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3434b = 0;

    public void b() {
        try {
            this.f3433a.acquire(this.f3434b);
            this.f3434b = 0;
        } catch (InterruptedException e7) {
            Thread.currentThread().interrupt();
            AbstractC0612b.a("Interrupted while waiting for background task", e7);
        }
    }

    public final /* synthetic */ void c(Runnable runnable) {
        runnable.run();
        this.f3433a.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        this.f3434b++;
        p.f3452c.execute(new Runnable() { // from class: K3.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f3431a.c(runnable);
            }
        });
    }
}
