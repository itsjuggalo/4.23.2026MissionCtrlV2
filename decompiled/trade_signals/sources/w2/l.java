package w2;

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
import w2.AbstractC2921j;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Map, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map.Entry[] f24015d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m f24016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient m f24017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient AbstractC2921j f24018c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Comparator f24019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f24020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0421a f24023e;

        /* JADX INFO: renamed from: w2.l$a$a, reason: collision with other inner class name */
        public static final class C0421a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f24024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f24025b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f24026c;

            public C0421a(Object obj, Object obj2, Object obj3) {
                this.f24024a = obj;
                this.f24025b = obj2;
                this.f24026c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f24024a + com.amazon.a.a.o.b.f.f14101b + this.f24025b + " and " + this.f24024a + com.amazon.a.a.o.b.f.f14101b + this.f24026c);
            }
        }

        public a() {
            this(4);
        }

        public static void j(Object[] objArr, int i8, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = i9 * 2;
                Object obj = objArr[i10];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i10 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i9] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i8, t.a(comparator).b(q.c()));
            for (int i11 = 0; i11 < i8; i11++) {
                int i12 = i11 * 2;
                objArr[i12] = entryArr[i11].getKey();
                objArr[i12 + 1] = entryArr[i11].getValue();
            }
        }

        public l a() {
            return c();
        }

        public final l b(boolean z7) {
            Object[] objArrE;
            C0421a c0421a;
            C0421a c0421a2;
            if (z7 && (c0421a2 = this.f24023e) != null) {
                throw c0421a2.a();
            }
            int length = this.f24021c;
            if (this.f24019a == null) {
                objArrE = this.f24020b;
            } else {
                if (this.f24022d) {
                    this.f24020b = Arrays.copyOf(this.f24020b, length * 2);
                }
                objArrE = this.f24020b;
                if (!z7) {
                    objArrE = e(objArrE, this.f24021c);
                    if (objArrE.length < this.f24020b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                j(objArrE, length, this.f24019a);
            }
            this.f24022d = true;
            w wVarP = w.p(length, objArrE, this);
            if (!z7 || (c0421a = this.f24023e) == null) {
                return wVarP;
            }
            throw c0421a.a();
        }

        public l c() {
            return b(true);
        }

        public final void d(int i8) {
            int i9 = i8 * 2;
            Object[] objArr = this.f24020b;
            if (i9 > objArr.length) {
                this.f24020b = Arrays.copyOf(objArr, AbstractC2921j.b.c(objArr.length, i9));
                this.f24022d = false;
            }
        }

        public final Object[] e(Object[] objArr, int i8) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i9 = i8 - 1; i9 >= 0; i9--) {
                Object obj = objArr[i9 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i9);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i8 - bitSet.cardinality()) * 2];
            int i10 = 0;
            int i11 = 0;
            while (i10 < i8 * 2) {
                if (bitSet.get(i10 >>> 1)) {
                    i10 += 2;
                } else {
                    int i12 = i11 + 1;
                    int i13 = i10 + 1;
                    Object obj2 = objArr[i10];
                    Objects.requireNonNull(obj2);
                    objArr2[i11] = obj2;
                    i11 += 2;
                    i10 += 2;
                    Object obj3 = objArr[i13];
                    Objects.requireNonNull(obj3);
                    objArr2[i12] = obj3;
                }
            }
            return objArr2;
        }

        public a f(Object obj, Object obj2) {
            d(this.f24021c + 1);
            AbstractC2915d.a(obj, obj2);
            Object[] objArr = this.f24020b;
            int i8 = this.f24021c;
            objArr[i8 * 2] = obj;
            objArr[(i8 * 2) + 1] = obj2;
            this.f24021c = i8 + 1;
            return this;
        }

        public a g(Map.Entry entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a h(Iterable iterable) {
            if (iterable instanceof Collection) {
                d(this.f24021c + ((Collection) iterable).size());
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

        public a(int i8) {
            this.f24020b = new Object[i8 * 2];
            this.f24021c = 0;
            this.f24022d = false;
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
            if (!lVar.h()) {
                return lVar;
            }
        }
        return b(map.entrySet());
    }

    public static l j() {
        return w.f24036h;
    }

    public static l k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        AbstractC2915d.a(obj, obj2);
        AbstractC2915d.a(obj3, obj4);
        AbstractC2915d.a(obj5, obj6);
        AbstractC2915d.a(obj7, obj8);
        return w.o(4, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8});
    }

    public static l l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        AbstractC2915d.a(obj, obj2);
        AbstractC2915d.a(obj3, obj4);
        AbstractC2915d.a(obj5, obj6);
        AbstractC2915d.a(obj7, obj8);
        AbstractC2915d.a(obj9, obj10);
        return w.o(5, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10});
    }

    public static l m(Map.Entry... entryArr) {
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

    public abstract m d();

    public abstract m e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return q.a(this, obj);
    }

    public abstract AbstractC2921j f();

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public m entrySet() {
        m mVar = this.f24016a;
        if (mVar != null) {
            return mVar;
        }
        m mVarD = d();
        this.f24016a = mVarD;
        return mVarD;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public abstract boolean h();

    @Override // java.util.Map
    public int hashCode() {
        return y.b(entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public m keySet() {
        m mVar = this.f24017b;
        if (mVar != null) {
            return mVar;
        }
        m mVarE = e();
        this.f24017b = mVarE;
        return mVarE;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public AbstractC2921j values() {
        AbstractC2921j abstractC2921j = this.f24018c;
        if (abstractC2921j != null) {
            return abstractC2921j;
        }
        AbstractC2921j abstractC2921jF = f();
        this.f24018c = abstractC2921jF;
        return abstractC2921jF;
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
