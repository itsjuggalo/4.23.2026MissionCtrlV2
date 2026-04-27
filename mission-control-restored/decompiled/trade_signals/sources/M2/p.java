package M2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0700c f5326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f5327b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f5328c = new HashSet();

        public b(C0700c c0700c) {
            this.f5326a = c0700c;
        }

        public void a(b bVar) {
            this.f5327b.add(bVar);
        }

        public void b(b bVar) {
            this.f5328c.add(bVar);
        }

        public C0700c c() {
            return this.f5326a;
        }

        public Set d() {
            return this.f5327b;
        }

        public boolean e() {
            return this.f5327b.isEmpty();
        }

        public boolean f() {
            return this.f5328c.isEmpty();
        }

        public void g(b bVar) {
            this.f5328c.remove(bVar);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f5329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5330b;

        public c(E e8, boolean z7) {
            this.f5329a = e8;
            this.f5330b = z7;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f5329a.equals(this.f5329a) && cVar.f5330b == this.f5330b;
        }

        public int hashCode() {
            return ((this.f5329a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f5330b).hashCode();
        }
    }

    public static void a(List list) {
        Set<b> setC = c(list);
        Set setB = b(setC);
        int i8 = 0;
        while (!setB.isEmpty()) {
            b bVar = (b) setB.iterator().next();
            setB.remove(bVar);
            i8++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    setB.add(bVar2);
                }
            }
        }
        if (i8 == list.size()) {
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
            C0700c c0700c = (C0700c) it.next();
            b bVar3 = new b(c0700c);
            for (E e8 : c0700c.j()) {
                c cVar = new c(e8, !c0700c.p());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f5330b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", e8));
                }
                set2.add(bVar3);
            }
        }
    }
}
