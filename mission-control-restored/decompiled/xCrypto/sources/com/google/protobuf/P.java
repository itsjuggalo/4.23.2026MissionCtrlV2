package com.google.protobuf;

import com.google.protobuf.C;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class P extends LinkedHashMap {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final P f10972b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10973a;

    static {
        P p4 = new P();
        f10972b = p4;
        p4.j();
    }

    public P() {
        this.f10973a = true;
    }

    public static int a(Map map) {
        int iB = 0;
        for (Map.Entry entry : map.entrySet()) {
            iB += b(entry.getValue()) ^ b(entry.getKey());
        }
        return iB;
    }

    public static int b(Object obj) {
        if (obj instanceof byte[]) {
            return C.d((byte[]) obj);
        }
        if (obj instanceof C.c) {
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

    public static P e() {
        return f10972b;
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
        return this.f10973a;
    }

    public void j() {
        this.f10973a = false;
    }

    public void k(P p4) {
        f();
        if (p4.isEmpty()) {
            return;
        }
        putAll(p4);
    }

    public P l() {
        return isEmpty() ? new P() : new P(this);
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

    public P(Map map) {
        super(map);
        this.f10973a = true;
    }
}
