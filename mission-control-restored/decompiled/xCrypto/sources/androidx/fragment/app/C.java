package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f7238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f7239b;

    public C(I fragmentManager) {
        kotlin.jvm.internal.r.f(fragmentManager, "fragmentManager");
        this.f7238a = fragmentManager;
        this.f7239b = new CopyOnWriteArrayList();
    }

    public final void a(AbstractComponentCallbacksC0828p f4, Bundle bundle, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().a(f4, bundle, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void b(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        this.f7238a.w0().f();
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().b(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void c(AbstractComponentCallbacksC0828p f4, Bundle bundle, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().c(f4, bundle, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void d(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().d(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void e(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().e(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void f(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().f(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void g(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        this.f7238a.w0().f();
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().g(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void h(AbstractComponentCallbacksC0828p f4, Bundle bundle, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().h(f4, bundle, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void i(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().i(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void j(AbstractComponentCallbacksC0828p f4, Bundle outState, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        kotlin.jvm.internal.r.f(outState, "outState");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().j(f4, outState, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void k(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().k(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void l(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().l(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void m(AbstractComponentCallbacksC0828p f4, View v4, Bundle bundle, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        kotlin.jvm.internal.r.f(v4, "v");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().m(f4, v4, bundle, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }

    public final void n(AbstractComponentCallbacksC0828p f4, boolean z4) {
        kotlin.jvm.internal.r.f(f4, "f");
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pZ0 = this.f7238a.z0();
        if (abstractComponentCallbacksC0828pZ0 != null) {
            I parentFragmentManager = abstractComponentCallbacksC0828pZ0.getParentFragmentManager();
            kotlin.jvm.internal.r.e(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.y0().n(f4, true);
        }
        Iterator it = this.f7239b.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            if (!z4) {
                throw null;
            }
            throw null;
        }
    }
}
