package H4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends n {
    public static Object f0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final void g0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, R4.l lVar) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            android.support.v4.media.session.a.a(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String h0(Iterable iterable, String str, String str2, String str3, R4.l lVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String prefix = (i & 2) != 0 ? "" : str2;
        String str5 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.j.e(iterable, "<this>");
        kotlin.jvm.internal.j.e(prefix, "prefix");
        StringBuilder sb = new StringBuilder();
        g0(iterable, sb, str4, prefix, str5, "...", lVar);
        return sb.toString();
    }

    public static Object i0(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return arrayList.get(i.b0(arrayList));
    }

    public static ArrayList j0(Collection collection, List list) {
        kotlin.jvm.internal.j.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(list.size() + collection.size());
        arrayList.addAll(collection);
        arrayList.addAll(list);
        return arrayList;
    }

    public static List k0(int i, List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(a3.d.i("Requested element count ", i, " is less than zero.").toString());
        }
        p pVar = p.f577a;
        if (i == 0) {
            return pVar;
        }
        if (i >= list.size()) {
            return o0(list);
        }
        if (i == 1) {
            return y5.a.D(f0(list));
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = list.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == i) {
                break;
            }
        }
        int size = arrayList.size();
        return size != 0 ? size != 1 ? arrayList : y5.a.D(arrayList.get(0)) : pVar;
    }

    public static byte[] l0(ArrayList arrayList) {
        byte[] bArr = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static final void m0(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] n0(ArrayList arrayList) {
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List o0(Iterable iterable) {
        ArrayList arrayListQ0;
        kotlin.jvm.internal.j.e(iterable, "<this>");
        boolean z6 = iterable instanceof Collection;
        p pVar = p.f577a;
        if (z6) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return pVar;
            }
            if (size != 1) {
                return q0(collection);
            }
            return y5.a.D(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        if (z6) {
            arrayListQ0 = q0((Collection) iterable);
        } else {
            ArrayList arrayList = new ArrayList();
            m0(iterable, arrayList);
            arrayListQ0 = arrayList;
        }
        int size2 = arrayListQ0.size();
        return size2 != 0 ? size2 != 1 ? arrayListQ0 : y5.a.D(arrayListQ0.get(0)) : pVar;
    }

    public static long[] p0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        long[] jArr = new long[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = ((Number) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static ArrayList q0(Collection collection) {
        kotlin.jvm.internal.j.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set r0(Iterable iterable) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        boolean z6 = iterable instanceof Collection;
        r rVar = r.f579a;
        if (z6) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(t.P(collection.size()));
                    m0(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                kotlin.jvm.internal.j.d(setSingleton, "singleton(...)");
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            m0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                kotlin.jvm.internal.j.d(setSingleton2, "singleton(...)");
                return setSingleton2;
            }
        }
        return rVar;
    }
}
