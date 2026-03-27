package g5;

import P4.r;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public class e extends r.b implements S4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f18272b;

    public e(ThreadFactory threadFactory) {
        this.f18271a = i.a(threadFactory);
    }

    @Override // P4.r.b
    public S4.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // P4.r.b
    public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
        return this.f18272b ? W4.c.INSTANCE : d(runnable, j8, timeUnit, null);
    }

    public h d(Runnable runnable, long j8, TimeUnit timeUnit, W4.a aVar) {
        h hVar = new h(AbstractC2283a.s(runnable), aVar);
        if (aVar != null && !aVar.a(hVar)) {
            return hVar;
        }
        try {
            hVar.a(j8 <= 0 ? this.f18271a.submit((Callable) hVar) : this.f18271a.schedule((Callable) hVar, j8, timeUnit));
        } catch (RejectedExecutionException e8) {
            if (aVar != null) {
                aVar.b(hVar);
            }
            AbstractC2283a.q(e8);
        }
        return hVar;
    }

    @Override // S4.b
    public void dispose() {
        if (this.f18272b) {
            return;
        }
        this.f18272b = true;
        this.f18271a.shutdownNow();
    }

    public S4.b e(Runnable runnable, long j8, TimeUnit timeUnit) {
        g gVar = new g(AbstractC2283a.s(runnable));
        try {
            gVar.a(j8 <= 0 ? this.f18271a.submit(gVar) : this.f18271a.schedule(gVar, j8, timeUnit));
            return gVar;
        } catch (RejectedExecutionException e8) {
            AbstractC2283a.q(e8);
            return W4.c.INSTANCE;
        }
    }

    public void f() {
        if (this.f18272b) {
            return;
        }
        this.f18272b = true;
        this.f18271a.shutdown();
    }

    @Override // S4.b
    public boolean g() {
        return this.f18272b;
    }
}
