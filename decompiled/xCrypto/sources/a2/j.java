package a2;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends AbstractCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f6129a = new Object[0];

    public static abstract class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f6130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6132c;

        public a(int i4) {
            d.b(i4, "initialCapacity");
            this.f6130a = new Object[i4];
            this.f6131b = 0;
        }

        @Override // a2.j.b
        public b b(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(this.f6131b + collection.size());
                if (collection instanceof j) {
                    this.f6131b = ((j) collection).f(this.f6130a, this.f6131b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a d(Object obj) {
            Z1.m.n(obj);
            g(this.f6131b + 1);
            Object[] objArr = this.f6130a;
            int i4 = this.f6131b;
            this.f6131b = i4 + 1;
            objArr[i4] = obj;
            return this;
        }

        public b e(Object... objArr) {
            f(objArr, objArr.length);
            return this;
        }

        public final void f(Object[] objArr, int i4) {
            s.c(objArr, i4);
            g(this.f6131b + i4);
            System.arraycopy(objArr, 0, this.f6130a, this.f6131b, i4);
            this.f6131b += i4;
        }

        public final void g(int i4) {
            Object[] objArr = this.f6130a;
            if (objArr.length < i4) {
                this.f6130a = Arrays.copyOf(objArr, b.c(objArr.length, i4));
                this.f6132c = false;
            } else if (this.f6132c) {
                this.f6130a = (Object[]) objArr.clone();
                this.f6132c = false;
            }
        }
    }

    public static abstract class b {
        public static int c(int i4, int i5) {
            if (i5 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i4 + (i4 >> 1) + 1;
            if (iHighestOneBit < i5) {
                iHighestOneBit = Integer.highestOneBit(i5 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public abstract b a(Object obj);

        public b b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public abstract k c();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    public abstract int f(Object[] objArr, int i4);

    public Object[] i() {
        return null;
    }

    public int k() {
        throw new UnsupportedOperationException();
    }

    public int l() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean m();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f6129a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Z1.m.n(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrI = i();
            if (objArrI != null) {
                return u.a(objArrI, l(), k(), objArr);
            }
            objArr = s.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        f(objArr, 0);
        return objArr;
    }
}
