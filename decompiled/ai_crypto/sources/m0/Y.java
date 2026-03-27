package m0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import d.C1386b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.AbstractC2148j;
import l0.AbstractC2153b;

/* JADX INFO: loaded from: classes.dex */
public abstract class Y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f18692f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f18693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f18695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18697e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final Y a(ViewGroup container, AbstractC2190H fragmentManager) {
            kotlin.jvm.internal.r.f(container, "container");
            kotlin.jvm.internal.r.f(fragmentManager, "fragmentManager");
            Z zA0 = fragmentManager.A0();
            kotlin.jvm.internal.r.e(zA0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, zA0);
        }

        public final Y b(ViewGroup container, Z factory) {
            kotlin.jvm.internal.r.f(container, "container");
            kotlin.jvm.internal.r.f(factory, "factory");
            Object tag = container.getTag(AbstractC2153b.f18282b);
            if (tag instanceof Y) {
                return (Y) tag;
            }
            Y yA = factory.a(container);
            kotlin.jvm.internal.r.e(yA, "factory.createController(container)");
            container.setTag(AbstractC2153b.f18282b, yA);
            return yA;
        }

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18700c;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (!this.f18700c) {
                c(container);
            }
            this.f18700c = true;
        }

        public boolean b() {
            return this.f18698a;
        }

        public abstract void c(ViewGroup viewGroup);

        public abstract void d(ViewGroup viewGroup);

        public void e(C1386b backEvent, ViewGroup container) {
            kotlin.jvm.internal.r.f(backEvent, "backEvent");
            kotlin.jvm.internal.r.f(container, "container");
        }

        public void f(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
        }

        public final void g(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            if (!this.f18699b) {
                f(container);
            }
            this.f18699b = true;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final C2196N f18701l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b finalState, d.a lifecycleImpact, C2196N fragmentStateManager) {
            kotlin.jvm.internal.r.f(finalState, "finalState");
            kotlin.jvm.internal.r.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = fragmentStateManager.k();
            kotlin.jvm.internal.r.e(abstractComponentCallbacksC2216pK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, abstractComponentCallbacksC2216pK);
            this.f18701l = fragmentStateManager;
        }

        @Override // m0.Y.d
        public void e() {
            super.e();
            i().f18877n = false;
            this.f18701l.m();
        }

        @Override // m0.Y.d
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != d.a.ADDING) {
                if (j() == d.a.REMOVING) {
                    AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = this.f18701l.k();
                    kotlin.jvm.internal.r.e(abstractComponentCallbacksC2216pK, "fragmentStateManager.fragment");
                    View viewR1 = abstractComponentCallbacksC2216pK.r1();
                    kotlin.jvm.internal.r.e(viewR1, "fragment.requireView()");
                    if (AbstractC2190H.I0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewR1.findFocus() + " on view " + viewR1 + " for Fragment " + abstractComponentCallbacksC2216pK);
                    }
                    viewR1.clearFocus();
                    return;
                }
                return;
            }
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK2 = this.f18701l.k();
            kotlin.jvm.internal.r.e(abstractComponentCallbacksC2216pK2, "fragmentStateManager.fragment");
            View viewFindFocus = abstractComponentCallbacksC2216pK2.f18844J.findFocus();
            if (viewFindFocus != null) {
                abstractComponentCallbacksC2216pK2.x1(viewFindFocus);
                if (AbstractC2190H.I0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC2216pK2);
                }
            }
            View viewR12 = i().r1();
            kotlin.jvm.internal.r.e(viewR12, "this.fragment.requireView()");
            if (viewR12.getParent() == null) {
                this.f18701l.b();
                viewR12.setAlpha(0.0f);
            }
            if (viewR12.getAlpha() == 0.0f && viewR12.getVisibility() == 0) {
                viewR12.setVisibility(4);
            }
            viewR12.setAlpha(abstractComponentCallbacksC2216pK2.L());
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f18702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f18703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractComponentCallbacksC2216p f18704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f18705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f18707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f18708g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f18709h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f18710i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f18711j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List f18712k;

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
            public static final a f18717a = new a(null);

            public static final class a {
                public /* synthetic */ a(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b a(View view) {
                    kotlin.jvm.internal.r.f(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i7) {
                    if (i7 == 0) {
                        return b.VISIBLE;
                    }
                    if (i7 == 4) {
                        return b.INVISIBLE;
                    }
                    if (i7 == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i7);
                }

                public a() {
                }
            }

            /* JADX INFO: renamed from: m0.Y$d$b$b, reason: collision with other inner class name */
            public /* synthetic */ class C0306b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f18723a;

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
                    f18723a = iArr;
                }
            }

            public static final b c(int i7) {
                return f18717a.b(i7);
            }

            public final void b(View view, ViewGroup container) {
                kotlin.jvm.internal.r.f(view, "view");
                kotlin.jvm.internal.r.f(container, "container");
                int i7 = C0306b.f18723a[ordinal()];
                if (i7 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (AbstractC2190H.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i7 == 2) {
                    if (AbstractC2190H.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (AbstractC2190H.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i7 == 3) {
                    if (AbstractC2190H.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i7 != 4) {
                    return;
                }
                if (AbstractC2190H.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public /* synthetic */ class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f18724a;

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
                f18724a = iArr;
            }
        }

        public d(b finalState, a lifecycleImpact, AbstractComponentCallbacksC2216p fragment) {
            kotlin.jvm.internal.r.f(finalState, "finalState");
            kotlin.jvm.internal.r.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.r.f(fragment, "fragment");
            this.f18702a = finalState;
            this.f18703b = lifecycleImpact;
            this.f18704c = fragment;
            this.f18705d = new ArrayList();
            this.f18710i = true;
            ArrayList arrayList = new ArrayList();
            this.f18711j = arrayList;
            this.f18712k = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.r.f(listener, "listener");
            this.f18705d.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.r.f(effect, "effect");
            this.f18711j.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.r.f(container, "container");
            this.f18709h = false;
            if (this.f18706e) {
                return;
            }
            this.f18706e = true;
            if (this.f18711j.isEmpty()) {
                e();
                return;
            }
            Iterator it = F5.v.h0(this.f18712k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z7) {
            kotlin.jvm.internal.r.f(container, "container");
            if (this.f18706e) {
                return;
            }
            if (z7) {
                this.f18708g = true;
            }
            c(container);
        }

        public void e() {
            this.f18709h = false;
            if (this.f18707f) {
                return;
            }
            if (AbstractC2190H.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f18707f = true;
            Iterator it = this.f18705d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            kotlin.jvm.internal.r.f(effect, "effect");
            if (this.f18711j.remove(effect) && this.f18711j.isEmpty()) {
                e();
            }
        }

        public final List g() {
            return this.f18712k;
        }

        public final b h() {
            return this.f18702a;
        }

        public final AbstractComponentCallbacksC2216p i() {
            return this.f18704c;
        }

        public final a j() {
            return this.f18703b;
        }

        public final boolean k() {
            return this.f18710i;
        }

        public final boolean l() {
            return this.f18706e;
        }

        public final boolean m() {
            return this.f18707f;
        }

        public final boolean n() {
            return this.f18708g;
        }

        public final boolean o() {
            return this.f18709h;
        }

        public final void p(b finalState, a lifecycleImpact) {
            kotlin.jvm.internal.r.f(finalState, "finalState");
            kotlin.jvm.internal.r.f(lifecycleImpact, "lifecycleImpact");
            int i7 = c.f18724a[lifecycleImpact.ordinal()];
            if (i7 == 1) {
                if (this.f18702a == b.REMOVED) {
                    if (AbstractC2190H.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f18704c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f18703b + " to ADDING.");
                    }
                    this.f18702a = b.VISIBLE;
                    this.f18703b = a.ADDING;
                    this.f18710i = true;
                    return;
                }
                return;
            }
            if (i7 == 2) {
                if (AbstractC2190H.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f18704c + " mFinalState = " + this.f18702a + " -> REMOVED. mLifecycleImpact  = " + this.f18703b + " to REMOVING.");
                }
                this.f18702a = b.REMOVED;
                this.f18703b = a.REMOVING;
                this.f18710i = true;
                return;
            }
            if (i7 == 3 && this.f18702a != b.REMOVED) {
                if (AbstractC2190H.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f18704c + " mFinalState = " + this.f18702a + " -> " + finalState + com.amazon.a.a.o.c.a.b.f10001a);
                }
                this.f18702a = finalState;
            }
        }

        public void q() {
            this.f18709h = true;
        }

        public final void r(boolean z7) {
            this.f18710i = z7;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f18702a + " lifecycleImpact = " + this.f18703b + " fragment = " + this.f18704c + '}';
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18725a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f18725a = iArr;
        }
    }

    public Y(ViewGroup container) {
        kotlin.jvm.internal.r.f(container, "container");
        this.f18693a = container;
        this.f18694b = new ArrayList();
        this.f18695c = new ArrayList();
    }

    public static final void h(Y this$0, c operation) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        kotlin.jvm.internal.r.f(operation, "$operation");
        if (this$0.f18694b.contains(operation)) {
            d.b bVarH = operation.h();
            View view = operation.i().f18844J;
            kotlin.jvm.internal.r.e(view, "operation.fragment.mView");
            bVarH.b(view, this$0.f18693a);
        }
    }

    public static final void i(Y this$0, c operation) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        kotlin.jvm.internal.r.f(operation, "$operation");
        this$0.f18694b.remove(operation);
        this$0.f18695c.remove(operation);
    }

    public static final Y u(ViewGroup viewGroup, AbstractC2190H abstractC2190H) {
        return f18692f.a(viewGroup, abstractC2190H);
    }

    public static final Y v(ViewGroup viewGroup, Z z7) {
        return f18692f.b(viewGroup, z7);
    }

    public final void A() {
        for (d dVar : this.f18694b) {
            if (dVar.j() == d.a.ADDING) {
                View viewR1 = dVar.i().r1();
                kotlin.jvm.internal.r.e(viewR1, "fragment.requireView()");
                dVar.p(d.b.f18717a.b(viewR1.getVisibility()), d.a.NONE);
            }
        }
    }

    public final void B(boolean z7) {
        this.f18696d = z7;
    }

    public final void c(d operation) {
        kotlin.jvm.internal.r.f(operation, "operation");
        if (operation.k()) {
            d.b bVarH = operation.h();
            View viewR1 = operation.i().r1();
            kotlin.jvm.internal.r.e(viewR1, "operation.fragment.requireView()");
            bVarH.b(viewR1, this.f18693a);
            operation.r(false);
        }
    }

    public abstract void d(List list, boolean z7);

    public void e(List operations) {
        kotlin.jvm.internal.r.f(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            F5.s.t(arrayList, ((d) it.next()).g());
        }
        List listH0 = F5.v.h0(F5.v.m0(arrayList));
        int size = listH0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((b) listH0.get(i7)).d(this.f18693a);
        }
        int size2 = operations.size();
        for (int i8 = 0; i8 < size2; i8++) {
            c((d) operations.get(i8));
        }
        List listH02 = F5.v.h0(operations);
        int size3 = listH02.size();
        for (int i9 = 0; i9 < size3; i9++) {
            d dVar = (d) listH02.get(i9);
            if (dVar.g().isEmpty()) {
                dVar.e();
            }
        }
    }

    public final void f() {
        if (AbstractC2190H.I0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f18695c);
        e(this.f18695c);
    }

    public final void g(d.b bVar, d.a aVar, C2196N c2196n) {
        synchronized (this.f18694b) {
            try {
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = c2196n.k();
                kotlin.jvm.internal.r.e(abstractComponentCallbacksC2216pK, "fragmentStateManager.fragment");
                d dVarO = o(abstractComponentCallbacksC2216pK);
                if (dVarO == null) {
                    if (c2196n.k().f18877n) {
                        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK2 = c2196n.k();
                        kotlin.jvm.internal.r.e(abstractComponentCallbacksC2216pK2, "fragmentStateManager.fragment");
                        dVarO = p(abstractComponentCallbacksC2216pK2);
                    } else {
                        dVarO = null;
                    }
                }
                if (dVarO != null) {
                    dVarO.p(bVar, aVar);
                    return;
                }
                final c cVar = new c(bVar, aVar, c2196n);
                this.f18694b.add(cVar);
                cVar.a(new Runnable() { // from class: m0.W
                    @Override // java.lang.Runnable
                    public final void run() {
                        Y.h(this.f18688a, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: m0.X
                    @Override // java.lang.Runnable
                    public final void run() {
                        Y.i(this.f18690a, cVar);
                    }
                });
                E5.E e7 = E5.E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(d.b finalState, C2196N fragmentStateManager) {
        kotlin.jvm.internal.r.f(finalState, "finalState");
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (AbstractC2190H.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, d.a.ADDING, fragmentStateManager);
    }

    public final void k(C2196N fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (AbstractC2190H.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.GONE, d.a.NONE, fragmentStateManager);
    }

    public final void l(C2196N fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (AbstractC2190H.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, fragmentStateManager);
    }

    public final void m(C2196N fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        if (AbstractC2190H.I0(2)) {
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
        throw new UnsupportedOperationException("Method not decompiled: m0.Y.n():void");
    }

    public final d o(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        Object next;
        Iterator it = this.f18694b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.r.b(dVar.i(), abstractComponentCallbacksC2216p) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final d p(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        Object next;
        Iterator it = this.f18695c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (kotlin.jvm.internal.r.b(dVar.i(), abstractComponentCallbacksC2216p) && !dVar.l()) {
                break;
            }
        }
        return (d) next;
    }

    public final void q() {
        if (AbstractC2190H.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f18693a.isAttachedToWindow();
        synchronized (this.f18694b) {
            try {
                A();
                z(this.f18694b);
                for (d dVar : F5.v.k0(this.f18695c)) {
                    if (AbstractC2190H.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f18693a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                    }
                    dVar.c(this.f18693a);
                }
                for (d dVar2 : F5.v.k0(this.f18694b)) {
                    if (AbstractC2190H.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f18693a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                    }
                    dVar2.c(this.f18693a);
                }
                E5.E e7 = E5.E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f18697e) {
            if (AbstractC2190H.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f18697e = false;
            n();
        }
    }

    public final d.a s(C2196N fragmentStateManager) {
        kotlin.jvm.internal.r.f(fragmentStateManager, "fragmentStateManager");
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pK = fragmentStateManager.k();
        kotlin.jvm.internal.r.e(abstractComponentCallbacksC2216pK, "fragmentStateManager.fragment");
        d dVarO = o(abstractComponentCallbacksC2216pK);
        d.a aVarJ = dVarO != null ? dVarO.j() : null;
        d dVarP = p(abstractComponentCallbacksC2216pK);
        d.a aVarJ2 = dVarP != null ? dVarP.j() : null;
        int i7 = aVarJ == null ? -1 : e.f18725a[aVarJ.ordinal()];
        return (i7 == -1 || i7 == 1) ? aVarJ2 : aVarJ;
    }

    public final ViewGroup t() {
        return this.f18693a;
    }

    public final boolean w() {
        return !this.f18694b.isEmpty();
    }

    public final void x() {
        Object objPrevious;
        synchronized (this.f18694b) {
            try {
                A();
                List list = this.f18694b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    d dVar = (d) objPrevious;
                    d.b.a aVar = d.b.f18717a;
                    View view = dVar.i().f18844J;
                    kotlin.jvm.internal.r.e(view, "operation.fragment.mView");
                    d.b bVarA = aVar.a(view);
                    d.b bVarH = dVar.h();
                    d.b bVar = d.b.VISIBLE;
                    if (bVarH == bVar && bVarA != bVar) {
                        break;
                    }
                }
                d dVar2 = (d) objPrevious;
                AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pI = dVar2 != null ? dVar2.i() : null;
                this.f18697e = abstractComponentCallbacksC2216pI != null ? abstractComponentCallbacksC2216pI.e0() : false;
                E5.E e7 = E5.E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(C1386b backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        if (AbstractC2190H.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
        }
        List list = this.f18695c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            F5.s.t(arrayList, ((d) it.next()).g());
        }
        List listH0 = F5.v.h0(F5.v.m0(arrayList));
        int size = listH0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((b) listH0.get(i7)).e(backEvent, this.f18693a);
        }
    }

    public final void z(List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((d) list.get(i7)).q();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            F5.s.t(arrayList, ((d) it.next()).g());
        }
        List listH0 = F5.v.h0(F5.v.m0(arrayList));
        int size2 = listH0.size();
        for (int i8 = 0; i8 < size2; i8++) {
            ((b) listH0.get(i8)).g(this.f18693a);
        }
    }
}
