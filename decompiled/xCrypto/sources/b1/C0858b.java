package b1;

import b1.g;

/* JADX INFO: renamed from: b1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0858b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a f8242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8243b;

    public C0858b(g.a aVar, long j4) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f8242a = aVar;
        this.f8243b = j4;
    }

    @Override // b1.g
    public long b() {
        return this.f8243b;
    }

    @Override // b1.g
    public g.a c() {
        return this.f8242a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f8242a.equals(gVar.c()) && this.f8243b == gVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f8242a.hashCode() ^ 1000003) * 1000003;
        long j4 = this.f8243b;
        return iHashCode ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f8242a + ", nextRequestWaitMillis=" + this.f8243b + "}";
    }
}
