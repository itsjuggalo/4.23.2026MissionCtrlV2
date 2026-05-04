package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f24406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f24407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f24408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f24409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f24410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f0.e f24411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f0.d f24412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f0.a f24413m;

    /* JADX INFO: renamed from: x7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0429b extends f0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f24417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f24418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f24419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f24420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f24421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f24422i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public f0.e f24423j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public f0.d f24424k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public f0.a f24425l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f24426m;

        @Override // x7.f0.b
        public f0 a() {
            if (this.f24426m == 1 && this.f24414a != null && this.f24415b != null && this.f24417d != null && this.f24421h != null && this.f24422i != null) {
                return new b(this.f24414a, this.f24415b, this.f24416c, this.f24417d, this.f24418e, this.f24419f, this.f24420g, this.f24421h, this.f24422i, this.f24423j, this.f24424k, this.f24425l);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24414a == null) {
                sb2.append(" sdkVersion");
            }
            if (this.f24415b == null) {
                sb2.append(" gmpAppId");
            }
            if ((1 & this.f24426m) == 0) {
                sb2.append(" platform");
            }
            if (this.f24417d == null) {
                sb2.append(" installationUuid");
            }
            if (this.f24421h == null) {
                sb2.append(" buildVersion");
            }
            if (this.f24422i == null) {
                sb2.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.b
        public f0.b b(f0.a aVar) {
            this.f24425l = aVar;
            return this;
        }

        @Override // x7.f0.b
        public f0.b c(String str) {
            this.f24420g = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f24421h = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f24422i = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b f(String str) {
            this.f24419f = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b g(String str) {
            this.f24418e = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f24415b = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f24417d = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b j(f0.d dVar) {
            this.f24424k = dVar;
            return this;
        }

        @Override // x7.f0.b
        public f0.b k(int i10) {
            this.f24416c = i10;
            this.f24426m = (byte) (this.f24426m | 1);
            return this;
        }

        @Override // x7.f0.b
        public f0.b l(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f24414a = str;
            return this;
        }

        @Override // x7.f0.b
        public f0.b m(f0.e eVar) {
            this.f24423j = eVar;
            return this;
        }

        public C0429b() {
        }

        public C0429b(f0 f0Var) {
            this.f24414a = f0Var.m();
            this.f24415b = f0Var.i();
            this.f24416c = f0Var.l();
            this.f24417d = f0Var.j();
            this.f24418e = f0Var.h();
            this.f24419f = f0Var.g();
            this.f24420g = f0Var.d();
            this.f24421h = f0Var.e();
            this.f24422i = f0Var.f();
            this.f24423j = f0Var.n();
            this.f24424k = f0Var.k();
            this.f24425l = f0Var.c();
            this.f24426m = (byte) 1;
        }
    }

    @Override // x7.f0
    public f0.a c() {
        return this.f24413m;
    }

    @Override // x7.f0
    public String d() {
        return this.f24408h;
    }

    @Override // x7.f0
    public String e() {
        return this.f24409i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        f0.e eVar;
        f0.d dVar;
        f0.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            if (this.f24402b.equals(f0Var.m()) && this.f24403c.equals(f0Var.i()) && this.f24404d == f0Var.l() && this.f24405e.equals(f0Var.j()) && ((str = this.f24406f) != null ? str.equals(f0Var.h()) : f0Var.h() == null) && ((str2 = this.f24407g) != null ? str2.equals(f0Var.g()) : f0Var.g() == null) && ((str3 = this.f24408h) != null ? str3.equals(f0Var.d()) : f0Var.d() == null) && this.f24409i.equals(f0Var.e()) && this.f24410j.equals(f0Var.f()) && ((eVar = this.f24411k) != null ? eVar.equals(f0Var.n()) : f0Var.n() == null) && ((dVar = this.f24412l) != null ? dVar.equals(f0Var.k()) : f0Var.k() == null) && ((aVar = this.f24413m) != null ? aVar.equals(f0Var.c()) : f0Var.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0
    public String f() {
        return this.f24410j;
    }

    @Override // x7.f0
    public String g() {
        return this.f24407g;
    }

    @Override // x7.f0
    public String h() {
        return this.f24406f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f24402b.hashCode() ^ 1000003) * 1000003) ^ this.f24403c.hashCode()) * 1000003) ^ this.f24404d) * 1000003) ^ this.f24405e.hashCode()) * 1000003;
        String str = this.f24406f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f24407g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f24408h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f24409i.hashCode()) * 1000003) ^ this.f24410j.hashCode()) * 1000003;
        f0.e eVar = this.f24411k;
        int iHashCode5 = (iHashCode4 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        f0.d dVar = this.f24412l;
        int iHashCode6 = (iHashCode5 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        f0.a aVar = this.f24413m;
        return iHashCode6 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // x7.f0
    public String i() {
        return this.f24403c;
    }

    @Override // x7.f0
    public String j() {
        return this.f24405e;
    }

    @Override // x7.f0
    public f0.d k() {
        return this.f24412l;
    }

    @Override // x7.f0
    public int l() {
        return this.f24404d;
    }

    @Override // x7.f0
    public String m() {
        return this.f24402b;
    }

    @Override // x7.f0
    public f0.e n() {
        return this.f24411k;
    }

    @Override // x7.f0
    public f0.b o() {
        return new C0429b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f24402b + ", gmpAppId=" + this.f24403c + ", platform=" + this.f24404d + ", installationUuid=" + this.f24405e + ", firebaseInstallationId=" + this.f24406f + ", firebaseAuthenticationToken=" + this.f24407g + ", appQualitySessionId=" + this.f24408h + ", buildVersion=" + this.f24409i + ", displayVersion=" + this.f24410j + ", session=" + this.f24411k + ", ndkPayload=" + this.f24412l + ", appExitInfo=" + this.f24413m + "}";
    }

    public b(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, String str8, f0.e eVar, f0.d dVar, f0.a aVar) {
        this.f24402b = str;
        this.f24403c = str2;
        this.f24404d = i10;
        this.f24405e = str3;
        this.f24406f = str4;
        this.f24407g = str5;
        this.f24408h = str6;
        this.f24409i = str7;
        this.f24410j = str8;
        this.f24411k = eVar;
        this.f24412l = dVar;
        this.f24413m = aVar;
    }
}
