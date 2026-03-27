package G2;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(long j7, long j8) {
        return Long.compare(j7, j8);
    }

    public static int b(double d7, long j7) {
        if (Double.isNaN(d7) || d7 < -9.223372036854776E18d) {
            return -1;
        }
        if (d7 >= 9.223372036854776E18d) {
            return 1;
        }
        int iA = a((long) d7, j7);
        return iA != 0 ? iA : c(d7, j7);
    }

    public static int c(double d7, double d8) {
        if (d7 < d8) {
            return -1;
        }
        if (d7 > d8) {
            return 1;
        }
        if (d7 == d8) {
            return 0;
        }
        if (Double.isNaN(d8)) {
            return !Double.isNaN(d7) ? 1 : 0;
        }
        return -1;
    }
}
