package com.google.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.google.protobuf.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0492v0 extends AbstractMap {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f5807k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f5809b = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f5810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5811d;
    public volatile androidx.datastore.preferences.protobuf.a0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f5812f;

    public C0492v0(int i) {
        this.f5808a = i;
        Map map = Collections.EMPTY_MAP;
        this.f5810c = map;
        this.f5812f = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f5809b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f5809b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.z0 r2 = (com.google.protobuf.z0) r2
            java.lang.Comparable r2 = r2.f5824a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f5809b
            java.lang.Object r3 = r3.get(r2)
            com.google.protobuf.z0 r3 = (com.google.protobuf.z0) r3
            java.lang.Comparable r3 = r3.f5824a
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0492v0.a(java.lang.Comparable):int");
    }

    public final void c() {
        if (this.f5811d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        c();
        if (!this.f5809b.isEmpty()) {
            this.f5809b.clear();
        }
        if (this.f5810c.isEmpty()) {
            return;
        }
        this.f5810c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f5810c.containsKey(comparable);
    }

    public final Map.Entry d(int i) {
        return (Map.Entry) this.f5809b.get(i);
    }

    public final Iterable e() {
        return this.f5810c.isEmpty() ? y0.f5819b : this.f5810c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new androidx.datastore.preferences.protobuf.a0(this, 1);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0492v0)) {
            return super.equals(obj);
        }
        C0492v0 c0492v0 = (C0492v0) obj;
        int size = size();
        if (size == c0492v0.size()) {
            int size2 = this.f5809b.size();
            if (size2 != c0492v0.f5809b.size()) {
                return ((AbstractSet) entrySet()).equals(c0492v0.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (d(i).equals(c0492v0.d(i))) {
                }
            }
            if (size2 != size) {
                return this.f5810c.equals(c0492v0.f5810c);
            }
            return true;
        }
        return false;
    }

    public final SortedMap f() {
        c();
        if (this.f5810c.isEmpty() && !(this.f5810c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f5810c = treeMap;
            this.f5812f = treeMap.descendingMap();
        }
        return (SortedMap) this.f5810c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        c();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((z0) this.f5809b.get(iA)).setValue(obj);
        }
        c();
        boolean zIsEmpty = this.f5809b.isEmpty();
        int i = this.f5808a;
        if (zIsEmpty && !(this.f5809b instanceof ArrayList)) {
            this.f5809b = new ArrayList(i);
        }
        int i6 = -(iA + 1);
        if (i6 >= i) {
            return f().put(comparable, obj);
        }
        if (this.f5809b.size() == i) {
            z0 z0Var = (z0) this.f5809b.remove(i - 1);
            f().put(z0Var.f5824a, z0Var.f5825b);
        }
        this.f5809b.add(i6, new z0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((z0) this.f5809b.get(iA)).f5825b : this.f5810c.get(comparable);
    }

    public final Object h(int i) {
        c();
        Object obj = ((z0) this.f5809b.remove(i)).f5825b;
        if (!this.f5810c.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            List list = this.f5809b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new z0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f5809b.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((z0) this.f5809b.get(i)).hashCode();
        }
        return this.f5810c.size() > 0 ? this.f5810c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        c();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f5810c.isEmpty()) {
            return null;
        }
        return this.f5810c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5810c.size() + this.f5809b.size();
    }
}
