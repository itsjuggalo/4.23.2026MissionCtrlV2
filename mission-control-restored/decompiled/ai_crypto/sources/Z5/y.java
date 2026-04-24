package Z5;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class y {
    public static /* synthetic */ long a(long j7, long j8) {
        if (j8 < 0) {
            return (j7 ^ Long.MIN_VALUE) < (j8 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j7 >= 0) {
            return j7 / j8;
        }
        long j9 = ((j7 >>> 1) / j8) << 1;
        return j9 + ((long) (((j7 - (j9 * j8)) ^ Long.MIN_VALUE) < (j8 ^ Long.MIN_VALUE) ? 0 : 1));
    }
}
