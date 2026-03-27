package Y6;

import Y6.AbstractC1004f0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class Q extends AbstractC1004f0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Q f9641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f9642j;

    static {
        Long l8;
        Q q8 = new Q();
        f9641i = q8;
        AbstractC1002e0.F0(q8, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l8 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l8 = 1000L;
        }
        f9642j = timeUnit.toNanos(l8.longValue());
    }

    @Override // Y6.AbstractC1006g0
    public Thread L0() {
        Thread thread = _thread;
        return thread == null ? f1() : thread;
    }

    @Override // Y6.AbstractC1006g0
    public void M0(long j8, AbstractC1004f0.b bVar) {
        j1();
    }

    @Override // Y6.AbstractC1004f0
    public void R0(Runnable runnable) {
        if (g1()) {
            j1();
        }
        super.R0(runnable);
    }

    public final synchronized void e1() {
        if (h1()) {
            debugStatus = 3;
            Z0();
            AbstractC2304t.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread f1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(f9641i.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean g1() {
        return debugStatus == 4;
    }

    public final boolean h1() {
        int i8 = debugStatus;
        return i8 == 2 || i8 == 3;
    }

    public final synchronized boolean i1() {
        if (h1()) {
            return false;
        }
        debugStatus = 1;
        AbstractC2304t.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void j1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zX0;
        P0.f9639a.d(this);
        AbstractC0997c.a();
        try {
            if (!i1()) {
                if (zX0) {
                    return;
                } else {
                    return;
                }
            }
            long j8 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jI0 = I0();
                if (jI0 == Long.MAX_VALUE) {
                    AbstractC0997c.a();
                    long jNanoTime = System.nanoTime();
                    if (j8 == Long.MAX_VALUE) {
                        j8 = f9642j + jNanoTime;
                    }
                    long j9 = j8 - jNanoTime;
                    if (j9 <= 0) {
                        _thread = null;
                        e1();
                        AbstractC0997c.a();
                        if (X0()) {
                            return;
                        }
                        L0();
                        return;
                    }
                    jI0 = H5.i.e(jI0, j9);
                } else {
                    j8 = Long.MAX_VALUE;
                }
                if (jI0 > 0) {
                    if (h1()) {
                        _thread = null;
                        e1();
                        AbstractC0997c.a();
                        if (X0()) {
                            return;
                        }
                        L0();
                        return;
                    }
                    AbstractC0997c.a();
                    LockSupport.parkNanos(this, jI0);
                }
            }
        } finally {
            _thread = null;
            e1();
            AbstractC0997c.a();
            if (!X0()) {
                L0();
            }
        }
    }

    @Override // Y6.AbstractC1004f0, Y6.AbstractC1002e0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // Y6.I
    public String toString() {
        return "DefaultExecutor";
    }
}
