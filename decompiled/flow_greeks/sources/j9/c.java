package j9;

import j9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.a f14233b;

    public c(long j10, p.a aVar) {
        this.f14232a = j10;
        if (aVar == null) {
            throw new NullPointerException("Null offset");
        }
        this.f14233b = aVar;
    }

    @Override // j9.p.b
    public p.a c() {
        return this.f14233b;
    }

    @Override // j9.p.b
    public long d() {
        return this.f14232a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p.b) {
            p.b bVar = (p.b) obj;
            if (this.f14232a == bVar.d() && this.f14233b.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f14232a;
        return ((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f14233b.hashCode();
    }

    public String toString() {
        return "IndexState{sequenceNumber=" + this.f14232a + ", offset=" + this.f14233b + "}";
    }
}
