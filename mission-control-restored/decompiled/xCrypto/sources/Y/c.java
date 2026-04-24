package Y;

import X2.L;
import X2.Q;
import X2.x;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import androidx.fragment.app.I;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5626a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0078c f5627b = C0078c.f5639d;

    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface b {
    }

    /* JADX INFO: renamed from: Y.c$c, reason: collision with other inner class name */
    public static final class C0078c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f5638c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0078c f5639d = new C0078c(Q.b(), null, L.e());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f5640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f5641b;

        /* JADX INFO: renamed from: Y.c$c$a */
        public static final class a {
            public /* synthetic */ a(AbstractC1585j abstractC1585j) {
                this();
            }

            public a() {
            }
        }

        public C0078c(Set flags, b bVar, Map allowedViolations) {
            r.f(flags, "flags");
            r.f(allowedViolations, "allowedViolations");
            this.f5640a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : allowedViolations.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f5641b = linkedHashMap;
        }

        public final Set a() {
            return this.f5640a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.f5641b;
        }
    }

    public static final void d(String str, m violation) {
        r.f(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    public static final void f(AbstractComponentCallbacksC0828p fragment, String previousFragmentId) {
        r.f(fragment, "fragment");
        r.f(previousFragmentId, "previousFragmentId");
        Y.a aVar = new Y.a(fragment, previousFragmentId);
        c cVar = f5626a;
        cVar.e(aVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_FRAGMENT_REUSE) && cVar.q(c0078cB, fragment.getClass(), aVar.getClass())) {
            cVar.c(c0078cB, aVar);
        }
    }

    public static final void g(AbstractComponentCallbacksC0828p fragment, ViewGroup viewGroup) {
        r.f(fragment, "fragment");
        d dVar = new d(fragment, viewGroup);
        c cVar = f5626a;
        cVar.e(dVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && cVar.q(c0078cB, fragment.getClass(), dVar.getClass())) {
            cVar.c(c0078cB, dVar);
        }
    }

    public static final void h(AbstractComponentCallbacksC0828p fragment) {
        r.f(fragment, "fragment");
        e eVar = new e(fragment);
        c cVar = f5626a;
        cVar.e(eVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && cVar.q(c0078cB, fragment.getClass(), eVar.getClass())) {
            cVar.c(c0078cB, eVar);
        }
    }

    public static final void i(AbstractComponentCallbacksC0828p fragment) {
        r.f(fragment, "fragment");
        f fVar = new f(fragment);
        c cVar = f5626a;
        cVar.e(fVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.q(c0078cB, fragment.getClass(), fVar.getClass())) {
            cVar.c(c0078cB, fVar);
        }
    }

    public static final void j(AbstractComponentCallbacksC0828p fragment) {
        r.f(fragment, "fragment");
        g gVar = new g(fragment);
        c cVar = f5626a;
        cVar.e(gVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.q(c0078cB, fragment.getClass(), gVar.getClass())) {
            cVar.c(c0078cB, gVar);
        }
    }

    public static final void k(AbstractComponentCallbacksC0828p fragment) {
        r.f(fragment, "fragment");
        i iVar = new i(fragment);
        c cVar = f5626a;
        cVar.e(iVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && cVar.q(c0078cB, fragment.getClass(), iVar.getClass())) {
            cVar.c(c0078cB, iVar);
        }
    }

    public static final void l(AbstractComponentCallbacksC0828p violatingFragment, AbstractComponentCallbacksC0828p targetFragment, int i4) {
        r.f(violatingFragment, "violatingFragment");
        r.f(targetFragment, "targetFragment");
        j jVar = new j(violatingFragment, targetFragment, i4);
        c cVar = f5626a;
        cVar.e(jVar);
        C0078c c0078cB = cVar.b(violatingFragment);
        if (c0078cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.q(c0078cB, violatingFragment.getClass(), jVar.getClass())) {
            cVar.c(c0078cB, jVar);
        }
    }

    public static final void m(AbstractComponentCallbacksC0828p fragment, boolean z4) {
        r.f(fragment, "fragment");
        k kVar = new k(fragment, z4);
        c cVar = f5626a;
        cVar.e(kVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && cVar.q(c0078cB, fragment.getClass(), kVar.getClass())) {
            cVar.c(c0078cB, kVar);
        }
    }

    public static final void n(AbstractComponentCallbacksC0828p fragment, ViewGroup container) {
        r.f(fragment, "fragment");
        r.f(container, "container");
        n nVar = new n(fragment, container);
        c cVar = f5626a;
        cVar.e(nVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && cVar.q(c0078cB, fragment.getClass(), nVar.getClass())) {
            cVar.c(c0078cB, nVar);
        }
    }

    public static final void o(AbstractComponentCallbacksC0828p fragment, AbstractComponentCallbacksC0828p expectedParentFragment, int i4) {
        r.f(fragment, "fragment");
        r.f(expectedParentFragment, "expectedParentFragment");
        o oVar = new o(fragment, expectedParentFragment, i4);
        c cVar = f5626a;
        cVar.e(oVar);
        C0078c c0078cB = cVar.b(fragment);
        if (c0078cB.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && cVar.q(c0078cB, fragment.getClass(), oVar.getClass())) {
            cVar.c(c0078cB, oVar);
        }
    }

    public final C0078c b(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        while (abstractComponentCallbacksC0828p != null) {
            if (abstractComponentCallbacksC0828p.isAdded()) {
                I parentFragmentManager = abstractComponentCallbacksC0828p.getParentFragmentManager();
                r.e(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.C0() != null) {
                    C0078c c0078cC0 = parentFragmentManager.C0();
                    r.c(c0078cC0);
                    return c0078cC0;
                }
            }
            abstractComponentCallbacksC0828p = abstractComponentCallbacksC0828p.getParentFragment();
        }
        return f5627b;
    }

    public final void c(C0078c c0078c, final m mVar) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pA = mVar.a();
        final String name = abstractComponentCallbacksC0828pA.getClass().getName();
        if (c0078c.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, mVar);
        }
        c0078c.b();
        if (c0078c.a().contains(a.PENALTY_DEATH)) {
            p(abstractComponentCallbacksC0828pA, new Runnable() { // from class: Y.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(name, mVar);
                }
            });
        }
    }

    public final void e(m mVar) {
        if (I.J0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + mVar.a().getClass().getName(), mVar);
        }
    }

    public final void p(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, Runnable runnable) {
        if (!abstractComponentCallbacksC0828p.isAdded()) {
            runnable.run();
            return;
        }
        Handler handlerH = abstractComponentCallbacksC0828p.getParentFragmentManager().w0().h();
        if (r.b(handlerH.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerH.post(runnable);
        }
    }

    public final boolean q(C0078c c0078c, Class cls, Class cls2) {
        Set set = (Set) c0078c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (r.b(cls2.getSuperclass(), m.class) || !x.C(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
