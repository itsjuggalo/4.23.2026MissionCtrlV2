package r3;

/* JADX INFO: renamed from: r3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1755b extends AbstractC1754a {
    public static final boolean d(char c4, char c5, boolean z4) {
        if (c4 == c5) {
            return true;
        }
        if (!z4) {
            return false;
        }
        char upperCase = Character.toUpperCase(c4);
        char upperCase2 = Character.toUpperCase(c5);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static String e(char c4) {
        return I.a(c4);
    }
}
