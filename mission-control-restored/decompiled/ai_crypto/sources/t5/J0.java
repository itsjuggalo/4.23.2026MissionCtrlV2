package t5;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class J0 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f23473d = Logger.getLogger(J0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f23474e = c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f23475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue f23476b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f23477c = 0;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(J0 j02, int i7, int i8);

        public abstract void b(J0 j02, int i7);
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater f23478a;

        @Override // t5.J0.b
        public boolean a(J0 j02, int i7, int i8) {
            return this.f23478a.compareAndSet(j02, i7, i8);
        }

        @Override // t5.J0.b
        public void b(J0 j02, int i7) {
            this.f23478a.set(j02, i7);
        }

        public c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f23478a = atomicIntegerFieldUpdater;
        }
    }

    public static final class d extends b {
        public d() {
            super();
        }

        @Override // t5.J0.b
        public boolean a(J0 j02, int i7, int i8) {
            synchronized (j02) {
                try {
                    if (j02.f23477c != i7) {
                        return false;
                    }
                    j02.f23477c = i8;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // t5.J0.b
        public void b(J0 j02, int i7) {
            synchronized (j02) {
                j02.f23477c = i7;
            }
        }
    }

    public J0(Executor executor) {
        H2.m.o(executor, "'executor' must not be null.");
        this.f23475a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(J0.class, "c"));
        } catch (Throwable th) {
            f23473d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void d(Runnable runnable) {
        if (f23474e.a(this, 0, -1)) {
            try {
                this.f23475a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f23476b.remove(runnable);
                }
                f23474e.b(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f23476b.add((Runnable) H2.m.o(runnable, "'r' must not be null."));
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        try {
            Executor executor = this.f23475a;
            while (executor == this.f23475a && (runnable = (Runnable) this.f23476b.poll()) != null) {
                try {
                    runnable.run();
                } catch (RuntimeException e7) {
                    f23473d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e7);
                }
            }
            f23474e.b(this, 0);
            if (this.f23476b.isEmpty()) {
                return;
            }
            d(null);
        } catch (Throwable th) {
            f23474e.b(this, 0);
            throw th;
        }
    }
}
