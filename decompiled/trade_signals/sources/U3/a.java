package U3;

import U3.c;
import U3.d;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f8163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8168h;

    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.a f8170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte f8176h;

        public b() {
        }

        @Override // U3.d.a
        public d a() {
            if (this.f8176h == 3 && this.f8170b != null) {
                return new a(this.f8169a, this.f8170b, this.f8171c, this.f8172d, this.f8173e, this.f8174f, this.f8175g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8170b == null) {
                sb.append(" registrationStatus");
            }
            if ((this.f8176h & 1) == 0) {
                sb.append(" expiresInSecs");
            }
            if ((this.f8176h & 2) == 0) {
                sb.append(" tokenCreationEpochInSecs");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // U3.d.a
        public d.a b(String str) {
            this.f8171c = str;
            return this;
        }

        @Override // U3.d.a
        public d.a c(long j8) {
            this.f8173e = j8;
            this.f8176h = (byte) (this.f8176h | 1);
            return this;
        }

        @Override // U3.d.a
        public d.a d(String str) {
            this.f8169a = str;
            return this;
        }

        @Override // U3.d.a
        public d.a e(String str) {
            this.f8175g = str;
            return this;
        }

        @Override // U3.d.a
        public d.a f(String str) {
            this.f8172d = str;
            return this;
        }

        @Override // U3.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f8170b = aVar;
            return this;
        }

        @Override // U3.d.a
        public d.a h(long j8) {
            this.f8174f = j8;
            this.f8176h = (byte) (this.f8176h | 2);
            return this;
        }

        public b(d dVar) {
            this.f8169a = dVar.d();
            this.f8170b = dVar.g();
            this.f8171c = dVar.b();
            this.f8172d = dVar.f();
            this.f8173e = dVar.c();
            this.f8174f = dVar.h();
            this.f8175g = dVar.e();
            this.f8176h = (byte) 3;
        }
    }

    public a(String str, c.a aVar, String str2, String str3, long j8, long j9, String str4) {
        this.f8162b = str;
        this.f8163c = aVar;
        this.f8164d = str2;
        this.f8165e = str3;
        this.f8166f = j8;
        this.f8167g = j9;
        this.f8168h = str4;
    }

    @Override // U3.d
    public String b() {
        return this.f8164d;
    }

    @Override // U3.d
    public long c() {
        return this.f8166f;
    }

    @Override // U3.d
    public String d() {
        return this.f8162b;
    }

    @Override // U3.d
    public String e() {
        return this.f8168h;
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
        String str3 = this.f8162b;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f8163c.equals(dVar.g()) && ((str = this.f8164d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f8165e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f8166f == dVar.c() && this.f8167g == dVar.h()) {
                String str4 = this.f8168h;
                String strE = dVar.e();
                if (str4 == null) {
                    if (strE == null) {
                        return true;
                    }
                } else if (str4.equals(strE)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // U3.d
    public String f() {
        return this.f8165e;
    }

    @Override // U3.d
    public c.a g() {
        return this.f8163c;
    }

    @Override // U3.d
    public long h() {
        return this.f8167g;
    }

    public int hashCode() {
        String str = this.f8162b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f8163c.hashCode()) * 1000003;
        String str2 = this.f8164d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f8165e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j8 = this.f8166f;
        int i8 = (iHashCode3 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f8167g;
        int i9 = (i8 ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        String str4 = this.f8168h;
        return i9 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // U3.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f8162b + ", registrationStatus=" + this.f8163c + ", authToken=" + this.f8164d + ", refreshToken=" + this.f8165e + ", expiresInSecs=" + this.f8166f + ", tokenCreationEpochInSecs=" + this.f8167g + ", fisError=" + this.f8168h + "}";
    }
}
