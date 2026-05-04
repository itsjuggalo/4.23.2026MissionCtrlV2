package fd;

import kotlin.jvm.internal.t;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static int a(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static int b(Object obj, Object obj2, k... selectors) {
        t.f(selectors, "selectors");
        if (selectors.length > 0) {
            return c(obj, obj2, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final int c(Object obj, Object obj2, k[] kVarArr) {
        for (k kVar : kVarArr) {
            int iA = a((Comparable) kVar.invoke(obj), (Comparable) kVar.invoke(obj2));
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }
}
