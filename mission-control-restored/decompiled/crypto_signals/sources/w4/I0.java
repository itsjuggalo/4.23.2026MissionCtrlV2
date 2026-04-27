package w4;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class I0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1343j f10907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f10908b;

    public I0(C1343j c1343j) {
        s3.D.j(c1343j, "executorPool");
        this.f10907a = c1343j;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Executor executor;
        synchronized (this) {
            try {
                if (this.f10908b == null) {
                    Executor executor2 = (Executor) Z1.a((Y1) this.f10907a.f11289b);
                    Executor executor3 = this.f10908b;
                    if (executor2 == null) {
                        throw new NullPointerException(t2.u0.A("%s.getObject()", executor3));
                    }
                    this.f10908b = executor2;
                }
                executor = this.f10908b;
            } catch (Throwable th) {
                throw th;
            }
        }
        executor.execute(runnable);
    }
}
