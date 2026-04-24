package t3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import y3.AbstractC1949c;

/* JADX INFO: renamed from: t3.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1829n0 extends AbstractC1827m0 implements V {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f15022d;

    public C1829n0(Executor executor) {
        this.f15022d = executor;
        AbstractC1949c.a(h0());
    }

    @Override // t3.V
    public InterfaceC1807c0 a0(long j4, Runnable runnable, Z2.i iVar) {
        long j5;
        Runnable runnable2;
        Z2.i iVar2;
        Executor executorH0 = h0();
        ScheduledFuture scheduledFutureI0 = null;
        ScheduledExecutorService scheduledExecutorService = executorH0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorH0 : null;
        if (scheduledExecutorService != null) {
            j5 = j4;
            runnable2 = runnable;
            iVar2 = iVar;
            scheduledFutureI0 = i0(scheduledExecutorService, runnable2, iVar2, j5);
        } else {
            j5 = j4;
            runnable2 = runnable;
            iVar2 = iVar;
        }
        return scheduledFutureI0 != null ? new C1805b0(scheduledFutureI0) : Q.f14962i.a0(j5, runnable2, iVar2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorH0 = h0();
        ExecutorService executorService = executorH0 instanceof ExecutorService ? (ExecutorService) executorH0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // t3.I
    public void d0(Z2.i iVar, Runnable runnable) {
        try {
            Executor executorH0 = h0();
            AbstractC1806c.a();
            executorH0.execute(runnable);
        } catch (RejectedExecutionException e4) {
            AbstractC1806c.a();
            g0(iVar, e4);
            C1803a0.b().d0(iVar, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1829n0) && ((C1829n0) obj).h0() == h0();
    }

    public final void g0(Z2.i iVar, RejectedExecutionException rejectedExecutionException) {
        A0.c(iVar, AbstractC1825l0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor h0() {
        return this.f15022d;
    }

    public int hashCode() {
        return System.identityHashCode(h0());
    }

    public final ScheduledFuture i0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, Z2.i iVar, long j4) {
        try {
            return scheduledExecutorService.schedule(runnable, j4, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e4) {
            g0(iVar, e4);
            return null;
        }
    }

    @Override // t3.V
    public void p(long j4, InterfaceC1830o interfaceC1830o) {
        long j5;
        Executor executorH0 = h0();
        ScheduledFuture scheduledFutureI0 = null;
        ScheduledExecutorService scheduledExecutorService = executorH0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorH0 : null;
        if (scheduledExecutorService != null) {
            j5 = j4;
            scheduledFutureI0 = i0(scheduledExecutorService, new P0(this, interfaceC1830o), interfaceC1830o.getContext(), j5);
        } else {
            j5 = j4;
        }
        if (scheduledFutureI0 != null) {
            A0.f(interfaceC1830o, scheduledFutureI0);
        } else {
            Q.f14962i.p(j5, interfaceC1830o);
        }
    }

    @Override // t3.I
    public String toString() {
        return h0().toString();
    }
}
