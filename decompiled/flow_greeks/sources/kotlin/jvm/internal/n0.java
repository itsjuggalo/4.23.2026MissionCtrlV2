package kotlin.jvm.internal;

import zd.a3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f14948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final wd.d[] f14949b;

    static {
        o0 o0Var = null;
        try {
            o0Var = (o0) a3.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (o0Var == null) {
            o0Var = new o0();
        }
        f14948a = o0Var;
        f14949b = new wd.d[0];
    }

    public static wd.h a(p pVar) {
        return f14948a.a(pVar);
    }

    public static wd.d b(Class cls) {
        return f14948a.b(cls);
    }

    public static wd.g c(Class cls) {
        return f14948a.c(cls, "");
    }

    public static wd.j d(x xVar) {
        return f14948a.d(xVar);
    }

    public static wd.k e(z zVar) {
        return f14948a.e(zVar);
    }

    public static wd.n f(d0 d0Var) {
        return f14948a.f(d0Var);
    }

    public static wd.o g(f0 f0Var) {
        return f14948a.g(f0Var);
    }

    public static wd.p h(h0 h0Var) {
        return f14948a.h(h0Var);
    }

    public static String i(o oVar) {
        return f14948a.i(oVar);
    }

    public static String j(v vVar) {
        return f14948a.j(vVar);
    }
}
