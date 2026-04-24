package com.google.firebase.firestore.index;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public final class IntMath {

    /* JADX INFO: renamed from: com.google.firebase.firestore.index.IntMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private IntMath() {
    }

    public static int divide(int i4, int i5, RoundingMode roundingMode) {
        if (i5 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i6 = i4 / i5;
        int i7 = i4 - (i5 * i6);
        if (i7 == 0) {
            return i6;
        }
        int i8 = ((i4 ^ i5) >> 31) | 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
            case 2:
                return i6;
            case 3:
                break;
            case 4:
                if (i8 <= 0) {
                    return i6;
                }
                break;
            case 5:
                if (i8 >= 0) {
                    return i6;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i7);
                int iAbs2 = iAbs - (Math.abs(i5) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i6 & 1) != 0))) {
                            return i6;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i6;
                }
            default:
                throw new AssertionError();
        }
        return i6 + i8;
    }
}
