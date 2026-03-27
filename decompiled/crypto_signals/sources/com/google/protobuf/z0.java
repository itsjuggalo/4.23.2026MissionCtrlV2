package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f5824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0492v0 f5826c;

    public z0(C0492v0 c0492v0, Comparable comparable, Object obj) {
        this.f5826c = c0492v0;
        this.f5824a = comparable;
        this.f5825b = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f5824a.compareTo(((z0) obj).f5824a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f5824a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f5825b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5824a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5825b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f5824a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f5825b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f5826c.c();
        Object obj2 = this.f5825b;
        this.f5825b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f5824a + "=" + this.f5825b;
    }
}
