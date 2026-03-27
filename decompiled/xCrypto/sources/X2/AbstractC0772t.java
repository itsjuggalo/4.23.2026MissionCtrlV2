package X2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: X2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0772t extends AbstractC0771s {
    public static final void s(List list, Comparator comparator) {
        kotlin.jvm.internal.r.f(list, "<this>");
        kotlin.jvm.internal.r.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
