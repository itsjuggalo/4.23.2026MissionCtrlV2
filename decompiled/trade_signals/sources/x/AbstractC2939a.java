package x;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: x.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2939a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f24102a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f24103b = new long[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object[] f24104c = new Object[0];

    public static final int a(int[] array, int i8, int i9) {
        AbstractC2304t.f(array, "array");
        int i10 = i8 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            int i13 = array[i12];
            if (i13 < i9) {
                i11 = i12 + 1;
            } else {
                if (i13 <= i9) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }

    public static final int b(long[] array, int i8, long j8) {
        AbstractC2304t.f(array, "array");
        int i9 = i8 - 1;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = (i10 + i9) >>> 1;
            long j9 = array[i11];
            if (j9 < j8) {
                i10 = i11 + 1;
            } else {
                if (j9 <= j8) {
                    return i11;
                }
                i9 = i11 - 1;
            }
        }
        return ~i10;
    }

    public static final boolean c(Object obj, Object obj2) {
        return AbstractC2304t.b(obj, obj2);
    }

    public static final int d(int i8) {
        for (int i9 = 4; i9 < 32; i9++) {
            int i10 = (1 << i9) - 12;
            if (i8 <= i10) {
                return i10;
            }
        }
        return i8;
    }

    public static final int e(int i8) {
        return d(i8 * 4) / 4;
    }

    public static final int f(int i8) {
        return d(i8 * 8) / 8;
    }
}
