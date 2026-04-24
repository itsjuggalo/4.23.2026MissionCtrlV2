package A1;

import A1.g;

/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a f16a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17b;

    public b(g.a aVar, long j8) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f16a = aVar;
        this.f17b = j8;
    }

    @Override // A1.g
    public long b() {
        return this.f17b;
    }

    @Override // A1.g
    public g.a c() {
        return this.f16a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f16a.equals(gVar.c()) && this.f17b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.f16a.hashCode() ^ 1000003) * 1000003;
        long j8 = this.f17b;
        return iHashCode ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f16a + ", nextRequestWaitMillis=" + this.f17b + "}";
    }
}
