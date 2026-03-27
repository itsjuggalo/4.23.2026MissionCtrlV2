package Z5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends r {
    public static final Void h(String input) {
        kotlin.jvm.internal.r.f(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer i(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return j(str, 10);
    }

    public static final Integer j(String str, int i7) {
        boolean z7;
        int i8;
        int i9;
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC0794a.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        int i11 = -2147483647;
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i11 = Integer.MIN_VALUE;
                z7 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z7 = false;
            }
        } else {
            z7 = false;
            i8 = 0;
        }
        int i12 = -59652323;
        while (i8 < length) {
            int iB = AbstractC0794a.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if ((i10 < i12 && (i12 != -59652323 || i10 < (i12 = i11 / i7))) || (i9 = i10 * i7) < i11 + iB) {
                return null;
            }
            i10 = i9 - iB;
            i8++;
        }
        return z7 ? Integer.valueOf(i10) : Integer.valueOf(-i10);
    }

    public static Long k(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return l(str, 10);
    }

    public static final Long l(String str, int i7) {
        boolean z7;
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC0794a.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        long j7 = -9223372036854775807L;
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            z7 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j7 = Long.MIN_VALUE;
                i8 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z7 = false;
                i8 = 1;
            }
        } else {
            z7 = false;
        }
        long j8 = -256204778801521550L;
        long j9 = 0;
        long j10 = -256204778801521550L;
        while (i8 < length) {
            int iB = AbstractC0794a.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if (j9 < j10) {
                if (j10 == j8) {
                    j10 = j7 / ((long) i7);
                    if (j9 < j10) {
                    }
                }
                return null;
            }
            long j11 = j9 * ((long) i7);
            long j12 = iB;
            if (j11 < j7 + j12) {
                return null;
            }
            j9 = j11 - j12;
            i8++;
            j8 = -256204778801521550L;
        }
        return z7 ? Long.valueOf(j9) : Long.valueOf(-j9);
    }
}
