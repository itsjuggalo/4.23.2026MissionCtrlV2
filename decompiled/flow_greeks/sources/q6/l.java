package q6;

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
import q6.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Map, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map.Entry[] f18815d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m f18816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient m f18817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient j f18818c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator f18819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f18820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0323a f18823e;

        /* JADX INFO: renamed from: q6.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0323a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f18824a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f18825b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f18826c;

            public C0323a(Object obj, Object obj2, Object obj3) {
                this.f18824a = obj;
                this.f18825b = obj2;
                this.f18826c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f18824a + com.amazon.a.a.o.b.f.f4599b + this.f18825b + " and " + this.f18824a + com.amazon.a.a.o.b.f.f4599b + this.f18826c);
            }
        }

        public a() {
            this(4);
        }

        public static void j(Object[] objArr, int i10, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, t.a(comparator).b(q.c()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public l a() {
            return c();
        }

        public final l b(boolean z10) {
            Object[] objArrE;
            C0323a c0323a;
            C0323a c0323a2;
            if (z10 && (c0323a2 = this.f18823e) != null) {
                throw c0323a2.a();
            }
            int length = this.f18821c;
            if (this.f18819a == null) {
                objArrE = this.f18820b;
            } else {
                if (this.f18822d) {
                    this.f18820b = Arrays.copyOf(this.f18820b, length * 2);
                }
                objArrE = this.f18820b;
                if (!z10) {
                    objArrE = e(objArrE, this.f18821c);
                    if (objArrE.length < this.f18820b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                j(objArrE, length, this.f18819a);
            }
            this.f18822d = true;
            w wVarQ = w.q(length, objArrE, this);
            if (!z10 || (c0323a = this.f18823e) == null) {
                return wVarQ;
            }
            throw c0323a.a();
        }

        public l c() {
            return b(true);
        }

        public final void d(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f18820b;
            if (i11 > objArr.length) {
                this.f18820b = Arrays.copyOf(objArr, j.b.c(objArr.length, i11));
                this.f18822d = false;
            }
        }

        public final Object[] e(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 += 2;
                    i12 += 2;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        public a f(Object obj, Object obj2) {
            d(this.f18821c + 1);
            d.a(obj, obj2);
            Object[] objArr = this.f18820b;
            int i10 = this.f18821c;
            objArr[i10 * 2] = obj;
            objArr[(i10 * 2) + 1] = obj2;
            this.f18821c = i10 + 1;
            return this;
        }

        public a g(Map.Entry entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a h(Iterable iterable) {
            if (iterable instanceof Collection) {
                d(this.f18821c + ((Collection) iterable).size());
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

        public a(int i10) {
            this.f18820b = new Object[i10 * 2];
            this.f18821c = 0;
            this.f18822d = false;
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

    public static l c(Map map) {
        if ((map instanceof l) && !(map instanceof SortedMap)) {
            l lVar = (l) map;
            if (!lVar.i()) {
                return lVar;
            }
        }
        return b(map.entrySet());
    }

    public static l k() {
        return w.f18836h;
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
        m mVar = this.f18816a;
        if (mVar != null) {
            return mVar;
        }
        m mVarE = e();
        this.f18816a = mVarE;
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
        m mVar = this.f18817b;
        if (mVar != null) {
            return mVar;
        }
        m mVarF = f();
        this.f18817b = mVarF;
        return mVarF;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public j values() {
        j jVar = this.f18818c;
        if (jVar != null) {
            return jVar;
        }
        j jVarG = g();
        this.f18818c = jVarG;
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
