package b6;

import g6.AbstractC1643c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b6.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1084n0 extends AbstractC1082m0 implements V {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f9080d;

    public C1084n0(Executor executor) {
        this.f9080d = executor;
        AbstractC1643c.a(C0());
    }

    public final void B0(H5.g gVar, RejectedExecutionException rejectedExecutionException) {
        A0.c(gVar, AbstractC1080l0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor C0() {
        return this.f9080d;
    }

    public final ScheduledFuture D0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, H5.g gVar, long j7) {
        try {
            return scheduledExecutorService.schedule(runnable, j7, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e7) {
            B0(gVar, e7);
            return null;
        }
    }

    @Override // b6.V
    public void G(long j7, InterfaceC1085o interfaceC1085o) {
        Executor executorC0 = C0();
        ScheduledExecutorService scheduledExecutorService = executorC0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorC0 : null;
        ScheduledFuture scheduledFutureD0 = scheduledExecutorService != null ? D0(scheduledExecutorService, new P0(this, interfaceC1085o), interfaceC1085o.getContext(), j7) : null;
        if (scheduledFutureD0 != null) {
            A0.f(interfaceC1085o, scheduledFutureD0);
        } else {
            Q.f9020i.G(j7, interfaceC1085o);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorC0 = C0();
        ExecutorService executorService = executorC0 instanceof ExecutorService ? (ExecutorService) executorC0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1084n0) && ((C1084n0) obj).C0() == C0();
    }

    public int hashCode() {
        return System.identityHashCode(C0());
    }

    @Override // b6.V
    public InterfaceC1062c0 i(long j7, Runnable runnable, H5.g gVar) {
        Executor executorC0 = C0();
        ScheduledExecutorService scheduledExecutorService = executorC0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorC0 : null;
        ScheduledFuture scheduledFutureD0 = scheduledExecutorService != null ? D0(scheduledExecutorService, runnable, gVar, j7) : null;
        return scheduledFutureD0 != null ? new C1060b0(scheduledFutureD0) : Q.f9020i.i(j7, runnable, gVar);
    }

    @Override // b6.I
    public String toString() {
        return C0().toString();
    }

    @Override // b6.I
    public void y0(H5.g gVar, Runnable runnable) {
        try {
            Executor executorC0 = C0();
            AbstractC1061c.a();
            executorC0.execute(runnable);
        } catch (RejectedExecutionException e7) {
            AbstractC1061c.a();
            B0(gVar, e7);
            C1058a0.b().y0(gVar, runnable);
        }
    }
}
