package R6;

import B6.k;
import S6.k;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final Collection a(Collection collection, Collection collection2) {
        AbstractC2304t.f(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final k b(Iterable scopes) {
        AbstractC2304t.f(scopes, "scopes");
        k kVar = new k();
        for (Object obj : scopes) {
            B6.k kVar2 = (B6.k) obj;
            if (kVar2 != null && kVar2 != k.b.f219b) {
                kVar.add(obj);
            }
        }
        return kVar;
    }
}
