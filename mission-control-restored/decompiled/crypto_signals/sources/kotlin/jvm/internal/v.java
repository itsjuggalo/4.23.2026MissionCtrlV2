package kotlin.jvm.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static Map a(HashMap map) {
        if (!(map instanceof S4.a) || (map instanceof S4.b)) {
            return map;
        }
        d(map, "kotlin.collections.MutableMap");
        throw null;
    }

    public static void b(int i, Object obj) {
        if (obj == null || c(i, obj)) {
            return;
        }
        d(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean c(int i, Object obj) {
        if (obj instanceof G4.a) {
            if ((obj instanceof g ? ((g) obj).getArity() : obj instanceof R4.a ? 0 : obj instanceof R4.l ? 1 : obj instanceof R4.p ? 2 : obj instanceof R4.q ? 3 : -1) == i) {
                return true;
            }
        }
        return false;
    }

    public static void d(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(a3.d.k(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        j.g(classCastException, v.class.getName());
        throw classCastException;
    }
}
