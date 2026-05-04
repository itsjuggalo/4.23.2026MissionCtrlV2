package wf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f24055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pd.k f24056d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Lock lock, Runnable checkCancelled, pd.k interruptedExceptionHandler) {
        super(lock);
        t.f(lock, "lock");
        t.f(checkCancelled, "checkCancelled");
        t.f(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.f24055c = checkCancelled;
        this.f24056d = interruptedExceptionHandler;
    }

    @Override // wf.d, wf.k
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f24055c.run();
            } catch (InterruptedException e10) {
                this.f24056d.invoke(e10);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Runnable checkCancelled, pd.k interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        t.f(checkCancelled, "checkCancelled");
        t.f(interruptedExceptionHandler, "interruptedExceptionHandler");
    }
}
