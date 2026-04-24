package Q6;

import V6.C;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final String a(String str) {
        char cCharAt;
        AbstractC2304t.f(str, "<this>");
        if (str.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt >= '{') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(cCharAt));
        sb.append((CharSequence) str, 1, str.length());
        return sb.toString();
    }

    public static final String b(String str) {
        char cCharAt;
        AbstractC2304t.f(str, "<this>");
        if (str.length() == 0 || 'A' > (cCharAt = str.charAt(0)) || cCharAt >= '[') {
            return str;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        String strSubstring = str.substring(1);
        AbstractC2304t.e(strSubstring, "substring(...)");
        return lowerCase + strSubstring;
    }

    public static final String c(String str, boolean z7) {
        Object next;
        AbstractC2304t.f(str, "<this>");
        if (str.length() == 0 || !d(str, 0, z7)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z7)) {
            if (z7) {
                return b(str);
            }
            if (str.length() <= 0) {
                return str;
            }
            char lowerCase = Character.toLowerCase(str.charAt(0));
            String strSubstring = str.substring(1);
            AbstractC2304t.e(strSubstring, "substring(...)");
            return lowerCase + strSubstring;
        }
        Iterator it = C.R(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!d(str, ((Number) next).intValue(), z7)) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num == null) {
            return e(str, z7);
        }
        int iIntValue = num.intValue() - 1;
        StringBuilder sb = new StringBuilder();
        String strSubstring2 = str.substring(0, iIntValue);
        AbstractC2304t.e(strSubstring2, "substring(...)");
        sb.append(e(strSubstring2, z7));
        String strSubstring3 = str.substring(iIntValue);
        AbstractC2304t.e(strSubstring3, "substring(...)");
        sb.append(strSubstring3);
        return sb.toString();
    }

    public static final boolean d(String str, int i8, boolean z7) {
        char cCharAt = str.charAt(i8);
        return z7 ? 'A' <= cCharAt && cCharAt < '[' : Character.isUpperCase(cCharAt);
    }

    public static final String e(String str, boolean z7) {
        if (z7) {
            return f(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        AbstractC2304t.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String f(String str) {
        AbstractC2304t.f(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }
}
