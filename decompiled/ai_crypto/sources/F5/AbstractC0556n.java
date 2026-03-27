package F5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: F5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0556n extends AbstractC0555m {
    public static ArrayList e(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C0547e(elements, true));
    }

    public static final Collection f(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new C0547e(objArr, false);
    }

    public static List g() {
        return x.f2384a;
    }

    public static W5.g h(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return new W5.g(0, collection.size() - 1);
    }

    public static int i(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        return list.size() - 1;
    }

    public static List j(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return elements.length > 0 ? AbstractC0551i.c(elements) : g();
    }

    public static List k(Object obj) {
        return obj != null ? AbstractC0555m.b(obj) : g();
    }

    public static List l(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return AbstractC0552j.s(elements);
    }

    public static List m(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C0547e(elements, true));
    }

    public static final List n(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : AbstractC0555m.b(list.get(0)) : g();
    }

    public static void o() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void p() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
