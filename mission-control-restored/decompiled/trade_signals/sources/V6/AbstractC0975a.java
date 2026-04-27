package V6;

/* JADX INFO: renamed from: V6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0975a {
    public static int a(int i8) {
        if (2 <= i8 && i8 < 37) {
            return i8;
        }
        throw new IllegalArgumentException("radix " + i8 + " was not in valid range " + new H5.d(2, 36));
    }

    public static final int b(char c8, int i8) {
        return Character.digit((int) c8, i8);
    }

    public static boolean c(char c8) {
        return Character.isWhitespace(c8) || Character.isSpaceChar(c8);
    }
}
