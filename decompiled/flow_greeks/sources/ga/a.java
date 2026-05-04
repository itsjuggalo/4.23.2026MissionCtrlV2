package ga;

import ga.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10436c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f10438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f10439c;

        @Override // ga.m.a
        public m a() {
            String str = "";
            if (this.f10437a == null) {
                str = " token";
            }
            if (this.f10438b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f10439c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f10437a, this.f10438b.longValue(), this.f10439c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ga.m.a
        public m.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f10437a = str;
            return this;
        }

        @Override // ga.m.a
        public m.a c(long j10) {
            this.f10439c = Long.valueOf(j10);
            return this;
        }

        @Override // ga.m.a
        public m.a d(long j10) {
            this.f10438b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // ga.m
    public String b() {
        return this.f10434a;
    }

    @Override // ga.m
    public long c() {
        return this.f10436c;
    }

    @Override // ga.m
    public long d() {
        return this.f10435b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f10434a.equals(mVar.b()) && this.f10435b == mVar.d() && this.f10436c == mVar.c()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f10434a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f10435b;
        long j11 = this.f10436c;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f10434a + ", tokenExpirationTimestamp=" + this.f10435b + ", tokenCreationTimestamp=" + this.f10436c + "}";
    }

    public a(String str, long j10, long j11) {
        this.f10434a = str;
        this.f10435b = j10;
        this.f10436c = j11;
    }
}
