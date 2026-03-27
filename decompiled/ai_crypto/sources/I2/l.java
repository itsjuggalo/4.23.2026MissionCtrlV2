package I2;

import I2.j;
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
    public static final Map.Entry[] f2967d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m f2968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient m f2969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient j f2970c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator f2971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f2972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0031a f2975e;

        /* JADX INFO: renamed from: I2.l$a$a, reason: collision with other inner class name */
        public static final class C0031a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f2976a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f2977b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f2978c;

            public C0031a(Object obj, Object obj2, Object obj3) {
                this.f2976a = obj;
                this.f2977b = obj2;
                this.f2978c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f2976a + com.amazon.a.a.o.b.f.f9990b + this.f2977b + " and " + this.f2976a + com.amazon.a.a.o.b.f.f9990b + this.f2978c);
            }
        }

        public a() {
            this(4);
        }

        public static void j(Object[] objArr, int i7, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = i8 * 2;
                Object obj = objArr[i9];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i9 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i8] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i7, t.a(comparator).b(q.c()));
            for (int i10 = 0; i10 < i7; i10++) {
                int i11 = i10 * 2;
                objArr[i11] = entryArr[i10].getKey();
                objArr[i11 + 1] = entryArr[i10].getValue();
            }
        }

        public l a() {
            return c();
        }

        public final l b(boolean z7) {
            Object[] objArrE;
            C0031a c0031a;
            C0031a c0031a2;
            if (z7 && (c0031a2 = this.f2975e) != null) {
                throw c0031a2.a();
            }
            int length = this.f2973c;
            if (this.f2971a == null) {
                objArrE = this.f2972b;
            } else {
                if (this.f2974d) {
                    this.f2972b = Arrays.copyOf(this.f2972b, length * 2);
                }
                objArrE = this.f2972b;
                if (!z7) {
                    objArrE = e(objArrE, this.f2973c);
                    if (objArrE.length < this.f2972b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                j(objArrE, length, this.f2971a);
            }
            this.f2974d = true;
            w wVarQ = w.q(length, objArrE, this);
            if (!z7 || (c0031a = this.f2975e) == null) {
                return wVarQ;
            }
            throw c0031a.a();
        }

        public l c() {
            return b(true);
        }

        public final void d(int i7) {
            int i8 = i7 * 2;
            Object[] objArr = this.f2972b;
            if (i8 > objArr.length) {
                this.f2972b = Arrays.copyOf(objArr, j.b.c(objArr.length, i8));
                this.f2974d = false;
            }
        }

        public final Object[] e(Object[] objArr, int i7) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i8 = i7 - 1; i8 >= 0; i8--) {
                Object obj = objArr[i8 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i8);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i7 - bitSet.cardinality()) * 2];
            int i9 = 0;
            int i10 = 0;
            while (i9 < i7 * 2) {
                if (bitSet.get(i9 >>> 1)) {
                    i9 += 2;
                } else {
                    int i11 = i10 + 1;
                    int i12 = i9 + 1;
                    Object obj2 = objArr[i9];
                    Objects.requireNonNull(obj2);
                    objArr2[i10] = obj2;
                    i10 += 2;
                    i9 += 2;
                    Object obj3 = objArr[i12];
                    Objects.requireNonNull(obj3);
                    objArr2[i11] = obj3;
                }
            }
            return objArr2;
        }

        public a f(Object obj, Object obj2) {
            d(this.f2973c + 1);
            d.a(obj, obj2);
            Object[] objArr = this.f2972b;
            int i7 = this.f2973c;
            objArr[i7 * 2] = obj;
            objArr[(i7 * 2) + 1] = obj2;
            this.f2973c = i7 + 1;
            return this;
        }

        public a g(Map.Entry entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a h(Iterable iterable) {
            if (iterable instanceof Collection) {
                d(this.f2973c + ((Collection) iterable).size());
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

        public a(int i7) {
            this.f2972b = new Object[i7 * 2];
            this.f2973c = 0;
            this.f2974d = false;
        }
    }

    public static a a() {
        return new a();
    }

    public static l c(Iterable iterable) {
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
        return c(map.entrySet());
    }

    public static l k() {
        return w.f2988h;
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
        return c(Arrays.asList(entryArr));
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
        m mVar = this.f2968a;
        if (mVar != null) {
            return mVar;
        }
        m mVarE = e();
        this.f2968a = mVarE;
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
        m mVar = this.f2969b;
        if (mVar != null) {
            return mVar;
        }
        m mVarF = f();
        this.f2969b = mVarF;
        return mVarF;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public j values() {
        j jVar = this.f2970c;
        if (jVar != null) {
            return jVar;
        }
        j jVarG = g();
        this.f2970c = jVarG;
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
