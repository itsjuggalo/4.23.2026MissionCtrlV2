package V2;

import V2.F;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p extends F.e.d.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final F.e.d.a.b.c f8834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8835e;

    public static final class b extends F.e.d.a.b.c.AbstractC0129a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f8838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public F.e.d.a.b.c f8839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f8841f;

        @Override // V2.F.e.d.a.b.c.AbstractC0129a
        public F.e.d.a.b.c a() {
            String str;
            List list;
            if (this.f8841f == 1 && (str = this.f8836a) != null && (list = this.f8838c) != null) {
                return new p(str, this.f8837b, list, this.f8839d, this.f8840e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8836a == null) {
                sb.append(" type");
            }
            if (this.f8838c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f8841f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.b.c.AbstractC0129a
        public F.e.d.a.b.c.AbstractC0129a b(F.e.d.a.b.c cVar) {
            this.f8839d = cVar;
            return this;
        }

        @Override // V2.F.e.d.a.b.c.AbstractC0129a
        public F.e.d.a.b.c.AbstractC0129a c(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f8838c = list;
            return this;
        }

        @Override // V2.F.e.d.a.b.c.AbstractC0129a
        public F.e.d.a.b.c.AbstractC0129a d(int i8) {
            this.f8840e = i8;
            this.f8841f = (byte) (this.f8841f | 1);
            return this;
        }

        @Override // V2.F.e.d.a.b.c.AbstractC0129a
        public F.e.d.a.b.c.AbstractC0129a e(String str) {
            this.f8837b = str;
            return this;
        }

        @Override // V2.F.e.d.a.b.c.AbstractC0129a
        public F.e.d.a.b.c.AbstractC0129a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f8836a = str;
            return this;
        }
    }

    public p(String str, String str2, List list, F.e.d.a.b.c cVar, int i8) {
        this.f8831a = str;
        this.f8832b = str2;
        this.f8833c = list;
        this.f8834d = cVar;
        this.f8835e = i8;
    }

    @Override // V2.F.e.d.a.b.c
    public F.e.d.a.b.c b() {
        return this.f8834d;
    }

    @Override // V2.F.e.d.a.b.c
    public List c() {
        return this.f8833c;
    }

    @Override // V2.F.e.d.a.b.c
    public int d() {
        return this.f8835e;
    }

    @Override // V2.F.e.d.a.b.c
    public String e() {
        return this.f8832b;
    }

    public boolean equals(Object obj) {
        String str;
        F.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.b.c)) {
            return false;
        }
        F.e.d.a.b.c cVar2 = (F.e.d.a.b.c) obj;
        return this.f8831a.equals(cVar2.f()) && ((str = this.f8832b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f8833c.equals(cVar2.c()) && ((cVar = this.f8834d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f8835e == cVar2.d();
    }

    @Override // V2.F.e.d.a.b.c
    public String f() {
        return this.f8831a;
    }

    public int hashCode() {
        int iHashCode = (this.f8831a.hashCode() ^ 1000003) * 1000003;
        String str = this.f8832b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f8833c.hashCode()) * 1000003;
        F.e.d.a.b.c cVar = this.f8834d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f8835e;
    }

    public String toString() {
        return "Exception{type=" + this.f8831a + ", reason=" + this.f8832b + ", frames=" + this.f8833c + ", causedBy=" + this.f8834d + ", overflowCount=" + this.f8835e + "}";
    }
}
