package m8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16097b;

    public g(Object obj, Object obj2) {
        this.f16096a = obj;
        this.f16097b = obj2;
    }

    public Object a() {
        return this.f16096a;
    }

    public Object b() {
        return this.f16097b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        Object obj2 = this.f16096a;
        if (obj2 == null ? gVar.f16096a != null : !obj2.equals(gVar.f16096a)) {
            return false;
        }
        Object obj3 = this.f16097b;
        Object obj4 = gVar.f16097b;
        return obj3 == null ? obj4 == null : obj3.equals(obj4);
    }

    public int hashCode() {
        Object obj = this.f16096a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f16097b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair(" + this.f16096a + com.amazon.a.a.o.b.f.f4598a + this.f16097b + ")";
    }
}
