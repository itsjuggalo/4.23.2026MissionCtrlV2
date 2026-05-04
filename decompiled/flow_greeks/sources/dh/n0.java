package dh;

import bh.e;
import bh.m;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 implements bh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bh.e f8190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8191b;

    public /* synthetic */ n0(bh.e eVar, kotlin.jvm.internal.k kVar) {
        this(eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return kotlin.jvm.internal.t.b(this.f8190a, n0Var.f8190a) && kotlin.jvm.internal.t.b(i(), n0Var.i());
    }

    @Override // bh.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // bh.e
    public bh.l h() {
        return m.b.f3403a;
    }

    public int hashCode() {
        return (this.f8190a.hashCode() * 31) + i().hashCode();
    }

    @Override // bh.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // bh.e
    public boolean j() {
        return e.a.c(this);
    }

    @Override // bh.e
    public int k(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        Integer numO = kg.y.o(name);
        if (numO != null) {
            return numO.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // bh.e
    public int l() {
        return this.f8191b;
    }

    @Override // bh.e
    public String m(int i10) {
        return String.valueOf(i10);
    }

    @Override // bh.e
    public List n(int i10) {
        if (i10 >= 0) {
            return dd.r.k();
        }
        throw new IllegalArgumentException(("Illegal index " + i10 + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // bh.e
    public bh.e o(int i10) {
        if (i10 >= 0) {
            return this.f8190a;
        }
        throw new IllegalArgumentException(("Illegal index " + i10 + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // bh.e
    public boolean p(int i10) {
        if (i10 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i10 + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.f8190a + ')';
    }

    public n0(bh.e eVar) {
        this.f8190a = eVar;
        this.f8191b = 1;
    }
}
