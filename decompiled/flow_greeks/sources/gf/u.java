package gf;

import gf.h;
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
public abstract class u extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f10712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile e f10714e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends u {
        public a(int i10) {
            super(i10, null);
        }

        @Override // gf.u
        public void n() {
            if (!m()) {
                for (int i10 = 0; i10 < j(); i10++) {
                    Map.Entry entryI = i(i10);
                    if (((h.b) entryI.getKey()).e()) {
                        entryI.setValue(Collections.unmodifiableList((List) entryI.getValue()));
                    }
                }
                for (Map.Entry entry : k()) {
                    if (((h.b) entry.getKey()).e()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.n();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.p((h.b) obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator f10715a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable f10716b = new C0193b();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

        /* JADX INFO: renamed from: gf.u$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0193b implements Iterable {
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return b.f10715a;
            }
        }

        public static Iterable b() {
            return f10716b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Comparable, Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparable f10717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f10718b;

        public c(u uVar, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
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
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.f10717a;
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
            return b(this.f10717a, entry.getKey()) && b(this.f10718b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f10718b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.f10717a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f10718b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            u.this.g();
            Object obj2 = this.f10718b;
            this.f10718b = obj;
            return obj2;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f10717a);
            String strValueOf2 = String.valueOf(this.f10718b);
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb2.append(strValueOf);
            sb2.append(com.amazon.a.a.o.b.f.f4599b);
            sb2.append(strValueOf2);
            return sb2.toString();
        }

        public c(Comparable comparable, Object obj) {
            this.f10717a = comparable;
            this.f10718b = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e extends AbstractSet {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            u.this.p((Comparable) entry.getKey(), entry.getValue());
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
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
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

    public /* synthetic */ u(int i10, a aVar) {
        this(i10);
    }

    public static u o(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f10711b.isEmpty()) {
            this.f10711b.clear();
        }
        if (this.f10712c.isEmpty()) {
            return;
        }
        this.f10712c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f10712c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f10714e == null) {
            this.f10714e = new e(this, null);
        }
        return this.f10714e;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f10711b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.f10711b
            java.lang.Object r2 = r2.get(r1)
            gf.u$c r2 = (gf.u.c) r2
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
            java.util.List r3 = r4.f10711b
            java.lang.Object r3 = r3.get(r2)
            gf.u$c r3 = (gf.u.c) r3
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
        throw new UnsupportedOperationException("Method not decompiled: gf.u.f(java.lang.Comparable):int");
    }

    public final void g() {
        if (this.f10713d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((c) this.f10711b.get(iF)).getValue() : this.f10712c.get(comparable);
    }

    public final void h() {
        g();
        if (!this.f10711b.isEmpty() || (this.f10711b instanceof ArrayList)) {
            return;
        }
        this.f10711b = new ArrayList(this.f10710a);
    }

    public Map.Entry i(int i10) {
        return (Map.Entry) this.f10711b.get(i10);
    }

    public int j() {
        return this.f10711b.size();
    }

    public Iterable k() {
        return this.f10712c.isEmpty() ? b.b() : this.f10712c.entrySet();
    }

    public final SortedMap l() {
        g();
        if (this.f10712c.isEmpty() && !(this.f10712c instanceof TreeMap)) {
            this.f10712c = new TreeMap();
        }
        return (SortedMap) this.f10712c;
    }

    public boolean m() {
        return this.f10713d;
    }

    public void n() {
        if (this.f10713d) {
            return;
        }
        this.f10712c = this.f10712c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f10712c);
        this.f10713d = true;
    }

    public Object p(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((c) this.f10711b.get(iF)).setValue(obj);
        }
        h();
        int i10 = -(iF + 1);
        if (i10 >= this.f10710a) {
            return l().put(comparable, obj);
        }
        int size = this.f10711b.size();
        int i11 = this.f10710a;
        if (size == i11) {
            c cVar = (c) this.f10711b.remove(i11 - 1);
            l().put(cVar.getKey(), cVar.getValue());
        }
        this.f10711b.add(i10, new c(comparable, obj));
        return null;
    }

    public final Object q(int i10) {
        g();
        Object value = ((c) this.f10711b.remove(i10)).getValue();
        if (!this.f10712c.isEmpty()) {
            Iterator it = l().entrySet().iterator();
            this.f10711b.add(new c(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return q(iF);
        }
        if (this.f10712c.isEmpty()) {
            return null;
        }
        return this.f10712c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f10711b.size() + this.f10712c.size();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator f10722c;

        public d() {
            this.f10720a = -1;
        }

        public final Iterator b() {
            if (this.f10722c == null) {
                this.f10722c = u.this.f10712c.entrySet().iterator();
            }
            return this.f10722c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.f10721b = true;
            int i10 = this.f10720a + 1;
            this.f10720a = i10;
            return i10 < u.this.f10711b.size() ? (Map.Entry) u.this.f10711b.get(this.f10720a) : (Map.Entry) b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10720a + 1 < u.this.f10711b.size() || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f10721b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f10721b = false;
            u.this.g();
            if (this.f10720a >= u.this.f10711b.size()) {
                b().remove();
                return;
            }
            u uVar = u.this;
            int i10 = this.f10720a;
            this.f10720a = i10 - 1;
            uVar.q(i10);
        }

        public /* synthetic */ d(u uVar, a aVar) {
            this();
        }
    }

    public u(int i10) {
        this.f10710a = i10;
        this.f10711b = Collections.EMPTY_LIST;
        this.f10712c = Collections.EMPTY_MAP;
    }
}
