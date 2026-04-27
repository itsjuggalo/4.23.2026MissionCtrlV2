package H6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f3974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B5.k f3975d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Runnable checkCancelled, B5.k interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        AbstractC2304t.f(checkCancelled, "checkCancelled");
        AbstractC2304t.f(interruptedExceptionHandler, "interruptedExceptionHandler");
    }

    @Override // H6.d, H6.k
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f3974c.run();
            } catch (InterruptedException e8) {
                this.f3975d.invoke(e8);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Lock lock, Runnable checkCancelled, B5.k interruptedExceptionHandler) {
        super(lock);
        AbstractC2304t.f(lock, "lock");
        AbstractC2304t.f(checkCancelled, "checkCancelled");
        AbstractC2304t.f(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.f3974c = checkCancelled;
        this.f3975d = interruptedExceptionHandler;
    }
}
