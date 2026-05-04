package com.amazon.a.a.o.c.a;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4612c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f4613d = '/';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f4614e = '\\';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f4616g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f4610a = '.';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4611b = Character.toString(f4610a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f4615f = File.separatorChar;

    static {
        if (a()) {
            f4616g = f4613d;
        } else {
            f4616g = f4614e;
        }
    }

    private static boolean a(char c10) {
        return c10 == '/' || c10 == '\\';
    }

    public static String b(String str) {
        return a(str, f4615f, false);
    }

    public static String c(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace(f4614e, f4613d);
    }

    public static String d(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace(f4613d, f4614e);
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
        s(str + f4613d);
        return str + f4613d;
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
        StringBuilder sb2 = new StringBuilder();
        int length = charArray.length;
        int i10 = 0;
        char c10 = 0;
        while (i10 < length) {
            char c11 = charArray[i10];
            if (c11 == '?' || c11 == '*') {
                if (sb2.length() != 0) {
                    arrayList.add(sb2.toString());
                    sb2.setLength(0);
                }
                if (c11 == '?') {
                    arrayList.add("?");
                } else if (c10 != '*') {
                    arrayList.add("*");
                }
            } else {
                sb2.append(c11);
            }
            i10++;
            c10 = c11;
        }
        if (sb2.length() != 0) {
            arrayList.add(sb2.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void s(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static boolean a() {
        return f4615f == '\\';
    }

    public static String b(String str, boolean z10) {
        return a(str, z10 ? f4613d : f4614e, false);
    }

    public static String a(String str) {
        return a(str, f4615f, true);
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

    private static String c(String str, boolean z10) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        if (iF >= str.length()) {
            return z10 ? i(str) : str;
        }
        int iG = g(str);
        if (iG < 0) {
            return str.substring(0, iF);
        }
        int i10 = iG + (z10 ? 1 : 0);
        if (i10 == 0) {
            i10++;
        }
        return str.substring(0, i10);
    }

    public static boolean d(String str, String str2) {
        return a(str, str2, false, d.SYSTEM);
    }

    public static boolean h(String str, String str2) {
        return a(str, str2, d.SENSITIVE);
    }

    public static String a(String str, boolean z10) {
        return a(str, z10 ? f4613d : f4614e, true);
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

    private static String a(String str, char c10, boolean z10) {
        boolean z11;
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
        int i10 = length + 2;
        char[] cArr = new char[i10];
        str.getChars(0, str.length(), cArr, 0);
        char c11 = f4615f;
        if (c10 == c11) {
            c11 = f4616g;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (cArr[i11] == c11) {
                cArr[i11] = c10;
            }
        }
        if (cArr[length - 1] != c10) {
            cArr[length] = c10;
            length++;
            z11 = false;
        } else {
            z11 = true;
        }
        int i12 = iF + 1;
        int i13 = i12;
        while (i13 < length) {
            if (cArr[i13] == c10) {
                int i14 = i13 - 1;
                if (cArr[i14] == c10) {
                    System.arraycopy(cArr, i13, cArr, i14, length - i13);
                    length--;
                    i13--;
                }
            }
            i13++;
        }
        int i15 = i12;
        while (i15 < length) {
            if (cArr[i15] == c10) {
                int i16 = i15 - 1;
                if (cArr[i16] == '.' && (i15 == i12 || cArr[i15 - 2] == c10)) {
                    if (i15 == length - 1) {
                        z11 = true;
                    }
                    System.arraycopy(cArr, i15 + 1, cArr, i16, length - i15);
                    length -= 2;
                    i15--;
                }
            }
            i15++;
        }
        int i17 = iF + 2;
        int i18 = i17;
        while (i18 < length) {
            if (cArr[i18] == c10 && cArr[i18 - 1] == '.' && cArr[i18 - 2] == '.' && (i18 == i17 || cArr[i18 - 3] == c10)) {
                if (i18 == i17) {
                    return null;
                }
                if (i18 == length - 1) {
                    z11 = true;
                }
                int i19 = i18 - 4;
                while (true) {
                    if (i19 >= iF) {
                        if (cArr[i19] == c10) {
                            int i20 = i19 + 1;
                            System.arraycopy(cArr, i18 + 1, cArr, i20, length - i18);
                            length -= i18 - i19;
                            i18 = i20;
                            break;
                        }
                        i19--;
                    } else {
                        int i21 = i18 + 1;
                        System.arraycopy(cArr, i21, cArr, iF, length - i18);
                        length -= i21 - iF;
                        i18 = i12;
                        break;
                    }
                }
            }
            i18++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= iF) {
            return new String(cArr, 0, length);
        }
        if (z11 && z10) {
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
        return a(str + f4613d + str2);
    }

    private static String a(String str, int i10) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        int iG = g(str);
        int i11 = i10 + iG;
        if (iF < str.length() && iG >= 0 && iF < i11) {
            String strSubstring = str.substring(iF, i11);
            s(strSubstring);
            return strSubstring;
        }
        return "";
    }

    public static boolean a(String str, String str2, boolean z10, d dVar) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z10) {
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
            boolean z10 = false;
            int length = 0;
            int i10 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i10 = iArr[0];
                    length = iArr[1];
                    z10 = true;
                }
                while (i10 < strArrR.length) {
                    if (strArrR[i10].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z10 = false;
                        i10++;
                    } else if (strArrR[i10].equals("*")) {
                        if (i10 == strArrR.length - 1) {
                            length = str.length();
                        }
                        z10 = true;
                        i10++;
                    } else {
                        if (z10) {
                            length = dVar.a(str, length, strArrR[i10]);
                            if (length == -1) {
                                break;
                            }
                            int iA = dVar.a(str, length + 1, strArrR[i10]);
                            if (iA >= 0) {
                                stack.push(new int[]{i10, iA});
                            }
                            length += strArrR[i10].length();
                            z10 = false;
                        } else {
                            if (!dVar.b(str, length, strArrR[i10])) {
                                break;
                            }
                            length += strArrR[i10].length();
                            z10 = false;
                        }
                        i10++;
                    }
                }
                if (i10 == strArrR.length && length == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }
}
