package k4;

import k4.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f14603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.b f14604b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s f14605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p.b f14606b;

        @Override // k4.p.a
        public p a() {
            return new f(this.f14605a, this.f14606b);
        }

        @Override // k4.p.a
        public p.a b(s sVar) {
            this.f14605a = sVar;
            return this;
        }

        @Override // k4.p.a
        public p.a c(p.b bVar) {
            this.f14606b = bVar;
            return this;
        }
    }

    @Override // k4.p
    public s b() {
        return this.f14603a;
    }

    @Override // k4.p
    public p.b c() {
        return this.f14604b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            s sVar = this.f14603a;
            if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
                p.b bVar = this.f14604b;
                if (bVar != null ? bVar.equals(pVar.c()) : pVar.c() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        s sVar = this.f14603a;
        int iHashCode = ((sVar == null ? 0 : sVar.hashCode()) ^ 1000003) * 1000003;
        p.b bVar = this.f14604b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f14603a + ", productIdOrigin=" + this.f14604b + "}";
    }

    public f(s sVar, p.b bVar) {
        this.f14603a = sVar;
        this.f14604b = bVar;
    }
}
