package yd;

import dd.a0;
import fe.e;
import fe.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import wd.f;
import wd.q;
import wd.r;
import zd.t2;
import zd.x2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final wd.d a(f fVar) {
        Object obj;
        wd.d dVarB;
        t.f(fVar, "<this>");
        if (fVar instanceof wd.d) {
            return (wd.d) fVar;
        }
        if (!(fVar instanceof r)) {
            throw new x2("Cannot calculate JVM erasure for type: " + fVar);
        }
        List upperBounds = ((r) fVar).getUpperBounds();
        Iterator it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            q qVar = (q) next;
            t.d(qVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            h hVarB = ((t2) qVar).x().N0().b();
            e eVar = hVarB instanceof e ? (e) hVarB : null;
            if (eVar != null && eVar.h() != fe.f.f9474c && eVar.h() != fe.f.f9477f) {
                obj = next;
                break;
            }
        }
        q qVar2 = (q) obj;
        if (qVar2 == null) {
            qVar2 = (q) a0.b0(upperBounds);
        }
        return (qVar2 == null || (dVarB = b(qVar2)) == null) ? n0.b(Object.class) : dVarB;
    }

    public static final wd.d b(q qVar) {
        wd.d dVarA;
        t.f(qVar, "<this>");
        f fVarJ = qVar.j();
        if (fVarJ != null && (dVarA = a(fVarJ)) != null) {
            return dVarA;
        }
        throw new x2("Cannot calculate JVM erasure for type: " + qVar);
    }
}
