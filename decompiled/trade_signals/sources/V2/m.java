package V2;

import V2.F;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m extends F.e.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F.e.d.a.b f8797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f8798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f8800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final F.e.d.a.c f8801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f8802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8803g;

    public static final class b extends F.e.d.a.AbstractC0125a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public F.e.d.a.b f8804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f8805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f8806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f8807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public F.e.d.a.c f8808e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f8809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8810g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte f8811h;

        public b() {
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a a() {
            F.e.d.a.b bVar;
            if (this.f8811h == 1 && (bVar = this.f8804a) != null) {
                return new m(bVar, this.f8805b, this.f8806c, this.f8807d, this.f8808e, this.f8809f, this.f8810g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8804a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f8811h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a b(List list) {
            this.f8809f = list;
            return this;
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a c(Boolean bool) {
            this.f8807d = bool;
            return this;
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a d(F.e.d.a.c cVar) {
            this.f8808e = cVar;
            return this;
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a e(List list) {
            this.f8805b = list;
            return this;
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a f(F.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f8804a = bVar;
            return this;
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a g(List list) {
            this.f8806c = list;
            return this;
        }

        @Override // V2.F.e.d.a.AbstractC0125a
        public F.e.d.a.AbstractC0125a h(int i8) {
            this.f8810g = i8;
            this.f8811h = (byte) (this.f8811h | 1);
            return this;
        }

        public b(F.e.d.a aVar) {
            this.f8804a = aVar.f();
            this.f8805b = aVar.e();
            this.f8806c = aVar.g();
            this.f8807d = aVar.c();
            this.f8808e = aVar.d();
            this.f8809f = aVar.b();
            this.f8810g = aVar.h();
            this.f8811h = (byte) 1;
        }
    }

    public m(F.e.d.a.b bVar, List list, List list2, Boolean bool, F.e.d.a.c cVar, List list3, int i8) {
        this.f8797a = bVar;
        this.f8798b = list;
        this.f8799c = list2;
        this.f8800d = bool;
        this.f8801e = cVar;
        this.f8802f = list3;
        this.f8803g = i8;
    }

    @Override // V2.F.e.d.a
    public List b() {
        return this.f8802f;
    }

    @Override // V2.F.e.d.a
    public Boolean c() {
        return this.f8800d;
    }

    @Override // V2.F.e.d.a
    public F.e.d.a.c d() {
        return this.f8801e;
    }

    @Override // V2.F.e.d.a
    public List e() {
        return this.f8798b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        F.e.d.a.c cVar;
        List list3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a)) {
            return false;
        }
        F.e.d.a aVar = (F.e.d.a) obj;
        return this.f8797a.equals(aVar.f()) && ((list = this.f8798b) != null ? list.equals(aVar.e()) : aVar.e() == null) && ((list2 = this.f8799c) != null ? list2.equals(aVar.g()) : aVar.g() == null) && ((bool = this.f8800d) != null ? bool.equals(aVar.c()) : aVar.c() == null) && ((cVar = this.f8801e) != null ? cVar.equals(aVar.d()) : aVar.d() == null) && ((list3 = this.f8802f) != null ? list3.equals(aVar.b()) : aVar.b() == null) && this.f8803g == aVar.h();
    }

    @Override // V2.F.e.d.a
    public F.e.d.a.b f() {
        return this.f8797a;
    }

    @Override // V2.F.e.d.a
    public List g() {
        return this.f8799c;
    }

    @Override // V2.F.e.d.a
    public int h() {
        return this.f8803g;
    }

    public int hashCode() {
        int iHashCode = (this.f8797a.hashCode() ^ 1000003) * 1000003;
        List list = this.f8798b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f8799c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f8800d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        F.e.d.a.c cVar = this.f8801e;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list3 = this.f8802f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f8803g;
    }

    @Override // V2.F.e.d.a
    public F.e.d.a.AbstractC0125a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f8797a + ", customAttributes=" + this.f8798b + ", internalKeys=" + this.f8799c + ", background=" + this.f8800d + ", currentProcessDetails=" + this.f8801e + ", appProcessDetails=" + this.f8802f + ", uiOrientation=" + this.f8803g + "}";
    }
}
