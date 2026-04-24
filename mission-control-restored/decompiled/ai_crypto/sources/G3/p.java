package G3;

import G3.p;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f2447a = b.a(0, a.f2449a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator f2448b = new Comparator() { // from class: G3.n
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return p.i((p) obj, (p) obj2);
        }
    };

    public static abstract class a implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2449a = c(v.f2475b, k.c(), -1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Comparator f2450b = new Comparator() { // from class: G3.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p.a.m((r) obj, (r) obj2);
            }
        };

        public static a c(v vVar, k kVar, int i7) {
            return new G3.b(vVar, kVar, i7);
        }

        public static a h(v vVar, int i7) {
            long jH = vVar.b().h();
            int iC = vVar.b().c() + 1;
            return c(new v(((double) iC) == 1.0E9d ? new Q2.s(jH + 1, 0) : new Q2.s(jH, iC)), k.c(), i7);
        }

        public static a i(h hVar) {
            return c(hVar.g(), hVar.getKey(), -1);
        }

        public static /* synthetic */ int m(r rVar, r rVar2) {
            return i(rVar).compareTo(i(rVar2));
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int iCompareTo = l().compareTo(aVar.l());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = j().compareTo(aVar.j());
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(k(), aVar.k());
        }

        public abstract k j();

        public abstract int k();

        public abstract v l();
    }

    public static abstract class b {
        public static b a(long j7, a aVar) {
            return new G3.c(j7, aVar);
        }

        public static b b(long j7, v vVar, k kVar, int i7) {
            return a(j7, a.c(vVar, kVar, i7));
        }

        public abstract a c();

        public abstract long d();
    }

    public static abstract class c implements Comparable {

        public enum a {
            ASCENDING,
            DESCENDING,
            CONTAINS
        }

        public static c b(q qVar, a aVar) {
            return new d(qVar, aVar);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int iCompareTo = c().compareTo(cVar.c());
            return iCompareTo != 0 ? iCompareTo : h().compareTo(cVar.h());
        }

        public abstract q c();

        public abstract a h();
    }

    public static p b(int i7, String str, List list, b bVar) {
        return new G3.a(i7, str, list, bVar);
    }

    public static /* synthetic */ int i(p pVar, p pVar2) {
        int iCompareTo = pVar.d().compareTo(pVar2.d());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Iterator it = pVar.h().iterator();
        Iterator it2 = pVar2.h().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo2 = ((c) it.next()).compareTo((c) it2.next());
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        return Boolean.compare(it.hasNext(), it2.hasNext());
    }

    public c c() {
        for (c cVar : h()) {
            if (cVar.h().equals(c.a.CONTAINS)) {
                return cVar;
            }
        }
        return null;
    }

    public abstract String d();

    public List e() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : h()) {
            if (!cVar.h().equals(c.a.CONTAINS)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public abstract int f();

    public abstract b g();

    public abstract List h();
}
