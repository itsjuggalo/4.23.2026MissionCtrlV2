package x7;

import x7.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0.a f24427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0.c f24428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0.b f24429c;

    public b0(g0.a aVar, g0.c cVar, g0.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f24427a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f24428b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f24429c = bVar;
    }

    @Override // x7.g0
    public g0.a a() {
        return this.f24427a;
    }

    @Override // x7.g0
    public g0.b c() {
        return this.f24429c;
    }

    @Override // x7.g0
    public g0.c d() {
        return this.f24428b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            if (this.f24427a.equals(g0Var.a()) && this.f24428b.equals(g0Var.d()) && this.f24429c.equals(g0Var.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f24427a.hashCode() ^ 1000003) * 1000003) ^ this.f24428b.hashCode()) * 1000003) ^ this.f24429c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f24427a + ", osData=" + this.f24428b + ", deviceData=" + this.f24429c + "}";
    }
}
