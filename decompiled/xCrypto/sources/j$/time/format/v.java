package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f13254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f13255b;

    v(Map map) {
        this.f13254a = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l4 = (Long) entry2.getKey();
                int i4 = b.f13204c;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l4));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, b.f13203b);
            map2.put((A) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, b.f13203b);
        this.f13255b = map2;
    }

    final String a(long j4, A a4) {
        Map map = (Map) this.f13254a.get(a4);
        if (map != null) {
            return (String) map.get(Long.valueOf(j4));
        }
        return null;
    }

    final Iterator b(A a4) {
        List list = (List) this.f13255b.get(a4);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
