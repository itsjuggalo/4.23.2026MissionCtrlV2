package com.google.android.recaptcha.internal;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public final class zzkj {
    public static int zza(int i, int i6, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i6 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i7 = i / i6;
        int i8 = i - (i6 * i7);
        if (i8 == 0) {
            return i7;
        }
        int i9 = ((i ^ i6) >> 31) | 1;
        switch (zzki.zza[roundingMode.ordinal()]) {
            case 1:
                zzkl.zzb(false);
                return i7;
            case 2:
                return i7;
            case 3:
                if (i9 >= 0) {
                    return i7;
                }
                break;
            case 4:
                break;
            case 5:
                if (i9 <= 0) {
                    return i7;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i8);
                int iAbs2 = iAbs - (Math.abs(i6) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if ((i7 & 1 & (roundingMode != RoundingMode.HALF_EVEN ? 0 : 1)) == 0) {
                            return i7;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i7;
                }
            default:
                throw new AssertionError();
        }
        return i7 + i9;
    }

    public static int zzb(int i, RoundingMode roundingMode) {
        if (i <= 0) {
            throw new IllegalArgumentException("x (0) must be > 0");
        }
        switch (zzki.zza[roundingMode.ordinal()]) {
            case 1:
                zzkl.zzb(((i + (-1)) & i) == 0);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - iNumberOfLeadingZeros) + ((((-1257966797) >>> iNumberOfLeadingZeros) - i) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }
}
