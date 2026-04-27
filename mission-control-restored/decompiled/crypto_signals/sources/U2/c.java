package U2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable, ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f3124a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f3125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f3126c;

    public c(d dVar) {
        this.f3126c = dVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        D1.b.w("Only one thread may be created in an AsyncQueue.", this.f3125b == null, new Object[0]);
        this.f3125b = runnable;
        this.f3124a.countDown();
        return this.f3126c.f3129c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3124a.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.f3125b.run();
    }
}
