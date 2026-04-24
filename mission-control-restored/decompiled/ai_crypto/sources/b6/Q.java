package b6;

import b6.AbstractC1072h0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class Q extends AbstractC1072h0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Q f9020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f9021j;

    static {
        Long l7;
        Q q7 = new Q();
        f9020i = q7;
        AbstractC1070g0.H0(q7, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l7 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l7 = 1000L;
        }
        f9021j = timeUnit.toNanos(l7.longValue());
    }

    @Override // b6.AbstractC1074i0
    public Thread N0() {
        Thread thread = _thread;
        return thread == null ? e1() : thread;
    }

    @Override // b6.AbstractC1074i0
    public void O0(long j7, AbstractC1072h0.c cVar) {
        i1();
    }

    @Override // b6.AbstractC1072h0
    public void T0(Runnable runnable) {
        if (f1()) {
            i1();
        }
        super.T0(runnable);
    }

    public final synchronized void d1() {
        if (g1()) {
            debugStatus = 3;
            X0();
            kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread e1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean f1() {
        return debugStatus == 4;
    }

    public final boolean g1() {
        int i7 = debugStatus;
        return i7 == 2 || i7 == 3;
    }

    public final synchronized boolean h1() {
        if (g1()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    @Override // b6.AbstractC1072h0, b6.V
    public InterfaceC1062c0 i(long j7, Runnable runnable, H5.g gVar) {
        return a1(j7, runnable);
    }

    public final void i1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zV0;
        U0.f9024a.d(this);
        AbstractC1061c.a();
        try {
            if (!h1()) {
                if (zV0) {
                    return;
                } else {
                    return;
                }
            }
            long j7 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jK0 = K0();
                if (jK0 == Long.MAX_VALUE) {
                    AbstractC1061c.a();
                    long jNanoTime = System.nanoTime();
                    if (j7 == Long.MAX_VALUE) {
                        j7 = f9021j + jNanoTime;
                    }
                    long j8 = j7 - jNanoTime;
                    if (j8 <= 0) {
                        _thread = null;
                        d1();
                        AbstractC1061c.a();
                        if (V0()) {
                            return;
                        }
                        N0();
                        return;
                    }
                    jK0 = W5.l.e(jK0, j8);
                } else {
                    j7 = Long.MAX_VALUE;
                }
                if (jK0 > 0) {
                    if (g1()) {
                        _thread = null;
                        d1();
                        AbstractC1061c.a();
                        if (V0()) {
                            return;
                        }
                        N0();
                        return;
                    }
                    AbstractC1061c.a();
                    LockSupport.parkNanos(this, jK0);
                }
            }
        } finally {
            _thread = null;
            d1();
            AbstractC1061c.a();
            if (!V0()) {
                N0();
            }
        }
    }

    @Override // b6.AbstractC1072h0, b6.AbstractC1070g0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
