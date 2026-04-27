package m3;

import h3.AbstractC1872h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import k3.AbstractC2279m;
import m3.e;
import p3.AbstractC2554h;
import p3.C2555i;
import p3.C2559m;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f21419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2554h f21420b;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C2376c c2376c, C2376c c2376c2) {
            AbstractC2279m.f((c2376c.i() == null || c2376c2.i() == null) ? false : true);
            return f.this.f21420b.compare(new C2559m(c2376c.i(), c2376c.k().n()), new C2559m(c2376c2.i(), c2376c2.k().n()));
        }
    }

    public f(i iVar) {
        this.f21419a = iVar;
        this.f21420b = iVar.c();
    }

    public final Comparator b() {
        return new a();
    }

    public final C2377d c(C2376c c2376c, AbstractC1872h abstractC1872h, C2555i c2555i) {
        if (!c2376c.j().equals(e.a.VALUE) && !c2376c.j().equals(e.a.CHILD_REMOVED)) {
            c2376c = c2376c.a(c2555i.C(c2376c.i(), c2376c.k().n(), this.f21420b));
        }
        return abstractC1872h.b(c2376c, this.f21419a);
    }

    public List d(List list, C2555i c2555i, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C2376c c2376c = (C2376c) it.next();
            if (c2376c.j().equals(e.a.CHILD_CHANGED) && this.f21420b.d(c2376c.l().n(), c2376c.k().n())) {
                arrayList2.add(C2376c.f(c2376c.i(), c2376c.k()));
            }
        }
        e(arrayList, e.a.CHILD_REMOVED, list, list2, c2555i);
        e(arrayList, e.a.CHILD_ADDED, list, list2, c2555i);
        e(arrayList, e.a.CHILD_MOVED, arrayList2, list2, c2555i);
        e(arrayList, e.a.CHILD_CHANGED, list, list2, c2555i);
        e(arrayList, e.a.VALUE, list, list2, c2555i);
        return arrayList;
    }

    public final void e(List list, e.a aVar, List list2, List list3, C2555i c2555i) {
        ArrayList<C2376c> arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            C2376c c2376c = (C2376c) it.next();
            if (c2376c.j().equals(aVar)) {
                arrayList.add(c2376c);
            }
        }
        Collections.sort(arrayList, b());
        for (C2376c c2376c2 : arrayList) {
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                AbstractC1872h abstractC1872h = (AbstractC1872h) it2.next();
                if (abstractC1872h.i(aVar)) {
                    list.add(c(c2376c2, abstractC1872h, c2555i));
                }
            }
        }
    }
}
