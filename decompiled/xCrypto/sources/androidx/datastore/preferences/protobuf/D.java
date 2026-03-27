package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class D extends LinkedHashMap {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D f6921b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6922a;

    static {
        D d4 = new D();
        f6921b = d4;
        d4.j();
    }

    public D() {
        this.f6922a = true;
    }

    public static int a(Map map) {
        int iB = 0;
        for (Map.Entry entry : map.entrySet()) {
            iB += b(entry.getValue()) ^ b(entry.getKey());
        }
        return iB;
    }

    public static int b(Object obj) {
        return obj instanceof byte[] ? AbstractC0807u.d((byte[]) obj) : obj.hashCode();
    }

    public static void d(Map map) {
        for (Object obj : map.keySet()) {
            AbstractC0807u.a(obj);
            AbstractC0807u.a(map.get(obj));
        }
    }

    public static D e() {
        return f6921b;
    }

    public static boolean g(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    public static boolean h(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !g(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && h(this, (Map) obj);
    }

    public final void f() {
        if (!i()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return a(this);
    }

    public boolean i() {
        return this.f6922a;
    }

    public void j() {
        this.f6922a = false;
    }

    public void k(D d4) {
        f();
        if (d4.isEmpty()) {
            return;
        }
        putAll(d4);
    }

    public D l() {
        return isEmpty() ? new D() : new D(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        f();
        AbstractC0807u.a(obj);
        AbstractC0807u.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        f();
        d(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        f();
        return super.remove(obj);
    }

    public D(Map map) {
        super(map);
        this.f6922a = true;
    }
}
