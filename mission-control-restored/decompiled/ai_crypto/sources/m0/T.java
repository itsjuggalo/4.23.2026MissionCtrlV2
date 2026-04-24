package m0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class T {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f18676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f18677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f18678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f18679e;

        public a(int i7, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f18675a = i7;
            this.f18676b = arrayList;
            this.f18677c = arrayList2;
            this.f18678d = arrayList3;
            this.f18679e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i7 = 0; i7 < this.f18675a; i7++) {
                Q.N.C0((View) this.f18676b.get(i7), (String) this.f18677c.get(i7));
                Q.N.C0((View) this.f18678d.get(i7), (String) this.f18679e.get(i7));
            }
        }
    }

    public static void f(List list, View view) {
        int size = list.size();
        if (i(list, view, size)) {
            return;
        }
        if (Q.N.H(view) != null) {
            list.add(view);
        }
        for (int i7 = size; i7 < list.size(); i7++) {
            View view2 = (View) list.get(i7);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = viewGroup.getChildAt(i8);
                    if (!i(list, childAt, size) && Q.N.H(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean i(List list, View view, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (list.get(i8) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void e(ViewGroup viewGroup, Object obj);

    public abstract boolean g(Object obj);

    public abstract Object h(Object obj);

    public Object j(ViewGroup viewGroup, Object obj) {
        return null;
    }

    public void k(View view, Rect rect) {
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public boolean m() {
        if (!AbstractC2190H.I0(4)) {
            return false;
        }
        Log.i("FragmentManager", "Older versions of AndroidX Transition do not support seeking. Add dependency on AndroidX Transition 1.5.0 or higher to enable seeking.");
        return false;
    }

    public boolean n(Object obj) {
        return false;
    }

    public abstract Object o(Object obj, Object obj2, Object obj3);

    public abstract Object p(Object obj, Object obj2, Object obj3);

    public ArrayList q(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            arrayList2.add(Q.N.H(view));
            Q.N.C0(view, null);
        }
        return arrayList2;
    }

    public abstract void r(Object obj, View view, ArrayList arrayList);

    public abstract void s(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public abstract void w(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, Object obj, M.e eVar, Runnable runnable);

    public void x(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, Object obj, M.e eVar, Runnable runnable, Runnable runnable2) {
        runnable2.run();
    }

    public void y(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) arrayList.get(i7);
            String strH = Q.N.H(view2);
            arrayList4.add(strH);
            if (strH != null) {
                Q.N.C0(view2, null);
                String str = (String) map.get(strH);
                int i8 = 0;
                while (true) {
                    if (i8 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i8))) {
                        Q.N.C0((View) arrayList2.get(i8), strH);
                        break;
                    }
                    i8++;
                }
            }
        }
        Q.I.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList arrayList);

    public void c(Object obj) {
    }

    public void d(Object obj, Runnable runnable) {
    }

    public void t(Object obj, float f7) {
    }
}
