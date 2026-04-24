package Z0;

import Z0.p;

/* JADX INFO: loaded from: classes.dex */
public final class f extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f5847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.b f5848b;

    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s f5849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p.b f5850b;

        @Override // Z0.p.a
        public p a() {
            return new f(this.f5849a, this.f5850b);
        }

        @Override // Z0.p.a
        public p.a b(s sVar) {
            this.f5849a = sVar;
            return this;
        }

        @Override // Z0.p.a
        public p.a c(p.b bVar) {
            this.f5850b = bVar;
            return this;
        }
    }

    @Override // Z0.p
    public s b() {
        return this.f5847a;
    }

    @Override // Z0.p
    public p.b c() {
        return this.f5848b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            s sVar = this.f5847a;
            if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
                p.b bVar = this.f5848b;
                if (bVar != null ? bVar.equals(pVar.c()) : pVar.c() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        s sVar = this.f5847a;
        int iHashCode = ((sVar == null ? 0 : sVar.hashCode()) ^ 1000003) * 1000003;
        p.b bVar = this.f5848b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f5847a + ", productIdOrigin=" + this.f5848b + "}";
    }

    public f(s sVar, p.b bVar) {
        this.f5847a = sVar;
        this.f5848b = bVar;
    }
}
