package X2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u extends AbstractC0772t {
    public static final boolean A(Collection collection, Iterable elements) {
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
        boolean z4 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z4 = true;
            }
        }
        return z4;
    }

    public static boolean u(Collection collection, Object[] elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        return collection.addAll(AbstractC0763j.c(elements));
    }

    public static final Collection v(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : x.g0(iterable);
    }

    public static final boolean w(Iterable iterable, i3.k kVar, boolean z4) {
        Iterator it = iterable.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (((Boolean) kVar.invoke(it.next())).booleanValue() == z4) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
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
        return list.remove(AbstractC0769p.i(list));
    }

    public static boolean z(Iterable iterable, i3.k predicate) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(predicate, "predicate");
        return w(iterable, predicate, false);
    }
}
