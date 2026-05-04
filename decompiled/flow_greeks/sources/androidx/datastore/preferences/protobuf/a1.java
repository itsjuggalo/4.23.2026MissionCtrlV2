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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f1643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f1644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile f f1646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f1647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile c f1648f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends a1 {
        public a() {
            super(null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.s((Comparable) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.a1
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends f {
        public c() {
            super(a1.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.a1.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(a1.this, null);
        }

        public /* synthetic */ c(a1 a1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Map.Entry, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f1653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f1654b;

        public d(a1 a1Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
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
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f1653a;
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
            return b(this.f1653a, entry.getKey()) && b(this.f1654b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f1654b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f1653a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f1654b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a1.this.h();
            Object obj2 = this.f1654b;
            this.f1654b = obj;
            return obj2;
        }

        public String toString() {
            return this.f1653a + com.amazon.a.a.o.b.f.f4599b + this.f1654b;
        }

        public d(Comparable comparable, Object obj) {
            this.f1653a = comparable;
            this.f1654b = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            a1.this.s((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = a1.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(a1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            a1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a1.this.size();
        }

        public /* synthetic */ f(a1 a1Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ a1(a aVar) {
        this();
    }

    public static a1 r() {
        return new a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f1643a.isEmpty()) {
            this.f1643a.clear();
        }
        if (this.f1644b.isEmpty()) {
            return;
        }
        this.f1644b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f1644b.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f1646d == null) {
            this.f1646d = new f(this, null);
        }
        return this.f1646d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return super.equals(obj);
        }
        a1 a1Var = (a1) obj;
        int size = size();
        if (size != a1Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != a1Var.l()) {
            return entrySet().equals(a1Var.entrySet());
        }
        for (int i10 = 0; i10 < iL; i10++) {
            if (!k(i10).equals(a1Var.k(i10))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f1644b.equals(a1Var.f1644b);
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
            java.util.List r0 = r4.f1643a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f1643a
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.a1$d r2 = (androidx.datastore.preferences.protobuf.a1.d) r2
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
            java.util.List r3 = r4.f1643a
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.a1$d r3 = (androidx.datastore.preferences.protobuf.a1.d) r3
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.a1.g(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? ((d) this.f1643a.get(iG)).getValue() : this.f1644b.get(comparable);
    }

    public final void h() {
        if (this.f1645c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iL; i10++) {
            iHashCode += ((d) this.f1643a.get(i10)).hashCode();
        }
        return m() > 0 ? iHashCode + this.f1644b.hashCode() : iHashCode;
    }

    public Set i() {
        if (this.f1648f == null) {
            this.f1648f = new c(this, null);
        }
        return this.f1648f;
    }

    public final void j() {
        h();
        if (!this.f1643a.isEmpty() || (this.f1643a instanceof ArrayList)) {
            return;
        }
        this.f1643a = new ArrayList(16);
    }

    public Map.Entry k(int i10) {
        return (Map.Entry) this.f1643a.get(i10);
    }

    public int l() {
        return this.f1643a.size();
    }

    public int m() {
        return this.f1644b.size();
    }

    public Iterable n() {
        return this.f1644b.isEmpty() ? Collections.EMPTY_SET : this.f1644b.entrySet();
    }

    public final SortedMap o() {
        h();
        if (this.f1644b.isEmpty() && !(this.f1644b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1644b = treeMap;
            this.f1647e = treeMap.descendingMap();
        }
        return (SortedMap) this.f1644b;
    }

    public boolean p() {
        return this.f1645c;
    }

    public void q() {
        if (this.f1645c) {
            return;
        }
        this.f1644b = this.f1644b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f1644b);
        this.f1647e = this.f1647e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f1647e);
        this.f1645c = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return t(iG);
        }
        if (this.f1644b.isEmpty()) {
            return null;
        }
        return this.f1644b.remove(comparable);
    }

    public Object s(Comparable comparable, Object obj) {
        h();
        int iG = g(comparable);
        if (iG >= 0) {
            return ((d) this.f1643a.get(iG)).setValue(obj);
        }
        j();
        int i10 = -(iG + 1);
        if (i10 >= 16) {
            return o().put(comparable, obj);
        }
        if (this.f1643a.size() == 16) {
            d dVar = (d) this.f1643a.remove(15);
            o().put(dVar.getKey(), dVar.getValue());
        }
        this.f1643a.add(i10, new d(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f1643a.size() + this.f1644b.size();
    }

    public final Object t(int i10) {
        h();
        Object value = ((d) this.f1643a.remove(i10)).getValue();
        if (!this.f1644b.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f1643a.add(new d(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f1650b;

        public b() {
            this.f1649a = a1.this.f1643a.size();
        }

        public final Iterator b() {
            if (this.f1650b == null) {
                this.f1650b = a1.this.f1647e.entrySet().iterator();
            }
            return this.f1650b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (b().hasNext()) {
                return (Map.Entry) b().next();
            }
            List list = a1.this.f1643a;
            int i10 = this.f1649a - 1;
            this.f1649a = i10;
            return (Map.Entry) list.get(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f1649a;
            return (i10 > 0 && i10 <= a1.this.f1643a.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(a1 a1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f1658c;

        public e() {
            this.f1656a = -1;
        }

        public final Iterator b() {
            if (this.f1658c == null) {
                this.f1658c = a1.this.f1644b.entrySet().iterator();
            }
            return this.f1658c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f1657b = true;
            int i10 = this.f1656a + 1;
            this.f1656a = i10;
            return i10 < a1.this.f1643a.size() ? (Map.Entry) a1.this.f1643a.get(this.f1656a) : (Map.Entry) b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1656a + 1 < a1.this.f1643a.size() || (!a1.this.f1644b.isEmpty() && b().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f1657b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f1657b = false;
            a1.this.h();
            if (this.f1656a >= a1.this.f1643a.size()) {
                b().remove();
                return;
            }
            a1 a1Var = a1.this;
            int i10 = this.f1656a;
            this.f1656a = i10 - 1;
            a1Var.t(i10);
        }

        public /* synthetic */ e(a1 a1Var, a aVar) {
            this();
        }
    }

    public a1() {
        this.f1643a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f1644b = map;
        this.f1647e = map;
    }
}
