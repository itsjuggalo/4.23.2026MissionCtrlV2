package X1;

/* JADX INFO: loaded from: classes.dex */
public final class s extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5577b;

    public s(int i4, long j4) {
        this.f5576a = i4;
        this.f5577b = j4;
    }

    @Override // X1.t
    public final int a() {
        return this.f5576a;
    }

    @Override // X1.t
    public final long b() {
        return this.f5577b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f5576a == tVar.a() && this.f5577b == tVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f5577b;
        return ((int) (j4 ^ (j4 >>> 32))) ^ ((this.f5576a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f5576a + ", eventTimestamp=" + this.f5577b + "}";
    }
}
