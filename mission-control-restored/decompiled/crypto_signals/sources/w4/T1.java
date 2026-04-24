package w4;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class T1 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f11114d = Logger.getLogger(T1.class.getName());
    public static final W1 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f11115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f11116b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f11117c = 0;

    static {
        W1 s12;
        try {
            s12 = new R1(AtomicIntegerFieldUpdater.newUpdater(T1.class, "c"));
        } catch (Throwable th) {
            f11114d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            s12 = new S1();
        }
        e = s12;
    }

    public T1(Executor executor) {
        s3.D.j(executor, "'executor' must not be null.");
        this.f11115a = executor;
    }

    public final void a(Runnable runnable) {
        W1 w12 = e;
        if (w12.r(this)) {
            try {
                this.f11115a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f11116b.remove(runnable);
                }
                w12.s(this);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f11116b;
        s3.D.j(runnable, "'r' must not be null.");
        concurrentLinkedQueue.add(runnable);
        a(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        W1 w12 = e;
        while (true) {
            concurrentLinkedQueue = this.f11116b;
            try {
                Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                if (runnable == null) {
                    break;
                }
                try {
                    runnable.run();
                } catch (RuntimeException e2) {
                    f11114d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e2);
                }
            } catch (Throwable th) {
                w12.s(this);
                throw th;
            }
        }
        w12.s(this);
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        a(null);
    }
}
