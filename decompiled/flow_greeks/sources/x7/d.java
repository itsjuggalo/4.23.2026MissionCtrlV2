package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f0.a.AbstractC0430a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24457c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.a.AbstractC0430a.AbstractC0431a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24460c;

        @Override // x7.f0.a.AbstractC0430a.AbstractC0431a
        public f0.a.AbstractC0430a a() {
            String str;
            String str2;
            String str3 = this.f24458a;
            if (str3 != null && (str = this.f24459b) != null && (str2 = this.f24460c) != null) {
                return new d(str3, str, str2);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24458a == null) {
                sb2.append(" arch");
            }
            if (this.f24459b == null) {
                sb2.append(" libraryName");
            }
            if (this.f24460c == null) {
                sb2.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.a.AbstractC0430a.AbstractC0431a
        public f0.a.AbstractC0430a.AbstractC0431a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f24458a = str;
            return this;
        }

        @Override // x7.f0.a.AbstractC0430a.AbstractC0431a
        public f0.a.AbstractC0430a.AbstractC0431a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f24460c = str;
            return this;
        }

        @Override // x7.f0.a.AbstractC0430a.AbstractC0431a
        public f0.a.AbstractC0430a.AbstractC0431a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f24459b = str;
            return this;
        }
    }

    @Override // x7.f0.a.AbstractC0430a
    public String b() {
        return this.f24455a;
    }

    @Override // x7.f0.a.AbstractC0430a
    public String c() {
        return this.f24457c;
    }

    @Override // x7.f0.a.AbstractC0430a
    public String d() {
        return this.f24456b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.a.AbstractC0430a) {
            f0.a.AbstractC0430a abstractC0430a = (f0.a.AbstractC0430a) obj;
            if (this.f24455a.equals(abstractC0430a.b()) && this.f24456b.equals(abstractC0430a.d()) && this.f24457c.equals(abstractC0430a.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f24455a.hashCode() ^ 1000003) * 1000003) ^ this.f24456b.hashCode()) * 1000003) ^ this.f24457c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f24455a + ", libraryName=" + this.f24456b + ", buildId=" + this.f24457c + "}";
    }

    public d(String str, String str2, String str3) {
        this.f24455a = str;
        this.f24456b = str2;
        this.f24457c = str3;
    }
}
