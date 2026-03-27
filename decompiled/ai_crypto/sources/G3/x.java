package G3;

import D3.AbstractC0447q;
import D3.C0446p;
import D3.b0;
import D3.h0;
import G3.p;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SortedSet f2478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2480d;

    public x(h0 h0Var) {
        this.f2477a = h0Var.d() != null ? h0Var.d() : h0Var.n().l();
        this.f2480d = h0Var.m();
        this.f2478b = new TreeSet(new Comparator() { // from class: G3.w
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return x.e((C0446p) obj, (C0446p) obj2);
            }
        });
        this.f2479c = new ArrayList();
        Iterator it = h0Var.h().iterator();
        while (it.hasNext()) {
            C0446p c0446p = (C0446p) ((AbstractC0447q) it.next());
            if (c0446p.i()) {
                this.f2478b.add(c0446p);
            } else {
                this.f2479c.add(c0446p);
            }
        }
    }

    public static /* synthetic */ int e(C0446p c0446p, C0446p c0446p2) {
        return c0446p.f().compareTo(c0446p2.f());
    }

    public p b() {
        if (d()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (C0446p c0446p : this.f2479c) {
            if (!c0446p.f().x()) {
                if (c0446p.g().equals(C0446p.b.ARRAY_CONTAINS) || c0446p.g().equals(C0446p.b.ARRAY_CONTAINS_ANY)) {
                    arrayList.add(p.c.b(c0446p.f(), p.c.a.CONTAINS));
                } else if (!hashSet.contains(c0446p.f())) {
                    hashSet.add(c0446p.f());
                    arrayList.add(p.c.b(c0446p.f(), p.c.a.ASCENDING));
                }
            }
        }
        for (b0 b0Var : this.f2480d) {
            if (!b0Var.c().x() && !hashSet.contains(b0Var.c())) {
                hashSet.add(b0Var.c());
                arrayList.add(p.c.b(b0Var.c(), b0Var.b() == b0.a.ASCENDING ? p.c.a.ASCENDING : p.c.a.DESCENDING));
            }
        }
        return p.b(-1, this.f2477a, arrayList, p.f2447a);
    }

    public final boolean c(p.c cVar) {
        Iterator it = this.f2479c.iterator();
        while (it.hasNext()) {
            if (f((C0446p) it.next(), cVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return this.f2478b.size() > 1;
    }

    public final boolean f(C0446p c0446p, p.c cVar) {
        if (c0446p == null || !c0446p.f().equals(cVar.c())) {
            return false;
        }
        return cVar.h().equals(p.c.a.CONTAINS) == (c0446p.g().equals(C0446p.b.ARRAY_CONTAINS) || c0446p.g().equals(C0446p.b.ARRAY_CONTAINS_ANY));
    }

    public final boolean g(b0 b0Var, p.c cVar) {
        if (b0Var.c().equals(cVar.c())) {
            return (cVar.h().equals(p.c.a.ASCENDING) && b0Var.b().equals(b0.a.ASCENDING)) || (cVar.h().equals(p.c.a.DESCENDING) && b0Var.b().equals(b0.a.DESCENDING));
        }
        return false;
    }

    public boolean h(p pVar) {
        AbstractC0612b.d(pVar.d().equals(this.f2477a), "Collection IDs do not match", new Object[0]);
        if (d()) {
            return false;
        }
        p.c cVarC = pVar.c();
        if (cVarC != null && !c(cVarC)) {
            return false;
        }
        Iterator it = this.f2480d.iterator();
        List listE = pVar.e();
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < listE.size() && c((p.c) listE.get(i7))) {
            hashSet.add(((p.c) listE.get(i7)).c().c());
            i7++;
        }
        if (i7 == listE.size()) {
            return true;
        }
        if (this.f2478b.size() > 0) {
            C0446p c0446p = (C0446p) this.f2478b.first();
            if (!hashSet.contains(c0446p.f().c())) {
                p.c cVar = (p.c) listE.get(i7);
                if (!f(c0446p, cVar) || !g((b0) it.next(), cVar)) {
                    return false;
                }
            }
            i7++;
        }
        while (i7 < listE.size()) {
            p.c cVar2 = (p.c) listE.get(i7);
            if (!it.hasNext() || !g((b0) it.next(), cVar2)) {
                return false;
            }
            i7++;
        }
        return true;
    }
}
