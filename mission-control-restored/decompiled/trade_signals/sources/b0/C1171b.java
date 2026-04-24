package b0;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1171b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f12596a;

    public C1171b(int i8) {
        this.f12596a = new AtomicInteger(i8);
    }

    public final int a() {
        return this.f12596a.decrementAndGet();
    }

    public final int b() {
        return this.f12596a.get();
    }

    public final int c() {
        return this.f12596a.getAndIncrement();
    }

    public final int d() {
        return this.f12596a.incrementAndGet();
    }
}
