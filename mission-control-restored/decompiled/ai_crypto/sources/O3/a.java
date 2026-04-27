package O3;

import O3.m;

/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4156c;

    public static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f4158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f4159c;

        @Override // O3.m.a
        public m a() {
            String str = "";
            if (this.f4157a == null) {
                str = " token";
            }
            if (this.f4158b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f4159c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f4157a, this.f4158b.longValue(), this.f4159c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // O3.m.a
        public m.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f4157a = str;
            return this;
        }

        @Override // O3.m.a
        public m.a c(long j7) {
            this.f4159c = Long.valueOf(j7);
            return this;
        }

        @Override // O3.m.a
        public m.a d(long j7) {
            this.f4158b = Long.valueOf(j7);
            return this;
        }
    }

    @Override // O3.m
    public String b() {
        return this.f4154a;
    }

    @Override // O3.m
    public long c() {
        return this.f4156c;
    }

    @Override // O3.m
    public long d() {
        return this.f4155b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f4154a.equals(mVar.b()) && this.f4155b == mVar.d() && this.f4156c == mVar.c();
    }

    public int hashCode() {
        int iHashCode = (this.f4154a.hashCode() ^ 1000003) * 1000003;
        long j7 = this.f4155b;
        long j8 = this.f4156c;
        return ((iHashCode ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f4154a + ", tokenExpirationTimestamp=" + this.f4155b + ", tokenCreationTimestamp=" + this.f4156c + "}";
    }

    public a(String str, long j7, long j8) {
        this.f4154a = str;
        this.f4155b = j7;
        this.f4156c = j8;
    }
}
