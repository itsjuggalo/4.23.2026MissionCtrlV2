package dd;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 extends t0 {
    public static Set d() {
        return e0.f8002a;
    }

    public static LinkedHashSet e(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return (LinkedHashSet) n.s0(elements, new LinkedHashSet(n0.d(elements.length)));
    }

    public static Set f(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return (Set) n.s0(elements, new LinkedHashSet(n0.d(elements.length)));
    }

    public static final Set g(Set set) {
        kotlin.jvm.internal.t.f(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : t0.c(set.iterator().next()) : d();
    }

    public static Set h(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return n.L0(elements);
    }

    public static Set i(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return (Set) n.B(elements, new LinkedHashSet());
    }
}
