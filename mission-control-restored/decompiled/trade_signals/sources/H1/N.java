package H1;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class N implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f3590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f3591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f3592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f3593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2426a f3594e;

    public N(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        this.f3590a = interfaceC2426a;
        this.f3591b = interfaceC2426a2;
        this.f3592c = interfaceC2426a3;
        this.f3593d = interfaceC2426a4;
        this.f3594e = interfaceC2426a5;
    }

    public static N a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        return new N(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4, interfaceC2426a5);
    }

    public static M c(J1.a aVar, J1.a aVar2, Object obj, Object obj2, InterfaceC2426a interfaceC2426a) {
        return new M(aVar, aVar2, (AbstractC0587e) obj, (W) obj2, interfaceC2426a);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public M get() {
        return c((J1.a) this.f3590a.get(), (J1.a) this.f3591b.get(), this.f3592c.get(), this.f3593d.get(), this.f3594e);
    }
}
