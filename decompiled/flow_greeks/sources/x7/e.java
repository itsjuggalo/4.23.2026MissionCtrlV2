package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24471b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24473b;

        @Override // x7.f0.c.a
        public f0.c a() {
            String str;
            String str2 = this.f24472a;
            if (str2 != null && (str = this.f24473b) != null) {
                return new e(str2, str);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24472a == null) {
                sb2.append(" key");
            }
            if (this.f24473b == null) {
                sb2.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.c.a
        public f0.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f24472a = str;
            return this;
        }

        @Override // x7.f0.c.a
        public f0.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f24473b = str;
            return this;
        }
    }

    @Override // x7.f0.c
    public String b() {
        return this.f24470a;
    }

    @Override // x7.f0.c
    public String c() {
        return this.f24471b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.c) {
            f0.c cVar = (f0.c) obj;
            if (this.f24470a.equals(cVar.b()) && this.f24471b.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f24470a.hashCode() ^ 1000003) * 1000003) ^ this.f24471b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f24470a + ", value=" + this.f24471b + "}";
    }

    public e(String str, String str2) {
        this.f24470a = str;
        this.f24471b = str2;
    }
}
