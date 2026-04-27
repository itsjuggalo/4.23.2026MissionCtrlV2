package X2;

/* JADX INFO: loaded from: classes3.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5581b;

    public D(int i4, Object obj) {
        this.f5580a = i4;
        this.f5581b = obj;
    }

    public final int a() {
        return this.f5580a;
    }

    public final Object b() {
        return this.f5581b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d4 = (D) obj;
        return this.f5580a == d4.f5580a && kotlin.jvm.internal.r.b(this.f5581b, d4.f5581b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f5580a) * 31;
        Object obj = this.f5581b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f5580a + ", value=" + this.f5581b + ')';
    }
}
