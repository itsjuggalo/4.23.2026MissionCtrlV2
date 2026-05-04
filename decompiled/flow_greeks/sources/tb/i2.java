package tb;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i2 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f21432d = Logger.getLogger(i2.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f21433e = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f21434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f21435b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f21436c = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(i2 i2Var, int i10, int i11);

        public abstract void b(i2 i2Var, int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater f21437a;

        @Override // tb.i2.b
        public boolean a(i2 i2Var, int i10, int i11) {
            return this.f21437a.compareAndSet(i2Var, i10, i11);
        }

        @Override // tb.i2.b
        public void b(i2 i2Var, int i10) {
            this.f21437a.set(i2Var, i10);
        }

        public c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f21437a = atomicIntegerFieldUpdater;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends b {
        public d() {
            super();
        }

        @Override // tb.i2.b
        public boolean a(i2 i2Var, int i10, int i11) {
            synchronized (i2Var) {
                try {
                    if (i2Var.f21436c != i10) {
                        return false;
                    }
                    i2Var.f21436c = i11;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // tb.i2.b
        public void b(i2 i2Var, int i10) {
            synchronized (i2Var) {
                i2Var.f21436c = i10;
            }
        }
    }

    public i2(Executor executor) {
        p6.n.o(executor, "'executor' must not be null.");
        this.f21434a = executor;
    }

    public static b d() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(i2.class, "c"));
        } catch (Throwable th) {
            f21432d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void e(Runnable runnable) {
        if (f21433e.a(this, 0, -1)) {
            try {
                this.f21434a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f21435b.remove(runnable);
                }
                f21433e.b(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f21435b.add((Runnable) p6.n.o(runnable, "'r' must not be null."));
        e(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        try {
            Executor executor = this.f21434a;
            while (executor == this.f21434a && (runnable = (Runnable) this.f21435b.poll()) != null) {
                try {
                    runnable.run();
                } catch (RuntimeException e10) {
                    f21432d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e10);
                }
            }
            f21433e.b(this, 0);
            if (this.f21435b.isEmpty()) {
                return;
            }
            e(null);
        } catch (Throwable th) {
            f21433e.b(this, 0);
            throw th;
        }
    }
}
