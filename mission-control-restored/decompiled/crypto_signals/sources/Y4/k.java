package Y4;

import a.AbstractC0284a;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j {
    public static Integer P(String str) {
        boolean z6;
        int i;
        int i6;
        kotlin.jvm.internal.j.e(str, "<this>");
        AbstractC0284a.b(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char cCharAt = str.charAt(0);
        int i8 = -2147483647;
        if (kotlin.jvm.internal.j.f(cCharAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z6 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i8 = Integer.MIN_VALUE;
                z6 = true;
            }
        } else {
            z6 = false;
            i = 0;
        }
        int i9 = -59652323;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i7 < i9 && (i9 != -59652323 || i7 < (i9 = i8 / 10))) || (i6 = i7 * 10) < i8 + iDigit) {
                return null;
            }
            i7 = i6 - iDigit;
            i++;
        }
        return z6 ? Integer.valueOf(i7) : Integer.valueOf(-i7);
    }
}
