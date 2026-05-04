package dd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8004b;

    public g0(int i10, Object obj) {
        this.f8003a = i10;
        this.f8004b = obj;
    }

    public final int a() {
        return this.f8003a;
    }

    public final Object b() {
        return this.f8004b;
    }

    public final int c() {
        return this.f8003a;
    }

    public final Object d() {
        return this.f8004b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f8003a == g0Var.f8003a && kotlin.jvm.internal.t.b(this.f8004b, g0Var.f8004b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f8003a) * 31;
        Object obj = this.f8004b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f8003a + ", value=" + this.f8004b + ')';
    }
}
