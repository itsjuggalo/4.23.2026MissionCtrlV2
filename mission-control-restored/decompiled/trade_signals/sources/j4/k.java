package j4;

import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class k implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f20081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f20082b;

    public k(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f20081a = interfaceC2426a;
        this.f20082b = interfaceC2426a2;
    }

    public static k a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new k(interfaceC2426a, interfaceC2426a2);
    }

    public static C2223j c(o oVar, o oVar2) {
        return new C2223j(oVar, oVar2);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2223j get() {
        return c((o) this.f20081a.get(), (o) this.f20082b.get());
    }
}
