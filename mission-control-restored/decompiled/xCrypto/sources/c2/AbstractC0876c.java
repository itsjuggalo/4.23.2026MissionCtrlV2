package c2;

/* JADX INFO: renamed from: c2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0876c {
    public static void a(boolean z4, String str, long j4, long j5) {
        if (z4) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j4 + ", " + j5 + ")");
    }

    public static int b(String str, int i4) {
        if (i4 > 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + " (" + i4 + ") must be > 0");
    }

    public static void c(boolean z4) {
        if (!z4) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
