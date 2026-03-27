package j4;

import b0.InterfaceC1178i;
import g4.InterfaceC1808X;
import i4.InterfaceC1923b;
import n5.InterfaceC2426a;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes.dex */
public final class n implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f20097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f20098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f20099c;

    public n(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f20097a = interfaceC2426a;
        this.f20098b = interfaceC2426a2;
        this.f20099c = interfaceC2426a3;
    }

    public static n a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new n(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static m c(InterfaceC2711i interfaceC2711i, InterfaceC1808X interfaceC1808X, InterfaceC1178i interfaceC1178i) {
        return new m(interfaceC2711i, interfaceC1808X, interfaceC1178i);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m get() {
        return c((InterfaceC2711i) this.f20097a.get(), (InterfaceC1808X) this.f20098b.get(), (InterfaceC1178i) this.f20099c.get());
    }
}
