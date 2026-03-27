package I0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.C2736a;
import u.C2739d;

/* JADX INFO: renamed from: I0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0571l implements Cloneable {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final int[] f2794F = {2, 1, 3, 4};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final AbstractC0566g f2795G = new a();

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static ThreadLocal f2796H = new ThreadLocal();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f2799C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public C2736a f2800D;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f2821t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f2822u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2802a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2803b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2804c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f2805d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f2806e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f2807f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f2808g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f2809h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f2810i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f2811j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f2812k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f2813l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f2814m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f2815n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f2816o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f2817p = new t();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t f2818q = new t();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0575p f2819r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f2820s = f2794F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2823v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f2824w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2825x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2826y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2827z = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ArrayList f2797A = null;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ArrayList f2798B = new ArrayList();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public AbstractC0566g f2801E = f2795G;

    /* JADX INFO: renamed from: I0.l$a */
    public class a extends AbstractC0566g {
        @Override // I0.AbstractC0566g
        public Path a(float f7, float f8, float f9, float f10) {
            Path path = new Path();
            path.moveTo(f7, f8);
            path.lineTo(f9, f10);
            return path;
        }
    }

    /* JADX INFO: renamed from: I0.l$b */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2736a f2828a;

        public b(C2736a c2736a) {
            this.f2828a = c2736a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2828a.remove(animator);
            AbstractC0571l.this.f2824w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC0571l.this.f2824w.add(animator);
        }
    }

    /* JADX INFO: renamed from: I0.l$c */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC0571l.this.p();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: renamed from: I0.l$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f2831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f2833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public P f2834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbstractC0571l f2835e;

        public d(View view, String str, AbstractC0571l abstractC0571l, P p7, s sVar) {
            this.f2831a = view;
            this.f2832b = str;
            this.f2833c = sVar;
            this.f2834d = p7;
            this.f2835e = abstractC0571l;
        }
    }

    /* JADX INFO: renamed from: I0.l$e */
    public static abstract class e {
    }

    /* JADX INFO: renamed from: I0.l$f */
    public interface f {
        void a(AbstractC0571l abstractC0571l);

        void b(AbstractC0571l abstractC0571l);

        void c(AbstractC0571l abstractC0571l);

        void d(AbstractC0571l abstractC0571l);

        void e(AbstractC0571l abstractC0571l);
    }

    public static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.f2854a.get(str);
        Object obj2 = sVar2.f2854a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void d(t tVar, View view, s sVar) {
        tVar.f2857a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f2858b.indexOfKey(id) >= 0) {
                tVar.f2858b.put(id, null);
            } else {
                tVar.f2858b.put(id, view);
            }
        }
        String strH = Q.N.H(view);
        if (strH != null) {
            if (tVar.f2860d.containsKey(strH)) {
                tVar.f2860d.put(strH, null);
            } else {
                tVar.f2860d.put(strH, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f2859c.f(itemIdAtPosition) < 0) {
                    Q.N.u0(view, true);
                    tVar.f2859c.i(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.f2859c.d(itemIdAtPosition);
                if (view2 != null) {
                    Q.N.u0(view2, false);
                    tVar.f2859c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    public static C2736a x() {
        C2736a c2736a = (C2736a) f2796H.get();
        if (c2736a != null) {
            return c2736a;
        }
        C2736a c2736a2 = new C2736a();
        f2796H.set(c2736a2);
        return c2736a2;
    }

    public List A() {
        return this.f2808g;
    }

    public List B() {
        return this.f2809h;
    }

    public List C() {
        return this.f2807f;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z7) {
        C0575p c0575p = this.f2819r;
        if (c0575p != null) {
            return c0575p.E(view, z7);
        }
        return (s) (z7 ? this.f2817p : this.f2818q).f2857a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrD = D();
        if (strArrD == null) {
            Iterator it = sVar.f2854a.keySet().iterator();
            while (it.hasNext()) {
                if (H(sVar, sVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrD) {
            if (!H(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean G(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f2810i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f2811j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f2812k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (((Class) this.f2812k.get(i7)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f2813l != null && Q.N.H(view) != null && this.f2813l.contains(Q.N.H(view))) {
            return false;
        }
        if ((this.f2806e.size() == 0 && this.f2807f.size() == 0 && (((arrayList = this.f2809h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f2808g) == null || arrayList2.isEmpty()))) || this.f2806e.contains(Integer.valueOf(id)) || this.f2807f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f2808g;
        if (arrayList6 != null && arrayList6.contains(Q.N.H(view))) {
            return true;
        }
        if (this.f2809h != null) {
            for (int i8 = 0; i8 < this.f2809h.size(); i8++) {
                if (((Class) this.f2809h.get(i8)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void I(C2736a c2736a, C2736a c2736a2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) sparseArray.valueAt(i7);
            if (view2 != null && G(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i7))) != null && G(view)) {
                s sVar = (s) c2736a.get(view2);
                s sVar2 = (s) c2736a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f2821t.add(sVar);
                    this.f2822u.add(sVar2);
                    c2736a.remove(view2);
                    c2736a2.remove(view);
                }
            }
        }
    }

    public final void J(C2736a c2736a, C2736a c2736a2) {
        s sVar;
        for (int size = c2736a.size() - 1; size >= 0; size--) {
            View view = (View) c2736a.j(size);
            if (view != null && G(view) && (sVar = (s) c2736a2.remove(view)) != null && G(sVar.f2855b)) {
                this.f2821t.add((s) c2736a.l(size));
                this.f2822u.add(sVar);
            }
        }
    }

    public final void K(C2736a c2736a, C2736a c2736a2, C2739d c2739d, C2739d c2739d2) {
        View view;
        int iL = c2739d.l();
        for (int i7 = 0; i7 < iL; i7++) {
            View view2 = (View) c2739d.m(i7);
            if (view2 != null && G(view2) && (view = (View) c2739d2.d(c2739d.g(i7))) != null && G(view)) {
                s sVar = (s) c2736a.get(view2);
                s sVar2 = (s) c2736a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f2821t.add(sVar);
                    this.f2822u.add(sVar2);
                    c2736a.remove(view2);
                    c2736a2.remove(view);
                }
            }
        }
    }

    public final void L(C2736a c2736a, C2736a c2736a2, C2736a c2736a3, C2736a c2736a4) {
        View view;
        int size = c2736a3.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) c2736a3.n(i7);
            if (view2 != null && G(view2) && (view = (View) c2736a4.get(c2736a3.j(i7))) != null && G(view)) {
                s sVar = (s) c2736a.get(view2);
                s sVar2 = (s) c2736a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f2821t.add(sVar);
                    this.f2822u.add(sVar2);
                    c2736a.remove(view2);
                    c2736a2.remove(view);
                }
            }
        }
    }

    public final void M(t tVar, t tVar2) {
        C2736a c2736a = new C2736a(tVar.f2857a);
        C2736a c2736a2 = new C2736a(tVar2.f2857a);
        int i7 = 0;
        while (true) {
            int[] iArr = this.f2820s;
            if (i7 >= iArr.length) {
                c(c2736a, c2736a2);
                return;
            }
            int i8 = iArr[i7];
            if (i8 == 1) {
                J(c2736a, c2736a2);
            } else if (i8 == 2) {
                L(c2736a, c2736a2, tVar.f2860d, tVar2.f2860d);
            } else if (i8 == 3) {
                I(c2736a, c2736a2, tVar.f2858b, tVar2.f2858b);
            } else if (i8 == 4) {
                K(c2736a, c2736a2, tVar.f2859c, tVar2.f2859c);
            }
            i7++;
        }
    }

    public void N(View view) {
        if (this.f2827z) {
            return;
        }
        for (int size = this.f2824w.size() - 1; size >= 0; size--) {
            AbstractC0560a.b((Animator) this.f2824w.get(size));
        }
        ArrayList arrayList = this.f2797A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f2797A.clone();
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((f) arrayList2.get(i7)).a(this);
            }
        }
        this.f2826y = true;
    }

    public void O(ViewGroup viewGroup) {
        d dVar;
        this.f2821t = new ArrayList();
        this.f2822u = new ArrayList();
        M(this.f2817p, this.f2818q);
        C2736a c2736aX = x();
        int size = c2736aX.size();
        P pD = A.d(viewGroup);
        for (int i7 = size - 1; i7 >= 0; i7--) {
            Animator animator = (Animator) c2736aX.j(i7);
            if (animator != null && (dVar = (d) c2736aX.get(animator)) != null && dVar.f2831a != null && pD.equals(dVar.f2834d)) {
                s sVar = dVar.f2833c;
                View view = dVar.f2831a;
                s sVarE = E(view, true);
                s sVarT = t(view, true);
                if (sVarE == null && sVarT == null) {
                    sVarT = (s) this.f2818q.f2857a.get(view);
                }
                if ((sVarE != null || sVarT != null) && dVar.f2835e.F(sVar, sVarT)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        c2736aX.remove(animator);
                    }
                }
            }
        }
        o(viewGroup, this.f2817p, this.f2818q, this.f2821t, this.f2822u);
        T();
    }

    public AbstractC0571l P(f fVar) {
        ArrayList arrayList = this.f2797A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.f2797A.size() == 0) {
            this.f2797A = null;
        }
        return this;
    }

    public AbstractC0571l Q(View view) {
        this.f2807f.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.f2826y) {
            if (!this.f2827z) {
                for (int size = this.f2824w.size() - 1; size >= 0; size--) {
                    AbstractC0560a.c((Animator) this.f2824w.get(size));
                }
                ArrayList arrayList = this.f2797A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f2797A.clone();
                    int size2 = arrayList2.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        ((f) arrayList2.get(i7)).b(this);
                    }
                }
            }
            this.f2826y = false;
        }
    }

    public final void S(Animator animator, C2736a c2736a) {
        if (animator != null) {
            animator.addListener(new b(c2736a));
            e(animator);
        }
    }

    public void T() {
        a0();
        C2736a c2736aX = x();
        for (Animator animator : this.f2798B) {
            if (c2736aX.containsKey(animator)) {
                a0();
                S(animator, c2736aX);
            }
        }
        this.f2798B.clear();
        p();
    }

    public AbstractC0571l U(long j7) {
        this.f2804c = j7;
        return this;
    }

    public void V(e eVar) {
        this.f2799C = eVar;
    }

    public AbstractC0571l W(TimeInterpolator timeInterpolator) {
        this.f2805d = timeInterpolator;
        return this;
    }

    public void X(AbstractC0566g abstractC0566g) {
        if (abstractC0566g == null) {
            this.f2801E = f2795G;
        } else {
            this.f2801E = abstractC0566g;
        }
    }

    public AbstractC0571l Z(long j7) {
        this.f2803b = j7;
        return this;
    }

    public AbstractC0571l a(f fVar) {
        if (this.f2797A == null) {
            this.f2797A = new ArrayList();
        }
        this.f2797A.add(fVar);
        return this;
    }

    public void a0() {
        if (this.f2825x == 0) {
            ArrayList arrayList = this.f2797A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2797A.clone();
                int size = arrayList2.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((f) arrayList2.get(i7)).c(this);
                }
            }
            this.f2827z = false;
        }
        this.f2825x++;
    }

    public AbstractC0571l b(View view) {
        this.f2807f.add(view);
        return this;
    }

    public String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2804c != -1) {
            str2 = str2 + "dur(" + this.f2804c + ") ";
        }
        if (this.f2803b != -1) {
            str2 = str2 + "dly(" + this.f2803b + ") ";
        }
        if (this.f2805d != null) {
            str2 = str2 + "interp(" + this.f2805d + ") ";
        }
        if (this.f2806e.size() <= 0 && this.f2807f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f2806e.size() > 0) {
            for (int i7 = 0; i7 < this.f2806e.size(); i7++) {
                if (i7 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2806e.get(i7);
            }
        }
        if (this.f2807f.size() > 0) {
            for (int i8 = 0; i8 < this.f2807f.size(); i8++) {
                if (i8 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2807f.get(i8);
            }
        }
        return str3 + ")";
    }

    public final void c(C2736a c2736a, C2736a c2736a2) {
        for (int i7 = 0; i7 < c2736a.size(); i7++) {
            s sVar = (s) c2736a.n(i7);
            if (G(sVar.f2855b)) {
                this.f2821t.add(sVar);
                this.f2822u.add(null);
            }
        }
        for (int i8 = 0; i8 < c2736a2.size(); i8++) {
            s sVar2 = (s) c2736a2.n(i8);
            if (G(sVar2.f2855b)) {
                this.f2822u.add(sVar2);
                this.f2821t.add(null);
            }
        }
    }

    public void cancel() {
        for (int size = this.f2824w.size() - 1; size >= 0; size--) {
            ((Animator) this.f2824w.get(size)).cancel();
        }
        ArrayList arrayList = this.f2797A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.f2797A.clone();
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ((f) arrayList2.get(i7)).d(this);
        }
    }

    public void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void f(s sVar);

    public final void g(View view, boolean z7) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f2810i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f2811j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f2812k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (((Class) this.f2812k.get(i7)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z7) {
                        j(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f2856c.add(this);
                    i(sVar);
                    if (z7) {
                        d(this.f2817p, view, sVar);
                    } else {
                        d(this.f2818q, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f2814m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f2815n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f2816o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    if (((Class) this.f2816o.get(i8)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                                g(viewGroup.getChildAt(i9), z7);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void j(s sVar);

    public void k(ViewGroup viewGroup, boolean z7) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C2736a c2736a;
        l(z7);
        if ((this.f2806e.size() > 0 || this.f2807f.size() > 0) && (((arrayList = this.f2808g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f2809h) == null || arrayList2.isEmpty()))) {
            for (int i7 = 0; i7 < this.f2806e.size(); i7++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f2806e.get(i7)).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z7) {
                        j(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f2856c.add(this);
                    i(sVar);
                    if (z7) {
                        d(this.f2817p, viewFindViewById, sVar);
                    } else {
                        d(this.f2818q, viewFindViewById, sVar);
                    }
                }
            }
            for (int i8 = 0; i8 < this.f2807f.size(); i8++) {
                View view = (View) this.f2807f.get(i8);
                s sVar2 = new s(view);
                if (z7) {
                    j(sVar2);
                } else {
                    f(sVar2);
                }
                sVar2.f2856c.add(this);
                i(sVar2);
                if (z7) {
                    d(this.f2817p, view, sVar2);
                } else {
                    d(this.f2818q, view, sVar2);
                }
            }
        } else {
            g(viewGroup, z7);
        }
        if (z7 || (c2736a = this.f2800D) == null) {
            return;
        }
        int size = c2736a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i9 = 0; i9 < size; i9++) {
            arrayList3.add(this.f2817p.f2860d.remove((String) this.f2800D.j(i9)));
        }
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) arrayList3.get(i10);
            if (view2 != null) {
                this.f2817p.f2860d.put((String) this.f2800D.n(i10), view2);
            }
        }
    }

    public void l(boolean z7) {
        if (z7) {
            this.f2817p.f2857a.clear();
            this.f2817p.f2858b.clear();
            this.f2817p.f2859c.a();
        } else {
            this.f2818q.f2857a.clear();
            this.f2818q.f2858b.clear();
            this.f2818q.f2859c.a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: m */
    public AbstractC0571l clone() {
        try {
            AbstractC0571l abstractC0571l = (AbstractC0571l) super.clone();
            abstractC0571l.f2798B = new ArrayList();
            abstractC0571l.f2817p = new t();
            abstractC0571l.f2818q = new t();
            abstractC0571l.f2821t = null;
            abstractC0571l.f2822u = null;
            return abstractC0571l;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        s sVar;
        int i7;
        Animator animator2;
        s sVar2;
        C2736a c2736aX = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            s sVar3 = (s) arrayList.get(i8);
            s sVar4 = (s) arrayList2.get(i8);
            if (sVar3 != null && !sVar3.f2856c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f2856c.contains(this)) {
                sVar4 = null;
            }
            if ((sVar3 != null || sVar4 != null) && (sVar3 == null || sVar4 == null || F(sVar3, sVar4))) {
                Animator animatorN = n(viewGroup, sVar3, sVar4);
                if (animatorN != null) {
                    if (sVar4 != null) {
                        View view2 = sVar4.f2855b;
                        String[] strArrD = D();
                        if (strArrD != null && strArrD.length > 0) {
                            sVar2 = new s(view2);
                            s sVar5 = (s) tVar2.f2857a.get(view2);
                            if (sVar5 != null) {
                                int i9 = 0;
                                while (i9 < strArrD.length) {
                                    Map map = sVar2.f2854a;
                                    Animator animator3 = animatorN;
                                    String str = strArrD[i9];
                                    map.put(str, sVar5.f2854a.get(str));
                                    i9++;
                                    animatorN = animator3;
                                    strArrD = strArrD;
                                }
                            }
                            Animator animator4 = animatorN;
                            int size2 = c2736aX.size();
                            int i10 = 0;
                            while (true) {
                                if (i10 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) c2736aX.get((Animator) c2736aX.j(i10));
                                if (dVar.f2833c != null && dVar.f2831a == view2 && dVar.f2832b.equals(u()) && dVar.f2833c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i10++;
                            }
                        } else {
                            animator2 = animatorN;
                            sVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        view = sVar3.f2855b;
                        animator = animatorN;
                        sVar = null;
                    }
                    if (animator != null) {
                        i7 = size;
                        c2736aX.put(animator, new d(view, u(), this, A.d(viewGroup), sVar));
                        this.f2798B.add(animator);
                    }
                    i8++;
                    size = i7;
                }
                i7 = size;
                i8++;
                size = i7;
            }
            i7 = size;
            i8++;
            size = i7;
        }
        if (sparseIntArray.size() != 0) {
            for (int i11 = 0; i11 < sparseIntArray.size(); i11++) {
                Animator animator5 = (Animator) this.f2798B.get(sparseIntArray.keyAt(i11));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i11)) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    public void p() {
        int i7 = this.f2825x - 1;
        this.f2825x = i7;
        if (i7 == 0) {
            ArrayList arrayList = this.f2797A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2797A.clone();
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((f) arrayList2.get(i8)).e(this);
                }
            }
            for (int i9 = 0; i9 < this.f2817p.f2859c.l(); i9++) {
                View view = (View) this.f2817p.f2859c.m(i9);
                if (view != null) {
                    Q.N.u0(view, false);
                }
            }
            for (int i10 = 0; i10 < this.f2818q.f2859c.l(); i10++) {
                View view2 = (View) this.f2818q.f2859c.m(i10);
                if (view2 != null) {
                    Q.N.u0(view2, false);
                }
            }
            this.f2827z = true;
        }
    }

    public long q() {
        return this.f2804c;
    }

    public e r() {
        return this.f2799C;
    }

    public TimeInterpolator s() {
        return this.f2805d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f2822u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f2821t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (I0.s) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public I0.s t(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            I0.p r0 = r5.f2819r
            if (r0 == 0) goto L9
            I0.s r6 = r0.t(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f2821t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f2822u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            I0.s r4 = (I0.s) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f2855b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.f2822u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f2821t
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            I0.s r1 = (I0.s) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: I0.AbstractC0571l.t(android.view.View, boolean):I0.s");
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.f2802a;
    }

    public AbstractC0566g v() {
        return this.f2801E;
    }

    public AbstractC0574o w() {
        return null;
    }

    public long y() {
        return this.f2803b;
    }

    public List z() {
        return this.f2806e;
    }

    public void Y(AbstractC0574o abstractC0574o) {
    }

    public void i(s sVar) {
    }
}
