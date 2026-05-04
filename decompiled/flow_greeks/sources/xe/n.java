package xe;

import dd.t0;
import dd.u0;
import fe.n0;
import java.util.Collection;
import java.util.Set;
import vf.m0;
import ye.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24895b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f24896c = t0.c(a.EnumC0469a.f25372e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f24897d = u0.h(a.EnumC0469a.f25373f, a.EnumC0469a.f25376i);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final df.e f24898e = new df.e(1, 1, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final df.e f24899f = new df.e(1, 1, 11);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final df.e f24900g = new df.e(1, 1, 13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tf.n f24901a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final df.e a() {
            return n.f24900g;
        }

        public a() {
        }
    }

    public static final Collection d() {
        return dd.r.k();
    }

    public final qf.k c(n0 descriptor, x kotlinClass) {
        cd.q qVarM;
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(kotlinClass, "kotlinClass");
        String[] strArrM = m(kotlinClass, f24897d);
        if (strArrM == null) {
            return null;
        }
        String[] strArrG = kotlinClass.b().g();
        try {
            if (strArrG == null) {
                return null;
            }
            try {
                qVarM = df.i.m(strArrM, strArrG);
            } catch (gf.k e10) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.a(), e10);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.b().d().h(h())) {
                throw th;
            }
            qVarM = null;
        }
        if (qVarM == null) {
            return null;
        }
        df.f fVar = (df.f) qVarM.a();
        ze.l lVar = (ze.l) qVarM.b();
        r rVar = new r(kotlinClass, lVar, fVar, g(kotlinClass), k(kotlinClass), e(kotlinClass));
        return new m0(descriptor, lVar, fVar, kotlinClass.b().d(), rVar, f(), "scope for " + rVar + " in " + descriptor, m.f24894a);
    }

    public final vf.r e(x xVar) {
        return f().g().b() ? vf.r.f23488a : xVar.b().j() ? vf.r.f23489b : vf.r.f23488a;
    }

    public final tf.n f() {
        tf.n nVar = this.f24901a;
        if (nVar != null) {
            return nVar;
        }
        kotlin.jvm.internal.t.s("components");
        return null;
    }

    public final tf.y g(x xVar) {
        if (i() || xVar.b().d().h(h())) {
            return null;
        }
        return new tf.y(xVar.b().d(), df.e.f8098i, h(), h().k(xVar.b().d().j()), xVar.a(), xVar.g());
    }

    public final df.e h() {
        return hg.c.a(f().g());
    }

    public final boolean i() {
        return f().g().e();
    }

    public final boolean j(x xVar) {
        return !f().g().c() && xVar.b().i() && kotlin.jvm.internal.t.b(xVar.b().d(), f24899f);
    }

    public final boolean k(x xVar) {
        return (f().g().f() && (xVar.b().i() || kotlin.jvm.internal.t.b(xVar.b().d(), f24898e))) || j(xVar);
    }

    public final tf.i l(x kotlinClass) {
        String[] strArrG;
        cd.q qVarI;
        kotlin.jvm.internal.t.f(kotlinClass, "kotlinClass");
        String[] strArrM = m(kotlinClass, f24896c);
        if (strArrM == null || (strArrG = kotlinClass.b().g()) == null) {
            return null;
        }
        try {
            try {
                qVarI = df.i.i(strArrM, strArrG);
            } catch (gf.k e10) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.a(), e10);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.b().d().h(h())) {
                throw th;
            }
            qVarI = null;
        }
        if (qVarI == null) {
            return null;
        }
        return new tf.i((df.f) qVarI.a(), (ze.c) qVarI.b(), kotlinClass.b().d(), new z(kotlinClass, g(kotlinClass), k(kotlinClass), e(kotlinClass)));
    }

    public final String[] m(x xVar, Set set) {
        ye.a aVarB = xVar.b();
        String[] strArrA = aVarB.a();
        if (strArrA == null) {
            strArrA = aVarB.b();
        }
        if (strArrA == null || !set.contains(aVarB.c())) {
            return null;
        }
        return strArrA;
    }

    public final fe.e n(x kotlinClass) {
        kotlin.jvm.internal.t.f(kotlinClass, "kotlinClass");
        tf.i iVarL = l(kotlinClass);
        if (iVarL == null) {
            return null;
        }
        return f().f().e(kotlinClass.g(), iVarL);
    }

    public final void o(tf.n nVar) {
        kotlin.jvm.internal.t.f(nVar, "<set-?>");
        this.f24901a = nVar;
    }

    public final void p(k components) {
        kotlin.jvm.internal.t.f(components, "components");
        o(components.a());
    }
}
