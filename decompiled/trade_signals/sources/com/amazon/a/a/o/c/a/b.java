package com.amazon.a.a.o.c.a;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14114c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f14115d = '/';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f14116e = '\\';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f14118g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f14112a = '.';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14113b = Character.toString(f14112a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f14117f = File.separatorChar;

    static {
        f14118g = a() ? f14115d : f14116e;
    }

    public static String a(String str) {
        return a(str, f14117f, true);
    }

    public static String b(String str) {
        return a(str, f14117f, false);
    }

    public static String c(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace(f14116e, f14115d);
    }

    public static String d(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace(f14115d, f14116e);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return a() ? d(str) : c(str);
    }

    public static int f(String str) {
        int iMin;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (cCharAt == '~') {
                return 2;
            }
            return a(cCharAt) ? 1 : 0;
        }
        if (cCharAt == '~') {
            int iIndexOf = str.indexOf(47, 1);
            int iIndexOf2 = str.indexOf(92, 1);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                return length + 1;
            }
            if (iIndexOf == -1) {
                iIndexOf = iIndexOf2;
            }
            if (iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            iMin = Math.min(iIndexOf, iIndexOf2);
        } else {
            char cCharAt2 = str.charAt(1);
            if (cCharAt2 == ':') {
                char upperCase = Character.toUpperCase(cCharAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    return -1;
                }
                return (length == 2 || !a(str.charAt(2))) ? 2 : 3;
            }
            if (!a(cCharAt) || !a(cCharAt2)) {
                return a(cCharAt) ? 1 : 0;
            }
            int iIndexOf3 = str.indexOf(47, 2);
            int iIndexOf4 = str.indexOf(92, 2);
            if ((iIndexOf3 == -1 && iIndexOf4 == -1) || iIndexOf3 == 2 || iIndexOf4 == 2) {
                return -1;
            }
            if (iIndexOf3 == -1) {
                iIndexOf3 = iIndexOf4;
            }
            if (iIndexOf4 == -1) {
                iIndexOf4 = iIndexOf3;
            }
            iMin = Math.min(iIndexOf3, iIndexOf4);
        }
        return iMin + 1;
    }

    public static int g(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int h(String str) {
        int iLastIndexOf;
        if (str != null && g(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String i(String str) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        if (iF <= str.length()) {
            String strSubstring = str.substring(0, iF);
            s(strSubstring);
            return strSubstring;
        }
        s(str + f14115d);
        return str + f14115d;
    }

    public static String j(String str) {
        return a(str, 1);
    }

    public static String k(String str) {
        return a(str, 0);
    }

    public static String l(String str) {
        return c(str, true);
    }

    public static String m(String str) {
        return c(str, false);
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        s(str);
        return str.substring(g(str) + 1);
    }

    public static String o(String str) {
        return q(n(str));
    }

    public static String p(String str) {
        if (str == null) {
            return null;
        }
        int iH = h(str);
        return iH == -1 ? "" : str.substring(iH + 1);
    }

    public static String q(String str) {
        if (str == null) {
            return null;
        }
        s(str);
        int iH = h(str);
        return iH == -1 ? str : str.substring(0, iH);
    }

    public static String[] r(String str) {
        String str2;
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i8 = 0;
        char c8 = 0;
        while (i8 < length) {
            char c9 = charArray[i8];
            if (c9 == '?' || c9 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c9 == '?') {
                    str2 = "?";
                } else if (c8 != '*') {
                    str2 = "*";
                }
                arrayList.add(str2);
            } else {
                sb.append(c9);
            }
            i8++;
            c8 = c9;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void s(String str) {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (str.charAt(i8) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    private static String a(String str, char c8, boolean z7) {
        boolean z8;
        if (str == null) {
            return null;
        }
        s(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int iF = f(str);
        if (iF < 0) {
            return null;
        }
        int i8 = length + 2;
        char[] cArr = new char[i8];
        str.getChars(0, str.length(), cArr, 0);
        char c9 = f14117f;
        if (c8 == c9) {
            c9 = f14118g;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (cArr[i9] == c9) {
                cArr[i9] = c8;
            }
        }
        if (cArr[length - 1] != c8) {
            cArr[length] = c8;
            length++;
            z8 = false;
        } else {
            z8 = true;
        }
        int i10 = iF + 1;
        int i11 = i10;
        while (i11 < length) {
            if (cArr[i11] == c8) {
                int i12 = i11 - 1;
                if (cArr[i12] == c8) {
                    System.arraycopy(cArr, i11, cArr, i12, length - i11);
                    length--;
                    i11--;
                }
            }
            i11++;
        }
        int i13 = i10;
        while (i13 < length) {
            if (cArr[i13] == c8) {
                int i14 = i13 - 1;
                if (cArr[i14] == '.' && (i13 == i10 || cArr[i13 - 2] == c8)) {
                    if (i13 == length - 1) {
                        z8 = true;
                    }
                    System.arraycopy(cArr, i13 + 1, cArr, i14, length - i13);
                    length -= 2;
                    i13--;
                }
            }
            i13++;
        }
        int i15 = iF + 2;
        int i16 = i15;
        while (i16 < length) {
            if (cArr[i16] == c8 && cArr[i16 - 1] == '.' && cArr[i16 - 2] == '.' && (i16 == i15 || cArr[i16 - 3] == c8)) {
                if (i16 == i15) {
                    return null;
                }
                if (i16 == length - 1) {
                    z8 = true;
                }
                int i17 = i16 - 4;
                while (true) {
                    if (i17 < iF) {
                        int i18 = i16 + 1;
                        System.arraycopy(cArr, i18, cArr, iF, length - i16);
                        length -= i18 - iF;
                        i16 = i10;
                        break;
                    }
                    if (cArr[i17] == c8) {
                        int i19 = i17 + 1;
                        System.arraycopy(cArr, i16 + 1, cArr, i19, length - i16);
                        length -= i16 - i17;
                        i16 = i19;
                        break;
                    }
                    i17--;
                }
            }
            i16++;
        }
        return length <= 0 ? "" : length <= iF ? new String(cArr, 0, length) : (z8 && z7) ? new String(cArr, 0, length) : new String(cArr, 0, length - 1);
    }

    public static String b(String str, boolean z7) {
        return a(str, z7 ? f14115d : f14116e, false);
    }

    private static String c(String str, boolean z7) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        if (iF >= str.length()) {
            return z7 ? i(str) : str;
        }
        int iG = g(str);
        if (iG < 0) {
            return str.substring(0, iF);
        }
        int i8 = iG + (z7 ? 1 : 0);
        if (i8 == 0) {
            i8++;
        }
        return str.substring(0, i8);
    }

    public static boolean d(String str, String str2) {
        return a(str, str2, false, d.SYSTEM);
    }

    public static boolean e(String str, String str2) {
        return a(str, str2, true, d.SENSITIVE);
    }

    public static boolean f(String str, String str2) {
        return a(str, str2, true, d.SYSTEM);
    }

    public static boolean g(String str, String str2) {
        if (str == null) {
            return false;
        }
        s(str);
        return (str2 == null || str2.isEmpty()) ? h(str) == -1 : p(str).equals(str2);
    }

    public static boolean h(String str, String str2) {
        return a(str, str2, d.SENSITIVE);
    }

    public static boolean i(String str, String str2) {
        return a(str, str2, d.SYSTEM);
    }

    private static String a(String str, int i8) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        int iG = g(str);
        int i9 = i8 + iG;
        if (iF >= str.length() || iG < 0 || iF >= i9) {
            return "";
        }
        String strSubstring = str.substring(iF, i9);
        s(strSubstring);
        return strSubstring;
    }

    public static boolean b(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (str2 == null) {
            return false;
        }
        d dVar = d.SYSTEM;
        if (dVar.b(str, str2)) {
            return false;
        }
        return dVar.c(str2, str);
    }

    public static boolean c(String str, String str2) {
        return a(str, str2, false, d.SENSITIVE);
    }

    public static String a(String str, String str2) {
        StringBuilder sb;
        int iF = f(str2);
        if (iF < 0) {
            return null;
        }
        if (iF > 0) {
            return a(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return a(str2);
        }
        if (a(str.charAt(length - 1))) {
            sb = new StringBuilder();
            sb.append(str);
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(f14115d);
        }
        sb.append(str2);
        return a(sb.toString());
    }

    public static String a(String str, boolean z7) {
        return a(str, z7 ? f14115d : f14116e, true);
    }

    public static boolean a() {
        return f14117f == '\\';
    }

    private static boolean a(char c8) {
        return c8 == '/' || c8 == '\\';
    }

    public static boolean a(String str, String str2, d dVar) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (dVar == null) {
                dVar = d.SENSITIVE;
            }
            String[] strArrR = r(str2);
            Stack stack = new Stack();
            boolean z7 = false;
            int length = 0;
            int i8 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i8 = iArr[0];
                    length = iArr[1];
                    z7 = true;
                }
                while (i8 < strArrR.length) {
                    if (strArrR[i8].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z7 = false;
                        i8++;
                    } else if (strArrR[i8].equals("*")) {
                        if (i8 == strArrR.length - 1) {
                            length = str.length();
                        }
                        z7 = true;
                        i8++;
                    } else {
                        if (z7) {
                            length = dVar.a(str, length, strArrR[i8]);
                            if (length == -1) {
                                break;
                            }
                            int iA = dVar.a(str, length + 1, strArrR[i8]);
                            if (iA >= 0) {
                                stack.push(new int[]{i8, iA});
                            }
                            length += strArrR[i8].length();
                            z7 = false;
                        } else {
                            if (!dVar.b(str, length, strArrR[i8])) {
                                break;
                            }
                            length += strArrR[i8].length();
                            z7 = false;
                        }
                        i8++;
                    }
                }
                if (i8 == strArrR.length && length == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }

    public static boolean a(String str, String str2, boolean z7, d dVar) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z7) {
            str = a(str);
            str2 = a(str2);
            if (str == null || str2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (dVar == null) {
            dVar = d.SENSITIVE;
        }
        return dVar.b(str, str2);
    }

    public static boolean a(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        s(str);
        if (collection == null || collection.isEmpty()) {
            return h(str) == -1;
        }
        String strP = p(str);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (strP.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, String[] strArr) {
        if (str == null) {
            return false;
        }
        s(str);
        if (strArr == null || strArr.length == 0) {
            return h(str) == -1;
        }
        String strP = p(str);
        for (String str2 : strArr) {
            if (strP.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
