package i9;

import j9.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f12101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f12102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f12104d;

    public o(o1 o1Var, e1 e1Var, b bVar, m mVar) {
        this.f12101a = o1Var;
        this.f12102b = e1Var;
        this.f12103c = bVar;
        this.f12104d = mVar;
    }

    public final Map a(Map map, Map map2, Set set) {
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        for (j9.r rVar : map.values()) {
            k9.k kVar = (k9.k) map2.get(rVar.getKey());
            if (set.contains(rVar.getKey()) && (kVar == null || (kVar.d() instanceof k9.l))) {
                map3.put(rVar.getKey(), rVar);
            } else if (kVar != null) {
                map4.put(rVar.getKey(), kVar.d().e());
                kVar.d().a(rVar, kVar.d().e(), a7.s.i());
            } else {
                map4.put(rVar.getKey(), k9.d.f14772b);
            }
        }
        map4.putAll(n(map3));
        HashMap map5 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map5.put((j9.k) entry.getKey(), new g1((j9.h) entry.getValue(), (k9.d) map4.get(entry.getKey())));
        }
        return map5;
    }

    public final j9.r b(j9.k kVar, k9.k kVar2) {
        return (kVar2 == null || (kVar2.d() instanceof k9.l)) ? this.f12101a.f(kVar) : j9.r.q(kVar);
    }

    public j9.h c(j9.k kVar) {
        k9.k kVarB = this.f12103c.b(kVar);
        j9.r rVarB = b(kVar, kVarB);
        if (kVarB != null) {
            kVarB.d().a(rVarB, k9.d.f14772b, a7.s.i());
        }
        return rVarB;
    }

    public g8.c d(Iterable iterable) {
        return j(this.f12101a.b(iterable), new HashSet());
    }

    public final g8.c e(g9.b1 b1Var, p.a aVar, i1 i1Var) {
        n9.b.d(b1Var.n().isEmpty(), "Currently we only support collection group queries at the root.", new Object[0]);
        String strF = b1Var.f();
        g8.c cVarA = j9.i.a();
        Iterator it = this.f12104d.g(strF).iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : f(b1Var.a((j9.t) ((j9.t) it.next()).b(strF)), aVar, i1Var)) {
                cVarA = cVarA.q((j9.k) entry.getKey(), (j9.h) entry.getValue());
            }
        }
        return cVarA;
    }

    public final g8.c f(g9.b1 b1Var, p.a aVar, i1 i1Var) {
        Map mapC = this.f12103c.c(b1Var.n(), aVar.l());
        Map mapA = this.f12101a.a(b1Var, aVar, mapC.keySet(), i1Var);
        for (Map.Entry entry : mapC.entrySet()) {
            if (!mapA.containsKey(entry.getKey())) {
                mapA.put((j9.k) entry.getKey(), j9.r.q((j9.k) entry.getKey()));
            }
        }
        g8.c cVarA = j9.i.a();
        for (Map.Entry entry2 : mapA.entrySet()) {
            k9.k kVar = (k9.k) mapC.get(entry2.getKey());
            if (kVar != null) {
                kVar.d().a((j9.r) entry2.getValue(), k9.d.f14772b, a7.s.i());
            }
            if (b1Var.u((j9.h) entry2.getValue())) {
                cVarA = cVarA.q((j9.k) entry2.getKey(), (j9.h) entry2.getValue());
            }
        }
        return cVarA;
    }

    public final g8.c g(j9.t tVar) {
        g8.c cVarA = j9.i.a();
        j9.h hVarC = c(j9.k.k(tVar));
        return hVarC.b() ? cVarA.q(hVarC.getKey(), hVarC) : cVarA;
    }

    public g8.c h(g9.b1 b1Var, p.a aVar) {
        return i(b1Var, aVar, null);
    }

    public g8.c i(g9.b1 b1Var, p.a aVar, i1 i1Var) {
        return b1Var.r() ? g(b1Var.n()) : b1Var.q() ? e(b1Var, aVar, i1Var) : f(b1Var, aVar, i1Var);
    }

    public g8.c j(Map map, Set set) {
        HashMap map2 = new HashMap();
        m(map2, map.keySet());
        g8.c cVarA = j9.i.a();
        for (Map.Entry entry : a(map, map2, set).entrySet()) {
            cVarA = cVarA.q((j9.k) entry.getKey(), ((g1) entry.getValue()).a());
        }
        return cVarA;
    }

    public n k(String str, p.a aVar, int i10) {
        Map mapC = this.f12101a.c(str, aVar, i10);
        Map mapF = i10 - mapC.size() > 0 ? this.f12103c.f(str, aVar.l(), i10 - mapC.size()) : new HashMap();
        int iMax = -1;
        for (k9.k kVar : mapF.values()) {
            if (!mapC.containsKey(kVar.b())) {
                mapC.put(kVar.b(), b(kVar.b(), kVar));
            }
            iMax = Math.max(iMax, kVar.c());
        }
        m(mapF, mapC.keySet());
        return n.a(iMax, a(mapC, mapF, Collections.EMPTY_SET));
    }

    public Map l(Map map) {
        HashMap map2 = new HashMap();
        m(map2, map.keySet());
        return a(map, map2, new HashSet());
    }

    public final void m(Map map, Set set) {
        TreeSet treeSet = new TreeSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            if (!map.containsKey(kVar)) {
                treeSet.add(kVar);
            }
        }
        map.putAll(this.f12103c.a(treeSet));
    }

    public final Map n(Map map) {
        List<k9.g> listD = this.f12102b.d(map.keySet());
        HashMap map2 = new HashMap();
        TreeMap treeMap = new TreeMap();
        for (k9.g gVar : listD) {
            for (j9.k kVar : gVar.f()) {
                j9.r rVar = (j9.r) map.get(kVar);
                if (rVar != null) {
                    map2.put(kVar, gVar.b(rVar, map2.containsKey(kVar) ? (k9.d) map2.get(kVar) : k9.d.f14772b));
                    int iE = gVar.e();
                    if (!treeMap.containsKey(Integer.valueOf(iE))) {
                        treeMap.put(Integer.valueOf(iE), new HashSet());
                    }
                    ((Set) treeMap.get(Integer.valueOf(iE))).add(kVar);
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : treeMap.descendingMap().entrySet()) {
            HashMap map3 = new HashMap();
            for (j9.k kVar2 : (Set) entry.getValue()) {
                if (!hashSet.contains(kVar2)) {
                    k9.f fVarC = k9.f.c((j9.r) map.get(kVar2), (k9.d) map2.get(kVar2));
                    if (fVarC != null) {
                        map3.put(kVar2, fVarC);
                    }
                    hashSet.add(kVar2);
                }
            }
            this.f12103c.e(((Integer) entry.getKey()).intValue(), map3);
        }
        return map2;
    }

    public void o(Set set) {
        n(this.f12101a.b(set));
    }
}
