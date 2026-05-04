package we;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24033a;

    public q1(Map map) {
        kotlin.jvm.internal.t.f(map, "map");
        this.f24033a = map;
    }

    public final q1 a() {
        Map map = this.f24033a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(dd.n0.d(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), h.c((h) entry.getValue(), null, null, false, true, 7, null));
        }
        return new q1(linkedHashMap);
    }

    public final Map b() {
        return this.f24033a;
    }
}
