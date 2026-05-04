package ea;

import ea.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8552c;

    /* JADX INFO: renamed from: ea.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0159b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f8556d;

        @Override // ea.m.a
        public m a() {
            String str;
            if (this.f8556d == 3 && (str = this.f8553a) != null) {
                return new b(str, this.f8554b, this.f8555c);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f8553a == null) {
                sb2.append(" limiterKey");
            }
            if ((this.f8556d & 1) == 0) {
                sb2.append(" limit");
            }
            if ((this.f8556d & 2) == 0) {
                sb2.append(" timeToLiveMillis");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // ea.m.a
        public m.a b(long j10) {
            this.f8554b = j10;
            this.f8556d = (byte) (this.f8556d | 1);
            return this;
        }

        @Override // ea.m.a
        public m.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null limiterKey");
            }
            this.f8553a = str;
            return this;
        }

        @Override // ea.m.a
        public m.a d(long j10) {
            this.f8555c = j10;
            this.f8556d = (byte) (this.f8556d | 2);
            return this;
        }
    }

    @Override // ea.m
    public long b() {
        return this.f8551b;
    }

    @Override // ea.m
    public String c() {
        return this.f8550a;
    }

    @Override // ea.m
    public long d() {
        return this.f8552c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f8550a.equals(mVar.c()) && this.f8551b == mVar.b() && this.f8552c == mVar.d()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f8550a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f8551b;
        long j11 = this.f8552c;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "RateLimit{limiterKey=" + this.f8550a + ", limit=" + this.f8551b + ", timeToLiveMillis=" + this.f8552c + "}";
    }

    public b(String str, long j10, long j11) {
        this.f8550a = str;
        this.f8551b = j10;
        this.f8552c = j11;
    }
}
