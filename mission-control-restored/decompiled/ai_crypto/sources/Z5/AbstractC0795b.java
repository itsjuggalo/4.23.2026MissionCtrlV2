package Z5;

/* JADX INFO: renamed from: Z5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0795b extends AbstractC0794a {
    public static final boolean d(char c7, char c8, boolean z7) {
        if (c7 == c8) {
            return true;
        }
        if (!z7) {
            return false;
        }
        char upperCase = Character.toUpperCase(c7);
        char upperCase2 = Character.toUpperCase(c8);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static String e(char c7) {
        return C.a(c7);
    }
}
