package j4;

import g4.C1813b;
import g4.InterfaceC1808X;
import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: j4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2220g implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f20061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f20062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f20063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f20064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2426a f20065e;

    public C2220g(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        this.f20061a = interfaceC2426a;
        this.f20062b = interfaceC2426a2;
        this.f20063c = interfaceC2426a3;
        this.f20064d = interfaceC2426a4;
        this.f20065e = interfaceC2426a5;
    }

    public static C2220g a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4, InterfaceC2426a interfaceC2426a5) {
        return new C2220g(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4, interfaceC2426a5);
    }

    public static C2217d c(InterfaceC1808X interfaceC1808X, T3.h hVar, C1813b c1813b, InterfaceC2214a interfaceC2214a, l lVar) {
        return new C2217d(interfaceC1808X, hVar, c1813b, interfaceC2214a, lVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2217d get() {
        return c((InterfaceC1808X) this.f20061a.get(), (T3.h) this.f20062b.get(), (C1813b) this.f20063c.get(), (InterfaceC2214a) this.f20064d.get(), (l) this.f20065e.get());
    }
}
