package q1;

import q1.o;

/* JADX INFO: renamed from: q1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2554e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o.b f22185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2550a f22186b;

    /* JADX INFO: renamed from: q1.e$b */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o.b f22187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC2550a f22188b;

        @Override // q1.o.a
        public o a() {
            return new C2554e(this.f22187a, this.f22188b);
        }

        @Override // q1.o.a
        public o.a b(AbstractC2550a abstractC2550a) {
            this.f22188b = abstractC2550a;
            return this;
        }

        @Override // q1.o.a
        public o.a c(o.b bVar) {
            this.f22187a = bVar;
            return this;
        }
    }

    @Override // q1.o
    public AbstractC2550a b() {
        return this.f22186b;
    }

    @Override // q1.o
    public o.b c() {
        return this.f22185a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.b bVar = this.f22185a;
        if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
            AbstractC2550a abstractC2550a = this.f22186b;
            if (abstractC2550a == null) {
                if (oVar.b() == null) {
                    return true;
                }
            } else if (abstractC2550a.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.b bVar = this.f22185a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC2550a abstractC2550a = this.f22186b;
        return iHashCode ^ (abstractC2550a != null ? abstractC2550a.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f22185a + ", androidClientInfo=" + this.f22186b + "}";
    }

    public C2554e(o.b bVar, AbstractC2550a abstractC2550a) {
        this.f22185a = bVar;
        this.f22186b = abstractC2550a;
    }
}
