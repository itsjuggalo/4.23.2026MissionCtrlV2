package h3;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18667a;

    public y(long j8) {
        this.f18667a = j8;
    }

    public long a() {
        return this.f18667a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && y.class == obj.getClass() && this.f18667a == ((y) obj).f18667a;
    }

    public int hashCode() {
        long j8 = this.f18667a;
        return (int) (j8 ^ (j8 >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.f18667a + '}';
    }
}
