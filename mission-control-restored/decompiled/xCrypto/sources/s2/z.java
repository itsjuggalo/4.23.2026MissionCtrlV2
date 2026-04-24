package s2;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class z extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator f14653i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f14654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f14656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f14659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f14660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f14661h;

    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return b();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            z.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && z.this.d((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e eVarD;
            if (!(obj instanceof Map.Entry) || (eVarD = z.this.d((Map.Entry) obj)) == null) {
                return false;
            }
            z.this.g(eVarD, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z.this.f14657d;
        }
    }

    public final class c extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return b().f14675f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            z.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return z.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return z.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z.this.f14657d;
        }
    }

    public abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f14666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f14667b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14668c;

        public d() {
            this.f14666a = z.this.f14659f.f14673d;
            this.f14668c = z.this.f14658e;
        }

        public final e b() {
            e eVar = this.f14666a;
            z zVar = z.this;
            if (eVar == zVar.f14659f) {
                throw new NoSuchElementException();
            }
            if (zVar.f14658e != this.f14668c) {
                throw new ConcurrentModificationException();
            }
            this.f14666a = eVar.f14673d;
            this.f14667b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f14666a != z.this.f14659f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f14667b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            z.this.g(eVar, true);
            this.f14667b = null;
            this.f14668c = z.this.f14658e;
        }
    }

    public z() {
        this(f14653i, true);
    }

    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public e b(Object obj, boolean z4) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f14654a;
        e eVar2 = this.f14656c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f14653i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f14675f) : comparator.compare(obj, eVar2.f14675f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.f14671b : eVar2.f14672c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        e eVar4 = eVar2;
        if (!z4) {
            return null;
        }
        e eVar5 = this.f14659f;
        if (eVar4 != null) {
            eVar = new e(this.f14655b, eVar4, obj, eVar5, eVar5.f14674e);
            if (iCompareTo < 0) {
                eVar4.f14671b = eVar;
            } else {
                eVar4.f14672c = eVar;
            }
            f(eVar4, true);
        } else {
            if (comparator == f14653i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f14655b, eVar4, obj, eVar5, eVar5.f14674e);
            this.f14656c = eVar;
        }
        this.f14657d++;
        this.f14658e++;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f14656c = null;
        this.f14657d = 0;
        this.f14658e++;
        e eVar = this.f14659f;
        eVar.f14674e = eVar;
        eVar.f14673d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return e(obj) != null;
    }

    public e d(Map.Entry entry) {
        e eVarE = e(entry.getKey());
        if (eVarE == null || !a(eVarE.f14677h, entry.getValue())) {
            return null;
        }
        return eVarE;
    }

    public e e(Object obj) {
        if (obj != null) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f14660g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f14660g = bVar2;
        return bVar2;
    }

    public final void f(e eVar, boolean z4) {
        while (eVar != null) {
            e eVar2 = eVar.f14671b;
            e eVar3 = eVar.f14672c;
            int i4 = eVar2 != null ? eVar2.f14678i : 0;
            int i5 = eVar3 != null ? eVar3.f14678i : 0;
            int i6 = i4 - i5;
            if (i6 == -2) {
                e eVar4 = eVar3.f14671b;
                e eVar5 = eVar3.f14672c;
                int i7 = (eVar4 != null ? eVar4.f14678i : 0) - (eVar5 != null ? eVar5.f14678i : 0);
                if (i7 == -1 || (i7 == 0 && !z4)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z4) {
                    return;
                }
            } else if (i6 == 2) {
                e eVar6 = eVar2.f14671b;
                e eVar7 = eVar2.f14672c;
                int i8 = (eVar6 != null ? eVar6.f14678i : 0) - (eVar7 != null ? eVar7.f14678i : 0);
                if (i8 == 1 || (i8 == 0 && !z4)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z4) {
                    return;
                }
            } else if (i6 == 0) {
                eVar.f14678i = i4 + 1;
                if (z4) {
                    return;
                }
            } else {
                eVar.f14678i = Math.max(i4, i5) + 1;
                if (!z4) {
                    return;
                }
            }
            eVar = eVar.f14670a;
        }
    }

    public void g(e eVar, boolean z4) {
        int i4;
        if (z4) {
            e eVar2 = eVar.f14674e;
            eVar2.f14673d = eVar.f14673d;
            eVar.f14673d.f14674e = eVar2;
        }
        e eVar3 = eVar.f14671b;
        e eVar4 = eVar.f14672c;
        e eVar5 = eVar.f14670a;
        int i5 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                i(eVar, eVar3);
                eVar.f14671b = null;
            } else if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f14672c = null;
            } else {
                i(eVar, null);
            }
            f(eVar5, false);
            this.f14657d--;
            this.f14658e++;
            return;
        }
        e eVarB = eVar3.f14678i > eVar4.f14678i ? eVar3.b() : eVar4.a();
        g(eVarB, false);
        e eVar6 = eVar.f14671b;
        if (eVar6 != null) {
            i4 = eVar6.f14678i;
            eVarB.f14671b = eVar6;
            eVar6.f14670a = eVarB;
            eVar.f14671b = null;
        } else {
            i4 = 0;
        }
        e eVar7 = eVar.f14672c;
        if (eVar7 != null) {
            i5 = eVar7.f14678i;
            eVarB.f14672c = eVar7;
            eVar7.f14670a = eVarB;
            eVar.f14672c = null;
        }
        eVarB.f14678i = Math.max(i4, i5) + 1;
        i(eVar, eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarE = e(obj);
        if (eVarE != null) {
            return eVarE.f14677h;
        }
        return null;
    }

    public e h(Object obj) {
        e eVarE = e(obj);
        if (eVarE != null) {
            g(eVarE, true);
        }
        return eVarE;
    }

    public final void i(e eVar, e eVar2) {
        e eVar3 = eVar.f14670a;
        eVar.f14670a = null;
        if (eVar2 != null) {
            eVar2.f14670a = eVar3;
        }
        if (eVar3 == null) {
            this.f14656c = eVar2;
        } else if (eVar3.f14671b == eVar) {
            eVar3.f14671b = eVar2;
        } else {
            eVar3.f14672c = eVar2;
        }
    }

    public final void j(e eVar) {
        e eVar2 = eVar.f14671b;
        e eVar3 = eVar.f14672c;
        e eVar4 = eVar3.f14671b;
        e eVar5 = eVar3.f14672c;
        eVar.f14672c = eVar4;
        if (eVar4 != null) {
            eVar4.f14670a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f14671b = eVar;
        eVar.f14670a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f14678i : 0, eVar4 != null ? eVar4.f14678i : 0) + 1;
        eVar.f14678i = iMax;
        eVar3.f14678i = Math.max(iMax, eVar5 != null ? eVar5.f14678i : 0) + 1;
    }

    public final void k(e eVar) {
        e eVar2 = eVar.f14671b;
        e eVar3 = eVar.f14672c;
        e eVar4 = eVar2.f14671b;
        e eVar5 = eVar2.f14672c;
        eVar.f14671b = eVar5;
        if (eVar5 != null) {
            eVar5.f14670a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f14672c = eVar;
        eVar.f14670a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f14678i : 0, eVar5 != null ? eVar5.f14678i : 0) + 1;
        eVar.f14678i = iMax;
        eVar2.f14678i = Math.max(iMax, eVar4 != null ? eVar4.f14678i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f14661h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f14661h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f14655b) {
            throw new NullPointerException("value == null");
        }
        e eVarB = b(obj, true);
        Object obj3 = eVarB.f14677h;
        eVarB.f14677h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarH = h(obj);
        if (eVarH != null) {
            return eVarH.f14677h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f14657d;
    }

    public z(boolean z4) {
        this(f14653i, z4);
    }

    public z(Comparator comparator, boolean z4) {
        this.f14657d = 0;
        this.f14658e = 0;
        this.f14654a = comparator == null ? f14653i : comparator;
        this.f14655b = z4;
        this.f14659f = new e(z4);
    }

    public static final class e implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f14670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f14671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f14672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f14673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f14674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f14675f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f14676g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f14677h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14678i;

        public e(boolean z4) {
            this.f14675f = null;
            this.f14676g = z4;
            this.f14674e = this;
            this.f14673d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f14671b; eVar2 != null; eVar2 = eVar2.f14671b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f14672c; eVar2 != null; eVar2 = eVar2.f14672c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f14675f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f14677h;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f14675f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f14677h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f14675f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f14677h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f14676g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f14677h;
            this.f14677h = obj;
            return obj2;
        }

        public String toString() {
            return this.f14675f + com.amazon.a.a.o.b.f.f8805b + this.f14677h;
        }

        public e(boolean z4, e eVar, Object obj, e eVar2, e eVar3) {
            this.f14670a = eVar;
            this.f14675f = obj;
            this.f14676g = z4;
            this.f14678i = 1;
            this.f14673d = eVar2;
            this.f14674e = eVar3;
            eVar3.f14673d = this;
            eVar2.f14674e = this;
        }
    }
}
