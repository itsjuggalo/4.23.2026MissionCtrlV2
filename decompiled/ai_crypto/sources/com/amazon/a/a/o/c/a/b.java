package com.amazon.a.a.o.c.a;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10003c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f10004d = '/';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f10005e = '\\';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f10007g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f10001a = '.';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10002b = Character.toString(f10001a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f10006f = File.separatorChar;

    static {
        if (a()) {
            f10007g = f10004d;
        } else {
            f10007g = f10005e;
        }
    }

    private static boolean a(char c7) {
        return c7 == '/' || c7 == '\\';
    }

    public static String b(String str) {
        return a(str, f10006f, false);
    }

    public static String c(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace(f10005e, f10004d);
    }

    public static String d(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace(f10004d, f10005e);
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
        s(str + f10004d);
        return str + f10004d;
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
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i7 = 0;
        char c7 = 0;
        while (i7 < length) {
            char c8 = charArray[i7];
            if (c8 == '?' || c8 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c8 == '?') {
                    arrayList.add("?");
                } else if (c7 != '*') {
                    arrayList.add("*");
                }
            } else {
                sb.append(c8);
            }
            i7++;
            c7 = c8;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void s(String str) {
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (str.charAt(i7) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static boolean a() {
        return f10006f == '\\';
    }

    public static String b(String str, boolean z7) {
        return a(str, z7 ? f10004d : f10005e, false);
    }

    public static String a(String str) {
        return a(str, f10006f, true);
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
        int i7 = iG + (z7 ? 1 : 0);
        if (i7 == 0) {
            i7++;
        }
        return str.substring(0, i7);
    }

    public static boolean d(String str, String str2) {
        return a(str, str2, false, d.SYSTEM);
    }

    public static boolean h(String str, String str2) {
        return a(str, str2, d.SENSITIVE);
    }

    public static String a(String str, boolean z7) {
        return a(str, z7 ? f10004d : f10005e, true);
    }

    public static boolean e(String str, String str2) {
        return a(str, str2, true, d.SENSITIVE);
    }

    public static boolean g(String str, String str2) {
        if (str == null) {
            return false;
        }
        s(str);
        if (str2 == null || str2.isEmpty()) {
            return h(str) == -1;
        }
        return p(str).equals(str2);
    }

    private static String a(String str, char c7, boolean z7) {
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
        int i7 = length + 2;
        char[] cArr = new char[i7];
        str.getChars(0, str.length(), cArr, 0);
        char c8 = f10006f;
        if (c7 == c8) {
            c8 = f10007g;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (cArr[i8] == c8) {
                cArr[i8] = c7;
            }
        }
        if (cArr[length - 1] != c7) {
            cArr[length] = c7;
            length++;
            z8 = false;
        } else {
            z8 = true;
        }
        int i9 = iF + 1;
        int i10 = i9;
        while (i10 < length) {
            if (cArr[i10] == c7) {
                int i11 = i10 - 1;
                if (cArr[i11] == c7) {
                    System.arraycopy(cArr, i10, cArr, i11, length - i10);
                    length--;
                    i10--;
                }
            }
            i10++;
        }
        int i12 = i9;
        while (i12 < length) {
            if (cArr[i12] == c7) {
                int i13 = i12 - 1;
                if (cArr[i13] == '.' && (i12 == i9 || cArr[i12 - 2] == c7)) {
                    if (i12 == length - 1) {
                        z8 = true;
                    }
                    System.arraycopy(cArr, i12 + 1, cArr, i13, length - i12);
                    length -= 2;
                    i12--;
                }
            }
            i12++;
        }
        int i14 = iF + 2;
        int i15 = i14;
        while (i15 < length) {
            if (cArr[i15] == c7 && cArr[i15 - 1] == '.' && cArr[i15 - 2] == '.' && (i15 == i14 || cArr[i15 - 3] == c7)) {
                if (i15 == i14) {
                    return null;
                }
                if (i15 == length - 1) {
                    z8 = true;
                }
                int i16 = i15 - 4;
                while (true) {
                    if (i16 >= iF) {
                        if (cArr[i16] == c7) {
                            int i17 = i16 + 1;
                            System.arraycopy(cArr, i15 + 1, cArr, i17, length - i15);
                            length -= i15 - i16;
                            i15 = i17;
                            break;
                        }
                        i16--;
                    } else {
                        int i18 = i15 + 1;
                        System.arraycopy(cArr, i18, cArr, iF, length - i15);
                        length -= i18 - iF;
                        i15 = i9;
                        break;
                    }
                }
            }
            i15++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= iF) {
            return new String(cArr, 0, length);
        }
        if (z8 && z7) {
            return new String(cArr, 0, length);
        }
        return new String(cArr, 0, length - 1);
    }

    public static boolean i(String str, String str2) {
        return a(str, str2, d.SYSTEM);
    }

    public static boolean c(String str, String str2) {
        return a(str, str2, false, d.SENSITIVE);
    }

    public static boolean f(String str, String str2) {
        return a(str, str2, true, d.SYSTEM);
    }

    public static String a(String str, String str2) {
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
            return a(str + str2);
        }
        return a(str + f10004d + str2);
    }

    private static String a(String str, int i7) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        int iG = g(str);
        int i8 = i7 + iG;
        if (iF < str.length() && iG >= 0 && iF < i8) {
            String strSubstring = str.substring(iF, i8);
            s(strSubstring);
            return strSubstring;
        }
        return "";
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
            int i7 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i7 = iArr[0];
                    length = iArr[1];
                    z7 = true;
                }
                while (i7 < strArrR.length) {
                    if (strArrR[i7].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z7 = false;
                        i7++;
                    } else if (strArrR[i7].equals("*")) {
                        if (i7 == strArrR.length - 1) {
                            length = str.length();
                        }
                        z7 = true;
                        i7++;
                    } else {
                        if (z7) {
                            length = dVar.a(str, length, strArrR[i7]);
                            if (length == -1) {
                                break;
                            }
                            int iA = dVar.a(str, length + 1, strArrR[i7]);
                            if (iA >= 0) {
                                stack.push(new int[]{i7, iA});
                            }
                            length += strArrR[i7].length();
                            z7 = false;
                        } else {
                            if (!dVar.b(str, length, strArrR[i7])) {
                                break;
                            }
                            length += strArrR[i7].length();
                            z7 = false;
                        }
                        i7++;
                    }
                }
                if (i7 == strArrR.length && length == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }
}
