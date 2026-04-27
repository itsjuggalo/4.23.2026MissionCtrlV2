package V2;

import V2.F;

/* JADX INFO: renamed from: V2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0971d extends F.a.AbstractC0122a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8712c;

    /* JADX INFO: renamed from: V2.d$b */
    public static final class b extends F.a.AbstractC0122a.AbstractC0123a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8715c;

        @Override // V2.F.a.AbstractC0122a.AbstractC0123a
        public F.a.AbstractC0122a a() {
            String str;
            String str2;
            String str3 = this.f8713a;
            if (str3 != null && (str = this.f8714b) != null && (str2 = this.f8715c) != null) {
                return new C0971d(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8713a == null) {
                sb.append(" arch");
            }
            if (this.f8714b == null) {
                sb.append(" libraryName");
            }
            if (this.f8715c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.a.AbstractC0122a.AbstractC0123a
        public F.a.AbstractC0122a.AbstractC0123a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f8713a = str;
            return this;
        }

        @Override // V2.F.a.AbstractC0122a.AbstractC0123a
        public F.a.AbstractC0122a.AbstractC0123a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f8715c = str;
            return this;
        }

        @Override // V2.F.a.AbstractC0122a.AbstractC0123a
        public F.a.AbstractC0122a.AbstractC0123a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f8714b = str;
            return this;
        }
    }

    public C0971d(String str, String str2, String str3) {
        this.f8710a = str;
        this.f8711b = str2;
        this.f8712c = str3;
    }

    @Override // V2.F.a.AbstractC0122a
    public String b() {
        return this.f8710a;
    }

    @Override // V2.F.a.AbstractC0122a
    public String c() {
        return this.f8712c;
    }

    @Override // V2.F.a.AbstractC0122a
    public String d() {
        return this.f8711b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.a.AbstractC0122a)) {
            return false;
        }
        F.a.AbstractC0122a abstractC0122a = (F.a.AbstractC0122a) obj;
        return this.f8710a.equals(abstractC0122a.b()) && this.f8711b.equals(abstractC0122a.d()) && this.f8712c.equals(abstractC0122a.c());
    }

    public int hashCode() {
        return ((((this.f8710a.hashCode() ^ 1000003) * 1000003) ^ this.f8711b.hashCode()) * 1000003) ^ this.f8712c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f8710a + ", libraryName=" + this.f8711b + ", buildId=" + this.f8712c + "}";
    }
}
