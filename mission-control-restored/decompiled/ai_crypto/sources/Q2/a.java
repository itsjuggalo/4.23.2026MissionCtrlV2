package Q2;

/* JADX INFO: loaded from: classes.dex */
public final class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4484c;

    public a(long j7, long j8, long j9) {
        this.f4482a = j7;
        this.f4483b = j8;
        this.f4484c = j9;
    }

    @Override // Q2.r
    public long b() {
        return this.f4483b;
    }

    @Override // Q2.r
    public long c() {
        return this.f4482a;
    }

    @Override // Q2.r
    public long d() {
        return this.f4484c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f4482a == rVar.c() && this.f4483b == rVar.b() && this.f4484c == rVar.d();
    }

    public int hashCode() {
        long j7 = this.f4482a;
        long j8 = this.f4483b;
        int i7 = (((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f4484c;
        return i7 ^ ((int) ((j9 >>> 32) ^ j9));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f4482a + ", elapsedRealtime=" + this.f4483b + ", uptimeMillis=" + this.f4484c + "}";
    }
}
