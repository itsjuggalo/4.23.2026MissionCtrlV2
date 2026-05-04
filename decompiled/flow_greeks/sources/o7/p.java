package o7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o7.c f17582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f17583b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f17584c = new HashSet();

        public b(o7.c cVar) {
            this.f17582a = cVar;
        }

        public void a(b bVar) {
            this.f17583b.add(bVar);
        }

        public void b(b bVar) {
            this.f17584c.add(bVar);
        }

        public o7.c c() {
            return this.f17582a;
        }

        public Set d() {
            return this.f17583b;
        }

        public boolean e() {
            return this.f17583b.isEmpty();
        }

        public boolean f() {
            return this.f17584c.isEmpty();
        }

        public void g(b bVar) {
            this.f17584c.remove(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0 f17585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17586b;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f17585a.equals(this.f17585a) && cVar.f17586b == this.f17586b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.f17585a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f17586b).hashCode();
        }

        public c(e0 e0Var, boolean z10) {
            this.f17585a = e0Var;
            this.f17586b = z10;
        }
    }

    public static void a(List list) {
        Set<b> setC = c(list);
        Set setB = b(setC);
        int i10 = 0;
        while (!setB.isEmpty()) {
            b bVar = (b) setB.iterator().next();
            setB.remove(bVar);
            i10++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    setB.add(bVar2);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 : setC) {
            if (!bVar3.f() && !bVar3.e()) {
                arrayList.add(bVar3.c());
            }
        }
        throw new r(arrayList);
    }

    public static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set c(List list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (q qVar : bVar.c().g()) {
                            if (qVar.e() && (set = (Set) map.get(new c(qVar.c(), qVar.g()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            o7.c cVar = (o7.c) it.next();
            b bVar3 = new b(cVar);
            for (e0 e0Var : cVar.j()) {
                c cVar2 = new c(e0Var, !cVar.p());
                if (!map.containsKey(cVar2)) {
                    map.put(cVar2, new HashSet());
                }
                Set set2 = (Set) map.get(cVar2);
                if (!set2.isEmpty() && !cVar2.f17586b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", e0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
