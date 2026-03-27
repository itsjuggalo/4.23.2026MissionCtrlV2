package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class A extends F.e.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8495a;

    public static final class b extends F.e.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8496a;

        @Override // V2.F.e.f.a
        public F.e.f a() {
            String str = this.f8496a;
            if (str != null) {
                return new A(str);
            }
            throw new IllegalStateException("Missing required properties: identifier");
        }

        @Override // V2.F.e.f.a
        public F.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f8496a = str;
            return this;
        }
    }

    public A(String str) {
        this.f8495a = str;
    }

    @Override // V2.F.e.f
    public String b() {
        return this.f8495a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.f) {
            return this.f8495a.equals(((F.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f8495a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f8495a + "}";
    }
}
