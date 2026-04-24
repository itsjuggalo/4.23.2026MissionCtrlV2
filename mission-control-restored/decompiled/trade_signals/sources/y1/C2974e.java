package y1;

import y1.o;

/* JADX INFO: renamed from: y1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2974e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o.b f24338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2970a f24339b;

    /* JADX INFO: renamed from: y1.e$b */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o.b f24340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC2970a f24341b;

        @Override // y1.o.a
        public o a() {
            return new C2974e(this.f24340a, this.f24341b);
        }

        @Override // y1.o.a
        public o.a b(AbstractC2970a abstractC2970a) {
            this.f24341b = abstractC2970a;
            return this;
        }

        @Override // y1.o.a
        public o.a c(o.b bVar) {
            this.f24340a = bVar;
            return this;
        }
    }

    public C2974e(o.b bVar, AbstractC2970a abstractC2970a) {
        this.f24338a = bVar;
        this.f24339b = abstractC2970a;
    }

    @Override // y1.o
    public AbstractC2970a b() {
        return this.f24339b;
    }

    @Override // y1.o
    public o.b c() {
        return this.f24338a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.b bVar = this.f24338a;
        if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
            AbstractC2970a abstractC2970a = this.f24339b;
            AbstractC2970a abstractC2970aB = oVar.b();
            if (abstractC2970a == null) {
                if (abstractC2970aB == null) {
                    return true;
                }
            } else if (abstractC2970a.equals(abstractC2970aB)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.b bVar = this.f24338a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC2970a abstractC2970a = this.f24339b;
        return iHashCode ^ (abstractC2970a != null ? abstractC2970a.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f24338a + ", androidClientInfo=" + this.f24339b + "}";
    }
}
