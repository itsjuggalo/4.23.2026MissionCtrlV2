package G4;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import y2.AbstractC2977b;

/* JADX INFO: renamed from: G4.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0521c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f2748a = TimeUnit.SECONDS.toNanos(1);

    public static List a(List list) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            if (!(list.get(i8) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i8), Integer.valueOf(i8), list));
            }
        }
        return list;
    }

    public static List b(List list) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            if (!(list.get(i8) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i8), Integer.valueOf(i8), list));
            }
        }
        return list;
    }

    public static boolean c(long j8, int i8) {
        if (j8 >= -315576000000L && j8 <= 315576000000L) {
            long j9 = i8;
            if (j9 >= -999999999 && j9 < f2748a) {
                if (j8 >= 0 && i8 >= 0) {
                    return true;
                }
                if (j8 <= 0 && i8 <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean d(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    public static List e(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    public static List f(Map map, String str) {
        List listE = e(map, str);
        if (listE == null) {
            return null;
        }
        return a(listE);
    }

    public static List g(Map map, String str) {
        List listE = e(map, str);
        if (listE == null) {
            return null;
        }
        return b(listE);
    }

    public static Double h(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
        }
    }

    public static Integer i(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        Double d8 = (Double) obj;
        int iIntValue = d8.intValue();
        if (iIntValue == d8.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d8);
    }

    public static Map j(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    public static String k(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long l(Map map, String str) {
        String strK = k(map, str);
        if (strK == null) {
            return null;
        }
        try {
            return Long.valueOf(n(strK));
        } catch (ParseException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static long m(long j8, int i8) {
        long j9 = i8;
        long j10 = f2748a;
        if (j9 <= (-j10) || j9 >= j10) {
            j8 = AbstractC2977b.a(j8, j9 / j10);
            i8 = (int) (j9 % j10);
        }
        if (j8 > 0 && i8 < 0) {
            i8 = (int) (((long) i8) + j10);
            j8--;
        }
        if (j8 < 0 && i8 > 0) {
            i8 = (int) (((long) i8) - j10);
            j8++;
        }
        if (c(j8, i8)) {
            return p(TimeUnit.SECONDS.toNanos(j8), i8);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j8), Integer.valueOf(i8)));
    }

    public static long n(String str) throws ParseException {
        boolean z7;
        String strSubstring;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z7 = true;
        } else {
            z7 = false;
        }
        String strSubstring2 = str.substring(0, str.length() - 1);
        int iIndexOf = strSubstring2.indexOf(46);
        if (iIndexOf != -1) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        long j8 = Long.parseLong(strSubstring2);
        int iO = strSubstring.isEmpty() ? 0 : o(strSubstring);
        if (j8 < 0) {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (z7) {
            j8 = -j8;
            iO = -iO;
        }
        try {
            return m(j8, iO);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    public static int o(String str) throws ParseException {
        int iCharAt = 0;
        for (int i8 = 0; i8 < 9; i8++) {
            iCharAt *= 10;
            if (i8 < str.length()) {
                if (str.charAt(i8) < '0' || str.charAt(i8) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt += str.charAt(i8) - '0';
            }
        }
        return iCharAt;
    }

    public static long p(long j8, long j9) {
        long j10 = j8 + j9;
        return (((j9 ^ j8) > 0L ? 1 : ((j9 ^ j8) == 0L ? 0 : -1)) < 0) | ((j8 ^ j10) >= 0) ? j10 : ((j10 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
