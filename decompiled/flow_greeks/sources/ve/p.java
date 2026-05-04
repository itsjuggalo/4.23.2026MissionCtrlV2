package ve;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static final boolean a(r rVar) {
        ef.c cVarE;
        b0 b0Var = (b0) dd.a0.x0(rVar.i());
        x type = b0Var != null ? b0Var.getType() : null;
        j jVar = type instanceof j ? (j) type : null;
        if (jVar == null) {
            return false;
        }
        i iVarJ = jVar.j();
        return (iVarJ instanceof g) && (cVarE = ((g) iVarJ).e()) != null && kotlin.jvm.internal.t.b(cVarE.a(), "java.lang.Object");
    }

    public static final boolean b(r rVar) {
        String strB = rVar.getName().b();
        int iHashCode = strB.hashCode();
        if (iHashCode != -1776922004) {
            if (iHashCode == -1295482945) {
                if (strB.equals("equals")) {
                    return a(rVar);
                }
                return false;
            }
            if (iHashCode != 147696667 || !strB.equals("hashCode")) {
                return false;
            }
        } else if (!strB.equals("toString")) {
            return false;
        }
        return rVar.i().isEmpty();
    }

    public static final boolean c(q qVar) {
        kotlin.jvm.internal.t.f(qVar, "<this>");
        return qVar.O().G() && (qVar instanceof r) && b((r) qVar);
    }
}
