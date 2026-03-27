package p5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends x {

    public static final class a implements U6.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f22395a;

        public a(Iterable iterable) {
            this.f22395a = iterable;
        }

        @Override // U6.h
        public Iterator iterator() {
            return this.f22395a.iterator();
        }
    }

    public static final List A0(Iterable iterable, int i8) {
        AbstractC2304t.f(iterable, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
        }
        if (i8 == 0) {
            return AbstractC2595q.i();
        }
        if (iterable instanceof Collection) {
            if (i8 >= ((Collection) iterable).size()) {
                return G0(iterable);
            }
            if (i8 == 1) {
                return AbstractC2594p.e(X(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i8);
        Iterator it = iterable.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i9++;
            if (i9 == i8) {
                break;
            }
        }
        return AbstractC2595q.p(arrayList);
    }

    public static List B0(List list, int i8) {
        AbstractC2304t.f(list, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
        }
        if (i8 == 0) {
            return AbstractC2595q.i();
        }
        int size = list.size();
        if (i8 >= size) {
            return G0(list);
        }
        if (i8 == 1) {
            return AbstractC2594p.e(j0(list));
        }
        ArrayList arrayList = new ArrayList(i8);
        if (list instanceof RandomAccess) {
            for (int i9 = size - i8; i9 < size; i9++) {
                arrayList.add(list.get(i9));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i8);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static boolean[] C0(Collection collection) {
        AbstractC2304t.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            zArr[i8] = ((Boolean) it.next()).booleanValue();
            i8++;
        }
        return zArr;
    }

    public static Collection D0(Iterable iterable, Collection destination) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static HashSet E0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return (HashSet) D0(iterable, new HashSet(L.d(r.s(iterable, 12))));
    }

    public static int[] F0(Collection collection) {
        AbstractC2304t.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            iArr[i8] = ((Number) it.next()).intValue();
            i8++;
        }
        return iArr;
    }

    public static List G0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC2595q.p(H0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC2595q.i();
        }
        if (size != 1) {
            return I0(collection);
        }
        return AbstractC2594p.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List H0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return iterable instanceof Collection ? I0((Collection) iterable) : (List) D0(iterable, new ArrayList());
    }

    public static List I0(Collection collection) {
        AbstractC2304t.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set J0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) D0(iterable, new LinkedHashSet());
    }

    public static Set K0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return S.g((Set) D0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return S.d();
        }
        if (size != 1) {
            return (Set) D0(iterable, new LinkedHashSet(L.d(collection.size())));
        }
        return Q.c(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static Set L0(Iterable iterable, Iterable other) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(other, "other");
        Set setJ0 = J0(iterable);
        v.x(setJ0, other);
        return setJ0;
    }

    public static Iterable M0(final Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return new C2578G(new Function0() { // from class: p5.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z.N0(iterable);
            }
        });
    }

    public static final Iterator N0(Iterable iterable) {
        return iterable.iterator();
    }

    public static boolean O(Iterable iterable, B5.k predicate) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static List O0(Iterable iterable, Iterable other) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(r.s(iterable, 10), r.s(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(o5.w.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static U6.h P(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean Q(Iterable iterable, Object obj) {
        AbstractC2304t.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : c0(iterable, obj) >= 0;
    }

    public static List R(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return G0(J0(iterable));
    }

    public static List S(Iterable iterable, int i8) {
        ArrayList arrayList;
        AbstractC2304t.f(iterable, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
        }
        if (i8 == 0) {
            return G0(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i8;
            if (size <= 0) {
                return AbstractC2595q.i();
            }
            if (size == 1) {
                return AbstractC2594p.e(i0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                boolean z7 = iterable instanceof RandomAccess;
                List list = (List) iterable;
                if (z7) {
                    int size2 = list.size();
                    while (i8 < size2) {
                        arrayList.add(list.get(i8));
                        i8++;
                    }
                } else {
                    ListIterator listIterator = list.listIterator(i8);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i9 = 0;
        for (Object obj : iterable) {
            if (i9 >= i8) {
                arrayList.add(obj);
            } else {
                i9++;
            }
        }
        return AbstractC2595q.p(arrayList);
    }

    public static List T(List list, int i8) {
        AbstractC2304t.f(list, "<this>");
        if (i8 >= 0) {
            return A0(list, H5.i.b(list.size() - i8, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static List U(Iterable iterable, B5.k predicate) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((Boolean) predicate.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List V(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        return (List) W(iterable, new ArrayList());
    }

    public static final Collection W(Iterable iterable, Collection destination) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(destination, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static Object X(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return Y((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object Y(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object Z(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object a0(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object b0(List list, int i8) {
        AbstractC2304t.f(list, "<this>");
        if (i8 < 0 || i8 >= list.size()) {
            return null;
        }
        return list.get(i8);
    }

    public static final int c0(Iterable iterable, Object obj) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i8 = 0;
        for (Object obj2 : iterable) {
            if (i8 < 0) {
                AbstractC2595q.r();
            }
            if (AbstractC2304t.b(obj, obj2)) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static Set d0(Iterable iterable, Iterable other) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(other, "other");
        Set setJ0 = J0(iterable);
        v.F(setJ0, other);
        return setJ0;
    }

    public static final Appendable e0(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, B5.k kVar) throws IOException {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(buffer, "buffer");
        AbstractC2304t.f(separator, "separator");
        AbstractC2304t.f(prefix, "prefix");
        AbstractC2304t.f(postfix, "postfix");
        AbstractC2304t.f(truncated, "truncated");
        buffer.append(prefix);
        int i9 = 0;
        for (Object obj : iterable) {
            i9++;
            if (i9 > 1) {
                buffer.append(separator);
            }
            if (i8 >= 0 && i9 > i8) {
                break;
            }
            V6.q.a(buffer, obj, kVar);
        }
        if (i8 >= 0 && i9 > i8) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String g0(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, B5.k kVar) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(separator, "separator");
        AbstractC2304t.f(prefix, "prefix");
        AbstractC2304t.f(postfix, "postfix");
        AbstractC2304t.f(truncated, "truncated");
        return ((StringBuilder) e0(iterable, new StringBuilder(), separator, prefix, postfix, i8, truncated, kVar)).toString();
    }

    public static /* synthetic */ String h0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, B5.k kVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i9 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i9 & 4) == 0 ? charSequence3 : "";
        if ((i9 & 8) != 0) {
            i8 = -1;
        }
        int i10 = i8;
        if ((i9 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i9 & 32) != 0) {
            kVar = null;
        }
        return g0(iterable, charSequence, charSequence5, charSequence6, i10, charSequence7, kVar);
    }

    public static Object i0(Iterable iterable) {
        Object next;
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return j0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object j0(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC2595q.k(list));
    }

    public static Object k0(Iterable iterable) {
        Object next;
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object l0(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static List m0(Iterable iterable, B5.k transform) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(transform, "transform");
        ArrayList arrayList = new ArrayList(r.s(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static Comparable n0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List o0(Iterable iterable, Object obj) {
        AbstractC2304t.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList(r.s(iterable, 10));
        boolean z7 = false;
        for (Object obj2 : iterable) {
            boolean z8 = true;
            if (!z7 && AbstractC2304t.b(obj2, obj)) {
                z7 = true;
                z8 = false;
            }
            if (z8) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static List p0(Iterable iterable, Iterable elements) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(elements, "elements");
        if (iterable instanceof Collection) {
            return r0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        v.x(arrayList, iterable);
        v.x(arrayList, elements);
        return arrayList;
    }

    public static List q0(Iterable iterable, Object obj) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return s0((Collection) iterable, obj);
        }
        ArrayList arrayList = new ArrayList();
        v.x(arrayList, iterable);
        arrayList.add(obj);
        return arrayList;
    }

    public static List r0(Collection collection, Iterable elements) {
        AbstractC2304t.f(collection, "<this>");
        AbstractC2304t.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            v.x(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List s0(Collection collection, Object obj) {
        AbstractC2304t.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object t0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return u0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static Object u0(List list) {
        AbstractC2304t.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object v0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static Object w0(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List x0(List list, H5.d indices) {
        AbstractC2304t.f(list, "<this>");
        AbstractC2304t.f(indices, "indices");
        return indices.isEmpty() ? AbstractC2595q.i() : G0(list.subList(indices.a().intValue(), indices.d().intValue() + 1));
    }

    public static List y0(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listH0 = H0(iterable);
            u.v(listH0);
            return listH0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return G0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        AbstractC2590l.p((Comparable[]) array);
        return AbstractC2590l.d(array);
    }

    public static List z0(Iterable iterable, Comparator comparator) {
        AbstractC2304t.f(iterable, "<this>");
        AbstractC2304t.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listH0 = H0(iterable);
            u.w(listH0, comparator);
            return listH0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return G0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        AbstractC2590l.q(array, comparator);
        return AbstractC2590l.d(array);
    }
}
