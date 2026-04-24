package g0;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;

/* JADX INFO: renamed from: g0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1771a {
    public static final Set a(Set set) {
        AbstractC2304t.f(set, "set");
        Set setUnmodifiableSet = Collections.unmodifiableSet(z.K0(set));
        AbstractC2304t.e(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final Map b(Map map) {
        AbstractC2304t.f(map, "map");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        AbstractC2304t.e(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }
}
