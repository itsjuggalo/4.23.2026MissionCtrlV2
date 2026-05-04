package x;

import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f24123a;

    public c(int i10, float f10) {
        this.f24123a = new LinkedHashMap(i10, f10, true);
    }

    public final Object a(Object key) {
        t.f(key, "key");
        return this.f24123a.get(key);
    }

    public final Set b() {
        Set setEntrySet = this.f24123a.entrySet();
        t.e(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean c() {
        return this.f24123a.isEmpty();
    }

    public final Object d(Object key, Object value) {
        t.f(key, "key");
        t.f(value, "value");
        return this.f24123a.put(key, value);
    }

    public final Object e(Object key) {
        t.f(key, "key");
        return this.f24123a.remove(key);
    }
}
