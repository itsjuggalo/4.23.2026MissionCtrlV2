package x;

import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f24105a;

    public c(int i8, float f8) {
        this.f24105a = new LinkedHashMap(i8, f8, true);
    }

    public final Object a(Object key) {
        AbstractC2304t.f(key, "key");
        return this.f24105a.get(key);
    }

    public final Set b() {
        Set setEntrySet = this.f24105a.entrySet();
        AbstractC2304t.e(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean c() {
        return this.f24105a.isEmpty();
    }

    public final Object d(Object key, Object value) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        return this.f24105a.put(key, value);
    }

    public final Object e(Object key) {
        AbstractC2304t.f(key, "key");
        return this.f24105a.remove(key);
    }
}
