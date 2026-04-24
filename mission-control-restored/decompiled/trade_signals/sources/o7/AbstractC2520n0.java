package o7;

/* JADX INFO: renamed from: o7.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2520n0 {
    public static /* synthetic */ void c(AbstractC2520n0 abstractC2520n0, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i9 & 1) != 0) {
            i8 = abstractC2520n0.d() + 1;
        }
        abstractC2520n0.b(i8);
    }

    public abstract Object a();

    public abstract void b(int i8);

    public abstract int d();
}
