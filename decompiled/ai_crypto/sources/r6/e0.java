package r6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {
    public static /* synthetic */ void c(e0 e0Var, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i8 & 1) != 0) {
            i7 = e0Var.d() + 1;
        }
        e0Var.b(i7);
    }

    public abstract Object a();

    public abstract void b(int i7);

    public abstract int d();
}
