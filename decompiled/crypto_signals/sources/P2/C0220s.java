package P2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: renamed from: P2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0220s implements InterfaceC0203a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap f2483a = new TreeMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2484b = new HashMap();

    @Override // P2.InterfaceC0203a
    public final void b(int i, HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            R2.h hVar = (R2.h) entry.getValue();
            Object[] objArr = {entry.getKey()};
            if (hVar == null) {
                throw new NullPointerException(String.format(Locale.US, "null value for key: %s", objArr));
            }
            TreeMap treeMap = this.f2483a;
            Q2.h hVar2 = hVar.f2780a;
            R2.d dVar = (R2.d) treeMap.get(hVar2);
            HashMap map2 = this.f2484b;
            if (dVar != null) {
                ((Set) map2.get(Integer.valueOf(dVar.f2774a))).remove(hVar2);
            }
            treeMap.put(hVar2, new R2.d(i, hVar));
            if (map2.get(Integer.valueOf(i)) == null) {
                map2.put(Integer.valueOf(i), new HashSet());
            }
            ((Set) map2.get(Integer.valueOf(i))).add(hVar2);
        }
    }

    @Override // P2.InterfaceC0203a
    public final HashMap h(TreeSet treeSet) {
        HashMap map = new HashMap();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            Q2.h hVar = (Q2.h) it.next();
            R2.d dVar = (R2.d) this.f2483a.get(hVar);
            if (dVar != null) {
                map.put(hVar, dVar);
            }
        }
        return map;
    }

    @Override // P2.InterfaceC0203a
    public final HashMap k(int i, int i6, String str) {
        int i7;
        TreeMap treeMap = new TreeMap();
        for (R2.d dVar : this.f2483a.values()) {
            if (dVar.f2775b.f2780a.f2674a.g(r3.f2668a.size() - 2).equals(str) && (i7 = dVar.f2774a) > i) {
                Map map = (Map) treeMap.get(Integer.valueOf(i7));
                if (map == null) {
                    map = new HashMap();
                    treeMap.put(Integer.valueOf(i7), map);
                }
                map.put(dVar.f2775b.f2780a, dVar);
            }
        }
        HashMap map2 = new HashMap();
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            map2.putAll((Map) it.next());
            if (map2.size() >= i6) {
                break;
            }
        }
        return map2;
    }

    @Override // P2.InterfaceC0203a
    public final HashMap p(Q2.m mVar, int i) {
        HashMap map = new HashMap();
        int size = mVar.f2668a.size() + 1;
        for (R2.d dVar : this.f2483a.tailMap(new Q2.h((Q2.m) mVar.b(""))).values()) {
            Q2.h hVar = dVar.f2775b.f2780a;
            if (!mVar.i(hVar.f2674a)) {
                break;
            }
            if (hVar.f2674a.f2668a.size() == size && dVar.f2774a > i) {
                map.put(dVar.f2775b.f2780a, dVar);
            }
        }
        return map;
    }

    @Override // P2.InterfaceC0203a
    public final void s(int i) {
        HashMap map = this.f2484b;
        if (map.containsKey(Integer.valueOf(i))) {
            Set set = (Set) map.get(Integer.valueOf(i));
            map.remove(Integer.valueOf(i));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                this.f2483a.remove((Q2.h) it.next());
            }
        }
    }

    @Override // P2.InterfaceC0203a
    public final R2.d v(Q2.h hVar) {
        return (R2.d) this.f2483a.get(hVar);
    }
}
