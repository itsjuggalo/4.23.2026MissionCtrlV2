package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2080e extends AbstractC2074F.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17796b;

    /* JADX INFO: renamed from: k3.e$b */
    public static final class b extends AbstractC2074F.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17798b;

        @Override // k3.AbstractC2074F.c.a
        public AbstractC2074F.c a() {
            String str;
            String str2 = this.f17797a;
            if (str2 != null && (str = this.f17798b) != null) {
                return new C2080e(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17797a == null) {
                sb.append(" key");
            }
            if (this.f17798b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.c.a
        public AbstractC2074F.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f17797a = str;
            return this;
        }

        @Override // k3.AbstractC2074F.c.a
        public AbstractC2074F.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f17798b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.c
    public String b() {
        return this.f17795a;
    }

    @Override // k3.AbstractC2074F.c
    public String c() {
        return this.f17796b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.c)) {
            return false;
        }
        AbstractC2074F.c cVar = (AbstractC2074F.c) obj;
        return this.f17795a.equals(cVar.b()) && this.f17796b.equals(cVar.c());
    }

    public int hashCode() {
        return ((this.f17795a.hashCode() ^ 1000003) * 1000003) ^ this.f17796b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f17795a + ", value=" + this.f17796b + "}";
    }

    public C2080e(String str, String str2) {
        this.f17795a = str;
        this.f17796b = str2;
    }
}
