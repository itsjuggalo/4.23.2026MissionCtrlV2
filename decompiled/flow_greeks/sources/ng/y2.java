package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y2 {
    public static final w2 a(long j10, w0 w0Var, y1 y1Var) {
        return new w2("Timed out waiting for " + j10 + " ms", y1Var);
    }

    public static final Object b(x2 x2Var, pd.o oVar) {
        b2.f(x2Var, x0.b(x2Var.f20435d.getContext()).K(x2Var.f17196e, x2Var, x2Var.getContext()));
        return tg.b.c(x2Var, x2Var, oVar);
    }

    public static final Object c(long j10, pd.o oVar, gd.e eVar) {
        if (j10 <= 0) {
            throw new w2("Timed out immediately");
        }
        Object objB = b(new x2(j10, eVar), oVar);
        if (objB == hd.c.f()) {
            id.h.c(eVar);
        }
        return objB;
    }
}
