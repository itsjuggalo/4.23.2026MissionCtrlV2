package Z1;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3951c;

    public a(long j4, long j6, long j7) {
        this.f3949a = j4;
        this.f3950b = j6;
        this.f3951c = j7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f3949a == aVar.f3949a && this.f3950b == aVar.f3950b && this.f3951c == aVar.f3951c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f3949a;
        long j6 = this.f3950b;
        int i = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j7 = this.f3951c;
        return i ^ ((int) ((j7 >>> 32) ^ j7));
    }

    public final String toString() {
        return "StartupTime{epochMillis=" + this.f3949a + ", elapsedRealtime=" + this.f3950b + ", uptimeMillis=" + this.f3951c + "}";
    }
}
