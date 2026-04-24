package s1;

import s1.g;

/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a f22970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22971b;

    public b(g.a aVar, long j7) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f22970a = aVar;
        this.f22971b = j7;
    }

    @Override // s1.g
    public long b() {
        return this.f22971b;
    }

    @Override // s1.g
    public g.a c() {
        return this.f22970a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f22970a.equals(gVar.c()) && this.f22971b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.f22970a.hashCode() ^ 1000003) * 1000003;
        long j7 = this.f22971b;
        return iHashCode ^ ((int) (j7 ^ (j7 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f22970a + ", nextRequestWaitMillis=" + this.f22971b + "}";
    }
}
