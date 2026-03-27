package q1;

import q1.w;

/* JADX INFO: loaded from: classes.dex */
public final class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f22234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.b f22235b;

    public static final class b extends w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w.c f22236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.b f22237b;

        @Override // q1.w.a
        public w a() {
            return new m(this.f22236a, this.f22237b);
        }

        @Override // q1.w.a
        public w.a b(w.b bVar) {
            this.f22237b = bVar;
            return this;
        }

        @Override // q1.w.a
        public w.a c(w.c cVar) {
            this.f22236a = cVar;
            return this;
        }
    }

    @Override // q1.w
    public w.b b() {
        return this.f22235b;
    }

    @Override // q1.w
    public w.c c() {
        return this.f22234a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        w.c cVar = this.f22234a;
        if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
            w.b bVar = this.f22235b;
            if (bVar == null) {
                if (wVar.b() == null) {
                    return true;
                }
            } else if (bVar.equals(wVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        w.c cVar = this.f22234a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        w.b bVar = this.f22235b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f22234a + ", mobileSubtype=" + this.f22235b + "}";
    }

    public m(w.c cVar, w.b bVar) {
        this.f22234a = cVar;
        this.f22235b = bVar;
    }
}
