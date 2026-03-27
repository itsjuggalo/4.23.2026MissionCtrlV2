package X2;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Q extends P {
    public static Set b() {
        return B.f5579a;
    }

    public static Set c(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return (Set) AbstractC0765l.d0(elements, new LinkedHashSet(K.b(elements.length)));
    }

    public static final Set d(Set set) {
        kotlin.jvm.internal.r.f(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : P.a(set.iterator().next()) : b();
    }

    public static Set e(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return AbstractC0765l.s0(elements);
    }

    public static Set f(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return (Set) AbstractC0765l.u(elements, new LinkedHashSet());
    }
}
