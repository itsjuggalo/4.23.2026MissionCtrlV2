package n0;

import F5.J;
import F5.O;
import F5.v;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import m0.AbstractC2190H;
import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19056a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0312c f19057b = C0312c.f19069d;

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

    /* JADX INFO: renamed from: n0.c$c, reason: collision with other inner class name */
    public static final class C0312c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f19068c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0312c f19069d = new C0312c(O.b(), null, J.e());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f19070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f19071b;

        /* JADX INFO: renamed from: n0.c$c$a */
        public static final class a {
            public /* synthetic */ a(AbstractC2148j abstractC2148j) {
                this();
            }

            public a() {
            }
        }

        public C0312c(Set flags, b bVar, Map allowedViolations) {
            r.f(flags, "flags");
            r.f(allowedViolations, "allowedViolations");
            this.f19070a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : allowedViolations.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f19071b = linkedHashMap;
        }

        public final Set a() {
            return this.f19070a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.f19071b;
        }
    }

    public static final void d(String str, g violation) {
        r.f(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    public static final void f(AbstractComponentCallbacksC2216p fragment, String previousFragmentId) {
        r.f(fragment, "fragment");
        r.f(previousFragmentId, "previousFragmentId");
        C2249a c2249a = new C2249a(fragment, previousFragmentId);
        c cVar = f19056a;
        cVar.e(c2249a);
        C0312c c0312cB = cVar.b(fragment);
        if (c0312cB.a().contains(a.DETECT_FRAGMENT_REUSE) && cVar.l(c0312cB, fragment.getClass(), c2249a.getClass())) {
            cVar.c(c0312cB, c2249a);
        }
    }

    public static final void g(AbstractComponentCallbacksC2216p fragment, ViewGroup viewGroup) {
        r.f(fragment, "fragment");
        d dVar = new d(fragment, viewGroup);
        c cVar = f19056a;
        cVar.e(dVar);
        C0312c c0312cB = cVar.b(fragment);
        if (c0312cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && cVar.l(c0312cB, fragment.getClass(), dVar.getClass())) {
            cVar.c(c0312cB, dVar);
        }
    }

    public static final void h(AbstractComponentCallbacksC2216p fragment) {
        r.f(fragment, "fragment");
        e eVar = new e(fragment);
        c cVar = f19056a;
        cVar.e(eVar);
        C0312c c0312cB = cVar.b(fragment);
        if (c0312cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.l(c0312cB, fragment.getClass(), eVar.getClass())) {
            cVar.c(c0312cB, eVar);
        }
    }

    public static final void i(AbstractComponentCallbacksC2216p fragment, ViewGroup container) {
        r.f(fragment, "fragment");
        r.f(container, "container");
        h hVar = new h(fragment, container);
        c cVar = f19056a;
        cVar.e(hVar);
        C0312c c0312cB = cVar.b(fragment);
        if (c0312cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && cVar.l(c0312cB, fragment.getClass(), hVar.getClass())) {
            cVar.c(c0312cB, hVar);
        }
    }

    public static final void j(AbstractComponentCallbacksC2216p fragment, AbstractComponentCallbacksC2216p expectedParentFragment, int i7) {
        r.f(fragment, "fragment");
        r.f(expectedParentFragment, "expectedParentFragment");
        i iVar = new i(fragment, expectedParentFragment, i7);
        c cVar = f19056a;
        cVar.e(iVar);
        C0312c c0312cB = cVar.b(fragment);
        if (c0312cB.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && cVar.l(c0312cB, fragment.getClass(), iVar.getClass())) {
            cVar.c(c0312cB, iVar);
        }
    }

    public final C0312c b(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        while (abstractComponentCallbacksC2216p != null) {
            if (abstractComponentCallbacksC2216p.a0()) {
                AbstractC2190H abstractC2190HH = abstractComponentCallbacksC2216p.H();
                r.e(abstractC2190HH, "declaringFragment.parentFragmentManager");
                if (abstractC2190HH.B0() != null) {
                    C0312c c0312cB0 = abstractC2190HH.B0();
                    r.c(c0312cB0);
                    return c0312cB0;
                }
            }
            abstractComponentCallbacksC2216p = abstractComponentCallbacksC2216p.G();
        }
        return f19057b;
    }

    public final void c(C0312c c0312c, final g gVar) {
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pA = gVar.a();
        final String name = abstractComponentCallbacksC2216pA.getClass().getName();
        if (c0312c.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, gVar);
        }
        c0312c.b();
        if (c0312c.a().contains(a.PENALTY_DEATH)) {
            k(abstractComponentCallbacksC2216pA, new Runnable() { // from class: n0.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(name, gVar);
                }
            });
        }
    }

    public final void e(g gVar) {
        if (AbstractC2190H.I0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + gVar.a().getClass().getName(), gVar);
        }
    }

    public final void k(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, Runnable runnable) {
        if (!abstractComponentCallbacksC2216p.a0()) {
            runnable.run();
            return;
        }
        Handler handlerW = abstractComponentCallbacksC2216p.H().v0().w();
        if (r.b(handlerW.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerW.post(runnable);
        }
    }

    public final boolean l(C0312c c0312c, Class cls, Class cls2) {
        Set set = (Set) c0312c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (r.b(cls2.getSuperclass(), g.class) || !v.D(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
