package p1;

/* JADX INFO: renamed from: p1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2370e {
    public static String a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i7 = 0; i7 < str.length(); i7++) {
            sb.append(str.charAt(i7));
            if (str2.length() > i7) {
                sb.append(str2.charAt(i7));
            }
        }
        return sb.toString();
    }
}
