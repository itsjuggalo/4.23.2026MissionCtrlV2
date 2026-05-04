package n2;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Cloneable {
    public static final int[] F = {2, 1, 3, 4};
    public static final g G = new a();
    public static ThreadLocal H = new ThreadLocal();
    public e C;
    public w.a D;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f16567t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f16568u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16548a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16549b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16550c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f16551d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f16552e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f16553f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f16554g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f16555h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f16556i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f16557j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f16558k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f16559l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f16560m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f16561n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f16562o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public s f16563p = new s();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s f16564q = new s();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p f16565r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f16566s = F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16569v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f16570w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16571x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f16572y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16573z = false;
    public ArrayList A = null;
    public ArrayList B = new ArrayList();
    public g E = G;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends g {
        @Override // n2.g
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w.a f16574a;

        public b(w.a aVar) {
            this.f16574a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f16574a.remove(animator);
            l.this.f16570w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l.this.f16570w.add(animator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.q();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f16577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public r f16579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public h0 f16580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l f16581e;

        public d(View view, String str, l lVar, h0 h0Var, r rVar) {
            this.f16577a = view;
            this.f16578b = str;
            this.f16579c = rVar;
            this.f16580d = h0Var;
            this.f16581e = lVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    public static boolean J(r rVar, r rVar2, String str) {
        Object obj = rVar.f16595a.get(str);
        Object obj2 = rVar2.f16595a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void d(s sVar, View view, r rVar) {
        sVar.f16598a.put(view, rVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (sVar.f16599b.indexOfKey(id2) >= 0) {
                sVar.f16599b.put(id2, null);
            } else {
                sVar.f16599b.put(id2, view);
            }
        }
        String strV = t0.c0.v(view);
        if (strV != null) {
            if (sVar.f16601d.containsKey(strV)) {
                sVar.f16601d.put(strV, null);
            } else {
                sVar.f16601d.put(strV, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (sVar.f16600c.d(itemIdAtPosition) < 0) {
                    t0.c0.P(view, true);
                    sVar.f16600c.g(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) sVar.f16600c.c(itemIdAtPosition);
                if (view2 != null) {
                    t0.c0.P(view2, false);
                    sVar.f16600c.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static w.a z() {
        w.a aVar = (w.a) H.get();
        if (aVar != null) {
            return aVar;
        }
        w.a aVar2 = new w.a();
        H.set(aVar2);
        return aVar2;
    }

    public long A() {
        return this.f16549b;
    }

    public List B() {
        return this.f16552e;
    }

    public List C() {
        return this.f16554g;
    }

    public List D() {
        return this.f16555h;
    }

    public List E() {
        return this.f16553f;
    }

    public String[] F() {
        return null;
    }

    public r G(View view, boolean z10) {
        p pVar = this.f16565r;
        if (pVar != null) {
            return pVar.G(view, z10);
        }
        return (r) (z10 ? this.f16563p : this.f16564q).f16598a.get(view);
    }

    public boolean H(r rVar, r rVar2) {
        if (rVar != null && rVar2 != null) {
            String[] strArrF = F();
            if (strArrF != null) {
                for (String str : strArrF) {
                    if (J(rVar, rVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = rVar.f16595a.keySet().iterator();
                while (it.hasNext()) {
                    if (J(rVar, rVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean I(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id2 = view.getId();
        ArrayList arrayList3 = this.f16556i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList arrayList4 = this.f16557j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f16558k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((Class) this.f16558k.get(i10)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f16559l != null && t0.c0.v(view) != null && this.f16559l.contains(t0.c0.v(view))) {
            return false;
        }
        if ((this.f16552e.size() == 0 && this.f16553f.size() == 0 && (((arrayList = this.f16555h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f16554g) == null || arrayList2.isEmpty()))) || this.f16552e.contains(Integer.valueOf(id2)) || this.f16553f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f16554g;
        if (arrayList6 != null && arrayList6.contains(t0.c0.v(view))) {
            return true;
        }
        if (this.f16555h != null) {
            for (int i11 = 0; i11 < this.f16555h.size(); i11++) {
                if (((Class) this.f16555h.get(i11)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void K(w.a aVar, w.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) sparseArray.valueAt(i10);
            if (view2 != null && I(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i10))) != null && I(view)) {
                r rVar = (r) aVar.get(view2);
                r rVar2 = (r) aVar2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.f16567t.add(rVar);
                    this.f16568u.add(rVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void L(w.a aVar, w.a aVar2) {
        r rVar;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.g(size);
            if (view != null && I(view) && (rVar = (r) aVar2.remove(view)) != null && I(rVar.f16596b)) {
                this.f16567t.add((r) aVar.i(size));
                this.f16568u.add(rVar);
            }
        }
    }

    public final void M(w.a aVar, w.a aVar2, w.f fVar, w.f fVar2) {
        View view;
        int i10 = fVar.i();
        for (int i11 = 0; i11 < i10; i11++) {
            View view2 = (View) fVar.j(i11);
            if (view2 != null && I(view2) && (view = (View) fVar2.c(fVar.f(i11))) != null && I(view)) {
                r rVar = (r) aVar.get(view2);
                r rVar2 = (r) aVar2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.f16567t.add(rVar);
                    this.f16568u.add(rVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void N(w.a aVar, w.a aVar2, w.a aVar3, w.a aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) aVar3.k(i10);
            if (view2 != null && I(view2) && (view = (View) aVar4.get(aVar3.g(i10))) != null && I(view)) {
                r rVar = (r) aVar.get(view2);
                r rVar2 = (r) aVar2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.f16567t.add(rVar);
                    this.f16568u.add(rVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void O(s sVar, s sVar2) {
        w.a aVar = new w.a(sVar.f16598a);
        w.a aVar2 = new w.a(sVar2.f16598a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f16566s;
            if (i10 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 1) {
                L(aVar, aVar2);
            } else if (i11 == 2) {
                N(aVar, aVar2, sVar.f16601d, sVar2.f16601d);
            } else if (i11 == 3) {
                K(aVar, aVar2, sVar.f16599b, sVar2.f16599b);
            } else if (i11 == 4) {
                M(aVar, aVar2, sVar.f16600c, sVar2.f16600c);
            }
            i10++;
        }
    }

    public void P(View view) {
        if (this.f16573z) {
            return;
        }
        for (int size = this.f16570w.size() - 1; size >= 0; size--) {
            n2.a.b((Animator) this.f16570w.get(size));
        }
        ArrayList arrayList = this.A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.A.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((f) arrayList2.get(i10)).e(this);
            }
        }
        this.f16572y = true;
    }

    public void Q(ViewGroup viewGroup) {
        d dVar;
        this.f16567t = new ArrayList();
        this.f16568u = new ArrayList();
        O(this.f16563p, this.f16564q);
        w.a aVarZ = z();
        int size = aVarZ.size();
        h0 h0VarD = y.d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = (Animator) aVarZ.g(i10);
            if (animator != null && (dVar = (d) aVarZ.get(animator)) != null && dVar.f16577a != null && h0VarD.equals(dVar.f16580d)) {
                r rVar = dVar.f16579c;
                View view = dVar.f16577a;
                r rVarG = G(view, true);
                r rVarV = v(view, true);
                if (rVarG == null && rVarV == null) {
                    rVarV = (r) this.f16564q.f16598a.get(view);
                }
                if ((rVarG != null || rVarV != null) && dVar.f16581e.H(rVar, rVarV)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        aVarZ.remove(animator);
                    }
                }
            }
        }
        p(viewGroup, this.f16563p, this.f16564q, this.f16567t, this.f16568u);
        V();
    }

    public l R(f fVar) {
        ArrayList arrayList = this.A;
        if (arrayList != null) {
            arrayList.remove(fVar);
            if (this.A.size() == 0) {
                this.A = null;
            }
        }
        return this;
    }

    public l S(View view) {
        this.f16553f.remove(view);
        return this;
    }

    public void T(View view) {
        if (this.f16572y) {
            if (!this.f16573z) {
                for (int size = this.f16570w.size() - 1; size >= 0; size--) {
                    n2.a.c((Animator) this.f16570w.get(size));
                }
                ArrayList arrayList = this.A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.A.clone();
                    int size2 = arrayList2.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        ((f) arrayList2.get(i10)).a(this);
                    }
                }
            }
            this.f16572y = false;
        }
    }

    public final void U(Animator animator, w.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            f(animator);
        }
    }

    public void V() {
        c0();
        w.a aVarZ = z();
        for (Animator animator : this.B) {
            if (aVarZ.containsKey(animator)) {
                c0();
                U(animator, aVarZ);
            }
        }
        this.B.clear();
        q();
    }

    public l W(long j10) {
        this.f16550c = j10;
        return this;
    }

    public void X(e eVar) {
        this.C = eVar;
    }

    public l Y(TimeInterpolator timeInterpolator) {
        this.f16551d = timeInterpolator;
        return this;
    }

    public void Z(g gVar) {
        if (gVar == null) {
            this.E = G;
        } else {
            this.E = gVar;
        }
    }

    public l a(f fVar) {
        if (this.A == null) {
            this.A = new ArrayList();
        }
        this.A.add(fVar);
        return this;
    }

    public l b(View view) {
        this.f16553f.add(view);
        return this;
    }

    public l b0(long j10) {
        this.f16549b = j10;
        return this;
    }

    public final void c(w.a aVar, w.a aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            r rVar = (r) aVar.k(i10);
            if (I(rVar.f16596b)) {
                this.f16567t.add(rVar);
                this.f16568u.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            r rVar2 = (r) aVar2.k(i11);
            if (I(rVar2.f16596b)) {
                this.f16568u.add(rVar2);
                this.f16567t.add(null);
            }
        }
    }

    public void c0() {
        if (this.f16571x == 0) {
            ArrayList arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((f) arrayList2.get(i10)).b(this);
                }
            }
            this.f16573z = false;
        }
        this.f16571x++;
    }

    public String d0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f16550c != -1) {
            str2 = str2 + "dur(" + this.f16550c + ") ";
        }
        if (this.f16549b != -1) {
            str2 = str2 + "dly(" + this.f16549b + ") ";
        }
        if (this.f16551d != null) {
            str2 = str2 + "interp(" + this.f16551d + ") ";
        }
        if (this.f16552e.size() <= 0 && this.f16553f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f16552e.size() > 0) {
            for (int i10 = 0; i10 < this.f16552e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f16552e.get(i10);
            }
        }
        if (this.f16553f.size() > 0) {
            for (int i11 = 0; i11 < this.f16553f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f16553f.get(i11);
            }
        }
        return str3 + ")";
    }

    public void f(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (A() >= 0) {
            animator.setStartDelay(A() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void g() {
        for (int size = this.f16570w.size() - 1; size >= 0; size--) {
            ((Animator) this.f16570w.get(size)).cancel();
        }
        ArrayList arrayList = this.A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.A.clone();
        int size2 = arrayList2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            ((f) arrayList2.get(i10)).c(this);
        }
    }

    public abstract void h(r rVar);

    public final void i(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        ArrayList arrayList = this.f16556i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
            ArrayList arrayList2 = this.f16557j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f16558k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (((Class) this.f16558k.get(i10)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    r rVar = new r(view);
                    if (z10) {
                        k(rVar);
                    } else {
                        h(rVar);
                    }
                    rVar.f16597c.add(this);
                    j(rVar);
                    if (z10) {
                        d(this.f16563p, view, rVar);
                    } else {
                        d(this.f16564q, view, rVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f16560m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                        ArrayList arrayList5 = this.f16561n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f16562o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    if (((Class) this.f16562o.get(i11)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                i(viewGroup.getChildAt(i12), z10);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void k(r rVar);

    public void l(ViewGroup viewGroup, boolean z10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        w.a aVar;
        m(z10);
        if ((this.f16552e.size() > 0 || this.f16553f.size() > 0) && (((arrayList = this.f16554g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f16555h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f16552e.size(); i10++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f16552e.get(i10)).intValue());
                if (viewFindViewById != null) {
                    r rVar = new r(viewFindViewById);
                    if (z10) {
                        k(rVar);
                    } else {
                        h(rVar);
                    }
                    rVar.f16597c.add(this);
                    j(rVar);
                    if (z10) {
                        d(this.f16563p, viewFindViewById, rVar);
                    } else {
                        d(this.f16564q, viewFindViewById, rVar);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f16553f.size(); i11++) {
                View view = (View) this.f16553f.get(i11);
                r rVar2 = new r(view);
                if (z10) {
                    k(rVar2);
                } else {
                    h(rVar2);
                }
                rVar2.f16597c.add(this);
                j(rVar2);
                if (z10) {
                    d(this.f16563p, view, rVar2);
                } else {
                    d(this.f16564q, view, rVar2);
                }
            }
        } else {
            i(viewGroup, z10);
        }
        if (z10 || (aVar = this.D) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList3.add(this.f16563p.f16601d.remove((String) this.D.g(i12)));
        }
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = (View) arrayList3.get(i13);
            if (view2 != null) {
                this.f16563p.f16601d.put((String) this.D.k(i13), view2);
            }
        }
    }

    public void m(boolean z10) {
        if (z10) {
            this.f16563p.f16598a.clear();
            this.f16563p.f16599b.clear();
            this.f16563p.f16600c.a();
        } else {
            this.f16564q.f16598a.clear();
            this.f16564q.f16599b.clear();
            this.f16564q.f16600c.a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: n */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.B = new ArrayList();
            lVar.f16563p = new s();
            lVar.f16564q = new s();
            lVar.f16567t = null;
            lVar.f16568u = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator o(ViewGroup viewGroup, r rVar, r rVar2) {
        return null;
    }

    public void p(ViewGroup viewGroup, s sVar, s sVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        r rVar;
        View view2;
        Animator animator2;
        w.a aVarZ = z();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            r rVar2 = (r) arrayList.get(i10);
            r rVar3 = (r) arrayList2.get(i10);
            if (rVar2 != null && !rVar2.f16597c.contains(this)) {
                rVar2 = null;
            }
            if (rVar3 != null && !rVar3.f16597c.contains(this)) {
                rVar3 = null;
            }
            if ((rVar2 != null || rVar3 != null) && (rVar2 == null || rVar3 == null || H(rVar2, rVar3))) {
                Animator animatorO = o(viewGroup, rVar2, rVar3);
                if (animatorO != null) {
                    if (rVar3 != null) {
                        View view3 = rVar3.f16596b;
                        String[] strArrF = F();
                        if (strArrF != null && strArrF.length > 0) {
                            rVar = new r(view3);
                            r rVar4 = (r) sVar2.f16598a.get(view3);
                            if (rVar4 != null) {
                                int i11 = 0;
                                while (i11 < strArrF.length) {
                                    Map map = rVar.f16595a;
                                    String[] strArr = strArrF;
                                    String str = strArr[i11];
                                    map.put(str, rVar4.f16595a.get(str));
                                    i11++;
                                    strArrF = strArr;
                                }
                            }
                            int size2 = aVarZ.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    view2 = view3;
                                    animator2 = animatorO;
                                    break;
                                }
                                d dVar = (d) aVarZ.get((Animator) aVarZ.g(i12));
                                if (dVar.f16579c != null && dVar.f16577a == view3) {
                                    view2 = view3;
                                    if (dVar.f16578b.equals(w()) && dVar.f16579c.equals(rVar)) {
                                        animator2 = null;
                                        break;
                                    }
                                } else {
                                    view2 = view3;
                                }
                                i12++;
                                view3 = view2;
                            }
                        } else {
                            view2 = view3;
                            animator2 = animatorO;
                            rVar = null;
                        }
                        animator = animator2;
                        view = view2;
                    } else {
                        view = rVar2.f16596b;
                        animator = animatorO;
                        rVar = null;
                    }
                    if (animator != null) {
                        aVarZ.put(animator, new d(view, w(), this, y.d(viewGroup), rVar));
                        this.B.add(animator);
                    }
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int i13 = 0; i13 < sparseIntArray.size(); i13++) {
                Animator animator3 = (Animator) this.B.get(sparseIntArray.keyAt(i13));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i13)) - Long.MAX_VALUE) + animator3.getStartDelay());
            }
        }
    }

    public void q() {
        int i10 = this.f16571x - 1;
        this.f16571x = i10;
        if (i10 == 0) {
            ArrayList arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).d(this);
                }
            }
            for (int i12 = 0; i12 < this.f16563p.f16600c.i(); i12++) {
                View view = (View) this.f16563p.f16600c.j(i12);
                if (view != null) {
                    t0.c0.P(view, false);
                }
            }
            for (int i13 = 0; i13 < this.f16564q.f16600c.i(); i13++) {
                View view2 = (View) this.f16564q.f16600c.j(i13);
                if (view2 != null) {
                    t0.c0.P(view2, false);
                }
            }
            this.f16573z = true;
        }
    }

    public long r() {
        return this.f16550c;
    }

    public e s() {
        return this.C;
    }

    public TimeInterpolator t() {
        return this.f16551d;
    }

    public String toString() {
        return d0("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f16568u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f16567t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return (n2.r) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n2.r v(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            n2.p r0 = r5.f16565r
            if (r0 == 0) goto L9
            n2.r r6 = r0.v(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f16567t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f16568u
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
            n2.r r4 = (n2.r) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f16596b
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
            java.util.ArrayList r6 = r5.f16568u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f16567t
        L36:
            java.lang.Object r6 = r6.get(r3)
            n2.r r6 = (n2.r) r6
            return r6
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.l.v(android.view.View, boolean):n2.r");
    }

    public String w() {
        return this.f16548a;
    }

    public g x() {
        return this.E;
    }

    public o y() {
        return null;
    }

    public void a0(o oVar) {
    }

    public void j(r rVar) {
    }
}
