package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.i3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0594i3 extends U3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicLong f4681k = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0586h3 f4682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0586h3 f4683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue f4684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f4685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f4686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f4687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f4688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Semaphore f4689j;

    public C0594i3(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4688i = new Object();
        this.f4689j = new Semaphore(2);
        this.f4684e = new PriorityBlockingQueue();
        this.f4685f = new LinkedBlockingQueue();
        this.f4686g = new C0570f3(this, "Thread death: Uncaught exception on worker thread");
        this.f4687h = new C0570f3(this, "Thread death: Uncaught exception on network thread");
    }

    public final /* synthetic */ void A(C0586h3 c0586h3) {
        this.f4683d = null;
    }

    public final /* synthetic */ Object B() {
        return this.f4688i;
    }

    public final /* synthetic */ Semaphore C() {
        return this.f4689j;
    }

    public final /* synthetic */ boolean D() {
        return false;
    }

    public final void F(C0578g3 c0578g3) {
        synchronized (this.f4688i) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f4684e;
                priorityBlockingQueue.add(c0578g3);
                C0586h3 c0586h3 = this.f4682c;
                if (c0586h3 == null) {
                    C0586h3 c0586h32 = new C0586h3(this, "Measurement Worker", priorityBlockingQueue);
                    this.f4682c = c0586h32;
                    c0586h32.setUncaughtExceptionHandler(this.f4686g);
                    this.f4682c.start();
                } else {
                    c0586h3.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // S1.T3
    public final void g() {
        if (Thread.currentThread() != this.f4683d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // S1.T3
    public final void h() {
        if (Thread.currentThread() != this.f4682c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // S1.U3
    public final boolean i() {
        return false;
    }

    public final void o() {
        if (Thread.currentThread() == this.f4682c) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean p() {
        return Thread.currentThread() == this.f4682c;
    }

    public final boolean q() {
        return Thread.currentThread() == this.f4683d;
    }

    public final Future r(Callable callable) {
        l();
        AbstractC0940s.k(callable);
        C0578g3 c0578g3 = new C0578g3(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() != this.f4682c) {
            F(c0578g3);
            return c0578g3;
        }
        if (!this.f4684e.isEmpty()) {
            this.f4245a.a().r().a("Callable skipped the worker queue.");
        }
        c0578g3.run();
        return c0578g3;
    }

    public final Future s(Callable callable) {
        l();
        AbstractC0940s.k(callable);
        C0578g3 c0578g3 = new C0578g3(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f4682c) {
            c0578g3.run();
            return c0578g3;
        }
        F(c0578g3);
        return c0578g3;
    }

    public final void t(Runnable runnable) {
        l();
        AbstractC0940s.k(runnable);
        F(new C0578g3(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object u(AtomicReference atomicReference, long j4, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.f4245a.b().t(runnable);
            try {
                atomicReference.wait(j4);
            } catch (InterruptedException unused) {
                A2 a2R = this.f4245a.a().r();
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                a2R.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.f4245a.a().r().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void v(Runnable runnable) {
        l();
        AbstractC0940s.k(runnable);
        F(new C0578g3(this, runnable, true, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) {
        l();
        AbstractC0940s.k(runnable);
        C0578g3 c0578g3 = new C0578g3(this, runnable, false, "Task exception on network thread");
        synchronized (this.f4688i) {
            try {
                BlockingQueue blockingQueue = this.f4685f;
                blockingQueue.add(c0578g3);
                C0586h3 c0586h3 = this.f4683d;
                if (c0586h3 == null) {
                    C0586h3 c0586h32 = new C0586h3(this, "Measurement Network", blockingQueue);
                    this.f4683d = c0586h32;
                    c0586h32.setUncaughtExceptionHandler(this.f4687h);
                    this.f4683d.start();
                } else {
                    c0586h3.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ C0586h3 x() {
        return this.f4682c;
    }

    public final /* synthetic */ void y(C0586h3 c0586h3) {
        this.f4682c = null;
    }

    public final /* synthetic */ C0586h3 z() {
        return this.f4683d;
    }
}
