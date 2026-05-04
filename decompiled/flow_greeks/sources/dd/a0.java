package dd;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 extends y {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements jg.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f7989a;

        public a(Iterable iterable) {
            this.f7989a = iterable;
        }

        @Override // jg.h
        public Iterator iterator() {
            return this.f7989a.iterator();
        }
    }

    public static List A0(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listK0 = K0(iterable);
            v.y(listK0, comparator);
            return listK0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return I0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        l.q(array, comparator);
        return l.d(array);
    }

    public static List B0(Iterable iterable, int i10) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return r.k();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return I0(iterable);
            }
            if (i10 == 1) {
                return q.e(Y(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator it = iterable.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return r.r(arrayList);
    }

    public static List C0(List list, int i10) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return r.k();
        }
        int size = list.size();
        if (i10 >= size) {
            return I0(list);
        }
        if (i10 == 1) {
            return q.e(k0(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static boolean[] D0(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            zArr[i10] = ((Boolean) it.next()).booleanValue();
            i10++;
        }
        return zArr;
    }

    public static byte[] E0(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bArr[i10] = ((Number) it.next()).byteValue();
            i10++;
        }
        return bArr;
    }

    public static final Collection F0(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static HashSet G0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return (HashSet) F0(iterable, new HashSet(n0.d(s.u(iterable, 12))));
    }

    public static int[] H0(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Number) it.next()).intValue();
            i10++;
        }
        return iArr;
    }

    public static List I0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return r.r(K0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return r.k();
        }
        if (size != 1) {
            return L0(collection);
        }
        return q.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static long[] J0(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr[i10] = ((Number) it.next()).longValue();
            i10++;
        }
        return jArr;
    }

    public static final List K0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return iterable instanceof Collection ? L0((Collection) iterable) : (List) F0(iterable, new ArrayList());
    }

    public static List L0(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set M0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) F0(iterable, new LinkedHashSet());
    }

    public static Set N0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return u0.g((Set) F0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return u0.d();
        }
        if (size != 1) {
            return (Set) F0(iterable, new LinkedHashSet(n0.d(collection.size())));
        }
        return t0.c(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static Set O0(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        Set setM0 = M0(iterable);
        w.z(setM0, other);
        return setM0;
    }

    public static boolean P(Iterable iterable, pd.k predicate) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(predicate, "predicate");
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

    public static List P0(Iterable iterable, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        w0.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = w0.b(iterable.iterator(), i10, i11, z10, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        int i12 = 0;
        while (i12 >= 0 && i12 < size) {
            int iD = vd.l.d(i10, size - i12);
            if (iD < i10 && !z10) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(iD);
            for (int i13 = 0; i13 < iD; i13++) {
                arrayList3.add(list.get(i13 + i12));
            }
            arrayList2.add(arrayList3);
            i12 += i11;
        }
        return arrayList2;
    }

    public static jg.h Q(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return new a(iterable);
    }

    public static Iterable Q0(final Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return new h0(new Function0() { // from class: dd.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a0.R0(iterable);
            }
        });
    }

    public static boolean R(Iterable iterable, Object obj) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : d0(iterable, obj) >= 0;
    }

    public static final Iterator R0(Iterable iterable) {
        return iterable.iterator();
    }

    public static List S(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return I0(M0(iterable));
    }

    public static List S0(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(s.u(iterable, 10), s.u(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(cd.w.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static List T(Iterable iterable, int i10) {
        ArrayList arrayList;
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return I0(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i10;
            if (size <= 0) {
                return r.k();
            }
            if (size == 1) {
                return q.e(j0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i10 < size2) {
                        arrayList.add(list.get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i11 = 0;
        for (Object obj : iterable) {
            if (i11 >= i10) {
                arrayList.add(obj);
            } else {
                i11++;
            }
        }
        return r.r(arrayList);
    }

    public static List U(List list, int i10) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (i10 >= 0) {
            return B0(list, vd.l.b(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static List V(Iterable iterable, pd.k predicate) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((Boolean) predicate.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List W(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        return (List) X(iterable, new ArrayList());
    }

    public static final Collection X(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static Object Y(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return Z((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object Z(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object a0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
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

    public static Object b0(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object c0(List list, int i10) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    public static final int d0(Iterable iterable, Object obj) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i10 = 0;
        for (Object obj2 : iterable) {
            if (i10 < 0) {
                r.t();
            }
            if (kotlin.jvm.internal.t.b(obj, obj2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static Set e0(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        Set setM0 = M0(iterable);
        w.G(setM0, other);
        return setM0;
    }

    public static final Appendable f0(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) throws IOException {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(buffer, "buffer");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (Object obj : iterable) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kg.p.a(buffer, obj, kVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String h0(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, pd.k kVar) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(separator, "separator");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        kotlin.jvm.internal.t.f(postfix, "postfix");
        kotlin.jvm.internal.t.f(truncated, "truncated");
        return ((StringBuilder) f0(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, kVar)).toString();
    }

    public static /* synthetic */ String i0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        pd.k kVar2 = kVar;
        return h0(iterable, charSequence, charSequence2, charSequence3, i10, charSequence5, kVar2);
    }

    public static Object j0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return k0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object k0(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(r.m(list));
    }

    public static Object l0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
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
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object m0(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static List n0(Iterable iterable, pd.k transform) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(transform, "transform");
        ArrayList arrayList = new ArrayList(s.u(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static Comparable o0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
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

    public static List p0(Iterable iterable, Object obj) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList(s.u(iterable, 10));
        boolean z10 = false;
        for (Object obj2 : iterable) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.t.b(obj2, obj)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static List q0(Iterable iterable, Iterable elements) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        if (iterable instanceof Collection) {
            return s0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        w.z(arrayList, iterable);
        w.z(arrayList, elements);
        return arrayList;
    }

    public static List r0(Iterable iterable, Object obj) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return t0((Collection) iterable, obj);
        }
        ArrayList arrayList = new ArrayList();
        w.z(arrayList, iterable);
        arrayList.add(obj);
        return arrayList;
    }

    public static List s0(Collection collection, Iterable elements) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            w.z(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List t0(Collection collection, Object obj) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object u0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (iterable instanceof List) {
            return v0((List) iterable);
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

    public static Object v0(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object w0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
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

    public static Object x0(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List y0(List list, vd.g indices) {
        kotlin.jvm.internal.t.f(list, "<this>");
        kotlin.jvm.internal.t.f(indices, "indices");
        return indices.isEmpty() ? r.k() : I0(list.subList(indices.a().intValue(), indices.c().intValue() + 1));
    }

    public static List z0(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listK0 = K0(iterable);
            v.x(listK0);
            return listK0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return I0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        l.p((Comparable[]) array);
        return l.d(array);
    }
}
