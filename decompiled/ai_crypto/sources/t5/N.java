package t5;

import r5.c0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N extends r5.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.c0 f23496a;

    public N(r5.c0 c0Var) {
        H2.m.o(c0Var, "delegate can not be null");
        this.f23496a = c0Var;
    }

    @Override // r5.c0
    public String a() {
        return this.f23496a.a();
    }

    @Override // r5.c0
    public void b() {
        this.f23496a.b();
    }

    @Override // r5.c0
    public void c() {
        this.f23496a.c();
    }

    @Override // r5.c0
    public void d(c0.d dVar) {
        this.f23496a.d(dVar);
    }

    public String toString() {
        return H2.g.b(this).d("delegate", this.f23496a).toString();
    }
}
