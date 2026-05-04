package sg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f20376a = new d0("CLOSED");

    public static final b b(b bVar) {
        while (true) {
            Object objG = bVar.g();
            if (objG == f20376a) {
                return bVar;
            }
            b bVar2 = (b) objG;
            if (bVar2 != null) {
                bVar = bVar2;
            } else if (bVar.m()) {
                return bVar;
            }
        }
    }

    public static final Object c(a0 a0Var, long j10, pd.o oVar) {
        while (true) {
            if (a0Var.f20378c >= j10 && !a0Var.k()) {
                return b0.a(a0Var);
            }
            Object objG = a0Var.g();
            if (objG == f20376a) {
                return b0.a(f20376a);
            }
            a0 a0Var2 = (a0) ((b) objG);
            if (a0Var2 == null) {
                a0Var2 = (a0) oVar.invoke(Long.valueOf(a0Var.f20378c + 1), a0Var);
                if (a0Var.o(a0Var2)) {
                    if (a0Var.k()) {
                        a0Var.n();
                    }
                }
            }
            a0Var = a0Var2;
        }
    }
}
