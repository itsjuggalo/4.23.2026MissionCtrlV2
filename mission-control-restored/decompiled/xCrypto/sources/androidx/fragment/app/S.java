package androidx.fragment.app;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import r0.C1731e;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f7380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final U f7381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U f7382c;

    static {
        S s4 = new S();
        f7380a = s4;
        f7381b = new T();
        f7382c = s4.b();
    }

    public static final void a(AbstractComponentCallbacksC0828p inFragment, AbstractComponentCallbacksC0828p outFragment, boolean z4, C1853a sharedElements, boolean z5) {
        kotlin.jvm.internal.r.f(inFragment, "inFragment");
        kotlin.jvm.internal.r.f(outFragment, "outFragment");
        kotlin.jvm.internal.r.f(sharedElements, "sharedElements");
        if (z4) {
            outFragment.getEnterTransitionCallback();
        } else {
            inFragment.getEnterTransitionCallback();
        }
    }

    public static final void c(C1853a c1853a, C1853a namedViews) {
        kotlin.jvm.internal.r.f(c1853a, "<this>");
        kotlin.jvm.internal.r.f(namedViews, "namedViews");
        int size = c1853a.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!namedViews.containsKey((String) c1853a.n(size))) {
                c1853a.l(size);
            }
        }
    }

    public static final void d(List views, int i4) {
        kotlin.jvm.internal.r.f(views, "views");
        Iterator it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i4);
        }
    }

    public final U b() {
        try {
            kotlin.jvm.internal.r.d(C1731e.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (U) C1731e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
