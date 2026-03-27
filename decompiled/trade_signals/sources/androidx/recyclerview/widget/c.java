package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f12406h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f12407i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f12408j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f12409k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f12410l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f12411m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f12412n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f12413o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f12414p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f12415q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f12416r = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f12417a;

        public a(ArrayList arrayList) {
            this.f12417a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : this.f12417a) {
                c cVar = c.this;
                eVar.getClass();
                cVar.o(null, eVar.f12423a, eVar.f12424b, eVar.f12425c, eVar.f12426d);
            }
            this.f12417a.clear();
            c.this.f12411m.remove(this.f12417a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f12419a;

        public b(ArrayList arrayList) {
            this.f12419a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f12419a.iterator();
            while (it.hasNext()) {
                c.this.n((d) it.next());
            }
            this.f12419a.clear();
            c.this.f12412n.remove(this.f12419a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    public class RunnableC0200c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f12421a;

        public RunnableC0200c(ArrayList arrayList) {
            this.f12421a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f12421a.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                c.this.m(null);
            }
            this.f12421a.clear();
            c.this.f12410l.remove(this.f12421a);
        }
    }

    public static class d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12426d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void c() {
        int size = this.f12408j.size() - 1;
        if (size >= 0) {
            ((e) this.f12408j.get(size)).getClass();
            throw null;
        }
        for (int size2 = this.f12406h.size() - 1; size2 >= 0; size2--) {
            android.support.v4.media.session.b.a(this.f12406h.get(size2));
            k(null);
            this.f12406h.remove(size2);
        }
        int size3 = this.f12407i.size() - 1;
        if (size3 >= 0) {
            android.support.v4.media.session.b.a(this.f12407i.get(size3));
            throw null;
        }
        for (int size4 = this.f12409k.size() - 1; size4 >= 0; size4--) {
            r((d) this.f12409k.get(size4));
        }
        this.f12409k.clear();
        if (g()) {
            for (int size5 = this.f12411m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f12411m.get(size5);
                int size6 = arrayList.size() - 1;
                if (size6 >= 0) {
                    ((e) arrayList.get(size6)).getClass();
                    throw null;
                }
            }
            for (int size7 = this.f12410l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f12410l.get(size7);
                int size8 = arrayList2.size() - 1;
                if (size8 >= 0) {
                    android.support.v4.media.session.b.a(arrayList2.get(size8));
                    throw null;
                }
            }
            for (int size9 = this.f12412n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f12412n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    r((d) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f12412n.remove(arrayList3);
                    }
                }
            }
            q(this.f12415q);
            q(this.f12414p);
            q(this.f12413o);
            q(this.f12416r);
            b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean g() {
        return (this.f12407i.isEmpty() && this.f12409k.isEmpty() && this.f12408j.isEmpty() && this.f12406h.isEmpty() && this.f12414p.isEmpty() && this.f12415q.isEmpty() && this.f12413o.isEmpty() && this.f12416r.isEmpty() && this.f12411m.isEmpty() && this.f12410l.isEmpty() && this.f12412n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void i() {
        boolean z7 = !this.f12406h.isEmpty();
        boolean z8 = !this.f12408j.isEmpty();
        boolean z9 = !this.f12409k.isEmpty();
        boolean z10 = !this.f12407i.isEmpty();
        if (z7 || z8 || z10 || z9) {
            Iterator it = this.f12406h.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                p(null);
            }
            this.f12406h.clear();
            if (z8) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f12408j);
                this.f12411m.add(arrayList);
                this.f12408j.clear();
                a aVar = new a(arrayList);
                if (z7) {
                    ((e) arrayList.get(0)).getClass();
                    throw null;
                }
                aVar.run();
            }
            if (z9) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f12409k);
                this.f12412n.add(arrayList2);
                this.f12409k.clear();
                b bVar = new b(arrayList2);
                if (z7) {
                    ((d) arrayList2.get(0)).getClass();
                    throw null;
                }
                bVar.run();
            }
            if (z10) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f12407i);
                this.f12410l.add(arrayList3);
                this.f12407i.clear();
                RunnableC0200c runnableC0200c = new RunnableC0200c(arrayList3);
                if (!z7 && !z8 && !z9) {
                    runnableC0200c.run();
                    return;
                }
                if (z7) {
                    f();
                }
                Math.max(z8 ? e() : 0L, z9 ? d() : 0L);
                android.support.v4.media.session.b.a(arrayList3.get(0));
                throw null;
            }
        }
    }

    public void m(RecyclerView.A a8) {
        throw null;
    }

    public void n(d dVar) {
        dVar.getClass();
    }

    public void o(RecyclerView.A a8, int i8, int i9, int i10, int i11) {
        throw null;
    }

    public final void p(RecyclerView.A a8) {
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
