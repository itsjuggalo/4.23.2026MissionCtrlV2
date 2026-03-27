package O2;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2338a;

    static {
        int[] iArr = new int[RoundingMode.values().length];
        f2338a = iArr;
        try {
            iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2338a[RoundingMode.DOWN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2338a[RoundingMode.UP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2338a[RoundingMode.CEILING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2338a[RoundingMode.FLOOR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f2338a[RoundingMode.HALF_EVEN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f2338a[RoundingMode.HALF_DOWN.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f2338a[RoundingMode.HALF_UP.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
