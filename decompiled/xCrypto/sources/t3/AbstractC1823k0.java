package t3;

/* JADX INFO: renamed from: t3.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1823k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y3.F f15017a = new y3.F("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y3.F f15018b = new y3.F("CLOSED_EMPTY");

    public static final long c(long j4) {
        if (j4 <= 0) {
            return 0L;
        }
        if (j4 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j4 * 1000000;
    }
}
