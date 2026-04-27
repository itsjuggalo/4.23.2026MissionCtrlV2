package p5;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends v {
    public static List J(List list) {
        AbstractC2304t.f(list, "<this>");
        return new P(list);
    }

    public static final int K(List list, int i8) {
        if (i8 >= 0 && i8 <= AbstractC2595q.k(list)) {
            return AbstractC2595q.k(list) - i8;
        }
        throw new IndexOutOfBoundsException("Element index " + i8 + " must be in range [" + new H5.d(0, AbstractC2595q.k(list)) + "].");
    }

    public static final int L(List list, int i8) {
        return AbstractC2595q.k(list) - i8;
    }

    public static final int M(List list, int i8) {
        if (i8 >= 0 && i8 <= list.size()) {
            return list.size() - i8;
        }
        throw new IndexOutOfBoundsException("Position index " + i8 + " must be in range [" + new H5.d(0, list.size()) + "].");
    }
}
