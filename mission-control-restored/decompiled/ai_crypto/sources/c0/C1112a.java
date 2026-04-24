package c0;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: c0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1112a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f9115a;

    public C1112a(int i7) {
        this.f9115a = new AtomicInteger(i7);
    }

    public final int a() {
        return this.f9115a.decrementAndGet();
    }

    public final int b() {
        return this.f9115a.get();
    }

    public final int c() {
        return this.f9115a.getAndIncrement();
    }

    public final int d() {
        return this.f9115a.incrementAndGet();
    }
}
