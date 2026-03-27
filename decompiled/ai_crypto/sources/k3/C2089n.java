package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2089n extends AbstractC2074F.e.d.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2074F.e.d.a.b.c f17892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2074F.a f17893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2074F.e.d.a.b.AbstractC0277d f17894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f17895e;

    /* JADX INFO: renamed from: k3.n$b */
    public static final class b extends AbstractC2074F.e.d.a.b.AbstractC0275b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f17896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC2074F.e.d.a.b.c f17897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AbstractC2074F.a f17898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC2074F.e.d.a.b.AbstractC0277d f17899d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f17900e;

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0275b
        public AbstractC2074F.e.d.a.b a() {
            List list;
            AbstractC2074F.e.d.a.b.AbstractC0277d abstractC0277d = this.f17899d;
            if (abstractC0277d != null && (list = this.f17900e) != null) {
                return new C2089n(this.f17896a, this.f17897b, this.f17898c, abstractC0277d, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17899d == null) {
                sb.append(" signal");
            }
            if (this.f17900e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0275b
        public AbstractC2074F.e.d.a.b.AbstractC0275b b(AbstractC2074F.a aVar) {
            this.f17898c = aVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0275b
        public AbstractC2074F.e.d.a.b.AbstractC0275b c(List list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f17900e = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0275b
        public AbstractC2074F.e.d.a.b.AbstractC0275b d(AbstractC2074F.e.d.a.b.c cVar) {
            this.f17897b = cVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0275b
        public AbstractC2074F.e.d.a.b.AbstractC0275b e(AbstractC2074F.e.d.a.b.AbstractC0277d abstractC0277d) {
            if (abstractC0277d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f17899d = abstractC0277d;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0275b
        public AbstractC2074F.e.d.a.b.AbstractC0275b f(List list) {
            this.f17896a = list;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.b
    public AbstractC2074F.a b() {
        return this.f17893c;
    }

    @Override // k3.AbstractC2074F.e.d.a.b
    public List c() {
        return this.f17895e;
    }

    @Override // k3.AbstractC2074F.e.d.a.b
    public AbstractC2074F.e.d.a.b.c d() {
        return this.f17892b;
    }

    @Override // k3.AbstractC2074F.e.d.a.b
    public AbstractC2074F.e.d.a.b.AbstractC0277d e() {
        return this.f17894d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.b)) {
            return false;
        }
        AbstractC2074F.e.d.a.b bVar = (AbstractC2074F.e.d.a.b) obj;
        List list = this.f17891a;
        if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
            AbstractC2074F.e.d.a.b.c cVar = this.f17892b;
            if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                AbstractC2074F.a aVar = this.f17893c;
                if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                    if (this.f17894d.equals(bVar.e()) && this.f17895e.equals(bVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // k3.AbstractC2074F.e.d.a.b
    public List f() {
        return this.f17891a;
    }

    public int hashCode() {
        List list = this.f17891a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        AbstractC2074F.e.d.a.b.c cVar = this.f17892b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        AbstractC2074F.a aVar = this.f17893c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f17894d.hashCode()) * 1000003) ^ this.f17895e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f17891a + ", exception=" + this.f17892b + ", appExitInfo=" + this.f17893c + ", signal=" + this.f17894d + ", binaries=" + this.f17895e + "}";
    }

    public C2089n(List list, AbstractC2074F.e.d.a.b.c cVar, AbstractC2074F.a aVar, AbstractC2074F.e.d.a.b.AbstractC0277d abstractC0277d, List list2) {
        this.f17891a = list;
        this.f17892b = cVar;
        this.f17893c = aVar;
        this.f17894d = abstractC0277d;
        this.f17895e = list2;
    }
}
