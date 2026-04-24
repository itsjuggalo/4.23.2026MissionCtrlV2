package n2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: n2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2408o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f21583a = new HashSet(Arrays.asList("app_update", "review"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f21584b = new HashSet(Arrays.asList("native", "unity"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f21585c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2412s f21586d = new C2412s("PlayCoreVersion");

    public static synchronized Map a(String str) {
        Map map;
        try {
            map = f21585c;
            if (!map.containsKey("app_update")) {
                HashMap map2 = new HashMap();
                map2.put("java", 11004);
                map.put("app_update", map2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) map.get("app_update");
    }
}
