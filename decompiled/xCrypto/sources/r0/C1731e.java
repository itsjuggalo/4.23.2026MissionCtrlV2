package r0;

import D.c;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import androidx.fragment.app.U;
import java.util.ArrayList;
import java.util.List;
import r0.AbstractC1738l;

/* JADX INFO: renamed from: r0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1731e extends U {

    /* JADX INFO: renamed from: r0.e$a */
    public class a extends AbstractC1738l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f14389a;

        public a(Rect rect) {
            this.f14389a = rect;
        }
    }

    /* JADX INFO: renamed from: r0.e$c */
    public class c extends AbstractC1739m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f14394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f14396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f14398e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14399f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f14394a = obj;
            this.f14395b = arrayList;
            this.f14396c = obj2;
            this.f14397d = arrayList2;
            this.f14398e = obj3;
            this.f14399f = arrayList3;
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            abstractC1738l.P(this);
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void e(AbstractC1738l abstractC1738l) {
            Object obj = this.f14394a;
            if (obj != null) {
                C1731e.this.D(obj, this.f14395b, null);
            }
            Object obj2 = this.f14396c;
            if (obj2 != null) {
                C1731e.this.D(obj2, this.f14397d, null);
            }
            Object obj3 = this.f14398e;
            if (obj3 != null) {
                C1731e.this.D(obj3, this.f14399f, null);
            }
        }
    }

    /* JADX INFO: renamed from: r0.e$d */
    public class d implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1738l f14401a;

        public d(AbstractC1738l abstractC1738l) {
            this.f14401a = abstractC1738l;
        }

        @Override // D.c.a
        public void a() {
            this.f14401a.f();
        }
    }

    /* JADX INFO: renamed from: r0.e$f */
    public class f extends AbstractC1738l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f14405a;

        public f(Rect rect) {
            this.f14405a = rect;
        }
    }

    public static boolean C(AbstractC1738l abstractC1738l) {
        return (U.l(abstractC1738l.z()) && U.l(abstractC1738l.A()) && U.l(abstractC1738l.B())) ? false : true;
    }

    @Override // androidx.fragment.app.U
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        C1742p c1742p = (C1742p) obj;
        if (c1742p != null) {
            c1742p.C().clear();
            c1742p.C().addAll(arrayList2);
            D(c1742p, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.U
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        C1742p c1742p = new C1742p();
        c1742p.e0((AbstractC1738l) obj);
        return c1742p;
    }

    public void D(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        AbstractC1738l abstractC1738l = (AbstractC1738l) obj;
        int i4 = 0;
        if (abstractC1738l instanceof C1742p) {
            C1742p c1742p = (C1742p) abstractC1738l;
            int iH0 = c1742p.h0();
            while (i4 < iH0) {
                D(c1742p.g0(i4), arrayList, arrayList2);
                i4++;
            }
            return;
        }
        if (C(abstractC1738l)) {
            return;
        }
        List listC = abstractC1738l.C();
        if (listC.size() == arrayList.size() && listC.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i4 < size) {
                abstractC1738l.b((View) arrayList2.get(i4));
                i4++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                abstractC1738l.Q((View) arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, View view) {
        if (obj != null) {
            ((AbstractC1738l) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.U
    public void b(Object obj, ArrayList arrayList) {
        AbstractC1738l abstractC1738l = (AbstractC1738l) obj;
        if (abstractC1738l == null) {
            return;
        }
        int i4 = 0;
        if (abstractC1738l instanceof C1742p) {
            C1742p c1742p = (C1742p) abstractC1738l;
            int iH0 = c1742p.h0();
            while (i4 < iH0) {
                b(c1742p.g0(i4), arrayList);
                i4++;
            }
            return;
        }
        if (C(abstractC1738l) || !U.l(abstractC1738l.C())) {
            return;
        }
        int size = arrayList.size();
        while (i4 < size) {
            abstractC1738l.b((View) arrayList.get(i4));
            i4++;
        }
    }

    @Override // androidx.fragment.app.U
    public void e(ViewGroup viewGroup, Object obj) {
        AbstractC1740n.a(viewGroup, (AbstractC1738l) obj);
    }

    @Override // androidx.fragment.app.U
    public boolean g(Object obj) {
        return obj instanceof AbstractC1738l;
    }

    @Override // androidx.fragment.app.U
    public Object h(Object obj) {
        if (obj != null) {
            return ((AbstractC1738l) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.U
    public Object o(Object obj, Object obj2, Object obj3) {
        AbstractC1738l abstractC1738lM0 = (AbstractC1738l) obj;
        AbstractC1738l abstractC1738l = (AbstractC1738l) obj2;
        AbstractC1738l abstractC1738l2 = (AbstractC1738l) obj3;
        if (abstractC1738lM0 != null && abstractC1738l != null) {
            abstractC1738lM0 = new C1742p().e0(abstractC1738lM0).e0(abstractC1738l).m0(1);
        } else if (abstractC1738lM0 == null) {
            abstractC1738lM0 = abstractC1738l != null ? abstractC1738l : null;
        }
        if (abstractC1738l2 == null) {
            return abstractC1738lM0;
        }
        C1742p c1742p = new C1742p();
        if (abstractC1738lM0 != null) {
            c1742p.e0(abstractC1738lM0);
        }
        c1742p.e0(abstractC1738l2);
        return c1742p;
    }

    @Override // androidx.fragment.app.U
    public Object p(Object obj, Object obj2, Object obj3) {
        C1742p c1742p = new C1742p();
        if (obj != null) {
            c1742p.e0((AbstractC1738l) obj);
        }
        if (obj2 != null) {
            c1742p.e0((AbstractC1738l) obj2);
        }
        if (obj3 != null) {
            c1742p.e0((AbstractC1738l) obj3);
        }
        return c1742p;
    }

    @Override // androidx.fragment.app.U
    public void r(Object obj, View view, ArrayList arrayList) {
        ((AbstractC1738l) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.U
    public void s(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((AbstractC1738l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.U
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((AbstractC1738l) obj).V(new f(rect));
        }
    }

    @Override // androidx.fragment.app.U
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((AbstractC1738l) obj).V(new a(rect));
        }
    }

    @Override // androidx.fragment.app.U
    public void w(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, Object obj, D.c cVar, Runnable runnable) {
        AbstractC1738l abstractC1738l = (AbstractC1738l) obj;
        cVar.b(new d(abstractC1738l));
        abstractC1738l.a(new C0232e(runnable));
    }

    @Override // androidx.fragment.app.U
    public void z(Object obj, View view, ArrayList arrayList) {
        C1742p c1742p = (C1742p) obj;
        List listC = c1742p.C();
        listC.clear();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            U.f(listC, (View) arrayList.get(i4));
        }
        listC.add(view);
        arrayList.add(view);
        b(c1742p, arrayList);
    }

    /* JADX INFO: renamed from: r0.e$b */
    public class b implements AbstractC1738l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14392b;

        public b(View view, ArrayList arrayList) {
            this.f14391a = view;
            this.f14392b = arrayList;
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            abstractC1738l.P(this);
            this.f14391a.setVisibility(8);
            int size = this.f14392b.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((View) this.f14392b.get(i4)).setVisibility(0);
            }
        }

        @Override // r0.AbstractC1738l.f
        public void e(AbstractC1738l abstractC1738l) {
            abstractC1738l.P(this);
            abstractC1738l.a(this);
        }

        @Override // r0.AbstractC1738l.f
        public void a(AbstractC1738l abstractC1738l) {
        }

        @Override // r0.AbstractC1738l.f
        public void c(AbstractC1738l abstractC1738l) {
        }

        @Override // r0.AbstractC1738l.f
        public void d(AbstractC1738l abstractC1738l) {
        }
    }

    /* JADX INFO: renamed from: r0.e$e, reason: collision with other inner class name */
    public class C0232e implements AbstractC1738l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f14403a;

        public C0232e(Runnable runnable) {
            this.f14403a = runnable;
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            this.f14403a.run();
        }

        @Override // r0.AbstractC1738l.f
        public void a(AbstractC1738l abstractC1738l) {
        }

        @Override // r0.AbstractC1738l.f
        public void c(AbstractC1738l abstractC1738l) {
        }

        @Override // r0.AbstractC1738l.f
        public void d(AbstractC1738l abstractC1738l) {
        }

        @Override // r0.AbstractC1738l.f
        public void e(AbstractC1738l abstractC1738l) {
        }
    }
}
