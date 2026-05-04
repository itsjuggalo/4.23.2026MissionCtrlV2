package r8;

import g8.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static n a(Object obj) {
        return b(obj, r.a());
    }

    public static n b(Object obj, n nVar) {
        HashMap map;
        try {
            if (obj instanceof Map) {
                Map map2 = (Map) obj;
                if (map2.containsKey(".priority")) {
                    nVar = r.d(map2.get(".priority"));
                }
                if (map2.containsKey(".value")) {
                    obj = map2.get(".value");
                }
            }
            if (obj == null) {
                return g.y();
            }
            if (obj instanceof String) {
                return new t((String) obj, nVar);
            }
            if (obj instanceof Long) {
                return new l((Long) obj, nVar);
            }
            if (obj instanceof Integer) {
                return new l(Long.valueOf(((Integer) obj).intValue()), nVar);
            }
            if (obj instanceof Double) {
                return new f((Double) obj, nVar);
            }
            if (obj instanceof Boolean) {
                return new a((Boolean) obj, nVar);
            }
            if (!(obj instanceof Map) && !(obj instanceof List)) {
                throw new e8.d("Failed to parse node with class " + obj.getClass().toString());
            }
            if (obj instanceof Map) {
                Map map3 = (Map) obj;
                if (map3.containsKey(".sv")) {
                    return new e(map3, nVar);
                }
                map = new HashMap(map3.size());
                for (String str : map3.keySet()) {
                    if (!str.startsWith(".")) {
                        n nVarA = a(map3.get(str));
                        if (!nVarA.isEmpty()) {
                            map.put(b.h(str), nVarA);
                        }
                    }
                }
            } else {
                List list = (List) obj;
                map = new HashMap(list.size());
                for (int i10 = 0; i10 < list.size(); i10++) {
                    String str2 = "" + i10;
                    n nVarA2 = a(list.get(i10));
                    if (!nVarA2.isEmpty()) {
                        map.put(b.h(str2), nVarA2);
                    }
                }
            }
            return map.isEmpty() ? g.y() : new c(c.a.d(map, c.f19391d), nVar);
        } catch (ClassCastException e10) {
            throw new e8.d("Failed to parse node", e10);
        }
    }

    public static int c(b bVar, n nVar, b bVar2, n nVar2) {
        int iCompareTo = nVar.compareTo(nVar2);
        return iCompareTo != 0 ? iCompareTo : bVar.compareTo(bVar2);
    }
}
