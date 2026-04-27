package P3;

import N3.n1;
import N3.o1;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0774j implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0768d f6410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6411b;

    public C0774j(C0768d c0768d, InterfaceC2426a interfaceC2426a) {
        this.f6410a = c0768d;
        this.f6411b = interfaceC2426a;
    }

    public static C0774j a(C0768d c0768d, InterfaceC2426a interfaceC2426a) {
        return new C0774j(c0768d, interfaceC2426a);
    }

    public static o1 c(C0768d c0768d, n1 n1Var) {
        return (o1) E3.d.e(c0768d.f(n1Var));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public o1 get() {
        return c(this.f6410a, (n1) this.f6411b.get());
    }
}
