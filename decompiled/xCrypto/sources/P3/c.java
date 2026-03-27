package P3;

import O3.q;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final int a(int[] iArr, int i4, int i5, int i6) {
        r.f(iArr, "<this>");
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i4) {
                i5 = i8 + 1;
            } else {
                if (i9 <= i4) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return (-i5) - 1;
    }

    public static final int b(q qVar, int i4) {
        r.f(qVar, "<this>");
        int iA = a(qVar.B(), i4 + 1, 0, qVar.C().length);
        return iA >= 0 ? iA : ~iA;
    }
}
