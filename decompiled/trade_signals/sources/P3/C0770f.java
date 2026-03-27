package P3;

import N3.C0732n;
import N3.n1;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0770f implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0768d f6404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f6406c;

    public C0770f(C0768d c0768d, InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f6404a = c0768d;
        this.f6405b = interfaceC2426a;
        this.f6406c = interfaceC2426a2;
    }

    public static C0770f a(C0768d c0768d, InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new C0770f(c0768d, interfaceC2426a, interfaceC2426a2);
    }

    public static C0732n c(C0768d c0768d, n1 n1Var, A3.d dVar) {
        return (C0732n) E3.d.e(c0768d.b(n1Var, dVar));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0732n get() {
        return c(this.f6404a, (n1) this.f6405b.get(), (A3.d) this.f6406c.get());
    }
}
