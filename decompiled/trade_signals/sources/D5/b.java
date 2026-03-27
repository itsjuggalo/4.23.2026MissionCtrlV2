package D5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends a {
    public static int a(int i8) {
        return Integer.signum(i8);
    }

    public static int b(long j8) {
        return Long.signum(j8);
    }

    public static int c(double d8) {
        if (Double.isNaN(d8)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d8 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d8 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d8);
    }

    public static long d(double d8) {
        if (Double.isNaN(d8)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d8);
    }
}
