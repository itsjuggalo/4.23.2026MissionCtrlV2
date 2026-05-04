package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static n a() {
        return g.y();
    }

    public static boolean b(n nVar) {
        if (nVar.n().isEmpty()) {
            return nVar.isEmpty() || (nVar instanceof f) || (nVar instanceof t) || (nVar instanceof e);
        }
        return false;
    }

    public static n c(j8.l lVar, Object obj) {
        String str;
        n nVarA = o.a(obj);
        if (nVarA instanceof l) {
            nVarA = new f(Double.valueOf(((Long) nVarA.getValue()).longValue()), a());
        }
        if (b(nVarA)) {
            return nVarA;
        }
        StringBuilder sb2 = new StringBuilder();
        if (lVar != null) {
            str = "Path '" + lVar + "'";
        } else {
            str = "Node";
        }
        sb2.append(str);
        sb2.append(" contains invalid priority: Must be a string, double, ServerValue, or null");
        throw new e8.d(sb2.toString());
    }

    public static n d(Object obj) {
        return c(null, obj);
    }
}
