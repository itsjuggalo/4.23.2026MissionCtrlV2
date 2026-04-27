package L3;

/* JADX INFO: renamed from: L3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0385h {
    public static /* synthetic */ String a(long j4, int i4) {
        if (j4 == 0) {
            return "0";
        }
        if (j4 > 0) {
            return Long.toString(j4, i4);
        }
        if (i4 < 2 || i4 > 36) {
            i4 = 10;
        }
        int i5 = 64;
        char[] cArr = new char[64];
        int i6 = i4 - 1;
        if ((i4 & i6) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i4);
            do {
                i5--;
                cArr[i5] = Character.forDigit(((int) j4) & i6, i4);
                j4 >>>= iNumberOfTrailingZeros;
            } while (j4 != 0);
        } else {
            long jA = (i4 & 1) == 0 ? (j4 >>> 1) / ((long) (i4 >>> 1)) : r3.E.a(j4, i4);
            long j5 = i4;
            cArr[63] = Character.forDigit((int) (j4 - (jA * j5)), i4);
            i5 = 63;
            while (jA > 0) {
                i5--;
                cArr[i5] = Character.forDigit((int) (jA % j5), i4);
                jA /= j5;
            }
        }
        return new String(cArr, i5, 64 - i5);
    }
}
