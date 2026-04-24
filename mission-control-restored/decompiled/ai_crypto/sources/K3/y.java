package K3;

import D3.AbstractC0447q;
import D3.C0441k;
import D3.C0446p;
import D3.S;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {
    public static AbstractC0447q a(AbstractC0447q abstractC0447q) {
        f(abstractC0447q);
        if (m(abstractC0447q)) {
            return abstractC0447q;
        }
        C0441k c0441k = (C0441k) abstractC0447q;
        List listB = c0441k.b();
        if (listB.size() == 1) {
            return a((AbstractC0447q) listB.get(0));
        }
        if (c0441k.h()) {
            return c0441k;
        }
        ArrayList<AbstractC0447q> arrayList = new ArrayList();
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(a((AbstractC0447q) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (AbstractC0447q abstractC0447q2 : arrayList) {
            if (abstractC0447q2 instanceof C0446p) {
                arrayList2.add(abstractC0447q2);
            } else if (abstractC0447q2 instanceof C0441k) {
                C0441k c0441k2 = (C0441k) abstractC0447q2;
                if (c0441k2.e().equals(c0441k.e())) {
                    arrayList2.addAll(c0441k2.b());
                } else {
                    arrayList2.add(c0441k2);
                }
            }
        }
        return arrayList2.size() == 1 ? (AbstractC0447q) arrayList2.get(0) : new C0441k(arrayList2, c0441k.e());
    }

    public static AbstractC0447q b(C0441k c0441k, C0441k c0441k2) {
        AbstractC0612b.d((c0441k.b().isEmpty() || c0441k2.b().isEmpty()) ? false : true, "Found an empty composite filter", new Object[0]);
        if (c0441k.f() && c0441k2.f()) {
            return c0441k.j(c0441k2.b());
        }
        C0441k c0441k3 = c0441k.g() ? c0441k : c0441k2;
        if (c0441k.g()) {
            c0441k = c0441k2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = c0441k3.b().iterator();
        while (it.hasNext()) {
            arrayList.add(e((AbstractC0447q) it.next(), c0441k));
        }
        return new C0441k(arrayList, C0441k.a.OR);
    }

    public static AbstractC0447q c(C0446p c0446p, C0441k c0441k) {
        if (c0441k.f()) {
            return c0441k.j(Collections.singletonList(c0446p));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = c0441k.b().iterator();
        while (it.hasNext()) {
            arrayList.add(e(c0446p, (AbstractC0447q) it.next()));
        }
        return new C0441k(arrayList, C0441k.a.OR);
    }

    public static AbstractC0447q d(C0446p c0446p, C0446p c0446p2) {
        return new C0441k(Arrays.asList(c0446p, c0446p2), C0441k.a.AND);
    }

    public static AbstractC0447q e(AbstractC0447q abstractC0447q, AbstractC0447q abstractC0447q2) {
        f(abstractC0447q);
        f(abstractC0447q2);
        boolean z7 = abstractC0447q instanceof C0446p;
        return a((z7 && (abstractC0447q2 instanceof C0446p)) ? d((C0446p) abstractC0447q, (C0446p) abstractC0447q2) : (z7 && (abstractC0447q2 instanceof C0441k)) ? c((C0446p) abstractC0447q, (C0441k) abstractC0447q2) : ((abstractC0447q instanceof C0441k) && (abstractC0447q2 instanceof C0446p)) ? c((C0446p) abstractC0447q2, (C0441k) abstractC0447q) : b((C0441k) abstractC0447q, (C0441k) abstractC0447q2));
    }

    public static void f(AbstractC0447q abstractC0447q) {
        AbstractC0612b.d((abstractC0447q instanceof C0446p) || (abstractC0447q instanceof C0441k), "Only field filters and composite filters are accepted.", new Object[0]);
    }

    public static AbstractC0447q g(AbstractC0447q abstractC0447q) {
        f(abstractC0447q);
        if (abstractC0447q instanceof C0446p) {
            return abstractC0447q;
        }
        C0441k c0441k = (C0441k) abstractC0447q;
        if (c0441k.b().size() == 1) {
            return g((AbstractC0447q) abstractC0447q.b().get(0));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = c0441k.b().iterator();
        while (it.hasNext()) {
            arrayList.add(g((AbstractC0447q) it.next()));
        }
        AbstractC0447q abstractC0447qA = a(new C0441k(arrayList, c0441k.e()));
        if (k(abstractC0447qA)) {
            return abstractC0447qA;
        }
        AbstractC0612b.d(abstractC0447qA instanceof C0441k, "field filters are already in DNF form.", new Object[0]);
        C0441k c0441k2 = (C0441k) abstractC0447qA;
        AbstractC0612b.d(c0441k2.f(), "Disjunction of filters all of which are already in DNF form is itself in DNF form.", new Object[0]);
        AbstractC0612b.d(c0441k2.b().size() > 1, "Single-filter composite filters are already in DNF form.", new Object[0]);
        AbstractC0447q abstractC0447qE = (AbstractC0447q) c0441k2.b().get(0);
        for (int i7 = 1; i7 < c0441k2.b().size(); i7++) {
            abstractC0447qE = e(abstractC0447qE, (AbstractC0447q) c0441k2.b().get(i7));
        }
        return abstractC0447qE;
    }

    public static AbstractC0447q h(AbstractC0447q abstractC0447q) {
        f(abstractC0447q);
        ArrayList arrayList = new ArrayList();
        if (!(abstractC0447q instanceof C0446p)) {
            C0441k c0441k = (C0441k) abstractC0447q;
            Iterator it = c0441k.b().iterator();
            while (it.hasNext()) {
                arrayList.add(h((AbstractC0447q) it.next()));
            }
            return new C0441k(arrayList, c0441k.e());
        }
        if (!(abstractC0447q instanceof S)) {
            return abstractC0447q;
        }
        S s7 = (S) abstractC0447q;
        Iterator it2 = s7.h().l0().g().iterator();
        while (it2.hasNext()) {
            arrayList.add(C0446p.e(s7.f(), C0446p.b.EQUAL, (C2105D) it2.next()));
        }
        return new C0441k(arrayList, C0441k.a.OR);
    }

    public static List i(C0441k c0441k) {
        if (c0441k.b().isEmpty()) {
            return Collections.emptyList();
        }
        AbstractC0447q abstractC0447qG = g(h(c0441k));
        AbstractC0612b.d(k(abstractC0447qG), "computeDistributedNormalForm did not result in disjunctive normal form", new Object[0]);
        return (m(abstractC0447qG) || l(abstractC0447qG)) ? Collections.singletonList(abstractC0447qG) : abstractC0447qG.b();
    }

    public static boolean j(AbstractC0447q abstractC0447q) {
        if (abstractC0447q instanceof C0441k) {
            C0441k c0441k = (C0441k) abstractC0447q;
            if (c0441k.g()) {
                for (AbstractC0447q abstractC0447q2 : c0441k.b()) {
                    if (!m(abstractC0447q2) && !l(abstractC0447q2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean k(AbstractC0447q abstractC0447q) {
        return m(abstractC0447q) || l(abstractC0447q) || j(abstractC0447q);
    }

    public static boolean l(AbstractC0447q abstractC0447q) {
        return (abstractC0447q instanceof C0441k) && ((C0441k) abstractC0447q).i();
    }

    public static boolean m(AbstractC0447q abstractC0447q) {
        return abstractC0447q instanceof C0446p;
    }
}
