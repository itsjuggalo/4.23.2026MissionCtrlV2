package t3;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import o3.AbstractC1681l;
import t3.AbstractC1817h0;

/* JADX INFO: loaded from: classes3.dex */
public final class Q extends AbstractC1817h0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Q f14962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f14963j;

    static {
        Long l4;
        Q q4 = new Q();
        f14962i = q4;
        AbstractC1815g0.m0(q4, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l4 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l4 = 1000L;
        }
        f14963j = timeUnit.toNanos(l4.longValue());
    }

    public final synchronized void I0() {
        if (L0()) {
            debugStatus = 3;
            C0();
            kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread J0() {
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

    public final boolean K0() {
        return debugStatus == 4;
    }

    public final boolean L0() {
        int i4 = debugStatus;
        return i4 == 2 || i4 == 3;
    }

    public final synchronized boolean M0() {
        if (L0()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void N0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // t3.AbstractC1817h0, t3.V
    public InterfaceC1807c0 a0(long j4, Runnable runnable, Z2.i iVar) {
        return F0(j4, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zA0;
        U0.f14966a.d(this);
        AbstractC1806c.a();
        try {
            if (!M0()) {
                if (zA0) {
                    return;
                } else {
                    return;
                }
            }
            long j4 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jP0 = p0();
                if (jP0 == Long.MAX_VALUE) {
                    AbstractC1806c.a();
                    long jNanoTime = System.nanoTime();
                    if (j4 == Long.MAX_VALUE) {
                        j4 = f14963j + jNanoTime;
                    }
                    long j5 = j4 - jNanoTime;
                    if (j5 <= 0) {
                        _thread = null;
                        I0();
                        AbstractC1806c.a();
                        if (A0()) {
                            return;
                        }
                        s0();
                        return;
                    }
                    jP0 = AbstractC1681l.e(jP0, j5);
                } else {
                    j4 = Long.MAX_VALUE;
                }
                if (jP0 > 0) {
                    if (L0()) {
                        _thread = null;
                        I0();
                        AbstractC1806c.a();
                        if (A0()) {
                            return;
                        }
                        s0();
                        return;
                    }
                    AbstractC1806c.a();
                    LockSupport.parkNanos(this, jP0);
                }
            }
        } finally {
            _thread = null;
            I0();
            AbstractC1806c.a();
            if (!A0()) {
                s0();
            }
        }
    }

    @Override // t3.AbstractC1819i0
    public Thread s0() {
        Thread thread = _thread;
        return thread == null ? J0() : thread;
    }

    @Override // t3.AbstractC1817h0, t3.AbstractC1815g0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // t3.AbstractC1819i0
    public void t0(long j4, AbstractC1817h0.c cVar) {
        N0();
    }

    @Override // t3.AbstractC1817h0
    public void y0(Runnable runnable) {
        if (K0()) {
            N0();
        }
        super.y0(runnable);
    }
}
