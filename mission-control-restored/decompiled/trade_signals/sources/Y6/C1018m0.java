package Y6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: Y6.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1018m0 extends AbstractC1016l0 implements V {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f9678d;

    public C1018m0(Executor executor) {
        this.f9678d = executor;
        if (A0() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) A0()).setRemoveOnCancelPolicy(true);
        }
    }

    public Executor A0() {
        return this.f9678d;
    }

    public final ScheduledFuture B0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, InterfaceC2711i interfaceC2711i, long j8) {
        try {
            return scheduledExecutorService.schedule(runnable, j8, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            z0(interfaceC2711i, e8);
            return null;
        }
    }

    @Override // Y6.V
    public void U(long j8, InterfaceC1015l interfaceC1015l) {
        Executor executorA0 = A0();
        ScheduledExecutorService scheduledExecutorService = executorA0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorA0 : null;
        ScheduledFuture scheduledFutureB0 = scheduledExecutorService != null ? B0(scheduledExecutorService, new K0(this, interfaceC1015l), interfaceC1015l.getContext(), j8) : null;
        if (scheduledFutureB0 != null) {
            AbstractC1023p.c(interfaceC1015l, new C1011j(scheduledFutureB0));
        } else {
            Q.f9641i.U(j8, interfaceC1015l);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorA0 = A0();
        ExecutorService executorService = executorA0 instanceof ExecutorService ? (ExecutorService) executorA0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1018m0) && ((C1018m0) obj).A0() == A0();
    }

    public int hashCode() {
        return System.identityHashCode(A0());
    }

    @Override // Y6.I
    public String toString() {
        return A0().toString();
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        try {
            Executor executorA0 = A0();
            AbstractC0997c.a();
            executorA0.execute(runnable);
        } catch (RejectedExecutionException e8) {
            AbstractC0997c.a();
            z0(interfaceC2711i, e8);
            C0994a0.b().v0(interfaceC2711i, runnable);
        }
    }

    public final void z0(InterfaceC2711i interfaceC2711i, RejectedExecutionException rejectedExecutionException) {
        x0.c(interfaceC2711i, AbstractC1012j0.a("The task was rejected", rejectedExecutionException));
    }
}
