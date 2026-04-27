package y1;

/* JADX INFO: loaded from: classes.dex */
public final class l extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24386a;

    public l(long j8) {
        this.f24386a = j8;
    }

    @Override // y1.v
    public long c() {
        return this.f24386a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof v) && this.f24386a == ((v) obj).c();
    }

    public int hashCode() {
        long j8 = this.f24386a;
        return ((int) (j8 ^ (j8 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f24386a + "}";
    }
}
