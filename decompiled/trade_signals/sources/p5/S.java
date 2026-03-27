package p5;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S extends Q {
    public static Set d() {
        return C2575D.f22364a;
    }

    public static LinkedHashSet e(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return (LinkedHashSet) AbstractC2592n.d0(elements, new LinkedHashSet(L.d(elements.length)));
    }

    public static Set f(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return (Set) AbstractC2592n.d0(elements, new LinkedHashSet(L.d(elements.length)));
    }

    public static final Set g(Set set) {
        AbstractC2304t.f(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : Q.c(set.iterator().next()) : d();
    }

    public static Set h(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return AbstractC2592n.w0(elements);
    }

    public static Set i(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return (Set) AbstractC2592n.B(elements, new LinkedHashSet());
    }
}
