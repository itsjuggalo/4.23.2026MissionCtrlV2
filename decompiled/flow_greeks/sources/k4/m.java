package k4;

import k4.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f14648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.b f14649b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w.c f14650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.b f14651b;

        @Override // k4.w.a
        public w a() {
            return new m(this.f14650a, this.f14651b);
        }

        @Override // k4.w.a
        public w.a b(w.b bVar) {
            this.f14651b = bVar;
            return this;
        }

        @Override // k4.w.a
        public w.a c(w.c cVar) {
            this.f14650a = cVar;
            return this;
        }
    }

    @Override // k4.w
    public w.b b() {
        return this.f14649b;
    }

    @Override // k4.w
    public w.c c() {
        return this.f14648a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            w.c cVar = this.f14648a;
            if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
                w.b bVar = this.f14649b;
                if (bVar != null ? bVar.equals(wVar.b()) : wVar.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        w.c cVar = this.f14648a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        w.b bVar = this.f14649b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f14648a + ", mobileSubtype=" + this.f14649b + "}";
    }

    public m(w.c cVar, w.b bVar) {
        this.f14648a = cVar;
        this.f14649b = bVar;
    }
}
