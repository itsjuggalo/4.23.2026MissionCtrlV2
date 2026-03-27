package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class z extends F.e.AbstractC0139e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8909d;

    public static final class b extends F.e.AbstractC0139e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f8914e;

        @Override // V2.F.e.AbstractC0139e.a
        public F.e.AbstractC0139e a() {
            String str;
            String str2;
            if (this.f8914e == 3 && (str = this.f8911b) != null && (str2 = this.f8912c) != null) {
                return new z(this.f8910a, str, str2, this.f8913d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f8914e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f8911b == null) {
                sb.append(" version");
            }
            if (this.f8912c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f8914e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.AbstractC0139e.a
        public F.e.AbstractC0139e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f8912c = str;
            return this;
        }

        @Override // V2.F.e.AbstractC0139e.a
        public F.e.AbstractC0139e.a c(boolean z7) {
            this.f8913d = z7;
            this.f8914e = (byte) (this.f8914e | 2);
            return this;
        }

        @Override // V2.F.e.AbstractC0139e.a
        public F.e.AbstractC0139e.a d(int i8) {
            this.f8910a = i8;
            this.f8914e = (byte) (this.f8914e | 1);
            return this;
        }

        @Override // V2.F.e.AbstractC0139e.a
        public F.e.AbstractC0139e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f8911b = str;
            return this;
        }
    }

    public z(int i8, String str, String str2, boolean z7) {
        this.f8906a = i8;
        this.f8907b = str;
        this.f8908c = str2;
        this.f8909d = z7;
    }

    @Override // V2.F.e.AbstractC0139e
    public String b() {
        return this.f8908c;
    }

    @Override // V2.F.e.AbstractC0139e
    public int c() {
        return this.f8906a;
    }

    @Override // V2.F.e.AbstractC0139e
    public String d() {
        return this.f8907b;
    }

    @Override // V2.F.e.AbstractC0139e
    public boolean e() {
        return this.f8909d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.AbstractC0139e)) {
            return false;
        }
        F.e.AbstractC0139e abstractC0139e = (F.e.AbstractC0139e) obj;
        return this.f8906a == abstractC0139e.c() && this.f8907b.equals(abstractC0139e.d()) && this.f8908c.equals(abstractC0139e.b()) && this.f8909d == abstractC0139e.e();
    }

    public int hashCode() {
        return ((((((this.f8906a ^ 1000003) * 1000003) ^ this.f8907b.hashCode()) * 1000003) ^ this.f8908c.hashCode()) * 1000003) ^ (this.f8909d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f8906a + ", version=" + this.f8907b + ", buildVersion=" + this.f8908c + ", jailbroken=" + this.f8909d + "}";
    }
}
