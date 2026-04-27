package p5;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class T extends S {
    public static Set j(Set set, Iterable elements) {
        AbstractC2304t.f(set, "<this>");
        AbstractC2304t.f(elements, "elements");
        Collection<?> collectionZ = v.z(elements);
        if (collectionZ.isEmpty()) {
            return z.K0(set);
        }
        if (!(collectionZ instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionZ);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!((Set) collectionZ).contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set k(Set set, Object obj) {
        AbstractC2304t.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(L.d(set.size()));
        boolean z7 = false;
        for (Object obj2 : set) {
            boolean z8 = true;
            if (!z7 && AbstractC2304t.b(obj2, obj)) {
                z7 = true;
                z8 = false;
            }
            if (z8) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static Set l(Set set, Iterable elements) {
        int size;
        AbstractC2304t.f(set, "<this>");
        AbstractC2304t.f(elements, "elements");
        Integer numT = r.t(elements);
        if (numT != null) {
            size = set.size() + numT.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(L.d(size));
        linkedHashSet.addAll(set);
        v.x(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static Set m(Set set, Object obj) {
        AbstractC2304t.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(L.d(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
