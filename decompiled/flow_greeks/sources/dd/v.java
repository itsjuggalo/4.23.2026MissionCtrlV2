package dd;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v extends u {
    public static final void x(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void y(List list, Comparator comparator) {
        kotlin.jvm.internal.t.f(list, "<this>");
        kotlin.jvm.internal.t.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
