package X2;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class S extends Q {
    public static Set g(Set set, Iterable elements) {
        kotlin.jvm.internal.r.f(set, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        Collection<?> collectionV = u.v(elements);
        if (collectionV.isEmpty()) {
            return x.l0(set);
        }
        if (!(collectionV instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionV);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!((Set) collectionV).contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set h(Set set, Iterable elements) {
        int size;
        kotlin.jvm.internal.r.f(set, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        Integer numR = AbstractC0770q.r(elements);
        if (numR != null) {
            size = set.size() + numR.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(K.b(size));
        linkedHashSet.addAll(set);
        u.t(linkedHashSet, elements);
        return linkedHashSet;
    }
}
