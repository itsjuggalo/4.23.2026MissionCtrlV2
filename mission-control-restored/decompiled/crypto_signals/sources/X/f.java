package X;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3369b;

    public f(long j4, long j6) {
        if (j6 == 0) {
            this.f3368a = 0L;
            this.f3369b = 1L;
        } else {
            this.f3368a = j4;
            this.f3369b = j6;
        }
    }

    public final String toString() {
        return this.f3368a + "/" + this.f3369b;
    }
}
