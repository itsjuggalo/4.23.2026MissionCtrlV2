package u2;

import com.amazon.a.a.o.c.a.b;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: renamed from: u2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1868a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f15100a = DesugarTimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i4, char c4) {
        return i4 < str.length() && str.charAt(i4) == c4;
    }

    public static String b(Date date) {
        return c(date, false, f15100a);
    }

    public static String c(Date date, boolean z4, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z4 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        e(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        e(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        e(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        e(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        e(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        e(sb, gregorianCalendar.get(13), 2);
        if (z4) {
            sb.append(b.f8816a);
            e(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i4 = offset / 60000;
            int iAbs = Math.abs(i4 / 60);
            int iAbs2 = Math.abs(i4 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            e(sb, iAbs, 2);
            sb.append(':');
            e(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    public static int d(String str, int i4) {
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < '0' || cCharAt > '9') {
                return i4;
            }
            i4++;
        }
        return str.length();
    }

    public static void e(StringBuilder sb, int i4, int i5) {
        String string = Integer.toString(i4);
        for (int length = i5 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00df A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:21:0x005b, B:23:0x006b, B:24:0x006d, B:26:0x0079, B:27:0x007c, B:29:0x0082, B:33:0x008c, B:38:0x009c, B:40:0x00a4, B:51:0x00d9, B:53:0x00df, B:55:0x00e5, B:79:0x0192, B:59:0x00ef, B:60:0x010a, B:61:0x010b, B:65:0x0127, B:67:0x0134, B:70:0x013d, B:72:0x015c, B:75:0x016b, B:76:0x018d, B:78:0x0190, B:64:0x0116, B:81:0x01c3, B:82:0x01ca, B:44:0x00bc, B:45:0x00bf), top: B:93:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c3 A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:21:0x005b, B:23:0x006b, B:24:0x006d, B:26:0x0079, B:27:0x007c, B:29:0x0082, B:33:0x008c, B:38:0x009c, B:40:0x00a4, B:51:0x00d9, B:53:0x00df, B:55:0x00e5, B:79:0x0192, B:59:0x00ef, B:60:0x010a, B:61:0x010b, B:65:0x0127, B:67:0x0134, B:70:0x013d, B:72:0x015c, B:75:0x016b, B:76:0x018d, B:78:0x0190, B:64:0x0116, B:81:0x01c3, B:82:0x01ca, B:44:0x00bc, B:45:0x00bf), top: B:93:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date f(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.AbstractC1868a.f(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int g(String str, int i4, int i5) {
        int i6;
        int i7;
        if (i4 < 0 || i5 > str.length() || i4 > i5) {
            throw new NumberFormatException(str);
        }
        if (i4 < i5) {
            i7 = i4 + 1;
            int iDigit = Character.digit(str.charAt(i4), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i4, i5));
            }
            i6 = -iDigit;
        } else {
            i6 = 0;
            i7 = i4;
        }
        while (i7 < i5) {
            int i8 = i7 + 1;
            int iDigit2 = Character.digit(str.charAt(i7), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i4, i5));
            }
            i6 = (i6 * 10) - iDigit2;
            i7 = i8;
        }
        return -i6;
    }
}
