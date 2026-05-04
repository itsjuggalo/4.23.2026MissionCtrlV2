package u7;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f22305a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f22306b = new AtomicInteger();

    public void a() {
        this.f22306b.getAndIncrement();
    }

    public void b() {
        this.f22305a.getAndIncrement();
    }

    public void c() {
        this.f22306b.set(0);
    }
}
