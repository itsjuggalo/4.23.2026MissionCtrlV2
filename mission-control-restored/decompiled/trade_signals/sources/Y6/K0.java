package Y6;

import o5.C2470H;

/* JADX INFO: loaded from: classes2.dex */
public final class K0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f9630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1015l f9631b;

    public K0(I i8, InterfaceC1015l interfaceC1015l) {
        this.f9630a = i8;
        this.f9631b = interfaceC1015l;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9631b.g(this.f9630a, C2470H.f21956a);
    }
}
