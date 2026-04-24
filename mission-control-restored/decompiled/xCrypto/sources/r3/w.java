package r3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends v {
    public static final Void l(String input) {
        kotlin.jvm.internal.r.f(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer m(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return n(str, 10);
    }

    public static final Integer n(String str, int i4) {
        boolean z4;
        int i5;
        int i6;
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC1754a.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char cCharAt = str.charAt(0);
        int i8 = -2147483647;
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            i5 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z4 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i8 = Integer.MIN_VALUE;
                z4 = true;
            }
        } else {
            z4 = false;
            i5 = 0;
        }
        int i9 = -59652323;
        while (i5 < length) {
            int iB = AbstractC1754a.b(str.charAt(i5), i4);
            if (iB < 0) {
                return null;
            }
            if ((i7 < i9 && (i9 != -59652323 || i7 < (i9 = i8 / i4))) || (i6 = i7 * i4) < i8 + iB) {
                return null;
            }
            i7 = i6 - iB;
            i5++;
        }
        return z4 ? Integer.valueOf(i7) : Integer.valueOf(-i7);
    }

    public static Long o(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return p(str, 10);
    }

    public static final Long p(String str, int i4) {
        boolean z4;
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC1754a.a(i4);
        int length = str.length();
        Long l4 = null;
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char cCharAt = str.charAt(0);
        long j4 = -9223372036854775807L;
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            z4 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z4 = false;
                i5 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j4 = Long.MIN_VALUE;
                i5 = 1;
            }
        } else {
            z4 = false;
        }
        long j5 = 0;
        long j6 = -256204778801521550L;
        while (i5 < length) {
            int iB = AbstractC1754a.b(str.charAt(i5), i4);
            if (iB < 0) {
                return l4;
            }
            if (j5 < j6) {
                if (j6 != -256204778801521550L) {
                    return l4;
                }
                j6 = j4 / ((long) i4);
                if (j5 < j6) {
                    return l4;
                }
            }
            Long l5 = l4;
            int i6 = i5;
            long j7 = j5 * ((long) i4);
            long j8 = iB;
            if (j7 < j4 + j8) {
                return l5;
            }
            j5 = j7 - j8;
            i5 = i6 + 1;
            l4 = l5;
        }
        return z4 ? Long.valueOf(j5) : Long.valueOf(-j5);
    }
}
