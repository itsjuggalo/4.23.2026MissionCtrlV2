package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class i extends F.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f8758f;

    public static final class b extends F.e.a.AbstractC0124a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8762d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8763e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f8764f;

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a a() {
            String str;
            String str2 = this.f8759a;
            if (str2 != null && (str = this.f8760b) != null) {
                return new i(str2, str, this.f8761c, null, this.f8762d, this.f8763e, this.f8764f);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8759a == null) {
                sb.append(" identifier");
            }
            if (this.f8760b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a.AbstractC0124a b(String str) {
            this.f8763e = str;
            return this;
        }

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a.AbstractC0124a c(String str) {
            this.f8764f = str;
            return this;
        }

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a.AbstractC0124a d(String str) {
            this.f8761c = str;
            return this;
        }

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a.AbstractC0124a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f8759a = str;
            return this;
        }

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a.AbstractC0124a f(String str) {
            this.f8762d = str;
            return this;
        }

        @Override // V2.F.e.a.AbstractC0124a
        public F.e.a.AbstractC0124a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f8760b = str;
            return this;
        }
    }

    public i(String str, String str2, String str3, F.e.a.b bVar, String str4, String str5, String str6) {
        this.f8753a = str;
        this.f8754b = str2;
        this.f8755c = str3;
        this.f8756d = str4;
        this.f8757e = str5;
        this.f8758f = str6;
    }

    @Override // V2.F.e.a
    public String b() {
        return this.f8757e;
    }

    @Override // V2.F.e.a
    public String c() {
        return this.f8758f;
    }

    @Override // V2.F.e.a
    public String d() {
        return this.f8755c;
    }

    @Override // V2.F.e.a
    public String e() {
        return this.f8753a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.a)) {
            return false;
        }
        F.e.a aVar = (F.e.a) obj;
        if (this.f8753a.equals(aVar.e()) && this.f8754b.equals(aVar.h()) && ((str = this.f8755c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
            aVar.g();
            String str2 = this.f8756d;
            if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                String str3 = this.f8757e;
                if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                    String str4 = this.f8758f;
                    String strC = aVar.c();
                    if (str4 == null) {
                        if (strC == null) {
                            return true;
                        }
                    } else if (str4.equals(strC)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // V2.F.e.a
    public String f() {
        return this.f8756d;
    }

    @Override // V2.F.e.a
    public F.e.a.b g() {
        return null;
    }

    @Override // V2.F.e.a
    public String h() {
        return this.f8754b;
    }

    public int hashCode() {
        int iHashCode = (((this.f8753a.hashCode() ^ 1000003) * 1000003) ^ this.f8754b.hashCode()) * 1000003;
        String str = this.f8755c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f8756d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f8757e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f8758f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f8753a + ", version=" + this.f8754b + ", displayVersion=" + this.f8755c + ", organization=" + ((Object) null) + ", installationUuid=" + this.f8756d + ", developmentPlatform=" + this.f8757e + ", developmentPlatformVersion=" + this.f8758f + "}";
    }
}
