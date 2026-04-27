package n4;

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
    public static final Comparator f19682i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f19683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f19685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f19688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f19689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f19690h;

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
            return z.this.f19686d;
        }
    }

    public final class c extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return b().f19704f;
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
            return z.this.f19686d;
        }
    }

    public abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f19695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f19696b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19697c;

        public d() {
            this.f19695a = z.this.f19688f.f19702d;
            this.f19697c = z.this.f19687e;
        }

        public final e b() {
            e eVar = this.f19695a;
            z zVar = z.this;
            if (eVar == zVar.f19688f) {
                throw new NoSuchElementException();
            }
            if (zVar.f19687e != this.f19697c) {
                throw new ConcurrentModificationException();
            }
            this.f19695a = eVar.f19702d;
            this.f19696b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f19695a != z.this.f19688f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f19696b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            z.this.g(eVar, true);
            this.f19696b = null;
            this.f19697c = z.this.f19687e;
        }
    }

    public z() {
        this(f19682i, true);
    }

    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public e c(Object obj, boolean z7) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f19683a;
        e eVar2 = this.f19685c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f19682i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f19704f) : comparator.compare(obj, eVar2.f19704f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.f19700b : eVar2.f19701c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z7) {
            return null;
        }
        e eVar4 = this.f19688f;
        if (eVar2 != null) {
            eVar = new e(this.f19684b, eVar2, obj, eVar4, eVar4.f19703e);
            if (iCompareTo < 0) {
                eVar2.f19700b = eVar;
            } else {
                eVar2.f19701c = eVar;
            }
            f(eVar2, true);
        } else {
            if (comparator == f19682i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f19684b, eVar2, obj, eVar4, eVar4.f19703e);
            this.f19685c = eVar;
        }
        this.f19686d++;
        this.f19687e++;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f19685c = null;
        this.f19686d = 0;
        this.f19687e++;
        e eVar = this.f19688f;
        eVar.f19703e = eVar;
        eVar.f19702d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return e(obj) != null;
    }

    public e d(Map.Entry entry) {
        e eVarE = e(entry.getKey());
        if (eVarE == null || !a(eVarE.f19706h, entry.getValue())) {
            return null;
        }
        return eVarE;
    }

    public e e(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return c(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f19689g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f19689g = bVar2;
        return bVar2;
    }

    public final void f(e eVar, boolean z7) {
        while (eVar != null) {
            e eVar2 = eVar.f19700b;
            e eVar3 = eVar.f19701c;
            int i7 = eVar2 != null ? eVar2.f19707i : 0;
            int i8 = eVar3 != null ? eVar3.f19707i : 0;
            int i9 = i7 - i8;
            if (i9 == -2) {
                e eVar4 = eVar3.f19700b;
                e eVar5 = eVar3.f19701c;
                int i10 = (eVar4 != null ? eVar4.f19707i : 0) - (eVar5 != null ? eVar5.f19707i : 0);
                if (i10 == -1 || (i10 == 0 && !z7)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 2) {
                e eVar6 = eVar2.f19700b;
                e eVar7 = eVar2.f19701c;
                int i11 = (eVar6 != null ? eVar6.f19707i : 0) - (eVar7 != null ? eVar7.f19707i : 0);
                if (i11 == 1 || (i11 == 0 && !z7)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 0) {
                eVar.f19707i = i7 + 1;
                if (z7) {
                    return;
                }
            } else {
                eVar.f19707i = Math.max(i7, i8) + 1;
                if (!z7) {
                    return;
                }
            }
            eVar = eVar.f19699a;
        }
    }

    public void g(e eVar, boolean z7) {
        int i7;
        if (z7) {
            e eVar2 = eVar.f19703e;
            eVar2.f19702d = eVar.f19702d;
            eVar.f19702d.f19703e = eVar2;
        }
        e eVar3 = eVar.f19700b;
        e eVar4 = eVar.f19701c;
        e eVar5 = eVar.f19699a;
        int i8 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                i(eVar, eVar3);
                eVar.f19700b = null;
            } else if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f19701c = null;
            } else {
                i(eVar, null);
            }
            f(eVar5, false);
            this.f19686d--;
            this.f19687e++;
            return;
        }
        e eVarB = eVar3.f19707i > eVar4.f19707i ? eVar3.b() : eVar4.a();
        g(eVarB, false);
        e eVar6 = eVar.f19700b;
        if (eVar6 != null) {
            i7 = eVar6.f19707i;
            eVarB.f19700b = eVar6;
            eVar6.f19699a = eVarB;
            eVar.f19700b = null;
        } else {
            i7 = 0;
        }
        e eVar7 = eVar.f19701c;
        if (eVar7 != null) {
            i8 = eVar7.f19707i;
            eVarB.f19701c = eVar7;
            eVar7.f19699a = eVarB;
            eVar.f19701c = null;
        }
        eVarB.f19707i = Math.max(i7, i8) + 1;
        i(eVar, eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarE = e(obj);
        if (eVarE != null) {
            return eVarE.f19706h;
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
        e eVar3 = eVar.f19699a;
        eVar.f19699a = null;
        if (eVar2 != null) {
            eVar2.f19699a = eVar3;
        }
        if (eVar3 == null) {
            this.f19685c = eVar2;
        } else if (eVar3.f19700b == eVar) {
            eVar3.f19700b = eVar2;
        } else {
            eVar3.f19701c = eVar2;
        }
    }

    public final void j(e eVar) {
        e eVar2 = eVar.f19700b;
        e eVar3 = eVar.f19701c;
        e eVar4 = eVar3.f19700b;
        e eVar5 = eVar3.f19701c;
        eVar.f19701c = eVar4;
        if (eVar4 != null) {
            eVar4.f19699a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f19700b = eVar;
        eVar.f19699a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f19707i : 0, eVar4 != null ? eVar4.f19707i : 0) + 1;
        eVar.f19707i = iMax;
        eVar3.f19707i = Math.max(iMax, eVar5 != null ? eVar5.f19707i : 0) + 1;
    }

    public final void k(e eVar) {
        e eVar2 = eVar.f19700b;
        e eVar3 = eVar.f19701c;
        e eVar4 = eVar2.f19700b;
        e eVar5 = eVar2.f19701c;
        eVar.f19700b = eVar5;
        if (eVar5 != null) {
            eVar5.f19699a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f19701c = eVar;
        eVar.f19699a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f19707i : 0, eVar5 != null ? eVar5.f19707i : 0) + 1;
        eVar.f19707i = iMax;
        eVar2.f19707i = Math.max(iMax, eVar4 != null ? eVar4.f19707i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f19690h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f19690h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f19684b) {
            throw new NullPointerException("value == null");
        }
        e eVarC = c(obj, true);
        Object obj3 = eVarC.f19706h;
        eVarC.f19706h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarH = h(obj);
        if (eVarH != null) {
            return eVarH.f19706h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f19686d;
    }

    public z(boolean z7) {
        this(f19682i, z7);
    }

    public z(Comparator comparator, boolean z7) {
        this.f19686d = 0;
        this.f19687e = 0;
        this.f19683a = comparator == null ? f19682i : comparator;
        this.f19684b = z7;
        this.f19688f = new e(z7);
    }

    public static final class e implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f19699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f19700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f19701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f19702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f19703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f19704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f19705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f19706h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19707i;

        public e(boolean z7) {
            this.f19704f = null;
            this.f19705g = z7;
            this.f19703e = this;
            this.f19702d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f19700b; eVar2 != null; eVar2 = eVar2.f19700b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f19701c; eVar2 != null; eVar2 = eVar2.f19701c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f19704f;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.f19706h;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f19704f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f19706h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f19704f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f19706h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f19705g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f19706h;
            this.f19706h = obj;
            return obj2;
        }

        public String toString() {
            return this.f19704f + com.amazon.a.a.o.b.f.f9990b + this.f19706h;
        }

        public e(boolean z7, e eVar, Object obj, e eVar2, e eVar3) {
            this.f19699a = eVar;
            this.f19704f = obj;
            this.f19705g = z7;
            this.f19707i = 1;
            this.f19702d = eVar2;
            this.f19703e = eVar3;
            eVar3.f19702d = this;
            eVar2.f19703e = this;
        }
    }
}
