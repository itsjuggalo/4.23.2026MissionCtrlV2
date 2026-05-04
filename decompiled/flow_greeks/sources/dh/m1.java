package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m1 {
    public static /* synthetic */ void c(m1 m1Var, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i11 & 1) != 0) {
            i10 = m1Var.d() + 1;
        }
        m1Var.b(i10);
    }

    public abstract Object a();

    public abstract void b(int i10);

    public abstract int d();
}
