package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.common.Constants;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class Iso8601Utils {
    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_Z = DesugarTimeZone.getTimeZone(GMT_ID);

    private static boolean checkOffset(String str, int i4, char c4) {
        return i4 < str.length() && str.charAt(i4) == c4;
    }

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
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append(com.amazon.a.a.o.c.a.b.f8816a);
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i4) {
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < '0' || cCharAt > '9') {
                return i4;
            }
            i4++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i4, int i5) {
        String string = Integer.toString(i4);
        for (int length = i5 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    public static Date parse(String str) {
        int i4;
        int i5;
        int iPow;
        int i6;
        int i7;
        TimeZone timeZone;
        char cCharAt;
        try {
            int i8 = parseInt(str, 0, 4);
            int i9 = checkOffset(str, 4, '-') ? 5 : 4;
            int i10 = i9 + 2;
            int i11 = parseInt(str, i9, i10);
            if (checkOffset(str, i10, '-')) {
                i10 = i9 + 3;
            }
            int i12 = i10 + 2;
            int i13 = parseInt(str, i10, i12);
            boolean zCheckOffset = checkOffset(str, i12, 'T');
            if (!zCheckOffset && str.length() <= i12) {
                return new GregorianCalendar(i8, i11 - 1, i13).getTime();
            }
            if (zCheckOffset) {
                int i14 = i10 + 5;
                int i15 = parseInt(str, i10 + 3, i14);
                if (checkOffset(str, i14, ':')) {
                    i14 = i10 + 6;
                }
                int i16 = i14 + 2;
                i7 = parseInt(str, i14, i16);
                if (checkOffset(str, i16, ':')) {
                    i16 = i14 + 3;
                }
                if (str.length() <= i16 || (cCharAt = str.charAt(i16)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i4 = i8;
                    i5 = i15;
                    i12 = i16;
                    iPow = 0;
                    i6 = 0;
                } else {
                    int i17 = i16 + 2;
                    i6 = parseInt(str, i16, i17);
                    if (i6 > 59 && i6 < 63) {
                        i6 = 59;
                    }
                    if (checkOffset(str, i17, com.amazon.a.a.o.c.a.b.f8816a)) {
                        int iIndexOfNonDigit = indexOfNonDigit(str, i16 + 4);
                        i4 = i8;
                        iPow = (int) (Math.pow(10.0d, 3 - (r5 - r9)) * ((double) parseInt(str, i16 + 3, Math.min(iIndexOfNonDigit, i16 + 6))));
                        i5 = i15;
                        i12 = iIndexOfNonDigit;
                    } else {
                        i4 = i8;
                        i5 = i15;
                        i12 = i17;
                        iPow = 0;
                    }
                }
            } else {
                i4 = i8;
                i5 = 0;
                iPow = 0;
                i6 = 0;
                i7 = 0;
            }
            if (str.length() <= i12) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 == 'Z') {
                timeZone = TIMEZONE_Z;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i12);
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = TIMEZONE_Z;
                } else {
                    String str2 = GMT_ID + strSubstring;
                    TimeZone timeZone2 = DesugarTimeZone.getTimeZone(str2);
                    String id = timeZone2.getID();
                    if (!id.equals(str2) && !id.replace(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "").equals(str2)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i11 - 1);
            gregorianCalendar.set(5, i13);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i6);
            gregorianCalendar.set(14, iPow);
            return gregorianCalendar.getTime();
        } catch (IllegalArgumentException e4) {
            e = e4;
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        } catch (IndexOutOfBoundsException e5) {
            e = e5;
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        }
    }

    private static int parseInt(String str, int i4, int i5) {
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
