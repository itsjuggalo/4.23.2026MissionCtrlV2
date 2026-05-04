package gg;

import hg.k;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.t;
import qf.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final Collection a(Collection collection, Collection collection2) {
        t.f(collection2, "collection");
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
        t.f(scopes, "scopes");
        k kVar = new k();
        for (Object obj : scopes) {
            qf.k kVar2 = (qf.k) obj;
            if (kVar2 != null && kVar2 != k.b.f19087b) {
                kVar.add(obj);
            }
        }
        return kVar;
    }
}
