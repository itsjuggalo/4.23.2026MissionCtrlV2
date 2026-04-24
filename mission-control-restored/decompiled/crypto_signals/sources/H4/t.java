package H4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class t extends D1.b {
    public static Object O(Map map, Object obj) {
        kotlin.jvm.internal.j.e(map, "<this>");
        if (map instanceof s) {
            return ((s) map).b();
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static int P(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
    }

    public static Map Q(G4.f pair) {
        kotlin.jvm.internal.j.e(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.f529a, pair.f530b);
        kotlin.jvm.internal.j.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static Map R(G4.f... fVarArr) {
        if (fVarArr.length <= 0) {
            return q.f578a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(fVarArr.length));
        T(linkedHashMap, fVarArr);
        return linkedHashMap;
    }

    public static LinkedHashMap S(G4.f... fVarArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(fVarArr.length));
        T(linkedHashMap, fVarArr);
        return linkedHashMap;
    }

    public static final void T(LinkedHashMap linkedHashMap, G4.f[] fVarArr) {
        for (G4.f fVar : fVarArr) {
            linkedHashMap.put(fVar.f529a, fVar.f530b);
        }
    }

    public static Map U(ArrayList arrayList) {
        q qVar = q.f578a;
        int size = arrayList.size();
        if (size == 0) {
            return qVar;
        }
        if (size == 1) {
            return Q((G4.f) arrayList.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(P(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            G4.f fVar = (G4.f) it.next();
            linkedHashMap.put(fVar.f529a, fVar.f530b);
        }
        return linkedHashMap;
    }

    public static Map V(Map map) {
        kotlin.jvm.internal.j.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return q.f578a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        kotlin.jvm.internal.j.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.j.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
