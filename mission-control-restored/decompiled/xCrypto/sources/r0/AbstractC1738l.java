package r0;

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
import u.C1853a;
import u.C1856d;

/* JADX INFO: renamed from: r0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1738l implements Cloneable {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final int[] f14410F = {2, 1, 3, 4};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final AbstractC1733g f14411G = new a();

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static ThreadLocal f14412H = new ThreadLocal();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f14415C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public C1853a f14416D;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f14437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f14438u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14418a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14419b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14420c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f14421d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f14422e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f14423f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f14424g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f14425h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f14426i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f14427j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f14428k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f14429l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f14430m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f14431n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f14432o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f14433p = new t();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t f14434q = new t();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C1742p f14435r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f14436s = f14410F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14439v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f14440w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14441x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14442y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14443z = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ArrayList f14413A = null;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ArrayList f14414B = new ArrayList();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public AbstractC1733g f14417E = f14411G;

    /* JADX INFO: renamed from: r0.l$a */
    public class a extends AbstractC1733g {
        @Override // r0.AbstractC1733g
        public Path a(float f4, float f5, float f6, float f7) {
            Path path = new Path();
            path.moveTo(f4, f5);
            path.lineTo(f6, f7);
            return path;
        }
    }

    /* JADX INFO: renamed from: r0.l$b */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1853a f14444a;

        public b(C1853a c1853a) {
            this.f14444a = c1853a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f14444a.remove(animator);
            AbstractC1738l.this.f14440w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC1738l.this.f14440w.add(animator);
        }
    }

    /* JADX INFO: renamed from: r0.l$c */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC1738l.this.p();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: renamed from: r0.l$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f14447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f14449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public P f14450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbstractC1738l f14451e;

        public d(View view, String str, AbstractC1738l abstractC1738l, P p4, s sVar) {
            this.f14447a = view;
            this.f14448b = str;
            this.f14449c = sVar;
            this.f14450d = p4;
            this.f14451e = abstractC1738l;
        }
    }

    /* JADX INFO: renamed from: r0.l$e */
    public static abstract class e {
    }

    /* JADX INFO: renamed from: r0.l$f */
    public interface f {
        void a(AbstractC1738l abstractC1738l);

        void b(AbstractC1738l abstractC1738l);

        void c(AbstractC1738l abstractC1738l);

        void d(AbstractC1738l abstractC1738l);

        void e(AbstractC1738l abstractC1738l);
    }

    public static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.f14470a.get(str);
        Object obj2 = sVar2.f14470a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void d(t tVar, View view, s sVar) {
        tVar.f14473a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f14474b.indexOfKey(id) >= 0) {
                tVar.f14474b.put(id, null);
            } else {
                tVar.f14474b.put(id, view);
            }
        }
        String strS = H.E.s(view);
        if (strS != null) {
            if (tVar.f14476d.containsKey(strS)) {
                tVar.f14476d.put(strS, null);
            } else {
                tVar.f14476d.put(strS, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f14475c.g(itemIdAtPosition) < 0) {
                    H.E.M(view, true);
                    tVar.f14475c.i(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.f14475c.e(itemIdAtPosition);
                if (view2 != null) {
                    H.E.M(view2, false);
                    tVar.f14475c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    public static C1853a x() {
        C1853a c1853a = (C1853a) f14412H.get();
        if (c1853a != null) {
            return c1853a;
        }
        C1853a c1853a2 = new C1853a();
        f14412H.set(c1853a2);
        return c1853a2;
    }

    public List A() {
        return this.f14424g;
    }

    public List B() {
        return this.f14425h;
    }

    public List C() {
        return this.f14423f;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z4) {
        C1742p c1742p = this.f14435r;
        if (c1742p != null) {
            return c1742p.E(view, z4);
        }
        return (s) (z4 ? this.f14433p : this.f14434q).f14473a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar != null && sVar2 != null) {
            String[] strArrD = D();
            if (strArrD != null) {
                for (String str : strArrD) {
                    if (H(sVar, sVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = sVar.f14470a.keySet().iterator();
                while (it.hasNext()) {
                    if (H(sVar, sVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean G(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f14426i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f14427j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f14428k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((Class) this.f14428k.get(i4)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f14429l != null && H.E.s(view) != null && this.f14429l.contains(H.E.s(view))) {
            return false;
        }
        if ((this.f14422e.size() == 0 && this.f14423f.size() == 0 && (((arrayList = this.f14425h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f14424g) == null || arrayList2.isEmpty()))) || this.f14422e.contains(Integer.valueOf(id)) || this.f14423f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f14424g;
        if (arrayList6 != null && arrayList6.contains(H.E.s(view))) {
            return true;
        }
        if (this.f14425h != null) {
            for (int i5 = 0; i5 < this.f14425h.size(); i5++) {
                if (((Class) this.f14425h.get(i5)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void I(C1853a c1853a, C1853a c1853a2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) sparseArray.valueAt(i4);
            if (view2 != null && G(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i4))) != null && G(view)) {
                s sVar = (s) c1853a.get(view2);
                s sVar2 = (s) c1853a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f14437t.add(sVar);
                    this.f14438u.add(sVar2);
                    c1853a.remove(view2);
                    c1853a2.remove(view);
                }
            }
        }
    }

    public final void J(C1853a c1853a, C1853a c1853a2) {
        s sVar;
        for (int size = c1853a.size() - 1; size >= 0; size--) {
            View view = (View) c1853a.j(size);
            if (view != null && G(view) && (sVar = (s) c1853a2.remove(view)) != null && G(sVar.f14471b)) {
                this.f14437t.add((s) c1853a.l(size));
                this.f14438u.add(sVar);
            }
        }
    }

    public final void K(C1853a c1853a, C1853a c1853a2, C1856d c1856d, C1856d c1856d2) {
        View view;
        int iK = c1856d.k();
        for (int i4 = 0; i4 < iK; i4++) {
            View view2 = (View) c1856d.l(i4);
            if (view2 != null && G(view2) && (view = (View) c1856d2.e(c1856d.h(i4))) != null && G(view)) {
                s sVar = (s) c1853a.get(view2);
                s sVar2 = (s) c1853a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f14437t.add(sVar);
                    this.f14438u.add(sVar2);
                    c1853a.remove(view2);
                    c1853a2.remove(view);
                }
            }
        }
    }

    public final void L(C1853a c1853a, C1853a c1853a2, C1853a c1853a3, C1853a c1853a4) {
        View view;
        int size = c1853a3.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) c1853a3.n(i4);
            if (view2 != null && G(view2) && (view = (View) c1853a4.get(c1853a3.j(i4))) != null && G(view)) {
                s sVar = (s) c1853a.get(view2);
                s sVar2 = (s) c1853a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f14437t.add(sVar);
                    this.f14438u.add(sVar2);
                    c1853a.remove(view2);
                    c1853a2.remove(view);
                }
            }
        }
    }

    public final void M(t tVar, t tVar2) {
        C1853a c1853a = new C1853a(tVar.f14473a);
        C1853a c1853a2 = new C1853a(tVar2.f14473a);
        int i4 = 0;
        while (true) {
            int[] iArr = this.f14436s;
            if (i4 >= iArr.length) {
                c(c1853a, c1853a2);
                return;
            }
            int i5 = iArr[i4];
            if (i5 == 1) {
                J(c1853a, c1853a2);
            } else if (i5 == 2) {
                L(c1853a, c1853a2, tVar.f14476d, tVar2.f14476d);
            } else if (i5 == 3) {
                I(c1853a, c1853a2, tVar.f14474b, tVar2.f14474b);
            } else if (i5 == 4) {
                K(c1853a, c1853a2, tVar.f14475c, tVar2.f14475c);
            }
            i4++;
        }
    }

    public void N(View view) {
        if (this.f14443z) {
            return;
        }
        for (int size = this.f14440w.size() - 1; size >= 0; size--) {
            AbstractC1727a.b((Animator) this.f14440w.get(size));
        }
        ArrayList arrayList = this.f14413A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f14413A.clone();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((f) arrayList2.get(i4)).a(this);
            }
        }
        this.f14442y = true;
    }

    public void O(ViewGroup viewGroup) {
        d dVar;
        this.f14437t = new ArrayList();
        this.f14438u = new ArrayList();
        M(this.f14433p, this.f14434q);
        C1853a c1853aX = x();
        int size = c1853aX.size();
        P pD = AbstractC1726A.d(viewGroup);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            Animator animator = (Animator) c1853aX.j(i4);
            if (animator != null && (dVar = (d) c1853aX.get(animator)) != null && dVar.f14447a != null && pD.equals(dVar.f14450d)) {
                s sVar = dVar.f14449c;
                View view = dVar.f14447a;
                s sVarE = E(view, true);
                s sVarT = t(view, true);
                if (sVarE == null && sVarT == null) {
                    sVarT = (s) this.f14434q.f14473a.get(view);
                }
                if ((sVarE != null || sVarT != null) && dVar.f14451e.F(sVar, sVarT)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        c1853aX.remove(animator);
                    }
                }
            }
        }
        o(viewGroup, this.f14433p, this.f14434q, this.f14437t, this.f14438u);
        T();
    }

    public AbstractC1738l P(f fVar) {
        ArrayList arrayList = this.f14413A;
        if (arrayList != null) {
            arrayList.remove(fVar);
            if (this.f14413A.size() == 0) {
                this.f14413A = null;
            }
        }
        return this;
    }

    public AbstractC1738l Q(View view) {
        this.f14423f.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.f14442y) {
            if (!this.f14443z) {
                for (int size = this.f14440w.size() - 1; size >= 0; size--) {
                    AbstractC1727a.c((Animator) this.f14440w.get(size));
                }
                ArrayList arrayList = this.f14413A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f14413A.clone();
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((f) arrayList2.get(i4)).d(this);
                    }
                }
            }
            this.f14442y = false;
        }
    }

    public final void S(Animator animator, C1853a c1853a) {
        if (animator != null) {
            animator.addListener(new b(c1853a));
            e(animator);
        }
    }

    public void T() {
        a0();
        C1853a c1853aX = x();
        for (Animator animator : this.f14414B) {
            if (c1853aX.containsKey(animator)) {
                a0();
                S(animator, c1853aX);
            }
        }
        this.f14414B.clear();
        p();
    }

    public AbstractC1738l U(long j4) {
        this.f14420c = j4;
        return this;
    }

    public void V(e eVar) {
        this.f14415C = eVar;
    }

    public AbstractC1738l W(TimeInterpolator timeInterpolator) {
        this.f14421d = timeInterpolator;
        return this;
    }

    public void X(AbstractC1733g abstractC1733g) {
        if (abstractC1733g == null) {
            this.f14417E = f14411G;
        } else {
            this.f14417E = abstractC1733g;
        }
    }

    public AbstractC1738l Z(long j4) {
        this.f14419b = j4;
        return this;
    }

    public AbstractC1738l a(f fVar) {
        if (this.f14413A == null) {
            this.f14413A = new ArrayList();
        }
        this.f14413A.add(fVar);
        return this;
    }

    public void a0() {
        if (this.f14441x == 0) {
            ArrayList arrayList = this.f14413A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f14413A.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((f) arrayList2.get(i4)).e(this);
                }
            }
            this.f14443z = false;
        }
        this.f14441x++;
    }

    public AbstractC1738l b(View view) {
        this.f14423f.add(view);
        return this;
    }

    public String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f14420c != -1) {
            str2 = str2 + "dur(" + this.f14420c + ") ";
        }
        if (this.f14419b != -1) {
            str2 = str2 + "dly(" + this.f14419b + ") ";
        }
        if (this.f14421d != null) {
            str2 = str2 + "interp(" + this.f14421d + ") ";
        }
        if (this.f14422e.size() <= 0 && this.f14423f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f14422e.size() > 0) {
            for (int i4 = 0; i4 < this.f14422e.size(); i4++) {
                if (i4 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f14422e.get(i4);
            }
        }
        if (this.f14423f.size() > 0) {
            for (int i5 = 0; i5 < this.f14423f.size(); i5++) {
                if (i5 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f14423f.get(i5);
            }
        }
        return str3 + ")";
    }

    public final void c(C1853a c1853a, C1853a c1853a2) {
        for (int i4 = 0; i4 < c1853a.size(); i4++) {
            s sVar = (s) c1853a.n(i4);
            if (G(sVar.f14471b)) {
                this.f14437t.add(sVar);
                this.f14438u.add(null);
            }
        }
        for (int i5 = 0; i5 < c1853a2.size(); i5++) {
            s sVar2 = (s) c1853a2.n(i5);
            if (G(sVar2.f14471b)) {
                this.f14438u.add(sVar2);
                this.f14437t.add(null);
            }
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

    public void f() {
        for (int size = this.f14440w.size() - 1; size >= 0; size--) {
            ((Animator) this.f14440w.get(size)).cancel();
        }
        ArrayList arrayList = this.f14413A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.f14413A.clone();
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((f) arrayList2.get(i4)).c(this);
        }
    }

    public abstract void g(s sVar);

    public final void h(View view, boolean z4) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f14426i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f14427j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f14428k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (((Class) this.f14428k.get(i4)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z4) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f14472c.add(this);
                    i(sVar);
                    if (z4) {
                        d(this.f14433p, view, sVar);
                    } else {
                        d(this.f14434q, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f14430m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f14431n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f14432o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    if (((Class) this.f14432o.get(i5)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                                h(viewGroup.getChildAt(i6), z4);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void j(s sVar);

    public void k(ViewGroup viewGroup, boolean z4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C1853a c1853a;
        l(z4);
        if ((this.f14422e.size() > 0 || this.f14423f.size() > 0) && (((arrayList = this.f14424g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f14425h) == null || arrayList2.isEmpty()))) {
            for (int i4 = 0; i4 < this.f14422e.size(); i4++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f14422e.get(i4)).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z4) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f14472c.add(this);
                    i(sVar);
                    if (z4) {
                        d(this.f14433p, viewFindViewById, sVar);
                    } else {
                        d(this.f14434q, viewFindViewById, sVar);
                    }
                }
            }
            for (int i5 = 0; i5 < this.f14423f.size(); i5++) {
                View view = (View) this.f14423f.get(i5);
                s sVar2 = new s(view);
                if (z4) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.f14472c.add(this);
                i(sVar2);
                if (z4) {
                    d(this.f14433p, view, sVar2);
                } else {
                    d(this.f14434q, view, sVar2);
                }
            }
        } else {
            h(viewGroup, z4);
        }
        if (z4 || (c1853a = this.f14416D) == null) {
            return;
        }
        int size = c1853a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            arrayList3.add(this.f14433p.f14476d.remove((String) this.f14416D.j(i6)));
        }
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) arrayList3.get(i7);
            if (view2 != null) {
                this.f14433p.f14476d.put((String) this.f14416D.n(i7), view2);
            }
        }
    }

    public void l(boolean z4) {
        if (z4) {
            this.f14433p.f14473a.clear();
            this.f14433p.f14474b.clear();
            this.f14433p.f14475c.a();
        } else {
            this.f14434q.f14473a.clear();
            this.f14434q.f14474b.clear();
            this.f14434q.f14475c.a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: m */
    public AbstractC1738l clone() {
        try {
            AbstractC1738l abstractC1738l = (AbstractC1738l) super.clone();
            abstractC1738l.f14414B = new ArrayList();
            abstractC1738l.f14433p = new t();
            abstractC1738l.f14434q = new t();
            abstractC1738l.f14437t = null;
            abstractC1738l.f14438u = null;
            return abstractC1738l;
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
        View view2;
        Animator animator2;
        C1853a c1853aX = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            s sVar2 = (s) arrayList.get(i4);
            s sVar3 = (s) arrayList2.get(i4);
            if (sVar2 != null && !sVar2.f14472c.contains(this)) {
                sVar2 = null;
            }
            if (sVar3 != null && !sVar3.f14472c.contains(this)) {
                sVar3 = null;
            }
            if ((sVar2 != null || sVar3 != null) && (sVar2 == null || sVar3 == null || F(sVar2, sVar3))) {
                Animator animatorN = n(viewGroup, sVar2, sVar3);
                if (animatorN != null) {
                    if (sVar3 != null) {
                        View view3 = sVar3.f14471b;
                        String[] strArrD = D();
                        if (strArrD != null && strArrD.length > 0) {
                            sVar = new s(view3);
                            s sVar4 = (s) tVar2.f14473a.get(view3);
                            if (sVar4 != null) {
                                int i5 = 0;
                                while (i5 < strArrD.length) {
                                    Map map = sVar.f14470a;
                                    String[] strArr = strArrD;
                                    String str = strArr[i5];
                                    map.put(str, sVar4.f14470a.get(str));
                                    i5++;
                                    strArrD = strArr;
                                }
                            }
                            int size2 = c1853aX.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    view2 = view3;
                                    animator2 = animatorN;
                                    break;
                                }
                                d dVar = (d) c1853aX.get((Animator) c1853aX.j(i6));
                                if (dVar.f14449c != null && dVar.f14447a == view3) {
                                    view2 = view3;
                                    if (dVar.f14448b.equals(u()) && dVar.f14449c.equals(sVar)) {
                                        animator2 = null;
                                        break;
                                    }
                                } else {
                                    view2 = view3;
                                }
                                i6++;
                                view3 = view2;
                            }
                        } else {
                            view2 = view3;
                            animator2 = animatorN;
                            sVar = null;
                        }
                        animator = animator2;
                        view = view2;
                    } else {
                        view = sVar2.f14471b;
                        animator = animatorN;
                        sVar = null;
                    }
                    if (animator != null) {
                        c1853aX.put(animator, new d(view, u(), this, AbstractC1726A.d(viewGroup), sVar));
                        this.f14414B.add(animator);
                    }
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = (Animator) this.f14414B.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i7)) - Long.MAX_VALUE) + animator3.getStartDelay());
            }
        }
    }

    public void p() {
        int i4 = this.f14441x - 1;
        this.f14441x = i4;
        if (i4 == 0) {
            ArrayList arrayList = this.f14413A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f14413A.clone();
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((f) arrayList2.get(i5)).b(this);
                }
            }
            for (int i6 = 0; i6 < this.f14433p.f14475c.k(); i6++) {
                View view = (View) this.f14433p.f14475c.l(i6);
                if (view != null) {
                    H.E.M(view, false);
                }
            }
            for (int i7 = 0; i7 < this.f14434q.f14475c.k(); i7++) {
                View view2 = (View) this.f14434q.f14475c.l(i7);
                if (view2 != null) {
                    H.E.M(view2, false);
                }
            }
            this.f14443z = true;
        }
    }

    public long q() {
        return this.f14420c;
    }

    public e r() {
        return this.f14415C;
    }

    public TimeInterpolator s() {
        return this.f14421d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f14438u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f14437t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return (r0.s) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r0.s t(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            r0.p r0 = r5.f14435r
            if (r0 == 0) goto L9
            r0.s r6 = r0.t(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f14437t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f14438u
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
            r0.s r4 = (r0.s) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f14471b
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
            java.util.ArrayList r6 = r5.f14438u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f14437t
        L36:
            java.lang.Object r6 = r6.get(r3)
            r0.s r6 = (r0.s) r6
            return r6
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.AbstractC1738l.t(android.view.View, boolean):r0.s");
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.f14418a;
    }

    public AbstractC1733g v() {
        return this.f14417E;
    }

    public AbstractC1741o w() {
        return null;
    }

    public long y() {
        return this.f14419b;
    }

    public List z() {
        return this.f14422e;
    }

    public void Y(AbstractC1741o abstractC1741o) {
    }

    public void i(s sVar) {
    }
}
