package k3;

/* JADX INFO: renamed from: k3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2273g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20372b;

    public C2273g(Object obj, Object obj2) {
        this.f20371a = obj;
        this.f20372b = obj2;
    }

    public Object a() {
        return this.f20371a;
    }

    public Object b() {
        return this.f20372b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2273g.class != obj.getClass()) {
            return false;
        }
        C2273g c2273g = (C2273g) obj;
        Object obj2 = this.f20371a;
        if (obj2 == null ? c2273g.f20371a != null : !obj2.equals(c2273g.f20371a)) {
            return false;
        }
        Object obj3 = this.f20372b;
        Object obj4 = c2273g.f20372b;
        return obj3 == null ? obj4 == null : obj3.equals(obj4);
    }

    public int hashCode() {
        Object obj = this.f20371a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f20372b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair(" + this.f20371a + com.amazon.a.a.o.b.f.f14100a + this.f20372b + ")";
    }
}
