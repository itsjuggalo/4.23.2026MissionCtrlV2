package a2;

import a2.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C f6133b = new b(v.f6156e, 0);

    public static final class a extends j.a {
        public a() {
            this(4);
        }

        @Override // a2.j.b
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
            this.f6132c = true;
            return k.o(this.f6130a, this.f6131b);
        }

        public a(int i4) {
            super(i4);
        }
    }

    public static class b extends AbstractC0782a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f6134c;

        public b(k kVar, int i4) {
            super(kVar.size(), i4);
            this.f6134c = kVar;
        }

        @Override // a2.AbstractC0782a
        public Object b(int i4) {
            return this.f6134c.get(i4);
        }
    }

    public class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f6135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f6136d;

        public c(int i4, int i5) {
            this.f6135c = i4;
            this.f6136d = i5;
        }

        @Override // a2.k, java.util.List
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public k subList(int i4, int i5) {
            Z1.m.s(i4, i5, this.f6136d);
            k kVar = k.this;
            int i6 = this.f6135c;
            return kVar.subList(i4 + i6, i5 + i6);
        }

        @Override // java.util.List
        public Object get(int i4) {
            Z1.m.l(i4, this.f6136d);
            return k.this.get(i4 + this.f6135c);
        }

        @Override // a2.j
        public Object[] i() {
            return k.this.i();
        }

        @Override // a2.k, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // a2.j
        public int k() {
            return k.this.l() + this.f6135c + this.f6136d;
        }

        @Override // a2.j
        public int l() {
            return k.this.l() + this.f6135c;
        }

        @Override // a2.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // a2.j
        public boolean m() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f6136d;
        }

        @Override // a2.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return super.listIterator(i4);
        }
    }

    public static k A(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        Z1.m.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
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
        return q(objArr2);
    }

    public static k n(Object[] objArr) {
        return o(objArr, objArr.length);
    }

    public static k o(Object[] objArr, int i4) {
        return i4 == 0 ? v() : new v(objArr, i4);
    }

    public static a p() {
        return new a();
    }

    public static k q(Object... objArr) {
        return n(s.b(objArr));
    }

    public static k r(Collection collection) {
        if (!(collection instanceof j)) {
            return q(collection.toArray());
        }
        k kVarC = ((j) collection).c();
        return kVarC.m() ? n(kVarC.toArray()) : kVarC;
    }

    public static k v() {
        return v.f6156e;
    }

    public static k w(Object obj) {
        return q(obj);
    }

    public static k x(Object obj, Object obj2) {
        return q(obj, obj2);
    }

    public static k y(Object obj, Object obj2, Object obj3) {
        return q(obj, obj2, obj3);
    }

    public static k z(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return q(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: B */
    public k subList(int i4, int i5) {
        Z1.m.s(i4, i5, size());
        int i6 = i5 - i4;
        return i6 == size() ? this : i6 == 0 ? v() : C(i4, i5);
    }

    public k C(int i4, int i5) {
        return new c(i4, i5 - i4);
    }

    @Override // java.util.List
    public final void add(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return o.b(this, obj);
    }

    @Override // a2.j
    public int f(Object[] objArr, int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i4 + i5] = get(i5);
        }
        return i4 + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i4 = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = ~(~((i4 * 31) + get(i5).hashCode()));
        }
        return i4;
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
    public final Object remove(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public B iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public final Object set(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public C listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public C listIterator(int i4) {
        Z1.m.q(i4, size());
        return isEmpty() ? f6133b : new b(this, i4);
    }

    @Override // a2.j
    public final k c() {
        return this;
    }
}
