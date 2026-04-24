package androidx.datastore.preferences.protobuf;

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

/* JADX INFO: loaded from: classes.dex */
public final class X extends AbstractMap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f4522f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f4523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f4524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile a0 f4526d;
    public Map e;

    public static X g() {
        X x6 = new X();
        x6.f4523a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        x6.f4524b = map;
        x6.e = map;
        return x6;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f4523a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f4523a
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.Y r2 = (androidx.datastore.preferences.protobuf.Y) r2
            java.lang.Comparable r2 = r2.f4527a
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
            java.util.List r3 = r4.f4523a
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.Y r3 = (androidx.datastore.preferences.protobuf.Y) r3
            java.lang.Comparable r3 = r3.f4527a
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.X.a(java.lang.Comparable):int");
    }

    public final void c() {
        if (this.f4525c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        c();
        if (!this.f4523a.isEmpty()) {
            this.f4523a.clear();
        }
        if (this.f4524b.isEmpty()) {
            return;
        }
        this.f4524b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f4524b.containsKey(comparable);
    }

    public final Map.Entry d(int i) {
        return (Map.Entry) this.f4523a.get(i);
    }

    public final Set e() {
        return this.f4524b.isEmpty() ? Collections.EMPTY_SET : this.f4524b.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f4526d == null) {
            this.f4526d = new a0(this, 0);
        }
        return this.f4526d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X)) {
            return super.equals(obj);
        }
        X x6 = (X) obj;
        int size = size();
        if (size == x6.size()) {
            int size2 = this.f4523a.size();
            if (size2 != x6.f4523a.size()) {
                return ((AbstractSet) entrySet()).equals(x6.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (d(i).equals(x6.d(i))) {
                }
            }
            if (size2 != size) {
                return this.f4524b.equals(x6.f4524b);
            }
            return true;
        }
        return false;
    }

    public final SortedMap f() {
        c();
        if (this.f4524b.isEmpty() && !(this.f4524b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f4524b = treeMap;
            this.e = treeMap.descendingMap();
        }
        return (SortedMap) this.f4524b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((Y) this.f4523a.get(iA)).f4528b : this.f4524b.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        c();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((Y) this.f4523a.get(iA)).setValue(obj);
        }
        c();
        if (this.f4523a.isEmpty() && !(this.f4523a instanceof ArrayList)) {
            this.f4523a = new ArrayList(16);
        }
        int i = -(iA + 1);
        if (i >= 16) {
            return f().put(comparable, obj);
        }
        if (this.f4523a.size() == 16) {
            Y y = (Y) this.f4523a.remove(15);
            f().put(y.f4527a, y.f4528b);
        }
        this.f4523a.add(i, new Y(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f4523a.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((Y) this.f4523a.get(i)).hashCode();
        }
        return this.f4524b.size() > 0 ? this.f4524b.hashCode() + iHashCode : iHashCode;
    }

    public final Object i(int i) {
        c();
        Object obj = ((Y) this.f4523a.remove(i)).f4528b;
        if (!this.f4524b.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            List list = this.f4523a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new Y(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        c();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return i(iA);
        }
        if (this.f4524b.isEmpty()) {
            return null;
        }
        return this.f4524b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f4524b.size() + this.f4523a.size();
    }
}
