package v2;

/* JADX INFO: renamed from: v2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2836b {
    public static boolean a(char c8) {
        return c8 >= 'a' && c8 <= 'z';
    }

    public static boolean b(char c8) {
        return c8 >= 'A' && c8 <= 'Z';
    }

    public static char c(char c8) {
        return a(c8) ? (char) (c8 ^ ' ') : c8;
    }
}
