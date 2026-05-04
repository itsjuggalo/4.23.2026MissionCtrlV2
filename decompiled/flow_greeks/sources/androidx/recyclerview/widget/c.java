package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f2773h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f2774i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f2775j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f2776k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f2777l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f2778m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f2779n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f2780o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f2781p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f2782q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f2783r = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2784a;

        public a(ArrayList arrayList) {
            this.f2784a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : this.f2784a) {
                c cVar = c.this;
                eVar.getClass();
                cVar.o(null, eVar.f2790a, eVar.f2791b, eVar.f2792c, eVar.f2793d);
            }
            this.f2784a.clear();
            c.this.f2778m.remove(this.f2784a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2786a;

        public b(ArrayList arrayList) {
            this.f2786a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2786a.iterator();
            while (it.hasNext()) {
                c.this.n((d) it.next());
            }
            this.f2786a.clear();
            c.this.f2779n.remove(this.f2786a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class RunnableC0041c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2788a;

        public RunnableC0041c(ArrayList arrayList) {
            this.f2788a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2788a.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                c.this.m(null);
            }
            this.f2788a.clear();
            c.this.f2777l.remove(this.f2788a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2793d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void c() {
        int size = this.f2775j.size() - 1;
        if (size >= 0) {
            ((e) this.f2775j.get(size)).getClass();
            throw null;
        }
        for (int size2 = this.f2773h.size() - 1; size2 >= 0; size2--) {
            android.support.v4.media.session.b.a(this.f2773h.get(size2));
            k(null);
            this.f2773h.remove(size2);
        }
        int size3 = this.f2774i.size() - 1;
        if (size3 >= 0) {
            android.support.v4.media.session.b.a(this.f2774i.get(size3));
            throw null;
        }
        for (int size4 = this.f2776k.size() - 1; size4 >= 0; size4--) {
            r((d) this.f2776k.get(size4));
        }
        this.f2776k.clear();
        if (g()) {
            for (int size5 = this.f2778m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f2778m.get(size5);
                int size6 = arrayList.size() - 1;
                if (size6 >= 0) {
                    ((e) arrayList.get(size6)).getClass();
                    throw null;
                }
            }
            for (int size7 = this.f2777l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f2777l.get(size7);
                int size8 = arrayList2.size() - 1;
                if (size8 >= 0) {
                    android.support.v4.media.session.b.a(arrayList2.get(size8));
                    throw null;
                }
            }
            for (int size9 = this.f2779n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f2779n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    r((d) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2779n.remove(arrayList3);
                    }
                }
            }
            q(this.f2782q);
            q(this.f2781p);
            q(this.f2780o);
            q(this.f2783r);
            b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean g() {
        return (this.f2774i.isEmpty() && this.f2776k.isEmpty() && this.f2775j.isEmpty() && this.f2773h.isEmpty() && this.f2781p.isEmpty() && this.f2782q.isEmpty() && this.f2780o.isEmpty() && this.f2783r.isEmpty() && this.f2778m.isEmpty() && this.f2777l.isEmpty() && this.f2779n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void i() {
        boolean zIsEmpty = this.f2773h.isEmpty();
        boolean zIsEmpty2 = this.f2775j.isEmpty();
        boolean zIsEmpty3 = this.f2776k.isEmpty();
        boolean zIsEmpty4 = this.f2774i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f2773h.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            p(null);
        }
        this.f2773h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f2775j);
            this.f2778m.add(arrayList);
            this.f2775j.clear();
            a aVar = new a(arrayList);
            if (!zIsEmpty) {
                ((e) arrayList.get(0)).getClass();
                throw null;
            }
            aVar.run();
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f2776k);
            this.f2779n.add(arrayList2);
            this.f2776k.clear();
            b bVar = new b(arrayList2);
            if (!zIsEmpty) {
                ((d) arrayList2.get(0)).getClass();
                throw null;
            }
            bVar.run();
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f2774i);
        this.f2777l.add(arrayList3);
        this.f2774i.clear();
        RunnableC0041c runnableC0041c = new RunnableC0041c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnableC0041c.run();
            return;
        }
        if (!zIsEmpty) {
            f();
        }
        Math.max(!zIsEmpty2 ? e() : 0L, zIsEmpty3 ? 0L : d());
        android.support.v4.media.session.b.a(arrayList3.get(0));
        throw null;
    }

    public void m(RecyclerView.a0 a0Var) {
        throw null;
    }

    public void n(d dVar) {
        dVar.getClass();
    }

    public void o(RecyclerView.a0 a0Var, int i10, int i11, int i12, int i13) {
        throw null;
    }

    public final void p(RecyclerView.a0 a0Var) {
        throw null;
    }

    public void q(List list) {
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        android.support.v4.media.session.b.a(list.get(size));
        throw null;
    }

    public final void r(d dVar) {
        dVar.getClass();
    }
}
