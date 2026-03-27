package F2;

/* JADX INFO: loaded from: classes.dex */
public final class s extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1934b;

    public s(int i7, long j7) {
        this.f1933a = i7;
        this.f1934b = j7;
    }

    @Override // F2.t
    public final int a() {
        return this.f1933a;
    }

    @Override // F2.t
    public final long b() {
        return this.f1934b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f1933a == tVar.a() && this.f1934b == tVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j7 = this.f1934b;
        return ((int) (j7 ^ (j7 >>> 32))) ^ ((this.f1933a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f1933a + ", eventTimestamp=" + this.f1934b + "}";
    }
}
