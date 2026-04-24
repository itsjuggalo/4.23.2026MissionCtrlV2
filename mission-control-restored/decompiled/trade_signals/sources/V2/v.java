package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class v extends F.e.d.AbstractC0137d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8889a;

    public static final class b extends F.e.d.AbstractC0137d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8890a;

        @Override // V2.F.e.d.AbstractC0137d.a
        public F.e.d.AbstractC0137d a() {
            String str = this.f8890a;
            if (str != null) {
                return new v(str);
            }
            throw new IllegalStateException("Missing required properties: content");
        }

        @Override // V2.F.e.d.AbstractC0137d.a
        public F.e.d.AbstractC0137d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f8890a = str;
            return this;
        }
    }

    public v(String str) {
        this.f8889a = str;
    }

    @Override // V2.F.e.d.AbstractC0137d
    public String b() {
        return this.f8889a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.AbstractC0137d) {
            return this.f8889a.equals(((F.e.d.AbstractC0137d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f8889a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f8889a + "}";
    }
}
