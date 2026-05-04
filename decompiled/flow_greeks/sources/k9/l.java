package k9;

import j9.r;
import j9.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f14791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f14792e;

    public l(j9.k kVar, s sVar, d dVar, m mVar) {
        this(kVar, sVar, dVar, mVar, new ArrayList());
    }

    @Override // k9.f
    public d a(r rVar, d dVar, a7.s sVar) {
        n(rVar);
        if (!h().e(rVar)) {
            return dVar;
        }
        Map mapL = l(sVar, rVar);
        Map mapP = p();
        s data = rVar.getData();
        data.m(mapP);
        data.m(mapL);
        rVar.l(rVar.k(), rVar.getData()).u();
        if (dVar == null) {
            return null;
        }
        HashSet hashSet = new HashSet(dVar.c());
        hashSet.addAll(this.f14792e.c());
        hashSet.addAll(o());
        return d.b(hashSet);
    }

    @Override // k9.f
    public void b(r rVar, i iVar) {
        n(rVar);
        if (!h().e(rVar)) {
            rVar.n(iVar.b());
            return;
        }
        Map mapM = m(rVar, iVar.a());
        s data = rVar.getData();
        data.m(p());
        data.m(mapM);
        rVar.l(iVar.b(), rVar.getData()).t();
    }

    @Override // k9.f
    public d e() {
        return this.f14792e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (i(lVar) && this.f14791d.equals(lVar.f14791d) && f().equals(lVar.f())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (j() * 31) + this.f14791d.hashCode();
    }

    public final List o() {
        ArrayList arrayList = new ArrayList();
        Iterator it = f().iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).a());
        }
        return arrayList;
    }

    public final Map p() {
        HashMap map = new HashMap();
        for (j9.q qVar : this.f14792e.c()) {
            if (!qVar.isEmpty()) {
                map.put(qVar, this.f14791d.i(qVar));
            }
        }
        return map;
    }

    public s q() {
        return this.f14791d;
    }

    public String toString() {
        return "PatchMutation{" + k() + ", mask=" + this.f14792e + ", value=" + this.f14791d + "}";
    }

    public l(j9.k kVar, s sVar, d dVar, m mVar, List list) {
        super(kVar, mVar, list);
        this.f14791d = sVar;
        this.f14792e = dVar;
    }
}
