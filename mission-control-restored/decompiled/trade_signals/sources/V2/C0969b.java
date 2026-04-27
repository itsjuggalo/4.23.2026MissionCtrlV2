package V2;

import V2.F;

/* JADX INFO: renamed from: V2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0969b extends F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f8670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f8674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final F.e f8675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final F.d f8676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final F.a f8677m;

    /* JADX INFO: renamed from: V2.b$b, reason: collision with other inner class name */
    public static final class C0141b extends F.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8682e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f8683f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8684g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8685h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f8686i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public F.e f8687j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public F.d f8688k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public F.a f8689l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f8690m;

        public C0141b() {
        }

        @Override // V2.F.b
        public F a() {
            if (this.f8690m == 1 && this.f8678a != null && this.f8679b != null && this.f8681d != null && this.f8685h != null && this.f8686i != null) {
                return new C0969b(this.f8678a, this.f8679b, this.f8680c, this.f8681d, this.f8682e, this.f8683f, this.f8684g, this.f8685h, this.f8686i, this.f8687j, this.f8688k, this.f8689l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8678a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f8679b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f8690m) == 0) {
                sb.append(" platform");
            }
            if (this.f8681d == null) {
                sb.append(" installationUuid");
            }
            if (this.f8685h == null) {
                sb.append(" buildVersion");
            }
            if (this.f8686i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.b
        public F.b b(F.a aVar) {
            this.f8689l = aVar;
            return this;
        }

        @Override // V2.F.b
        public F.b c(String str) {
            this.f8684g = str;
            return this;
        }

        @Override // V2.F.b
        public F.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f8685h = str;
            return this;
        }

        @Override // V2.F.b
        public F.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f8686i = str;
            return this;
        }

        @Override // V2.F.b
        public F.b f(String str) {
            this.f8683f = str;
            return this;
        }

        @Override // V2.F.b
        public F.b g(String str) {
            this.f8682e = str;
            return this;
        }

        @Override // V2.F.b
        public F.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f8679b = str;
            return this;
        }

        @Override // V2.F.b
        public F.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f8681d = str;
            return this;
        }

        @Override // V2.F.b
        public F.b j(F.d dVar) {
            this.f8688k = dVar;
            return this;
        }

        @Override // V2.F.b
        public F.b k(int i8) {
            this.f8680c = i8;
            this.f8690m = (byte) (this.f8690m | 1);
            return this;
        }

        @Override // V2.F.b
        public F.b l(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f8678a = str;
            return this;
        }

        @Override // V2.F.b
        public F.b m(F.e eVar) {
            this.f8687j = eVar;
            return this;
        }

        public C0141b(F f8) {
            this.f8678a = f8.m();
            this.f8679b = f8.i();
            this.f8680c = f8.l();
            this.f8681d = f8.j();
            this.f8682e = f8.h();
            this.f8683f = f8.g();
            this.f8684g = f8.d();
            this.f8685h = f8.e();
            this.f8686i = f8.f();
            this.f8687j = f8.n();
            this.f8688k = f8.k();
            this.f8689l = f8.c();
            this.f8690m = (byte) 1;
        }
    }

    public C0969b(String str, String str2, int i8, String str3, String str4, String str5, String str6, String str7, String str8, F.e eVar, F.d dVar, F.a aVar) {
        this.f8666b = str;
        this.f8667c = str2;
        this.f8668d = i8;
        this.f8669e = str3;
        this.f8670f = str4;
        this.f8671g = str5;
        this.f8672h = str6;
        this.f8673i = str7;
        this.f8674j = str8;
        this.f8675k = eVar;
        this.f8676l = dVar;
        this.f8677m = aVar;
    }

    @Override // V2.F
    public F.a c() {
        return this.f8677m;
    }

    @Override // V2.F
    public String d() {
        return this.f8672h;
    }

    @Override // V2.F
    public String e() {
        return this.f8673i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        F.e eVar;
        F.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F)) {
            return false;
        }
        F f8 = (F) obj;
        if (this.f8666b.equals(f8.m()) && this.f8667c.equals(f8.i()) && this.f8668d == f8.l() && this.f8669e.equals(f8.j()) && ((str = this.f8670f) != null ? str.equals(f8.h()) : f8.h() == null) && ((str2 = this.f8671g) != null ? str2.equals(f8.g()) : f8.g() == null) && ((str3 = this.f8672h) != null ? str3.equals(f8.d()) : f8.d() == null) && this.f8673i.equals(f8.e()) && this.f8674j.equals(f8.f()) && ((eVar = this.f8675k) != null ? eVar.equals(f8.n()) : f8.n() == null) && ((dVar = this.f8676l) != null ? dVar.equals(f8.k()) : f8.k() == null)) {
            F.a aVar = this.f8677m;
            F.a aVarC = f8.c();
            if (aVar == null) {
                if (aVarC == null) {
                    return true;
                }
            } else if (aVar.equals(aVarC)) {
                return true;
            }
        }
        return false;
    }

    @Override // V2.F
    public String f() {
        return this.f8674j;
    }

    @Override // V2.F
    public String g() {
        return this.f8671g;
    }

    @Override // V2.F
    public String h() {
        return this.f8670f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f8666b.hashCode() ^ 1000003) * 1000003) ^ this.f8667c.hashCode()) * 1000003) ^ this.f8668d) * 1000003) ^ this.f8669e.hashCode()) * 1000003;
        String str = this.f8670f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f8671g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f8672h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f8673i.hashCode()) * 1000003) ^ this.f8674j.hashCode()) * 1000003;
        F.e eVar = this.f8675k;
        int iHashCode5 = (iHashCode4 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        F.d dVar = this.f8676l;
        int iHashCode6 = (iHashCode5 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        F.a aVar = this.f8677m;
        return iHashCode6 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // V2.F
    public String i() {
        return this.f8667c;
    }

    @Override // V2.F
    public String j() {
        return this.f8669e;
    }

    @Override // V2.F
    public F.d k() {
        return this.f8676l;
    }

    @Override // V2.F
    public int l() {
        return this.f8668d;
    }

    @Override // V2.F
    public String m() {
        return this.f8666b;
    }

    @Override // V2.F
    public F.e n() {
        return this.f8675k;
    }

    @Override // V2.F
    public F.b o() {
        return new C0141b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f8666b + ", gmpAppId=" + this.f8667c + ", platform=" + this.f8668d + ", installationUuid=" + this.f8669e + ", firebaseInstallationId=" + this.f8670f + ", firebaseAuthenticationToken=" + this.f8671g + ", appQualitySessionId=" + this.f8672h + ", buildVersion=" + this.f8673i + ", displayVersion=" + this.f8674j + ", session=" + this.f8675k + ", ndkPayload=" + this.f8676l + ", appExitInfo=" + this.f8677m + "}";
    }
}
