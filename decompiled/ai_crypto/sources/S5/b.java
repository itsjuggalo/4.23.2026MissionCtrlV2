package S5;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends a {
    public static int a(int i7) {
        return Integer.signum(i7);
    }

    public static int b(long j7) {
        return Long.signum(j7);
    }

    public static int c(double d7) {
        if (Double.isNaN(d7)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d7 > 2.147483647E9d) {
            return a.e.API_PRIORITY_OTHER;
        }
        if (d7 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d7);
    }

    public static long d(double d7) {
        if (Double.isNaN(d7)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d7);
    }
}
