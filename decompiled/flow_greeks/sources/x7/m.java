package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends f0.e.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0.e.d.a.b f24555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f24556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f24557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f24558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0.e.d.a.c f24559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f24560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f24561g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.AbstractC0433a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f0.e.d.a.b f24562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f24563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f24564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f24565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f0.e.d.a.c f24566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f24567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f24568g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte f24569h;

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a a() {
            f0.e.d.a.b bVar;
            if (this.f24569h == 1 && (bVar = this.f24562a) != null) {
                return new m(bVar, this.f24563b, this.f24564c, this.f24565d, this.f24566e, this.f24567f, this.f24568g);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24562a == null) {
                sb2.append(" execution");
            }
            if ((1 & this.f24569h) == 0) {
                sb2.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a b(List list) {
            this.f24567f = list;
            return this;
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a c(Boolean bool) {
            this.f24565d = bool;
            return this;
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a d(f0.e.d.a.c cVar) {
            this.f24566e = cVar;
            return this;
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a e(List list) {
            this.f24563b = list;
            return this;
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a f(f0.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f24562a = bVar;
            return this;
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a g(List list) {
            this.f24564c = list;
            return this;
        }

        @Override // x7.f0.e.d.a.AbstractC0433a
        public f0.e.d.a.AbstractC0433a h(int i10) {
            this.f24568g = i10;
            this.f24569h = (byte) (this.f24569h | 1);
            return this;
        }

        public b() {
        }

        public b(f0.e.d.a aVar) {
            this.f24562a = aVar.f();
            this.f24563b = aVar.e();
            this.f24564c = aVar.g();
            this.f24565d = aVar.c();
            this.f24566e = aVar.d();
            this.f24567f = aVar.b();
            this.f24568g = aVar.h();
            this.f24569h = (byte) 1;
        }
    }

    @Override // x7.f0.e.d.a
    public List b() {
        return this.f24560f;
    }

    @Override // x7.f0.e.d.a
    public Boolean c() {
        return this.f24558d;
    }

    @Override // x7.f0.e.d.a
    public f0.e.d.a.c d() {
        return this.f24559e;
    }

    @Override // x7.f0.e.d.a
    public List e() {
        return this.f24556b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        f0.e.d.a.c cVar;
        List list3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a) {
            f0.e.d.a aVar = (f0.e.d.a) obj;
            if (this.f24555a.equals(aVar.f()) && ((list = this.f24556b) != null ? list.equals(aVar.e()) : aVar.e() == null) && ((list2 = this.f24557c) != null ? list2.equals(aVar.g()) : aVar.g() == null) && ((bool = this.f24558d) != null ? bool.equals(aVar.c()) : aVar.c() == null) && ((cVar = this.f24559e) != null ? cVar.equals(aVar.d()) : aVar.d() == null) && ((list3 = this.f24560f) != null ? list3.equals(aVar.b()) : aVar.b() == null) && this.f24561g == aVar.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.e.d.a
    public f0.e.d.a.b f() {
        return this.f24555a;
    }

    @Override // x7.f0.e.d.a
    public List g() {
        return this.f24557c;
    }

    @Override // x7.f0.e.d.a
    public int h() {
        return this.f24561g;
    }

    public int hashCode() {
        int iHashCode = (this.f24555a.hashCode() ^ 1000003) * 1000003;
        List list = this.f24556b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f24557c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f24558d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        f0.e.d.a.c cVar = this.f24559e;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list3 = this.f24560f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f24561g;
    }

    @Override // x7.f0.e.d.a
    public f0.e.d.a.AbstractC0433a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f24555a + ", customAttributes=" + this.f24556b + ", internalKeys=" + this.f24557c + ", background=" + this.f24558d + ", currentProcessDetails=" + this.f24559e + ", appProcessDetails=" + this.f24560f + ", uiOrientation=" + this.f24561g + "}";
    }

    public m(f0.e.d.a.b bVar, List list, List list2, Boolean bool, f0.e.d.a.c cVar, List list3, int i10) {
        this.f24555a = bVar;
        this.f24556b = list;
        this.f24557c = list2;
        this.f24558d = bool;
        this.f24559e = cVar;
        this.f24560f = list3;
        this.f24561g = i10;
    }
}
