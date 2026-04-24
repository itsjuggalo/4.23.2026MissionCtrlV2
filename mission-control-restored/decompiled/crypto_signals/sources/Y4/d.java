package Y4;

import a.AbstractC0284a;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends l {
    public static boolean U(String str, String str2) {
        kotlin.jvm.internal.j.e(str, "<this>");
        return Y(str, str2, 0, 2) >= 0;
    }

    public static int V(CharSequence charSequence) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int W(CharSequence other, String string, int i, boolean z6) {
        kotlin.jvm.internal.j.e(other, "<this>");
        kotlin.jvm.internal.j.e(string, "string");
        if (!z6 && (other instanceof String)) {
            return ((String) other).indexOf(string, i);
        }
        int length = other.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = other.length();
        if (length > length2) {
            length = length2;
        }
        V4.f fVar = new V4.f(i, length, 1);
        boolean z7 = other instanceof String;
        int i6 = fVar.f3300c;
        int i7 = fVar.f3299b;
        int i8 = fVar.f3298a;
        if (!z7 || string == null) {
            if ((i6 <= 0 || i8 > i7) && (i6 >= 0 || i7 > i8)) {
                return -1;
            }
            while (true) {
                int length3 = string.length();
                kotlin.jvm.internal.j.e(other, "other");
                if (i8 >= 0 && string.length() - length3 >= 0 && i8 <= other.length() - length3) {
                    for (int i9 = 0; i9 < length3; i9++) {
                        if (AbstractC0284a.h(string.charAt(i9), other.charAt(i8 + i9), z6)) {
                        }
                    }
                    return i8;
                }
                if (i8 == i7) {
                    return -1;
                }
                i8 += i6;
            }
        } else {
            if ((i6 <= 0 || i8 > i7) && (i6 >= 0 || i7 > i8)) {
                return -1;
            }
            int i10 = i8;
            while (true) {
                String str = string;
                boolean z8 = z6;
                if (l.R(0, i10, string.length(), str, (String) other, z8)) {
                    return i10;
                }
                if (i10 == i7) {
                    return -1;
                }
                i10 += i6;
                string = str;
                z6 = z8;
            }
        }
    }

    public static int X(CharSequence charSequence, char c6, int i, int i6) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c6, i);
        }
        char[] cArr = {c6};
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        int iV = V(charSequence);
        if (i > iV) {
            return -1;
        }
        while (!AbstractC0284a.h(cArr[0], charSequence.charAt(i), false)) {
            if (i == iV) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public static /* synthetic */ int Y(CharSequence charSequence, String str, int i, int i6) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return W(charSequence, str, i, false);
    }

    public static boolean Z(CharSequence charSequence) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static int a0(String str, String str2) {
        int iV = V(str);
        kotlin.jvm.internal.j.e(str, "<this>");
        return str.lastIndexOf(str2, iV);
    }

    public static String b0(int i, String str) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.j.e(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(a3.d.i("Desired length ", i, " is less than zero."));
        }
        if (i <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            sb.append((CharSequence) str);
            int length = i - str.length();
            int i6 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(' ');
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                }
            }
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static String c0(String str, String delimiter, String str2) {
        kotlin.jvm.internal.j.e(delimiter, "delimiter");
        int iY = Y(str, delimiter, 0, 6);
        if (iY == -1) {
            return str2;
        }
        String strSubstring = str.substring(delimiter.length() + iY, str.length());
        kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String d0(String str, String str2) {
        int iLastIndexOf = str.lastIndexOf(46, V(str));
        if (iLastIndexOf == -1) {
            return str2;
        }
        String strSubstring = str.substring(iLastIndexOf + 1, str.length());
        kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
