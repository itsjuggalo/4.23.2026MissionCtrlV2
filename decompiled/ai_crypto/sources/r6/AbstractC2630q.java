package r6;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: r6.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2630q extends AbstractC2629p {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2630q(n6.b element) {
        super(element, null);
        kotlin.jvm.internal.r.f(element, "element");
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Iterator d(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return collection.iterator();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int e(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return collection.size();
    }
}
