package dd;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends w {
    public static List K(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        return new r0(list);
    }

    public static final int L(List list, int i10) {
        if (i10 >= 0 && i10 <= r.m(list)) {
            return r.m(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new vd.g(0, r.m(list)) + "].");
    }

    public static final int M(List list, int i10) {
        return r.m(list) - i10;
    }

    public static final int N(List list, int i10) {
        if (i10 >= 0 && i10 <= list.size()) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new vd.g(0, list.size()) + "].");
    }
}
