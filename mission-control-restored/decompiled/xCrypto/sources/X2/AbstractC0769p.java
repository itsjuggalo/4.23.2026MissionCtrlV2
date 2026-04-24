package X2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import o3.C1676g;

/* JADX INFO: renamed from: X2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0769p extends AbstractC0768o {
    public static ArrayList e(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C0759f(elements, true));
    }

    public static final Collection f(Object[] objArr) {
        kotlin.jvm.internal.r.f(objArr, "<this>");
        return new C0759f(objArr, false);
    }

    public static List g() {
        return z.f5622a;
    }

    public static C1676g h(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return new C1676g(0, collection.size() - 1);
    }

    public static int i(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        return list.size() - 1;
    }

    public static List j(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return elements.length > 0 ? AbstractC0763j.c(elements) : g();
    }

    public static List k(Object obj) {
        return obj != null ? AbstractC0768o.b(obj) : g();
    }

    public static List l(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return AbstractC0765l.t(elements);
    }

    public static List m(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C0759f(elements, true));
    }

    public static final List n(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : AbstractC0768o.b(list.get(0)) : g();
    }

    public static void o() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void p() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
