package i6;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: i6.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1994r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f18929a;

    public C1994r0(Map map) {
        AbstractC2304t.f(map, "map");
        this.f18929a = map;
    }

    public final C1994r0 a() {
        Map map = this.f18929a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(p5.L.d(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), C1973h.c((C1973h) entry.getValue(), null, null, false, true, 7, null));
        }
        return new C1994r0(linkedHashMap);
    }

    public final Map b() {
        return this.f18929a;
    }
}
