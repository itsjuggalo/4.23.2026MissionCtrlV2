package t5;

import java.util.concurrent.TimeUnit;
import r5.AbstractC2591g;
import r5.C2587c;
import r5.EnumC2600p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class M extends r5.V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.V f23494a;

    public M(r5.V v7) {
        this.f23494a = v7;
    }

    @Override // r5.AbstractC2588d
    public String a() {
        return this.f23494a.a();
    }

    @Override // r5.AbstractC2588d
    public AbstractC2591g g(r5.a0 a0Var, C2587c c2587c) {
        return this.f23494a.g(a0Var, c2587c);
    }

    @Override // r5.V
    public boolean j(long j7, TimeUnit timeUnit) {
        return this.f23494a.j(j7, timeUnit);
    }

    @Override // r5.V
    public void k() {
        this.f23494a.k();
    }

    @Override // r5.V
    public EnumC2600p l(boolean z7) {
        return this.f23494a.l(z7);
    }

    @Override // r5.V
    public void m(EnumC2600p enumC2600p, Runnable runnable) {
        this.f23494a.m(enumC2600p, runnable);
    }

    @Override // r5.V
    public r5.V n() {
        return this.f23494a.n();
    }

    @Override // r5.V
    public r5.V o() {
        return this.f23494a.o();
    }

    public String toString() {
        return H2.g.b(this).d("delegate", this.f23494a).toString();
    }
}
