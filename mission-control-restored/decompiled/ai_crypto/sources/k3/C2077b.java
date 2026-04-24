package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2077b extends AbstractC2074F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f17753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AbstractC2074F.e f17754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AbstractC2074F.d f17755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AbstractC2074F.a f17756m;

    /* JADX INFO: renamed from: k3.b$b, reason: collision with other inner class name */
    public static final class C0288b extends AbstractC2074F.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f17761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f17762f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f17763g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f17764h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f17765i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public AbstractC2074F.e f17766j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public AbstractC2074F.d f17767k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public AbstractC2074F.a f17768l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f17769m;

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F a() {
            if (this.f17769m == 1 && this.f17757a != null && this.f17758b != null && this.f17760d != null && this.f17764h != null && this.f17765i != null) {
                return new C2077b(this.f17757a, this.f17758b, this.f17759c, this.f17760d, this.f17761e, this.f17762f, this.f17763g, this.f17764h, this.f17765i, this.f17766j, this.f17767k, this.f17768l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17757a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f17758b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f17769m) == 0) {
                sb.append(" platform");
            }
            if (this.f17760d == null) {
                sb.append(" installationUuid");
            }
            if (this.f17764h == null) {
                sb.append(" buildVersion");
            }
            if (this.f17765i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b b(AbstractC2074F.a aVar) {
            this.f17768l = aVar;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b c(String str) {
            this.f17763g = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f17764h = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f17765i = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b f(String str) {
            this.f17762f = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b g(String str) {
            this.f17761e = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f17758b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f17760d = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b j(AbstractC2074F.d dVar) {
            this.f17767k = dVar;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b k(int i7) {
            this.f17759c = i7;
            this.f17769m = (byte) (this.f17769m | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b l(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f17757a = str;
            return this;
        }

        @Override // k3.AbstractC2074F.b
        public AbstractC2074F.b m(AbstractC2074F.e eVar) {
            this.f17766j = eVar;
            return this;
        }

        public C0288b() {
        }

        public C0288b(AbstractC2074F abstractC2074F) {
            this.f17757a = abstractC2074F.m();
            this.f17758b = abstractC2074F.i();
            this.f17759c = abstractC2074F.l();
            this.f17760d = abstractC2074F.j();
            this.f17761e = abstractC2074F.h();
            this.f17762f = abstractC2074F.g();
            this.f17763g = abstractC2074F.d();
            this.f17764h = abstractC2074F.e();
            this.f17765i = abstractC2074F.f();
            this.f17766j = abstractC2074F.n();
            this.f17767k = abstractC2074F.k();
            this.f17768l = abstractC2074F.c();
            this.f17769m = (byte) 1;
        }
    }

    @Override // k3.AbstractC2074F
    public AbstractC2074F.a c() {
        return this.f17756m;
    }

    @Override // k3.AbstractC2074F
    public String d() {
        return this.f17751h;
    }

    @Override // k3.AbstractC2074F
    public String e() {
        return this.f17752i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        AbstractC2074F.e eVar;
        AbstractC2074F.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F)) {
            return false;
        }
        AbstractC2074F abstractC2074F = (AbstractC2074F) obj;
        if (this.f17745b.equals(abstractC2074F.m()) && this.f17746c.equals(abstractC2074F.i()) && this.f17747d == abstractC2074F.l() && this.f17748e.equals(abstractC2074F.j()) && ((str = this.f17749f) != null ? str.equals(abstractC2074F.h()) : abstractC2074F.h() == null) && ((str2 = this.f17750g) != null ? str2.equals(abstractC2074F.g()) : abstractC2074F.g() == null) && ((str3 = this.f17751h) != null ? str3.equals(abstractC2074F.d()) : abstractC2074F.d() == null) && this.f17752i.equals(abstractC2074F.e()) && this.f17753j.equals(abstractC2074F.f()) && ((eVar = this.f17754k) != null ? eVar.equals(abstractC2074F.n()) : abstractC2074F.n() == null) && ((dVar = this.f17755l) != null ? dVar.equals(abstractC2074F.k()) : abstractC2074F.k() == null)) {
            AbstractC2074F.a aVar = this.f17756m;
            if (aVar == null) {
                if (abstractC2074F.c() == null) {
                    return true;
                }
            } else if (aVar.equals(abstractC2074F.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // k3.AbstractC2074F
    public String f() {
        return this.f17753j;
    }

    @Override // k3.AbstractC2074F
    public String g() {
        return this.f17750g;
    }

    @Override // k3.AbstractC2074F
    public String h() {
        return this.f17749f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f17745b.hashCode() ^ 1000003) * 1000003) ^ this.f17746c.hashCode()) * 1000003) ^ this.f17747d) * 1000003) ^ this.f17748e.hashCode()) * 1000003;
        String str = this.f17749f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f17750g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f17751h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f17752i.hashCode()) * 1000003) ^ this.f17753j.hashCode()) * 1000003;
        AbstractC2074F.e eVar = this.f17754k;
        int iHashCode5 = (iHashCode4 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        AbstractC2074F.d dVar = this.f17755l;
        int iHashCode6 = (iHashCode5 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        AbstractC2074F.a aVar = this.f17756m;
        return iHashCode6 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // k3.AbstractC2074F
    public String i() {
        return this.f17746c;
    }

    @Override // k3.AbstractC2074F
    public String j() {
        return this.f17748e;
    }

    @Override // k3.AbstractC2074F
    public AbstractC2074F.d k() {
        return this.f17755l;
    }

    @Override // k3.AbstractC2074F
    public int l() {
        return this.f17747d;
    }

    @Override // k3.AbstractC2074F
    public String m() {
        return this.f17745b;
    }

    @Override // k3.AbstractC2074F
    public AbstractC2074F.e n() {
        return this.f17754k;
    }

    @Override // k3.AbstractC2074F
    public AbstractC2074F.b o() {
        return new C0288b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f17745b + ", gmpAppId=" + this.f17746c + ", platform=" + this.f17747d + ", installationUuid=" + this.f17748e + ", firebaseInstallationId=" + this.f17749f + ", firebaseAuthenticationToken=" + this.f17750g + ", appQualitySessionId=" + this.f17751h + ", buildVersion=" + this.f17752i + ", displayVersion=" + this.f17753j + ", session=" + this.f17754k + ", ndkPayload=" + this.f17755l + ", appExitInfo=" + this.f17756m + "}";
    }

    public C2077b(String str, String str2, int i7, String str3, String str4, String str5, String str6, String str7, String str8, AbstractC2074F.e eVar, AbstractC2074F.d dVar, AbstractC2074F.a aVar) {
        this.f17745b = str;
        this.f17746c = str2;
        this.f17747d = i7;
        this.f17748e = str3;
        this.f17749f = str4;
        this.f17750g = str5;
        this.f17751h = str6;
        this.f17752i = str7;
        this.f17753j = str8;
        this.f17754k = eVar;
        this.f17755l = dVar;
        this.f17756m = aVar;
    }
}
