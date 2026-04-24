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
public abstract class b0 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f6970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile f f6973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f6974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile c f6975f;

    public class a extends b0 {
        public a() {
            super(null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.s((Comparable) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public void q() {
            if (!p()) {
                if (l() > 0) {
                    android.support.v4.media.session.b.a(k(0).getKey());
                    throw null;
                }
                Iterator it = n().iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.b.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            }
            super.q();
        }
    }

    public class c extends f {
        public c() {
            super(b0.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.b0.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(b0.this, null);
        }

        public /* synthetic */ c(b0 b0Var, a aVar) {
            this();
        }
    }

    public class d implements Map.Entry, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f6980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f6981b;

        public d(b0 b0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        public final boolean c(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return c(this.f6980a, entry.getKey()) && c(this.f6981b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f6980a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f6981b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f6980a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f6981b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            b0.this.h();
            Object obj2 = this.f6981b;
            this.f6981b = obj;
            return obj2;
        }

        public String toString() {
            return this.f6980a + com.amazon.a.a.o.b.f.f8805b + this.f6981b;
        }

        public d(Comparable comparable, Object obj) {
            this.f6980a = comparable;
            this.f6981b = obj;
        }
    }

    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            b0.this.s((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = b0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(b0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            b0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b0.this.size();
        }

        public /* synthetic */ f(b0 b0Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ b0(a aVar) {
        this();
    }

    public static b0 r() {
        return new a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f6970a.isEmpty()) {
            this.f6970a.clear();
        }
        if (this.f6971b.isEmpty()) {
            return;
        }
        this.f6971b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f6971b.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f6973d == null) {
            this.f6973d = new f(this, null);
        }
        return this.f6973d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return super.equals(obj);
        }
        b0 b0Var = (b0) obj;
        int size = size();
        if (size != b0Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != b0Var.l()) {
            return entrySet().equals(b0Var.entrySet());
        }
        for (int i4 = 0; i4 < iL; i4++) {
            if (!k(i4).equals(b0Var.k(i4))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f6971b.equals(b0Var.f6971b);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f6970a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f6970a
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.b0$d r2 = (androidx.datastore.preferences.protobuf.b0.d) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r5 = -r0
            return r5
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f6970a
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.b0$d r3 = (androidx.datastore.preferences.protobuf.b0.d) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.b0.g(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? ((d) this.f6970a.get(iG)).getValue() : this.f6971b.get(comparable);
    }

    public final void h() {
        if (this.f6972c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i4 = 0; i4 < iL; i4++) {
            iHashCode += ((d) this.f6970a.get(i4)).hashCode();
        }
        return m() > 0 ? iHashCode + this.f6971b.hashCode() : iHashCode;
    }

    public Set i() {
        if (this.f6975f == null) {
            this.f6975f = new c(this, null);
        }
        return this.f6975f;
    }

    public final void j() {
        h();
        if (!this.f6970a.isEmpty() || (this.f6970a instanceof ArrayList)) {
            return;
        }
        this.f6970a = new ArrayList(16);
    }

    public Map.Entry k(int i4) {
        return (Map.Entry) this.f6970a.get(i4);
    }

    public int l() {
        return this.f6970a.size();
    }

    public int m() {
        return this.f6971b.size();
    }

    public Iterable n() {
        return this.f6971b.isEmpty() ? Collections.EMPTY_SET : this.f6971b.entrySet();
    }

    public final SortedMap o() {
        h();
        if (this.f6971b.isEmpty() && !(this.f6971b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f6971b = treeMap;
            this.f6974e = treeMap.descendingMap();
        }
        return (SortedMap) this.f6971b;
    }

    public boolean p() {
        return this.f6972c;
    }

    public void q() {
        if (this.f6972c) {
            return;
        }
        this.f6971b = this.f6971b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f6971b);
        this.f6974e = this.f6974e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f6974e);
        this.f6972c = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return t(iG);
        }
        if (this.f6971b.isEmpty()) {
            return null;
        }
        return this.f6971b.remove(comparable);
    }

    public Object s(Comparable comparable, Object obj) {
        h();
        int iG = g(comparable);
        if (iG >= 0) {
            return ((d) this.f6970a.get(iG)).setValue(obj);
        }
        j();
        int i4 = -(iG + 1);
        if (i4 >= 16) {
            return o().put(comparable, obj);
        }
        if (this.f6970a.size() == 16) {
            d dVar = (d) this.f6970a.remove(15);
            o().put(dVar.getKey(), dVar.getValue());
        }
        this.f6970a.add(i4, new d(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f6970a.size() + this.f6971b.size();
    }

    public final Object t(int i4) {
        h();
        Object value = ((d) this.f6970a.remove(i4)).getValue();
        if (!this.f6971b.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f6970a.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f6977b;

        public b() {
            this.f6976a = b0.this.f6970a.size();
        }

        public final Iterator b() {
            if (this.f6977b == null) {
                this.f6977b = b0.this.f6974e.entrySet().iterator();
            }
            return this.f6977b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (b().hasNext()) {
                return (Map.Entry) b().next();
            }
            List list = b0.this.f6970a;
            int i4 = this.f6976a - 1;
            this.f6976a = i4;
            return (Map.Entry) list.get(i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i4 = this.f6976a;
            return (i4 > 0 && i4 <= b0.this.f6970a.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(b0 b0Var, a aVar) {
            this();
        }
    }

    public class e implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f6985c;

        public e() {
            this.f6983a = -1;
        }

        public final Iterator b() {
            if (this.f6985c == null) {
                this.f6985c = b0.this.f6971b.entrySet().iterator();
            }
            return this.f6985c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f6984b = true;
            int i4 = this.f6983a + 1;
            this.f6983a = i4;
            return i4 < b0.this.f6970a.size() ? (Map.Entry) b0.this.f6970a.get(this.f6983a) : (Map.Entry) b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6983a + 1 < b0.this.f6970a.size() || (!b0.this.f6971b.isEmpty() && b().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f6984b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f6984b = false;
            b0.this.h();
            if (this.f6983a >= b0.this.f6970a.size()) {
                b().remove();
                return;
            }
            b0 b0Var = b0.this;
            int i4 = this.f6983a;
            this.f6983a = i4 - 1;
            b0Var.t(i4);
        }

        public /* synthetic */ e(b0 b0Var, a aVar) {
            this();
        }
    }

    public b0() {
        this.f6970a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f6971b = map;
        this.f6974e = map;
    }
}
