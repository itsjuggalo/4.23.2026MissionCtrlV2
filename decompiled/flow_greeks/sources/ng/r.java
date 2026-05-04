package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {
    public static final void a(n nVar, e1 e1Var) {
        c(nVar, new f1(e1Var));
    }

    public static final p b(gd.e eVar) {
        if (!(eVar instanceof sg.h)) {
            return new p(eVar, 1);
        }
        p pVarN = ((sg.h) eVar).n();
        if (pVarN != null) {
            if (!pVarN.N()) {
                pVarN = null;
            }
            if (pVarN != null) {
                return pVarN;
            }
        }
        return new p(eVar, 2);
    }

    public static final void c(n nVar, m mVar) {
        if (!(nVar instanceof p)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((p) nVar).H(mVar);
    }
}
