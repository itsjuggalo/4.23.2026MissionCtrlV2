package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface p1 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static /* synthetic */ q1 a(p1 p1Var, ge.h hVar, u1 u1Var, fe.m mVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
            }
            if ((i10 & 2) != 0) {
                u1Var = null;
            }
            if ((i10 & 4) != 0) {
                mVar = null;
            }
            return p1Var.a(hVar, u1Var, mVar);
        }
    }

    q1 a(ge.h hVar, u1 u1Var, fe.m mVar);
}
