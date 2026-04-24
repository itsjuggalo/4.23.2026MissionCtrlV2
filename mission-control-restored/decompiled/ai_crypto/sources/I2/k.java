package I2;

import I2.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C f2962b = new b(v.f2985e, 0);

    public static final class a extends j.a {
        public a() {
            this(4);
        }

        @Override // I2.j.b
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
            this.f2961c = true;
            return k.l(this.f2959a, this.f2960b);
        }

        public a(int i7) {
            super(i7);
        }
    }

    public static class b extends AbstractC0583a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f2963c;

        public b(k kVar, int i7) {
            super(kVar.size(), i7);
            this.f2963c = kVar;
        }

        @Override // I2.AbstractC0583a
        public Object b(int i7) {
            return this.f2963c.get(i7);
        }
    }

    public class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f2964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f2965d;

        public c(int i7, int i8) {
            this.f2964c = i7;
            this.f2965d = i8;
        }

        @Override // I2.k, java.util.List
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public k subList(int i7, int i8) {
            H2.m.s(i7, i8, this.f2965d);
            k kVar = k.this;
            int i9 = this.f2964c;
            return kVar.subList(i7 + i9, i8 + i9);
        }

        @Override // I2.j
        public Object[] c() {
            return k.this.c();
        }

        @Override // I2.j
        public int g() {
            return k.this.h() + this.f2964c + this.f2965d;
        }

        @Override // java.util.List
        public Object get(int i7) {
            H2.m.l(i7, this.f2965d);
            return k.this.get(i7 + this.f2964c);
        }

        @Override // I2.j
        public int h() {
            return k.this.h() + this.f2964c;
        }

        @Override // I2.k, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // I2.j
        public boolean j() {
            return true;
        }

        @Override // I2.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f2965d;
        }

        @Override // I2.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i7) {
            return super.listIterator(i7);
        }
    }

    public static k A(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        H2.m.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
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
        return n(objArr2);
    }

    public static k k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    public static k l(Object[] objArr, int i7) {
        return i7 == 0 ? t() : new v(objArr, i7);
    }

    public static a m() {
        return new a();
    }

    public static k n(Object... objArr) {
        return k(s.b(objArr));
    }

    public static k p(Collection collection) {
        if (!(collection instanceof j)) {
            return n(collection.toArray());
        }
        k kVarA = ((j) collection).a();
        return kVarA.j() ? k(kVarA.toArray()) : kVarA;
    }

    public static k t() {
        return v.f2985e;
    }

    public static k u(Object obj) {
        return n(obj);
    }

    public static k w(Object obj, Object obj2) {
        return n(obj, obj2);
    }

    public static k x(Object obj, Object obj2, Object obj3) {
        return n(obj, obj2, obj3);
    }

    public static k y(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return n(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: B */
    public k subList(int i7, int i8) {
        H2.m.s(i7, i8, size());
        int i9 = i8 - i7;
        return i9 == size() ? this : i9 == 0 ? t() : C(i7, i8);
    }

    public k C(int i7, int i8) {
        return new c(i7, i8 - i7);
    }

    @Override // java.util.List
    public final void add(int i7, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i7, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // I2.j
    public int b(Object[] objArr, int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i7 + i8] = get(i8);
        }
        return i7 + size;
    }

    @Override // I2.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return o.b(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i7 = 1;
        for (int i8 = 0; i8 < size; i8++) {
            i7 = ~(~((i7 * 31) + get(i8).hashCode()));
        }
        return i7;
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public B iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public C listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public C listIterator(int i7) {
        H2.m.q(i7, size());
        return isEmpty() ? f2962b : new b(this, i7);
    }

    @Override // java.util.List
    public final Object set(int i7, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // I2.j
    public final k a() {
        return this;
    }
}
