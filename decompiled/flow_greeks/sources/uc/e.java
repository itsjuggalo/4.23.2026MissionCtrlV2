package uc;

import cc.r;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e extends r.b implements fc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f22948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f22949b;

    public e(ThreadFactory threadFactory) {
        this.f22948a = i.a(threadFactory);
    }

    @Override // cc.r.b
    public fc.b b(Runnable runnable) {
        return d(runnable, 0L, null);
    }

    @Override // fc.b
    public boolean c() {
        return this.f22949b;
    }

    @Override // cc.r.b
    public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f22949b ? jc.c.INSTANCE : e(runnable, j10, timeUnit, null);
    }

    @Override // fc.b
    public void dispose() {
        if (this.f22949b) {
            return;
        }
        this.f22949b = true;
        this.f22948a.shutdownNow();
    }

    public h e(Runnable runnable, long j10, TimeUnit timeUnit, jc.a aVar) {
        h hVar = new h(yc.a.s(runnable), aVar);
        if (aVar != null && !aVar.d(hVar)) {
            return hVar;
        }
        try {
            hVar.a(j10 <= 0 ? this.f22948a.submit((Callable) hVar) : this.f22948a.schedule((Callable) hVar, j10, timeUnit));
            return hVar;
        } catch (RejectedExecutionException e10) {
            if (aVar != null) {
                aVar.a(hVar);
            }
            yc.a.q(e10);
            return hVar;
        }
    }

    public fc.b f(Runnable runnable, long j10, TimeUnit timeUnit) {
        g gVar = new g(yc.a.s(runnable));
        try {
            gVar.a(j10 <= 0 ? this.f22948a.submit(gVar) : this.f22948a.schedule(gVar, j10, timeUnit));
            return gVar;
        } catch (RejectedExecutionException e10) {
            yc.a.q(e10);
            return jc.c.INSTANCE;
        }
    }

    public void g() {
        if (this.f22949b) {
            return;
        }
        this.f22949b = true;
        this.f22948a.shutdown();
    }
}
