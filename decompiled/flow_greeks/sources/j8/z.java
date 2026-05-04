package j8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14224a;

    public z(long j10) {
        this.f14224a = j10;
    }

    public long a() {
        return this.f14224a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && z.class == obj.getClass() && this.f14224a == ((z) obj).f14224a;
    }

    public int hashCode() {
        long j10 = this.f14224a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.f14224a + '}';
    }
}
