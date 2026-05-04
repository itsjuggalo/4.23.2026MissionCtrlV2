package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends f0.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f24516f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.a.AbstractC0432a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f24520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f24521e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f24522f;

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a a() {
            String str;
            String str2 = this.f24517a;
            if (str2 != null && (str = this.f24518b) != null) {
                return new i(str2, str, this.f24519c, null, this.f24520d, this.f24521e, this.f24522f);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24517a == null) {
                sb2.append(" identifier");
            }
            if (this.f24518b == null) {
                sb2.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a.AbstractC0432a b(String str) {
            this.f24521e = str;
            return this;
        }

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a.AbstractC0432a c(String str) {
            this.f24522f = str;
            return this;
        }

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a.AbstractC0432a d(String str) {
            this.f24519c = str;
            return this;
        }

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a.AbstractC0432a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f24517a = str;
            return this;
        }

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a.AbstractC0432a f(String str) {
            this.f24520d = str;
            return this;
        }

        @Override // x7.f0.e.a.AbstractC0432a
        public f0.e.a.AbstractC0432a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f24518b = str;
            return this;
        }
    }

    @Override // x7.f0.e.a
    public String b() {
        return this.f24515e;
    }

    @Override // x7.f0.e.a
    public String c() {
        return this.f24516f;
    }

    @Override // x7.f0.e.a
    public String d() {
        return this.f24513c;
    }

    @Override // x7.f0.e.a
    public String e() {
        return this.f24511a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.a) {
            f0.e.a aVar = (f0.e.a) obj;
            if (this.f24511a.equals(aVar.e()) && this.f24512b.equals(aVar.h()) && ((str = this.f24513c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
                aVar.g();
                String str2 = this.f24514d;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f24515e;
                    if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                        String str4 = this.f24516f;
                        if (str4 != null ? str4.equals(aVar.c()) : aVar.c() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // x7.f0.e.a
    public String f() {
        return this.f24514d;
    }

    @Override // x7.f0.e.a
    public f0.e.a.b g() {
        return null;
    }

    @Override // x7.f0.e.a
    public String h() {
        return this.f24512b;
    }

    public int hashCode() {
        int iHashCode = (((this.f24511a.hashCode() ^ 1000003) * 1000003) ^ this.f24512b.hashCode()) * 1000003;
        String str = this.f24513c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f24514d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f24515e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f24516f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f24511a + ", version=" + this.f24512b + ", displayVersion=" + this.f24513c + ", organization=" + ((Object) null) + ", installationUuid=" + this.f24514d + ", developmentPlatform=" + this.f24515e + ", developmentPlatformVersion=" + this.f24516f + "}";
    }

    public i(String str, String str2, String str3, f0.e.a.b bVar, String str4, String str5, String str6) {
        this.f24511a = str;
        this.f24512b = str2;
        this.f24513c = str3;
        this.f24514d = str4;
        this.f24515e = str5;
        this.f24516f = str6;
    }
}
