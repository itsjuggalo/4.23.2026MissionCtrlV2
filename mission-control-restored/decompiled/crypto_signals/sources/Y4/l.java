package Y4;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends k {
    public static boolean Q(String str, String str2, boolean z6) {
        return !z6 ? str.endsWith(str2) : R(str.length() - str2.length(), 0, str2.length(), str, str2, true);
    }

    public static boolean R(int i, int i6, int i7, String str, String other, boolean z6) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(other, "other");
        return !z6 ? str.regionMatches(i, other, i6, i7) : str.regionMatches(z6, i, other, i6, i7);
    }

    public static String S(String str, String str2, String newValue) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(newValue, "newValue");
        int iW = d.W(str, str2, 0, false);
        if (iW < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i6 = 0;
        do {
            sb.append((CharSequence) str, i6, iW);
            sb.append(newValue);
            i6 = iW + length;
            if (iW >= str.length()) {
                break;
            }
            iW = d.W(str, str2, iW + i, false);
        } while (iW > 0);
        sb.append((CharSequence) str, i6, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }

    public static boolean T(String str, String prefix) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(prefix, "prefix");
        return str.startsWith(prefix);
    }
}
