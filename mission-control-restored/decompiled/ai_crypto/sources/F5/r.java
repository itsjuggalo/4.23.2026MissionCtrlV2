package F5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends AbstractC0559q {
    public static final void s(List list, Comparator comparator) {
        kotlin.jvm.internal.r.f(list, "<this>");
        kotlin.jvm.internal.r.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
