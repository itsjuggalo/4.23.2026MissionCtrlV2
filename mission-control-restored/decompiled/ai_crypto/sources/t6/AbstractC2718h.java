package t6;

/* JADX INFO: renamed from: t6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC2718h {
    public static /* synthetic */ String a(long j7, int i7) {
        if (j7 == 0) {
            return "0";
        }
        if (j7 > 0) {
            return Long.toString(j7, i7);
        }
        if (i7 < 2 || i7 > 36) {
            i7 = 10;
        }
        int i8 = 64;
        char[] cArr = new char[64];
        int i9 = i7 - 1;
        if ((i7 & i9) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i7);
            do {
                i8--;
                cArr[i8] = Character.forDigit(((int) j7) & i9, i7);
                j7 >>>= iNumberOfTrailingZeros;
            } while (j7 != 0);
        } else {
            long jA = (i7 & 1) == 0 ? (j7 >>> 1) / ((long) (i7 >>> 1)) : Z5.y.a(j7, i7);
            long j8 = i7;
            cArr[63] = Character.forDigit((int) (j7 - (jA * j8)), i7);
            i8 = 63;
            while (jA > 0) {
                i8--;
                cArr[i8] = Character.forDigit((int) (jA % j8), i7);
                jA /= j8;
            }
        }
        return new String(cArr, i8, 64 - i8);
    }
}
