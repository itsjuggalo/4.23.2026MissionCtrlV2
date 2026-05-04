package i9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap f12161a = new TreeMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12162b = new HashMap();

    @Override // i9.b
    public Map a(SortedSet sortedSet) {
        HashMap map = new HashMap();
        Iterator it = sortedSet.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            k9.k kVar2 = (k9.k) this.f12161a.get(kVar);
            if (kVar2 != null) {
                map.put(kVar, kVar2);
            }
        }
        return map;
    }

    @Override // i9.b
    public k9.k b(j9.k kVar) {
        return (k9.k) this.f12161a.get(kVar);
    }

    @Override // i9.b
    public Map c(j9.t tVar, int i10) {
        HashMap map = new HashMap();
        int iU = tVar.u() + 1;
        for (k9.k kVar : this.f12161a.tailMap(j9.k.k((j9.t) tVar.b(""))).values()) {
            j9.k kVarB = kVar.b();
            if (!tVar.s(kVarB.s())) {
                break;
            }
            if (kVarB.s().u() == iU && kVar.c() > i10) {
                map.put(kVar.b(), kVar);
            }
        }
        return map;
    }

    @Override // i9.b
    public void d(int i10) {
        if (this.f12162b.containsKey(Integer.valueOf(i10))) {
            Set set = (Set) this.f12162b.get(Integer.valueOf(i10));
            this.f12162b.remove(Integer.valueOf(i10));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                this.f12161a.remove((j9.k) it.next());
            }
        }
    }

    @Override // i9.b
    public void e(int i10, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            g(i10, (k9.f) n9.x.d((k9.f) entry.getValue(), "null value for key: %s", entry.getKey()));
        }
    }

    @Override // i9.b
    public Map f(String str, int i10, int i11) {
        TreeMap treeMap = new TreeMap();
        for (k9.k kVar : this.f12161a.values()) {
            if (kVar.b().m().equals(str) && kVar.c() > i10) {
                Map map = (Map) treeMap.get(Integer.valueOf(kVar.c()));
                if (map == null) {
                    map = new HashMap();
                    treeMap.put(Integer.valueOf(kVar.c()), map);
                }
                map.put(kVar.b(), kVar);
            }
        }
        HashMap map2 = new HashMap();
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            map2.putAll((Map) it.next());
            if (map2.size() >= i11) {
                break;
            }
        }
        return map2;
    }

    public final void g(int i10, k9.f fVar) {
        k9.k kVar = (k9.k) this.f12161a.get(fVar.g());
        if (kVar != null) {
            ((Set) this.f12162b.get(Integer.valueOf(kVar.c()))).remove(fVar.g());
        }
        this.f12161a.put(fVar.g(), k9.k.a(i10, fVar));
        if (this.f12162b.get(Integer.valueOf(i10)) == null) {
            this.f12162b.put(Integer.valueOf(i10), new HashSet());
        }
        ((Set) this.f12162b.get(Integer.valueOf(i10))).add(fVar.g());
    }
}
