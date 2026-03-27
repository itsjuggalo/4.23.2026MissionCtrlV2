package J3;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: J3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0344q extends AbstractC0343p {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0344q(F3.b element) {
        super(element, null);
        kotlin.jvm.internal.r.f(element, "element");
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Iterator d(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return collection.iterator();
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int e(Collection collection) {
        kotlin.jvm.internal.r.f(collection, "<this>");
        return collection.size();
    }
}
