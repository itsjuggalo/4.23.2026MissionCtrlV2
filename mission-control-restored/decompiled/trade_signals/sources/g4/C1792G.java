package g4;

import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: g4.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1792G implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f18026a;

    public C1792G(InterfaceC2426a interfaceC2426a) {
        this.f18026a = interfaceC2426a;
    }

    public static C1792G a(InterfaceC2426a interfaceC2426a) {
        return new C1792G(interfaceC2426a);
    }

    public static C1791F c(C1799N c1799n) {
        return new C1791F(c1799n);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1791F get() {
        return c((C1799N) this.f18026a.get());
    }
}
