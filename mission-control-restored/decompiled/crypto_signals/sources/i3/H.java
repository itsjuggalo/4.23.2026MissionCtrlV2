package i3;

import java.util.Map;
import n0.C0865a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class H implements p5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f6841a;
    private static final n5.d descriptor;

    static {
        H h6 = new H();
        f6841a = h6;
        p5.m mVar = new p5.m("com.google.firebase.sessions.SessionData", h6, 3);
        mVar.k("sessionDetails", false);
        mVar.k("backgroundTime", true);
        mVar.k("processDataMap", true);
        descriptor = mVar;
    }

    @Override // p5.e
    public final l5.a[] a() {
        return new l5.a[]{L.f6847a, F1.h.w(i0.f6970a), F1.h.w(J.f6842d[2])};
    }

    @Override // l5.a
    public final void b(C0865a c0865a, Object obj) {
        J value = (J) obj;
        kotlin.jvm.internal.j.e(value, "value");
        n5.d dVar = descriptor;
        C0865a c0865aA = c0865a.a(dVar);
        I i = J.Companion;
        c0865aA.h(dVar, 0, L.f6847a, value.f6843a);
        boolean zO = c0865aA.o(dVar);
        k0 k0Var = value.f6844b;
        if (zO || k0Var != null) {
            c0865aA.g(dVar, 1, i0.f6970a, k0Var);
        }
        boolean zO2 = c0865aA.o(dVar);
        Map map = value.f6845c;
        if (zO2 || map != null) {
            c0865aA.g(dVar, 2, J.f6842d[2], map);
        }
        c0865aA.l(dVar);
    }

    @Override // l5.a
    public final Object c(N2.N n6) throws Throwable {
        n5.d dVar = descriptor;
        N2.N nM = n6.m(dVar);
        l5.a[] aVarArr = J.f6842d;
        N n7 = null;
        boolean z6 = true;
        int i = 0;
        k0 k0Var = null;
        Map map = null;
        while (z6) {
            int iN = nM.n(dVar);
            if (iN == -1) {
                z6 = false;
            } else if (iN == 0) {
                n7 = (N) nM.v(dVar, 0, L.f6847a, n7);
                i |= 1;
            } else if (iN == 1) {
                k0Var = (k0) nM.u(dVar, 1, i0.f6970a, k0Var);
                i |= 2;
            } else {
                if (iN != 2) {
                    throw new l5.d(iN);
                }
                map = (Map) nM.u(dVar, 2, aVarArr[2], map);
                i |= 4;
            }
        }
        nM.z(dVar);
        return new J(i, n7, k0Var, map);
    }

    @Override // l5.a
    public final n5.d d() {
        return descriptor;
    }
}
