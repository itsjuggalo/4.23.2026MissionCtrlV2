package dh;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends p {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(zg.b element) {
        super(element, null);
        kotlin.jvm.internal.t.f(element, "element");
    }

    @Override // dh.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Iterator d(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        return collection.iterator();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int e(Collection collection) {
        kotlin.jvm.internal.t.f(collection, "<this>");
        return collection.size();
    }
}
