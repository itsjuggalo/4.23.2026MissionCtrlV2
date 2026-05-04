package com.google.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p1 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f7121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f7122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile g f7124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f7125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f7126g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends p1 {
        public a(int i10) {
            super(i10, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.s((Comparable) obj, obj2);
        }

        @Override // com.google.protobuf.p1
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
    public class c extends g {
        public c() {
            super(p1.this, null);
        }

        @Override // com.google.protobuf.p1.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(p1.this, null);
        }

        public /* synthetic */ c(p1 p1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator f7131a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable f7132b = new b();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Iterator {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Iterable {
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return d.f7131a;
            }
        }

        public static Iterable b() {
            return f7132b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Map.Entry, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f7133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f7134b;

        public e(p1 p1Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f7133a;
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
            return b(this.f7133a, entry.getKey()) && b(this.f7134b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f7134b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f7133a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f7134b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            p1.this.h();
            Object obj2 = this.f7134b;
            this.f7134b = obj;
            return obj2;
        }

        public String toString() {
            return this.f7133a + com.amazon.a.a.o.b.f.f4599b + this.f7134b;
        }

        public e(Comparable comparable, Object obj) {
            this.f7133a = comparable;
            this.f7134b = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g extends AbstractSet {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            p1.this.s((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            p1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = p1.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new f(p1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            p1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p1.this.size();
        }

        public /* synthetic */ g(p1 p1Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ p1(int i10, a aVar) {
        this(i10);
    }

    public static p1 r(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f7121b.isEmpty()) {
            this.f7121b.clear();
        }
        if (this.f7122c.isEmpty()) {
            return;
        }
        this.f7122c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f7122c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f7124e == null) {
            this.f7124e = new g(this, null);
        }
        return this.f7124e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return super.equals(obj);
        }
        p1 p1Var = (p1) obj;
        int size = size();
        if (size != p1Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != p1Var.l()) {
            return entrySet().equals(p1Var.entrySet());
        }
        for (int i10 = 0; i10 < iL; i10++) {
            if (!k(i10).equals(p1Var.k(i10))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f7122c.equals(p1Var.f7122c);
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
            java.util.List r0 = r4.f7121b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f7121b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.p1$e r2 = (com.google.protobuf.p1.e) r2
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
            java.util.List r3 = r4.f7121b
            java.lang.Object r3 = r3.get(r2)
            com.google.protobuf.p1$e r3 = (com.google.protobuf.p1.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.p1.g(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? ((e) this.f7121b.get(iG)).getValue() : this.f7122c.get(comparable);
    }

    public final void h() {
        if (this.f7123d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iL; i10++) {
            iHashCode += ((e) this.f7121b.get(i10)).hashCode();
        }
        return m() > 0 ? iHashCode + this.f7122c.hashCode() : iHashCode;
    }

    public Set i() {
        if (this.f7126g == null) {
            this.f7126g = new c(this, null);
        }
        return this.f7126g;
    }

    public final void j() {
        h();
        if (!this.f7121b.isEmpty() || (this.f7121b instanceof ArrayList)) {
            return;
        }
        this.f7121b = new ArrayList(this.f7120a);
    }

    public Map.Entry k(int i10) {
        return (Map.Entry) this.f7121b.get(i10);
    }

    public int l() {
        return this.f7121b.size();
    }

    public int m() {
        return this.f7122c.size();
    }

    public Iterable n() {
        return this.f7122c.isEmpty() ? d.b() : this.f7122c.entrySet();
    }

    public final SortedMap o() {
        h();
        if (this.f7122c.isEmpty() && !(this.f7122c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7122c = treeMap;
            this.f7125f = treeMap.descendingMap();
        }
        return (SortedMap) this.f7122c;
    }

    public boolean p() {
        return this.f7123d;
    }

    public void q() {
        if (this.f7123d) {
            return;
        }
        this.f7122c = this.f7122c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f7122c);
        this.f7125f = this.f7125f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f7125f);
        this.f7123d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return t(iG);
        }
        if (this.f7122c.isEmpty()) {
            return null;
        }
        return this.f7122c.remove(comparable);
    }

    public Object s(Comparable comparable, Object obj) {
        h();
        int iG = g(comparable);
        if (iG >= 0) {
            return ((e) this.f7121b.get(iG)).setValue(obj);
        }
        j();
        int i10 = -(iG + 1);
        if (i10 >= this.f7120a) {
            return o().put(comparable, obj);
        }
        int size = this.f7121b.size();
        int i11 = this.f7120a;
        if (size == i11) {
            e eVar = (e) this.f7121b.remove(i11 - 1);
            o().put(eVar.getKey(), eVar.getValue());
        }
        this.f7121b.add(i10, new e(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f7121b.size() + this.f7122c.size();
    }

    public final Object t(int i10) {
        h();
        Object value = ((e) this.f7121b.remove(i10)).getValue();
        if (!this.f7122c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f7121b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f7128b;

        public b() {
            this.f7127a = p1.this.f7121b.size();
        }

        public final Iterator b() {
            if (this.f7128b == null) {
                this.f7128b = p1.this.f7125f.entrySet().iterator();
            }
            return this.f7128b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (b().hasNext()) {
                return (Map.Entry) b().next();
            }
            List list = p1.this.f7121b;
            int i10 = this.f7127a - 1;
            this.f7127a = i10;
            return (Map.Entry) list.get(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f7127a;
            return (i10 > 0 && i10 <= p1.this.f7121b.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(p1 p1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f7138c;

        public f() {
            this.f7136a = -1;
        }

        public final Iterator b() {
            if (this.f7138c == null) {
                this.f7138c = p1.this.f7122c.entrySet().iterator();
            }
            return this.f7138c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f7137b = true;
            int i10 = this.f7136a + 1;
            this.f7136a = i10;
            return i10 < p1.this.f7121b.size() ? (Map.Entry) p1.this.f7121b.get(this.f7136a) : (Map.Entry) b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7136a + 1 < p1.this.f7121b.size() || (!p1.this.f7122c.isEmpty() && b().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f7137b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f7137b = false;
            p1.this.h();
            if (this.f7136a >= p1.this.f7121b.size()) {
                b().remove();
                return;
            }
            p1 p1Var = p1.this;
            int i10 = this.f7136a;
            this.f7136a = i10 - 1;
            p1Var.t(i10);
        }

        public /* synthetic */ f(p1 p1Var, a aVar) {
            this();
        }
    }

    public p1(int i10) {
        this.f7120a = i10;
        this.f7121b = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f7122c = map;
        this.f7125f = map;
    }
}
