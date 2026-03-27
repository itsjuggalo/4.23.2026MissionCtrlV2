package L5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final int a(int i7, int i8, int i9) {
        return e(e(i7, i9) - e(i8, i9), i9);
    }

    public static final long b(long j7, long j8, long j9) {
        return f(f(j7, j9) - f(j8, j9), j9);
    }

    public static final int c(int i7, int i8, int i9) {
        if (i9 > 0) {
            return i7 >= i8 ? i8 : i8 - a(i8, i7, i9);
        }
        if (i9 < 0) {
            return i7 <= i8 ? i8 : i8 + a(i7, i8, -i9);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long d(long j7, long j8, long j9) {
        if (j9 > 0) {
            return j7 >= j8 ? j8 : j8 - b(j8, j7, j9);
        }
        if (j9 < 0) {
            return j7 <= j8 ? j8 : j8 + b(j7, j8, -j9);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int e(int i7, int i8) {
        int i9 = i7 % i8;
        return i9 >= 0 ? i9 : i9 + i8;
    }

    public static final long f(long j7, long j8) {
        long j9 = j7 % j8;
        return j9 >= 0 ? j9 : j9 + j8;
    }
}
