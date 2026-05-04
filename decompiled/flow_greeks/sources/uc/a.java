package uc;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends AtomicReference implements fc.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FutureTask f22908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FutureTask f22909d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f22910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f22911b;

    static {
        Runnable runnable = kc.a.f14805b;
        f22908c = new FutureTask(runnable, null);
        f22909d = new FutureTask(runnable, null);
    }

    public a(Runnable runnable) {
        this.f22910a = runnable;
    }

    public final void a(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == f22908c) {
                return;
            }
            if (future2 == f22909d) {
                future.cancel(this.f22911b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // fc.b
    public final boolean c() {
        Future future = (Future) get();
        return future == f22908c || future == f22909d;
    }

    @Override // fc.b
    public final void dispose() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == f22908c || future == (futureTask = f22909d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f22911b != Thread.currentThread());
    }
}
