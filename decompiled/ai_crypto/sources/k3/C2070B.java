package k3;

import k3.AbstractC2075G;

/* JADX INFO: renamed from: k3.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2070B extends AbstractC2075G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2075G.a f17576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2075G.c f17577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2075G.b f17578c;

    public C2070B(AbstractC2075G.a aVar, AbstractC2075G.c cVar, AbstractC2075G.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f17576a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f17577b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f17578c = bVar;
    }

    @Override // k3.AbstractC2075G
    public AbstractC2075G.a a() {
        return this.f17576a;
    }

    @Override // k3.AbstractC2075G
    public AbstractC2075G.b c() {
        return this.f17578c;
    }

    @Override // k3.AbstractC2075G
    public AbstractC2075G.c d() {
        return this.f17577b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2075G)) {
            return false;
        }
        AbstractC2075G abstractC2075G = (AbstractC2075G) obj;
        return this.f17576a.equals(abstractC2075G.a()) && this.f17577b.equals(abstractC2075G.d()) && this.f17578c.equals(abstractC2075G.c());
    }

    public int hashCode() {
        return ((((this.f17576a.hashCode() ^ 1000003) * 1000003) ^ this.f17577b.hashCode()) * 1000003) ^ this.f17578c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f17576a + ", osData=" + this.f17577b + ", deviceData=" + this.f17578c + "}";
    }
}
