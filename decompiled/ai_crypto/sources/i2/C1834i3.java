package i2;

import com.google.android.gms.common.internal.AbstractC1207s;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: i2.i3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1834i3 extends U3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicLong f15840k = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1826h3 f15841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1826h3 f15842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue f15843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f15844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f15845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f15846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f15847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Semaphore f15848j;

    public C1834i3(C1898q3 c1898q3) {
        super(c1898q3);
        this.f15847i = new Object();
        this.f15848j = new Semaphore(2);
        this.f15843e = new PriorityBlockingQueue();
        this.f15844f = new LinkedBlockingQueue();
        this.f15845g = new C1810f3(this, "Thread death: Uncaught exception on worker thread");
        this.f15846h = new C1810f3(this, "Thread death: Uncaught exception on network thread");
    }

    public final /* synthetic */ void A(C1826h3 c1826h3) {
        this.f15842d = null;
    }

    public final /* synthetic */ Object B() {
        return this.f15847i;
    }

    public final /* synthetic */ Semaphore C() {
        return this.f15848j;
    }

    public final /* synthetic */ boolean D() {
        return false;
    }

    public final void F(C1818g3 c1818g3) {
        synchronized (this.f15847i) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f15843e;
                priorityBlockingQueue.add(c1818g3);
                C1826h3 c1826h3 = this.f15841c;
                if (c1826h3 == null) {
                    C1826h3 c1826h32 = new C1826h3(this, "Measurement Worker", priorityBlockingQueue);
                    this.f15841c = c1826h32;
                    c1826h32.setUncaughtExceptionHandler(this.f15845g);
                    this.f15841c.start();
                } else {
                    c1826h3.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i2.T3
    public final void g() {
        if (Thread.currentThread() != this.f15842d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // i2.T3
    public final void h() {
        if (Thread.currentThread() != this.f15841c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // i2.U3
    public final boolean i() {
        return false;
    }

    public final void o() {
        if (Thread.currentThread() == this.f15841c) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean p() {
        return Thread.currentThread() == this.f15841c;
    }

    public final boolean q() {
        return Thread.currentThread() == this.f15842d;
    }

    public final Future r(Callable callable) {
        l();
        AbstractC1207s.k(callable);
        C1818g3 c1818g3 = new C1818g3(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f15841c) {
            if (!this.f15843e.isEmpty()) {
                this.f15404a.a().r().a("Callable skipped the worker queue.");
            }
            c1818g3.run();
        } else {
            F(c1818g3);
        }
        return c1818g3;
    }

    public final Future s(Callable callable) {
        l();
        AbstractC1207s.k(callable);
        C1818g3 c1818g3 = new C1818g3(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f15841c) {
            c1818g3.run();
        } else {
            F(c1818g3);
        }
        return c1818g3;
    }

    public final void t(Runnable runnable) {
        l();
        AbstractC1207s.k(runnable);
        F(new C1818g3(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object u(AtomicReference atomicReference, long j7, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.f15404a.b().t(runnable);
            try {
                atomicReference.wait(j7);
            } catch (InterruptedException unused) {
                A2 a2R = this.f15404a.a().r();
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                a2R.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.f15404a.a().r().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void v(Runnable runnable) {
        l();
        AbstractC1207s.k(runnable);
        F(new C1818g3(this, runnable, true, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) {
        l();
        AbstractC1207s.k(runnable);
        C1818g3 c1818g3 = new C1818g3(this, runnable, false, "Task exception on network thread");
        synchronized (this.f15847i) {
            try {
                BlockingQueue blockingQueue = this.f15844f;
                blockingQueue.add(c1818g3);
                C1826h3 c1826h3 = this.f15842d;
                if (c1826h3 == null) {
                    C1826h3 c1826h32 = new C1826h3(this, "Measurement Network", blockingQueue);
                    this.f15842d = c1826h32;
                    c1826h32.setUncaughtExceptionHandler(this.f15846h);
                    this.f15842d.start();
                } else {
                    c1826h3.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ C1826h3 x() {
        return this.f15841c;
    }

    public final /* synthetic */ void y(C1826h3 c1826h3) {
        this.f15841c = null;
    }

    public final /* synthetic */ C1826h3 z() {
        return this.f15842d;
    }
}
