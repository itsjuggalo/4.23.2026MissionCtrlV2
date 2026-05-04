package a7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f305c;

    public a(long j10, long j11, long j12) {
        this.f303a = j10;
        this.f304b = j11;
        this.f305c = j12;
    }

    @Override // a7.r
    public long b() {
        return this.f304b;
    }

    @Override // a7.r
    public long c() {
        return this.f303a;
    }

    @Override // a7.r
    public long d() {
        return this.f305c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f303a == rVar.c() && this.f304b == rVar.b() && this.f305c == rVar.d()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f303a;
        long j11 = this.f304b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f305c;
        return i10 ^ ((int) ((j12 >>> 32) ^ j12));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f303a + ", elapsedRealtime=" + this.f304b + ", uptimeMillis=" + this.f305c + "}";
    }
}
