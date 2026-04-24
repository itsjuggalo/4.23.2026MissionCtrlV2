package q;

/* JADX INFO: renamed from: q.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0912d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f9116a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object[] f9117b = new Object[0];

    public static int a(int i, int i6, int[] iArr) {
        int i7 = i - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else {
                if (i10 <= i6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static int b(long[] jArr, int i, long j4) {
        int i6 = i - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            long j6 = jArr[i8];
            if (j6 < j4) {
                i7 = i8 + 1;
            } else {
                if (j6 <= j4) {
                    return i8;
                }
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }
}
