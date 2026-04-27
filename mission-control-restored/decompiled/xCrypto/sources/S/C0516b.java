package S;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: S.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0516b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f3606a;

    public C0516b(int i4) {
        this.f3606a = new AtomicInteger(i4);
    }

    public final int a() {
        return this.f3606a.decrementAndGet();
    }

    public final int b() {
        return this.f3606a.get();
    }

    public final int c() {
        return this.f3606a.getAndIncrement();
    }

    public final int d() {
        return this.f3606a.incrementAndGet();
    }
}
