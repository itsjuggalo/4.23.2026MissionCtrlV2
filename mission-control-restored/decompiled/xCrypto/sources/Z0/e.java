package Z0;

import Z0.o;

/* JADX INFO: loaded from: classes.dex */
public final class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o.b f5843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z0.a f5844b;

    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o.b f5845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Z0.a f5846b;

        @Override // Z0.o.a
        public o a() {
            return new e(this.f5845a, this.f5846b);
        }

        @Override // Z0.o.a
        public o.a b(Z0.a aVar) {
            this.f5846b = aVar;
            return this;
        }

        @Override // Z0.o.a
        public o.a c(o.b bVar) {
            this.f5845a = bVar;
            return this;
        }
    }

    @Override // Z0.o
    public Z0.a b() {
        return this.f5844b;
    }

    @Override // Z0.o
    public o.b c() {
        return this.f5843a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            o.b bVar = this.f5843a;
            if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
                Z0.a aVar = this.f5844b;
                if (aVar != null ? aVar.equals(oVar.b()) : oVar.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        o.b bVar = this.f5843a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        Z0.a aVar = this.f5844b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f5843a + ", androidClientInfo=" + this.f5844b + "}";
    }

    public e(o.b bVar, Z0.a aVar) {
        this.f5843a = bVar;
        this.f5844b = aVar;
    }
}
