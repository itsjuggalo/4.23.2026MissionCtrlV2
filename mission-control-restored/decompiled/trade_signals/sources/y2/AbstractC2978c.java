package y2;

/* JADX INFO: renamed from: y2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2978c {
    public static void a(boolean z7, String str, long j8, long j9) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j8 + ", " + j9 + ")");
    }

    public static int b(String str, int i8) {
        if (i8 > 0) {
            return i8;
        }
        throw new IllegalArgumentException(str + " (" + i8 + ") must be > 0");
    }

    public static void c(boolean z7) {
        if (!z7) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
