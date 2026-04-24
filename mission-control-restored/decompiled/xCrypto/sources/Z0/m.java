package Z0;

import Z0.w;

/* JADX INFO: loaded from: classes.dex */
public final class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f5892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.b f5893b;

    public static final class b extends w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w.c f5894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.b f5895b;

        @Override // Z0.w.a
        public w a() {
            return new m(this.f5894a, this.f5895b);
        }

        @Override // Z0.w.a
        public w.a b(w.b bVar) {
            this.f5895b = bVar;
            return this;
        }

        @Override // Z0.w.a
        public w.a c(w.c cVar) {
            this.f5894a = cVar;
            return this;
        }
    }

    @Override // Z0.w
    public w.b b() {
        return this.f5893b;
    }

    @Override // Z0.w
    public w.c c() {
        return this.f5892a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            w.c cVar = this.f5892a;
            if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
                w.b bVar = this.f5893b;
                if (bVar != null ? bVar.equals(wVar.b()) : wVar.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        w.c cVar = this.f5892a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        w.b bVar = this.f5893b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f5892a + ", mobileSubtype=" + this.f5893b + "}";
    }

    public m(w.c cVar, w.b bVar) {
        this.f5892a = cVar;
        this.f5893b = bVar;
    }
}
