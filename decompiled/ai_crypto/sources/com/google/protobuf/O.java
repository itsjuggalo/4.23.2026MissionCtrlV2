package com.google.protobuf;

import com.google.protobuf.C;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class O extends LinkedHashMap {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f12597b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12598a;

    static {
        O o7 = new O();
        f12597b = o7;
        o7.k();
    }

    public O() {
        this.f12598a = true;
    }

    public static int a(Map map) {
        int iC = 0;
        for (Map.Entry entry : map.entrySet()) {
            iC += c(entry.getValue()) ^ c(entry.getKey());
        }
        return iC;
    }

    public static int c(Object obj) {
        if (obj instanceof byte[]) {
            return C.d((byte[]) obj);
        }
        if (obj instanceof C.a) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static void d(Map map) {
        for (Object obj : map.keySet()) {
            C.a(obj);
            C.a(map.get(obj));
        }
    }

    public static O e() {
        return f12597b;
    }

    public static boolean g(Object obj, Object obj2) {
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
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && i(this, (Map) obj);
    }

    public final void f() {
        if (!j()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return a(this);
    }

    public boolean j() {
        return this.f12598a;
    }

    public void k() {
        this.f12598a = false;
    }

    public void l(O o7) {
        f();
        if (o7.isEmpty()) {
            return;
        }
        putAll(o7);
    }

    public O m() {
        return isEmpty() ? new O() : new O(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        f();
        C.a(obj);
        C.a(obj2);
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

    public O(Map map) {
        super(map);
        this.f12598a = true;
    }
}
