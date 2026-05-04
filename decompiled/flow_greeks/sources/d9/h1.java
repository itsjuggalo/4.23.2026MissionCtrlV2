package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7877a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7878a;

        public h1 a() {
            return new h1(this.f7878a);
        }

        public b b(long j10) {
            this.f7878a = j10;
            return this;
        }

        public b() {
            this.f7878a = 104857600L;
        }
    }

    public static b b() {
        return new b();
    }

    public long a() {
        return this.f7877a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && h1.class == obj.getClass() && this.f7877a == ((h1) obj).f7877a;
    }

    public int hashCode() {
        long j10 = this.f7877a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public String toString() {
        return "PersistentCacheSettings{sizeBytes=" + this.f7877a + '}';
    }

    public h1(long j10) {
        this.f7877a = j10;
    }
}
