package j4;

import g4.C1813b;
import i4.InterfaceC1923b;
import n5.InterfaceC2426a;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: j4.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2219f implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f20059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f20060b;

    public C2219f(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f20059a = interfaceC2426a;
        this.f20060b = interfaceC2426a2;
    }

    public static C2219f a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new C2219f(interfaceC2426a, interfaceC2426a2);
    }

    public static C2218e c(C1813b c1813b, InterfaceC2711i interfaceC2711i) {
        return new C2218e(c1813b, interfaceC2711i);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2218e get() {
        return c((C1813b) this.f20059a.get(), (InterfaceC2711i) this.f20060b.get());
    }
}
