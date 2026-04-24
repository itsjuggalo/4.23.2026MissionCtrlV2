package S1;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2878b;

    public m(int i, long j4) {
        this.f2877a = i;
        this.f2878b = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f2877a == mVar.f2877a && this.f2878b == mVar.f2878b;
    }

    public final int hashCode() {
        long j4 = this.f2878b;
        return ((int) (j4 ^ (j4 >>> 32))) ^ ((this.f2877a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f2877a + ", eventTimestamp=" + this.f2878b + "}";
    }
}
