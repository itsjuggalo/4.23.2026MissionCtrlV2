package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface n extends gd.e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static /* synthetic */ boolean a(n nVar, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return nVar.cancel(th);
        }
    }

    void c(Object obj, pd.p pVar);

    boolean cancel(Throwable th);

    void f(pd.k kVar);

    Object h(Throwable th);

    boolean isCompleted();

    void j(k0 k0Var, Object obj);

    Object k(Object obj, Object obj2, pd.p pVar);

    void p(Object obj);
}
