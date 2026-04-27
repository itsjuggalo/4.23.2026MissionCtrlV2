package r3;

import X2.AbstractC0757d;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends w {
    public static /* synthetic */ String A(String str, String str2, String str3, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return y(str, str2, str3, z4);
    }

    public static final boolean B(String str, String prefix, boolean z4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        return !z4 ? str.startsWith(prefix) : w(str, 0, prefix, 0, prefix.length(), z4);
    }

    public static /* synthetic */ boolean C(String str, String str2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return B(str, str2, z4);
    }

    public static String q(char[] cArr) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String r(char[] cArr, int i4, int i5) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        AbstractC0757d.f5605a.a(i4, i5, cArr.length);
        return new String(cArr, i4, i5 - i4);
    }

    public static byte[] s(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        byte[] bytes = str.getBytes(C1756c.f14563b);
        kotlin.jvm.internal.r.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static final boolean t(String str, String suffix, boolean z4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(suffix, "suffix");
        return !z4 ? str.endsWith(suffix) : w(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean u(String str, String str2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return t(str, str2, z4);
    }

    public static boolean v(String str, String str2, boolean z4) {
        return str == null ? str2 == null : !z4 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean w(String str, int i4, String other, int i5, int i6, boolean z4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        return !z4 ? str.regionMatches(i4, other, i5, i6) : str.regionMatches(z4, i4, other, i5, i6);
    }

    public static final String x(String str, char c4, char c5, boolean z4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (!z4) {
            String strReplace = str.replace(c4, c5);
            kotlin.jvm.internal.r.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (AbstractC1755b.d(cCharAt, c4, z4)) {
                cCharAt = c5;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static final String y(String str, String oldValue, String newValue, boolean z4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(oldValue, "oldValue");
        kotlin.jvm.internal.r.f(newValue, "newValue");
        int i4 = 0;
        int iO = AbstractC1753A.O(str, oldValue, 0, z4);
        if (iO < 0) {
            return str;
        }
        int length = oldValue.length();
        int iB = AbstractC1681l.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i4, iO);
            sb.append(newValue);
            i4 = iO + length;
            if (iO >= str.length()) {
                break;
            }
            iO = AbstractC1753A.O(str, oldValue, iO + iB, z4);
        } while (iO > 0);
        sb.append((CharSequence) str, i4, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String z(String str, char c4, char c5, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return x(str, c4, c5, z4);
    }
}
