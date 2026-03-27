package V2;

import V2.F;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n extends F.e.d.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F.e.d.a.b.c f8813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F.a f8814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final F.e.d.a.b.AbstractC0130d f8815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f8816e;

    public static final class b extends F.e.d.a.b.AbstractC0128b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f8817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public F.e.d.a.b.c f8818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public F.a f8819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public F.e.d.a.b.AbstractC0130d f8820d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f8821e;

        @Override // V2.F.e.d.a.b.AbstractC0128b
        public F.e.d.a.b a() {
            List list;
            F.e.d.a.b.AbstractC0130d abstractC0130d = this.f8820d;
            if (abstractC0130d != null && (list = this.f8821e) != null) {
                return new n(this.f8817a, this.f8818b, this.f8819c, abstractC0130d, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8820d == null) {
                sb.append(" signal");
            }
            if (this.f8821e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.b.AbstractC0128b
        public F.e.d.a.b.AbstractC0128b b(F.a aVar) {
            this.f8819c = aVar;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0128b
        public F.e.d.a.b.AbstractC0128b c(List list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f8821e = list;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0128b
        public F.e.d.a.b.AbstractC0128b d(F.e.d.a.b.c cVar) {
            this.f8818b = cVar;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0128b
        public F.e.d.a.b.AbstractC0128b e(F.e.d.a.b.AbstractC0130d abstractC0130d) {
            if (abstractC0130d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f8820d = abstractC0130d;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0128b
        public F.e.d.a.b.AbstractC0128b f(List list) {
            this.f8817a = list;
            return this;
        }
    }

    public n(List list, F.e.d.a.b.c cVar, F.a aVar, F.e.d.a.b.AbstractC0130d abstractC0130d, List list2) {
        this.f8812a = list;
        this.f8813b = cVar;
        this.f8814c = aVar;
        this.f8815d = abstractC0130d;
        this.f8816e = list2;
    }

    @Override // V2.F.e.d.a.b
    public F.a b() {
        return this.f8814c;
    }

    @Override // V2.F.e.d.a.b
    public List c() {
        return this.f8816e;
    }

    @Override // V2.F.e.d.a.b
    public F.e.d.a.b.c d() {
        return this.f8813b;
    }

    @Override // V2.F.e.d.a.b
    public F.e.d.a.b.AbstractC0130d e() {
        return this.f8815d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.b)) {
            return false;
        }
        F.e.d.a.b bVar = (F.e.d.a.b) obj;
        List list = this.f8812a;
        if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
            F.e.d.a.b.c cVar = this.f8813b;
            if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                F.a aVar = this.f8814c;
                if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                    if (this.f8815d.equals(bVar.e()) && this.f8816e.equals(bVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // V2.F.e.d.a.b
    public List f() {
        return this.f8812a;
    }

    public int hashCode() {
        List list = this.f8812a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        F.e.d.a.b.c cVar = this.f8813b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        F.a aVar = this.f8814c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f8815d.hashCode()) * 1000003) ^ this.f8816e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f8812a + ", exception=" + this.f8813b + ", appExitInfo=" + this.f8814c + ", signal=" + this.f8815d + ", binaries=" + this.f8816e + "}";
    }
}
