package h3;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14787a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f14788b = new AtomicInteger();

    public int a() {
        return this.f14788b.get();
    }

    public int b() {
        return this.f14787a.get();
    }

    public void c() {
        this.f14788b.getAndIncrement();
    }

    public void d() {
        this.f14787a.getAndIncrement();
    }

    public void e() {
        this.f14788b.set(0);
    }
}
