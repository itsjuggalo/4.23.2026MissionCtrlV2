package F5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends u {

    public static final class a implements Y5.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f2382a;

        public a(Iterable iterable) {
            this.f2382a = iterable;
        }

        @Override // Y5.f
        public Iterator iterator() {
            return this.f2382a.iterator();
        }
    }

    public static Y5.f C(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean D(Iterable iterable, Object obj) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : M(iterable, obj) >= 0;
    }

    public static List E(List list, int i7) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (i7 >= 0) {
            return b0(list, W5.l.b(list.size() - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    public static List F(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return (List) G(iterable, new ArrayList());
    }

    public static final Collection G(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static Object H(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof List) {
            return I((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object I(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object J(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
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

    public static Object K(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object L(List list, int i7) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (i7 < 0 || i7 >= list.size()) {
            return null;
        }
        return list.get(i7);
    }

    public static final int M(Iterable iterable, Object obj) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i7 = 0;
        for (Object obj2 : iterable) {
            if (i7 < 0) {
                AbstractC0556n.p();
            }
            if (kotlin.jvm.internal.r.b(obj, obj2)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static Set N(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        Set setL0 = l0(iterable);
        s.B(setL0, other);
        return setL0;
    }

    public static final Appendable O(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (Object obj : iterable) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            Z5.l.a(buffer, obj, kVar);
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String Q(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i7, CharSequence truncated, Q5.k kVar) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        String string = ((StringBuilder) O(iterable, new StringBuilder(), separator, prefix, postfix, i7, truncated, kVar)).toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String R(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, Q5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            kVar = null;
        }
        return Q(iterable, charSequence, charSequence5, charSequence6, i9, charSequence7, kVar);
    }

    public static Object S(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC0556n.i(list));
    }

    public static Object T(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable U(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
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

    public static List V(Collection collection, Iterable elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            s.t(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List W(Collection collection, Object obj) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object X(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof List) {
            return Y((List) iterable);
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

    public static final Object Y(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object Z(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List a0(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listJ0 = j0(iterable);
            r.s(listJ0, comparator);
            return listJ0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return h0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        AbstractC0551i.l(array, comparator);
        return AbstractC0551i.c(array);
    }

    public static List b0(Iterable iterable, int i7) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return AbstractC0556n.g();
        }
        if (iterable instanceof Collection) {
            if (i7 >= ((Collection) iterable).size()) {
                return h0(iterable);
            }
            if (i7 == 1) {
                return AbstractC0555m.b(H(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i7);
        Iterator it = iterable.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return AbstractC0556n.n(arrayList);
    }

    public static boolean[] c0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            zArr[i7] = ((Boolean) it.next()).booleanValue();
            i7++;
        }
        return zArr;
    }

    public static byte[] d0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            bArr[i7] = ((Number) it.next()).byteValue();
            i7++;
        }
        return bArr;
    }

    public static final Collection e0(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static HashSet f0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return (HashSet) e0(iterable, new HashSet(I.b(AbstractC0557o.q(iterable, 12))));
    }

    public static int[] g0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr[i7] = ((Number) it.next()).intValue();
            i7++;
        }
        return iArr;
    }

    public static List h0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC0556n.n(j0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC0556n.g();
        }
        if (size != 1) {
            return k0(collection);
        }
        return AbstractC0555m.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static long[] i0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            jArr[i7] = ((Number) it.next()).longValue();
            i7++;
        }
        return jArr;
    }

    public static final List j0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? k0((Collection) iterable) : (List) e0(iterable, new ArrayList());
    }

    public static List k0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set l0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) e0(iterable, new LinkedHashSet());
    }

    public static Set m0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return O.d((Set) e0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return O.b();
        }
        if (size != 1) {
            return (Set) e0(iterable, new LinkedHashSet(I.b(collection.size())));
        }
        return N.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static List n0(Iterable iterable, int i7, int i8, boolean z7) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        Q.a(i7, i8);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = Q.b(iterable.iterator(), i7, i8, z7, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i8) + (size % i8 == 0 ? 0 : 1));
        int i9 = 0;
        while (i9 >= 0 && i9 < size) {
            int iD = W5.l.d(i7, size - i9);
            if (iD < i7 && !z7) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iD);
            for (int i10 = 0; i10 < iD; i10++) {
                arrayList3.add(list.get(i10 + i9));
            }
            arrayList2.add(arrayList3);
            i9 += i8;
        }
        return arrayList2;
    }

    public static List o0(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC0557o.q(iterable, 10), AbstractC0557o.q(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(E5.t.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
