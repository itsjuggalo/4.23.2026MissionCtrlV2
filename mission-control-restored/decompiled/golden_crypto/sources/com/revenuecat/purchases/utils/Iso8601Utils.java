package com.revenuecat.purchases.utils;

import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Iso8601Utils {
    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_Z = DesugarTimeZone.getTimeZone(GMT_ID);

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0190, IndexOutOfBoundsException -> 0x0192, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0190, blocks: (B:3:0x000a, B:6:0x0017, B:8:0x0023, B:9:0x0025, B:11:0x0034, B:13:0x003a, B:17:0x004b, B:19:0x005b, B:20:0x005d, B:22:0x0069, B:23:0x006c, B:25:0x0072, B:29:0x007c, B:34:0x008c, B:36:0x0094, B:41:0x00c9, B:43:0x00cf, B:45:0x00d7, B:66:0x0159, B:50:0x00e2, B:51:0x00f8, B:52:0x00f9, B:54:0x0105, B:57:0x010e, B:59:0x0128, B:62:0x0137, B:63:0x0154, B:65:0x0157, B:68:0x0188, B:69:0x018f), top: B:75:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0188 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0190, IndexOutOfBoundsException -> 0x0192, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0190, blocks: (B:3:0x000a, B:6:0x0017, B:8:0x0023, B:9:0x0025, B:11:0x0034, B:13:0x003a, B:17:0x004b, B:19:0x005b, B:20:0x005d, B:22:0x0069, B:23:0x006c, B:25:0x0072, B:29:0x007c, B:34:0x008c, B:36:0x0094, B:41:0x00c9, B:43:0x00cf, B:45:0x00d7, B:66:0x0159, B:50:0x00e2, B:51:0x00f8, B:52:0x00f9, B:54:0x0105, B:57:0x010e, B:59:0x0128, B:62:0x0137, B:63:0x0154, B:65:0x0157, B:68:0x0188, B:69:0x018f), top: B:75:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.utils.Iso8601Utils.parse(java.lang.String):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
