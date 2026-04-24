package g4;

import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: g4.O, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1800O implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f18064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f18065b;

    public C1800O(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f18064a = interfaceC2426a;
        this.f18065b = interfaceC2426a2;
    }

    public static C1800O a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new C1800O(interfaceC2426a, interfaceC2426a2);
    }

    public static C1799N c(InterfaceC1808X interfaceC1808X, InterfaceC1810Z interfaceC1810Z) {
        return new C1799N(interfaceC1808X, interfaceC1810Z);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1799N get() {
        return c((InterfaceC1808X) this.f18064a.get(), (InterfaceC1810Z) this.f18065b.get());
    }
}
