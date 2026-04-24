package Y6;

/* JADX INFO: renamed from: Y6.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1010i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d7.D f9672a = new d7.D("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d7.D f9673b = new d7.D("CLOSED_EMPTY");

    public static final long c(long j8) {
        if (j8 <= 0) {
            return 0L;
        }
        if (j8 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j8;
    }
}
