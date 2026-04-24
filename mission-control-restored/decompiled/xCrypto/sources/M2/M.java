package M2;

import K2.AbstractC0359g;
import K2.C0355c;
import K2.EnumC0368p;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class M extends K2.V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.V f1943a;

    public M(K2.V v4) {
        this.f1943a = v4;
    }

    @Override // K2.AbstractC0356d
    public String a() {
        return this.f1943a.a();
    }

    @Override // K2.AbstractC0356d
    public AbstractC0359g g(K2.a0 a0Var, C0355c c0355c) {
        return this.f1943a.g(a0Var, c0355c);
    }

    @Override // K2.V
    public boolean j(long j4, TimeUnit timeUnit) {
        return this.f1943a.j(j4, timeUnit);
    }

    @Override // K2.V
    public void k() {
        this.f1943a.k();
    }

    @Override // K2.V
    public EnumC0368p l(boolean z4) {
        return this.f1943a.l(z4);
    }

    @Override // K2.V
    public void m(EnumC0368p enumC0368p, Runnable runnable) {
        this.f1943a.m(enumC0368p, runnable);
    }

    @Override // K2.V
    public K2.V n() {
        return this.f1943a.n();
    }

    @Override // K2.V
    public K2.V o() {
        return this.f1943a.o();
    }

    public String toString() {
        return Z1.g.b(this).d("delegate", this.f1943a).toString();
    }
}
