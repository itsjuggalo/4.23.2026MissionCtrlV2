package H3;

import G3.r;
import K3.AbstractC0612b;
import Q2.s;

/* JADX INFO: loaded from: classes.dex */
public final class q extends f {
    public q(G3.k kVar, m mVar) {
        super(kVar, mVar);
    }

    @Override // H3.f
    public d a(r rVar, d dVar, s sVar) {
        throw AbstractC0612b.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // H3.f
    public void b(r rVar, i iVar) {
        throw AbstractC0612b.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // H3.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return i((q) obj);
    }

    public int hashCode() {
        return j();
    }

    public String toString() {
        return "VerifyMutation{" + k() + "}";
    }
}
