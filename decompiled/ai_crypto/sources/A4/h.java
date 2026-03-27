package A4;

import java.util.HashMap;
import java.util.Map;
import y4.C;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static Map a(e eVar) {
        C cD = eVar.d();
        if (cD == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("sql", cD.c());
        map.put("arguments", cD.b());
        return map;
    }
}
