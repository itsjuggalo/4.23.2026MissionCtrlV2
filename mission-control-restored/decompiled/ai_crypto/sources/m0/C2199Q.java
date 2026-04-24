package m0;

import I0.C0564e;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import u.C2736a;

/* JADX INFO: renamed from: m0.Q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2199Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2199Q f18656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final T f18657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final T f18658c;

    static {
        C2199Q c2199q = new C2199Q();
        f18656a = c2199q;
        f18657b = new C2200S();
        f18658c = c2199q.b();
    }

    public static final void a(AbstractComponentCallbacksC2216p inFragment, AbstractComponentCallbacksC2216p outFragment, boolean z7, C2736a sharedElements, boolean z8) {
        kotlin.jvm.internal.r.f(inFragment, "inFragment");
        kotlin.jvm.internal.r.f(outFragment, "outFragment");
        kotlin.jvm.internal.r.f(sharedElements, "sharedElements");
        if (z7) {
            outFragment.x();
        } else {
            inFragment.x();
        }
    }

    public static final void c(C2736a c2736a, C2736a namedViews) {
        kotlin.jvm.internal.r.f(c2736a, "<this>");
        kotlin.jvm.internal.r.f(namedViews, "namedViews");
        int size = c2736a.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!namedViews.containsKey((String) c2736a.n(size))) {
                c2736a.l(size);
            }
        }
    }

    public static final void d(List views, int i7) {
        kotlin.jvm.internal.r.f(views, "views");
        Iterator it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i7);
        }
    }

    public final T b() {
        try {
            kotlin.jvm.internal.r.d(C0564e.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (T) C0564e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
