package H3;

import G3.r;
import K3.AbstractC0612b;
import Q2.s;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f {
    public c(G3.k kVar, m mVar) {
        super(kVar, mVar);
    }

    @Override // H3.f
    public d a(r rVar, d dVar, s sVar) {
        n(rVar);
        if (!h().e(rVar)) {
            return dVar;
        }
        rVar.n(rVar.l()).v();
        return null;
    }

    @Override // H3.f
    public void b(r rVar, i iVar) {
        n(rVar);
        AbstractC0612b.d(iVar.a().isEmpty(), "Transform results received by DeleteMutation.", new Object[0]);
        rVar.n(iVar.b()).u();
    }

    @Override // H3.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return i((c) obj);
    }

    public int hashCode() {
        return j();
    }

    public String toString() {
        return "DeleteMutation{" + k() + "}";
    }
}
