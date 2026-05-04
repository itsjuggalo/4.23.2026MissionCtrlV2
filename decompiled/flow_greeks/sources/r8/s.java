package r8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.l f19437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j8.l f19438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f19439c;

    public s(h8.o oVar) {
        List listA = oVar.a();
        this.f19437a = listA != null ? new j8.l(listA) : null;
        List listB = oVar.b();
        this.f19438b = listB != null ? new j8.l(listB) : null;
        this.f19439c = o.a(oVar.c());
    }

    public n a(n nVar) {
        return b(j8.l.G(), nVar, this.f19439c);
    }

    public final n b(j8.l lVar, n nVar, n nVar2) {
        j8.l lVar2 = this.f19437a;
        boolean z10 = true;
        int iCompareTo = lVar2 == null ? 1 : lVar.compareTo(lVar2);
        j8.l lVar3 = this.f19438b;
        int iCompareTo2 = lVar3 == null ? -1 : lVar.compareTo(lVar3);
        j8.l lVar4 = this.f19437a;
        boolean z11 = lVar4 != null && lVar.y(lVar4);
        j8.l lVar5 = this.f19438b;
        boolean z12 = lVar5 != null && lVar.y(lVar5);
        if (iCompareTo > 0 && iCompareTo2 < 0 && !z12) {
            return nVar2;
        }
        if (iCompareTo > 0 && z12 && nVar2.J()) {
            return nVar2;
        }
        if (iCompareTo > 0 && iCompareTo2 == 0) {
            m8.m.f(z12);
            m8.m.f(!nVar2.J());
            return nVar.J() ? g.y() : nVar;
        }
        if (!z11 && !z12) {
            if (iCompareTo2 <= 0 && iCompareTo > 0) {
                z10 = false;
            }
            m8.m.f(z10);
            return nVar;
        }
        HashSet hashSet = new HashSet();
        Iterator it = nVar.iterator();
        while (it.hasNext()) {
            hashSet.add(((m) it.next()).c());
        }
        Iterator it2 = nVar2.iterator();
        while (it2.hasNext()) {
            hashSet.add(((m) it2.next()).c());
        }
        ArrayList<b> arrayList = new ArrayList(hashSet.size() + 1);
        arrayList.addAll(hashSet);
        if (!nVar2.n().isEmpty() || !nVar.n().isEmpty()) {
            arrayList.add(b.m());
        }
        n nVarT = nVar;
        for (b bVar : arrayList) {
            n nVarZ = nVar.z(bVar);
            n nVarB = b(lVar.v(bVar), nVar.z(bVar), nVar2.z(bVar));
            if (nVarB != nVarZ) {
                nVarT = nVarT.t(bVar, nVarB);
            }
        }
        return nVarT;
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.f19437a + ", optInclusiveEnd=" + this.f19438b + ", snap=" + this.f19439c + '}';
    }
}
