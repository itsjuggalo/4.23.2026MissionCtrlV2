package P3;

import P3.c;
import P3.d;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f4326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4331h;

    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.a f4333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4335d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f4336e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f4337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f4338g;

        @Override // P3.d.a
        public d a() {
            String str = "";
            if (this.f4333b == null) {
                str = " registrationStatus";
            }
            if (this.f4336e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f4337f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f4332a, this.f4333b, this.f4334c, this.f4335d, this.f4336e.longValue(), this.f4337f.longValue(), this.f4338g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // P3.d.a
        public d.a b(String str) {
            this.f4334c = str;
            return this;
        }

        @Override // P3.d.a
        public d.a c(long j7) {
            this.f4336e = Long.valueOf(j7);
            return this;
        }

        @Override // P3.d.a
        public d.a d(String str) {
            this.f4332a = str;
            return this;
        }

        @Override // P3.d.a
        public d.a e(String str) {
            this.f4338g = str;
            return this;
        }

        @Override // P3.d.a
        public d.a f(String str) {
            this.f4335d = str;
            return this;
        }

        @Override // P3.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f4333b = aVar;
            return this;
        }

        @Override // P3.d.a
        public d.a h(long j7) {
            this.f4337f = Long.valueOf(j7);
            return this;
        }

        public b() {
        }

        public b(d dVar) {
            this.f4332a = dVar.d();
            this.f4333b = dVar.g();
            this.f4334c = dVar.b();
            this.f4335d = dVar.f();
            this.f4336e = Long.valueOf(dVar.c());
            this.f4337f = Long.valueOf(dVar.h());
            this.f4338g = dVar.e();
        }
    }

    @Override // P3.d
    public String b() {
        return this.f4327d;
    }

    @Override // P3.d
    public long c() {
        return this.f4329f;
    }

    @Override // P3.d
    public String d() {
        return this.f4325b;
    }

    @Override // P3.d
    public String e() {
        return this.f4331h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f4325b;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f4326c.equals(dVar.g()) && ((str = this.f4327d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f4328e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f4329f == dVar.c() && this.f4330g == dVar.h()) {
                String str4 = this.f4331h;
                if (str4 == null) {
                    if (dVar.e() == null) {
                        return true;
                    }
                } else if (str4.equals(dVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // P3.d
    public String f() {
        return this.f4328e;
    }

    @Override // P3.d
    public c.a g() {
        return this.f4326c;
    }

    @Override // P3.d
    public long h() {
        return this.f4330g;
    }

    public int hashCode() {
        String str = this.f4325b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f4326c.hashCode()) * 1000003;
        String str2 = this.f4327d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f4328e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j7 = this.f4329f;
        int i7 = (iHashCode3 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j8 = this.f4330g;
        int i8 = (i7 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        String str4 = this.f4331h;
        return i8 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // P3.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f4325b + ", registrationStatus=" + this.f4326c + ", authToken=" + this.f4327d + ", refreshToken=" + this.f4328e + ", expiresInSecs=" + this.f4329f + ", tokenCreationEpochInSecs=" + this.f4330g + ", fisError=" + this.f4331h + "}";
    }

    public a(String str, c.a aVar, String str2, String str3, long j7, long j8, String str4) {
        this.f4325b = str;
        this.f4326c = aVar;
        this.f4327d = str2;
        this.f4328e = str3;
        this.f4329f = j7;
        this.f4330g = j8;
        this.f4331h = str4;
    }
}
