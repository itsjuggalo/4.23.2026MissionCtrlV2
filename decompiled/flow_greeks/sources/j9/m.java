package j9;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g8.c f14246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g8.e f14247b;

    public m(g8.c cVar, g8.e eVar) {
        this.f14246a = cVar;
        this.f14247b = eVar;
    }

    public static /* synthetic */ int a(Comparator comparator, h hVar, h hVar2) {
        int iCompare = comparator.compare(hVar, hVar2);
        return iCompare == 0 ? h.f14240a.compare(hVar, hVar2) : iCompare;
    }

    public static m d(final Comparator comparator) {
        return new m(i.a(), new g8.e(Collections.EMPTY_LIST, new Comparator() { // from class: j9.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.a(comparator, (h) obj, (h) obj2);
            }
        }));
    }

    public m c(h hVar) {
        m mVarQ = q(hVar.getKey());
        return new m(mVarQ.f14246a.q(hVar.getKey(), hVar), mVarQ.f14247b.e(hVar));
    }

    public h e(k kVar) {
        return (h) this.f14246a.c(kVar);
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

    public h f() {
        return (h) this.f14247b.c();
    }

    public h g() {
        return (h) this.f14247b.a();
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
        return this.f14246a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f14247b.iterator();
    }

    public int p(k kVar) {
        h hVar = (h) this.f14246a.c(kVar);
        if (hVar == null) {
            return -1;
        }
        return this.f14247b.indexOf(hVar);
    }

    public m q(k kVar) {
        h hVar = (h) this.f14246a.c(kVar);
        return hVar == null ? this : new m(this.f14246a.s(kVar), this.f14247b.g(hVar));
    }

    public int size() {
        return this.f14246a.size();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator it = iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(hVar);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
