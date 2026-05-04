package n9;

import g9.k;
import g9.p;
import g9.r0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public static g9.q a(g9.q qVar) {
        f(qVar);
        if (m(qVar)) {
            return qVar;
        }
        g9.k kVar = (g9.k) qVar;
        List listB = kVar.b();
        if (listB.size() == 1) {
            return a((g9.q) listB.get(0));
        }
        if (kVar.h()) {
            return kVar;
        }
        ArrayList<g9.q> arrayList = new ArrayList();
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(a((g9.q) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (g9.q qVar2 : arrayList) {
            if (qVar2 instanceof g9.p) {
                arrayList2.add(qVar2);
            } else if (qVar2 instanceof g9.k) {
                g9.k kVar2 = (g9.k) qVar2;
                if (kVar2.e().equals(kVar.e())) {
                    arrayList2.addAll(kVar2.b());
                } else {
                    arrayList2.add(kVar2);
                }
            }
        }
        return arrayList2.size() == 1 ? (g9.q) arrayList2.get(0) : new g9.k(arrayList2, kVar.e());
    }

    public static g9.q b(g9.k kVar, g9.k kVar2) {
        b.d((kVar.b().isEmpty() || kVar2.b().isEmpty()) ? false : true, "Found an empty composite filter", new Object[0]);
        if (kVar.f() && kVar2.f()) {
            return kVar.j(kVar2.b());
        }
        g9.k kVar3 = kVar.g() ? kVar : kVar2;
        if (kVar.g()) {
            kVar = kVar2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = kVar3.b().iterator();
        while (it.hasNext()) {
            arrayList.add(e((g9.q) it.next(), kVar));
        }
        return new g9.k(arrayList, k.a.OR);
    }

    public static g9.q c(g9.p pVar, g9.k kVar) {
        if (kVar.f()) {
            return kVar.j(Collections.singletonList(pVar));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = kVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(e(pVar, (g9.q) it.next()));
        }
        return new g9.k(arrayList, k.a.OR);
    }

    public static g9.q d(g9.p pVar, g9.p pVar2) {
        return new g9.k(Arrays.asList(pVar, pVar2), k.a.AND);
    }

    public static g9.q e(g9.q qVar, g9.q qVar2) {
        f(qVar);
        f(qVar2);
        boolean z10 = qVar instanceof g9.p;
        return a((z10 && (qVar2 instanceof g9.p)) ? d((g9.p) qVar, (g9.p) qVar2) : (z10 && (qVar2 instanceof g9.k)) ? c((g9.p) qVar, (g9.k) qVar2) : ((qVar instanceof g9.k) && (qVar2 instanceof g9.p)) ? c((g9.p) qVar2, (g9.k) qVar) : b((g9.k) qVar, (g9.k) qVar2));
    }

    public static void f(g9.q qVar) {
        b.d((qVar instanceof g9.p) || (qVar instanceof g9.k), "Only field filters and composite filters are accepted.", new Object[0]);
    }

    public static g9.q g(g9.q qVar) {
        f(qVar);
        if (qVar instanceof g9.p) {
            return qVar;
        }
        g9.k kVar = (g9.k) qVar;
        if (kVar.b().size() == 1) {
            return g((g9.q) qVar.b().get(0));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = kVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(g((g9.q) it.next()));
        }
        g9.q qVarA = a(new g9.k(arrayList, kVar.e()));
        if (k(qVarA)) {
            return qVarA;
        }
        b.d(qVarA instanceof g9.k, "field filters are already in DNF form.", new Object[0]);
        g9.k kVar2 = (g9.k) qVarA;
        b.d(kVar2.f(), "Disjunction of filters all of which are already in DNF form is itself in DNF form.", new Object[0]);
        b.d(kVar2.b().size() > 1, "Single-filter composite filters are already in DNF form.", new Object[0]);
        g9.q qVarE = (g9.q) kVar2.b().get(0);
        for (int i10 = 1; i10 < kVar2.b().size(); i10++) {
            qVarE = e(qVarE, (g9.q) kVar2.b().get(i10));
        }
        return qVarE;
    }

    public static g9.q h(g9.q qVar) {
        f(qVar);
        ArrayList arrayList = new ArrayList();
        if (!(qVar instanceof g9.p)) {
            g9.k kVar = (g9.k) qVar;
            Iterator it = kVar.b().iterator();
            while (it.hasNext()) {
                arrayList.add(h((g9.q) it.next()));
            }
            return new g9.k(arrayList, kVar.e());
        }
        if (!(qVar instanceof r0)) {
            return qVar;
        }
        r0 r0Var = (r0) qVar;
        Iterator it2 = r0Var.h().l0().h().iterator();
        while (it2.hasNext()) {
            arrayList.add(g9.p.e(r0Var.f(), p.b.EQUAL, (bb.d0) it2.next()));
        }
        return new g9.k(arrayList, k.a.OR);
    }

    public static List i(g9.k kVar) {
        if (kVar.b().isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        g9.q qVarG = g(h(kVar));
        b.d(k(qVarG), "computeDistributedNormalForm did not result in disjunctive normal form", new Object[0]);
        return (m(qVarG) || l(qVarG)) ? Collections.singletonList(qVarG) : qVarG.b();
    }

    public static boolean j(g9.q qVar) {
        if (qVar instanceof g9.k) {
            g9.k kVar = (g9.k) qVar;
            if (kVar.g()) {
                for (g9.q qVar2 : kVar.b()) {
                    if (!m(qVar2) && !l(qVar2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean k(g9.q qVar) {
        return m(qVar) || l(qVar) || j(qVar);
    }

    public static boolean l(g9.q qVar) {
        return (qVar instanceof g9.k) && ((g9.k) qVar).i();
    }

    public static boolean m(g9.q qVar) {
        return qVar instanceof g9.p;
    }
}
