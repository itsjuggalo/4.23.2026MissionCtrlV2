package j9;

import g9.a1;
import g9.g1;
import g9.p;
import j9.p;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SortedSet f14281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f14283d;

    public x(g1 g1Var) {
        this.f14280a = g1Var.d() != null ? g1Var.d() : g1Var.n().m();
        this.f14283d = g1Var.m();
        this.f14281b = new TreeSet(new Comparator() { // from class: j9.w
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((g9.p) obj).f().compareTo(((g9.p) obj2).f());
            }
        });
        this.f14282c = new ArrayList();
        Iterator it = g1Var.h().iterator();
        while (it.hasNext()) {
            g9.p pVar = (g9.p) ((g9.q) it.next());
            if (pVar.i()) {
                this.f14281b.add(pVar);
            } else {
                this.f14282c.add(pVar);
            }
        }
    }

    public p b() {
        if (d()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (g9.p pVar : this.f14282c) {
            if (!pVar.f().G()) {
                if (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY)) {
                    arrayList.add(p.c.b(pVar.f(), p.c.a.CONTAINS));
                } else if (!hashSet.contains(pVar.f())) {
                    hashSet.add(pVar.f());
                    arrayList.add(p.c.b(pVar.f(), p.c.a.ASCENDING));
                }
            }
        }
        for (a1 a1Var : this.f14283d) {
            if (!a1Var.c().G() && !hashSet.contains(a1Var.c())) {
                hashSet.add(a1Var.c());
                arrayList.add(p.c.b(a1Var.c(), a1Var.b() == a1.a.ASCENDING ? p.c.a.ASCENDING : p.c.a.DESCENDING));
            }
        }
        return p.b(-1, this.f14280a, arrayList, p.f14248a);
    }

    public final boolean c(p.c cVar) {
        Iterator it = this.f14282c.iterator();
        while (it.hasNext()) {
            if (e((g9.p) it.next(), cVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return this.f14281b.size() > 1;
    }

    public final boolean e(g9.p pVar, p.c cVar) {
        if (pVar != null && pVar.f().equals(cVar.c())) {
            if (cVar.h().equals(p.c.a.CONTAINS) == (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY))) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(a1 a1Var, p.c cVar) {
        if (!a1Var.c().equals(cVar.c())) {
            return false;
        }
        if (cVar.h().equals(p.c.a.ASCENDING) && a1Var.b().equals(a1.a.ASCENDING)) {
            return true;
        }
        return cVar.h().equals(p.c.a.DESCENDING) && a1Var.b().equals(a1.a.DESCENDING);
    }

    public boolean g(p pVar) {
        n9.b.d(pVar.d().equals(this.f14280a), "Collection IDs do not match", new Object[0]);
        if (d()) {
            return false;
        }
        p.c cVarC = pVar.c();
        if (cVarC != null && !c(cVarC)) {
            return false;
        }
        Iterator it = this.f14283d.iterator();
        List listE = pVar.e();
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < listE.size() && c((p.c) listE.get(i10))) {
            hashSet.add(((p.c) listE.get(i10)).c().c());
            i10++;
        }
        if (i10 == listE.size()) {
            return true;
        }
        if (this.f14281b.size() > 0) {
            g9.p pVar2 = (g9.p) this.f14281b.first();
            if (!hashSet.contains(pVar2.f().c())) {
                p.c cVar = (p.c) listE.get(i10);
                if (!e(pVar2, cVar) || !f((a1) it.next(), cVar)) {
                    return false;
                }
            }
            i10++;
        }
        while (i10 < listE.size()) {
            p.c cVar2 = (p.c) listE.get(i10);
            if (!it.hasNext() || !f((a1) it.next(), cVar2)) {
                return false;
            }
            i10++;
        }
        return true;
    }
}
