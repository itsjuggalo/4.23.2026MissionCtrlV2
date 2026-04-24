package Z0;

/* JADX INFO: loaded from: classes.dex */
public final class l extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5891a;

    public l(long j4) {
        this.f5891a = j4;
    }

    @Override // Z0.v
    public long c() {
        return this.f5891a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof v) && this.f5891a == ((v) obj).c();
    }

    public int hashCode() {
        long j4 = this.f5891a;
        return ((int) (j4 ^ (j4 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f5891a + "}";
    }
}
