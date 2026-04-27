package N3;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f5711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f5712c;

    public m1(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f5710a = interfaceC2426a;
        this.f5711b = interfaceC2426a2;
        this.f5712c = interfaceC2426a3;
    }

    public static m1 a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new m1(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static l1 c(P4.r rVar, P4.r rVar2, P4.r rVar3) {
        return new l1(rVar, rVar2, rVar3);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l1 get() {
        return c((P4.r) this.f5710a.get(), (P4.r) this.f5711b.get(), (P4.r) this.f5712c.get());
    }
}
