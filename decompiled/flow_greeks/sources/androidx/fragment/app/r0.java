package androidx.fragment.app;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f2297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f2298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f2299c;

    static {
        r0 r0Var = new r0();
        f2297a = r0Var;
        f2298b = new s0();
        f2299c = r0Var.b();
    }

    public static final void a(p inFragment, p outFragment, boolean z10, w.a sharedElements, boolean z11) {
        kotlin.jvm.internal.t.f(inFragment, "inFragment");
        kotlin.jvm.internal.t.f(outFragment, "outFragment");
        kotlin.jvm.internal.t.f(sharedElements, "sharedElements");
        if (z10) {
            outFragment.getEnterTransitionCallback();
        } else {
            inFragment.getEnterTransitionCallback();
        }
    }

    public static final void c(w.a aVar, w.a namedViews) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        kotlin.jvm.internal.t.f(namedViews, "namedViews");
        int size = aVar.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!namedViews.containsKey((String) aVar.k(size))) {
                aVar.i(size);
            }
        }
    }

    public static final void d(List views, int i10) {
        kotlin.jvm.internal.t.f(views, "views");
        Iterator it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i10);
        }
    }

    public final t0 b() {
        try {
            kotlin.jvm.internal.t.d(n2.e.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (t0) n2.e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
