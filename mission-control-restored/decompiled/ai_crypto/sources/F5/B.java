package F5;

/* JADX INFO: loaded from: classes2.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2343b;

    public B(int i7, Object obj) {
        this.f2342a = i7;
        this.f2343b = obj;
    }

    public final int a() {
        return this.f2342a;
    }

    public final Object b() {
        return this.f2343b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b7 = (B) obj;
        return this.f2342a == b7.f2342a && kotlin.jvm.internal.r.b(this.f2343b, b7.f2343b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f2342a) * 31;
        Object obj = this.f2343b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f2342a + ", value=" + this.f2343b + ')';
    }
}
