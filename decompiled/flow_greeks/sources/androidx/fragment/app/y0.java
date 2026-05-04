package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f2349f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f2350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f2351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2354e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final y0 a(ViewGroup container, i0 fragmentManager) {
            kotlin.jvm.internal.t.f(container, "container");
            kotlin.jvm.internal.t.f(fragmentManager, "fragmentManager");
            z0 z0VarB0 = fragmentManager.B0();
            kotlin.jvm.internal.t.e(z0VarB0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, z0VarB0);
        }

        public final y0 b(ViewGroup container, z0 factory) {
            kotlin.jvm.internal.t.f(container, "container");
            kotlin.jvm.internal.t.f(factory, "factory");
            Object tag = container.getTag(u1.b.f22143b);
            if (tag instanceof y0) {
                return (y0) tag;
            }
            y0 y0VarA = factory.a(container);
            kotlin.jvm.internal.t.e(y0VarA, "factory.createController(container)");
            container.setTag(u1.b.f22143b, y0VarA);
            return y0VarA;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2357c;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            if (!this.f2357c) {
                c(container);
            }
            this.f2357c = true;
        }

        public boolean b() {
            return this.f2355a;
        }

        public abstract void c(ViewGroup viewGroup);

        public abstract void d(ViewGroup viewGroup);

        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.t.f(backEvent, "backEvent");
            kotlin.jvm.internal.t.f(container, "container");
        }

        public void f(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
        }

        public final void g(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            if (!this.f2356b) {
                f(container);
            }
            this.f2356b = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final o0 f2358l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b finalState, d.a lifecycleImpact, o0 fragmentStateManager) {
            kotlin.jvm.internal.t.f(finalState, "finalState");
            kotlin.jvm.internal.t.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.t.f(fragmentStateManager, "fragmentStateManager");
            p pVarK = fragmentStateManager.k();
            kotlin.jvm.internal.t.e(pVarK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, pVarK);
            this.f2358l = fragmentStateManager;
        }

        @Override // androidx.fragment.app.y0.d
        public void e() {
            super.e();
            i().mTransitioning = false;
            this.f2358l.m();
        }

        @Override // androidx.fragment.app.y0.d
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != d.a.ADDING) {
                if (j() == d.a.REMOVING) {
                    p pVarK = this.f2358l.k();
                    kotlin.jvm.internal.t.e(pVarK, "fragmentStateManager.fragment");
                    View viewRequireView = pVarK.requireView();
                    kotlin.jvm.internal.t.e(viewRequireView, "fragment.requireView()");
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + pVarK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            p pVarK2 = this.f2358l.k();
            kotlin.jvm.internal.t.e(pVarK2, "fragmentStateManager.fragment");
            View viewFindFocus = pVarK2.mView.findFocus();
            if (viewFindFocus != null) {
                pVarK2.setFocusedView(viewFindFocus);
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + pVarK2);
                }
            }
            View viewRequireView2 = i().requireView();
            kotlin.jvm.internal.t.e(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                this.f2358l.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(pVarK2.getPostOnViewCreatedAlpha());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f2359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f2360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f2361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f2362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2363e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2364f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2365g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2366h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2367i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f2368j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List f2369k;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f2374a = new a(null);

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class a {
                public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                    this();
                }

                public final b a(View view) {
                    kotlin.jvm.internal.t.f(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i10) {
                    if (i10 == 0) {
                        return b.VISIBLE;
                    }
                    if (i10 == 4) {
                        return b.INVISIBLE;
                    }
                    if (i10 == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i10);
                }

                public a() {
                }
            }

            /* JADX INFO: renamed from: androidx.fragment.app.y0$d$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public /* synthetic */ class C0029b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f2380a;

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
                    f2380a = iArr;
                }
            }

            public static final b c(int i10) {
                return f2374a.b(i10);
            }

            public final void b(View view, ViewGroup container) {
                kotlin.jvm.internal.t.f(view, "view");
                kotlin.jvm.internal.t.f(container, "container");
                int i10 = C0029b.f2380a[ordinal()];
                if (i10 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (i0.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (i0.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2381a;

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
                f2381a = iArr;
            }
        }

        public d(b finalState, a lifecycleImpact, p fragment) {
            kotlin.jvm.internal.t.f(finalState, "finalState");
            kotlin.jvm.internal.t.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.t.f(fragment, "fragment");
            this.f2359a = finalState;
            this.f2360b = lifecycleImpact;
            this.f2361c = fragment;
            this.f2362d = new ArrayList();
            this.f2367i = true;
            ArrayList arrayList = new ArrayList();
            this.f2368j = arrayList;
            this.f2369k = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.t.f(listener, "listener");
            this.f2362d.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.t.f(effect, "effect");
            this.f2368j.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.t.f(container, "container");
            this.f2366h = false;
            if (this.f2363e) {
                return;
            }
            this.f2363e = true;
            if (this.f2368j.isEmpty()) {
                e();
                return;
            }
            Iterator it = dd.a0.I0(this.f2369k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z10) {
            kotlin.jvm.internal.t.f(container, "container");
            if (this.f2363e) {
                return;
            }
            if (z10) {
                this.f2365g = true;
            }
            c(container);
        }

        public void e() {
            this.f2366h = false;
            if (this.f2364f) {
                return;
            }
            if (i0.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f2364f = true;
            Iterator it = this.f2362d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            kotlin.jvm.internal.t.f(effect, "effect");
            if (this.f2368j.remove(effect) && this.f2368j.isEmpty()) {
                e();
            }
        }

        public final List g() {
            return this.f2369k;
        }

        public final b h() {
            return this.f2359a;
        }

        public final p i() {
            return this.f2361c;
        }

        public final a j() {
            return this.f2360b;
        }

        public final boolean k() {
            return this.f2367i;
        }

        public final boolean l() {
            return this.f2363e;
        }

        public final boolean m() {
            return this.f2364f;
        }

        public final boolean n() {
            return this.f2365g;
        }

        public final boolean o() {
            return this.f2366h;
        }

        public final void p(b finalState, a lifecycleImpact) {
            kotlin.jvm.internal.t.f(finalState, "finalState");
            kotlin.jvm.internal.t.f(lifecycleImpact, "lifecycleImpact");
            int i10 = c.f2381a[lifecycleImpact.ordinal()];
            if (i10 == 1) {
                if (this.f2359a == b.REMOVED) {
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2361c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2360b + " to ADDING.");
                    }
                    this.f2359a = b.VISIBLE;
                    this.f2360b = a.ADDING;
                    this.f2367i = true;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2361c + " mFinalState = " + this.f2359a + " -> REMOVED. mLifecycleImpact  = " + this.f2360b + " to REMOVING.");
                }
                this.f2359a = b.REMOVED;
                this.f2360b = a.REMOVING;
                this.f2367i = true;
                return;
            }
            if (i10 == 3 && this.f2359a != b.REMOVED) {
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2361c + " mFinalState = " + this.f2359a + " -> " + finalState + com.amazon.a.a.o.c.a.b.f4610a);
                }
                this.f2359a = finalState;
            }
        }

        public void q() {
            this.f2366h = true;
        }

        public final void r(boolean z10) {
            this.f2367i = z10;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f2359a + " lifecycleImpact = " + this.f2360b + " fragment = " + this.f2361c + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2382a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f2382a = iArr;
        }
    }

    public y0(ViewGroup container) {
        kotlin.jvm.internal.t.f(container, "container");
        this.f2350a = container;
        this.f2351b = new ArrayList();
        this.f2352c = new ArrayList();
    }

    public static final void h(y0 this$0, c operation) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        kotlin.jvm.internal.t.f(operation, "$operation");
        if (this$0.f2351b.contains(operation)) {
            d.b bVarH = operation.h();
            View view = operation.i().mView;
            kotlin.jvm.internal.t.e(view, "operation.fragment.mView");
            bVarH.b(view, this$0.f2350a);
        }
    }

    public static final void i(y0 this$0, c operation) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        kotlin.jvm.internal.t.f(operation, "$operation");
        this$0.f2351b.remove(operation);
        this$0.f2352c.remove(operation);
    }

    public static final y0 u(ViewGroup viewGroup, i0 i0Var) {
        return f2349f.a(viewGroup, i0Var);
    }

    public static final y0 v(ViewGroup viewGroup, z0 z0Var) {
        return f2349f.b(viewGroup, z0Var);
    }

    public final void A() {
        for (d dVar : this.f2351b) {
            if (dVar.j() == d.a.ADDING) {
                View viewRequireView = dVar.i().requireView();
                kotlin.jvm.internal.t.e(viewRequireView, "fragment.requireView()");
                dVar.p(d.b.f2374a.b(viewRequireView.getVisibility()), d.a.NONE);
            }
        }
    }

    public final void B(boolean z10) {
        this.f2353d = z10;
    }

    public final void c(d operation) {
        kotlin.jvm.internal.t.f(operation, "operation");
        if (operation.k()) {
            d.b bVarH = operation.h();
            View viewRequireView = operation.i().requireView();
            kotlin.jvm.internal.t.e(viewRequireView, "operation.fragment.requireView()");
            bVarH.b(viewRequireView, this.f2350a);
            operation.r(false);
        }
    }

    public abstract void d(List list, boolean z10);

    public void e(List operations) {
        kotlin.jvm.internal.t.f(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList, ((d) it.next()).g());
        }
        List listI0 = dd.a0.I0(dd.a0.N0(arrayList));
        int size = listI0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listI0.get(i10)).d(this.f2350a);
        }
        int size2 = operations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            c((d) operations.get(i11));
        }
        List listI02 = dd.a0.I0(operations);
        int size3 = listI02.size();
        for (int i12 = 0; i12 < size3; i12++) {
            d dVar = (d) listI02.get(i12);
            if (dVar.g().isEmpty()) {
                dVar.e();
            }
        }
    }

    public final void f() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f2352c);
        e(this.f2352c);
    }

    public final void g(d.b bVar, d.a aVar, o0 o0Var) {
        synchronized (this.f2351b) {
            try {
                p pVarK = o0Var.k();
                kotlin.jvm.internal.t.e(pVarK, "fragmentStateManager.fragment");
                d dVarO = o(pVarK);
                if (dVarO == null) {
                    if (o0Var.k().mTransitioning) {
                        p pVarK2 = o0Var.k();
                        kotlin.jvm.internal.t.e(pVarK2, "fragmentStateManager.fragment");
                        dVarO = p(pVarK2);
                    } else {
                        dVarO = null;
                    }
                }
                if (dVarO != null) {
                    dVarO.p(bVar, aVar);
                    return;
                }
                final c cVar = new c(bVar, aVar, o0Var);
                this.f2351b.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.w0
                    @Override // java.lang.Runnable
                    public final void run() {
                        y0.h(this.f2339a, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        y0.i(this.f2346a, cVar);
                    }
                });
                cd.h0 h0Var = cd.h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(d.b finalState, o0 fragmentStateManager) {
        kotlin.jvm.internal.t.f(finalState, "finalState");
        kotlin.jvm.internal.t.f(fragmentStateManager, "fragmentStateManager");
        if (i0.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, d.a.ADDING, fragmentStateManager);
    }

    public final void k(o0 fragmentStateManager) {
        kotlin.jvm.internal.t.f(fragmentStateManager, "fragmentStateManager");
        if (i0.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.GONE, d.a.NONE, fragmentStateManager);
    }

    public final void l(o0 fragmentStateManager) {
        kotlin.jvm.internal.t.f(fragmentStateManager, "fragmentStateManager");
        if (i0.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, fragmentStateManager);
    }

    public final void m(o0 fragmentStateManager) {
        kotlin.jvm.internal.t.f(fragmentStateManager, "fragmentStateManager");
        if (i0.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.VISIBLE, d.a.NONE, fragmentStateManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.y0.n():void");
    }

    public final d o(p pVar) {
        Object next;
        Iterator it = this.f2351b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.t.b(dVar.i(), pVar) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final d p(p pVar) {
        Object next;
        Iterator it = this.f2352c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.t.b(dVar.i(), pVar) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final void q() {
        if (i0.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f2350a.isAttachedToWindow();
        synchronized (this.f2351b) {
            try {
                A();
                z(this.f2351b);
                for (d dVar : dd.a0.L0(this.f2352c)) {
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f2350a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                    }
                    dVar.c(this.f2350a);
                }
                for (d dVar2 : dd.a0.L0(this.f2351b)) {
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f2350a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                    }
                    dVar2.c(this.f2350a);
                }
                cd.h0 h0Var = cd.h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f2354e) {
            if (i0.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f2354e = false;
            n();
        }
    }

    public final d.a s(o0 fragmentStateManager) {
        kotlin.jvm.internal.t.f(fragmentStateManager, "fragmentStateManager");
        p pVarK = fragmentStateManager.k();
        kotlin.jvm.internal.t.e(pVarK, "fragmentStateManager.fragment");
        d dVarO = o(pVarK);
        d.a aVarJ = dVarO != null ? dVarO.j() : null;
        d dVarP = p(pVarK);
        d.a aVarJ2 = dVarP != null ? dVarP.j() : null;
        int i10 = aVarJ == null ? -1 : e.f2382a[aVarJ.ordinal()];
        return (i10 == -1 || i10 == 1) ? aVarJ2 : aVarJ;
    }

    public final ViewGroup t() {
        return this.f2350a;
    }

    public final boolean w() {
        return !this.f2351b.isEmpty();
    }

    public final void x() {
        Object objPrevious;
        synchronized (this.f2351b) {
            try {
                A();
                List list = this.f2351b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    d dVar = (d) objPrevious;
                    d.b.a aVar = d.b.f2374a;
                    View view = dVar.i().mView;
                    kotlin.jvm.internal.t.e(view, "operation.fragment.mView");
                    d.b bVarA = aVar.a(view);
                    d.b bVarH = dVar.h();
                    d.b bVar = d.b.VISIBLE;
                    if (bVarH == bVar && bVarA != bVar) {
                        break;
                    }
                }
                d dVar2 = (d) objPrevious;
                p pVarI = dVar2 != null ? dVar2.i() : null;
                this.f2354e = pVarI != null ? pVarI.isPostponed() : false;
                cd.h0 h0Var = cd.h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(androidx.activity.b backEvent) {
        kotlin.jvm.internal.t.f(backEvent, "backEvent");
        if (i0.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
        }
        List list = this.f2352c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList, ((d) it.next()).g());
        }
        List listI0 = dd.a0.I0(dd.a0.N0(arrayList));
        int size = listI0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listI0.get(i10)).e(backEvent, this.f2350a);
        }
    }

    public final void z(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((d) list.get(i10)).q();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList, ((d) it.next()).g());
        }
        List listI0 = dd.a0.I0(dd.a0.N0(arrayList));
        int size2 = listI0.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((b) listI0.get(i11)).g(this.f2350a);
        }
    }
}
