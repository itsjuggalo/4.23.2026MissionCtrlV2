package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2101z extends AbstractC2074F.e.AbstractC0286e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17988d;

    /* JADX INFO: renamed from: k3.z$b */
    public static final class b extends AbstractC2074F.e.AbstractC0286e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f17992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f17993e;

        @Override // k3.AbstractC2074F.e.AbstractC0286e.a
        public AbstractC2074F.e.AbstractC0286e a() {
            String str;
            String str2;
            if (this.f17993e == 3 && (str = this.f17990b) != null && (str2 = this.f17991c) != null) {
                return new C2101z(this.f17989a, str, str2, this.f17992d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f17993e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f17990b == null) {
                sb.append(" version");
            }
            if (this.f17991c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f17993e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.AbstractC0286e.a
        public AbstractC2074F.e.AbstractC0286e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f17991c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.AbstractC0286e.a
        public AbstractC2074F.e.AbstractC0286e.a c(boolean z7) {
            this.f17992d = z7;
            this.f17993e = (byte) (this.f17993e | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.AbstractC0286e.a
        public AbstractC2074F.e.AbstractC0286e.a d(int i7) {
            this.f17989a = i7;
            this.f17993e = (byte) (this.f17993e | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.AbstractC0286e.a
        public AbstractC2074F.e.AbstractC0286e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f17990b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.AbstractC0286e
    public String b() {
        return this.f17987c;
    }

    @Override // k3.AbstractC2074F.e.AbstractC0286e
    public int c() {
        return this.f17985a;
    }

    @Override // k3.AbstractC2074F.e.AbstractC0286e
    public String d() {
        return this.f17986b;
    }

    @Override // k3.AbstractC2074F.e.AbstractC0286e
    public boolean e() {
        return this.f17988d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.AbstractC0286e)) {
            return false;
        }
        AbstractC2074F.e.AbstractC0286e abstractC0286e = (AbstractC2074F.e.AbstractC0286e) obj;
        return this.f17985a == abstractC0286e.c() && this.f17986b.equals(abstractC0286e.d()) && this.f17987c.equals(abstractC0286e.b()) && this.f17988d == abstractC0286e.e();
    }

    public int hashCode() {
        return ((((((this.f17985a ^ 1000003) * 1000003) ^ this.f17986b.hashCode()) * 1000003) ^ this.f17987c.hashCode()) * 1000003) ^ (this.f17988d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f17985a + ", version=" + this.f17986b + ", buildVersion=" + this.f17987c + ", jailbroken=" + this.f17988d + "}";
    }

    public C2101z(int i7, String str, String str2, boolean z7) {
        this.f17985a = i7;
        this.f17986b = str;
        this.f17987c = str2;
        this.f17988d = z7;
    }
}
