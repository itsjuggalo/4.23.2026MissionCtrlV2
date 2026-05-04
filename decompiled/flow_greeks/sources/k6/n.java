package k6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f14745a;

    static {
        new HashSet(Arrays.asList("native", "unity"));
        f14745a = new HashMap();
        new l6.i("PlayCoreVersion");
    }

    public static synchronized Map a() {
        Map map;
        map = f14745a;
        map.put("java", 20002);
        return map;
    }
}
