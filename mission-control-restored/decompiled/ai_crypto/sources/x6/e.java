package x6;

import kotlin.jvm.internal.r;
import w6.W;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final int a(int[] iArr, int i7, int i8, int i9) {
        r.f(iArr, "<this>");
        int i10 = i9 - 1;
        while (i8 <= i10) {
            int i11 = (i8 + i10) >>> 1;
            int i12 = iArr[i11];
            if (i12 < i7) {
                i8 = i11 + 1;
            } else {
                if (i12 <= i7) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return (-i8) - 1;
    }

    public static final int b(W w7, int i7) {
        r.f(w7, "<this>");
        int iA = a(w7.P(), i7 + 1, 0, w7.Q().length);
        return iA >= 0 ? iA : ~iA;
    }
}
