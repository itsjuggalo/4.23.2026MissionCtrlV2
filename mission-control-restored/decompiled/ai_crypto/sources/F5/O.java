package F5;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class O extends N {
    public static Set b() {
        return z.f2386a;
    }

    public static Set c(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return (Set) AbstractC0552j.c0(elements, new LinkedHashSet(I.b(elements.length)));
    }

    public static final Set d(Set set) {
        kotlin.jvm.internal.r.f(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : N.a(set.iterator().next()) : b();
    }

    public static Set e(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return AbstractC0552j.r0(elements);
    }

    public static Set f(Object... elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return (Set) AbstractC0552j.t(elements, new LinkedHashSet());
    }
}
