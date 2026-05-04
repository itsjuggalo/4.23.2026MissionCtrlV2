package l1;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14999a;

    public b(int i10) {
        this.f14999a = new AtomicInteger(i10);
    }

    public final int a() {
        return this.f14999a.decrementAndGet();
    }

    public final int b() {
        return this.f14999a.get();
    }

    public final int c() {
        return this.f14999a.getAndIncrement();
    }

    public final int d() {
        return this.f14999a.incrementAndGet();
    }
}
