package of;

import dd.a0;
import fe.h;
import kotlin.jvm.internal.t;
import qf.k;
import re.j;
import se.d0;
import ve.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f18111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pe.j f18112b;

    public c(j packageFragmentProvider, pe.j javaResolverCache) {
        t.f(packageFragmentProvider, "packageFragmentProvider");
        t.f(javaResolverCache, "javaResolverCache");
        this.f18111a = packageFragmentProvider;
        this.f18112b = javaResolverCache;
    }

    public final j a() {
        return this.f18111a;
    }

    public final fe.e b(g javaClass) {
        d0 d0Var;
        t.f(javaClass, "javaClass");
        ef.c cVarE = javaClass.e();
        if (cVarE != null && javaClass.H() == ve.d0.f23406a) {
            return this.f18112b.c(cVarE);
        }
        g gVarK = javaClass.k();
        if (gVarK == null) {
            if (cVarE == null || (d0Var = (d0) a0.b0(this.f18111a.c(cVarE.d()))) == null) {
                return null;
            }
            return d0Var.N0(javaClass);
        }
        fe.e eVarB = b(gVarK);
        k kVarX0 = eVarB != null ? eVarB.x0() : null;
        h hVarE = kVarX0 != null ? kVarX0.e(javaClass.getName(), ne.d.f17052s) : null;
        if (hVarE instanceof fe.e) {
            return (fe.e) hVarE;
        }
        return null;
    }
}
