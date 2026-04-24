package o7;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2525q extends AbstractC2523p {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2525q(k7.b element) {
        super(element, null);
        AbstractC2304t.f(element, "element");
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Iterator d(Collection collection) {
        AbstractC2304t.f(collection, "<this>");
        return collection.iterator();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int e(Collection collection) {
        AbstractC2304t.f(collection, "<this>");
        return collection.size();
    }
}
