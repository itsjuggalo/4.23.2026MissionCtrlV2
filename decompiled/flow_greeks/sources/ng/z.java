package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    public static final x a(y1 y1Var) {
        return new y(y1Var);
    }

    public static /* synthetic */ x b(y1 y1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            y1Var = null;
        }
        return a(y1Var);
    }

    public static final boolean c(x xVar, Object obj) {
        Throwable thE = cd.r.e(obj);
        return thE == null ? xVar.H(obj) : xVar.E(thE);
    }
}
