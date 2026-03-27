package S2;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f7509a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f7510b = new AtomicInteger();

    public void a() {
        this.f7510b.getAndIncrement();
    }

    public void b() {
        this.f7509a.getAndIncrement();
    }

    public void c() {
        this.f7510b.set(0);
    }
}
