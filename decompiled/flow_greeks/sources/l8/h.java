package l8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.i f15555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15558e;

    public h(long j10, o8.i iVar, long j11, boolean z10, boolean z11) {
        this.f15554a = j10;
        if (iVar.g() && !iVar.f()) {
            throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
        }
        this.f15555b = iVar;
        this.f15556c = j11;
        this.f15557d = z10;
        this.f15558e = z11;
    }

    public h a(boolean z10) {
        return new h(this.f15554a, this.f15555b, this.f15556c, this.f15557d, z10);
    }

    public h b() {
        return new h(this.f15554a, this.f15555b, this.f15556c, true, this.f15558e);
    }

    public h c(long j10) {
        return new h(this.f15554a, this.f15555b, j10, this.f15557d, this.f15558e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == h.class) {
            h hVar = (h) obj;
            if (this.f15554a == hVar.f15554a && this.f15555b.equals(hVar.f15555b) && this.f15556c == hVar.f15556c && this.f15557d == hVar.f15557d && this.f15558e == hVar.f15558e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f15554a).hashCode() * 31) + this.f15555b.hashCode()) * 31) + Long.valueOf(this.f15556c).hashCode()) * 31) + Boolean.valueOf(this.f15557d).hashCode()) * 31) + Boolean.valueOf(this.f15558e).hashCode();
    }

    public String toString() {
        return "TrackedQuery{id=" + this.f15554a + ", querySpec=" + this.f15555b + ", lastUse=" + this.f15556c + ", complete=" + this.f15557d + ", active=" + this.f15558e + "}";
    }
}
