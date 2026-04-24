package T3;

import T3.m;

/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7952c;

    public static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f7954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f7955c;

        @Override // T3.m.a
        public m a() {
            String str = "";
            if (this.f7953a == null) {
                str = " token";
            }
            if (this.f7954b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f7955c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f7953a, this.f7954b.longValue(), this.f7955c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // T3.m.a
        public m.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f7953a = str;
            return this;
        }

        @Override // T3.m.a
        public m.a c(long j8) {
            this.f7955c = Long.valueOf(j8);
            return this;
        }

        @Override // T3.m.a
        public m.a d(long j8) {
            this.f7954b = Long.valueOf(j8);
            return this;
        }
    }

    public a(String str, long j8, long j9) {
        this.f7950a = str;
        this.f7951b = j8;
        this.f7952c = j9;
    }

    @Override // T3.m
    public String b() {
        return this.f7950a;
    }

    @Override // T3.m
    public long c() {
        return this.f7952c;
    }

    @Override // T3.m
    public long d() {
        return this.f7951b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f7950a.equals(mVar.b()) && this.f7951b == mVar.d() && this.f7952c == mVar.c();
    }

    public int hashCode() {
        int iHashCode = (this.f7950a.hashCode() ^ 1000003) * 1000003;
        long j8 = this.f7951b;
        long j9 = this.f7952c;
        return ((iHashCode ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f7950a + ", tokenExpirationTimestamp=" + this.f7951b + ", tokenCreationTimestamp=" + this.f7952c + "}";
    }
}
