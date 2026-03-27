package w2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import v2.AbstractC2848n;
import w2.AbstractC2921j;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends AbstractC2921j implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2911C f24010b = new b(v.f24033e, 0);

    public static final class a extends AbstractC2921j.a {
        public a() {
            this(4);
        }

        @Override // w2.AbstractC2921j.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            super.d(obj);
            return this;
        }

        public a i(Object... objArr) {
            super.e(objArr);
            return this;
        }

        public a j(Iterable iterable) {
            super.b(iterable);
            return this;
        }

        public k k() {
            this.f24009c = true;
            return k.F(this.f24007a, this.f24008b);
        }

        public a(int i8) {
            super(i8);
        }
    }

    public static class b extends AbstractC2912a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f24011c;

        public b(k kVar, int i8) {
            super(kVar.size(), i8);
            this.f24011c = kVar;
        }

        @Override // w2.AbstractC2912a
        public Object b(int i8) {
            return this.f24011c.get(i8);
        }
    }

    public class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f24012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f24013d;

        public c(int i8, int i9) {
            this.f24012c = i8;
            this.f24013d = i9;
        }

        @Override // w2.k, java.util.List
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public k subList(int i8, int i9) {
            AbstractC2848n.s(i8, i9, this.f24013d);
            k kVar = k.this;
            int i10 = this.f24012c;
            return kVar.subList(i8 + i10, i9 + i10);
        }

        @Override // w2.AbstractC2921j
        public Object[] e() {
            return k.this.e();
        }

        @Override // w2.AbstractC2921j
        public int f() {
            return k.this.h() + this.f24012c + this.f24013d;
        }

        @Override // java.util.List
        public Object get(int i8) {
            AbstractC2848n.l(i8, this.f24013d);
            return k.this.get(i8 + this.f24012c);
        }

        @Override // w2.AbstractC2921j
        public int h() {
            return k.this.h() + this.f24012c;
        }

        @Override // w2.k, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // w2.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // w2.AbstractC2921j
        public boolean n() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f24013d;
        }

        @Override // w2.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i8) {
            return super.listIterator(i8);
        }
    }

    public static k C(Object[] objArr) {
        return F(objArr, objArr.length);
    }

    public static k F(Object[] objArr, int i8) {
        return i8 == 0 ? N() : new v(objArr, i8);
    }

    public static a H() {
        return new a();
    }

    public static k I(Object... objArr) {
        return C(s.b(objArr));
    }

    public static k J(Collection collection) {
        if (!(collection instanceof AbstractC2921j)) {
            return I(collection.toArray());
        }
        k kVarA = ((AbstractC2921j) collection).a();
        return kVarA.n() ? C(kVarA.toArray()) : kVarA;
    }

    public static k N() {
        return v.f24033e;
    }

    public static k O(Object obj) {
        return I(obj);
    }

    public static k P(Object obj, Object obj2) {
        return I(obj, obj2);
    }

    public static k Q(Object obj, Object obj2, Object obj3) {
        return I(obj, obj2, obj3);
    }

    public static k R(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return I(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static k S(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        AbstractC2848n.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[objArr.length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        return I(objArr2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public AbstractC2910B iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public AbstractC2911C listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public AbstractC2911C listIterator(int i8) {
        AbstractC2848n.q(i8, size());
        return isEmpty() ? f24010b : new b(this, i8);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: T */
    public k subList(int i8, int i9) {
        AbstractC2848n.s(i8, i9, size());
        int i10 = i9 - i8;
        return i10 == size() ? this : i10 == 0 ? N() : U(i8, i9);
    }

    public k U(int i8, int i9) {
        return new c(i8, i9 - i8);
    }

    @Override // java.util.List
    public final void add(int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i8, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // w2.AbstractC2921j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // w2.AbstractC2921j
    public int d(Object[] objArr, int i8) {
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            objArr[i8 + i9] = get(i9);
        }
        return i8 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return o.b(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i8 = 1;
        for (int i9 = 0; i9 < size; i9++) {
            i8 = ~(~((i8 * 31) + get(i9).hashCode()));
        }
        return i8;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return o.c(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return o.e(this, obj);
    }

    @Override // java.util.List
    public final Object remove(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // w2.AbstractC2921j
    public final k a() {
        return this;
    }
}
