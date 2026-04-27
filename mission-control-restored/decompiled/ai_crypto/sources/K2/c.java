package K2;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(boolean z7, String str, long j7, long j8) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j7 + ", " + j8 + ")");
    }

    public static int b(String str, int i7) {
        if (i7 > 0) {
            return i7;
        }
        throw new IllegalArgumentException(str + " (" + i7 + ") must be > 0");
    }

    public static void c(boolean z7) {
        if (!z7) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
