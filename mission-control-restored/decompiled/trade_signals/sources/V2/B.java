package V2;

import V2.G;

/* JADX INFO: loaded from: classes.dex */
public final class B extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G.a f8497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G.c f8498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G.b f8499c;

    public B(G.a aVar, G.c cVar, G.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f8497a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f8498b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f8499c = bVar;
    }

    @Override // V2.G
    public G.a a() {
        return this.f8497a;
    }

    @Override // V2.G
    public G.b c() {
        return this.f8499c;
    }

    @Override // V2.G
    public G.c d() {
        return this.f8498b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        G g8 = (G) obj;
        return this.f8497a.equals(g8.a()) && this.f8498b.equals(g8.d()) && this.f8499c.equals(g8.c());
    }

    public int hashCode() {
        return ((((this.f8497a.hashCode() ^ 1000003) * 1000003) ^ this.f8498b.hashCode()) * 1000003) ^ this.f8499c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f8497a + ", osData=" + this.f8498b + ", deviceData=" + this.f8499c + "}";
    }
}
