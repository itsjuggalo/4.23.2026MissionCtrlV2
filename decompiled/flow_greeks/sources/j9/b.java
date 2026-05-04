package j9;

import j9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends p.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f14229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f14230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14231e;

    public b(v vVar, k kVar, int i10) {
        if (vVar == null) {
            throw new NullPointerException("Null readTime");
        }
        this.f14229c = vVar;
        if (kVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f14230d = kVar;
        this.f14231e = i10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p.a) {
            p.a aVar = (p.a) obj;
            if (this.f14229c.equals(aVar.m()) && this.f14230d.equals(aVar.k()) && this.f14231e == aVar.l()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f14229c.hashCode() ^ 1000003) * 1000003) ^ this.f14230d.hashCode()) * 1000003) ^ this.f14231e;
    }

    @Override // j9.p.a
    public k k() {
        return this.f14230d;
    }

    @Override // j9.p.a
    public int l() {
        return this.f14231e;
    }

    @Override // j9.p.a
    public v m() {
        return this.f14229c;
    }

    public String toString() {
        return "IndexOffset{readTime=" + this.f14229c + ", documentKey=" + this.f14230d + ", largestBatchId=" + this.f14231e + "}";
    }
}
