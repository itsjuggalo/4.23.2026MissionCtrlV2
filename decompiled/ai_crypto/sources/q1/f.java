package q1;

import q1.p;

/* JADX INFO: loaded from: classes.dex */
public final class f extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f22189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.b f22190b;

    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s f22191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p.b f22192b;

        @Override // q1.p.a
        public p a() {
            return new f(this.f22191a, this.f22192b);
        }

        @Override // q1.p.a
        public p.a b(s sVar) {
            this.f22191a = sVar;
            return this;
        }

        @Override // q1.p.a
        public p.a c(p.b bVar) {
            this.f22192b = bVar;
            return this;
        }
    }

    @Override // q1.p
    public s b() {
        return this.f22189a;
    }

    @Override // q1.p
    public p.b c() {
        return this.f22190b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        s sVar = this.f22189a;
        if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
            p.b bVar = this.f22190b;
            if (bVar == null) {
                if (pVar.c() == null) {
                    return true;
                }
            } else if (bVar.equals(pVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        s sVar = this.f22189a;
        int iHashCode = ((sVar == null ? 0 : sVar.hashCode()) ^ 1000003) * 1000003;
        p.b bVar = this.f22190b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f22189a + ", productIdOrigin=" + this.f22190b + "}";
    }

    public f(s sVar, p.b bVar) {
        this.f22189a = sVar;
        this.f22190b = bVar;
    }
}
