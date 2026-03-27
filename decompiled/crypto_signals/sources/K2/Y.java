package K2;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f908a;

    public Y(long j4) {
        this.f908a = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Y.class == obj.getClass() && this.f908a == ((Y) obj).f908a;
    }

    public final int hashCode() {
        long j4 = this.f908a;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public final String toString() {
        return "PersistentCacheSettings{sizeBytes=" + this.f908a + '}';
    }
}
