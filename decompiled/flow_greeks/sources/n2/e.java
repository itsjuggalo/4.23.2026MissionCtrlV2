package n2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.t0;
import java.util.ArrayList;
import java.util.List;
import n2.l;
import p0.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends t0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f16508a;

        public a(Rect rect) {
            this.f16508a = rect;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f16513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f16515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f16517e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16518f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f16513a = obj;
            this.f16514b = arrayList;
            this.f16515c = obj2;
            this.f16516d = arrayList2;
            this.f16517e = obj3;
            this.f16518f = arrayList3;
        }

        @Override // n2.m, n2.l.f
        public void b(l lVar) {
            Object obj = this.f16513a;
            if (obj != null) {
                e.this.D(obj, this.f16514b, null);
            }
            Object obj2 = this.f16515c;
            if (obj2 != null) {
                e.this.D(obj2, this.f16516d, null);
            }
            Object obj3 = this.f16517e;
            if (obj3 != null) {
                e.this.D(obj3, this.f16518f, null);
            }
        }

        @Override // n2.l.f
        public void d(l lVar) {
            lVar.R(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f16520a;

        public d(l lVar) {
            this.f16520a = lVar;
        }

        @Override // p0.c.a
        public void onCancel() {
            this.f16520a.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f extends l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f16524a;

        public f(Rect rect) {
            this.f16524a = rect;
        }
    }

    public static boolean C(l lVar) {
        return (t0.l(lVar.B()) && t0.l(lVar.C()) && t0.l(lVar.D())) ? false : true;
    }

    @Override // androidx.fragment.app.t0
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.E().clear();
            pVar.E().addAll(arrayList2);
            D(pVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.t0
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.g0((l) obj);
        return pVar;
    }

    public void D(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        l lVar = (l) obj;
        int i10 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int iJ0 = pVar.j0();
            while (i10 < iJ0) {
                D(pVar.i0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (C(lVar)) {
            return;
        }
        List listE = lVar.E();
        if (listE.size() == arrayList.size() && listE.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                lVar.b((View) arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                lVar.S((View) arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.t0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.t0
    public void b(Object obj, ArrayList arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i10 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int iJ0 = pVar.j0();
            while (i10 < iJ0) {
                b(pVar.i0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (C(lVar) || !t0.l(lVar.E())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            lVar.b((View) arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.t0
    public void e(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    @Override // androidx.fragment.app.t0
    public boolean g(Object obj) {
        return obj instanceof l;
    }

    @Override // androidx.fragment.app.t0
    public Object h(Object obj) {
        if (obj != null) {
            return ((l) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.t0
    public Object o(Object obj, Object obj2, Object obj3) {
        l lVarO0 = (l) obj;
        l lVar = (l) obj2;
        l lVar2 = (l) obj3;
        if (lVarO0 != null && lVar != null) {
            lVarO0 = new p().g0(lVarO0).g0(lVar).o0(1);
        } else if (lVarO0 == null) {
            lVarO0 = lVar != null ? lVar : null;
        }
        if (lVar2 == null) {
            return lVarO0;
        }
        p pVar = new p();
        if (lVarO0 != null) {
            pVar.g0(lVarO0);
        }
        pVar.g0(lVar2);
        return pVar;
    }

    @Override // androidx.fragment.app.t0
    public Object p(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.g0((l) obj);
        }
        if (obj2 != null) {
            pVar.g0((l) obj2);
        }
        if (obj3 != null) {
            pVar.g0((l) obj3);
        }
        return pVar;
    }

    @Override // androidx.fragment.app.t0
    public void r(Object obj, View view, ArrayList arrayList) {
        ((l) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.t0
    public void s(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.t0
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).X(new f(rect));
        }
    }

    @Override // androidx.fragment.app.t0
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).X(new a(rect));
        }
    }

    @Override // androidx.fragment.app.t0
    public void w(androidx.fragment.app.p pVar, Object obj, p0.c cVar, Runnable runnable) {
        l lVar = (l) obj;
        cVar.b(new d(lVar));
        lVar.a(new C0295e(runnable));
    }

    @Override // androidx.fragment.app.t0
    public void z(Object obj, View view, ArrayList arrayList) {
        p pVar = (p) obj;
        List listE = pVar.E();
        listE.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            t0.f(listE, (View) arrayList.get(i10));
        }
        listE.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16511b;

        public b(View view, ArrayList arrayList) {
            this.f16510a = view;
            this.f16511b = arrayList;
        }

        @Override // n2.l.f
        public void b(l lVar) {
            lVar.R(this);
            lVar.a(this);
        }

        @Override // n2.l.f
        public void d(l lVar) {
            lVar.R(this);
            this.f16510a.setVisibility(8);
            int size = this.f16511b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f16511b.get(i10)).setVisibility(0);
            }
        }

        @Override // n2.l.f
        public void a(l lVar) {
        }

        @Override // n2.l.f
        public void c(l lVar) {
        }

        @Override // n2.l.f
        public void e(l lVar) {
        }
    }

    /* JADX INFO: renamed from: n2.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0295e implements l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f16522a;

        public C0295e(Runnable runnable) {
            this.f16522a = runnable;
        }

        @Override // n2.l.f
        public void d(l lVar) {
            this.f16522a.run();
        }

        @Override // n2.l.f
        public void a(l lVar) {
        }

        @Override // n2.l.f
        public void b(l lVar) {
        }

        @Override // n2.l.f
        public void c(l lVar) {
        }

        @Override // n2.l.f
        public void e(l lVar) {
        }
    }
}
