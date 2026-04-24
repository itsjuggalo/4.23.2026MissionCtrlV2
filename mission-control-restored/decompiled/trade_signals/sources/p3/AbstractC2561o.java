package p3;

import e3.AbstractC1666c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: p3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2561o {
    public static InterfaceC2560n a(Object obj) {
        return b(obj, AbstractC2564r.a());
    }

    public static InterfaceC2560n b(Object obj, InterfaceC2560n interfaceC2560n) {
        HashMap map;
        try {
            if (obj instanceof Map) {
                Map map2 = (Map) obj;
                if (map2.containsKey(".priority")) {
                    interfaceC2560n = AbstractC2564r.d(map2.get(".priority"));
                }
                if (map2.containsKey(".value")) {
                    obj = map2.get(".value");
                }
            }
            if (obj == null) {
                return C2553g.M();
            }
            if (obj instanceof String) {
                return new C2566t((String) obj, interfaceC2560n);
            }
            if (obj instanceof Long) {
                return new C2558l((Long) obj, interfaceC2560n);
            }
            if (obj instanceof Integer) {
                return new C2558l(Long.valueOf(((Integer) obj).intValue()), interfaceC2560n);
            }
            if (obj instanceof Double) {
                return new C2552f((Double) obj, interfaceC2560n);
            }
            if (obj instanceof Boolean) {
                return new C2547a((Boolean) obj, interfaceC2560n);
            }
            if (!(obj instanceof Map) && !(obj instanceof List)) {
                throw new c3.d("Failed to parse node with class " + obj.getClass().toString());
            }
            if (obj instanceof Map) {
                Map map3 = (Map) obj;
                if (map3.containsKey(".sv")) {
                    return new C2551e(map3, interfaceC2560n);
                }
                map = new HashMap(map3.size());
                for (String str : map3.keySet()) {
                    if (!str.startsWith(".")) {
                        InterfaceC2560n interfaceC2560nA = a(map3.get(str));
                        if (!interfaceC2560nA.isEmpty()) {
                            map.put(C2548b.i(str), interfaceC2560nA);
                        }
                    }
                }
            } else {
                List list = (List) obj;
                map = new HashMap(list.size());
                for (int i8 = 0; i8 < list.size(); i8++) {
                    String str2 = "" + i8;
                    InterfaceC2560n interfaceC2560nA2 = a(list.get(i8));
                    if (!interfaceC2560nA2.isEmpty()) {
                        map.put(C2548b.i(str2), interfaceC2560nA2);
                    }
                }
            }
            return map.isEmpty() ? C2553g.M() : new C2549c(AbstractC1666c.a.d(map, C2549c.f22267d), interfaceC2560n);
        } catch (ClassCastException e8) {
            throw new c3.d("Failed to parse node", e8);
        }
    }

    public static int c(C2548b c2548b, InterfaceC2560n interfaceC2560n, C2548b c2548b2, InterfaceC2560n interfaceC2560n2) {
        int iCompareTo = interfaceC2560n.compareTo(interfaceC2560n2);
        return iCompareTo != 0 ? iCompareTo : c2548b.compareTo(c2548b2);
    }
}
