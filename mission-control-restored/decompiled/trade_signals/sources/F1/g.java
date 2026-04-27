package F1;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class g implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f1518a;

    public g(InterfaceC2426a interfaceC2426a) {
        this.f1518a = interfaceC2426a;
    }

    public static G1.f a(J1.a aVar) {
        return (G1.f) B1.d.d(f.a(aVar));
    }

    public static g b(InterfaceC2426a interfaceC2426a) {
        return new g(interfaceC2426a);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public G1.f get() {
        return a((J1.a) this.f1518a.get());
    }
}
