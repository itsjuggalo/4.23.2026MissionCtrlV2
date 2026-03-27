package p5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends AbstractC2595q {
    public static int s(Iterable iterable, int i8) {
        AbstractC2304t.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i8;
    }

    public static final Integer t(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static List u(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            v.x(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }
}
