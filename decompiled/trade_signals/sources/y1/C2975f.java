package y1;

import y1.p;

/* JADX INFO: renamed from: y1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2975f extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f24342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.b f24343b;

    /* JADX INFO: renamed from: y1.f$b */
    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s f24344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p.b f24345b;

        @Override // y1.p.a
        public p a() {
            return new C2975f(this.f24344a, this.f24345b);
        }

        @Override // y1.p.a
        public p.a b(s sVar) {
            this.f24344a = sVar;
            return this;
        }

        @Override // y1.p.a
        public p.a c(p.b bVar) {
            this.f24345b = bVar;
            return this;
        }
    }

    public C2975f(s sVar, p.b bVar) {
        this.f24342a = sVar;
        this.f24343b = bVar;
    }

    @Override // y1.p
    public s b() {
        return this.f24342a;
    }

    @Override // y1.p
    public p.b c() {
        return this.f24343b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        s sVar = this.f24342a;
        if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
            p.b bVar = this.f24343b;
            p.b bVarC = pVar.c();
            if (bVar == null) {
                if (bVarC == null) {
                    return true;
                }
            } else if (bVar.equals(bVarC)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        s sVar = this.f24342a;
        int iHashCode = ((sVar == null ? 0 : sVar.hashCode()) ^ 1000003) * 1000003;
        p.b bVar = this.f24343b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f24342a + ", productIdOrigin=" + this.f24343b + "}";
    }
}
