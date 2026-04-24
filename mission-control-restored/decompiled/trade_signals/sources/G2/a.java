package G2;

/* JADX INFO: loaded from: classes.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2162c;

    public a(long j8, long j9, long j10) {
        this.f2160a = j8;
        this.f2161b = j9;
        this.f2162c = j10;
    }

    @Override // G2.o
    public long b() {
        return this.f2161b;
    }

    @Override // G2.o
    public long c() {
        return this.f2160a;
    }

    @Override // G2.o
    public long d() {
        return this.f2162c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f2160a == oVar.c() && this.f2161b == oVar.b() && this.f2162c == oVar.d();
    }

    public int hashCode() {
        long j8 = this.f2160a;
        long j9 = this.f2161b;
        int i8 = (((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        long j10 = this.f2162c;
        return i8 ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f2160a + ", elapsedRealtime=" + this.f2161b + ", uptimeMillis=" + this.f2162c + "}";
    }
}
