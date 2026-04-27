package androidx.recyclerview.widget;

import Q.N;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f8292s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f8293h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f8294i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f8295j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f8296k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f8297l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f8298m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f8299n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f8300o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f8301p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f8302q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f8303r = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8304a;

        public a(ArrayList arrayList) {
            this.f8304a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f8304a) {
                c.this.S(jVar.f8338a, jVar.f8339b, jVar.f8340c, jVar.f8341d, jVar.f8342e);
            }
            this.f8304a.clear();
            c.this.f8298m.remove(this.f8304a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8306a;

        public b(ArrayList arrayList) {
            this.f8306a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f8306a.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f8306a.clear();
            c.this.f8299n.remove(this.f8306a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    public class RunnableC0139c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8308a;

        public RunnableC0139c(ArrayList arrayList) {
            this.f8308a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f8308a.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.C) it.next());
            }
            this.f8308a.clear();
            c.this.f8297l.remove(this.f8308a);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.C f8310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f8311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f8312c;

        public d(RecyclerView.C c7, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f8310a = c7;
            this.f8311b = viewPropertyAnimator;
            this.f8312c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8311b.setListener(null);
            this.f8312c.setAlpha(1.0f);
            c.this.G(this.f8310a);
            c.this.f8302q.remove(this.f8310a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f8310a);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.C f8314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f8315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f8316c;

        public e(RecyclerView.C c7, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f8314a = c7;
            this.f8315b = view;
            this.f8316c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8315b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8316c.setListener(null);
            c.this.A(this.f8314a);
            c.this.f8300o.remove(this.f8314a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f8314a);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.C f8318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f8320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f8321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f8322e;

        public f(RecyclerView.C c7, int i7, View view, int i8, ViewPropertyAnimator viewPropertyAnimator) {
            this.f8318a = c7;
            this.f8319b = i7;
            this.f8320c = view;
            this.f8321d = i8;
            this.f8322e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f8319b != 0) {
                this.f8320c.setTranslationX(0.0f);
            }
            if (this.f8321d != 0) {
                this.f8320c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8322e.setListener(null);
            c.this.E(this.f8318a);
            c.this.f8301p.remove(this.f8318a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f8318a);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f8324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f8325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f8326c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f8324a = iVar;
            this.f8325b = viewPropertyAnimator;
            this.f8326c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8325b.setListener(null);
            this.f8326c.setAlpha(1.0f);
            this.f8326c.setTranslationX(0.0f);
            this.f8326c.setTranslationY(0.0f);
            c.this.C(this.f8324a.f8332a, true);
            c.this.f8303r.remove(this.f8324a.f8332a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f8324a.f8332a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f8328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f8329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f8330c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f8328a = iVar;
            this.f8329b = viewPropertyAnimator;
            this.f8330c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8329b.setListener(null);
            this.f8330c.setAlpha(1.0f);
            this.f8330c.setTranslationX(0.0f);
            this.f8330c.setTranslationY(0.0f);
            c.this.C(this.f8328a.f8333b, false);
            c.this.f8303r.remove(this.f8328a.f8333b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f8328a.f8333b, false);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.C f8338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8342e;

        public j(RecyclerView.C c7, int i7, int i8, int i9, int i10) {
            this.f8338a = c7;
            this.f8339b = i7;
            this.f8340c = i8;
            this.f8341d = i9;
            this.f8342e = i10;
        }
    }

    public void Q(RecyclerView.C c7) {
        View view = c7.f8107a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f8300o.add(c7);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new e(c7, view, viewPropertyAnimatorAnimate)).start();
    }

    public void R(i iVar) {
        RecyclerView.C c7 = iVar.f8332a;
        View view = c7 == null ? null : c7.f8107a;
        RecyclerView.C c8 = iVar.f8333b;
        View view2 = c8 != null ? c8.f8107a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f8303r.add(iVar.f8332a);
            duration.translationX(iVar.f8336e - iVar.f8334c);
            duration.translationY(iVar.f8337f - iVar.f8335d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f8303r.add(iVar.f8333b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public void S(RecyclerView.C c7, int i7, int i8, int i9, int i10) {
        View view = c7.f8107a;
        int i11 = i9 - i7;
        int i12 = i10 - i8;
        if (i11 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i12 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f8301p.add(c7);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(c7, i11, view, i12, viewPropertyAnimatorAnimate)).start();
    }

    public final void T(RecyclerView.C c7) {
        View view = c7.f8107a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f8302q.add(c7);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(c7, viewPropertyAnimatorAnimate, view)).start();
    }

    public void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.C) list.get(size)).f8107a.animate().cancel();
        }
    }

    public void V() {
        if (p()) {
            return;
        }
        i();
    }

    public final void W(List list, RecyclerView.C c7) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, c7) && iVar.f8332a == null && iVar.f8333b == null) {
                list.remove(iVar);
            }
        }
    }

    public final void X(i iVar) {
        RecyclerView.C c7 = iVar.f8332a;
        if (c7 != null) {
            Y(iVar, c7);
        }
        RecyclerView.C c8 = iVar.f8333b;
        if (c8 != null) {
            Y(iVar, c8);
        }
    }

    public final boolean Y(i iVar, RecyclerView.C c7) {
        boolean z7 = false;
        if (iVar.f8333b == c7) {
            iVar.f8333b = null;
        } else {
            if (iVar.f8332a != c7) {
                return false;
            }
            iVar.f8332a = null;
            z7 = true;
        }
        c7.f8107a.setAlpha(1.0f);
        c7.f8107a.setTranslationX(0.0f);
        c7.f8107a.setTranslationY(0.0f);
        C(c7, z7);
        return true;
    }

    public final void Z(RecyclerView.C c7) {
        if (f8292s == null) {
            f8292s = new ValueAnimator().getInterpolator();
        }
        c7.f8107a.animate().setInterpolator(f8292s);
        j(c7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.C c7, List list) {
        return !list.isEmpty() || super.g(c7, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.C c7) {
        View view = c7.f8107a;
        view.animate().cancel();
        int size = this.f8295j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f8295j.get(size)).f8338a == c7) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(c7);
                this.f8295j.remove(size);
            }
        }
        W(this.f8296k, c7);
        if (this.f8293h.remove(c7)) {
            view.setAlpha(1.0f);
            G(c7);
        }
        if (this.f8294i.remove(c7)) {
            view.setAlpha(1.0f);
            A(c7);
        }
        for (int size2 = this.f8299n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f8299n.get(size2);
            W(arrayList, c7);
            if (arrayList.isEmpty()) {
                this.f8299n.remove(size2);
            }
        }
        for (int size3 = this.f8298m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f8298m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).f8338a == c7) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(c7);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f8298m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f8297l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f8297l.get(size5);
            if (arrayList3.remove(c7)) {
                view.setAlpha(1.0f);
                A(c7);
                if (arrayList3.isEmpty()) {
                    this.f8297l.remove(size5);
                }
            }
        }
        this.f8302q.remove(c7);
        this.f8300o.remove(c7);
        this.f8303r.remove(c7);
        this.f8301p.remove(c7);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f8295j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f8295j.get(size);
            View view = jVar.f8338a.f8107a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f8338a);
            this.f8295j.remove(size);
        }
        for (int size2 = this.f8293h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.C) this.f8293h.get(size2));
            this.f8293h.remove(size2);
        }
        int size3 = this.f8294i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.C c7 = (RecyclerView.C) this.f8294i.get(size3);
            c7.f8107a.setAlpha(1.0f);
            A(c7);
            this.f8294i.remove(size3);
        }
        for (int size4 = this.f8296k.size() - 1; size4 >= 0; size4--) {
            X((i) this.f8296k.get(size4));
        }
        this.f8296k.clear();
        if (p()) {
            for (int size5 = this.f8298m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f8298m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f8338a.f8107a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f8338a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f8298m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f8297l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f8297l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C c8 = (RecyclerView.C) arrayList2.get(size8);
                    c8.f8107a.setAlpha(1.0f);
                    A(c8);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f8297l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f8299n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f8299n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f8299n.remove(arrayList3);
                    }
                }
            }
            U(this.f8302q);
            U(this.f8301p);
            U(this.f8300o);
            U(this.f8303r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f8294i.isEmpty() && this.f8296k.isEmpty() && this.f8295j.isEmpty() && this.f8293h.isEmpty() && this.f8301p.isEmpty() && this.f8302q.isEmpty() && this.f8300o.isEmpty() && this.f8303r.isEmpty() && this.f8298m.isEmpty() && this.f8297l.isEmpty() && this.f8299n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean zIsEmpty = this.f8293h.isEmpty();
        boolean zIsEmpty2 = this.f8295j.isEmpty();
        boolean zIsEmpty3 = this.f8296k.isEmpty();
        boolean zIsEmpty4 = this.f8294i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f8293h.iterator();
        while (it.hasNext()) {
            T((RecyclerView.C) it.next());
        }
        this.f8293h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f8295j);
            this.f8298m.add(arrayList);
            this.f8295j.clear();
            a aVar = new a(arrayList);
            if (zIsEmpty) {
                aVar.run();
            } else {
                N.e0(((j) arrayList.get(0)).f8338a.f8107a, aVar, o());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f8296k);
            this.f8299n.add(arrayList2);
            this.f8296k.clear();
            b bVar = new b(arrayList2);
            if (zIsEmpty) {
                bVar.run();
            } else {
                N.e0(((i) arrayList2.get(0)).f8332a.f8107a, bVar, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f8294i);
        this.f8297l.add(arrayList3);
        this.f8294i.clear();
        RunnableC0139c runnableC0139c = new RunnableC0139c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnableC0139c.run();
        } else {
            N.e0(((RecyclerView.C) arrayList3.get(0)).f8107a, runnableC0139c, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }

    @Override // androidx.recyclerview.widget.m
    public boolean w(RecyclerView.C c7) {
        Z(c7);
        c7.f8107a.setAlpha(0.0f);
        this.f8294i.add(c7);
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean x(RecyclerView.C c7, RecyclerView.C c8, int i7, int i8, int i9, int i10) {
        if (c7 == c8) {
            return y(c7, i7, i8, i9, i10);
        }
        float translationX = c7.f8107a.getTranslationX();
        float translationY = c7.f8107a.getTranslationY();
        float alpha = c7.f8107a.getAlpha();
        Z(c7);
        int i11 = (int) ((i9 - i7) - translationX);
        int i12 = (int) ((i10 - i8) - translationY);
        c7.f8107a.setTranslationX(translationX);
        c7.f8107a.setTranslationY(translationY);
        c7.f8107a.setAlpha(alpha);
        if (c8 != null) {
            Z(c8);
            c8.f8107a.setTranslationX(-i11);
            c8.f8107a.setTranslationY(-i12);
            c8.f8107a.setAlpha(0.0f);
        }
        this.f8296k.add(new i(c7, c8, i7, i8, i9, i10));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean y(RecyclerView.C c7, int i7, int i8, int i9, int i10) {
        View view = c7.f8107a;
        int translationX = i7 + ((int) view.getTranslationX());
        int translationY = i8 + ((int) c7.f8107a.getTranslationY());
        Z(c7);
        int i11 = i9 - translationX;
        int i12 = i10 - translationY;
        if (i11 == 0 && i12 == 0) {
            E(c7);
            return false;
        }
        if (i11 != 0) {
            view.setTranslationX(-i11);
        }
        if (i12 != 0) {
            view.setTranslationY(-i12);
        }
        this.f8295j.add(new j(c7, translationX, translationY, i9, i10));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean z(RecyclerView.C c7) {
        Z(c7);
        this.f8293h.add(c7);
        return true;
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.C f8332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.C f8333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8335d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8336e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8337f;

        public i(RecyclerView.C c7, RecyclerView.C c8) {
            this.f8332a = c7;
            this.f8333b = c8;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f8332a + ", newHolder=" + this.f8333b + ", fromX=" + this.f8334c + ", fromY=" + this.f8335d + ", toX=" + this.f8336e + ", toY=" + this.f8337f + '}';
        }

        public i(RecyclerView.C c7, RecyclerView.C c8, int i7, int i8, int i9, int i10) {
            this(c7, c8);
            this.f8334c = i7;
            this.f8335d = i8;
            this.f8336e = i9;
            this.f8337f = i10;
        }
    }
}
