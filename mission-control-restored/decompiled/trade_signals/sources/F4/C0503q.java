package F4;

import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0503q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0502p f1891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f1892b;

    public C0503q(EnumC0502p enumC0502p, j0 j0Var) {
        this.f1891a = (EnumC0502p) AbstractC2848n.o(enumC0502p, "state is null");
        this.f1892b = (j0) AbstractC2848n.o(j0Var, "status is null");
    }

    public static C0503q a(EnumC0502p enumC0502p) {
        AbstractC2848n.e(enumC0502p != EnumC0502p.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new C0503q(enumC0502p, j0.f1797e);
    }

    public static C0503q b(j0 j0Var) {
        AbstractC2848n.e(!j0Var.p(), "The error status must not be OK");
        return new C0503q(EnumC0502p.TRANSIENT_FAILURE, j0Var);
    }

    public EnumC0502p c() {
        return this.f1891a;
    }

    public j0 d() {
        return this.f1892b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0503q)) {
            return false;
        }
        C0503q c0503q = (C0503q) obj;
        return this.f1891a.equals(c0503q.f1891a) && this.f1892b.equals(c0503q.f1892b);
    }

    public int hashCode() {
        return this.f1891a.hashCode() ^ this.f1892b.hashCode();
    }

    public String toString() {
        if (this.f1892b.p()) {
            return this.f1891a.toString();
        }
        return this.f1891a + "(" + this.f1892b + ")";
    }
}
