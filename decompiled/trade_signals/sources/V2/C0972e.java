package V2;

import V2.F;

/* JADX INFO: renamed from: V2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0972e extends F.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8717b;

    /* JADX INFO: renamed from: V2.e$b */
    public static final class b extends F.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8719b;

        @Override // V2.F.c.a
        public F.c a() {
            String str;
            String str2 = this.f8718a;
            if (str2 != null && (str = this.f8719b) != null) {
                return new C0972e(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8718a == null) {
                sb.append(" key");
            }
            if (this.f8719b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.c.a
        public F.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f8718a = str;
            return this;
        }

        @Override // V2.F.c.a
        public F.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f8719b = str;
            return this;
        }
    }

    public C0972e(String str, String str2) {
        this.f8716a = str;
        this.f8717b = str2;
    }

    @Override // V2.F.c
    public String b() {
        return this.f8716a;
    }

    @Override // V2.F.c
    public String c() {
        return this.f8717b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.c)) {
            return false;
        }
        F.c cVar = (F.c) obj;
        return this.f8716a.equals(cVar.b()) && this.f8717b.equals(cVar.c());
    }

    public int hashCode() {
        return ((this.f8716a.hashCode() ^ 1000003) * 1000003) ^ this.f8717b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f8716a + ", value=" + this.f8717b + "}";
    }
}
