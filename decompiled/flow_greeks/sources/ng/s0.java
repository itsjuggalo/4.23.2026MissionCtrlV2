package ng;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import ng.j1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends j1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final s0 f17181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f17182j;

    static {
        Long l10;
        s0 s0Var = new s0();
        f17181i = s0Var;
        i1.k0(s0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f17182j = timeUnit.toNanos(l10.longValue());
    }

    @Override // ng.j1, ng.w0
    public e1 K(long j10, Runnable runnable, gd.i iVar) {
        return H0(j10, runnable);
    }

    public final synchronized void K0() {
        if (N0()) {
            debugStatus = 3;
            E0();
            kotlin.jvm.internal.t.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread L0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(f17181i.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean M0() {
        return debugStatus == 4;
    }

    public final boolean N0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    public final synchronized boolean O0() {
        if (N0()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.t.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void P0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // ng.k1
    public Thread q0() {
        Thread thread = _thread;
        return thread == null ? L0() : thread;
    }

    @Override // ng.k1
    public void r0(long j10, j1.c cVar) {
        P0();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zC0;
        v2.f17190a.d(this);
        c.a();
        try {
            if (!O0()) {
                if (zC0) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jN0 = n0();
                if (jN0 == Long.MAX_VALUE) {
                    c.a();
                    long jNanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f17182j + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        K0();
                        c.a();
                        if (C0()) {
                            return;
                        }
                        q0();
                        return;
                    }
                    jN0 = vd.l.e(jN0, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jN0 > 0) {
                    if (N0()) {
                        _thread = null;
                        K0();
                        c.a();
                        if (C0()) {
                            return;
                        }
                        q0();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jN0);
                }
            }
        } finally {
            _thread = null;
            K0();
            c.a();
            if (!C0()) {
                q0();
            }
        }
    }

    @Override // ng.j1, ng.i1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // ng.k0
    public String toString() {
        return "DefaultExecutor";
    }

    @Override // ng.j1
    public void w0(Runnable runnable) {
        if (M0()) {
            P0();
        }
        super.w0(runnable);
    }
}
