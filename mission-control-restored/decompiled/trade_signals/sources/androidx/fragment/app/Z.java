package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import l0.AbstractC2310b;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public abstract class Z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11712f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f11713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f11715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11717e;

    public static final class a {
        public a() {
        }

        public final Z a(ViewGroup container, I fragmentManager) {
            AbstractC2304t.f(container, "container");
            AbstractC2304t.f(fragmentManager, "fragmentManager");
            a0 a0VarB0 = fragmentManager.B0();
            AbstractC2304t.e(a0VarB0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, a0VarB0);
        }

        public final Z b(ViewGroup container, a0 factory) {
            AbstractC2304t.f(container, "container");
            AbstractC2304t.f(factory, "factory");
            Object tag = container.getTag(AbstractC2310b.f20510b);
            if (tag instanceof Z) {
                return (Z) tag;
            }
            Z zA = factory.a(container);
            AbstractC2304t.e(zA, "factory.createController(container)");
            container.setTag(AbstractC2310b.f20510b, zA);
            return zA;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f11718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11720c;

        public final void a(ViewGroup container) {
            AbstractC2304t.f(container, "container");
            if (!this.f11720c) {
                c(container);
            }
            this.f11720c = true;
        }

        public boolean b() {
            return this.f11718a;
        }

        public abstract void c(ViewGroup viewGroup);

        public abstract void d(ViewGroup viewGroup);

        public void e(androidx.activity.b backEvent, ViewGroup container) {
            AbstractC2304t.f(backEvent, "backEvent");
            AbstractC2304t.f(container, "container");
        }

        public void f(ViewGroup container) {
            AbstractC2304t.f(container, "container");
        }

        public final void g(ViewGroup container) {
            AbstractC2304t.f(container, "container");
            if (!this.f11719b) {
                f(container);
            }
            this.f11719b = true;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final O f11721l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b finalState, d.a lifecycleImpact, O fragmentStateManager) {
            AbstractC2304t.f(finalState, "finalState");
            AbstractC2304t.f(lifecycleImpact, "lifecycleImpact");
            AbstractC2304t.f(fragmentStateManager, "fragmentStateManager");
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = fragmentStateManager.k();
            AbstractC2304t.e(abstractComponentCallbacksC1139pK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, abstractComponentCallbacksC1139pK);
            this.f11721l = fragmentStateManager;
        }

        @Override // androidx.fragment.app.Z.d
        public void e() {
            super.e();
            i().mTransitioning = false;
            this.f11721l.m();
        }

        @Override // androidx.fragment.app.Z.d
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != d.a.ADDING) {
                if (j() == d.a.REMOVING) {
                    AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = this.f11721l.k();
                    AbstractC2304t.e(abstractComponentCallbacksC1139pK, "fragmentStateManager.fragment");
                    View viewRequireView = abstractComponentCallbacksC1139pK.requireView();
                    AbstractC2304t.e(viewRequireView, "fragment.requireView()");
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + abstractComponentCallbacksC1139pK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK2 = this.f11721l.k();
            AbstractC2304t.e(abstractComponentCallbacksC1139pK2, "fragmentStateManager.fragment");
            View viewFindFocus = abstractComponentCallbacksC1139pK2.mView.findFocus();
            if (viewFindFocus != null) {
                abstractComponentCallbacksC1139pK2.setFocusedView(viewFindFocus);
                if (I.J0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC1139pK2);
                }
            }
            View viewRequireView2 = i().requireView();
            AbstractC2304t.e(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                this.f11721l.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(abstractComponentCallbacksC1139pK2.getPostOnViewCreatedAlpha());
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f11722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f11723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractComponentCallbacksC1139p f11724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f11725d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11726e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11727f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11728g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f11729h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11730i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f11731j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List f11732k;

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
            public static final a f11737a = new a(null);

            public static final class a {
                public a() {
                }

                public final b a(View view) {
                    AbstractC2304t.f(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i8) {
                    if (i8 == 0) {
                        return b.VISIBLE;
                    }
                    if (i8 == 4) {
                        return b.INVISIBLE;
                    }
                    if (i8 == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i8);
                }

                public /* synthetic */ a(AbstractC2296k abstractC2296k) {
                    this();
                }
            }

            /* JADX INFO: renamed from: androidx.fragment.app.Z$d$b$b, reason: collision with other inner class name */
            public /* synthetic */ class C0186b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f11743a;

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
                    f11743a = iArr;
                }
            }

            public static final b g(int i8) {
                return f11737a.b(i8);
            }

            public final void b(View view, ViewGroup container) {
                int i8;
                AbstractC2304t.f(view, "view");
                AbstractC2304t.f(container, "container");
                int i9 = C0186b.f11743a[ordinal()];
                if (i9 == 1) {
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
                if (i9 == 2) {
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
                    i8 = 0;
                } else if (i9 != 3) {
                    i8 = 4;
                    if (i9 != 4) {
                        return;
                    }
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                } else {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i8 = 8;
                }
                view.setVisibility(i8);
            }
        }

        public /* synthetic */ class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11744a;

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
                f11744a = iArr;
            }
        }

        public d(b finalState, a lifecycleImpact, AbstractComponentCallbacksC1139p fragment) {
            AbstractC2304t.f(finalState, "finalState");
            AbstractC2304t.f(lifecycleImpact, "lifecycleImpact");
            AbstractC2304t.f(fragment, "fragment");
            this.f11722a = finalState;
            this.f11723b = lifecycleImpact;
            this.f11724c = fragment;
            this.f11725d = new ArrayList();
            this.f11730i = true;
            ArrayList arrayList = new ArrayList();
            this.f11731j = arrayList;
            this.f11732k = arrayList;
        }

        public final void a(Runnable listener) {
            AbstractC2304t.f(listener, "listener");
            this.f11725d.add(listener);
        }

        public final void b(b effect) {
            AbstractC2304t.f(effect, "effect");
            this.f11731j.add(effect);
        }

        public final void c(ViewGroup container) {
            AbstractC2304t.f(container, "container");
            this.f11729h = false;
            if (this.f11726e) {
                return;
            }
            this.f11726e = true;
            if (this.f11731j.isEmpty()) {
                e();
                return;
            }
            Iterator it = p5.z.G0(this.f11732k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z7) {
            AbstractC2304t.f(container, "container");
            if (this.f11726e) {
                return;
            }
            if (z7) {
                this.f11728g = true;
            }
            c(container);
        }

        public void e() {
            this.f11729h = false;
            if (this.f11727f) {
                return;
            }
            if (I.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f11727f = true;
            Iterator it = this.f11725d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            AbstractC2304t.f(effect, "effect");
            if (this.f11731j.remove(effect) && this.f11731j.isEmpty()) {
                e();
            }
        }

        public final List g() {
            return this.f11732k;
        }

        public final b h() {
            return this.f11722a;
        }

        public final AbstractComponentCallbacksC1139p i() {
            return this.f11724c;
        }

        public final a j() {
            return this.f11723b;
        }

        public final boolean k() {
            return this.f11730i;
        }

        public final boolean l() {
            return this.f11726e;
        }

        public final boolean m() {
            return this.f11727f;
        }

        public final boolean n() {
            return this.f11728g;
        }

        public final boolean o() {
            return this.f11729h;
        }

        public final void p(b finalState, a lifecycleImpact) {
            a aVar;
            AbstractC2304t.f(finalState, "finalState");
            AbstractC2304t.f(lifecycleImpact, "lifecycleImpact");
            int i8 = c.f11744a[lifecycleImpact.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3 && this.f11722a != b.REMOVED) {
                        if (I.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f11724c + " mFinalState = " + this.f11722a + " -> " + finalState + com.amazon.a.a.o.c.a.b.f14112a);
                        }
                        this.f11722a = finalState;
                        return;
                    }
                    return;
                }
                if (I.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f11724c + " mFinalState = " + this.f11722a + " -> REMOVED. mLifecycleImpact  = " + this.f11723b + " to REMOVING.");
                }
                this.f11722a = b.REMOVED;
                aVar = a.REMOVING;
            } else {
                if (this.f11722a != b.REMOVED) {
                    return;
                }
                if (I.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f11724c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f11723b + " to ADDING.");
                }
                this.f11722a = b.VISIBLE;
                aVar = a.ADDING;
            }
            this.f11723b = aVar;
            this.f11730i = true;
        }

        public void q() {
            this.f11729h = true;
        }

        public final void r(boolean z7) {
            this.f11730i = z7;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f11722a + " lifecycleImpact = " + this.f11723b + " fragment = " + this.f11724c + '}';
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11745a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f11745a = iArr;
        }
    }

    public Z(ViewGroup container) {
        AbstractC2304t.f(container, "container");
        this.f11713a = container;
        this.f11714b = new ArrayList();
        this.f11715c = new ArrayList();
    }

    public static final void h(Z this$0, c operation) {
        AbstractC2304t.f(this$0, "this$0");
        AbstractC2304t.f(operation, "$operation");
        if (this$0.f11714b.contains(operation)) {
            d.b bVarH = operation.h();
            View view = operation.i().mView;
            AbstractC2304t.e(view, "operation.fragment.mView");
            bVarH.b(view, this$0.f11713a);
        }
    }

    public static final void i(Z this$0, c operation) {
        AbstractC2304t.f(this$0, "this$0");
        AbstractC2304t.f(operation, "$operation");
        this$0.f11714b.remove(operation);
        this$0.f11715c.remove(operation);
    }

    public static final Z u(ViewGroup viewGroup, I i8) {
        return f11712f.a(viewGroup, i8);
    }

    public static final Z v(ViewGroup viewGroup, a0 a0Var) {
        return f11712f.b(viewGroup, a0Var);
    }

    public final void A() {
        for (d dVar : this.f11714b) {
            if (dVar.j() == d.a.ADDING) {
                View viewRequireView = dVar.i().requireView();
                AbstractC2304t.e(viewRequireView, "fragment.requireView()");
                dVar.p(d.b.f11737a.b(viewRequireView.getVisibility()), d.a.NONE);
            }
        }
    }

    public final void B(boolean z7) {
        this.f11716d = z7;
    }

    public final void c(d operation) {
        AbstractC2304t.f(operation, "operation");
        if (operation.k()) {
            d.b bVarH = operation.h();
            View viewRequireView = operation.i().requireView();
            AbstractC2304t.e(viewRequireView, "operation.fragment.requireView()");
            bVarH.b(viewRequireView, this.f11713a);
            operation.r(false);
        }
    }

    public abstract void d(List list, boolean z7);

    public void e(List operations) {
        AbstractC2304t.f(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            p5.v.x(arrayList, ((d) it.next()).g());
        }
        List listG0 = p5.z.G0(p5.z.K0(arrayList));
        int size = listG0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((b) listG0.get(i8)).d(this.f11713a);
        }
        int size2 = operations.size();
        for (int i9 = 0; i9 < size2; i9++) {
            c((d) operations.get(i9));
        }
        List listG02 = p5.z.G0(operations);
        int size3 = listG02.size();
        for (int i10 = 0; i10 < size3; i10++) {
            d dVar = (d) listG02.get(i10);
            if (dVar.g().isEmpty()) {
                dVar.e();
            }
        }
    }

    public final void f() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f11715c);
        e(this.f11715c);
    }

    public final void g(d.b bVar, d.a aVar, O o8) {
        synchronized (this.f11714b) {
            try {
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = o8.k();
                AbstractC2304t.e(abstractComponentCallbacksC1139pK, "fragmentStateManager.fragment");
                d dVarO = o(abstractComponentCallbacksC1139pK);
                if (dVarO == null) {
                    if (o8.k().mTransitioning) {
                        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK2 = o8.k();
                        AbstractC2304t.e(abstractComponentCallbacksC1139pK2, "fragmentStateManager.fragment");
                        dVarO = p(abstractComponentCallbacksC1139pK2);
                    } else {
                        dVarO = null;
                    }
                }
                if (dVarO != null) {
                    dVarO.p(bVar, aVar);
                    return;
                }
                final c cVar = new c(bVar, aVar, o8);
                this.f11714b.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.X
                    @Override // java.lang.Runnable
                    public final void run() {
                        Z.h(this.f11708a, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        Z.i(this.f11710a, cVar);
                    }
                });
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(d.b finalState, O fragmentStateManager) {
        AbstractC2304t.f(finalState, "finalState");
        AbstractC2304t.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, d.a.ADDING, fragmentStateManager);
    }

    public final void k(O fragmentStateManager) {
        AbstractC2304t.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.GONE, d.a.NONE, fragmentStateManager);
    }

    public final void l(O fragmentStateManager) {
        AbstractC2304t.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, fragmentStateManager);
    }

    public final void m(O fragmentStateManager) {
        AbstractC2304t.f(fragmentStateManager, "fragmentStateManager");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.VISIBLE, d.a.NONE, fragmentStateManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Z.n():void");
    }

    public final d o(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        Object next;
        Iterator it = this.f11714b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (AbstractC2304t.b(dVar.i(), abstractComponentCallbacksC1139p) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final d p(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        Object next;
        Iterator it = this.f11715c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (AbstractC2304t.b(dVar.i(), abstractComponentCallbacksC1139p) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final void q() {
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f11713a.isAttachedToWindow();
        synchronized (this.f11714b) {
            try {
                A();
                z(this.f11714b);
                for (d dVar : p5.z.I0(this.f11715c)) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f11713a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                    }
                    dVar.c(this.f11713a);
                }
                for (d dVar2 : p5.z.I0(this.f11714b)) {
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f11713a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                    }
                    dVar2.c(this.f11713a);
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f11717e) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f11717e = false;
            n();
        }
    }

    public final d.a s(O fragmentStateManager) {
        AbstractC2304t.f(fragmentStateManager, "fragmentStateManager");
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pK = fragmentStateManager.k();
        AbstractC2304t.e(abstractComponentCallbacksC1139pK, "fragmentStateManager.fragment");
        d dVarO = o(abstractComponentCallbacksC1139pK);
        d.a aVarJ = dVarO != null ? dVarO.j() : null;
        d dVarP = p(abstractComponentCallbacksC1139pK);
        d.a aVarJ2 = dVarP != null ? dVarP.j() : null;
        int i8 = aVarJ == null ? -1 : e.f11745a[aVarJ.ordinal()];
        return (i8 == -1 || i8 == 1) ? aVarJ2 : aVarJ;
    }

    public final ViewGroup t() {
        return this.f11713a;
    }

    public final boolean w() {
        return !this.f11714b.isEmpty();
    }

    public final void x() {
        Object objPrevious;
        synchronized (this.f11714b) {
            try {
                A();
                List list = this.f11714b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    d dVar = (d) objPrevious;
                    d.b.a aVar = d.b.f11737a;
                    View view = dVar.i().mView;
                    AbstractC2304t.e(view, "operation.fragment.mView");
                    d.b bVarA = aVar.a(view);
                    d.b bVarH = dVar.h();
                    d.b bVar = d.b.VISIBLE;
                    if (bVarH == bVar && bVarA != bVar) {
                        break;
                    }
                }
                d dVar2 = (d) objPrevious;
                AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pI = dVar2 != null ? dVar2.i() : null;
                this.f11717e = abstractComponentCallbacksC1139pI != null ? abstractComponentCallbacksC1139pI.isPostponed() : false;
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(androidx.activity.b backEvent) {
        AbstractC2304t.f(backEvent, "backEvent");
        if (I.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
        }
        List list = this.f11715c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p5.v.x(arrayList, ((d) it.next()).g());
        }
        List listG0 = p5.z.G0(p5.z.K0(arrayList));
        int size = listG0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((b) listG0.get(i8)).e(backEvent, this.f11713a);
        }
    }

    public final void z(List list) {
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((d) list.get(i8)).q();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p5.v.x(arrayList, ((d) it.next()).g());
        }
        List listG0 = p5.z.G0(p5.z.K0(arrayList));
        int size2 = listG0.size();
        for (int i9 = 0; i9 < size2; i9++) {
            ((b) listG0.get(i9)).g(this.f11713a);
        }
    }
}
