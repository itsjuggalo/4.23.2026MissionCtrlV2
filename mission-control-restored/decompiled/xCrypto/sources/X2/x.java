package X2;

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
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends w {

    public static final class a implements q3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f5620a;

        public a(Iterable iterable) {
            this.f5620a = iterable;
        }

        @Override // q3.e
        public Iterator iterator() {
            return this.f5620a.iterator();
        }
    }

    public static q3.e B(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean C(Iterable iterable, Object obj) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : L(iterable, obj) >= 0;
    }

    public static List D(List list, int i4) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (i4 >= 0) {
            return a0(list, AbstractC1681l.b(list.size() - i4, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static List E(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return (List) F(iterable, new ArrayList());
    }

    public static final Collection F(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static Object G(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof List) {
            return H((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object H(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object I(Iterable iterable) {
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

    public static Object J(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object K(List list, int i4) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (i4 < 0 || i4 >= list.size()) {
            return null;
        }
        return list.get(i4);
    }

    public static final int L(Iterable iterable, Object obj) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i4 = 0;
        for (Object obj2 : iterable) {
            if (i4 < 0) {
                AbstractC0769p.p();
            }
            if (kotlin.jvm.internal.r.b(obj, obj2)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static Set M(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        Set setK0 = k0(iterable);
        u.A(setK0, other);
        return setK0;
    }

    public static final Appendable N(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) throws IOException {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(buffer, "buffer");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        buffer.append(prefix);
        int i5 = 0;
        for (Object obj : iterable) {
            i5++;
            if (i5 > 1) {
                buffer.append(separator);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            r3.n.a(buffer, obj, kVar);
        }
        if (i4 >= 0 && i5 > i4) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String P(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i4, CharSequence truncated, i3.k kVar) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(separator, "separator");
        kotlin.jvm.internal.r.f(prefix, "prefix");
        kotlin.jvm.internal.r.f(postfix, "postfix");
        kotlin.jvm.internal.r.f(truncated, "truncated");
        return ((StringBuilder) N(iterable, new StringBuilder(), separator, prefix, postfix, i4, truncated, kVar)).toString();
    }

    public static /* synthetic */ String Q(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i5 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i5 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i5 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        i3.k kVar2 = kVar;
        return P(iterable, charSequence, charSequence2, charSequence3, i4, charSequence5, kVar2);
    }

    public static Object R(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC0769p.i(list));
    }

    public static Object S(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable T(Iterable iterable) {
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

    public static List U(Collection collection, Iterable elements) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            u.t(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List V(Collection collection, Object obj) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object W(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof List) {
            return X((List) iterable);
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

    public static final Object X(List list) {
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

    public static Object Y(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List Z(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listI0 = i0(iterable);
            AbstractC0772t.s(listI0, comparator);
            return listI0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return g0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        AbstractC0763j.l(array, comparator);
        return AbstractC0763j.c(array);
    }

    public static List a0(Iterable iterable, int i4) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
        }
        if (i4 == 0) {
            return AbstractC0769p.g();
        }
        if (iterable instanceof Collection) {
            if (i4 >= ((Collection) iterable).size()) {
                return g0(iterable);
            }
            if (i4 == 1) {
                return AbstractC0768o.b(G(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i4);
        Iterator it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i5++;
            if (i5 == i4) {
                break;
            }
        }
        return AbstractC0769p.n(arrayList);
    }

    public static boolean[] b0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            zArr[i4] = ((Boolean) it.next()).booleanValue();
            i4++;
        }
        return zArr;
    }

    public static byte[] c0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            bArr[i4] = ((Number) it.next()).byteValue();
            i4++;
        }
        return bArr;
    }

    public static final Collection d0(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static HashSet e0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return (HashSet) d0(iterable, new HashSet(K.b(AbstractC0770q.q(iterable, 12))));
    }

    public static int[] f0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            iArr[i4] = ((Number) it.next()).intValue();
            i4++;
        }
        return iArr;
    }

    public static List g0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC0769p.n(i0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC0769p.g();
        }
        if (size != 1) {
            return j0(collection);
        }
        return AbstractC0768o.b(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static long[] h0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            jArr[i4] = ((Number) it.next()).longValue();
            i4++;
        }
        return jArr;
    }

    public static final List i0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? j0((Collection) iterable) : (List) d0(iterable, new ArrayList());
    }

    public static List j0(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set k0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) d0(iterable, new LinkedHashSet());
    }

    public static Set l0(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return Q.d((Set) d0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return Q.b();
        }
        if (size != 1) {
            return (Set) d0(iterable, new LinkedHashSet(K.b(collection.size())));
        }
        return P.a(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static List m0(Iterable iterable, int i4, int i5, boolean z4) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        T.a(i4, i5);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = T.b(iterable.iterator(), i4, i5, z4, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i5) + (size % i5 == 0 ? 0 : 1));
        int i6 = 0;
        while (i6 >= 0 && i6 < size) {
            int iD = AbstractC1681l.d(i4, size - i6);
            if (iD < i4 && !z4) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(iD);
            for (int i7 = 0; i7 < iD; i7++) {
                arrayList3.add(list.get(i7 + i6));
            }
            arrayList2.add(arrayList3);
            i6 += i5;
        }
        return arrayList2;
    }

    public static List n0(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC0770q.q(iterable, 10), AbstractC0770q.q(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(W2.t.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
