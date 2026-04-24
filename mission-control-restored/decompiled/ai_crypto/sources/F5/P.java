package F5;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P extends O {
    public static Set g(Set set, Iterable elements) {
        kotlin.jvm.internal.r.f(set, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        Collection<?> collectionV = s.v(elements);
        if (collectionV.isEmpty()) {
            return v.m0(set);
        }
        if (!(collectionV instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionV);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!collectionV.contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set h(Set set, Iterable elements) {
        int size;
        kotlin.jvm.internal.r.f(set, "<this>");
        kotlin.jvm.internal.r.f(elements, "elements");
        Integer numR = AbstractC0557o.r(elements);
        if (numR != null) {
            size = set.size() + numR.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(I.b(size));
        linkedHashSet.addAll(set);
        s.t(linkedHashSet, elements);
        return linkedHashSet;
    }
}
