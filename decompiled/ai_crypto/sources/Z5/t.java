package Z5;

import F5.AbstractC0545c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends s {
    public static String m(char[] cArr) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String n(char[] cArr, int i7, int i8) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        AbstractC0545c.f2367a.a(i7, i8, cArr.length);
        return new String(cArr, i7, i8 - i7);
    }

    public static byte[] o(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        byte[] bytes = str.getBytes(C0796c.f6018b);
        kotlin.jvm.internal.r.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean p(String str, String suffix, boolean z7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(suffix, "suffix");
        return !z7 ? str.endsWith(suffix) : s(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean q(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return p(str, str2, z7);
    }

    public static boolean r(String str, String str2, boolean z7) {
        return str == null ? str2 == null : !z7 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean s(String str, int i7, String other, int i8, int i9, boolean z7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        return !z7 ? str.regionMatches(i7, other, i8, i9) : str.regionMatches(z7, i7, other, i8, i9);
    }

    public static final String t(String str, char c7, char c8, boolean z7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (!z7) {
            String strReplace = str.replace(c7, c8);
            kotlin.jvm.internal.r.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (AbstractC0795b.d(cCharAt, c7, z7)) {
                cCharAt = c8;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static final String u(String str, String oldValue, String newValue, boolean z7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(oldValue, "oldValue");
        kotlin.jvm.internal.r.f(newValue, "newValue");
        int i7 = 0;
        int iJ = u.J(str, oldValue, 0, z7);
        if (iJ < 0) {
            return str;
        }
        int length = oldValue.length();
        int iB = W5.l.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i7, iJ);
            sb.append(newValue);
            i7 = iJ + length;
            if (iJ >= str.length()) {
                break;
            }
            iJ = u.J(str, oldValue, iJ + iB, z7);
        } while (iJ > 0);
        sb.append((CharSequence) str, i7, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String v(String str, char c7, char c8, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return t(str, c7, c8, z7);
    }

    public static /* synthetic */ String w(String str, String str2, String str3, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return u(str, str2, str3, z7);
    }

    public static final boolean x(String str, String prefix, boolean z7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        return !z7 ? str.startsWith(prefix) : s(str, 0, prefix, 0, prefix.length(), z7);
    }

    public static /* synthetic */ boolean y(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return x(str, str2, z7);
    }
}
