package c3;

import c3.p;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class o implements ScheduledExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f9406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f9407b;

    public o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f9406a = executorService;
        this.f9407b = scheduledExecutorService;
    }

    public static /* synthetic */ void C0(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e7) {
            bVar.a(e7);
        }
    }

    public static /* synthetic */ void F0(Runnable runnable, p.b bVar) throws Exception {
        try {
            runnable.run();
        } catch (Exception e7) {
            bVar.a(e7);
            throw e7;
        }
    }

    public static /* synthetic */ void K0(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e7) {
            bVar.a(e7);
        }
    }

    public static /* synthetic */ void z0(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e7) {
            bVar.a(e7);
        }
    }

    public final /* synthetic */ void A0(final Runnable runnable, final p.b bVar) {
        this.f9406a.execute(new Runnable() { // from class: c3.m
            @Override // java.lang.Runnable
            public final void run() {
                o.z0(runnable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture B0(final Runnable runnable, long j7, TimeUnit timeUnit, final p.b bVar) {
        return this.f9407b.schedule(new Runnable() { // from class: c3.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f9393a.A0(runnable, bVar);
            }
        }, j7, timeUnit);
    }

    public final /* synthetic */ Future D0(final Callable callable, final p.b bVar) {
        return this.f9406a.submit(new Runnable() { // from class: c3.n
            @Override // java.lang.Runnable
            public final void run() {
                o.C0(callable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture E0(final Callable callable, long j7, TimeUnit timeUnit, final p.b bVar) {
        return this.f9407b.schedule(new Callable() { // from class: c3.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f9396a.D0(callable, bVar);
            }
        }, j7, timeUnit);
    }

    public final /* synthetic */ void G0(final Runnable runnable, final p.b bVar) {
        this.f9406a.execute(new Runnable() { // from class: c3.d
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                o.F0(runnable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture H0(final Runnable runnable, long j7, long j8, TimeUnit timeUnit, final p.b bVar) {
        return this.f9407b.scheduleAtFixedRate(new Runnable() { // from class: c3.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f9390a.G0(runnable, bVar);
            }
        }, j7, j8, timeUnit);
    }

    public final /* synthetic */ void I0(final Runnable runnable, final p.b bVar) {
        this.f9406a.execute(new Runnable() { // from class: c3.e
            @Override // java.lang.Runnable
            public final void run() {
                o.K0(runnable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture J0(final Runnable runnable, long j7, long j8, TimeUnit timeUnit, final p.b bVar) {
        return this.f9407b.scheduleWithFixedDelay(new Runnable() { // from class: c3.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f9399a.I0(runnable, bVar);
            }
        }, j7, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j7, TimeUnit timeUnit) {
        return this.f9406a.awaitTermination(j7, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f9406a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f9406a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f9406a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f9406a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f9406a.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j7, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: c3.c
            @Override // c3.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f9368a.B0(runnable, j7, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j7, final long j8, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: c3.f
            @Override // c3.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f9376a.H0(runnable, j7, j8, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j7, final long j8, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: c3.g
            @Override // c3.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f9381a.J0(runnable, j7, j8, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f9406a.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j7, TimeUnit timeUnit) {
        return this.f9406a.invokeAll(collection, j7, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j7, TimeUnit timeUnit) {
        return this.f9406a.invokeAny(collection, j7, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j7, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: c3.h
            @Override // c3.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f9386a.E0(callable, j7, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f9406a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f9406a.submit(runnable);
    }
}
