package N2;

import N2.p;
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
    public final ExecutorService f5527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f5528b;

    public o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f5527a = executorService;
        this.f5528b = scheduledExecutorService;
    }

    public static /* synthetic */ void Q(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e8) {
            bVar.a(e8);
        }
    }

    public static /* synthetic */ void U(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e8) {
            bVar.a(e8);
        }
    }

    public static /* synthetic */ void b0(Runnable runnable, p.b bVar) throws Exception {
        try {
            runnable.run();
        } catch (Exception e8) {
            bVar.a(e8);
            throw e8;
        }
    }

    public static /* synthetic */ void v0(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e8) {
            bVar.a(e8);
        }
    }

    public final /* synthetic */ void R(final Runnable runnable, final p.b bVar) {
        this.f5527a.execute(new Runnable() { // from class: N2.m
            @Override // java.lang.Runnable
            public final void run() {
                o.Q(runnable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture T(final Runnable runnable, long j8, TimeUnit timeUnit, final p.b bVar) {
        return this.f5528b.schedule(new Runnable() { // from class: N2.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f5514a.R(runnable, bVar);
            }
        }, j8, timeUnit);
    }

    public final /* synthetic */ Future W(final Callable callable, final p.b bVar) {
        return this.f5527a.submit(new Runnable() { // from class: N2.n
            @Override // java.lang.Runnable
            public final void run() {
                o.U(callable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture X(final Callable callable, long j8, TimeUnit timeUnit, final p.b bVar) {
        return this.f5528b.schedule(new Callable() { // from class: N2.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5517a.W(callable, bVar);
            }
        }, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j8, TimeUnit timeUnit) {
        return this.f5527a.awaitTermination(j8, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f5527a.execute(runnable);
    }

    public final /* synthetic */ void i0(final Runnable runnable, final p.b bVar) {
        this.f5527a.execute(new Runnable() { // from class: N2.d
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                o.b0(runnable, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f5527a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f5527a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f5527a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f5527a.isTerminated();
    }

    public final /* synthetic */ ScheduledFuture m0(final Runnable runnable, long j8, long j9, TimeUnit timeUnit, final p.b bVar) {
        return this.f5528b.scheduleAtFixedRate(new Runnable() { // from class: N2.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f5511a.i0(runnable, bVar);
            }
        }, j8, j9, timeUnit);
    }

    public final /* synthetic */ void r0(final Runnable runnable, final p.b bVar) {
        this.f5527a.execute(new Runnable() { // from class: N2.e
            @Override // java.lang.Runnable
            public final void run() {
                o.v0(runnable, bVar);
            }
        });
    }

    public final /* synthetic */ ScheduledFuture s0(final Runnable runnable, long j8, long j9, TimeUnit timeUnit, final p.b bVar) {
        return this.f5528b.scheduleWithFixedDelay(new Runnable() { // from class: N2.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f5520a.r0(runnable, bVar);
            }
        }, j8, j9, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j8, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: N2.c
            @Override // N2.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f5489a.T(runnable, j8, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j8, final long j9, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: N2.f
            @Override // N2.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f5497a.m0(runnable, j8, j9, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j8, final long j9, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: N2.g
            @Override // N2.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f5502a.s0(runnable, j8, j9, timeUnit, bVar);
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
    public Future submit(Runnable runnable) {
        return this.f5527a.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j8, TimeUnit timeUnit) {
        return this.f5527a.invokeAll(collection, j8, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j8, TimeUnit timeUnit) {
        return this.f5527a.invokeAny(collection, j8, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j8, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: N2.h
            @Override // N2.p.c
            public final ScheduledFuture a(p.b bVar) {
                return this.f5507a.X(callable, j8, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f5527a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f5527a.submit(callable);
    }
}
