package w2;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: w2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2921j extends AbstractCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f24006a = new Object[0];

    /* JADX INFO: renamed from: w2.j$a */
    public static abstract class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f24007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f24008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24009c;

        public a(int i8) {
            AbstractC2915d.b(i8, "initialCapacity");
            this.f24007a = new Object[i8];
            this.f24008b = 0;
        }

        @Override // w2.AbstractC2921j.b
        public b b(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(this.f24008b + collection.size());
                if (collection instanceof AbstractC2921j) {
                    this.f24008b = ((AbstractC2921j) collection).d(this.f24007a, this.f24008b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a d(Object obj) {
            AbstractC2848n.n(obj);
            g(this.f24008b + 1);
            Object[] objArr = this.f24007a;
            int i8 = this.f24008b;
            this.f24008b = i8 + 1;
            objArr[i8] = obj;
            return this;
        }

        public b e(Object... objArr) {
            f(objArr, objArr.length);
            return this;
        }

        public final void f(Object[] objArr, int i8) {
            s.c(objArr, i8);
            g(this.f24008b + i8);
            System.arraycopy(objArr, 0, this.f24007a, this.f24008b, i8);
            this.f24008b += i8;
        }

        public final void g(int i8) {
            Object[] objArr = this.f24007a;
            if (objArr.length < i8) {
                this.f24007a = Arrays.copyOf(objArr, b.c(objArr.length, i8));
            } else if (!this.f24009c) {
                return;
            } else {
                this.f24007a = (Object[]) objArr.clone();
            }
            this.f24009c = false;
        }
    }

    /* JADX INFO: renamed from: w2.j$b */
    public static abstract class b {
        public static int c(int i8, int i9) {
            if (i9 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i8 + (i8 >> 1) + 1;
            if (iHighestOneBit < i9) {
                iHighestOneBit = Integer.highestOneBit(i9 - 1) << 1;
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

    public abstract k a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    public abstract int d(Object[] objArr, int i8);

    public Object[] e() {
        return null;
    }

    public int f() {
        throw new UnsupportedOperationException();
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean n();

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
        return toArray(f24006a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC2848n.n(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrE = e();
            if (objArrE != null) {
                return u.a(objArrE, h(), f(), objArr);
            }
            objArr = s.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        d(objArr, 0);
        return objArr;
    }
}
