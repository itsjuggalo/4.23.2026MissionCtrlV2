package G3;

import G3.p;

/* JADX INFO: loaded from: classes.dex */
public final class c extends p.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.a f2432b;

    public c(long j7, p.a aVar) {
        this.f2431a = j7;
        if (aVar == null) {
            throw new NullPointerException("Null offset");
        }
        this.f2432b = aVar;
    }

    @Override // G3.p.b
    public p.a c() {
        return this.f2432b;
    }

    @Override // G3.p.b
    public long d() {
        return this.f2431a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p.b)) {
            return false;
        }
        p.b bVar = (p.b) obj;
        return this.f2431a == bVar.d() && this.f2432b.equals(bVar.c());
    }

    public int hashCode() {
        long j7 = this.f2431a;
        return ((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ this.f2432b.hashCode();
    }

    public String toString() {
        return "IndexState{sequenceNumber=" + this.f2431a + ", offset=" + this.f2432b + "}";
    }
}
