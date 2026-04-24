package r3;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class E {
    public static /* synthetic */ long a(long j4, long j5) {
        if (j5 < 0) {
            return (j4 ^ Long.MIN_VALUE) < (j5 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j4 >= 0) {
            return j4 / j5;
        }
        long j6 = ((j4 >>> 1) / j5) << 1;
        return j6 + ((long) (((j4 - (j6 * j5)) ^ Long.MIN_VALUE) < (j5 ^ Long.MIN_VALUE) ? 0 : 1));
    }
}
