package N1;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: N1.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0126r0 extends E0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicLong f1766o = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0124q0 f1767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0124q0 f1768d;
    public final PriorityBlockingQueue e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedBlockingQueue f1769f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0118o0 f1770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0118o0 f1771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f1772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Semaphore f1773n;

    public C0126r0(C0138v0 c0138v0) {
        super(c0138v0);
        this.f1772m = new Object();
        this.f1773n = new Semaphore(2);
        this.e = new PriorityBlockingQueue();
        this.f1769f = new LinkedBlockingQueue();
        this.f1770k = new C0118o0(this, "Thread death: Uncaught exception on worker thread");
        this.f1771l = new C0118o0(this, "Thread death: Uncaught exception on network thread");
    }

    public final void A(Runnable runnable) {
        r();
        C(new C0121p0(this, runnable, true, "Task exception on worker thread"));
    }

    public final void B(Runnable runnable) {
        r();
        C0121p0 c0121p0 = new C0121p0(this, runnable, false, "Task exception on network thread");
        synchronized (this.f1772m) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.f1769f;
                linkedBlockingQueue.add(c0121p0);
                C0124q0 c0124q0 = this.f1768d;
                if (c0124q0 == null) {
                    C0124q0 c0124q02 = new C0124q0(this, "Measurement Network", linkedBlockingQueue);
                    this.f1768d = c0124q02;
                    c0124q02.setUncaughtExceptionHandler(this.f1771l);
                    this.f1768d.start();
                } else {
                    Object obj = c0124q0.f1753a;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C(C0121p0 c0121p0) {
        synchronized (this.f1772m) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.e;
                priorityBlockingQueue.add(c0121p0);
                C0124q0 c0124q0 = this.f1767c;
                if (c0124q0 == null) {
                    C0124q0 c0124q02 = new C0124q0(this, "Measurement Worker", priorityBlockingQueue);
                    this.f1767c = c0124q02;
                    c0124q02.setUncaughtExceptionHandler(this.f1770k);
                    this.f1767c.start();
                } else {
                    Object obj = c0124q0.f1753a;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // N1.D0
    public final void p() {
        if (Thread.currentThread() != this.f1767c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // N1.E0
    public final boolean q() {
        return false;
    }

    public final void t() {
        if (Thread.currentThread() != this.f1768d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void u() {
        if (Thread.currentThread() == this.f1767c) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean v() {
        return Thread.currentThread() == this.f1767c;
    }

    public final C0121p0 w(Callable callable) {
        r();
        C0121p0 c0121p0 = new C0121p0(this, callable, false);
        if (Thread.currentThread() != this.f1767c) {
            C(c0121p0);
            return c0121p0;
        }
        if (!this.e.isEmpty()) {
            W w6 = ((C0138v0) this.f1130a).f1814f;
            C0138v0.l(w6);
            w6.f1414m.a("Callable skipped the worker queue.");
        }
        c0121p0.run();
        return c0121p0;
    }

    public final C0121p0 x(Callable callable) {
        r();
        C0121p0 c0121p0 = new C0121p0(this, callable, true);
        if (Thread.currentThread() == this.f1767c) {
            c0121p0.run();
            return c0121p0;
        }
        C(c0121p0);
        return c0121p0;
    }

    public final void y(Runnable runnable) {
        r();
        com.google.android.gms.common.internal.I.g(runnable);
        C(new C0121p0(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object z(AtomicReference atomicReference, long j4, String str, Runnable runnable) {
        synchronized (atomicReference) {
            C0126r0 c0126r0 = ((C0138v0) this.f1130a).f1815k;
            C0138v0.l(c0126r0);
            c0126r0.y(runnable);
            try {
                atomicReference.wait(j4);
            } catch (InterruptedException unused) {
                W w6 = ((C0138v0) this.f1130a).f1814f;
                C0138v0.l(w6);
                U u6 = w6.f1414m;
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                u6.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            W w7 = ((C0138v0) this.f1130a).f1814f;
            C0138v0.l(w7);
            w7.f1414m.a("Timed out waiting for ".concat(str));
        }
        return obj;
    }
}
