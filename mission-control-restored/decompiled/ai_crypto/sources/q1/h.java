package q1;

import q1.r;

/* JADX INFO: loaded from: classes.dex */
public final class h extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f22197a;

    public static final class b extends r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f22198a;

        @Override // q1.r.a
        public r a() {
            return new h(this.f22198a);
        }

        @Override // q1.r.a
        public r.a b(Integer num) {
            this.f22198a = num;
            return this;
        }
    }

    @Override // q1.r
    public Integer b() {
        return this.f22197a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        Integer num = this.f22197a;
        Integer numB = ((r) obj).b();
        return num == null ? numB == null : num.equals(numB);
    }

    public int hashCode() {
        Integer num = this.f22197a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f22197a + "}";
    }

    public h(Integer num) {
        this.f22197a = num;
    }
}
