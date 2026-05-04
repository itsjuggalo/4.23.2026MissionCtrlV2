package k9;

import j9.r;
import j9.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f14797d;

    public o(j9.k kVar, s sVar, m mVar) {
        this(kVar, sVar, mVar, new ArrayList());
    }

    @Override // k9.f
    public d a(r rVar, d dVar, a7.s sVar) {
        n(rVar);
        if (!h().e(rVar)) {
            return dVar;
        }
        Map mapL = l(sVar, rVar);
        s sVarClone = this.f14797d.clone();
        sVarClone.m(mapL);
        rVar.l(rVar.k(), sVarClone).u();
        return null;
    }

    @Override // k9.f
    public void b(r rVar, i iVar) {
        n(rVar);
        s sVarClone = this.f14797d.clone();
        sVarClone.m(m(rVar, iVar.a()));
        rVar.l(iVar.b(), sVarClone).t();
    }

    @Override // k9.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (i(oVar) && this.f14797d.equals(oVar.f14797d) && f().equals(oVar.f())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (j() * 31) + this.f14797d.hashCode();
    }

    public s o() {
        return this.f14797d;
    }

    public String toString() {
        return "SetMutation{" + k() + ", value=" + this.f14797d + "}";
    }

    public o(j9.k kVar, s sVar, m mVar, List list) {
        super(kVar, mVar, list);
        this.f14797d = sVar;
    }
}
