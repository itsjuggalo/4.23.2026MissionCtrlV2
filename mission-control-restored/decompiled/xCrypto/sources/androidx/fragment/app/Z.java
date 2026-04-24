package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public abstract class Z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f7416f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f7417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7421e;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final Z a(ViewGroup container, I fragmentManager) {
            kotlin.jvm.internal.r.f(container, "container");
            kotlin.jvm.internal.r.f(fragmentManager, "fragmentManager");
            a0 a0VarB0 = fragmentManager.B0();
            kotlin.jvm.internal.r.e(a0VarB0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, a0VarB0);
        }

        public final Z b(ViewGroup container, a0 factory) {
            kotlin.jvm.internal.r.f(container, "container");
            kotlin.jvm.internal.r.f(factory, "factory");
            Object tag = container.getTag(X.b.f5520b);
            if (tag instanceof Z) {
                return (Z) tag;
            }
            Z zA = factory.a(container);
            kotlin.jvm.internal.r.e(zA, "factory.createController(container)");
            container.setTag(X.b.f5520b, zA);
            return zA;
        }

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7424c;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (!this.f7424c) {
                c(container);
            }
            this.f7424c = true;
        }

        public boolean b() {
            return this.f7422a;
        }

        public abstract void c(ViewGroup viewGroup);

        public abstract void d(ViewGroup viewGroup);

        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            kotlin.jvm.internal.r.f(container, "container");
        }

        public void f(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
        }

        public final void g(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (!this.f7423b) {
                f(container);
            }
            this.f7423b = true;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final O f7425l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b finalState, d.a lifecycleImpact, O fragmentStateManager) {
            kotlin.jvm.internal.r.f(finalState, "finalState");
            kotlin.jvm.internal.r.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = fragmentStateManager.k();
            kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, abstractComponentCallbacksC0828pK);
            this.f7425l = fragmentStateManager;
        }

        @Override // androidx.fragment.app.Z.d
        public void e() {
            super.e();
            i().mTransitioning = false;
            this.f7425l.m();
        }

        @Override // androidx.fragment.app.Z.d
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != d.a.ADDING) {
                if (j() == d.a.REMOVING) {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = this.f7425l.k();
                    kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pK, "fragmentStateManager.fragment");
                    View viewRequireView = abstractComponentCallbacksC0828pK.requireView();
                    kotlin.jvm.internal.r.e(viewRequireView, "fragment.requireView()");
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + abstractComponentCallbacksC0828pK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK2 = this.f7425l.k();
            kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pK2, "fragmentStateManager.fragment");
            View viewFindFocus = abstractComponentCallbacksC0828pK2.mView.findFocus();
            if (viewFindFocus != null) {
                abstractComponentCallbacksC0828pK2.setFocusedView(viewFindFocus);
                if (I.J0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC0828pK2);
                }
            }
            View viewRequireView2 = i().requireView();
            kotlin.jvm.internal.r.e(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                this.f7425l.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(abstractComponentCallbacksC0828pK2.getPostOnViewCreatedAlpha());
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f7426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f7427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractComponentCallbacksC0828p f7428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f7429d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7430e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7431f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f7432g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7433h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f7434i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f7435j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List f7436k;

        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f7441a = new a(null);

            public static final class a {
                public /* synthetic */ a(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b a(View view) {
                    kotlin.jvm.internal.r.f(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i4) {
                    if (i4 == 0) {
                        return b.VISIBLE;
                    }
                    if (i4 == 4) {
                        return b.INVISIBLE;
                    }
                    if (i4 == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i4);
                }

                public a() {
                }
            }

            /* JADX INFO: renamed from: androidx.fragment.app.Z$d$b$b, reason: collision with other inner class name */
            public /* synthetic */ class C0103b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f7447a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f7447a = iArr;
                }
            }

            public static final b g(int i4) {
                return f7441a.b(i4);
            }

            public final void c(View view, ViewGroup container) {
                kotlin.jvm.internal.r.f(view, "view");
                kotlin.jvm.internal.r.f(container, "container");
                int i4 = C0103b.f7447a[ordinal()];
                if (i4 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (I.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i4 == 2) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (I.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i4 == 3) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i4 != 4) {
                    return;
                }
                if (I.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public /* synthetic */ class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f7448a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f7448a = iArr;
            }
        }

        public d(b finalState, a lifecycleImpact, AbstractComponentCallbacksC0828p fragment) {
            kotlin.jvm.internal.r.f(finalState, "finalState");
            kotlin.jvm.internal.r.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.r.f(fragment, "fragment");
            this.f7426a = finalState;
            this.f7427b = lifecycleImpact;
            this.f7428c = fragment;
            this.f7429d = new ArrayList();
            this.f7434i = true;
            ArrayList arrayList = new ArrayList();
            this.f7435j = arrayList;
            this.f7436k = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.r.f(listener, "listener");
            this.f7429d.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.r.f(effect, "effect");
            this.f7435j.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            this.f7433h = false;
            if (this.f7430e) {
                return;
            }
            this.f7430e = true;
            if (this.f7435j.isEmpty()) {
                e();
                return;
            }
            Iterator it = X2.x.g0(this.f7436k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z4) {
            kotlin.jvm.internal.r.f(container, "container");
            if (this.f7430e) {
                return;
            }
            if (z4) {
                this.f7432g = true;
            }
            c(container);
        }

        public void e() {
            this.f7433h = false;
            if (this.f7431f) {
                return;
            }
            if (I.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f7431f = true;
            Iterator it = this.f7429d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            kotlin.jvm.internal.r.f(effect, "effect");
            if (this.f7435j.remove(effect) && this.f7435j.isEmpty()) {
                e();
            }
        }

        public final List g() {
            return this.f7436k;
        }

        public final b h() {
            return this.f7426a;
        }

        public final AbstractComponentCallbacksC0828p i() {
            return this.f7428c;
        }

        public final a j() {
            return this.f7427b;
        }

        public final boolean k() {
            return this.f7434i;
        }

        public final boolean l() {
            return this.f7430e;
        }

        public final boolean m() {
            return this.f7431f;
        }

        public final boolean n() {
            return this.f7432g;
        }

        public final boolean o() {
            return this.f7433h;
        }

        public final void p(b finalState, a lifecycleImpact) {
            kotlin.jvm.internal.r.f(finalState, "finalState");
            kotlin.jvm.internal.r.f(lifecycleImpact, "lifecycleImpact");
            int i4 = c.f7448a[lifecycleImpact.ordinal()];
            if (i4 == 1) {
                if (this.f7426a == b.REMOVED) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f7428c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f7427b + " to ADDING.");
                    }
                    this.f7426a = b.VISIBLE;
                    this.f7427b = a.ADDING;
                    this.f7434i = true;
                    return;
                }
                return;
            }
            if (i4 == 2) {
                if (I.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f7428c + " mFinalState = " + this.f7426a + " -> REMOVED. mLifecycleImpact  = " + this.f7427b + " to REMOVING.");
                }
                this.f7426a = b.REMOVED;
                this.f7427b = a.REMOVING;
                this.f7434i = true;
                return;
            }
            if (i4 == 3 && this.f7426a != b.REMOVED) {
                if (I.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f7428c + " mFinalState = " + this.f7426a + " -> " + finalState + com.amazon.a.a.o.c.a.b.f8816a);
                }
                this.f7426a = finalState;
            }
        }

        public void q() {
            this.f7433h = true;
        }

        public final void r(boolean z4) {
            this.f7434i = z4;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f7426a + " lifecycleImpact = " + this.f7427b + " fragment = " + this.f7428c + '}';
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7449a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f7449a = iArr;
        }
    }

    public Z(ViewGroup container) {
        kotlin.jvm.internal.r.f(container, "container");
        this.f7417a = container;
        this.f7418b = new ArrayList();
        this.f7419c = new ArrayList();
    }

    public static final void h(Z this$0, c operation) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        kotlin.jvm.internal.r.f(operation, "$operation");
        if (this$0.f7418b.contains(operation)) {
            d.b bVarH = operation.h();
            View view = operation.i().mView;
            kotlin.jvm.internal.r.e(view, "operation.fragment.mView");
            bVarH.c(view, this$0.f7417a);
        }
    }

    public static final void i(Z this$0, c operation) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        kotlin.jvm.internal.r.f(operation, "$operation");
        this$0.f7418b.remove(operation);
        this$0.f7419c.remove(operation);
    }

    public static final Z u(ViewGroup viewGroup, I i4) {
        return f7416f.a(viewGroup, i4);
    }

    public static final Z v(ViewGroup viewGroup, a0 a0Var) {
        return f7416f.b(viewGroup, a0Var);
    }

    public final void A() {
        for (d dVar : this.f7418b) {
            if (dVar.j() == d.a.ADDING) {
                View viewRequireView = dVar.i().requireView();
                kotlin.jvm.internal.r.e(viewRequireView, "fragment.requireView()");
                dVar.p(d.b.f7441a.b(viewRequireView.getVisibility()), d.a.NONE);
            }
        }
    }

    public final void B(boolean z4) {
        this.f7420d = z4;
    }

    public final void c(d operation) {
        kotlin.jvm.internal.r.f(operation, "operation");
        if (operation.k()) {
            d.b bVarH = operation.h();
            View viewRequireView = operation.i().requireView();
            kotlin.jvm.internal.r.e(viewRequireView, "operation.fragment.requireView()");
            bVarH.c(viewRequireView, this.f7417a);
            operation.r(false);
        }
    }

    public abstract void d(List list, boolean z4);

    public void e(List operations) {
        kotlin.jvm.internal.r.f(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            X2.u.t(arrayList, ((d) it.next()).g());
        }
        List listG0 = X2.x.g0(X2.x.l0(arrayList));
        int size = listG0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((b) listG0.get(i4)).d(this.f7417a);
        }
        int size2 = operations.size();
        for (int i5 = 0; i5 < size2; i5++) {
            c((d) operations.get(i5));
        }
        List listG02 = X2.x.g0(operations);
        int size3 = listG02.size();
        for (int i6 = 0; i6 < size3; i6++) {
            d dVar = (d) listG02.get(i6);
            if (dVar.g().isEmpty()) {
                dVar.e();
            }
        }
    }

    public final void f() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f7419c);
        e(this.f7419c);
    }

    public final void g(d.b bVar, d.a aVar, O o4) {
        synchronized (this.f7418b) {
            try {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pK, "fragmentStateManager.fragment");
                d dVarO = o(abstractComponentCallbacksC0828pK);
                if (dVarO == null) {
                    if (o4.k().mTransitioning) {
                        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK2 = o4.k();
                        kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pK2, "fragmentStateManager.fragment");
                        dVarO = p(abstractComponentCallbacksC0828pK2);
                    } else {
                        dVarO = null;
                    }
                }
                if (dVarO != null) {
                    dVarO.p(bVar, aVar);
                    return;
                }
                final c cVar = new c(bVar, aVar, o4);
                this.f7418b.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.X
                    @Override // java.lang.Runnable
                    public final void run() {
                        Z.h(this.f7412a, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        Z.i(this.f7414a, cVar);
                    }
                });
                W2.E e4 = W2.E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(d.b finalState, O fragmentStateManager) {
        kotlin.jvm.internal.r.f(finalState, "finalState");
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, d.a.ADDING, fragmentStateManager);
    }

    public final void k(O fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.GONE, d.a.NONE, fragmentStateManager);
    }

    public final void l(O fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, fragmentStateManager);
    }

    public final void m(O fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.VISIBLE, d.a.NONE, fragmentStateManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Z.n():void");
    }

    public final d o(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        Object next;
        Iterator it = this.f7418b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.r.b(dVar.i(), abstractComponentCallbacksC0828p) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final d p(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        Object next;
        Iterator it = this.f7419c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.r.b(dVar.i(), abstractComponentCallbacksC0828p) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final void q() {
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f7417a.isAttachedToWindow();
        synchronized (this.f7418b) {
            try {
                A();
                z(this.f7418b);
                for (d dVar : X2.x.j0(this.f7419c)) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f7417a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                    }
                    dVar.c(this.f7417a);
                }
                for (d dVar2 : X2.x.j0(this.f7418b)) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f7417a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                    }
                    dVar2.c(this.f7417a);
                }
                W2.E e4 = W2.E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f7421e) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f7421e = false;
            n();
        }
    }

    public final d.a s(O fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = fragmentStateManager.k();
        kotlin.jvm.internal.r.e(abstractComponentCallbacksC0828pK, "fragmentStateManager.fragment");
        d dVarO = o(abstractComponentCallbacksC0828pK);
        d.a aVarJ = dVarO != null ? dVarO.j() : null;
        d dVarP = p(abstractComponentCallbacksC0828pK);
        d.a aVarJ2 = dVarP != null ? dVarP.j() : null;
        int i4 = aVarJ == null ? -1 : e.f7449a[aVarJ.ordinal()];
        return (i4 == -1 || i4 == 1) ? aVarJ2 : aVarJ;
    }

    public final ViewGroup t() {
        return this.f7417a;
    }

    public final boolean w() {
        return !this.f7418b.isEmpty();
    }

    public final void x() {
        Object objPrevious;
        synchronized (this.f7418b) {
            try {
                A();
                List list = this.f7418b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    d dVar = (d) objPrevious;
                    d.b.a aVar = d.b.f7441a;
                    View view = dVar.i().mView;
                    kotlin.jvm.internal.r.e(view, "operation.fragment.mView");
                    d.b bVarA = aVar.a(view);
                    d.b bVarH = dVar.h();
                    d.b bVar = d.b.VISIBLE;
                    if (bVarH == bVar && bVarA != bVar) {
                        break;
                    }
                }
                d dVar2 = (d) objPrevious;
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI = dVar2 != null ? dVar2.i() : null;
                this.f7421e = abstractComponentCallbacksC0828pI != null ? abstractComponentCallbacksC0828pI.isPostponed() : false;
                W2.E e4 = W2.E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(androidx.activity.b backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
        }
        List list = this.f7419c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            X2.u.t(arrayList, ((d) it.next()).g());
        }
        List listG0 = X2.x.g0(X2.x.l0(arrayList));
        int size = listG0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((b) listG0.get(i4)).e(backEvent, this.f7417a);
        }
    }

    public final void z(List list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((d) list.get(i4)).q();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            X2.u.t(arrayList, ((d) it.next()).g());
        }
        List listG0 = X2.x.g0(X2.x.l0(arrayList));
        int size2 = listG0.size();
        for (int i5 = 0; i5 < size2; i5++) {
            ((b) listG0.get(i5)).g(this.f7417a);
        }
    }
}
