package Y1;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(long j4, long j5) {
        return Long.compare(j4, j5);
    }

    public static int b(double d4, long j4) {
        if (Double.isNaN(d4) || d4 < -9.223372036854776E18d) {
            return -1;
        }
        if (d4 >= 9.223372036854776E18d) {
            return 1;
        }
        int iA = a((long) d4, j4);
        return iA != 0 ? iA : c(d4, j4);
    }

    public static int c(double d4, double d5) {
        if (d4 < d5) {
            return -1;
        }
        if (d4 > d5) {
            return 1;
        }
        if (d4 == d5) {
            return 0;
        }
        if (Double.isNaN(d5)) {
            return !Double.isNaN(d4) ? 1 : 0;
        }
        return -1;
    }
}
