package n9;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f16892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f16893b;

    public a0(int i10, Executor executor) {
        this.f16893b = new Semaphore(i10);
        this.f16892a = executor;
    }

    public static /* synthetic */ void a(a0 a0Var, Runnable runnable) {
        a0Var.getClass();
        runnable.run();
        a0Var.f16893b.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (!this.f16893b.tryAcquire()) {
            runnable.run();
            return;
        }
        try {
            this.f16892a.execute(new Runnable() { // from class: n9.z
                @Override // java.lang.Runnable
                public final void run() {
                    a0.a(this.f16982a, runnable);
                }
            });
        } catch (RejectedExecutionException unused) {
            runnable.run();
        }
    }
}
