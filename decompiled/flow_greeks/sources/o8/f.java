package o8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import m8.m;
import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f17622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r8.h f17623b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            m.f((cVar.i() == null || cVar2.i() == null) ? false : true);
            return f.this.f17623b.compare(new r8.m(cVar.i(), cVar.k().g()), new r8.m(cVar2.i(), cVar2.k().g()));
        }
    }

    public f(i iVar) {
        this.f17622a = iVar;
        this.f17623b = iVar.c();
    }

    public final Comparator b() {
        return new a();
    }

    public final d c(c cVar, j8.i iVar, r8.i iVar2) {
        if (!cVar.j().equals(e.a.VALUE) && !cVar.j().equals(e.a.CHILD_REMOVED)) {
            cVar = cVar.a(iVar2.p(cVar.i(), cVar.k().g(), this.f17623b));
        }
        return iVar.b(cVar, this.f17622a);
    }

    public List d(List list, r8.i iVar, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.j().equals(e.a.CHILD_CHANGED) && this.f17623b.d(cVar.l().g(), cVar.k().g())) {
                arrayList2.add(c.f(cVar.i(), cVar.k()));
            }
        }
        e(arrayList, e.a.CHILD_REMOVED, list, list2, iVar);
        e(arrayList, e.a.CHILD_ADDED, list, list2, iVar);
        e(arrayList, e.a.CHILD_MOVED, arrayList2, list2, iVar);
        e(arrayList, e.a.CHILD_CHANGED, list, list2, iVar);
        e(arrayList, e.a.VALUE, list, list2, iVar);
        return arrayList;
    }

    public final void e(List list, e.a aVar, List list2, List list3, r8.i iVar) {
        ArrayList<c> arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.j().equals(aVar)) {
                arrayList.add(cVar);
            }
        }
        Collections.sort(arrayList, b());
        for (c cVar2 : arrayList) {
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                j8.i iVar2 = (j8.i) it2.next();
                if (iVar2.i(aVar)) {
                    list.add(c(cVar2, iVar2, iVar));
                }
            }
        }
    }
}
