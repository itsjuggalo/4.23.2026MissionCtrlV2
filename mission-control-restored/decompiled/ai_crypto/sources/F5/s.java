package F5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends r {
    public static boolean A(Iterable iterable, Q5.k predicate) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(predicate, "predicate");
        return w(iterable, predicate, false);
    }

    public static final boolean B(Collection collection, Iterable elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        return collection.retainAll(v(elements));
    }

    public static boolean t(Collection collection, Iterable elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
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

    public static boolean u(Collection collection, Object[] elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        return collection.addAll(AbstractC0551i.c(elements));
    }

    public static final Collection v(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : v.h0(iterable);
    }

    public static final boolean w(Iterable iterable, Q5.k kVar, boolean z7) {
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

    public static final boolean x(Collection collection, Iterable elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        return collection.removeAll(v(elements));
    }

    public static Object y(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(AbstractC0556n.i(list));
    }

    public static Object z(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(AbstractC0556n.i(list));
    }
}
