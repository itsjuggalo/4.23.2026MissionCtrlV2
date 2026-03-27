package K2;

/* JADX INFO: renamed from: K2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0369q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0368p f1297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f1298b;

    public C0369q(EnumC0368p enumC0368p, l0 l0Var) {
        this.f1297a = (EnumC0368p) Z1.m.o(enumC0368p, "state is null");
        this.f1298b = (l0) Z1.m.o(l0Var, "status is null");
    }

    public static C0369q a(EnumC0368p enumC0368p) {
        Z1.m.e(enumC0368p != EnumC0368p.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new C0369q(enumC0368p, l0.f1215e);
    }

    public static C0369q b(l0 l0Var) {
        Z1.m.e(!l0Var.o(), "The error status must not be OK");
        return new C0369q(EnumC0368p.TRANSIENT_FAILURE, l0Var);
    }

    public EnumC0368p c() {
        return this.f1297a;
    }

    public l0 d() {
        return this.f1298b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0369q)) {
            return false;
        }
        C0369q c0369q = (C0369q) obj;
        return this.f1297a.equals(c0369q.f1297a) && this.f1298b.equals(c0369q.f1298b);
    }

    public int hashCode() {
        return this.f1297a.hashCode() ^ this.f1298b.hashCode();
    }

    public String toString() {
        if (this.f1298b.o()) {
            return this.f1297a.toString();
        }
        return this.f1297a + "(" + this.f1298b + ")";
    }
}
