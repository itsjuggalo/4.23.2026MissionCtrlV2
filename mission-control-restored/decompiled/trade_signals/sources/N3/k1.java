package N3;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f5702b;

    public k1(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f5701a = interfaceC2426a;
        this.f5702b = interfaceC2426a2;
    }

    public static k1 a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new k1(interfaceC2426a, interfaceC2426a2);
    }

    public static j1 c(R0 r02, Q3.a aVar) {
        return new j1(r02, aVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j1 get() {
        return c((R0) this.f5701a.get(), (Q3.a) this.f5702b.get());
    }
}
