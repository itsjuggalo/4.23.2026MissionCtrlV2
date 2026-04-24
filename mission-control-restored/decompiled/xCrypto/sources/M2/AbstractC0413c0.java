package M2;

import c2.AbstractC0875b;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: M2.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0413c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f2160a = TimeUnit.SECONDS.toNanos(1);

    public static List a(List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!(list.get(i4) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i4), Integer.valueOf(i4), list));
            }
        }
        return list;
    }

    public static List b(List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!(list.get(i4) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i4), Integer.valueOf(i4), list));
            }
        }
        return list;
    }

    public static boolean c(long j4, int i4) {
        if (j4 >= -315576000000L && j4 <= 315576000000L) {
            long j5 = i4;
            if (j5 >= -999999999 && j5 < f2160a) {
                if (j4 >= 0 && i4 >= 0) {
                    return true;
                }
                if (j4 <= 0 && i4 <= 0) {
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
        Double d4 = (Double) obj;
        int iIntValue = d4.intValue();
        if (iIntValue == d4.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d4);
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
        } catch (ParseException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static long m(long j4, int i4) {
        long j5 = i4;
        long j6 = f2160a;
        if (j5 <= (-j6) || j5 >= j6) {
            j4 = AbstractC0875b.a(j4, j5 / j6);
            i4 = (int) (j5 % j6);
        }
        if (j4 > 0 && i4 < 0) {
            i4 = (int) (((long) i4) + j6);
            j4--;
        }
        if (j4 < 0 && i4 > 0) {
            i4 = (int) (((long) i4) - j6);
            j4++;
        }
        if (c(j4, i4)) {
            return p(TimeUnit.SECONDS.toNanos(j4), i4);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j4), Integer.valueOf(i4)));
    }

    public static long n(String str) throws ParseException {
        boolean z4;
        String strSubstring;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z4 = true;
        } else {
            z4 = false;
        }
        String strSubstring2 = str.substring(0, str.length() - 1);
        int iIndexOf = strSubstring2.indexOf(46);
        if (iIndexOf != -1) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        long j4 = Long.parseLong(strSubstring2);
        int iO = strSubstring.isEmpty() ? 0 : o(strSubstring);
        if (j4 < 0) {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (z4) {
            j4 = -j4;
            iO = -iO;
        }
        try {
            return m(j4, iO);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    public static int o(String str) throws ParseException {
        int iCharAt = 0;
        for (int i4 = 0; i4 < 9; i4++) {
            iCharAt *= 10;
            if (i4 < str.length()) {
                if (str.charAt(i4) < '0' || str.charAt(i4) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt += str.charAt(i4) - '0';
            }
        }
        return iCharAt;
    }

    public static long p(long j4, long j5) {
        long j6 = j4 + j5;
        return (((j5 ^ j4) > 0L ? 1 : ((j5 ^ j4) == 0L ? 0 : -1)) < 0) | ((j4 ^ j6) >= 0) ? j6 : ((j6 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
