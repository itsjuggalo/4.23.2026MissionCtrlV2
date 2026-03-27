package V6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends y {
    public static final Void m(String input) {
        AbstractC2304t.f(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer n(String str) {
        AbstractC2304t.f(str, "<this>");
        return o(str, 10);
    }

    public static final Integer o(String str, int i8) {
        boolean z7;
        int i9;
        int i10;
        AbstractC2304t.f(str, "<this>");
        AbstractC0975a.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        int i12 = -2147483647;
        if (AbstractC2304t.g(cCharAt, 48) < 0) {
            i9 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z7 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i12 = Integer.MIN_VALUE;
                z7 = true;
            }
        } else {
            z7 = false;
            i9 = 0;
        }
        int i13 = -59652323;
        while (i9 < length) {
            int iB = AbstractC0975a.b(str.charAt(i9), i8);
            if (iB < 0) {
                return null;
            }
            if ((i11 < i13 && (i13 != -59652323 || i11 < (i13 = i12 / i8))) || (i10 = i11 * i8) < i12 + iB) {
                return null;
            }
            i11 = i10 - iB;
            i9++;
        }
        return z7 ? Integer.valueOf(i11) : Integer.valueOf(-i11);
    }

    public static Long p(String str) {
        AbstractC2304t.f(str, "<this>");
        return q(str, 10);
    }

    public static final Long q(String str, int i8) {
        boolean z7;
        AbstractC2304t.f(str, "<this>");
        AbstractC0975a.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        long j8 = -9223372036854775807L;
        if (AbstractC2304t.g(cCharAt, 48) < 0) {
            z7 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z7 = false;
                i9 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j8 = Long.MIN_VALUE;
                i9 = 1;
            }
        } else {
            z7 = false;
        }
        long j9 = -256204778801521550L;
        long j10 = 0;
        long j11 = -256204778801521550L;
        while (i9 < length) {
            int iB = AbstractC0975a.b(str.charAt(i9), i8);
            if (iB < 0) {
                return null;
            }
            if (j10 < j11) {
                if (j11 == j9) {
                    j11 = j8 / ((long) i8);
                    if (j10 < j11) {
                    }
                }
                return null;
            }
            long j12 = j10 * ((long) i8);
            long j13 = iB;
            if (j12 < j8 + j13) {
                return null;
            }
            j10 = j12 - j13;
            i9++;
            j9 = -256204778801521550L;
        }
        return z7 ? Long.valueOf(j10) : Long.valueOf(-j10);
    }
}
