package d7;

/* JADX INFO: renamed from: d7.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1651l {
    public static final void a(int i8) {
        if (i8 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i8).toString());
    }

    public static final Y6.I b(Y6.I i8, String str) {
        return str != null ? new v(i8, str) : i8;
    }
}
