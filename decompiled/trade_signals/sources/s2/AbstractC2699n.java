package s2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import t2.C2742i;

/* JADX INFO: renamed from: s2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2699n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f23081a;

    static {
        new HashSet(Arrays.asList("native", "unity"));
        f23081a = new HashMap();
        new C2742i("PlayCoreVersion");
    }

    public static synchronized Map a() {
        Map map;
        map = f23081a;
        map.put("java", 20002);
        return map;
    }
}
