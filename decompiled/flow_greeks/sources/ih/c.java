package ih;

import hh.q;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final int a(int[] iArr, int i10, int i11, int i12) {
        t.f(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final int b(q qVar, int i10) {
        t.f(qVar, "<this>");
        int iA = a(qVar.M(), i10 + 1, 0, qVar.R().length);
        return iA >= 0 ? iA : ~iA;
    }
}
