package ee;

import dd.t0;
import dd.u0;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8701a = new d();

    public static /* synthetic */ fe.e f(d dVar, ef.c cVar, ce.i iVar, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        return dVar.e(cVar, iVar, num);
    }

    public final fe.e a(fe.e mutable) {
        kotlin.jvm.internal.t.f(mutable, "mutable");
        ef.c cVarO = c.f8681a.o(jf.i.m(mutable));
        if (cVarO != null) {
            fe.e eVarP = nf.e.m(mutable).p(cVarO);
            kotlin.jvm.internal.t.e(eVarP, "getBuiltInClassByFqName(...)");
            return eVarP;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    public final fe.e b(fe.e readOnly) {
        kotlin.jvm.internal.t.f(readOnly, "readOnly");
        ef.c cVarP = c.f8681a.p(jf.i.m(readOnly));
        if (cVarP != null) {
            fe.e eVarP = nf.e.m(readOnly).p(cVarP);
            kotlin.jvm.internal.t.e(eVarP, "getBuiltInClassByFqName(...)");
            return eVarP;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean c(fe.e mutable) {
        kotlin.jvm.internal.t.f(mutable, "mutable");
        return c.f8681a.k(jf.i.m(mutable));
    }

    public final boolean d(fe.e readOnly) {
        kotlin.jvm.internal.t.f(readOnly, "readOnly");
        return c.f8681a.l(jf.i.m(readOnly));
    }

    public final fe.e e(ef.c fqName, ce.i builtIns, Integer num) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(builtIns, "builtIns");
        ef.b bVarM = (num == null || !kotlin.jvm.internal.t.b(fqName, c.f8681a.h())) ? c.f8681a.m(fqName) : ce.o.a(num.intValue());
        if (bVarM != null) {
            return builtIns.p(bVarM.a());
        }
        return null;
    }

    public final Collection g(ef.c fqName, ce.i builtIns) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(builtIns, "builtIns");
        fe.e eVarF = f(this, fqName, builtIns, null, 4, null);
        if (eVarF == null) {
            return u0.d();
        }
        ef.c cVarP = c.f8681a.p(nf.e.p(eVarF));
        return cVarP == null ? t0.c(eVarF) : dd.r.n(eVarF, builtIns.p(cVarP));
    }
}
