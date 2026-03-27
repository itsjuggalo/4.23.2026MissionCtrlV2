package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f8110h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f8111i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f8112j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f8113k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f8114l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f8115m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f8116n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f8117o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f8118p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f8119q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f8120r = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8121a;

        public a(ArrayList arrayList) {
            this.f8121a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : this.f8121a) {
                c cVar = c.this;
                eVar.getClass();
                cVar.o(null, eVar.f8127a, eVar.f8128b, eVar.f8129c, eVar.f8130d);
            }
            this.f8121a.clear();
            c.this.f8115m.remove(this.f8121a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8123a;

        public b(ArrayList arrayList) {
            this.f8123a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f8123a.iterator();
            while (it.hasNext()) {
                c.this.n((d) it.next());
            }
            this.f8123a.clear();
            c.this.f8116n.remove(this.f8123a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    public class RunnableC0117c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8125a;

        public RunnableC0117c(ArrayList arrayList) {
            this.f8125a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f8125a.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                c.this.m(null);
            }
            this.f8125a.clear();
            c.this.f8114l.remove(this.f8125a);
        }
    }

    public static class d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8130d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void c() {
        int size = this.f8112j.size() - 1;
        if (size >= 0) {
            ((e) this.f8112j.get(size)).getClass();
            throw null;
        }
        for (int size2 = this.f8110h.size() - 1; size2 >= 0; size2--) {
            android.support.v4.media.session.b.a(this.f8110h.get(size2));
            k(null);
            this.f8110h.remove(size2);
        }
        int size3 = this.f8111i.size() - 1;
        if (size3 >= 0) {
            android.support.v4.media.session.b.a(this.f8111i.get(size3));
            throw null;
        }
        for (int size4 = this.f8113k.size() - 1; size4 >= 0; size4--) {
            r((d) this.f8113k.get(size4));
        }
        this.f8113k.clear();
        if (g()) {
            for (int size5 = this.f8115m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f8115m.get(size5);
                int size6 = arrayList.size() - 1;
                if (size6 >= 0) {
                    ((e) arrayList.get(size6)).getClass();
                    throw null;
                }
            }
            for (int size7 = this.f8114l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f8114l.get(size7);
                int size8 = arrayList2.size() - 1;
                if (size8 >= 0) {
                    android.support.v4.media.session.b.a(arrayList2.get(size8));
                    throw null;
                }
            }
            for (int size9 = this.f8116n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f8116n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    r((d) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f8116n.remove(arrayList3);
                    }
                }
            }
            q(this.f8119q);
            q(this.f8118p);
            q(this.f8117o);
            q(this.f8120r);
            b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean g() {
        return (this.f8111i.isEmpty() && this.f8113k.isEmpty() && this.f8112j.isEmpty() && this.f8110h.isEmpty() && this.f8118p.isEmpty() && this.f8119q.isEmpty() && this.f8117o.isEmpty() && this.f8120r.isEmpty() && this.f8115m.isEmpty() && this.f8114l.isEmpty() && this.f8116n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void i() {
        boolean zIsEmpty = this.f8110h.isEmpty();
        boolean zIsEmpty2 = this.f8112j.isEmpty();
        boolean zIsEmpty3 = this.f8113k.isEmpty();
        boolean zIsEmpty4 = this.f8111i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f8110h.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            p(null);
        }
        this.f8110h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f8112j);
            this.f8115m.add(arrayList);
            this.f8112j.clear();
            a aVar = new a(arrayList);
            if (!zIsEmpty) {
                ((e) arrayList.get(0)).getClass();
                throw null;
            }
            aVar.run();
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f8113k);
            this.f8116n.add(arrayList2);
            this.f8113k.clear();
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
        arrayList3.addAll(this.f8111i);
        this.f8114l.add(arrayList3);
        this.f8111i.clear();
        RunnableC0117c runnableC0117c = new RunnableC0117c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnableC0117c.run();
            return;
        }
        if (!zIsEmpty) {
            f();
        }
        Math.max(!zIsEmpty2 ? e() : 0L, zIsEmpty3 ? 0L : d());
        android.support.v4.media.session.b.a(arrayList3.get(0));
        throw null;
    }

    public void m(RecyclerView.A a4) {
        throw null;
    }

    public void n(d dVar) {
        dVar.getClass();
    }

    public void o(RecyclerView.A a4, int i4, int i5, int i6, int i7) {
        throw null;
    }

    public final void p(RecyclerView.A a4) {
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
