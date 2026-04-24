package q1;

/* JADX INFO: loaded from: classes.dex */
public final class l extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22233a;

    public l(long j7) {
        this.f22233a = j7;
    }

    @Override // q1.v
    public long c() {
        return this.f22233a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof v) && this.f22233a == ((v) obj).c();
    }

    public int hashCode() {
        long j7 = this.f22233a;
        return ((int) (j7 ^ (j7 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f22233a + "}";
    }
}
