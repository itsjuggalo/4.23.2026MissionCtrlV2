package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2084i extends AbstractC2074F.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17837f;

    /* JADX INFO: renamed from: k3.i$b */
    public static final class b extends AbstractC2074F.e.a.AbstractC0271a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f17842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f17843f;

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a a() {
            String str;
            String str2 = this.f17838a;
            if (str2 != null && (str = this.f17839b) != null) {
                return new C2084i(str2, str, this.f17840c, null, this.f17841d, this.f17842e, this.f17843f);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17838a == null) {
                sb.append(" identifier");
            }
            if (this.f17839b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a.AbstractC0271a b(String str) {
            this.f17842e = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a.AbstractC0271a c(String str) {
            this.f17843f = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a.AbstractC0271a d(String str) {
            this.f17840c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a.AbstractC0271a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f17838a = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a.AbstractC0271a f(String str) {
            this.f17841d = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.a.AbstractC0271a
        public AbstractC2074F.e.a.AbstractC0271a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f17839b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.a
    public String b() {
        return this.f17836e;
    }

    @Override // k3.AbstractC2074F.e.a
    public String c() {
        return this.f17837f;
    }

    @Override // k3.AbstractC2074F.e.a
    public String d() {
        return this.f17834c;
    }

    @Override // k3.AbstractC2074F.e.a
    public String e() {
        return this.f17832a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.a)) {
            return false;
        }
        AbstractC2074F.e.a aVar = (AbstractC2074F.e.a) obj;
        if (this.f17832a.equals(aVar.e()) && this.f17833b.equals(aVar.h()) && ((str = this.f17834c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
            aVar.g();
            String str2 = this.f17835d;
            if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                String str3 = this.f17836e;
                if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                    String str4 = this.f17837f;
                    if (str4 == null) {
                        if (aVar.c() == null) {
                            return true;
                        }
                    } else if (str4.equals(aVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // k3.AbstractC2074F.e.a
    public String f() {
        return this.f17835d;
    }

    @Override // k3.AbstractC2074F.e.a
    public AbstractC2074F.e.a.b g() {
        return null;
    }

    @Override // k3.AbstractC2074F.e.a
    public String h() {
        return this.f17833b;
    }

    public int hashCode() {
        int iHashCode = (((this.f17832a.hashCode() ^ 1000003) * 1000003) ^ this.f17833b.hashCode()) * 1000003;
        String str = this.f17834c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f17835d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f17836e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f17837f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f17832a + ", version=" + this.f17833b + ", displayVersion=" + this.f17834c + ", organization=" + ((Object) null) + ", installationUuid=" + this.f17835d + ", developmentPlatform=" + this.f17836e + ", developmentPlatformVersion=" + this.f17837f + "}";
    }

    public C2084i(String str, String str2, String str3, AbstractC2074F.e.a.b bVar, String str4, String str5, String str6) {
        this.f17832a = str;
        this.f17833b = str2;
        this.f17834c = str3;
        this.f17835d = str4;
        this.f17836e = str5;
        this.f17837f = str6;
    }
}
