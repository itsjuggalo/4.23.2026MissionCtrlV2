package ng;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends p1 implements w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f17177d;

    public q1(Executor executor) {
        this.f17177d = executor;
        if (e0() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) e0()).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // ng.w0
    public e1 K(long j10, Runnable runnable, gd.i iVar) {
        long j11;
        Runnable runnable2;
        gd.i iVar2;
        Executor executorE0 = e0();
        ScheduledFuture scheduledFutureG0 = null;
        ScheduledExecutorService scheduledExecutorService = executorE0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorE0 : null;
        if (scheduledExecutorService != null) {
            j11 = j10;
            runnable2 = runnable;
            iVar2 = iVar;
            scheduledFutureG0 = g0(scheduledExecutorService, runnable2, iVar2, j11);
        } else {
            j11 = j10;
            runnable2 = runnable;
            iVar2 = iVar;
        }
        return scheduledFutureG0 != null ? new d1(scheduledFutureG0) : s0.f17181i.K(j11, runnable2, iVar2);
    }

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        try {
            Executor executorE0 = e0();
            c.a();
            executorE0.execute(runnable);
        } catch (RejectedExecutionException e10) {
            c.a();
            f0(iVar, e10);
            c1.b().Z(iVar, runnable);
        }
    }

    @Override // ng.w0
    public void b(long j10, n nVar) {
        long j11;
        Executor executorE0 = e0();
        ScheduledFuture scheduledFutureG0 = null;
        ScheduledExecutorService scheduledExecutorService = executorE0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorE0 : null;
        if (scheduledExecutorService != null) {
            j11 = j10;
            scheduledFutureG0 = g0(scheduledExecutorService, new q2(this, nVar), nVar.getContext(), j11);
        } else {
            j11 = j10;
        }
        if (scheduledFutureG0 != null) {
            r.c(nVar, new l(scheduledFutureG0));
        } else {
            s0.f17181i.b(j11, nVar);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorE0 = e0();
        ExecutorService executorService = executorE0 instanceof ExecutorService ? (ExecutorService) executorE0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // ng.p1
    public Executor e0() {
        return this.f17177d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof q1) && ((q1) obj).e0() == e0();
    }

    public final void f0(gd.i iVar, RejectedExecutionException rejectedExecutionException) {
        b2.c(iVar, n1.a("The task was rejected", rejectedExecutionException));
    }

    public final ScheduledFuture g0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, gd.i iVar, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            f0(iVar, e10);
            return null;
        }
    }

    public int hashCode() {
        return System.identityHashCode(e0());
    }

    @Override // ng.k0
    public String toString() {
        return e0().toString();
    }
}
