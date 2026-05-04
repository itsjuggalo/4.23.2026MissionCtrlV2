package dh;

import bh.e;
import bh.m;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 implements bh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.e f8212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bh.e f8213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8214d;

    public /* synthetic */ r0(String str, bh.e eVar, bh.e eVar2, kotlin.jvm.internal.k kVar) {
        this(str, eVar, eVar2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return kotlin.jvm.internal.t.b(i(), r0Var.i()) && kotlin.jvm.internal.t.b(this.f8212b, r0Var.f8212b) && kotlin.jvm.internal.t.b(this.f8213c, r0Var.f8213c);
    }

    @Override // bh.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // bh.e
    public bh.l h() {
        return m.c.f3404a;
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.f8212b.hashCode()) * 31) + this.f8213c.hashCode();
    }

    @Override // bh.e
    public String i() {
        return this.f8211a;
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
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // bh.e
    public int l() {
        return this.f8214d;
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
            int i11 = i10 % 2;
            if (i11 == 0) {
                return this.f8212b;
            }
            if (i11 == 1) {
                return this.f8213c;
            }
            throw new IllegalStateException("Unreached");
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
        return i() + '(' + this.f8212b + ", " + this.f8213c + ')';
    }

    public r0(String str, bh.e eVar, bh.e eVar2) {
        this.f8211a = str;
        this.f8212b = eVar;
        this.f8213c = eVar2;
        this.f8214d = 2;
    }
}
