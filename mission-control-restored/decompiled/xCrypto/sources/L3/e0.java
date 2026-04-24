package L3;

import H3.i;
import H3.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 {
    public static final H3.e a(H3.e eVar, M3.e module) {
        H3.e eVarA;
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(module, "module");
        if (!kotlin.jvm.internal.r.b(eVar.e(), i.a.f764a)) {
            return eVar.isInline() ? a(eVar.i(0), module) : eVar;
        }
        H3.e eVarB = H3.b.b(module, eVar);
        return (eVarB == null || (eVarA = a(eVarB, module)) == null) ? eVar : eVarA;
    }

    public static final d0 b(K3.a aVar, H3.e desc) {
        kotlin.jvm.internal.r.f(aVar, "<this>");
        kotlin.jvm.internal.r.f(desc, "desc");
        H3.i iVarE = desc.e();
        if (iVarE instanceof H3.c) {
            return d0.POLY_OBJ;
        }
        if (kotlin.jvm.internal.r.b(iVarE, j.b.f767a)) {
            return d0.LIST;
        }
        if (!kotlin.jvm.internal.r.b(iVarE, j.c.f768a)) {
            return d0.OBJ;
        }
        H3.e eVarA = a(desc.i(0), aVar.a());
        H3.i iVarE2 = eVarA.e();
        if ((iVarE2 instanceof H3.d) || kotlin.jvm.internal.r.b(iVarE2, i.b.f765a)) {
            return d0.MAP;
        }
        if (aVar.f().b()) {
            return d0.LIST;
        }
        throw E.d(eVarA);
    }
}
