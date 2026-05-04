package q6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import q6.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f18810b = new b(v.f18833e, 0);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j.a {
        public a() {
            this(4);
        }

        @Override // q6.j.b
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
            this.f18809c = true;
            return k.q(this.f18807a, this.f18808b);
        }

        public a(int i10) {
            super(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends q6.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f18811c;

        public b(k kVar, int i10) {
            super(kVar.size(), i10);
            this.f18811c = kVar;
        }

        @Override // q6.a
        public Object b(int i10) {
            return this.f18811c.get(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient int f18812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f18813d;

        public c(int i10, int i11) {
            this.f18812c = i10;
            this.f18813d = i11;
        }

        @Override // q6.k, java.util.List
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public k subList(int i10, int i11) {
            p6.n.s(i10, i11, this.f18813d);
            k kVar = k.this;
            int i12 = this.f18812c;
            return kVar.subList(i10 + i12, i11 + i12);
        }

        @Override // q6.j
        public Object[] d() {
            return k.this.d();
        }

        @Override // q6.j
        public int e() {
            return k.this.f() + this.f18812c + this.f18813d;
        }

        @Override // q6.j
        public int f() {
            return k.this.f() + this.f18812c;
        }

        @Override // q6.j
        public boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i10) {
            p6.n.l(i10, this.f18813d);
            return k.this.get(i10 + this.f18812c);
        }

        @Override // q6.k, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // q6.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f18813d;
        }

        @Override // q6.k, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }
    }

    public static k A() {
        return v.f18833e;
    }

    public static k G(Object obj) {
        return s(obj);
    }

    public static k K(Object obj, Object obj2) {
        return s(obj, obj2);
    }

    public static k L(Object obj, Object obj2, Object obj3) {
        return s(obj, obj2, obj3);
    }

    public static k R(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return s(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static k S(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        p6.n.e(objArr.length <= 2147483635, "the total number of elements must fit in an int");
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
        return s(objArr2);
    }

    public static k p(Object[] objArr) {
        return q(objArr, objArr.length);
    }

    public static k q(Object[] objArr, int i10) {
        return i10 == 0 ? A() : new v(objArr, i10);
    }

    public static a r() {
        return new a();
    }

    public static k s(Object... objArr) {
        return p(s.b(objArr));
    }

    public static k u(Collection collection) {
        if (!(collection instanceof j)) {
            return s(collection.toArray());
        }
        k kVarA = ((j) collection).a();
        return kVarA.g() ? p(kVarA.toArray()) : kVarA;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: T */
    public k subList(int i10, int i11) {
        p6.n.s(i10, i11, size());
        int i12 = i11 - i10;
        return i12 == size() ? this : i12 == 0 ? A() : U(i10, i11);
    }

    public k U(int i10, int i11) {
        return new c(i10, i11 - i10);
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // q6.j
    public int c(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // q6.j, java.util.AbstractCollection, java.util.Collection
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
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
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
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public b0 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public c0 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public c0 listIterator(int i10) {
        p6.n.q(i10, size());
        return isEmpty() ? f18810b : new b(this, i10);
    }

    @Override // q6.j
    public final k a() {
        return this;
    }
}
