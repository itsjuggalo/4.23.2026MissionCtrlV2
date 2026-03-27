package j6;

import E6.C0470i;
import E6.C0475n;
import E6.C0485y;
import G6.M;
import R5.InterfaceC0848e;
import R5.N;
import java.util.Collection;
import java.util.Set;
import k6.C2284a;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2595q;
import p5.Q;
import p5.S;
import p6.C2602e;
import p6.C2603f;
import p6.C2606i;
import s6.C2724k;

/* JADX INFO: renamed from: j6.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2250n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20202b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f20203c = Q.c(C2284a.EnumC0339a.f20424e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f20204d = S.h(C2284a.EnumC0339a.f20425f, C2284a.EnumC0339a.f20428i);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2602e f20205e = new C2602e(1, 1, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2602e f20206f = new C2602e(1, 1, 11);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2602e f20207g = new C2602e(1, 1, 13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0475n f20208a;

    /* JADX INFO: renamed from: j6.n$a */
    public static final class a {
        public a() {
        }

        public final C2602e a() {
            return C2250n.f20207g;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final Collection d() {
        return AbstractC2595q.i();
    }

    public final B6.k c(N descriptor, InterfaceC2260x kotlinClass) {
        C2489q c2489qM;
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(kotlinClass, "kotlinClass");
        String[] strArrM = m(kotlinClass, f20204d);
        if (strArrM == null) {
            return null;
        }
        String[] strArrG = kotlinClass.b().g();
        try {
            if (strArrG == null) {
                return null;
            }
            try {
                c2489qM = C2606i.m(strArrM, strArrG);
            } catch (C2724k e8) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.a(), e8);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.b().d().h(h())) {
                throw th;
            }
            c2489qM = null;
        }
        if (c2489qM == null) {
            return null;
        }
        C2603f c2603f = (C2603f) c2489qM.a();
        l6.l lVar = (l6.l) c2489qM.b();
        C2254r c2254r = new C2254r(kotlinClass, lVar, c2603f, g(kotlinClass), k(kotlinClass), e(kotlinClass));
        return new M(descriptor, lVar, c2603f, kotlinClass.b().d(), c2254r, f(), "scope for " + c2254r + " in " + descriptor, C2249m.f20201a);
    }

    public final G6.r e(InterfaceC2260x interfaceC2260x) {
        return (!f().g().b() && interfaceC2260x.b().j()) ? G6.r.f3354b : G6.r.f3353a;
    }

    public final C0475n f() {
        C0475n c0475n = this.f20208a;
        if (c0475n != null) {
            return c0475n;
        }
        AbstractC2304t.s("components");
        return null;
    }

    public final C0485y g(InterfaceC2260x interfaceC2260x) {
        if (i() || interfaceC2260x.b().d().h(h())) {
            return null;
        }
        return new C0485y(interfaceC2260x.b().d(), C2602e.f22409i, h(), h().k(interfaceC2260x.b().d().j()), interfaceC2260x.a(), interfaceC2260x.d());
    }

    public final C2602e h() {
        return S6.c.a(f().g());
    }

    public final boolean i() {
        return f().g().e();
    }

    public final boolean j(InterfaceC2260x interfaceC2260x) {
        return !f().g().c() && interfaceC2260x.b().i() && AbstractC2304t.b(interfaceC2260x.b().d(), f20206f);
    }

    public final boolean k(InterfaceC2260x interfaceC2260x) {
        return (f().g().f() && (interfaceC2260x.b().i() || AbstractC2304t.b(interfaceC2260x.b().d(), f20205e))) || j(interfaceC2260x);
    }

    public final C0470i l(InterfaceC2260x kotlinClass) {
        String[] strArrG;
        C2489q c2489qI;
        AbstractC2304t.f(kotlinClass, "kotlinClass");
        String[] strArrM = m(kotlinClass, f20203c);
        if (strArrM == null || (strArrG = kotlinClass.b().g()) == null) {
            return null;
        }
        try {
            try {
                c2489qI = C2606i.i(strArrM, strArrG);
            } catch (C2724k e8) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.a(), e8);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.b().d().h(h())) {
                throw th;
            }
            c2489qI = null;
        }
        if (c2489qI == null) {
            return null;
        }
        return new C0470i((C2603f) c2489qI.a(), (l6.c) c2489qI.b(), kotlinClass.b().d(), new C2262z(kotlinClass, g(kotlinClass), k(kotlinClass), e(kotlinClass)));
    }

    public final String[] m(InterfaceC2260x interfaceC2260x, Set set) {
        C2284a c2284aB = interfaceC2260x.b();
        String[] strArrA = c2284aB.a();
        if (strArrA == null) {
            strArrA = c2284aB.b();
        }
        if (strArrA == null || !set.contains(c2284aB.c())) {
            return null;
        }
        return strArrA;
    }

    public final InterfaceC0848e n(InterfaceC2260x kotlinClass) {
        AbstractC2304t.f(kotlinClass, "kotlinClass");
        C0470i c0470iL = l(kotlinClass);
        if (c0470iL == null) {
            return null;
        }
        return f().f().e(kotlinClass.d(), c0470iL);
    }

    public final void o(C0475n c0475n) {
        AbstractC2304t.f(c0475n, "<set-?>");
        this.f20208a = c0475n;
    }

    public final void p(C2247k components) {
        AbstractC2304t.f(components, "components");
        o(components.a());
    }
}
