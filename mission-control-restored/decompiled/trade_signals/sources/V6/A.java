package V6;

import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2582d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends z {
    public static String A(CharSequence charSequence, int i8) {
        AbstractC2304t.f(charSequence, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i8 + com.amazon.a.a.o.c.a.b.f14112a).toString());
        }
        if (i8 == 0) {
            return "";
        }
        int i9 = 1;
        if (i8 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i8];
            for (int i10 = 0; i10 < i8; i10++) {
                cArr[i10] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i8);
        if (1 <= i8) {
            while (true) {
                sb.append(charSequence);
                if (i9 == i8) {
                    break;
                }
                i9++;
            }
        }
        String string = sb.toString();
        AbstractC2304t.c(string);
        return string;
    }

    public static final String B(String str, char c8, char c9, boolean z7) {
        AbstractC2304t.f(str, "<this>");
        if (!z7) {
            String strReplace = str.replace(c8, c9);
            AbstractC2304t.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (AbstractC0976b.d(cCharAt, c8, z7)) {
                cCharAt = c9;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static final String C(String str, String oldValue, String newValue, boolean z7) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(oldValue, "oldValue");
        AbstractC2304t.f(newValue, "newValue");
        int i8 = 0;
        int iU = C.U(str, oldValue, 0, z7);
        if (iU < 0) {
            return str;
        }
        int length = oldValue.length();
        int iB = H5.i.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i8, iU);
            sb.append(newValue);
            i8 = iU + length;
            if (iU >= str.length()) {
                break;
            }
            iU = C.U(str, oldValue, iU + iB, z7);
        } while (iU > 0);
        sb.append((CharSequence) str, i8, str.length());
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String D(String str, char c8, char c9, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return B(str, c8, c9, z7);
    }

    public static /* synthetic */ String E(String str, String str2, String str3, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return C(str, str2, str3, z7);
    }

    public static final boolean F(String str, String prefix, boolean z7) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(prefix, "prefix");
        return !z7 ? str.startsWith(prefix) : y(str, 0, prefix, 0, prefix.length(), z7);
    }

    public static /* synthetic */ boolean G(String str, String str2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return F(str, str2, z7);
    }

    public static String r(char[] cArr) {
        AbstractC2304t.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String s(char[] cArr, int i8, int i9) {
        AbstractC2304t.f(cArr, "<this>");
        AbstractC2582d.f22376a.a(i8, i9, cArr.length);
        return new String(cArr, i8, i9 - i8);
    }

    public static String t(byte[] bArr) {
        AbstractC2304t.f(bArr, "<this>");
        return new String(bArr, C0977c.f8956b);
    }

    public static byte[] u(String str) {
        AbstractC2304t.f(str, "<this>");
        byte[] bytes = str.getBytes(C0977c.f8956b);
        AbstractC2304t.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean v(String str, String suffix, boolean z7) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(suffix, "suffix");
        return !z7 ? str.endsWith(suffix) : y(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean w(String str, String str2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return v(str, str2, z7);
    }

    public static boolean x(String str, String str2, boolean z7) {
        return str == null ? str2 == null : !z7 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean y(String str, int i8, String other, int i9, int i10, boolean z7) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(other, "other");
        return !z7 ? str.regionMatches(i8, other, i9, i10) : str.regionMatches(z7, i8, other, i9, i10);
    }

    public static /* synthetic */ boolean z(String str, int i8, String str2, int i9, int i10, boolean z7, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            z7 = false;
        }
        return y(str, i8, str2, i9, i10, z7);
    }
}
