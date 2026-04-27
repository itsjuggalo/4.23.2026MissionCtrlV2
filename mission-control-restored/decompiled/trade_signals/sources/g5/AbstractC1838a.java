package g5;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: g5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1838a extends AtomicReference implements S4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FutureTask f18233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FutureTask f18234d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f18236b;

    static {
        Runnable runnable = X4.a.f9376b;
        f18233c = new FutureTask(runnable, null);
        f18234d = new FutureTask(runnable, null);
    }

    public AbstractC1838a(Runnable runnable) {
        this.f18235a = runnable;
    }

    public final void a(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == f18233c) {
                return;
            }
            if (future2 == f18234d) {
                future.cancel(this.f18236b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // S4.b
    public final void dispose() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == f18233c || future == (futureTask = f18234d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f18236b != Thread.currentThread());
    }

    @Override // S4.b
    public final boolean g() {
        Future future = (Future) get();
        return future == f18233c || future == f18234d;
    }
}
