package b6;

/* JADX INFO: renamed from: b6.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1078k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g6.F f9075a = new g6.F("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g6.F f9076b = new g6.F("CLOSED_EMPTY");

    public static final long c(long j7) {
        if (j7 <= 0) {
            return 0L;
        }
        if (j7 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j7;
    }
}
