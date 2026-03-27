package p3;

import h3.C1875k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k3.AbstractC2279m;

/* JADX INFO: renamed from: p3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2565s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1875k f22314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1875k f22315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2560n f22316c;

    public C2565s(f3.o oVar) {
        List listA = oVar.a();
        this.f22314a = listA != null ? new C1875k(listA) : null;
        List listB = oVar.b();
        this.f22315b = listB != null ? new C1875k(listB) : null;
        this.f22316c = AbstractC2561o.a(oVar.c());
    }

    public InterfaceC2560n a(InterfaceC2560n interfaceC2560n) {
        return b(C1875k.O(), interfaceC2560n, this.f22316c);
    }

    public final InterfaceC2560n b(C1875k c1875k, InterfaceC2560n interfaceC2560n, InterfaceC2560n interfaceC2560n2) {
        C1875k c1875k2 = this.f22314a;
        boolean z7 = true;
        int iCompareTo = c1875k2 == null ? 1 : c1875k.compareTo(c1875k2);
        C1875k c1875k3 = this.f22315b;
        int iCompareTo2 = c1875k3 == null ? -1 : c1875k.compareTo(c1875k3);
        C1875k c1875k4 = this.f22314a;
        boolean z8 = c1875k4 != null && c1875k.M(c1875k4);
        C1875k c1875k5 = this.f22315b;
        boolean z9 = c1875k5 != null && c1875k.M(c1875k5);
        if (iCompareTo > 0 && iCompareTo2 < 0 && !z9) {
            return interfaceC2560n2;
        }
        if (iCompareTo > 0 && z9 && interfaceC2560n2.x()) {
            return interfaceC2560n2;
        }
        if (iCompareTo > 0 && iCompareTo2 == 0) {
            AbstractC2279m.f(z9);
            AbstractC2279m.f(!interfaceC2560n2.x());
            return interfaceC2560n.x() ? C2553g.M() : interfaceC2560n;
        }
        if (!z8 && !z9) {
            if (iCompareTo2 <= 0 && iCompareTo > 0) {
                z7 = false;
            }
            AbstractC2279m.f(z7);
            return interfaceC2560n;
        }
        HashSet hashSet = new HashSet();
        Iterator it = interfaceC2560n.iterator();
        while (it.hasNext()) {
            hashSet.add(((C2559m) it.next()).c());
        }
        Iterator it2 = interfaceC2560n2.iterator();
        while (it2.hasNext()) {
            hashSet.add(((C2559m) it2.next()).c());
        }
        ArrayList<C2548b> arrayList = new ArrayList(hashSet.size() + 1);
        arrayList.addAll(hashSet);
        if (!interfaceC2560n2.o().isEmpty() || !interfaceC2560n.o().isEmpty()) {
            arrayList.add(C2548b.n());
        }
        InterfaceC2560n interfaceC2560nA = interfaceC2560n;
        for (C2548b c2548b : arrayList) {
            InterfaceC2560n interfaceC2560nZ = interfaceC2560n.z(c2548b);
            InterfaceC2560n interfaceC2560nB = b(c1875k.K(c2548b), interfaceC2560n.z(c2548b), interfaceC2560n2.z(c2548b));
            if (interfaceC2560nB != interfaceC2560nZ) {
                interfaceC2560nA = interfaceC2560nA.A(c2548b, interfaceC2560nB);
            }
        }
        return interfaceC2560nA;
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.f22314a + ", optInclusiveEnd=" + this.f22315b + ", snap=" + this.f22316c + '}';
    }
}
