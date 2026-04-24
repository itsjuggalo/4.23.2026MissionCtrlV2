package V6;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class G {
    public static /* synthetic */ long a(long j8, long j9) {
        if (j9 < 0) {
            return (j8 ^ Long.MIN_VALUE) < (j9 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j8 >= 0) {
            return j8 / j9;
        }
        long j10 = ((j8 >>> 1) / j9) << 1;
        return j10 + ((long) (((j8 - (j10 * j9)) ^ Long.MIN_VALUE) < (j9 ^ Long.MIN_VALUE) ? 0 : 1));
    }
}
