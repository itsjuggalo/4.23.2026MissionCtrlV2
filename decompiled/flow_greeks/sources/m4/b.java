package m4;

import m4.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a f15856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15857b;

    public b(g.a aVar, long j10) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f15856a = aVar;
        this.f15857b = j10;
    }

    @Override // m4.g
    public long b() {
        return this.f15857b;
    }

    @Override // m4.g
    public g.a c() {
        return this.f15856a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f15856a.equals(gVar.c()) && this.f15857b == gVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f15856a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f15857b;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f15856a + ", nextRequestWaitMillis=" + this.f15857b + "}";
    }
}
