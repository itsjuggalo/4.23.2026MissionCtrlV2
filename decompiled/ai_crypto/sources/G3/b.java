package G3;

import G3.p;

/* JADX INFO: loaded from: classes.dex */
public final class b extends p.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f2428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f2429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2430e;

    public b(v vVar, k kVar, int i7) {
        if (vVar == null) {
            throw new NullPointerException("Null readTime");
        }
        this.f2428c = vVar;
        if (kVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f2429d = kVar;
        this.f2430e = i7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p.a)) {
            return false;
        }
        p.a aVar = (p.a) obj;
        return this.f2428c.equals(aVar.l()) && this.f2429d.equals(aVar.j()) && this.f2430e == aVar.k();
    }

    public int hashCode() {
        return ((((this.f2428c.hashCode() ^ 1000003) * 1000003) ^ this.f2429d.hashCode()) * 1000003) ^ this.f2430e;
    }

    @Override // G3.p.a
    public k j() {
        return this.f2429d;
    }

    @Override // G3.p.a
    public int k() {
        return this.f2430e;
    }

    @Override // G3.p.a
    public v l() {
        return this.f2428c;
    }

    public String toString() {
        return "IndexOffset{readTime=" + this.f2428c + ", documentKey=" + this.f2429d + ", largestBatchId=" + this.f2430e + "}";
    }
}
