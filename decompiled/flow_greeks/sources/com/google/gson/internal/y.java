package com.google.gson.internal;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator f6850i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f6851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f6853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f6856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f6857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f6858h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends AbstractSet {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            y.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && y.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = y.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            y.this.g(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y.this.f6854d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c extends AbstractSet {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return b().f6872f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            y.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return y.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return y.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y.this.f6854d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f6863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f6864b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6865c;

        public d() {
            this.f6863a = y.this.f6856f.f6870d;
            this.f6865c = y.this.f6855e;
        }

        public final e b() {
            e eVar = this.f6863a;
            y yVar = y.this;
            if (eVar == yVar.f6856f) {
                throw new NoSuchElementException();
            }
            if (yVar.f6855e != this.f6865c) {
                throw new ConcurrentModificationException();
            }
            this.f6863a = eVar.f6870d;
            this.f6864b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f6863a != y.this.f6856f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f6864b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            y.this.g(eVar, true);
            this.f6864b = null;
            this.f6865c = y.this.f6855e;
        }
    }

    public y() {
        this(f6850i, true);
    }

    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public e b(Object obj, boolean z10) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f6851a;
        e eVar2 = this.f6853c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f6850i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f6872f) : comparator.compare(obj, eVar2.f6872f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.f6868b : eVar2.f6869c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        e eVar4 = eVar2;
        if (!z10) {
            return null;
        }
        e eVar5 = this.f6856f;
        if (eVar4 != null) {
            eVar = new e(this.f6852b, eVar4, obj, eVar5, eVar5.f6871e);
            if (iCompareTo < 0) {
                eVar4.f6868b = eVar;
            } else {
                eVar4.f6869c = eVar;
            }
            f(eVar4, true);
        } else {
            if (comparator == f6850i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f6852b, eVar4, obj, eVar5, eVar5.f6871e);
            this.f6853c = eVar;
        }
        this.f6854d++;
        this.f6855e++;
        return eVar;
    }

    public e c(Map.Entry entry) {
        e eVarE = e(entry.getKey());
        if (eVarE == null || !a(eVarE.f6874h, entry.getValue())) {
            return null;
        }
        return eVarE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f6853c = null;
        this.f6854d = 0;
        this.f6855e++;
        e eVar = this.f6856f;
        eVar.f6871e = eVar;
        eVar.f6870d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return e(obj) != null;
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
        b bVar = this.f6857g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f6857g = bVar2;
        return bVar2;
    }

    public final void f(e eVar, boolean z10) {
        while (eVar != null) {
            e eVar2 = eVar.f6868b;
            e eVar3 = eVar.f6869c;
            int i10 = eVar2 != null ? eVar2.f6875i : 0;
            int i11 = eVar3 != null ? eVar3.f6875i : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e eVar4 = eVar3.f6868b;
                e eVar5 = eVar3.f6869c;
                int i13 = (eVar4 != null ? eVar4.f6875i : 0) - (eVar5 != null ? eVar5.f6875i : 0);
                if (i13 == -1 || (i13 == 0 && !z10)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                e eVar6 = eVar2.f6868b;
                e eVar7 = eVar2.f6869c;
                int i14 = (eVar6 != null ? eVar6.f6875i : 0) - (eVar7 != null ? eVar7.f6875i : 0);
                if (i14 == 1 || (i14 == 0 && !z10)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f6875i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f6875i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f6867a;
        }
    }

    public void g(e eVar, boolean z10) {
        int i10;
        if (z10) {
            e eVar2 = eVar.f6871e;
            eVar2.f6870d = eVar.f6870d;
            eVar.f6870d.f6871e = eVar2;
        }
        e eVar3 = eVar.f6868b;
        e eVar4 = eVar.f6869c;
        e eVar5 = eVar.f6867a;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                i(eVar, eVar3);
                eVar.f6868b = null;
            } else if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f6869c = null;
            } else {
                i(eVar, null);
            }
            f(eVar5, false);
            this.f6854d--;
            this.f6855e++;
            return;
        }
        e eVarB = eVar3.f6875i > eVar4.f6875i ? eVar3.b() : eVar4.a();
        g(eVarB, false);
        e eVar6 = eVar.f6868b;
        if (eVar6 != null) {
            i10 = eVar6.f6875i;
            eVarB.f6868b = eVar6;
            eVar6.f6867a = eVarB;
            eVar.f6868b = null;
        } else {
            i10 = 0;
        }
        e eVar7 = eVar.f6869c;
        if (eVar7 != null) {
            i11 = eVar7.f6875i;
            eVarB.f6869c = eVar7;
            eVar7.f6867a = eVarB;
            eVar.f6869c = null;
        }
        eVarB.f6875i = Math.max(i10, i11) + 1;
        i(eVar, eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarE = e(obj);
        if (eVarE != null) {
            return eVarE.f6874h;
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
        e eVar3 = eVar.f6867a;
        eVar.f6867a = null;
        if (eVar2 != null) {
            eVar2.f6867a = eVar3;
        }
        if (eVar3 == null) {
            this.f6853c = eVar2;
        } else if (eVar3.f6868b == eVar) {
            eVar3.f6868b = eVar2;
        } else {
            eVar3.f6869c = eVar2;
        }
    }

    public final void j(e eVar) {
        e eVar2 = eVar.f6868b;
        e eVar3 = eVar.f6869c;
        e eVar4 = eVar3.f6868b;
        e eVar5 = eVar3.f6869c;
        eVar.f6869c = eVar4;
        if (eVar4 != null) {
            eVar4.f6867a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f6868b = eVar;
        eVar.f6867a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f6875i : 0, eVar4 != null ? eVar4.f6875i : 0) + 1;
        eVar.f6875i = iMax;
        eVar3.f6875i = Math.max(iMax, eVar5 != null ? eVar5.f6875i : 0) + 1;
    }

    public final void k(e eVar) {
        e eVar2 = eVar.f6868b;
        e eVar3 = eVar.f6869c;
        e eVar4 = eVar2.f6868b;
        e eVar5 = eVar2.f6869c;
        eVar.f6868b = eVar5;
        if (eVar5 != null) {
            eVar5.f6867a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f6869c = eVar;
        eVar.f6867a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f6875i : 0, eVar5 != null ? eVar5.f6875i : 0) + 1;
        eVar.f6875i = iMax;
        eVar2.f6875i = Math.max(iMax, eVar4 != null ? eVar4.f6875i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f6858h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f6858h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f6852b) {
            throw new NullPointerException("value == null");
        }
        e eVarB = b(obj, true);
        Object obj3 = eVarB.f6874h;
        eVarB.f6874h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarH = h(obj);
        if (eVarH != null) {
            return eVarH.f6874h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f6854d;
    }

    public y(boolean z10) {
        this(f6850i, z10);
    }

    public y(Comparator comparator, boolean z10) {
        this.f6854d = 0;
        this.f6855e = 0;
        this.f6851a = comparator == null ? f6850i : comparator;
        this.f6852b = z10;
        this.f6856f = new e(z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f6867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f6868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f6869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f6870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f6871e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f6872f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f6873g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f6874h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6875i;

        public e(boolean z10) {
            this.f6872f = null;
            this.f6873g = z10;
            this.f6871e = this;
            this.f6870d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f6868b; eVar2 != null; eVar2 = eVar2.f6868b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f6869c; eVar2 != null; eVar2 = eVar2.f6869c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f6872f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f6874h;
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
            return this.f6872f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f6874h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f6872f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f6874h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f6873g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f6874h;
            this.f6874h = obj;
            return obj2;
        }

        public String toString() {
            return this.f6872f + com.amazon.a.a.o.b.f.f4599b + this.f6874h;
        }

        public e(boolean z10, e eVar, Object obj, e eVar2, e eVar3) {
            this.f6867a = eVar;
            this.f6872f = obj;
            this.f6873g = z10;
            this.f6875i = 1;
            this.f6870d = eVar2;
            this.f6871e = eVar3;
            eVar3.f6870d = this;
            eVar2.f6871e = this;
        }
    }
}
