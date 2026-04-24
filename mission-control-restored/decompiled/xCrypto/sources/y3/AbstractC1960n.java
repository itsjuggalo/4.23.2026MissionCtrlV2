package y3;

/* JADX INFO: renamed from: y3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1960n {
    public static final void a(int i4) {
        if (i4 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i4).toString());
    }
}
