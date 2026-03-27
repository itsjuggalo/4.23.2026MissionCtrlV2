package a2;

import a2.j;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Map, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map.Entry[] f6138d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m f6139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient m f6140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient j f6141c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator f6142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f6143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0087a f6146e;

        /* JADX INFO: renamed from: a2.l$a$a, reason: collision with other inner class name */
        public static final class C0087a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f6147a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f6148b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f6149c;

            public C0087a(Object obj, Object obj2, Object obj3) {
                this.f6147a = obj;
                this.f6148b = obj2;
                this.f6149c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f6147a + com.amazon.a.a.o.b.f.f8805b + this.f6148b + " and " + this.f6147a + com.amazon.a.a.o.b.f.f8805b + this.f6149c);
            }
        }

        public a() {
            this(4);
        }

        public static void j(Object[] objArr, int i4, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 2;
                Object obj = objArr[i6];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i6 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i5] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i4, t.a(comparator).b(q.c()));
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = i7 * 2;
                objArr[i8] = entryArr[i7].getKey();
                objArr[i8 + 1] = entryArr[i7].getValue();
            }
        }

        public l a() {
            return c();
        }

        public final l b(boolean z4) {
            Object[] objArrE;
            C0087a c0087a;
            C0087a c0087a2;
            if (z4 && (c0087a2 = this.f6146e) != null) {
                throw c0087a2.a();
            }
            int length = this.f6144c;
            if (this.f6142a == null) {
                objArrE = this.f6143b;
            } else {
                if (this.f6145d) {
                    this.f6143b = Arrays.copyOf(this.f6143b, length * 2);
                }
                objArrE = this.f6143b;
                if (!z4) {
                    objArrE = e(objArrE, this.f6144c);
                    if (objArrE.length < this.f6143b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                j(objArrE, length, this.f6142a);
            }
            this.f6145d = true;
            w wVarQ = w.q(length, objArrE, this);
            if (!z4 || (c0087a = this.f6146e) == null) {
                return wVarQ;
            }
            throw c0087a.a();
        }

        public l c() {
            return b(true);
        }

        public final void d(int i4) {
            int i5 = i4 * 2;
            Object[] objArr = this.f6143b;
            if (i5 > objArr.length) {
                this.f6143b = Arrays.copyOf(objArr, j.b.c(objArr.length, i5));
                this.f6145d = false;
            }
        }

        public final Object[] e(Object[] objArr, int i4) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                Object obj = objArr[i5 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i5);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i4 - bitSet.cardinality()) * 2];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4 * 2) {
                if (bitSet.get(i6 >>> 1)) {
                    i6 += 2;
                } else {
                    int i8 = i7 + 1;
                    int i9 = i6 + 1;
                    Object obj2 = objArr[i6];
                    Objects.requireNonNull(obj2);
                    objArr2[i7] = obj2;
                    i7 += 2;
                    i6 += 2;
                    Object obj3 = objArr[i9];
                    Objects.requireNonNull(obj3);
                    objArr2[i8] = obj3;
                }
            }
            return objArr2;
        }

        public a f(Object obj, Object obj2) {
            d(this.f6144c + 1);
            d.a(obj, obj2);
            Object[] objArr = this.f6143b;
            int i4 = this.f6144c;
            objArr[i4 * 2] = obj;
            objArr[(i4 * 2) + 1] = obj2;
            this.f6144c = i4 + 1;
            return this;
        }

        public a g(Map.Entry entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a h(Iterable iterable) {
            if (iterable instanceof Collection) {
                d(this.f6144c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                g((Map.Entry) it.next());
            }
            return this;
        }

        public a i(Map map) {
            return h(map.entrySet());
        }

        public a(int i4) {
            this.f6143b = new Object[i4 * 2];
            this.f6144c = 0;
            this.f6145d = false;
        }
    }

    public static a a() {
        return new a();
    }

    public static l b(Iterable iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.h(iterable);
        return aVar.a();
    }

    public static l d(Map map) {
        if ((map instanceof l) && !(map instanceof SortedMap)) {
            l lVar = (l) map;
            if (!lVar.i()) {
                return lVar;
            }
        }
        return b(map.entrySet());
    }

    public static l k() {
        return w.f6159h;
    }

    public static l l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        d.a(obj, obj2);
        d.a(obj3, obj4);
        d.a(obj5, obj6);
        d.a(obj7, obj8);
        return w.p(4, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8});
    }

    public static l m(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        d.a(obj, obj2);
        d.a(obj3, obj4);
        d.a(obj5, obj6);
        d.a(obj7, obj8);
        d.a(obj9, obj10);
        return w.p(5, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10});
    }

    public static l n(Map.Entry... entryArr) {
        return b(Arrays.asList(entryArr));
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract m e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return q.a(this, obj);
    }

    public abstract m f();

    public abstract j g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public m entrySet() {
        m mVar = this.f6139a;
        if (mVar != null) {
            return mVar;
        }
        m mVarE = e();
        this.f6139a = mVarE;
        return mVarE;
    }

    @Override // java.util.Map
    public int hashCode() {
        return y.b(entrySet());
    }

    public abstract boolean i();

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public m keySet() {
        m mVar = this.f6140b;
        if (mVar != null) {
            return mVar;
        }
        m mVarF = f();
        this.f6140b = mVarF;
        return mVarF;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public j values() {
        j jVar = this.f6141c;
        if (jVar != null) {
            return jVar;
        }
        j jVarG = g();
        this.f6141c = jVarG;
        return jVarG;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return q.b(this);
    }
}
