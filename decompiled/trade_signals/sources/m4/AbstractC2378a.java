package m4;

import com.amazon.a.a.o.c.a.b;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: renamed from: m4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2378a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f21458a = DesugarTimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i8, char c8) {
        return i8 < str.length() && str.charAt(i8) == c8;
    }

    public static String b(Date date) {
        return c(date, false, f21458a);
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
            sb.append(b.f14112a);
            e(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i8 = offset / 60000;
            int iAbs = Math.abs(i8 / 60);
            int iAbs2 = Math.abs(i8 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            e(sb, iAbs, 2);
            sb.append(':');
            e(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    public static int d(String str, int i8) {
        while (i8 < str.length()) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < '0' || cCharAt > '9') {
                return i8;
            }
            i8++;
        }
        return str.length();
    }

    public static void e(StringBuilder sb, int i8, int i9) {
        String string = Integer.toString(i8);
        for (int length = i9 - string.length(); length > 0; length--) {
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
        throw new UnsupportedOperationException("Method not decompiled: m4.AbstractC2378a.f(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int g(String str, int i8, int i9) {
        int i10;
        int i11;
        if (i8 < 0 || i9 > str.length() || i8 > i9) {
            throw new NumberFormatException(str);
        }
        if (i8 < i9) {
            i11 = i8 + 1;
            int iDigit = Character.digit(str.charAt(i8), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i8, i9));
            }
            i10 = -iDigit;
        } else {
            i10 = 0;
            i11 = i8;
        }
        while (i11 < i9) {
            int i12 = i11 + 1;
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i8, i9));
            }
            i10 = (i10 * 10) - iDigit2;
            i11 = i12;
        }
        return -i10;
    }
}
