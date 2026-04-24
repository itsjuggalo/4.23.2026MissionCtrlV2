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
public abstract class q0 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f12761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f12762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile g f12764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f12765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f12766g;

    public class a extends q0 {
        public a(int i7) {
            super(i7, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.s((Comparable) obj, obj2);
        }

        @Override // com.google.protobuf.q0
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

    public class c extends g {
        public c() {
            super(q0.this, null);
        }

        @Override // com.google.protobuf.q0.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(q0.this, null);
        }

        public /* synthetic */ c(q0 q0Var, a aVar) {
            this();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator f12771a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable f12772b = new b();

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
                return d.f12771a;
            }
        }

        public static Iterable b() {
            return f12772b;
        }
    }

    public class e implements Map.Entry, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f12773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12774b;

        public e(q0 q0Var, Map.Entry entry) {
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
            return this.f12773a;
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
            return b(this.f12773a, entry.getKey()) && b(this.f12774b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f12774b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f12773a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f12774b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            q0.this.h();
            Object obj2 = this.f12774b;
            this.f12774b = obj;
            return obj2;
        }

        public String toString() {
            return this.f12773a + com.amazon.a.a.o.b.f.f9990b + this.f12774b;
        }

        public e(Comparable comparable, Object obj) {
            this.f12773a = comparable;
            this.f12774b = obj;
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
            q0.this.s((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            q0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = q0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new f(q0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            q0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return q0.this.size();
        }

        public /* synthetic */ g(q0 q0Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ q0(int i7, a aVar) {
        this(i7);
    }

    public static q0 r(int i7) {
        return new a(i7);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f12761b.isEmpty()) {
            this.f12761b.clear();
        }
        if (this.f12762c.isEmpty()) {
            return;
        }
        this.f12762c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f12762c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f12764e == null) {
            this.f12764e = new g(this, null);
        }
        return this.f12764e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return super.equals(obj);
        }
        q0 q0Var = (q0) obj;
        int size = size();
        if (size != q0Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != q0Var.l()) {
            return entrySet().equals(q0Var.entrySet());
        }
        for (int i7 = 0; i7 < iL; i7++) {
            if (!k(i7).equals(q0Var.k(i7))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f12762c.equals(q0Var.f12762c);
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
            java.util.List r0 = r4.f12761b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f12761b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.q0$e r2 = (com.google.protobuf.q0.e) r2
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
            java.util.List r3 = r4.f12761b
            java.lang.Object r3 = r3.get(r2)
            com.google.protobuf.q0$e r3 = (com.google.protobuf.q0.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.q0.g(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? ((e) this.f12761b.get(iG)).getValue() : this.f12762c.get(comparable);
    }

    public final void h() {
        if (this.f12763d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i7 = 0; i7 < iL; i7++) {
            iHashCode += ((e) this.f12761b.get(i7)).hashCode();
        }
        return m() > 0 ? iHashCode + this.f12762c.hashCode() : iHashCode;
    }

    public Set i() {
        if (this.f12766g == null) {
            this.f12766g = new c(this, null);
        }
        return this.f12766g;
    }

    public final void j() {
        h();
        if (!this.f12761b.isEmpty() || (this.f12761b instanceof ArrayList)) {
            return;
        }
        this.f12761b = new ArrayList(this.f12760a);
    }

    public Map.Entry k(int i7) {
        return (Map.Entry) this.f12761b.get(i7);
    }

    public int l() {
        return this.f12761b.size();
    }

    public int m() {
        return this.f12762c.size();
    }

    public Iterable n() {
        return this.f12762c.isEmpty() ? d.b() : this.f12762c.entrySet();
    }

    public final SortedMap o() {
        h();
        if (this.f12762c.isEmpty() && !(this.f12762c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f12762c = treeMap;
            this.f12765f = treeMap.descendingMap();
        }
        return (SortedMap) this.f12762c;
    }

    public boolean p() {
        return this.f12763d;
    }

    public void q() {
        if (this.f12763d) {
            return;
        }
        this.f12762c = this.f12762c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f12762c);
        this.f12765f = this.f12765f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f12765f);
        this.f12763d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return t(iG);
        }
        if (this.f12762c.isEmpty()) {
            return null;
        }
        return this.f12762c.remove(comparable);
    }

    public Object s(Comparable comparable, Object obj) {
        h();
        int iG = g(comparable);
        if (iG >= 0) {
            return ((e) this.f12761b.get(iG)).setValue(obj);
        }
        j();
        int i7 = -(iG + 1);
        if (i7 >= this.f12760a) {
            return o().put(comparable, obj);
        }
        int size = this.f12761b.size();
        int i8 = this.f12760a;
        if (size == i8) {
            e eVar = (e) this.f12761b.remove(i8 - 1);
            o().put(eVar.getKey(), eVar.getValue());
        }
        this.f12761b.add(i7, new e(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f12761b.size() + this.f12762c.size();
    }

    public final Object t(int i7) {
        h();
        Object value = ((e) this.f12761b.remove(i7)).getValue();
        if (!this.f12762c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.f12761b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f12768b;

        public b() {
            this.f12767a = q0.this.f12761b.size();
        }

        public final Iterator b() {
            if (this.f12768b == null) {
                this.f12768b = q0.this.f12765f.entrySet().iterator();
            }
            return this.f12768b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (b().hasNext()) {
                return (Map.Entry) b().next();
            }
            List list = q0.this.f12761b;
            int i7 = this.f12767a - 1;
            this.f12767a = i7;
            return (Map.Entry) list.get(i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i7 = this.f12767a;
            return (i7 > 0 && i7 <= q0.this.f12761b.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(q0 q0Var, a aVar) {
            this();
        }
    }

    public class f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f12778c;

        public f() {
            this.f12776a = -1;
        }

        public final Iterator b() {
            if (this.f12778c == null) {
                this.f12778c = q0.this.f12762c.entrySet().iterator();
            }
            return this.f12778c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f12777b = true;
            int i7 = this.f12776a + 1;
            this.f12776a = i7;
            return i7 < q0.this.f12761b.size() ? (Map.Entry) q0.this.f12761b.get(this.f12776a) : (Map.Entry) b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12776a + 1 >= q0.this.f12761b.size()) {
                return !q0.this.f12762c.isEmpty() && b().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f12777b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f12777b = false;
            q0.this.h();
            if (this.f12776a >= q0.this.f12761b.size()) {
                b().remove();
                return;
            }
            q0 q0Var = q0.this;
            int i7 = this.f12776a;
            this.f12776a = i7 - 1;
            q0Var.t(i7);
        }

        public /* synthetic */ f(q0 q0Var, a aVar) {
            this();
        }
    }

    public q0(int i7) {
        this.f12760a = i7;
        this.f12761b = Collections.emptyList();
        this.f12762c = Collections.emptyMap();
        this.f12765f = Collections.emptyMap();
    }
}
