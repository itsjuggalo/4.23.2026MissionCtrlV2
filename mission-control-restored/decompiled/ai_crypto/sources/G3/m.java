package G3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f2445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r3.e f2446b;

    public m(r3.c cVar, r3.e eVar) {
        this.f2445a = cVar;
        this.f2446b = eVar;
    }

    public static m c(final Comparator comparator) {
        return new m(i.a(), new r3.e(Collections.emptyList(), new Comparator() { // from class: G3.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.l(comparator, (h) obj, (h) obj2);
            }
        }));
    }

    public static /* synthetic */ int l(Comparator comparator, h hVar, h hVar2) {
        int iCompare = comparator.compare(hVar, hVar2);
        return iCompare == 0 ? h.f2439a.compare(hVar, hVar2) : iCompare;
    }

    public m b(h hVar) {
        m mVarM = m(hVar.getKey());
        return new m(mVarM.f2445a.j(hVar.getKey(), hVar), mVarM.f2446b.c(hVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (size() != mVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = mVar.iterator();
        while (it.hasNext()) {
            if (!((h) it.next()).equals((h) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public h g(k kVar) {
        return (h) this.f2445a.b(kVar);
    }

    public h h() {
        return (h) this.f2446b.b();
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            iHashCode = (((iHashCode * 31) + hVar.getKey().hashCode()) * 31) + hVar.getData().hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.f2445a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f2446b.iterator();
    }

    public h j() {
        return (h) this.f2446b.a();
    }

    public int k(k kVar) {
        h hVar = (h) this.f2445a.b(kVar);
        if (hVar == null) {
            return -1;
        }
        return this.f2446b.indexOf(hVar);
    }

    public m m(k kVar) {
        h hVar = (h) this.f2445a.b(kVar);
        return hVar == null ? this : new m(this.f2445a.l(kVar), this.f2446b.h(hVar));
    }

    public int size() {
        return this.f2445a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (z7) {
                z7 = false;
            } else {
                sb.append(", ");
            }
            sb.append(hVar);
        }
        sb.append("]");
        return sb.toString();
    }
}
