package p5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2595q extends AbstractC2594p {
    public static ArrayList g(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C2586h(elements, true));
    }

    public static final Collection h(Object[] objArr) {
        AbstractC2304t.f(objArr, "<this>");
        return new C2586h(objArr, false);
    }

    public static List i() {
        return C2573B.f22362a;
    }

    public static H5.d j(Collection collection) {
        AbstractC2304t.f(collection, "<this>");
        return new H5.d(0, collection.size() - 1);
    }

    public static int k(List list) {
        AbstractC2304t.f(list, "<this>");
        return list.size() - 1;
    }

    public static List l(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return elements.length > 0 ? AbstractC2590l.d(elements) : i();
    }

    public static List m(Object obj) {
        return obj != null ? AbstractC2594p.e(obj) : i();
    }

    public static List n(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return AbstractC2592n.A(elements);
    }

    public static List o(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C2586h(elements, true));
    }

    public static final List p(List list) {
        AbstractC2304t.f(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : AbstractC2594p.e(list.get(0)) : i();
    }

    public static void q() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void r() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
