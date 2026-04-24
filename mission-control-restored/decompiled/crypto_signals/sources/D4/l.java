package D4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Map {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f310a = new HashMap();

    public final double a() {
        HashMap map = this.f310a;
        if (map.isEmpty()) {
            return 0.0d;
        }
        Iterator it = map.values().iterator();
        int i = 0;
        int i6 = 0;
        while (it.hasNext()) {
            i6++;
            if (((k) it.next()).d()) {
                i++;
            }
        }
        return (((double) i) / ((double) i6)) * 100.0d;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f310a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f310a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f310a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.f310a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || this.f310a.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f310a.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f310a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f310a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.f310a.keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f310a.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f310a.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f310a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f310a.size();
    }

    public final String toString() {
        return this.f310a.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f310a.values();
    }
}
