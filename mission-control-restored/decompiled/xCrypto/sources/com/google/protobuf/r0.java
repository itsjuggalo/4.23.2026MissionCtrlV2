package com.google.protobuf;

import com.google.protobuf.C1073u;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class r0 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f11146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile g f11148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f11149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f11150g;

    public class a extends r0 {
        public a(int i4) {
            super(i4, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.s((Comparable) obj, obj2);
        }

        @Override // com.google.protobuf.r0
        public void q() {
            if (!p()) {
                for (int i4 = 0; i4 < l(); i4++) {
                    Map.Entry entryK = k(i4);
                    if (((C1073u.b) entryK.getKey()).d()) {
                        entryK.setValue(Collections.unmodifiableList((List) entryK.getValue()));
                    }
                }
                for (Map.Entry entry : n()) {
                    if (((C1073u.b) entry.getKey()).d()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.q();
        }
    }

    public class c extends g {
        public c() {
            super(r0.this, null);
        }

        @Override // com.google.protobuf.r0.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(r0.this, null);
        }

        public /* synthetic */ c(r0 r0Var, a aVar) {
            this();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator f11155a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable f11156b = new b();

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

        public class b implements Iterable {
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return d.f11155a;
            }
        }

        public static Iterable b() {
            return f11156b;
        }
    }

    public class e implements Map.Entry, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f11157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11158b;

        public e(r0 r0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return getKey().compareTo(eVar.getKey());
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
            return c(this.f11157a, entry.getKey()) && c(this.f11158b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f11157a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f11158b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f11157a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f11158b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            r0.this.h();
            Object obj2 = this.f11158b;
            this.f11158b = obj;
            return obj2;
        }

        public String toString() {
            return this.f11157a + com.amazon.a.a.o.b.f.f8805b + this.f11158b;
        }

        public e(Comparable comparable, Object obj) {
            this.f11157a = comparable;
            this.f11158b = obj;
        }
    }

    public class g extends AbstractSet {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            r0.this.s((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            r0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = r0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new f(r0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            r0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r0.this.size();
        }

        public /* synthetic */ g(r0 r0Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ r0(int i4, a aVar) {
        this(i4);
    }

    public static r0 r(int i4) {
        return new a(i4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f11145b.isEmpty()) {
            this.f11145b.clear();
        }
        if (this.f11146c.isEmpty()) {
            return;
        }
        this.f11146c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f11146c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f11148e == null) {
            this.f11148e = new g(this, null);
        }
        return this.f11148e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return super.equals(obj);
        }
        r0 r0Var = (r0) obj;
        int size = size();
        if (size != r0Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != r0Var.l()) {
            return entrySet().equals(r0Var.entrySet());
        }
        for (int i4 = 0; i4 < iL; i4++) {
            if (!k(i4).equals(r0Var.k(i4))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f11146c.equals(r0Var.f11146c);
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
            java.util.List r0 = r4.f11145b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f11145b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.r0$e r2 = (com.google.protobuf.r0.e) r2
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
            java.util.List r3 = r4.f11145b
            java.lang.Object r3 = r3.get(r2)
            com.google.protobuf.r0$e r3 = (com.google.protobuf.r0.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.r0.g(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? ((e) this.f11145b.get(iG)).getValue() : this.f11146c.get(comparable);
    }

    public final void h() {
        if (this.f11147d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i4 = 0; i4 < iL; i4++) {
            iHashCode += ((e) this.f11145b.get(i4)).hashCode();
        }
        return m() > 0 ? iHashCode + this.f11146c.hashCode() : iHashCode;
    }

    public Set i() {
        if (this.f11150g == null) {
            this.f11150g = new c(this, null);
        }
        return this.f11150g;
    }

    public final void j() {
        h();
        if (!this.f11145b.isEmpty() || (this.f11145b instanceof ArrayList)) {
            return;
        }
        this.f11145b = new ArrayList(this.f11144a);
    }

    public Map.Entry k(int i4) {
        return (Map.Entry) this.f11145b.get(i4);
    }

    public int l() {
        return this.f11145b.size();
    }

    public int m() {
        return this.f11146c.size();
    }

    public Iterable n() {
        return this.f11146c.isEmpty() ? d.b() : this.f11146c.entrySet();
    }

    public final SortedMap o() {
        h();
        if (this.f11146c.isEmpty() && !(this.f11146c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f11146c = treeMap;
            this.f11149f = treeMap.descendingMap();
        }
        return (SortedMap) this.f11146c;
    }

    public boolean p() {
        return this.f11147d;
    }

    public void q() {
        if (this.f11147d) {
            return;
        }
        this.f11146c = this.f11146c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f11146c);
        this.f11149f = this.f11149f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f11149f);
        this.f11147d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return t(iG);
        }
        if (this.f11146c.isEmpty()) {
            return null;
        }
        return this.f11146c.remove(comparable);
    }

    public Object s(Comparable comparable, Object obj) {
        h();
        int iG = g(comparable);
        if (iG >= 0) {
            return ((e) this.f11145b.get(iG)).setValue(obj);
        }
        j();
        int i4 = -(iG + 1);
        if (i4 >= this.f11144a) {
            return o().put(comparable, obj);
        }
        int size = this.f11145b.size();
        int i5 = this.f11144a;
        if (size == i5) {
            e eVar = (e) this.f11145b.remove(i5 - 1);
            o().put(eVar.getKey(), eVar.getValue());
        }
        this.f11145b.add(i4, new e(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f11145b.size() + this.f11146c.size();
    }

    public final Object t(int i4) {
        h();
        Object value = ((e) this.f11145b.remove(i4)).getValue();
        if (!this.f11146c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f11145b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f11152b;

        public b() {
            this.f11151a = r0.this.f11145b.size();
        }

        public final Iterator b() {
            if (this.f11152b == null) {
                this.f11152b = r0.this.f11149f.entrySet().iterator();
            }
            return this.f11152b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (b().hasNext()) {
                return (Map.Entry) b().next();
            }
            List list = r0.this.f11145b;
            int i4 = this.f11151a - 1;
            this.f11151a = i4;
            return (Map.Entry) list.get(i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i4 = this.f11151a;
            return (i4 > 0 && i4 <= r0.this.f11145b.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(r0 r0Var, a aVar) {
            this();
        }
    }

    public class f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f11162c;

        public f() {
            this.f11160a = -1;
        }

        public final Iterator b() {
            if (this.f11162c == null) {
                this.f11162c = r0.this.f11146c.entrySet().iterator();
            }
            return this.f11162c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f11161b = true;
            int i4 = this.f11160a + 1;
            this.f11160a = i4;
            return i4 < r0.this.f11145b.size() ? (Map.Entry) r0.this.f11145b.get(this.f11160a) : (Map.Entry) b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11160a + 1 < r0.this.f11145b.size() || (!r0.this.f11146c.isEmpty() && b().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f11161b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f11161b = false;
            r0.this.h();
            if (this.f11160a >= r0.this.f11145b.size()) {
                b().remove();
                return;
            }
            r0 r0Var = r0.this;
            int i4 = this.f11160a;
            this.f11160a = i4 - 1;
            r0Var.t(i4);
        }

        public /* synthetic */ f(r0 r0Var, a aVar) {
            this();
        }
    }

    public r0(int i4) {
        this.f11144a = i4;
        this.f11145b = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        this.f11146c = map;
        this.f11149f = map;
    }
}
