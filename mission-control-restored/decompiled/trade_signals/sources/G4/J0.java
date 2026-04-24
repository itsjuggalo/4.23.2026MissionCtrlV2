package G4;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class J0 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f2510d = Logger.getLogger(J0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f2511e = c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f2512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f2513b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f2514c = 0;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(J0 j02, int i8, int i9);

        public abstract void b(J0 j02, int i8);
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater f2515a;

        public c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f2515a = atomicIntegerFieldUpdater;
        }

        @Override // G4.J0.b
        public boolean a(J0 j02, int i8, int i9) {
            return this.f2515a.compareAndSet(j02, i8, i9);
        }

        @Override // G4.J0.b
        public void b(J0 j02, int i8) {
            this.f2515a.set(j02, i8);
        }
    }

    public static final class d extends b {
        public d() {
            super();
        }

        @Override // G4.J0.b
        public boolean a(J0 j02, int i8, int i9) {
            synchronized (j02) {
                try {
                    if (j02.f2514c != i8) {
                        return false;
                    }
                    j02.f2514c = i9;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // G4.J0.b
        public void b(J0 j02, int i8) {
            synchronized (j02) {
                j02.f2514c = i8;
            }
        }
    }

    public J0(Executor executor) {
        AbstractC2848n.o(executor, "'executor' must not be null.");
        this.f2512a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(J0.class, "c"));
        } catch (Throwable th) {
            f2510d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void d(Runnable runnable) {
        if (f2511e.a(this, 0, -1)) {
            try {
                this.f2512a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f2513b.remove(runnable);
                }
                f2511e.b(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f2513b.add((Runnable) AbstractC2848n.o(runnable, "'r' must not be null."));
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        try {
            Executor executor = this.f2512a;
            while (executor == this.f2512a && (runnable = (Runnable) this.f2513b.poll()) != null) {
                try {
                    runnable.run();
                } catch (RuntimeException e8) {
                    f2510d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e8);
                }
            }
            f2511e.b(this, 0);
            if (this.f2513b.isEmpty()) {
                return;
            }
            d(null);
        } catch (Throwable th) {
            f2511e.b(this, 0);
            throw th;
        }
    }
}
