package rb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f19681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1 f19682b;

    public q(p pVar, k1 k1Var) {
        this.f19681a = (p) p6.n.o(pVar, "state is null");
        this.f19682b = (k1) p6.n.o(k1Var, "status is null");
    }

    public static q a(p pVar) {
        p6.n.e(pVar != p.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new q(pVar, k1.f19592e);
    }

    public static q b(k1 k1Var) {
        p6.n.e(!k1Var.p(), "The error status must not be OK");
        return new q(p.TRANSIENT_FAILURE, k1Var);
    }

    public p c() {
        return this.f19681a;
    }

    public k1 d() {
        return this.f19682b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f19681a.equals(qVar.f19681a) && this.f19682b.equals(qVar.f19682b);
    }

    public int hashCode() {
        return this.f19681a.hashCode() ^ this.f19682b.hashCode();
    }

    public String toString() {
        if (this.f19682b.p()) {
            return this.f19681a.toString();
        }
        return this.f19681a + "(" + this.f19682b + ")";
    }
}
