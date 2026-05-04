package of;

import ce.o;
import fe.h;
import fe.l1;
import fe.m;
import fe.s1;
import java.util.Iterator;
import java.util.List;
import jf.i;
import jf.k;
import kotlin.jvm.internal.t;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final boolean a(fe.e eVar) {
        return t.b(nf.e.o(eVar), o.f3969w);
    }

    public static final boolean b(r0 r0Var, boolean z10) {
        h hVarB = r0Var.N0().b();
        l1 l1Var = hVarB instanceof l1 ? (l1) hVarB : null;
        if (l1Var == null) {
            return false;
        }
        return (z10 || !k.d(l1Var)) && e(cg.d.o(l1Var));
    }

    public static final boolean c(m mVar) {
        t.f(mVar, "<this>");
        return k.g(mVar) && !a((fe.e) mVar);
    }

    public static final boolean d(r0 r0Var) {
        t.f(r0Var, "<this>");
        h hVarB = r0Var.N0().b();
        return hVarB != null && ((k.b(hVarB) && c(hVarB)) || k.i(r0Var));
    }

    public static final boolean e(r0 r0Var) {
        return d(r0Var) || b(r0Var, true);
    }

    public static final boolean f(fe.b descriptor) {
        t.f(descriptor, "descriptor");
        fe.d dVar = descriptor instanceof fe.d ? (fe.d) descriptor : null;
        if (dVar == null || fe.t.g(dVar.getVisibility())) {
            return false;
        }
        fe.e eVarD = dVar.D();
        t.e(eVarD, "getConstructedClass(...)");
        if (k.g(eVarD) || i.G(dVar.D())) {
            return false;
        }
        List listI = dVar.i();
        t.e(listI, "getValueParameters(...)");
        if (listI != null && listI.isEmpty()) {
            return false;
        }
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            r0 type = ((s1) it.next()).getType();
            t.e(type, "getType(...)");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
