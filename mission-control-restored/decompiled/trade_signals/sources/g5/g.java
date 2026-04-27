package g5;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC1838a implements Callable {
    public g(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f18236b = Thread.currentThread();
        try {
            this.f18235a.run();
            return null;
        } finally {
            lazySet(AbstractC1838a.f18233c);
            this.f18236b = null;
        }
    }
}
