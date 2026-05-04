package t4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l4.p f20743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l4.i f20744c;

    public b(long j10, l4.p pVar, l4.i iVar) {
        this.f20742a = j10;
        if (pVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f20743b = pVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f20744c = iVar;
    }

    @Override // t4.k
    public l4.i b() {
        return this.f20744c;
    }

    @Override // t4.k
    public long c() {
        return this.f20742a;
    }

    @Override // t4.k
    public l4.p d() {
        return this.f20743b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f20742a == kVar.c() && this.f20743b.equals(kVar.d()) && this.f20744c.equals(kVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f20742a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f20743b.hashCode()) * 1000003) ^ this.f20744c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f20742a + ", transportContext=" + this.f20743b + ", event=" + this.f20744c + "}";
    }
}
