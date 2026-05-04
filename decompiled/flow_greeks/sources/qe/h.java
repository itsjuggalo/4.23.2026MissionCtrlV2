package qe;

import cd.q;
import dd.a0;
import dd.s;
import fe.g1;
import fe.s1;
import ie.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;
import qf.k;
import se.z0;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final List a(Collection newValueParameterTypes, Collection oldValueParameters, fe.a newOwner) {
        t.f(newValueParameterTypes, "newValueParameterTypes");
        t.f(oldValueParameters, "oldValueParameters");
        t.f(newOwner, "newOwner");
        newValueParameterTypes.size();
        oldValueParameters.size();
        List<q> listS0 = a0.S0(newValueParameterTypes, oldValueParameters);
        ArrayList arrayList = new ArrayList(s.u(listS0, 10));
        for (q qVar : listS0) {
            r0 r0Var = (r0) qVar.a();
            s1 s1Var = (s1) qVar.b();
            int index = s1Var.getIndex();
            ge.h annotations = s1Var.getAnnotations();
            ef.f name = s1Var.getName();
            t.e(name, "getName(...)");
            boolean zS0 = s1Var.s0();
            boolean zB0 = s1Var.b0();
            boolean Z = s1Var.Z();
            r0 r0VarK = s1Var.j0() != null ? nf.e.s(newOwner).p().k(r0Var) : null;
            g1 g1VarJ = s1Var.j();
            t.e(g1VarJ, "getSource(...)");
            arrayList.add(new u0(newOwner, null, index, annotations, name, r0Var, zS0, zB0, Z, r0VarK, g1VarJ));
        }
        return arrayList;
    }

    public static final z0 b(fe.e eVar) {
        t.f(eVar, "<this>");
        fe.e eVarX = nf.e.x(eVar);
        if (eVarX == null) {
            return null;
        }
        k kVarT = eVarX.T();
        z0 z0Var = kVarT instanceof z0 ? (z0) kVarT : null;
        return z0Var == null ? b(eVarX) : z0Var;
    }
}
