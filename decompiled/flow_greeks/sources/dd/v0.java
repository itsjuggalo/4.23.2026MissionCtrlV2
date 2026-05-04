package dd;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 extends u0 {
    public static Set j(Set set, Iterable elements) {
        kotlin.jvm.internal.t.f(set, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        Collection<?> collectionB = w.B(elements);
        if (collectionB.isEmpty()) {
            return a0.N0(set);
        }
        if (!(collectionB instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionB);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!((Set) collectionB).contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set k(Set set, Object obj) {
        kotlin.jvm.internal.t.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(n0.d(set.size()));
        boolean z10 = false;
        for (Object obj2 : set) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.t.b(obj2, obj)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static Set l(Set set, Iterable elements) {
        int size;
        kotlin.jvm.internal.t.f(set, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        Integer numV = s.v(elements);
        if (numV != null) {
            size = set.size() + numV.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(n0.d(size));
        linkedHashSet.addAll(set);
        w.z(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static Set m(Set set, Object obj) {
        kotlin.jvm.internal.t.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(n0.d(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
