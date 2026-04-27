package J3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 {
    public static /* synthetic */ void c(e0 e0Var, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i5 & 1) != 0) {
            i4 = e0Var.d() + 1;
        }
        e0Var.b(i4);
    }

    public abstract Object a();

    public abstract void b(int i4);

    public abstract int d();
}
