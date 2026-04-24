package e0;

import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.L;
import p5.z;

/* JADX INFO: renamed from: e0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1660c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f17136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f17137b;

    public C1660c(SharedPreferences prefs, Set set) {
        AbstractC2304t.f(prefs, "prefs");
        this.f17136a = prefs;
        this.f17137b = set;
    }

    public final Map a() {
        Map<String, ?> all = this.f17136a.getAll();
        AbstractC2304t.e(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Set set = this.f17137b;
            if (set != null ? set.contains(key) : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(L.d(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Set) {
                value = z.K0((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        return linkedHashMap2;
    }
}
