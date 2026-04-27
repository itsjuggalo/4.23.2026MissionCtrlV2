package F3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class U implements InterfaceC0480b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap f2081a = new TreeMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2082b = new HashMap();

    @Override // F3.InterfaceC0480b
    public Map a(SortedSet sortedSet) {
        HashMap map = new HashMap();
        Iterator it = sortedSet.iterator();
        while (it.hasNext()) {
            G3.k kVar = (G3.k) it.next();
            H3.k kVar2 = (H3.k) this.f2081a.get(kVar);
            if (kVar2 != null) {
                map.put(kVar, kVar2);
            }
        }
        return map;
    }

    @Override // F3.InterfaceC0480b
    public Map b(G3.t tVar, int i7) {
        HashMap map = new HashMap();
        int iQ = tVar.q() + 1;
        for (H3.k kVar : this.f2081a.tailMap(G3.k.j((G3.t) tVar.b(""))).values()) {
            G3.k kVarB = kVar.b();
            if (!tVar.p(kVarB.o())) {
                break;
            }
            if (kVarB.o().q() == iQ && kVar.c() > i7) {
                map.put(kVar.b(), kVar);
            }
        }
        return map;
    }

    @Override // F3.InterfaceC0480b
    public H3.k c(G3.k kVar) {
        return (H3.k) this.f2081a.get(kVar);
    }

    @Override // F3.InterfaceC0480b
    public void d(int i7) {
        if (this.f2082b.containsKey(Integer.valueOf(i7))) {
            Set set = (Set) this.f2082b.get(Integer.valueOf(i7));
            this.f2082b.remove(Integer.valueOf(i7));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                this.f2081a.remove((G3.k) it.next());
            }
        }
    }

    @Override // F3.InterfaceC0480b
    public void e(int i7, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            g(i7, (H3.f) K3.z.d((H3.f) entry.getValue(), "null value for key: %s", entry.getKey()));
        }
    }

    @Override // F3.InterfaceC0480b
    public Map f(String str, int i7, int i8) {
        TreeMap treeMap = new TreeMap();
        for (H3.k kVar : this.f2081a.values()) {
            if (kVar.b().l().equals(str) && kVar.c() > i7) {
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
            if (map2.size() >= i8) {
                break;
            }
        }
        return map2;
    }

    public final void g(int i7, H3.f fVar) {
        H3.k kVar = (H3.k) this.f2081a.get(fVar.g());
        if (kVar != null) {
            ((Set) this.f2082b.get(Integer.valueOf(kVar.c()))).remove(fVar.g());
        }
        this.f2081a.put(fVar.g(), H3.k.a(i7, fVar));
        if (this.f2082b.get(Integer.valueOf(i7)) == null) {
            this.f2082b.put(Integer.valueOf(i7), new HashSet());
        }
        ((Set) this.f2082b.get(Integer.valueOf(i7))).add(fVar.g());
    }
}
