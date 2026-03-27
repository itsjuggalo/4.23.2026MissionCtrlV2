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

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f16335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f16336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile g f16338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f16339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f16340g;

    public class a extends b0 {
        public a(int i8) {
            super(i8, null);
        }

        @Override // com.google.protobuf.b0
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
        public int f16341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f16342b;

        public b() {
            this.f16341a = b0.this.f16335b.size();
        }

        public final Iterator b() {
            if (this.f16342b == null) {
                this.f16342b = b0.this.f16339f.entrySet().iterator();
            }
            return this.f16342b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Object next;
            if (b().hasNext()) {
                next = b().next();
            } else {
                List list = b0.this.f16335b;
                int i8 = this.f16341a - 1;
                this.f16341a = i8;
                next = list.get(i8);
            }
            return (Map.Entry) next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i8 = this.f16341a;
            return (i8 > 0 && i8 <= b0.this.f16335b.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(b0 b0Var, a aVar) {
            this();
        }
    }

    public class c extends g {
        public c() {
            super(b0.this, null);
        }

        @Override // com.google.protobuf.b0.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(b0.this, null);
        }

        public /* synthetic */ c(b0 b0Var, a aVar) {
            this();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator f16345a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable f16346b = new b();

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
                return d.f16345a;
            }
        }

        public static Iterable b() {
            return f16346b;
        }
    }

    public class e implements Map.Entry, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f16347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f16348b;

        public e(Comparable comparable, Object obj) {
            this.f16347a = comparable;
            this.f16348b = obj;
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
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f16347a, entry.getKey()) && b(this.f16348b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f16347a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f16348b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f16347a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f16348b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            b0.this.g();
            Object obj2 = this.f16348b;
            this.f16348b = obj;
            return obj2;
        }

        public String toString() {
            return this.f16347a + com.amazon.a.a.o.b.f.f14101b + this.f16348b;
        }

        public e(b0 b0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }
    }

    public class f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f16352c;

        public f() {
            this.f16350a = -1;
        }

        public final Iterator b() {
            if (this.f16352c == null) {
                this.f16352c = b0.this.f16336c.entrySet().iterator();
            }
            return this.f16352c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f16351b = true;
            int i8 = this.f16350a + 1;
            this.f16350a = i8;
            return (Map.Entry) (i8 < b0.this.f16335b.size() ? b0.this.f16335b.get(this.f16350a) : b().next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16350a + 1 >= b0.this.f16335b.size()) {
                return !b0.this.f16336c.isEmpty() && b().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f16351b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f16351b = false;
            b0.this.g();
            if (this.f16350a >= b0.this.f16335b.size()) {
                b().remove();
                return;
            }
            b0 b0Var = b0.this;
            int i8 = this.f16350a;
            this.f16350a = i8 - 1;
            b0Var.s(i8);
        }

        public /* synthetic */ f(b0 b0Var, a aVar) {
            this();
        }
    }

    public class g extends AbstractSet {
        public g() {
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
            return new f(b0.this, null);
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

        public /* synthetic */ g(b0 b0Var, a aVar) {
            this();
        }
    }

    public b0(int i8) {
        this.f16334a = i8;
        this.f16335b = Collections.emptyList();
        this.f16336c = Collections.emptyMap();
        this.f16339f = Collections.emptyMap();
    }

    public static b0 q(int i8) {
        return new a(i8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f16335b.isEmpty()) {
            this.f16335b.clear();
        }
        if (this.f16336c.isEmpty()) {
            return;
        }
        this.f16336c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f16336c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f16338e == null) {
            this.f16338e = new g(this, null);
        }
        return this.f16338e;
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
            return this.f16336c.equals(b0Var.f16336c);
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
            java.util.List r0 = r4.f16335b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f16335b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.b0$e r2 = (com.google.protobuf.b0.e) r2
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
            java.util.List r3 = r4.f16335b
            java.lang.Object r3 = r3.get(r2)
            com.google.protobuf.b0$e r3 = (com.google.protobuf.b0.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b0.f(java.lang.Comparable):int");
    }

    public final void g() {
        if (this.f16337d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((e) this.f16335b.get(iF)).getValue() : this.f16336c.get(comparable);
    }

    public Set h() {
        if (this.f16340g == null) {
            this.f16340g = new c(this, null);
        }
        return this.f16340g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i8 = 0; i8 < iK; i8++) {
            iHashCode += ((e) this.f16335b.get(i8)).hashCode();
        }
        return l() > 0 ? iHashCode + this.f16336c.hashCode() : iHashCode;
    }

    public final void i() {
        g();
        if (!this.f16335b.isEmpty() || (this.f16335b instanceof ArrayList)) {
            return;
        }
        this.f16335b = new ArrayList(this.f16334a);
    }

    public Map.Entry j(int i8) {
        return (Map.Entry) this.f16335b.get(i8);
    }

    public int k() {
        return this.f16335b.size();
    }

    public int l() {
        return this.f16336c.size();
    }

    public Iterable m() {
        return this.f16336c.isEmpty() ? d.b() : this.f16336c.entrySet();
    }

    public final SortedMap n() {
        g();
        if (this.f16336c.isEmpty() && !(this.f16336c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f16336c = treeMap;
            this.f16339f = treeMap.descendingMap();
        }
        return (SortedMap) this.f16336c;
    }

    public boolean o() {
        return this.f16337d;
    }

    public void p() {
        if (this.f16337d) {
            return;
        }
        this.f16336c = this.f16336c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f16336c);
        this.f16339f = this.f16339f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f16339f);
        this.f16337d = true;
    }

    public Object r(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((e) this.f16335b.get(iF)).setValue(obj);
        }
        i();
        int i8 = -(iF + 1);
        if (i8 >= this.f16334a) {
            return n().put(comparable, obj);
        }
        int size = this.f16335b.size();
        int i9 = this.f16334a;
        if (size == i9) {
            e eVar = (e) this.f16335b.remove(i9 - 1);
            n().put(eVar.getKey(), eVar.getValue());
        }
        this.f16335b.add(i8, new e(comparable, obj));
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
        if (this.f16336c.isEmpty()) {
            return null;
        }
        return this.f16336c.remove(comparable);
    }

    public final Object s(int i8) {
        g();
        Object value = ((e) this.f16335b.remove(i8)).getValue();
        if (!this.f16336c.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            this.f16335b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f16335b.size() + this.f16336c.size();
    }

    public /* synthetic */ b0(int i8, a aVar) {
        this(i8);
    }
}
