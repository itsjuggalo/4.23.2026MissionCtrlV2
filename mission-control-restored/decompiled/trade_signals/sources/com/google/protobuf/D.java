package com.google.protobuf;

import com.google.protobuf.AbstractC1481u;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class D extends LinkedHashMap {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D f16286b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16287a;

    static {
        D d8 = new D();
        f16286b = d8;
        d8.k();
    }

    public D() {
        this.f16287a = true;
    }

    public static int b(Map map) {
        int iC = 0;
        for (Map.Entry entry : map.entrySet()) {
            iC += c(entry.getValue()) ^ c(entry.getKey());
        }
        return iC;
    }

    public static int c(Object obj) {
        if (obj instanceof byte[]) {
            return AbstractC1481u.d((byte[]) obj);
        }
        if (obj instanceof AbstractC1481u.a) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static void d(Map map) {
        for (Object obj : map.keySet()) {
            AbstractC1481u.a(obj);
            AbstractC1481u.a(map.get(obj));
        }
    }

    public static D e() {
        return f16286b;
    }

    public static boolean h(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    public static boolean i(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !h(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && i(this, (Map) obj);
    }

    public final void g() {
        if (!j()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return b(this);
    }

    public boolean j() {
        return this.f16287a;
    }

    public void k() {
        this.f16287a = false;
    }

    public void l(D d8) {
        g();
        if (d8.isEmpty()) {
            return;
        }
        putAll(d8);
    }

    public D m() {
        return isEmpty() ? new D() : new D(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        g();
        AbstractC1481u.a(obj);
        AbstractC1481u.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        g();
        d(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        return super.remove(obj);
    }

    public D(Map map) {
        super(map);
        this.f16287a = true;
    }
}
