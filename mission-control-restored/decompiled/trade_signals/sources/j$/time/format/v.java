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
    private final Map f19790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f19791b;

    v(Map map) {
        this.f19790a = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l8 = (Long) entry2.getKey();
                int i8 = b.f19740c;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l8));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, b.f19739b);
            map2.put((A) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, b.f19739b);
        this.f19791b = map2;
    }

    final String a(long j8, A a8) {
        Map map = (Map) this.f19790a.get(a8);
        if (map != null) {
            return (String) map.get(Long.valueOf(j8));
        }
        return null;
    }

    final Iterator b(A a8) {
        List list = (List) this.f19791b.get(a8);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
