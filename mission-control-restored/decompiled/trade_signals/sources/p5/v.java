package p5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends u {
    public static final boolean A(Iterable iterable, B5.k kVar, boolean z7) {
        Iterator it = iterable.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            if (((Boolean) kVar.invoke(it.next())).booleanValue() == z7) {
                it.remove();
                z8 = true;
            }
        }
        return z8;
    }

    public static final boolean B(Collection collection, Iterable elements) {
        AbstractC2304t.f(collection, "<this>");
        AbstractC2304t.f(elements, "elements");
        return collection.removeAll(z(elements));
    }

    public static Object C(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(AbstractC2595q.k(list));
    }

    public static Object D(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(AbstractC2595q.k(list));
    }

    public static boolean E(Iterable iterable, B5.k predicate) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        return A(iterable, predicate, false);
    }

    public static final boolean F(Collection collection, Iterable elements) {
        AbstractC2304t.f(collection, "<this>");
        AbstractC2304t.f(elements, "elements");
        return collection.retainAll(z(elements));
    }

    public static boolean x(Collection collection, Iterable elements) {
        AbstractC2304t.f(collection, "<this>");
        AbstractC2304t.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator it = elements.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public static boolean y(Collection collection, Object[] elements) {
        AbstractC2304t.f(collection, "<this>");
        AbstractC2304t.f(elements, "elements");
        return collection.addAll(AbstractC2590l.d(elements));
    }

    public static final Collection z(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : z.G0(iterable);
    }
}
