package dd;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends v {
    public static boolean A(Collection collection, Object[] elements) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        return collection.addAll(l.d(elements));
    }

    public static final Collection B(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : a0.I0(iterable);
    }

    public static final boolean C(Iterable iterable, pd.k kVar, boolean z10) {
        Iterator it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (((Boolean) kVar.invoke(it.next())).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static final boolean D(Collection collection, Iterable elements) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        return collection.removeAll(B(elements));
    }

    public static Object E(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(r.m(list));
    }

    public static boolean F(Iterable iterable, pd.k predicate) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        return C(iterable, predicate, false);
    }

    public static final boolean G(Collection collection, Iterable elements) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        return collection.retainAll(B(elements));
    }

    public static boolean z(Collection collection, Iterable elements) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }
}
