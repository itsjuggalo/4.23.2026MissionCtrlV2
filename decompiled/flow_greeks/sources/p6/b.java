package p6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(char c10) {
        return c10 >= 'a' && c10 <= 'z';
    }

    public static boolean b(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static char c(char c10) {
        return a(c10) ? (char) (c10 ^ ' ') : c10;
    }
}
