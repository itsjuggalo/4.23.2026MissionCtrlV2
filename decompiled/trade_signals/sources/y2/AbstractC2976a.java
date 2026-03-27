package y2;

import java.math.RoundingMode;
import v2.AbstractC2848n;
import z2.AbstractC3003a;

/* JADX INFO: renamed from: y2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2976a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f24455a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f24456b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f24457c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f24458d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int[] f24459e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0435a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24460a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f24460a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24460a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24460a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24460a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24460a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24460a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24460a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f24460a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i8, int i9, RoundingMode roundingMode) {
        AbstractC2848n.n(roundingMode);
        if (i9 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i10 = i8 / i9;
        int i11 = i8 - (i9 * i10);
        if (i11 == 0) {
            return i10;
        }
        int i12 = ((i8 ^ i9) >> 31) | 1;
        switch (C0435a.f24460a[roundingMode.ordinal()]) {
            case 1:
                AbstractC2978c.c(i11 == 0);
                return i10;
            case 2:
                return i10;
            case 3:
                if (i12 >= 0) {
                    return i10;
                }
                break;
            case 4:
                break;
            case 5:
                if (i12 <= 0) {
                    return i10;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i11);
                int iAbs2 = iAbs - (Math.abs(i9) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i10 & 1) != 0))) {
                            return i10;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i10;
                }
            default:
                throw new AssertionError();
        }
        return i10 + i12;
    }

    public static boolean b(int i8) {
        return (i8 > 0) & ((i8 & (i8 + (-1))) == 0);
    }

    public static int c(int i8, int i9) {
        return (~(~(i8 - i9))) >>> 31;
    }

    public static int d(int i8, RoundingMode roundingMode) {
        AbstractC2978c.b("x", i8);
        switch (C0435a.f24460a[roundingMode.ordinal()]) {
            case 1:
                AbstractC2978c.c(b(i8));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i8 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i8);
                return (31 - iNumberOfLeadingZeros) + c((-1257966797) >>> iNumberOfLeadingZeros, i8);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i8);
    }

    public static int e(int i8, int i9) {
        return AbstractC3003a.a(((long) i8) * ((long) i9));
    }
}
