package p5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends AbstractC2597t {
    public static final void v(List list) {
        AbstractC2304t.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void w(List list, Comparator comparator) {
        AbstractC2304t.f(list, "<this>");
        AbstractC2304t.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
