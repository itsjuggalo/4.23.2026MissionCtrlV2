package kg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends y {
    public static /* synthetic */ boolean A(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return z(str, i10, str2, i11, i12, z10);
    }

    public static String B(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + com.amazon.a.a.o.c.a.b.f4610a).toString());
        }
        if (i10 == 0) {
            return "";
        }
        int i11 = 1;
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                cArr[i12] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        if (1 <= i10) {
            while (true) {
                sb2.append(charSequence);
                if (i11 == i10) {
                    break;
                }
                i11++;
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.t.c(string);
        return string;
    }

    public static final String C(String str, char c10, char c11, boolean z10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            kotlin.jvm.internal.t.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (b.d(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static final String D(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(oldValue, "oldValue");
        kotlin.jvm.internal.t.f(newValue, "newValue");
        int i10 = 0;
        int iY = c0.Y(str, oldValue, 0, z10);
        if (iY < 0) {
            return str;
        }
        int length = oldValue.length();
        int iB = vd.l.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iY);
            sb2.append(newValue);
            i10 = iY + length;
            if (iY >= str.length()) {
                break;
            }
            iY = c0.Y(str, oldValue, iY + iB, z10);
        } while (iY > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String E(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return C(str, c10, c11, z10);
    }

    public static /* synthetic */ String F(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return D(str, str2, str3, z10);
    }

    public static final String G(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(oldValue, "oldValue");
        kotlin.jvm.internal.t.f(newValue, "newValue");
        int iC0 = c0.c0(str, oldValue, 0, z10, 2, null);
        return iC0 < 0 ? str : c0.A0(str, iC0, oldValue.length() + iC0, newValue).toString();
    }

    public static /* synthetic */ String H(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return G(str, str2, str3, z10);
    }

    public static final boolean I(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : z(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean J(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return I(str, str2, z10);
    }

    public static String s(char[] cArr) {
        kotlin.jvm.internal.t.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String t(char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.t.f(cArr, "<this>");
        dd.d.f7994a.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static String u(byte[] bArr) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        return new String(bArr, c.f14857b);
    }

    public static byte[] v(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        byte[] bytes = str.getBytes(c.f14857b);
        kotlin.jvm.internal.t.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static final boolean w(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : z(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return w(str, str2, z10);
    }

    public static boolean y(String str, String str2, boolean z10) {
        return str == null ? str2 == null : !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean z(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }
}
