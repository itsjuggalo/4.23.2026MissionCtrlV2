package v7;

import kotlin.jvm.internal.AbstractC2304t;
import u7.S;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final int a(int[] iArr, int i8, int i9, int i10) {
        AbstractC2304t.f(iArr, "<this>");
        int i11 = i10 - 1;
        while (i9 <= i11) {
            int i12 = (i9 + i11) >>> 1;
            int i13 = iArr[i12];
            if (i13 < i8) {
                i9 = i12 + 1;
            } else {
                if (i13 <= i8) {
                    return i12;
                }
                i11 = i12 - 1;
            }
        }
        return (-i9) - 1;
    }

    public static final int b(S s8, int i8) {
        AbstractC2304t.f(s8, "<this>");
        int iA = a(s8.Z(), i8 + 1, 0, s8.a0().length);
        return iA >= 0 ? iA : ~iA;
    }
}
