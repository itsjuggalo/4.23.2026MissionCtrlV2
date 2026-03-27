package p4;

import com.amazon.a.a.o.c.a.b;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: renamed from: p4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2376a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f21539a = DesugarTimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i7, char c7) {
        return i7 < str.length() && str.charAt(i7) == c7;
    }

    public static String b(Date date) {
        return c(date, false, f21539a);
    }

    public static String c(Date date, boolean z7, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z7 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
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
        if (z7) {
            sb.append(b.f10001a);
            e(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i7 = offset / 60000;
            int iAbs = Math.abs(i7 / 60);
            int iAbs2 = Math.abs(i7 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            e(sb, iAbs, 2);
            sb.append(':');
            e(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    public static int d(String str, int i7) {
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < '0' || cCharAt > '9') {
                return i7;
            }
            i7++;
        }
        return str.length();
    }

    public static void e(StringBuilder sb, int i7, int i8) {
        String string = Integer.toString(i7);
        for (int length = i8 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date f(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.AbstractC2376a.f(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int g(String str, int i7, int i8) {
        int i9;
        int i10;
        if (i7 < 0 || i8 > str.length() || i7 > i8) {
            throw new NumberFormatException(str);
        }
        if (i7 < i8) {
            i10 = i7 + 1;
            int iDigit = Character.digit(str.charAt(i7), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = -iDigit;
        } else {
            i9 = 0;
            i10 = i7;
        }
        while (i10 < i8) {
            int i11 = i10 + 1;
            int iDigit2 = Character.digit(str.charAt(i10), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = (i9 * 10) - iDigit2;
            i10 = i11;
        }
        return -i9;
    }
}
