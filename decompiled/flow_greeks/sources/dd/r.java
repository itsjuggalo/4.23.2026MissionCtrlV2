package dd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends q {
    public static ArrayList h(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(i(elements, true));
    }

    public static final Collection i(Object[] objArr, boolean z10) {
        kotlin.jvm.internal.t.f(objArr, "<this>");
        return new h(objArr, z10);
    }

    public static /* synthetic */ Collection j(Object[] objArr, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return i(objArr, z10);
    }

    public static List k() {
        return c0.f7993a;
    }

    public static vd.g l(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        return new vd.g(0, collection.size() - 1);
    }

    public static int m(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        return list.size() - 1;
    }

    public static List n(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return elements.length > 0 ? l.d(elements) : k();
    }

    public static List o(Object obj) {
        return obj != null ? q.e(obj) : k();
    }

    public static List p(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return n.A(elements);
    }

    public static List q(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(i(elements, true));
    }

    public static final List r(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : q.e(list.get(0)) : k();
    }

    public static void s() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void t() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
