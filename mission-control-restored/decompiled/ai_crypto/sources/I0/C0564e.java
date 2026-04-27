package I0;

import I0.AbstractC0571l;
import M.e;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import m0.AbstractComponentCallbacksC2216p;
import m0.T;

/* JADX INFO: renamed from: I0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0564e extends T {

    /* JADX INFO: renamed from: I0.e$a */
    public class a extends AbstractC0571l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f2773a;

        public a(Rect rect) {
            this.f2773a = rect;
        }
    }

    /* JADX INFO: renamed from: I0.e$c */
    public class c extends AbstractC0572m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f2778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f2780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2781d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f2782e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2783f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2778a = obj;
            this.f2779b = arrayList;
            this.f2780c = obj2;
            this.f2781d = arrayList2;
            this.f2782e = obj3;
            this.f2783f = arrayList3;
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void c(AbstractC0571l abstractC0571l) {
            Object obj = this.f2778a;
            if (obj != null) {
                C0564e.this.D(obj, this.f2779b, null);
            }
            Object obj2 = this.f2780c;
            if (obj2 != null) {
                C0564e.this.D(obj2, this.f2781d, null);
            }
            Object obj3 = this.f2782e;
            if (obj3 != null) {
                C0564e.this.D(obj3, this.f2783f, null);
            }
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            abstractC0571l.P(this);
        }
    }

    /* JADX INFO: renamed from: I0.e$d */
    public class d implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0571l f2785a;

        public d(AbstractC0571l abstractC0571l) {
            this.f2785a = abstractC0571l;
        }

        @Override // M.e.a
        public void a() {
            this.f2785a.cancel();
        }
    }

    /* JADX INFO: renamed from: I0.e$f */
    public class f extends AbstractC0571l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f2789a;

        public f(Rect rect) {
            this.f2789a = rect;
        }
    }

    public static boolean C(AbstractC0571l abstractC0571l) {
        return (T.l(abstractC0571l.z()) && T.l(abstractC0571l.A()) && T.l(abstractC0571l.B())) ? false : true;
    }

    @Override // m0.T
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        C0575p c0575p = (C0575p) obj;
        if (c0575p != null) {
            c0575p.C().clear();
            c0575p.C().addAll(arrayList2);
            D(c0575p, arrayList, arrayList2);
        }
    }

    @Override // m0.T
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        C0575p c0575p = new C0575p();
        c0575p.e0((AbstractC0571l) obj);
        return c0575p;
    }

    public void D(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        AbstractC0571l abstractC0571l = (AbstractC0571l) obj;
        int i7 = 0;
        if (abstractC0571l instanceof C0575p) {
            C0575p c0575p = (C0575p) abstractC0571l;
            int iH0 = c0575p.h0();
            while (i7 < iH0) {
                D(c0575p.g0(i7), arrayList, arrayList2);
                i7++;
            }
            return;
        }
        if (C(abstractC0571l)) {
            return;
        }
        List listC = abstractC0571l.C();
        if (listC.size() == arrayList.size() && listC.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i7 < size) {
                abstractC0571l.b((View) arrayList2.get(i7));
                i7++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                abstractC0571l.Q((View) arrayList.get(size2));
            }
        }
    }

    @Override // m0.T
    public void a(Object obj, View view) {
        if (obj != null) {
            ((AbstractC0571l) obj).b(view);
        }
    }

    @Override // m0.T
    public void b(Object obj, ArrayList arrayList) {
        AbstractC0571l abstractC0571l = (AbstractC0571l) obj;
        if (abstractC0571l == null) {
            return;
        }
        int i7 = 0;
        if (abstractC0571l instanceof C0575p) {
            C0575p c0575p = (C0575p) abstractC0571l;
            int iH0 = c0575p.h0();
            while (i7 < iH0) {
                b(c0575p.g0(i7), arrayList);
                i7++;
            }
            return;
        }
        if (C(abstractC0571l) || !T.l(abstractC0571l.C())) {
            return;
        }
        int size = arrayList.size();
        while (i7 < size) {
            abstractC0571l.b((View) arrayList.get(i7));
            i7++;
        }
    }

    @Override // m0.T
    public void e(ViewGroup viewGroup, Object obj) {
        AbstractC0573n.a(viewGroup, (AbstractC0571l) obj);
    }

    @Override // m0.T
    public boolean g(Object obj) {
        return obj instanceof AbstractC0571l;
    }

    @Override // m0.T
    public Object h(Object obj) {
        if (obj != null) {
            return ((AbstractC0571l) obj).clone();
        }
        return null;
    }

    @Override // m0.T
    public Object o(Object obj, Object obj2, Object obj3) {
        AbstractC0571l abstractC0571lM0 = (AbstractC0571l) obj;
        AbstractC0571l abstractC0571l = (AbstractC0571l) obj2;
        AbstractC0571l abstractC0571l2 = (AbstractC0571l) obj3;
        if (abstractC0571lM0 != null && abstractC0571l != null) {
            abstractC0571lM0 = new C0575p().e0(abstractC0571lM0).e0(abstractC0571l).m0(1);
        } else if (abstractC0571lM0 == null) {
            abstractC0571lM0 = abstractC0571l != null ? abstractC0571l : null;
        }
        if (abstractC0571l2 == null) {
            return abstractC0571lM0;
        }
        C0575p c0575p = new C0575p();
        if (abstractC0571lM0 != null) {
            c0575p.e0(abstractC0571lM0);
        }
        c0575p.e0(abstractC0571l2);
        return c0575p;
    }

    @Override // m0.T
    public Object p(Object obj, Object obj2, Object obj3) {
        C0575p c0575p = new C0575p();
        if (obj != null) {
            c0575p.e0((AbstractC0571l) obj);
        }
        if (obj2 != null) {
            c0575p.e0((AbstractC0571l) obj2);
        }
        if (obj3 != null) {
            c0575p.e0((AbstractC0571l) obj3);
        }
        return c0575p;
    }

    @Override // m0.T
    public void r(Object obj, View view, ArrayList arrayList) {
        ((AbstractC0571l) obj).a(new b(view, arrayList));
    }

    @Override // m0.T
    public void s(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((AbstractC0571l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // m0.T
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((AbstractC0571l) obj).V(new f(rect));
        }
    }

    @Override // m0.T
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((AbstractC0571l) obj).V(new a(rect));
        }
    }

    @Override // m0.T
    public void w(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, Object obj, M.e eVar, Runnable runnable) {
        AbstractC0571l abstractC0571l = (AbstractC0571l) obj;
        eVar.b(new d(abstractC0571l));
        abstractC0571l.a(new C0027e(runnable));
    }

    @Override // m0.T
    public void z(Object obj, View view, ArrayList arrayList) {
        C0575p c0575p = (C0575p) obj;
        List listC = c0575p.C();
        listC.clear();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            T.f(listC, (View) arrayList.get(i7));
        }
        listC.add(view);
        arrayList.add(view);
        b(c0575p, arrayList);
    }

    /* JADX INFO: renamed from: I0.e$b */
    public class b implements AbstractC0571l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2776b;

        public b(View view, ArrayList arrayList) {
            this.f2775a = view;
            this.f2776b = arrayList;
        }

        @Override // I0.AbstractC0571l.f
        public void c(AbstractC0571l abstractC0571l) {
            abstractC0571l.P(this);
            abstractC0571l.a(this);
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            abstractC0571l.P(this);
            this.f2775a.setVisibility(8);
            int size = this.f2776b.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((View) this.f2776b.get(i7)).setVisibility(0);
            }
        }

        @Override // I0.AbstractC0571l.f
        public void a(AbstractC0571l abstractC0571l) {
        }

        @Override // I0.AbstractC0571l.f
        public void b(AbstractC0571l abstractC0571l) {
        }

        @Override // I0.AbstractC0571l.f
        public void d(AbstractC0571l abstractC0571l) {
        }
    }

    /* JADX INFO: renamed from: I0.e$e, reason: collision with other inner class name */
    public class C0027e implements AbstractC0571l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f2787a;

        public C0027e(Runnable runnable) {
            this.f2787a = runnable;
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            this.f2787a.run();
        }

        @Override // I0.AbstractC0571l.f
        public void a(AbstractC0571l abstractC0571l) {
        }

        @Override // I0.AbstractC0571l.f
        public void b(AbstractC0571l abstractC0571l) {
        }

        @Override // I0.AbstractC0571l.f
        public void c(AbstractC0571l abstractC0571l) {
        }

        @Override // I0.AbstractC0571l.f
        public void d(AbstractC0571l abstractC0571l) {
        }
    }
}
