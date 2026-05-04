package pa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18469b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f18470a = 60;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f18471b = com.google.firebase.remoteconfig.internal.c.f6495j;

        public u c() {
            return new u(this);
        }

        public b d(long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j10)));
            }
            this.f18470a = j10;
            return this;
        }

        public b e(long j10) {
            if (j10 >= 0) {
                this.f18471b = j10;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j10 + " is an invalid argument");
        }
    }

    public long a() {
        return this.f18468a;
    }

    public long b() {
        return this.f18469b;
    }

    public u(b bVar) {
        this.f18468a = bVar.f18470a;
        this.f18469b = bVar.f18471b;
    }
}
