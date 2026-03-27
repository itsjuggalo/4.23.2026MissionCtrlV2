package x4;

import java.util.HashMap;
import java.util.Map;
import v4.C2865E;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static Map a(e eVar) {
        C2865E c2865eB = eVar.b();
        if (c2865eB == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("sql", c2865eB.c());
        map.put("arguments", c2865eB.b());
        return map;
    }
}
