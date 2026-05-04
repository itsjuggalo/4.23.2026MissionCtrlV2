package k4;

import k4.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o.b f14599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k4.a f14600b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o.b f14601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k4.a f14602b;

        @Override // k4.o.a
        public o a() {
            return new e(this.f14601a, this.f14602b);
        }

        @Override // k4.o.a
        public o.a b(k4.a aVar) {
            this.f14602b = aVar;
            return this;
        }

        @Override // k4.o.a
        public o.a c(o.b bVar) {
            this.f14601a = bVar;
            return this;
        }
    }

    @Override // k4.o
    public k4.a b() {
        return this.f14600b;
    }

    @Override // k4.o
    public o.b c() {
        return this.f14599a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            o.b bVar = this.f14599a;
            if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
                k4.a aVar = this.f14600b;
                if (aVar != null ? aVar.equals(oVar.b()) : oVar.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        o.b bVar = this.f14599a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        k4.a aVar = this.f14600b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f14599a + ", androidClientInfo=" + this.f14600b + "}";
    }

    public e(o.b bVar, k4.a aVar) {
        this.f14599a = bVar;
        this.f14600b = aVar;
    }
}
