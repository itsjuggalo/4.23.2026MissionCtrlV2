package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f17213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f17214b;

    v(Map map) {
        this.f17213a = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l7 = (Long) entry2.getKey();
                int i7 = b.f17163c;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l7));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, b.f17162b);
            map2.put((A) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, b.f17162b);
        this.f17214b = map2;
    }

    final String a(long j7, A a7) {
        Map map = (Map) this.f17213a.get(a7);
        if (map != null) {
            return (String) map.get(Long.valueOf(j7));
        }
        return null;
    }

    final Iterator b(A a7) {
        List list = (List) this.f17214b.get(a7);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
