package R3;

import R3.m;

/* JADX INFO: loaded from: classes.dex */
public final class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7119c;

    /* JADX INFO: renamed from: R3.b$b, reason: collision with other inner class name */
    public static final class C0102b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f7123d;

        @Override // R3.m.a
        public m a() {
            String str;
            if (this.f7123d == 3 && (str = this.f7120a) != null) {
                return new b(str, this.f7121b, this.f7122c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f7120a == null) {
                sb.append(" limiterKey");
            }
            if ((this.f7123d & 1) == 0) {
                sb.append(" limit");
            }
            if ((this.f7123d & 2) == 0) {
                sb.append(" timeToLiveMillis");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // R3.m.a
        public m.a b(long j8) {
            this.f7121b = j8;
            this.f7123d = (byte) (this.f7123d | 1);
            return this;
        }

        @Override // R3.m.a
        public m.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null limiterKey");
            }
            this.f7120a = str;
            return this;
        }

        @Override // R3.m.a
        public m.a d(long j8) {
            this.f7122c = j8;
            this.f7123d = (byte) (this.f7123d | 2);
            return this;
        }
    }

    public b(String str, long j8, long j9) {
        this.f7117a = str;
        this.f7118b = j8;
        this.f7119c = j9;
    }

    @Override // R3.m
    public long b() {
        return this.f7118b;
    }

    @Override // R3.m
    public String c() {
        return this.f7117a;
    }

    @Override // R3.m
    public long d() {
        return this.f7119c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f7117a.equals(mVar.c()) && this.f7118b == mVar.b() && this.f7119c == mVar.d();
    }

    public int hashCode() {
        int iHashCode = (this.f7117a.hashCode() ^ 1000003) * 1000003;
        long j8 = this.f7118b;
        long j9 = this.f7119c;
        return ((iHashCode ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)));
    }

    public String toString() {
        return "RateLimit{limiterKey=" + this.f7117a + ", limit=" + this.f7118b + ", timeToLiveMillis=" + this.f7119c + "}";
    }
}
