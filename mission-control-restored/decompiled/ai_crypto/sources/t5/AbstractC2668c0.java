package t5;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: t5.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2668c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f23711a = TimeUnit.SECONDS.toNanos(1);

    public static List a(List list) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!(list.get(i7) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i7), Integer.valueOf(i7), list));
            }
        }
        return list;
    }

    public static List b(List list) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!(list.get(i7) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i7), Integer.valueOf(i7), list));
            }
        }
        return list;
    }

    public static boolean c(long j7, int i7) {
        if (j7 >= -315576000000L && j7 <= 315576000000L) {
            long j8 = i7;
            if (j8 >= -999999999 && j8 < f23711a) {
                if (j7 >= 0 && i7 >= 0) {
                    return true;
                }
                if (j7 <= 0 && i7 <= 0) {
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
        Double d7 = (Double) obj;
        int iIntValue = d7.intValue();
        if (iIntValue == d7.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d7);
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
        } catch (ParseException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static long m(long j7, int i7) {
        long j8 = i7;
        long j9 = f23711a;
        if (j8 <= (-j9) || j8 >= j9) {
            j7 = K2.b.a(j7, j8 / j9);
            i7 = (int) (j8 % j9);
        }
        if (j7 > 0 && i7 < 0) {
            i7 = (int) (((long) i7) + j9);
            j7--;
        }
        if (j7 < 0 && i7 > 0) {
            i7 = (int) (((long) i7) - j9);
            j7++;
        }
        if (c(j7, i7)) {
            return p(TimeUnit.SECONDS.toNanos(j7), i7);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j7), Integer.valueOf(i7)));
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
        long j7 = Long.parseLong(strSubstring2);
        int iO = strSubstring.isEmpty() ? 0 : o(strSubstring);
        if (j7 < 0) {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (z7) {
            j7 = -j7;
            iO = -iO;
        }
        try {
            return m(j7, iO);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    public static int o(String str) throws ParseException {
        int iCharAt = 0;
        for (int i7 = 0; i7 < 9; i7++) {
            iCharAt *= 10;
            if (i7 < str.length()) {
                if (str.charAt(i7) < '0' || str.charAt(i7) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt += str.charAt(i7) - '0';
            }
        }
        return iCharAt;
    }

    public static long p(long j7, long j8) {
        long j9 = j7 + j8;
        return (((j8 ^ j7) > 0L ? 1 : ((j8 ^ j7) == 0L ? 0 : -1)) < 0) | ((j7 ^ j9) >= 0) ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
