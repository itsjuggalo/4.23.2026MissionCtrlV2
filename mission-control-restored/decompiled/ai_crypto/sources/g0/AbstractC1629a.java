package g0;

import F5.v;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1629a {
    public static final Set a(Set set) {
        r.f(set, "set");
        Set setUnmodifiableSet = Collections.unmodifiableSet(v.m0(set));
        r.e(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final Map b(Map map) {
        r.f(map, "map");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        r.e(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }
}
