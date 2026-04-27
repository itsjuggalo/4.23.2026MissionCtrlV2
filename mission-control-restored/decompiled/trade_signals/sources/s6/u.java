package s6;

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
import s6.C2721h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f23209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f23210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile e f23212e;

    public static class a extends u {
        public a(int i8) {
            super(i8, null);
        }

        @Override // s6.u
        public void m() {
            if (!l()) {
                for (int i8 = 0; i8 < i(); i8++) {
                    Map.Entry entryH = h(i8);
                    if (((C2721h.b) entryH.getKey()).e()) {
                        entryH.setValue(Collections.unmodifiableList((List) entryH.getValue()));
                    }
                }
                for (Map.Entry entry : j()) {
                    if (((C2721h.b) entry.getKey()).e()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.m();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.o((C2721h.b) obj, obj2);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator f23213a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable f23214b = new C0398b();

        public static class a implements Iterator {
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

        /* JADX INFO: renamed from: s6.u$b$b, reason: collision with other inner class name */
        public static class C0398b implements Iterable {
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return b.f23213a;
            }
        }

        public static Iterable b() {
            return f23214b;
        }
    }

    public class c implements Comparable, Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f23215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f23216b;

        public c(Comparable comparable, Object obj) {
            this.f23215a = comparable;
            this.f23216b = obj;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return getKey().compareTo(cVar.getKey());
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
            return b(this.f23215a, entry.getKey()) && b(this.f23216b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f23215a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f23216b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f23215a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f23216b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            u.this.f();
            Object obj2 = this.f23216b;
            this.f23216b = obj;
            return obj2;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f23215a);
            String strValueOf2 = String.valueOf(this.f23216b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append(com.amazon.a.a.o.b.f.f14101b);
            sb.append(strValueOf2);
            return sb.toString();
        }

        public c(u uVar, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }
    }

    public class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f23220c;

        public d() {
            this.f23218a = -1;
        }

        public final Iterator b() {
            if (this.f23220c == null) {
                this.f23220c = u.this.f23210c.entrySet().iterator();
            }
            return this.f23220c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f23219b = true;
            int i8 = this.f23218a + 1;
            this.f23218a = i8;
            return (Map.Entry) (i8 < u.this.f23209b.size() ? u.this.f23209b.get(this.f23218a) : b().next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23218a + 1 < u.this.f23209b.size() || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f23219b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f23219b = false;
            u.this.f();
            if (this.f23218a >= u.this.f23209b.size()) {
                b().remove();
                return;
            }
            u uVar = u.this;
            int i8 = this.f23218a;
            this.f23218a = i8 - 1;
            uVar.p(i8);
        }

        public /* synthetic */ d(u uVar, a aVar) {
            this();
        }
    }

    public class e extends AbstractSet {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            u.this.o((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            u.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = u.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new d(u.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            u.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return u.this.size();
        }

        public /* synthetic */ e(u uVar, a aVar) {
            this();
        }
    }

    public u(int i8) {
        this.f23208a = i8;
        this.f23209b = Collections.emptyList();
        this.f23210c = Collections.emptyMap();
    }

    public static u n(int i8) {
        return new a(i8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f23209b.isEmpty()) {
            this.f23209b.clear();
        }
        if (this.f23210c.isEmpty()) {
            return;
        }
        this.f23210c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f23210c.containsKey(comparable);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f23209b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f23209b
            java.lang.Object r2 = r2.get(r1)
            s6.u$c r2 = (s6.u.c) r2
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
            java.util.List r3 = r4.f23209b
            java.lang.Object r3 = r3.get(r2)
            s6.u$c r3 = (s6.u.c) r3
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
        throw new UnsupportedOperationException("Method not decompiled: s6.u.e(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f23212e == null) {
            this.f23212e = new e(this, null);
        }
        return this.f23212e;
    }

    public final void f() {
        if (this.f23211d) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g() {
        f();
        if (!this.f23209b.isEmpty() || (this.f23209b instanceof ArrayList)) {
            return;
        }
        this.f23209b = new ArrayList(this.f23208a);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        return iE >= 0 ? ((c) this.f23209b.get(iE)).getValue() : this.f23210c.get(comparable);
    }

    public Map.Entry h(int i8) {
        return (Map.Entry) this.f23209b.get(i8);
    }

    public int i() {
        return this.f23209b.size();
    }

    public Iterable j() {
        return this.f23210c.isEmpty() ? b.b() : this.f23210c.entrySet();
    }

    public final SortedMap k() {
        f();
        if (this.f23210c.isEmpty() && !(this.f23210c instanceof TreeMap)) {
            this.f23210c = new TreeMap();
        }
        return (SortedMap) this.f23210c;
    }

    public boolean l() {
        return this.f23211d;
    }

    public void m() {
        if (this.f23211d) {
            return;
        }
        this.f23210c = this.f23210c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f23210c);
        this.f23211d = true;
    }

    public Object o(Comparable comparable, Object obj) {
        f();
        int iE = e(comparable);
        if (iE >= 0) {
            return ((c) this.f23209b.get(iE)).setValue(obj);
        }
        g();
        int i8 = -(iE + 1);
        if (i8 >= this.f23208a) {
            return k().put(comparable, obj);
        }
        int size = this.f23209b.size();
        int i9 = this.f23208a;
        if (size == i9) {
            c cVar = (c) this.f23209b.remove(i9 - 1);
            k().put(cVar.getKey(), cVar.getValue());
        }
        this.f23209b.add(i8, new c(comparable, obj));
        return null;
    }

    public final Object p(int i8) {
        f();
        Object value = ((c) this.f23209b.remove(i8)).getValue();
        if (!this.f23210c.isEmpty()) {
            Iterator it = k().entrySet().iterator();
            this.f23209b.add(new c(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        if (iE >= 0) {
            return p(iE);
        }
        if (this.f23210c.isEmpty()) {
            return null;
        }
        return this.f23210c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f23209b.size() + this.f23210c.size();
    }

    public /* synthetic */ u(int i8, a aVar) {
        this(i8);
    }
}
