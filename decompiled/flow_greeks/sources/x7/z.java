package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends f0.e.AbstractC0447e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24667d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.AbstractC0447e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f24672e;

        @Override // x7.f0.e.AbstractC0447e.a
        public f0.e.AbstractC0447e a() {
            String str;
            String str2;
            if (this.f24672e == 3 && (str = this.f24669b) != null && (str2 = this.f24670c) != null) {
                return new z(this.f24668a, str, str2, this.f24671d);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f24672e & 1) == 0) {
                sb2.append(" platform");
            }
            if (this.f24669b == null) {
                sb2.append(" version");
            }
            if (this.f24670c == null) {
                sb2.append(" buildVersion");
            }
            if ((this.f24672e & 2) == 0) {
                sb2.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.AbstractC0447e.a
        public f0.e.AbstractC0447e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f24670c = str;
            return this;
        }

        @Override // x7.f0.e.AbstractC0447e.a
        public f0.e.AbstractC0447e.a c(boolean z10) {
            this.f24671d = z10;
            this.f24672e = (byte) (this.f24672e | 2);
            return this;
        }

        @Override // x7.f0.e.AbstractC0447e.a
        public f0.e.AbstractC0447e.a d(int i10) {
            this.f24668a = i10;
            this.f24672e = (byte) (this.f24672e | 1);
            return this;
        }

        @Override // x7.f0.e.AbstractC0447e.a
        public f0.e.AbstractC0447e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f24669b = str;
            return this;
        }
    }

    @Override // x7.f0.e.AbstractC0447e
    public String b() {
        return this.f24666c;
    }

    @Override // x7.f0.e.AbstractC0447e
    public int c() {
        return this.f24664a;
    }

    @Override // x7.f0.e.AbstractC0447e
    public String d() {
        return this.f24665b;
    }

    @Override // x7.f0.e.AbstractC0447e
    public boolean e() {
        return this.f24667d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.AbstractC0447e) {
            f0.e.AbstractC0447e abstractC0447e = (f0.e.AbstractC0447e) obj;
            if (this.f24664a == abstractC0447e.c() && this.f24665b.equals(abstractC0447e.d()) && this.f24666c.equals(abstractC0447e.b()) && this.f24667d == abstractC0447e.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f24664a ^ 1000003) * 1000003) ^ this.f24665b.hashCode()) * 1000003) ^ this.f24666c.hashCode()) * 1000003) ^ (this.f24667d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f24664a + ", version=" + this.f24665b + ", buildVersion=" + this.f24666c + ", jailbroken=" + this.f24667d + "}";
    }

    public z(int i10, String str, String str2, boolean z10) {
        this.f24664a = i10;
        this.f24665b = str;
        this.f24666c = str2;
        this.f24667d = z10;
    }
}
