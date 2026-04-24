package d;

import P3.C0227b;
import Z.AbstractComponentCallbacksC0277t;
import Z.C0259a;
import Z.C0270l;
import Z.G;
import Z.P;
import Z.W;
import Z.Z;
import Z.a0;
import android.os.Build;
import android.util.Log;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: renamed from: d.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0517u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H4.f f5941b = new H4.f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public G f5942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f5943d;
    public OnBackInvokedDispatcher e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5945g;

    public C0517u(Runnable runnable) {
        this.f5940a = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            this.f5943d = i >= 34 ? new C0513q(new C0511o(this, 0), new C0511o(this, 1), new C0512p(this, 0), new C0512p(this, 1)) : new C0227b(new C0512p(this, 2), 1);
        }
    }

    public final void a() {
        Object objPrevious;
        G g2 = this.f5942c;
        if (g2 == null) {
            H4.f fVar = this.f5941b;
            ListIterator<E> listIterator = fVar.listIterator(fVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((G) objPrevious).f3708a) {
                        break;
                    }
                }
            }
            g2 = (G) objPrevious;
        }
        this.f5942c = null;
        if (g2 != null) {
            g2.a();
        }
    }

    public final void b() {
        Object objPrevious;
        G g2 = this.f5942c;
        if (g2 == null) {
            H4.f fVar = this.f5941b;
            fVar.getClass();
            ListIterator listIterator = fVar.listIterator(fVar.f575c);
            while (true) {
                if (listIterator.hasPrevious()) {
                    objPrevious = listIterator.previous();
                    if (((G) objPrevious).f3708a) {
                        break;
                    }
                } else {
                    objPrevious = null;
                    break;
                }
            }
            g2 = (G) objPrevious;
        }
        this.f5942c = null;
        if (g2 == null) {
            this.f5940a.run();
            return;
        }
        boolean zK = P.K(3);
        P p3 = g2.f3711d;
        if (zK) {
            Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + p3);
        }
        p3.A(true);
        C0259a c0259a = p3.f3742h;
        G g5 = p3.i;
        if (c0259a == null) {
            if (g5.f3708a) {
                if (P.K(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                p3.R();
                return;
            } else {
                if (P.K(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                p3.f3741g.b();
                return;
            }
        }
        ArrayList arrayList = p3.f3746m;
        if (!arrayList.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(P.F(p3.f3742h));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                Iterator it2 = linkedHashSet.iterator();
                if (it2.hasNext()) {
                    throw null;
                }
            }
        }
        Iterator it3 = p3.f3742h.f3798a.iterator();
        while (it3.hasNext()) {
            AbstractComponentCallbacksC0277t abstractComponentCallbacksC0277t = ((W) it3.next()).f3789b;
            if (abstractComponentCallbacksC0277t != null) {
                abstractComponentCallbacksC0277t.f3908q = false;
            }
        }
        for (C0270l c0270l : p3.f(new ArrayList(Collections.singletonList(p3.f3742h)), 0, 1)) {
            c0270l.getClass();
            if (P.K(3)) {
                Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
            }
            ArrayList operations = c0270l.f3847c;
            c0270l.f(operations);
            c0270l.getClass();
            kotlin.jvm.internal.j.e(operations, "operations");
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = operations.iterator();
            while (it4.hasNext()) {
                ((a0) it4.next()).getClass();
                H4.n.e0(arrayList2, null);
            }
            List listO0 = H4.h.o0(H4.h.r0(arrayList2));
            int size = listO0.size();
            for (int i = 0; i < size; i++) {
                ((Z) listO0.get(i)).a(c0270l.f3845a);
            }
            int size2 = operations.size();
            for (int i6 = 0; i6 < size2; i6++) {
                c0270l.a((a0) operations.get(i6));
            }
            List listO02 = H4.h.o0(operations);
            if (listO02.size() > 0) {
                ((a0) listO02.get(0)).getClass();
                throw null;
            }
        }
        p3.f3742h = null;
        p3.f0();
        if (P.K(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + g5.f3708a + " for  FragmentManager " + p3);
        }
    }

    public final void c(boolean z6) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        OnBackInvokedCallback onBackInvokedCallback = this.f5943d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z6 && !this.f5944f) {
            AbstractC0503g.b(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f5944f = true;
        } else {
            if (z6 || !this.f5944f) {
                return;
            }
            AbstractC0503g.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f5944f = false;
        }
    }

    public final void d() {
        boolean z6 = this.f5945g;
        boolean z7 = false;
        H4.f fVar = this.f5941b;
        if (fVar == null || !fVar.isEmpty()) {
            Iterator it = fVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((G) it.next()).f3708a) {
                    z7 = true;
                    break;
                }
            }
        }
        this.f5945g = z7;
        if (z7 == z6 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        c(z7);
    }
}
