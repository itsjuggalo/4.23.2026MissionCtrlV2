package t3;

/* JADX INFO: loaded from: classes3.dex */
public final class P0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f14960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1830o f14961b;

    public P0(I i4, InterfaceC1830o interfaceC1830o) {
        this.f14960a = i4;
        this.f14961b = interfaceC1830o;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14961b.j(this.f14960a, W2.E.f5463a);
    }
}
