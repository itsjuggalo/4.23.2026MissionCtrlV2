package r5;

/* JADX INFO: renamed from: r5.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2601q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC2600p f22787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f22788b;

    public C2601q(EnumC2600p enumC2600p, l0 l0Var) {
        this.f22787a = (EnumC2600p) H2.m.o(enumC2600p, "state is null");
        this.f22788b = (l0) H2.m.o(l0Var, "status is null");
    }

    public static C2601q a(EnumC2600p enumC2600p) {
        H2.m.e(enumC2600p != EnumC2600p.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new C2601q(enumC2600p, l0.f22705e);
    }

    public static C2601q b(l0 l0Var) {
        H2.m.e(!l0Var.o(), "The error status must not be OK");
        return new C2601q(EnumC2600p.TRANSIENT_FAILURE, l0Var);
    }

    public EnumC2600p c() {
        return this.f22787a;
    }

    public l0 d() {
        return this.f22788b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2601q)) {
            return false;
        }
        C2601q c2601q = (C2601q) obj;
        return this.f22787a.equals(c2601q.f22787a) && this.f22788b.equals(c2601q.f22788b);
    }

    public int hashCode() {
        return this.f22787a.hashCode() ^ this.f22788b.hashCode();
    }

    public String toString() {
        if (this.f22788b.o()) {
            return this.f22787a.toString();
        }
        return this.f22787a + "(" + this.f22788b + ")";
    }
}
