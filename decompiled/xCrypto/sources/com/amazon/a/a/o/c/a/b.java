package com.amazon.a.a.o.c.a;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8818c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f8819d = '/';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f8820e = '\\';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f8822g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f8816a = '.';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8817b = Character.toString(f8816a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f8821f = File.separatorChar;

    static {
        if (a()) {
            f8822g = f8819d;
        } else {
            f8822g = f8820e;
        }
    }

    private static boolean a(char c4) {
        return c4 == '/' || c4 == '\\';
    }

    public static String b(String str) {
        return a(str, f8821f, false);
    }

    public static String c(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace(f8820e, f8819d);
    }

    public static String d(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace(f8819d, f8820e);
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
        s(str + f8819d);
        return str + f8819d;
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
        int i4 = 0;
        char c4 = 0;
        while (i4 < length) {
            char c5 = charArray[i4];
            if (c5 == '?' || c5 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c5 == '?') {
                    arrayList.add("?");
                } else if (c4 != '*') {
                    arrayList.add("*");
                }
            } else {
                sb.append(c5);
            }
            i4++;
            c4 = c5;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void s(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static boolean a() {
        return f8821f == '\\';
    }

    public static String b(String str, boolean z4) {
        return a(str, z4 ? f8819d : f8820e, false);
    }

    public static String a(String str) {
        return a(str, f8821f, true);
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

    private static String c(String str, boolean z4) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        if (iF >= str.length()) {
            return z4 ? i(str) : str;
        }
        int iG = g(str);
        if (iG < 0) {
            return str.substring(0, iF);
        }
        int i4 = iG + (z4 ? 1 : 0);
        if (i4 == 0) {
            i4++;
        }
        return str.substring(0, i4);
    }

    public static boolean d(String str, String str2) {
        return a(str, str2, false, d.SYSTEM);
    }

    public static boolean h(String str, String str2) {
        return a(str, str2, d.SENSITIVE);
    }

    public static String a(String str, boolean z4) {
        return a(str, z4 ? f8819d : f8820e, true);
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

    private static String a(String str, char c4, boolean z4) {
        boolean z5;
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
        int i4 = length + 2;
        char[] cArr = new char[i4];
        str.getChars(0, str.length(), cArr, 0);
        char c5 = f8821f;
        if (c4 == c5) {
            c5 = f8822g;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (cArr[i5] == c5) {
                cArr[i5] = c4;
            }
        }
        if (cArr[length - 1] != c4) {
            cArr[length] = c4;
            length++;
            z5 = false;
        } else {
            z5 = true;
        }
        int i6 = iF + 1;
        int i7 = i6;
        while (i7 < length) {
            if (cArr[i7] == c4) {
                int i8 = i7 - 1;
                if (cArr[i8] == c4) {
                    System.arraycopy(cArr, i7, cArr, i8, length - i7);
                    length--;
                    i7--;
                }
            }
            i7++;
        }
        int i9 = i6;
        while (i9 < length) {
            if (cArr[i9] == c4) {
                int i10 = i9 - 1;
                if (cArr[i10] == '.' && (i9 == i6 || cArr[i9 - 2] == c4)) {
                    if (i9 == length - 1) {
                        z5 = true;
                    }
                    System.arraycopy(cArr, i9 + 1, cArr, i10, length - i9);
                    length -= 2;
                    i9--;
                }
            }
            i9++;
        }
        int i11 = iF + 2;
        int i12 = i11;
        while (i12 < length) {
            if (cArr[i12] == c4 && cArr[i12 - 1] == '.' && cArr[i12 - 2] == '.' && (i12 == i11 || cArr[i12 - 3] == c4)) {
                if (i12 == i11) {
                    return null;
                }
                if (i12 == length - 1) {
                    z5 = true;
                }
                int i13 = i12 - 4;
                while (true) {
                    if (i13 >= iF) {
                        if (cArr[i13] == c4) {
                            int i14 = i13 + 1;
                            System.arraycopy(cArr, i12 + 1, cArr, i14, length - i12);
                            length -= i12 - i13;
                            i12 = i14;
                            break;
                        }
                        i13--;
                    } else {
                        int i15 = i12 + 1;
                        System.arraycopy(cArr, i15, cArr, iF, length - i12);
                        length -= i15 - iF;
                        i12 = i6;
                        break;
                    }
                }
            }
            i12++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= iF) {
            return new String(cArr, 0, length);
        }
        if (z5 && z4) {
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
        return a(str + f8819d + str2);
    }

    private static String a(String str, int i4) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        int iG = g(str);
        int i5 = i4 + iG;
        if (iF < str.length() && iG >= 0 && iF < i5) {
            String strSubstring = str.substring(iF, i5);
            s(strSubstring);
            return strSubstring;
        }
        return "";
    }

    public static boolean a(String str, String str2, boolean z4, d dVar) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z4) {
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
            boolean z4 = false;
            int length = 0;
            int i4 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i4 = iArr[0];
                    length = iArr[1];
                    z4 = true;
                }
                while (i4 < strArrR.length) {
                    if (strArrR[i4].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z4 = false;
                        i4++;
                    } else if (strArrR[i4].equals("*")) {
                        if (i4 == strArrR.length - 1) {
                            length = str.length();
                        }
                        z4 = true;
                        i4++;
                    } else {
                        if (z4) {
                            length = dVar.a(str, length, strArrR[i4]);
                            if (length == -1) {
                                break;
                            }
                            int iA = dVar.a(str, length + 1, strArrR[i4]);
                            if (iA >= 0) {
                                stack.push(new int[]{i4, iA});
                            }
                            length += strArrR[i4].length();
                            z4 = false;
                        } else {
                            if (!dVar.b(str, length, strArrR[i4])) {
                                break;
                            }
                            length += strArrR[i4].length();
                            z4 = false;
                        }
                        i4++;
                    }
                }
                if (i4 == strArrR.length && length == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }
}
