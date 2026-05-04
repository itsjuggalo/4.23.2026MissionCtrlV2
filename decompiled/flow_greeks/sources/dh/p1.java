package dh;

import bh.e;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 implements bh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.d f8205b;

    public p1(String serialName, bh.d kind) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(kind, "kind");
        this.f8204a = serialName;
        this.f8205b = kind;
    }

    private final Void a() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // bh.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bh.d h() {
        return this.f8205b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return kotlin.jvm.internal.t.b(i(), p1Var.i()) && kotlin.jvm.internal.t.b(h(), p1Var.h());
    }

    @Override // bh.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    public int hashCode() {
        return i().hashCode() + (h().hashCode() * 31);
    }

    @Override // bh.e
    public String i() {
        return this.f8204a;
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
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public int l() {
        return 0;
    }

    @Override // bh.e
    public String m(int i10) {
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public List n(int i10) {
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public bh.e o(int i10) {
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public boolean p(int i10) {
        a();
        throw new cd.h();
    }

    public String toString() {
        return "PrimitiveDescriptor(" + i() + ')';
    }
}
