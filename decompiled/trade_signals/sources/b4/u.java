package b4;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12934b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12935a = 60;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f12936b = com.google.firebase.remoteconfig.internal.c.f15842j;

        public u c() {
            return new u(this);
        }

        public b d(long j8) {
            if (j8 < 0) {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j8)));
            }
            this.f12935a = j8;
            return this;
        }

        public b e(long j8) {
            if (j8 >= 0) {
                this.f12936b = j8;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j8 + " is an invalid argument");
        }
    }

    public u(b bVar) {
        this.f12933a = bVar.f12935a;
        this.f12934b = bVar.f12936b;
    }

    public long a() {
        return this.f12933a;
    }

    public long b() {
        return this.f12934b;
    }
}
