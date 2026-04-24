package M2;

import K2.c0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class N extends K2.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.c0 f1945a;

    public N(K2.c0 c0Var) {
        Z1.m.o(c0Var, "delegate can not be null");
        this.f1945a = c0Var;
    }

    @Override // K2.c0
    public String a() {
        return this.f1945a.a();
    }

    @Override // K2.c0
    public void b() {
        this.f1945a.b();
    }

    @Override // K2.c0
    public void c() {
        this.f1945a.c();
    }

    @Override // K2.c0
    public void d(c0.d dVar) {
        this.f1945a.d(dVar);
    }

    public String toString() {
        return Z1.g.b(this).d("delegate", this.f1945a).toString();
    }
}
