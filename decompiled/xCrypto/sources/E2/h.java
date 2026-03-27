package E2;

import C2.C;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static Map a(e eVar) {
        C cB = eVar.b();
        if (cB == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("sql", cB.c());
        map.put("arguments", cB.b());
        return map;
    }
}
