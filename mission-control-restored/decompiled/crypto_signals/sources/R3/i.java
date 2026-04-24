package R3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f2819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2820b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f2821c = new AtomicBoolean(false);

    public i(ExecutorService executorService) {
        this.f2819a = executorService;
    }

    @Override // R3.e
    public final void a(c cVar) {
        this.f2820b.add(cVar);
        this.f2819a.execute(new h(this, 0));
    }

    public final void b() {
        ExecutorService executorService = this.f2819a;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f2820b;
        AtomicBoolean atomicBoolean = this.f2821c;
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                if (runnable != null) {
                    runnable.run();
                }
            } finally {
                atomicBoolean.set(false);
                if (!concurrentLinkedQueue.isEmpty()) {
                    executorService.execute(new h(this, 1));
                }
            }
        }
    }
}
