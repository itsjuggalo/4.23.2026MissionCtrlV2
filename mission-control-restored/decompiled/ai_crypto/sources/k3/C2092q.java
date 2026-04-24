package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2092q extends AbstractC2074F.e.d.a.b.AbstractC0277d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17923c;

    /* JADX INFO: renamed from: k3.q$b */
    public static final class b extends AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f17926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f17927d;

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a
        public AbstractC2074F.e.d.a.b.AbstractC0277d a() {
            String str;
            String str2;
            if (this.f17927d == 1 && (str = this.f17924a) != null && (str2 = this.f17925b) != null) {
                return new C2092q(str, str2, this.f17926c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17924a == null) {
                sb.append(" name");
            }
            if (this.f17925b == null) {
                sb.append(" code");
            }
            if ((1 & this.f17927d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a
        public AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a b(long j7) {
            this.f17926c = j7;
            this.f17927d = (byte) (this.f17927d | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a
        public AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f17925b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a
        public AbstractC2074F.e.d.a.b.AbstractC0277d.AbstractC0278a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f17924a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d
    public long b() {
        return this.f17923c;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d
    public String c() {
        return this.f17922b;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0277d
    public String d() {
        return this.f17921a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.b.AbstractC0277d)) {
            return false;
        }
        AbstractC2074F.e.d.a.b.AbstractC0277d abstractC0277d = (AbstractC2074F.e.d.a.b.AbstractC0277d) obj;
        return this.f17921a.equals(abstractC0277d.d()) && this.f17922b.equals(abstractC0277d.c()) && this.f17923c == abstractC0277d.b();
    }

    public int hashCode() {
        int iHashCode = (((this.f17921a.hashCode() ^ 1000003) * 1000003) ^ this.f17922b.hashCode()) * 1000003;
        long j7 = this.f17923c;
        return iHashCode ^ ((int) (j7 ^ (j7 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f17921a + ", code=" + this.f17922b + ", address=" + this.f17923c + "}";
    }

    public C2092q(String str, String str2, long j7) {
        this.f17921a = str;
        this.f17922b = str2;
        this.f17923c = j7;
    }
}
