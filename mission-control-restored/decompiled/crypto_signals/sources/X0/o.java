package X0;

/* JADX INFO: loaded from: classes.dex */
public final class o extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f3488a;

    public o(r rVar) {
        A a6 = A.f3424a;
        this.f3488a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b3 = (B) obj;
        if (!this.f3488a.equals(((o) b3).f3488a)) {
            return false;
        }
        Object obj2 = A.f3424a;
        ((o) b3).getClass();
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.f3488a.hashCode() ^ 1000003) * 1000003) ^ A.f3424a.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f3488a + ", productIdOrigin=" + A.f3424a + "}";
    }
}
