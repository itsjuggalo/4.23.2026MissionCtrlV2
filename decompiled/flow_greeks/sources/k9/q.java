package k9;

import a7.s;
import j9.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends f {
    public q(j9.k kVar, m mVar) {
        super(kVar, mVar);
    }

    @Override // k9.f
    public d a(r rVar, d dVar, s sVar) {
        throw n9.b.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // k9.f
    public void b(r rVar, i iVar) {
        throw n9.b.a("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // k9.f
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
