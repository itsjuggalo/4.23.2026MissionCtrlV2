package v1;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.i0;
import androidx.fragment.app.p;
import dd.a0;
import dd.o0;
import dd.u0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23067a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0398c f23068b = C0398c.f23080d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
    }

    /* JADX INFO: renamed from: v1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0398c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23079c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0398c f23080d = new C0398c(u0.d(), null, o0.h());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f23081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f23082b;

        /* JADX INFO: renamed from: v1.c$c$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public a() {
            }
        }

        public C0398c(Set flags, b bVar, Map allowedViolations) {
            t.f(flags, "flags");
            t.f(allowedViolations, "allowedViolations");
            this.f23081a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : allowedViolations.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f23082b = linkedHashMap;
        }

        public final Set a() {
            return this.f23081a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.f23082b;
        }
    }

    public static final void d(String str, m violation) {
        t.f(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    public static final void f(p fragment, String previousFragmentId) {
        t.f(fragment, "fragment");
        t.f(previousFragmentId, "previousFragmentId");
        v1.a aVar = new v1.a(fragment, previousFragmentId);
        c cVar = f23067a;
        cVar.e(aVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_FRAGMENT_REUSE) && cVar.q(c0398cB, fragment.getClass(), aVar.getClass())) {
            cVar.c(c0398cB, aVar);
        }
    }

    public static final void g(p fragment, ViewGroup viewGroup) {
        t.f(fragment, "fragment");
        d dVar = new d(fragment, viewGroup);
        c cVar = f23067a;
        cVar.e(dVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && cVar.q(c0398cB, fragment.getClass(), dVar.getClass())) {
            cVar.c(c0398cB, dVar);
        }
    }

    public static final void h(p fragment) {
        t.f(fragment, "fragment");
        e eVar = new e(fragment);
        c cVar = f23067a;
        cVar.e(eVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && cVar.q(c0398cB, fragment.getClass(), eVar.getClass())) {
            cVar.c(c0398cB, eVar);
        }
    }

    public static final void i(p fragment) {
        t.f(fragment, "fragment");
        f fVar = new f(fragment);
        c cVar = f23067a;
        cVar.e(fVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.q(c0398cB, fragment.getClass(), fVar.getClass())) {
            cVar.c(c0398cB, fVar);
        }
    }

    public static final void j(p fragment) {
        t.f(fragment, "fragment");
        g gVar = new g(fragment);
        c cVar = f23067a;
        cVar.e(gVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.q(c0398cB, fragment.getClass(), gVar.getClass())) {
            cVar.c(c0398cB, gVar);
        }
    }

    public static final void k(p fragment) {
        t.f(fragment, "fragment");
        i iVar = new i(fragment);
        c cVar = f23067a;
        cVar.e(iVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && cVar.q(c0398cB, fragment.getClass(), iVar.getClass())) {
            cVar.c(c0398cB, iVar);
        }
    }

    public static final void l(p violatingFragment, p targetFragment, int i10) {
        t.f(violatingFragment, "violatingFragment");
        t.f(targetFragment, "targetFragment");
        j jVar = new j(violatingFragment, targetFragment, i10);
        c cVar = f23067a;
        cVar.e(jVar);
        C0398c c0398cB = cVar.b(violatingFragment);
        if (c0398cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.q(c0398cB, violatingFragment.getClass(), jVar.getClass())) {
            cVar.c(c0398cB, jVar);
        }
    }

    public static final void m(p fragment, boolean z10) {
        t.f(fragment, "fragment");
        k kVar = new k(fragment, z10);
        c cVar = f23067a;
        cVar.e(kVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && cVar.q(c0398cB, fragment.getClass(), kVar.getClass())) {
            cVar.c(c0398cB, kVar);
        }
    }

    public static final void n(p fragment, ViewGroup container) {
        t.f(fragment, "fragment");
        t.f(container, "container");
        n nVar = new n(fragment, container);
        c cVar = f23067a;
        cVar.e(nVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && cVar.q(c0398cB, fragment.getClass(), nVar.getClass())) {
            cVar.c(c0398cB, nVar);
        }
    }

    public static final void o(p fragment, p expectedParentFragment, int i10) {
        t.f(fragment, "fragment");
        t.f(expectedParentFragment, "expectedParentFragment");
        o oVar = new o(fragment, expectedParentFragment, i10);
        c cVar = f23067a;
        cVar.e(oVar);
        C0398c c0398cB = cVar.b(fragment);
        if (c0398cB.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && cVar.q(c0398cB, fragment.getClass(), oVar.getClass())) {
            cVar.c(c0398cB, oVar);
        }
    }

    public final C0398c b(p pVar) {
        while (pVar != null) {
            if (pVar.isAdded()) {
                i0 parentFragmentManager = pVar.getParentFragmentManager();
                t.e(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.C0() != null) {
                    C0398c c0398cC0 = parentFragmentManager.C0();
                    t.c(c0398cC0);
                    return c0398cC0;
                }
            }
            pVar = pVar.getParentFragment();
        }
        return f23068b;
    }

    public final void c(C0398c c0398c, final m mVar) {
        p pVarA = mVar.a();
        final String name = pVarA.getClass().getName();
        if (c0398c.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, mVar);
        }
        c0398c.b();
        if (c0398c.a().contains(a.PENALTY_DEATH)) {
            p(pVarA, new Runnable() { // from class: v1.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(name, mVar);
                }
            });
        }
    }

    public final void e(m mVar) {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + mVar.a().getClass().getName(), mVar);
        }
    }

    public final void p(p pVar, Runnable runnable) {
        if (!pVar.isAdded()) {
            runnable.run();
            return;
        }
        Handler handlerH = pVar.getParentFragmentManager().w0().h();
        if (t.b(handlerH.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerH.post(runnable);
        }
    }

    public final boolean q(C0398c c0398c, Class cls, Class cls2) {
        Set set = (Set) c0398c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (t.b(cls2.getSuperclass(), m.class) || !a0.R(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
