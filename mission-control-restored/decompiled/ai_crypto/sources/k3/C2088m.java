package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2088m extends AbstractC2074F.e.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2074F.e.d.a.b f17876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f17877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f17878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f17879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC2074F.e.d.a.c f17880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f17881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17882g;

    /* JADX INFO: renamed from: k3.m$b */
    public static final class b extends AbstractC2074F.e.d.a.AbstractC0272a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC2074F.e.d.a.b f17883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f17884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f17885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f17886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbstractC2074F.e.d.a.c f17887e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f17888f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f17889g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte f17890h;

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a a() {
            AbstractC2074F.e.d.a.b bVar;
            if (this.f17890h == 1 && (bVar = this.f17883a) != null) {
                return new C2088m(bVar, this.f17884b, this.f17885c, this.f17886d, this.f17887e, this.f17888f, this.f17889g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17883a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f17890h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a b(List list) {
            this.f17888f = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a c(Boolean bool) {
            this.f17886d = bool;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a d(AbstractC2074F.e.d.a.c cVar) {
            this.f17887e = cVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a e(List list) {
            this.f17884b = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a f(AbstractC2074F.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f17883a = bVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a g(List list) {
            this.f17885c = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.AbstractC0272a
        public AbstractC2074F.e.d.a.AbstractC0272a h(int i7) {
            this.f17889g = i7;
            this.f17890h = (byte) (this.f17890h | 1);
            return this;
        }

        public b() {
        }

        public b(AbstractC2074F.e.d.a aVar) {
            this.f17883a = aVar.f();
            this.f17884b = aVar.e();
            this.f17885c = aVar.g();
            this.f17886d = aVar.c();
            this.f17887e = aVar.d();
            this.f17888f = aVar.b();
            this.f17889g = aVar.h();
            this.f17890h = (byte) 1;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a
    public List b() {
        return this.f17881f;
    }

    @Override // k3.AbstractC2074F.e.d.a
    public Boolean c() {
        return this.f17879d;
    }

    @Override // k3.AbstractC2074F.e.d.a
    public AbstractC2074F.e.d.a.c d() {
        return this.f17880e;
    }

    @Override // k3.AbstractC2074F.e.d.a
    public List e() {
        return this.f17877b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        AbstractC2074F.e.d.a.c cVar;
        List list3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a)) {
            return false;
        }
        AbstractC2074F.e.d.a aVar = (AbstractC2074F.e.d.a) obj;
        return this.f17876a.equals(aVar.f()) && ((list = this.f17877b) != null ? list.equals(aVar.e()) : aVar.e() == null) && ((list2 = this.f17878c) != null ? list2.equals(aVar.g()) : aVar.g() == null) && ((bool = this.f17879d) != null ? bool.equals(aVar.c()) : aVar.c() == null) && ((cVar = this.f17880e) != null ? cVar.equals(aVar.d()) : aVar.d() == null) && ((list3 = this.f17881f) != null ? list3.equals(aVar.b()) : aVar.b() == null) && this.f17882g == aVar.h();
    }

    @Override // k3.AbstractC2074F.e.d.a
    public AbstractC2074F.e.d.a.b f() {
        return this.f17876a;
    }

    @Override // k3.AbstractC2074F.e.d.a
    public List g() {
        return this.f17878c;
    }

    @Override // k3.AbstractC2074F.e.d.a
    public int h() {
        return this.f17882g;
    }

    public int hashCode() {
        int iHashCode = (this.f17876a.hashCode() ^ 1000003) * 1000003;
        List list = this.f17877b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f17878c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f17879d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        AbstractC2074F.e.d.a.c cVar = this.f17880e;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list3 = this.f17881f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f17882g;
    }

    @Override // k3.AbstractC2074F.e.d.a
    public AbstractC2074F.e.d.a.AbstractC0272a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f17876a + ", customAttributes=" + this.f17877b + ", internalKeys=" + this.f17878c + ", background=" + this.f17879d + ", currentProcessDetails=" + this.f17880e + ", appProcessDetails=" + this.f17881f + ", uiOrientation=" + this.f17882g + "}";
    }

    public C2088m(AbstractC2074F.e.d.a.b bVar, List list, List list2, Boolean bool, AbstractC2074F.e.d.a.c cVar, List list3, int i7) {
        this.f17876a = bVar;
        this.f17877b = list;
        this.f17878c = list2;
        this.f17879d = bool;
        this.f17880e = cVar;
        this.f17881f = list3;
        this.f17882g = i7;
    }
}
