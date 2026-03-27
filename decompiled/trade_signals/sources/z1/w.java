package z1;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class w implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f24727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f24728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f24729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f24730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2426a f24731e;

    public w(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        this.f24727a = interfaceC2426a;
        this.f24728b = interfaceC2426a2;
        this.f24729c = interfaceC2426a3;
        this.f24730d = interfaceC2426a4;
        this.f24731e = interfaceC2426a5;
    }

    public static w a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        return new w(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4, interfaceC2426a5);
    }

    public static u c(J1.a aVar, J1.a aVar2, F1.e eVar, G1.r rVar, G1.v vVar) {
        return new u(aVar, aVar2, eVar, rVar, vVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((J1.a) this.f24727a.get(), (J1.a) this.f24728b.get(), (F1.e) this.f24729c.get(), (G1.r) this.f24730d.get(), (G1.v) this.f24731e.get());
    }
}
