package Z5;

/* JADX INFO: renamed from: Z5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0794a {
    public static int a(int i7) {
        if (2 <= i7 && i7 < 37) {
            return i7;
        }
        throw new IllegalArgumentException("radix " + i7 + " was not in valid range " + new W5.g(2, 36));
    }

    public static final int b(char c7, int i7) {
        return Character.digit((int) c7, i7);
    }

    public static final boolean c(char c7) {
        return Character.isWhitespace(c7) || Character.isSpaceChar(c7);
    }
}
