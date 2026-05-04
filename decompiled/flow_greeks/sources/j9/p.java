package j9;

import j9.p;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f14248a = b.a(0, a.f14250a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator f14249b = new Comparator() { // from class: j9.n
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return p.a((p) obj, (p) obj2);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14250a = c(v.f14278b, k.c(), -1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Comparator f14251b = new Comparator() { // from class: j9.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p.a.i((r) obj).compareTo(p.a.i((r) obj2));
            }
        };

        public static a c(v vVar, k kVar, int i10) {
            return new j9.b(vVar, kVar, i10);
        }

        public static a h(v vVar, int i10) {
            long jH = vVar.b().h();
            int iB = vVar.b().b() + 1;
            return c(new v(((double) iB) == 1.0E9d ? new a7.s(jH + 1, 0) : new a7.s(jH, iB)), k.c(), i10);
        }

        public static a i(h hVar) {
            return c(hVar.f(), hVar.getKey(), -1);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int iCompareTo = m().compareTo(aVar.m());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = k().compareTo(aVar.k());
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(l(), aVar.l());
        }

        public abstract k k();

        public abstract int l();

        public abstract v m();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {
        public static b a(long j10, a aVar) {
            return new j9.c(j10, aVar);
        }

        public static b b(long j10, v vVar, k kVar, int i10) {
            return a(j10, a.c(vVar, kVar, i10));
        }

        public abstract a c();

        public abstract long d();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c implements Comparable {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    public static /* synthetic */ int a(p pVar, p pVar2) {
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

    public static p b(int i10, String str, List list, b bVar) {
        return new j9.a(i10, str, list, bVar);
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
