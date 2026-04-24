package S6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final void a(Collection collection, Object obj) {
        AbstractC2304t.f(collection, "<this>");
        if (obj != null) {
            collection.add(obj);
        }
    }

    public static final int b(int i8) {
        if (i8 < 3) {
            return 3;
        }
        return i8 + (i8 / 3) + 1;
    }

    public static final List c(ArrayList arrayList) {
        AbstractC2304t.f(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return AbstractC2595q.i();
        }
        if (size == 1) {
            return AbstractC2594p.e(z.Y(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final Map d(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = iterable.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i8));
            i8++;
        }
        return linkedHashMap;
    }

    public static final HashMap e(int i8) {
        return new HashMap(b(i8));
    }

    public static final HashSet f(int i8) {
        return new HashSet(b(i8));
    }

    public static final LinkedHashSet g(int i8) {
        return new LinkedHashSet(b(i8));
    }
}
