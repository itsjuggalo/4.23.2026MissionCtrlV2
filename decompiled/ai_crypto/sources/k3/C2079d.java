package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2079d extends AbstractC2074F.a.AbstractC0269a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17791c;

    /* JADX INFO: renamed from: k3.d$b */
    public static final class b extends AbstractC2074F.a.AbstractC0269a.AbstractC0270a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17794c;

        @Override // k3.AbstractC2074F.a.AbstractC0269a.AbstractC0270a
        public AbstractC2074F.a.AbstractC0269a a() {
            String str;
            String str2;
            String str3 = this.f17792a;
            if (str3 != null && (str = this.f17793b) != null && (str2 = this.f17794c) != null) {
                return new C2079d(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17792a == null) {
                sb.append(" arch");
            }
            if (this.f17793b == null) {
                sb.append(" libraryName");
            }
            if (this.f17794c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.a.AbstractC0269a.AbstractC0270a
        public AbstractC2074F.a.AbstractC0269a.AbstractC0270a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f17792a = str;
            return this;
        }

        @Override // k3.AbstractC2074F.a.AbstractC0269a.AbstractC0270a
        public AbstractC2074F.a.AbstractC0269a.AbstractC0270a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f17794c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.a.AbstractC0269a.AbstractC0270a
        public AbstractC2074F.a.AbstractC0269a.AbstractC0270a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f17793b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.a.AbstractC0269a
    public String b() {
        return this.f17789a;
    }

    @Override // k3.AbstractC2074F.a.AbstractC0269a
    public String c() {
        return this.f17791c;
    }

    @Override // k3.AbstractC2074F.a.AbstractC0269a
    public String d() {
        return this.f17790b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.a.AbstractC0269a)) {
            return false;
        }
        AbstractC2074F.a.AbstractC0269a abstractC0269a = (AbstractC2074F.a.AbstractC0269a) obj;
        return this.f17789a.equals(abstractC0269a.b()) && this.f17790b.equals(abstractC0269a.d()) && this.f17791c.equals(abstractC0269a.c());
    }

    public int hashCode() {
        return ((((this.f17789a.hashCode() ^ 1000003) * 1000003) ^ this.f17790b.hashCode()) * 1000003) ^ this.f17791c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f17789a + ", libraryName=" + this.f17790b + ", buildId=" + this.f17791c + "}";
    }

    public C2079d(String str, String str2, String str3) {
        this.f17789a = str;
        this.f17790b = str2;
        this.f17791c = str3;
    }
}
