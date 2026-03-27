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
    public List f11190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f11191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile f f11193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f11194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile c f11195f;

    public class a extends b0 {
        public a() {
            super(null);
        }

        @Override // androidx.datastore.preferences.protobuf.b0
        public void p() {
            if (!o()) {
                if (k() > 0) {
                    android.support.v4.media.session.b.a(j(0).getKey());
                    throw null;
                }
                Iterator it = m().iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.b.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            }
            super.p();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.r((Comparable) obj, obj2);
        }
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f11197b;

        public b() {
            this.f11196a = b0.this.f11190a.size();
        }

        public final Iterator b() {
            if (this.f11197b == null) {
                this.f11197b = b0.this.f11194e.entrySet().iterator();
            }
            return this.f11197b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Object next;
            if (b().hasNext()) {
                next = b().next();
            } else {
                List list = b0.this.f11190a;
                int i8 = this.f11196a - 1;
                this.f11196a = i8;
                next = list.get(i8);
            }
            return (Map.Entry) next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i8 = this.f11196a;
            return (i8 > 0 && i8 <= b0.this.f11190a.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(b0 b0Var, a aVar) {
            this();
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
        public final Comparable f11200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11201b;

        public d(Comparable comparable, Object obj) {
            this.f11200a = comparable;
            this.f11201b = obj;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return getKey().compareTo(dVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
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
            return b(this.f11200a, entry.getKey()) && b(this.f11201b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f11200a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f11201b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f11200a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f11201b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            b0.this.g();
            Object obj2 = this.f11201b;
            this.f11201b = obj;
            return obj2;
        }

        public String toString() {
            return this.f11200a + com.amazon.a.a.o.b.f.f14101b + this.f11201b;
        }

        public d(b0 b0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }
    }

    public class e implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f11205c;

        public e() {
            this.f11203a = -1;
        }

        public final Iterator b() {
            if (this.f11205c == null) {
                this.f11205c = b0.this.f11191b.entrySet().iterator();
            }
            return this.f11205c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f11204b = true;
            int i8 = this.f11203a + 1;
            this.f11203a = i8;
            return (Map.Entry) (i8 < b0.this.f11190a.size() ? b0.this.f11190a.get(this.f11203a) : b().next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11203a + 1 >= b0.this.f11190a.size()) {
                return !b0.this.f11191b.isEmpty() && b().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f11204b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f11204b = false;
            b0.this.g();
            if (this.f11203a >= b0.this.f11190a.size()) {
                b().remove();
                return;
            }
            b0 b0Var = b0.this;
            int i8 = this.f11203a;
            this.f11203a = i8 - 1;
            b0Var.s(i8);
        }

        public /* synthetic */ e(b0 b0Var, a aVar) {
            this();
        }
    }

    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            b0.this.r((Comparable) entry.getKey(), entry.getValue());
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
            return obj2 == value || (obj2 != null && obj2.equals(value));
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

    public b0() {
        this.f11190a = Collections.emptyList();
        this.f11191b = Collections.emptyMap();
        this.f11194e = Collections.emptyMap();
    }

    public static b0 q() {
        return new a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f11190a.isEmpty()) {
            this.f11190a.clear();
        }
        if (this.f11191b.isEmpty()) {
            return;
        }
        this.f11191b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f11191b.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f11193d == null) {
            this.f11193d = new f(this, null);
        }
        return this.f11193d;
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
        int iK = k();
        if (iK != b0Var.k()) {
            return entrySet().equals(b0Var.entrySet());
        }
        for (int i8 = 0; i8 < iK; i8++) {
            if (!j(i8).equals(b0Var.j(i8))) {
                return false;
            }
        }
        if (iK != size) {
            return this.f11191b.equals(b0Var.f11191b);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f11190a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f11190a
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
            java.util.List r3 = r4.f11190a
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.b0.f(java.lang.Comparable):int");
    }

    public final void g() {
        if (this.f11192c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((d) this.f11190a.get(iF)).getValue() : this.f11191b.get(comparable);
    }

    public Set h() {
        if (this.f11195f == null) {
            this.f11195f = new c(this, null);
        }
        return this.f11195f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i8 = 0; i8 < iK; i8++) {
            iHashCode += ((d) this.f11190a.get(i8)).hashCode();
        }
        return l() > 0 ? iHashCode + this.f11191b.hashCode() : iHashCode;
    }

    public final void i() {
        g();
        if (!this.f11190a.isEmpty() || (this.f11190a instanceof ArrayList)) {
            return;
        }
        this.f11190a = new ArrayList(16);
    }

    public Map.Entry j(int i8) {
        return (Map.Entry) this.f11190a.get(i8);
    }

    public int k() {
        return this.f11190a.size();
    }

    public int l() {
        return this.f11191b.size();
    }

    public Iterable m() {
        return this.f11191b.isEmpty() ? Collections.emptySet() : this.f11191b.entrySet();
    }

    public final SortedMap n() {
        g();
        if (this.f11191b.isEmpty() && !(this.f11191b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f11191b = treeMap;
            this.f11194e = treeMap.descendingMap();
        }
        return (SortedMap) this.f11191b;
    }

    public boolean o() {
        return this.f11192c;
    }

    public void p() {
        if (this.f11192c) {
            return;
        }
        this.f11191b = this.f11191b.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f11191b);
        this.f11194e = this.f11194e.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f11194e);
        this.f11192c = true;
    }

    public Object r(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((d) this.f11190a.get(iF)).setValue(obj);
        }
        i();
        int i8 = -(iF + 1);
        if (i8 >= 16) {
            return n().put(comparable, obj);
        }
        if (this.f11190a.size() == 16) {
            d dVar = (d) this.f11190a.remove(15);
            n().put(dVar.getKey(), dVar.getValue());
        }
        this.f11190a.add(i8, new d(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return s(iF);
        }
        if (this.f11191b.isEmpty()) {
            return null;
        }
        return this.f11191b.remove(comparable);
    }

    public final Object s(int i8) {
        g();
        Object value = ((d) this.f11190a.remove(i8)).getValue();
        if (!this.f11191b.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f11190a.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f11190a.size() + this.f11191b.size();
    }

    public /* synthetic */ b0(a aVar) {
        this();
    }
}
