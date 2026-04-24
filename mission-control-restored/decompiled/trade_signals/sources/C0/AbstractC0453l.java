package C0;

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
import w.C2882a;

/* JADX INFO: renamed from: C0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0453l implements Cloneable {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final int[] f516F = {2, 1, 3, 4};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final AbstractC0448g f517G = new a();

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static ThreadLocal f518H = new ThreadLocal();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f521C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public C2882a f522D;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f543t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f544u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f524a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f525b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f526c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f527d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f528e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f529f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f530g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f531h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f532i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f533j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f534k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f535l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f536m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f537n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f538o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f539p = new t();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t f540q = new t();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0457p f541r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f542s = f516F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f545v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f546w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f547x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f548y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f549z = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ArrayList f519A = null;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ArrayList f520B = new ArrayList();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public AbstractC0448g f523E = f517G;

    /* JADX INFO: renamed from: C0.l$a */
    public class a extends AbstractC0448g {
        @Override // C0.AbstractC0448g
        public Path a(float f8, float f9, float f10, float f11) {
            Path path = new Path();
            path.moveTo(f8, f9);
            path.lineTo(f10, f11);
            return path;
        }
    }

    /* JADX INFO: renamed from: C0.l$b */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2882a f550a;

        public b(C2882a c2882a) {
            this.f550a = c2882a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f550a.remove(animator);
            AbstractC0453l.this.f546w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC0453l.this.f546w.add(animator);
        }
    }

    /* JADX INFO: renamed from: C0.l$c */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC0453l.this.s();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: renamed from: C0.l$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public P f556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbstractC0453l f557e;

        public d(View view, String str, AbstractC0453l abstractC0453l, P p8, s sVar) {
            this.f553a = view;
            this.f554b = str;
            this.f555c = sVar;
            this.f556d = p8;
            this.f557e = abstractC0453l;
        }
    }

    /* JADX INFO: renamed from: C0.l$e */
    public static abstract class e {
    }

    /* JADX INFO: renamed from: C0.l$f */
    public interface f {
        void a(AbstractC0453l abstractC0453l);

        void b(AbstractC0453l abstractC0453l);

        void c(AbstractC0453l abstractC0453l);

        void d(AbstractC0453l abstractC0453l);

        void e(AbstractC0453l abstractC0453l);
    }

    public static C2882a A() {
        C2882a c2882a = (C2882a) f518H.get();
        if (c2882a != null) {
            return c2882a;
        }
        C2882a c2882a2 = new C2882a();
        f518H.set(c2882a2);
        return c2882a2;
    }

    public static boolean K(s sVar, s sVar2, String str) {
        Object obj = sVar.f576a.get(str);
        Object obj2 = sVar2.f576a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void e(t tVar, View view, s sVar) {
        tVar.f579a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f580b.indexOfKey(id) >= 0) {
                tVar.f580b.put(id, null);
            } else {
                tVar.f580b.put(id, view);
            }
        }
        String strV = T.D.v(view);
        if (strV != null) {
            if (tVar.f582d.containsKey(strV)) {
                tVar.f582d.put(strV, null);
            } else {
                tVar.f582d.put(strV, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f581c.e(itemIdAtPosition) < 0) {
                    T.D.P(view, true);
                    tVar.f581c.h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.f581c.d(itemIdAtPosition);
                if (view2 != null) {
                    T.D.P(view2, false);
                    tVar.f581c.h(itemIdAtPosition, null);
                }
            }
        }
    }

    public long B() {
        return this.f525b;
    }

    public List C() {
        return this.f528e;
    }

    public List D() {
        return this.f530g;
    }

    public List E() {
        return this.f531h;
    }

    public List F() {
        return this.f529f;
    }

    public String[] G() {
        return null;
    }

    public s H(View view, boolean z7) {
        C0457p c0457p = this.f541r;
        if (c0457p != null) {
            return c0457p.H(view, z7);
        }
        return (s) (z7 ? this.f539p : this.f540q).f579a.get(view);
    }

    public boolean I(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrG = G();
        if (strArrG == null) {
            Iterator it = sVar.f576a.keySet().iterator();
            while (it.hasNext()) {
                if (K(sVar, sVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrG) {
            if (!K(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean J(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f532i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f533j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f534k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i8 = 0; i8 < size; i8++) {
                if (((Class) this.f534k.get(i8)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f535l != null && T.D.v(view) != null && this.f535l.contains(T.D.v(view))) {
            return false;
        }
        if ((this.f528e.size() == 0 && this.f529f.size() == 0 && (((arrayList = this.f531h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f530g) == null || arrayList2.isEmpty()))) || this.f528e.contains(Integer.valueOf(id)) || this.f529f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f530g;
        if (arrayList6 != null && arrayList6.contains(T.D.v(view))) {
            return true;
        }
        if (this.f531h != null) {
            for (int i9 = 0; i9 < this.f531h.size(); i9++) {
                if (((Class) this.f531h.get(i9)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void L(C2882a c2882a, C2882a c2882a2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view2 = (View) sparseArray.valueAt(i8);
            if (view2 != null && J(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i8))) != null && J(view)) {
                s sVar = (s) c2882a.get(view2);
                s sVar2 = (s) c2882a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f543t.add(sVar);
                    this.f544u.add(sVar2);
                    c2882a.remove(view2);
                    c2882a2.remove(view);
                }
            }
        }
    }

    public final void M(C2882a c2882a, C2882a c2882a2) {
        s sVar;
        for (int size = c2882a.size() - 1; size >= 0; size--) {
            View view = (View) c2882a.f(size);
            if (view != null && J(view) && (sVar = (s) c2882a2.remove(view)) != null && J(sVar.f577b)) {
                this.f543t.add((s) c2882a.h(size));
                this.f544u.add(sVar);
            }
        }
    }

    public final void N(C2882a c2882a, C2882a c2882a2, w.f fVar, w.f fVar2) {
        View view;
        int iJ = fVar.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            View view2 = (View) fVar.k(i8);
            if (view2 != null && J(view2) && (view = (View) fVar2.d(fVar.g(i8))) != null && J(view)) {
                s sVar = (s) c2882a.get(view2);
                s sVar2 = (s) c2882a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f543t.add(sVar);
                    this.f544u.add(sVar2);
                    c2882a.remove(view2);
                    c2882a2.remove(view);
                }
            }
        }
    }

    public final void O(C2882a c2882a, C2882a c2882a2, C2882a c2882a3, C2882a c2882a4) {
        View view;
        int size = c2882a3.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view2 = (View) c2882a3.j(i8);
            if (view2 != null && J(view2) && (view = (View) c2882a4.get(c2882a3.f(i8))) != null && J(view)) {
                s sVar = (s) c2882a.get(view2);
                s sVar2 = (s) c2882a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f543t.add(sVar);
                    this.f544u.add(sVar2);
                    c2882a.remove(view2);
                    c2882a2.remove(view);
                }
            }
        }
    }

    public final void P(t tVar, t tVar2) {
        C2882a c2882a = new C2882a(tVar.f579a);
        C2882a c2882a2 = new C2882a(tVar2.f579a);
        int i8 = 0;
        while (true) {
            int[] iArr = this.f542s;
            if (i8 >= iArr.length) {
                d(c2882a, c2882a2);
                return;
            }
            int i9 = iArr[i8];
            if (i9 == 1) {
                M(c2882a, c2882a2);
            } else if (i9 == 2) {
                O(c2882a, c2882a2, tVar.f582d, tVar2.f582d);
            } else if (i9 == 3) {
                L(c2882a, c2882a2, tVar.f580b, tVar2.f580b);
            } else if (i9 == 4) {
                N(c2882a, c2882a2, tVar.f581c, tVar2.f581c);
            }
            i8++;
        }
    }

    public void Q(View view) {
        if (this.f549z) {
            return;
        }
        for (int size = this.f546w.size() - 1; size >= 0; size--) {
            AbstractC0442a.b((Animator) this.f546w.get(size));
        }
        ArrayList arrayList = this.f519A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f519A.clone();
            int size2 = arrayList2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                ((f) arrayList2.get(i8)).a(this);
            }
        }
        this.f548y = true;
    }

    public void R(ViewGroup viewGroup) {
        d dVar;
        this.f543t = new ArrayList();
        this.f544u = new ArrayList();
        P(this.f539p, this.f540q);
        C2882a c2882aA = A();
        int size = c2882aA.size();
        P pD = A.d(viewGroup);
        for (int i8 = size - 1; i8 >= 0; i8--) {
            Animator animator = (Animator) c2882aA.f(i8);
            if (animator != null && (dVar = (d) c2882aA.get(animator)) != null && dVar.f553a != null && pD.equals(dVar.f556d)) {
                s sVar = dVar.f555c;
                View view = dVar.f553a;
                s sVarH = H(view, true);
                s sVarW = w(view, true);
                if (sVarH == null && sVarW == null) {
                    sVarW = (s) this.f540q.f579a.get(view);
                }
                if ((sVarH != null || sVarW != null) && dVar.f557e.I(sVar, sVarW)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        c2882aA.remove(animator);
                    }
                }
            }
        }
        r(viewGroup, this.f539p, this.f540q, this.f543t, this.f544u);
        W();
    }

    public AbstractC0453l S(f fVar) {
        ArrayList arrayList = this.f519A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.f519A.size() == 0) {
            this.f519A = null;
        }
        return this;
    }

    public AbstractC0453l T(View view) {
        this.f529f.remove(view);
        return this;
    }

    public void U(View view) {
        if (this.f548y) {
            if (!this.f549z) {
                for (int size = this.f546w.size() - 1; size >= 0; size--) {
                    AbstractC0442a.c((Animator) this.f546w.get(size));
                }
                ArrayList arrayList = this.f519A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f519A.clone();
                    int size2 = arrayList2.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        ((f) arrayList2.get(i8)).c(this);
                    }
                }
            }
            this.f548y = false;
        }
    }

    public final void V(Animator animator, C2882a c2882a) {
        if (animator != null) {
            animator.addListener(new b(c2882a));
            g(animator);
        }
    }

    public void W() {
        d0();
        C2882a c2882aA = A();
        for (Animator animator : this.f520B) {
            if (c2882aA.containsKey(animator)) {
                d0();
                V(animator, c2882aA);
            }
        }
        this.f520B.clear();
        s();
    }

    public AbstractC0453l X(long j8) {
        this.f526c = j8;
        return this;
    }

    public void Y(e eVar) {
        this.f521C = eVar;
    }

    public AbstractC0453l Z(TimeInterpolator timeInterpolator) {
        this.f527d = timeInterpolator;
        return this;
    }

    public void a0(AbstractC0448g abstractC0448g) {
        if (abstractC0448g == null) {
            abstractC0448g = f517G;
        }
        this.f523E = abstractC0448g;
    }

    public AbstractC0453l b(f fVar) {
        if (this.f519A == null) {
            this.f519A = new ArrayList();
        }
        this.f519A.add(fVar);
        return this;
    }

    public AbstractC0453l c(View view) {
        this.f529f.add(view);
        return this;
    }

    public AbstractC0453l c0(long j8) {
        this.f525b = j8;
        return this;
    }

    public final void d(C2882a c2882a, C2882a c2882a2) {
        for (int i8 = 0; i8 < c2882a.size(); i8++) {
            s sVar = (s) c2882a.j(i8);
            if (J(sVar.f577b)) {
                this.f543t.add(sVar);
                this.f544u.add(null);
            }
        }
        for (int i9 = 0; i9 < c2882a2.size(); i9++) {
            s sVar2 = (s) c2882a2.j(i9);
            if (J(sVar2.f577b)) {
                this.f544u.add(sVar2);
                this.f543t.add(null);
            }
        }
    }

    public void d0() {
        if (this.f547x == 0) {
            ArrayList arrayList = this.f519A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f519A.clone();
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((f) arrayList2.get(i8)).e(this);
                }
            }
            this.f549z = false;
        }
        this.f547x++;
    }

    public String e0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f526c != -1) {
            str2 = str2 + "dur(" + this.f526c + ") ";
        }
        if (this.f525b != -1) {
            str2 = str2 + "dly(" + this.f525b + ") ";
        }
        if (this.f527d != null) {
            str2 = str2 + "interp(" + this.f527d + ") ";
        }
        if (this.f528e.size() <= 0 && this.f529f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f528e.size() > 0) {
            for (int i8 = 0; i8 < this.f528e.size(); i8++) {
                if (i8 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f528e.get(i8);
            }
        }
        if (this.f529f.size() > 0) {
            for (int i9 = 0; i9 < this.f529f.size(); i9++) {
                if (i9 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f529f.get(i9);
            }
        }
        return str3 + ")";
    }

    public void g(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (t() >= 0) {
            animator.setDuration(t());
        }
        if (B() >= 0) {
            animator.setStartDelay(B() + animator.getStartDelay());
        }
        if (v() != null) {
            animator.setInterpolator(v());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void h() {
        for (int size = this.f546w.size() - 1; size >= 0; size--) {
            ((Animator) this.f546w.get(size)).cancel();
        }
        ArrayList arrayList = this.f519A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.f519A.clone();
        int size2 = arrayList2.size();
        for (int i8 = 0; i8 < size2; i8++) {
            ((f) arrayList2.get(i8)).b(this);
        }
    }

    public abstract void i(s sVar);

    public final void j(View view, boolean z7) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f532i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f533j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f534k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        if (((Class) this.f534k.get(i8)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z7) {
                        l(sVar);
                    } else {
                        i(sVar);
                    }
                    sVar.f578c.add(this);
                    k(sVar);
                    e(z7 ? this.f539p : this.f540q, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f536m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f537n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f538o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i9 = 0; i9 < size2; i9++) {
                                    if (((Class) this.f538o.get(i9)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                                j(viewGroup.getChildAt(i10), z7);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void l(s sVar);

    public void m(ViewGroup viewGroup, boolean z7) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C2882a c2882a;
        o(z7);
        if ((this.f528e.size() > 0 || this.f529f.size() > 0) && (((arrayList = this.f530g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f531h) == null || arrayList2.isEmpty()))) {
            for (int i8 = 0; i8 < this.f528e.size(); i8++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f528e.get(i8)).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z7) {
                        l(sVar);
                    } else {
                        i(sVar);
                    }
                    sVar.f578c.add(this);
                    k(sVar);
                    e(z7 ? this.f539p : this.f540q, viewFindViewById, sVar);
                }
            }
            for (int i9 = 0; i9 < this.f529f.size(); i9++) {
                View view = (View) this.f529f.get(i9);
                s sVar2 = new s(view);
                if (z7) {
                    l(sVar2);
                } else {
                    i(sVar2);
                }
                sVar2.f578c.add(this);
                k(sVar2);
                e(z7 ? this.f539p : this.f540q, view, sVar2);
            }
        } else {
            j(viewGroup, z7);
        }
        if (z7 || (c2882a = this.f522D) == null) {
            return;
        }
        int size = c2882a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList3.add(this.f539p.f582d.remove((String) this.f522D.f(i10)));
        }
        for (int i11 = 0; i11 < size; i11++) {
            View view2 = (View) arrayList3.get(i11);
            if (view2 != null) {
                this.f539p.f582d.put((String) this.f522D.j(i11), view2);
            }
        }
    }

    public void o(boolean z7) {
        t tVar;
        if (z7) {
            this.f539p.f579a.clear();
            this.f539p.f580b.clear();
            tVar = this.f539p;
        } else {
            this.f540q.f579a.clear();
            this.f540q.f580b.clear();
            tVar = this.f540q;
        }
        tVar.f581c.b();
    }

    @Override // 
    /* JADX INFO: renamed from: p */
    public AbstractC0453l clone() {
        try {
            AbstractC0453l abstractC0453l = (AbstractC0453l) super.clone();
            abstractC0453l.f520B = new ArrayList();
            abstractC0453l.f539p = new t();
            abstractC0453l.f540q = new t();
            abstractC0453l.f543t = null;
            abstractC0453l.f544u = null;
            return abstractC0453l;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator q(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        s sVar;
        int i8;
        Animator animator2;
        s sVar2;
        C2882a c2882aA = A();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            s sVar3 = (s) arrayList.get(i9);
            s sVar4 = (s) arrayList2.get(i9);
            if (sVar3 != null && !sVar3.f578c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f578c.contains(this)) {
                sVar4 = null;
            }
            if ((sVar3 != null || sVar4 != null) && (sVar3 == null || sVar4 == null || I(sVar3, sVar4))) {
                Animator animatorQ = q(viewGroup, sVar3, sVar4);
                if (animatorQ != null) {
                    if (sVar4 != null) {
                        View view2 = sVar4.f577b;
                        String[] strArrG = G();
                        if (strArrG != null && strArrG.length > 0) {
                            sVar2 = new s(view2);
                            s sVar5 = (s) tVar2.f579a.get(view2);
                            if (sVar5 != null) {
                                int i10 = 0;
                                while (i10 < strArrG.length) {
                                    Map map = sVar2.f576a;
                                    Animator animator3 = animatorQ;
                                    String str = strArrG[i10];
                                    map.put(str, sVar5.f576a.get(str));
                                    i10++;
                                    animatorQ = animator3;
                                    strArrG = strArrG;
                                }
                            }
                            Animator animator4 = animatorQ;
                            int size2 = c2882aA.size();
                            int i11 = 0;
                            while (true) {
                                if (i11 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) c2882aA.get((Animator) c2882aA.f(i11));
                                if (dVar.f555c != null && dVar.f553a == view2 && dVar.f554b.equals(x()) && dVar.f555c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i11++;
                            }
                        } else {
                            animator2 = animatorQ;
                            sVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        view = sVar3.f577b;
                        animator = animatorQ;
                        sVar = null;
                    }
                    if (animator != null) {
                        i8 = size;
                        c2882aA.put(animator, new d(view, x(), this, A.d(viewGroup), sVar));
                        this.f520B.add(animator);
                    }
                    i9++;
                    size = i8;
                }
                i8 = size;
                i9++;
                size = i8;
            }
            i8 = size;
            i9++;
            size = i8;
        }
        if (sparseIntArray.size() != 0) {
            for (int i12 = 0; i12 < sparseIntArray.size(); i12++) {
                Animator animator5 = (Animator) this.f520B.get(sparseIntArray.keyAt(i12));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i12)) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    public void s() {
        int i8 = this.f547x - 1;
        this.f547x = i8;
        if (i8 == 0) {
            ArrayList arrayList = this.f519A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f519A.clone();
                int size = arrayList2.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ((f) arrayList2.get(i9)).d(this);
                }
            }
            for (int i10 = 0; i10 < this.f539p.f581c.j(); i10++) {
                View view = (View) this.f539p.f581c.k(i10);
                if (view != null) {
                    T.D.P(view, false);
                }
            }
            for (int i11 = 0; i11 < this.f540q.f581c.j(); i11++) {
                View view2 = (View) this.f540q.f581c.k(i11);
                if (view2 != null) {
                    T.D.P(view2, false);
                }
            }
            this.f549z = true;
        }
    }

    public long t() {
        return this.f526c;
    }

    public String toString() {
        return e0("");
    }

    public e u() {
        return this.f521C;
    }

    public TimeInterpolator v() {
        return this.f527d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f544u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f543t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (C0.s) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0.s w(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            C0.p r0 = r5.f541r
            if (r0 == 0) goto L9
            C0.s r6 = r0.w(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f543t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f544u
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
            C0.s r4 = (C0.s) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f577b
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
            java.util.ArrayList r6 = r5.f544u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f543t
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            C0.s r1 = (C0.s) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: C0.AbstractC0453l.w(android.view.View, boolean):C0.s");
    }

    public String x() {
        return this.f524a;
    }

    public AbstractC0448g y() {
        return this.f523E;
    }

    public AbstractC0456o z() {
        return null;
    }

    public void b0(AbstractC0456o abstractC0456o) {
    }

    public void k(s sVar) {
    }
}
