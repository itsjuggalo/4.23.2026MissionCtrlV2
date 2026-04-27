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

/* JADX INFO: loaded from: classes.dex */
public final class y extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator f16226i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f16227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f16229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f16232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f16233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f16234h;

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
            y.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y.this.f16230d;
        }
    }

    public final class c extends AbstractSet {

        public class a extends d {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return b().f16248f;
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
            return y.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y.this.f16230d;
        }
    }

    public abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f16239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f16240b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16241c;

        public d() {
            this.f16239a = y.this.f16232f.f16246d;
            this.f16241c = y.this.f16231e;
        }

        public final e b() {
            e eVar = this.f16239a;
            y yVar = y.this;
            if (eVar == yVar.f16232f) {
                throw new NoSuchElementException();
            }
            if (yVar.f16231e != this.f16241c) {
                throw new ConcurrentModificationException();
            }
            this.f16239a = eVar.f16246d;
            this.f16240b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f16239a != y.this.f16232f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f16240b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            y.this.f(eVar, true);
            this.f16240b = null;
            this.f16241c = y.this.f16231e;
        }
    }

    public static final class e implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f16243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f16244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f16245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f16246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f16247e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f16248f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f16249g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f16250h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16251i;

        public e(boolean z7) {
            this.f16248f = null;
            this.f16249g = z7;
            this.f16247e = this;
            this.f16246d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f16244b; eVar2 != null; eVar2 = eVar2.f16244b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f16245c; eVar2 != null; eVar2 = eVar2.f16245c) {
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
            Object obj2 = this.f16248f;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.f16250h;
            Object value = entry.getValue();
            if (obj3 == null) {
                if (value != null) {
                    return false;
                }
            } else if (!obj3.equals(value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f16248f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f16250h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f16248f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f16250h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f16249g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f16250h;
            this.f16250h = obj;
            return obj2;
        }

        public String toString() {
            return this.f16248f + com.amazon.a.a.o.b.f.f14101b + this.f16250h;
        }

        public e(boolean z7, e eVar, Object obj, e eVar2, e eVar3) {
            this.f16243a = eVar;
            this.f16248f = obj;
            this.f16249g = z7;
            this.f16251i = 1;
            this.f16246d = eVar2;
            this.f16247e = eVar3;
            eVar3.f16246d = this;
            eVar2.f16247e = this;
        }
    }

    public y() {
        this(f16226i, true);
    }

    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public e b(Object obj, boolean z7) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f16227a;
        e eVar2 = this.f16229c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f16226i ? (Comparable) obj : null;
            while (true) {
                Object obj2 = eVar2.f16248f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.f16244b : eVar2.f16245c;
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
        e eVar4 = this.f16232f;
        if (eVar2 != null) {
            eVar = new e(this.f16228b, eVar2, obj, eVar4, eVar4.f16247e);
            if (iCompareTo < 0) {
                eVar2.f16244b = eVar;
            } else {
                eVar2.f16245c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f16226i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f16228b, eVar2, obj, eVar4, eVar4.f16247e);
            this.f16229c = eVar;
        }
        this.f16230d++;
        this.f16231e++;
        return eVar;
    }

    public e c(Map.Entry entry) {
        e eVarD = d(entry.getKey());
        if (eVarD == null || !a(eVarD.f16250h, entry.getValue())) {
            return null;
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f16229c = null;
        this.f16230d = 0;
        this.f16231e++;
        e eVar = this.f16232f;
        eVar.f16247e = eVar;
        eVar.f16246d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    public e d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void e(e eVar, boolean z7) {
        while (eVar != null) {
            e eVar2 = eVar.f16244b;
            e eVar3 = eVar.f16245c;
            int i8 = eVar2 != null ? eVar2.f16251i : 0;
            int i9 = eVar3 != null ? eVar3.f16251i : 0;
            int i10 = i8 - i9;
            if (i10 == -2) {
                e eVar4 = eVar3.f16244b;
                e eVar5 = eVar3.f16245c;
                int i11 = (eVar4 != null ? eVar4.f16251i : 0) - (eVar5 != null ? eVar5.f16251i : 0);
                if (i11 != -1 && (i11 != 0 || z7)) {
                    j(eVar3);
                }
                i(eVar);
                if (z7) {
                    return;
                }
            } else if (i10 == 2) {
                e eVar6 = eVar2.f16244b;
                e eVar7 = eVar2.f16245c;
                int i12 = (eVar6 != null ? eVar6.f16251i : 0) - (eVar7 != null ? eVar7.f16251i : 0);
                if (i12 != 1 && (i12 != 0 || z7)) {
                    i(eVar2);
                }
                j(eVar);
                if (z7) {
                    return;
                }
            } else if (i10 == 0) {
                eVar.f16251i = i8 + 1;
                if (z7) {
                    return;
                }
            } else {
                eVar.f16251i = Math.max(i8, i9) + 1;
                if (!z7) {
                    return;
                }
            }
            eVar = eVar.f16243a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f16233g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f16233g = bVar2;
        return bVar2;
    }

    public void f(e eVar, boolean z7) {
        int i8;
        if (z7) {
            e eVar2 = eVar.f16247e;
            eVar2.f16246d = eVar.f16246d;
            eVar.f16246d.f16247e = eVar2;
        }
        e eVar3 = eVar.f16244b;
        e eVar4 = eVar.f16245c;
        e eVar5 = eVar.f16243a;
        int i9 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f16244b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f16245c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f16230d--;
            this.f16231e++;
            return;
        }
        e eVarB = eVar3.f16251i > eVar4.f16251i ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e eVar6 = eVar.f16244b;
        if (eVar6 != null) {
            i8 = eVar6.f16251i;
            eVarB.f16244b = eVar6;
            eVar6.f16243a = eVarB;
            eVar.f16244b = null;
        } else {
            i8 = 0;
        }
        e eVar7 = eVar.f16245c;
        if (eVar7 != null) {
            i9 = eVar7.f16251i;
            eVarB.f16245c = eVar7;
            eVar7.f16243a = eVarB;
            eVar.f16245c = null;
        }
        eVarB.f16251i = Math.max(i8, i9) + 1;
        h(eVar, eVarB);
    }

    public e g(Object obj) {
        e eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f16250h;
        }
        return null;
    }

    public final void h(e eVar, e eVar2) {
        e eVar3 = eVar.f16243a;
        eVar.f16243a = null;
        if (eVar2 != null) {
            eVar2.f16243a = eVar3;
        }
        if (eVar3 == null) {
            this.f16229c = eVar2;
        } else if (eVar3.f16244b == eVar) {
            eVar3.f16244b = eVar2;
        } else {
            eVar3.f16245c = eVar2;
        }
    }

    public final void i(e eVar) {
        e eVar2 = eVar.f16244b;
        e eVar3 = eVar.f16245c;
        e eVar4 = eVar3.f16244b;
        e eVar5 = eVar3.f16245c;
        eVar.f16245c = eVar4;
        if (eVar4 != null) {
            eVar4.f16243a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f16244b = eVar;
        eVar.f16243a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f16251i : 0, eVar4 != null ? eVar4.f16251i : 0) + 1;
        eVar.f16251i = iMax;
        eVar3.f16251i = Math.max(iMax, eVar5 != null ? eVar5.f16251i : 0) + 1;
    }

    public final void j(e eVar) {
        e eVar2 = eVar.f16244b;
        e eVar3 = eVar.f16245c;
        e eVar4 = eVar2.f16244b;
        e eVar5 = eVar2.f16245c;
        eVar.f16244b = eVar5;
        if (eVar5 != null) {
            eVar5.f16243a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f16245c = eVar;
        eVar.f16243a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f16251i : 0, eVar5 != null ? eVar5.f16251i : 0) + 1;
        eVar.f16251i = iMax;
        eVar2.f16251i = Math.max(iMax, eVar4 != null ? eVar4.f16251i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f16234h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f16234h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f16228b) {
            throw new NullPointerException("value == null");
        }
        e eVarB = b(obj, true);
        Object obj3 = eVarB.f16250h;
        eVarB.f16250h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f16250h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f16230d;
    }

    public y(Comparator comparator, boolean z7) {
        this.f16230d = 0;
        this.f16231e = 0;
        this.f16227a = comparator == null ? f16226i : comparator;
        this.f16228b = z7;
        this.f16232f = new e(z7);
    }

    public y(boolean z7) {
        this(f16226i, z7);
    }
}
