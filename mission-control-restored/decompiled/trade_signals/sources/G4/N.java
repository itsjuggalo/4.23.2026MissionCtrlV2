package G4;

import F4.a0;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N extends F4.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.a0 f2533a;

    public N(F4.a0 a0Var) {
        AbstractC2848n.o(a0Var, "delegate can not be null");
        this.f2533a = a0Var;
    }

    @Override // F4.a0
    public String a() {
        return this.f2533a.a();
    }

    @Override // F4.a0
    public void b() {
        this.f2533a.b();
    }

    @Override // F4.a0
    public void c() {
        this.f2533a.c();
    }

    @Override // F4.a0
    public void d(a0.d dVar) {
        this.f2533a.d(dVar);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", this.f2533a).toString();
    }
}
