package y1;

import y1.w;

/* JADX INFO: loaded from: classes.dex */
public final class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f24387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.b f24388b;

    public static final class b extends w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w.c f24389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.b f24390b;

        @Override // y1.w.a
        public w a() {
            return new m(this.f24389a, this.f24390b);
        }

        @Override // y1.w.a
        public w.a b(w.b bVar) {
            this.f24390b = bVar;
            return this;
        }

        @Override // y1.w.a
        public w.a c(w.c cVar) {
            this.f24389a = cVar;
            return this;
        }
    }

    public m(w.c cVar, w.b bVar) {
        this.f24387a = cVar;
        this.f24388b = bVar;
    }

    @Override // y1.w
    public w.b b() {
        return this.f24388b;
    }

    @Override // y1.w
    public w.c c() {
        return this.f24387a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        w.c cVar = this.f24387a;
        if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
            w.b bVar = this.f24388b;
            w.b bVarB = wVar.b();
            if (bVar == null) {
                if (bVarB == null) {
                    return true;
                }
            } else if (bVar.equals(bVarB)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        w.c cVar = this.f24387a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        w.b bVar = this.f24388b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f24387a + ", mobileSubtype=" + this.f24388b + "}";
    }
}
