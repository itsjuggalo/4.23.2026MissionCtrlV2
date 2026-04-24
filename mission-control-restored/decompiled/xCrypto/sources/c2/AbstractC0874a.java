package c2;

import Z1.m;
import d2.AbstractC1216a;
import java.math.RoundingMode;

/* JADX INFO: renamed from: c2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0874a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f8309a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f8310b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f8311c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f8312d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int[] f8313e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: renamed from: c2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0129a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8314a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f8314a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8314a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8314a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8314a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8314a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8314a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8314a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8314a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(int i4, int i5, RoundingMode roundingMode) {
        m.n(roundingMode);
        if (i5 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i6 = i4 / i5;
        int i7 = i4 - (i5 * i6);
        if (i7 == 0) {
            return i6;
        }
        int i8 = ((i4 ^ i5) >> 31) | 1;
        switch (C0129a.f8314a[roundingMode.ordinal()]) {
            case 1:
                AbstractC0876c.c(i7 == 0);
                return i6;
            case 2:
                return i6;
            case 3:
                if (i8 >= 0) {
                    return i6;
                }
                return i6 + i8;
            case 4:
                return i6 + i8;
            case 5:
                if (i8 <= 0) {
                    return i6;
                }
                return i6 + i8;
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
                return i6 + i8;
            default:
                throw new AssertionError();
        }
    }

    public static boolean b(int i4) {
        return (i4 > 0) & ((i4 & (i4 + (-1))) == 0);
    }

    public static int c(int i4, int i5) {
        return (~(~(i4 - i5))) >>> 31;
    }

    public static int d(int i4, RoundingMode roundingMode) {
        AbstractC0876c.b("x", i4);
        switch (C0129a.f8314a[roundingMode.ordinal()]) {
            case 1:
                AbstractC0876c.c(b(i4));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i4 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i4);
                return (31 - iNumberOfLeadingZeros) + c((-1257966797) >>> iNumberOfLeadingZeros, i4);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i4);
    }

    public static int e(int i4, int i5) {
        return AbstractC1216a.a(((long) i4) * ((long) i5));
    }
}
