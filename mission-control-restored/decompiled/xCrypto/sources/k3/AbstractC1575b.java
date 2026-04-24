package k3;

/* JADX INFO: renamed from: k3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1575b extends AbstractC1574a {
    public static int a(int i4) {
        return Integer.signum(i4);
    }

    public static int b(long j4) {
        return Long.signum(j4);
    }

    public static int c(double d4) {
        if (Double.isNaN(d4)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d4 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d4 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d4);
    }

    public static long d(double d4) {
        if (Double.isNaN(d4)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d4);
    }
}
