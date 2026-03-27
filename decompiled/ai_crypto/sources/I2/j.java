package I2;

import com.google.android.gms.common.api.a;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends AbstractCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f2958a = new Object[0];

    public static abstract class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f2959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2961c;

        public a(int i7) {
            d.b(i7, "initialCapacity");
            this.f2959a = new Object[i7];
            this.f2960b = 0;
        }

        @Override // I2.j.b
        public b b(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(this.f2960b + collection.size());
                if (collection instanceof j) {
                    this.f2960b = ((j) collection).b(this.f2959a, this.f2960b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a d(Object obj) {
            H2.m.n(obj);
            g(this.f2960b + 1);
            Object[] objArr = this.f2959a;
            int i7 = this.f2960b;
            this.f2960b = i7 + 1;
            objArr[i7] = obj;
            return this;
        }

        public b e(Object... objArr) {
            f(objArr, objArr.length);
            return this;
        }

        public final void f(Object[] objArr, int i7) {
            s.c(objArr, i7);
            g(this.f2960b + i7);
            System.arraycopy(objArr, 0, this.f2959a, this.f2960b, i7);
            this.f2960b += i7;
        }

        public final void g(int i7) {
            Object[] objArr = this.f2959a;
            if (objArr.length < i7) {
                this.f2959a = Arrays.copyOf(objArr, b.c(objArr.length, i7));
                this.f2961c = false;
            } else if (this.f2961c) {
                this.f2959a = (Object[]) objArr.clone();
                this.f2961c = false;
            }
        }
    }

    public static abstract class b {
        public static int c(int i7, int i8) {
            if (i8 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i7 + (i7 >> 1) + 1;
            if (iHighestOneBit < i8) {
                iHighestOneBit = Integer.highestOneBit(i8 - 1) << 1;
            }
            return iHighestOneBit < 0 ? a.e.API_PRIORITY_OTHER : iHighestOneBit;
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

    public abstract int b(Object[] objArr, int i7);

    public Object[] c() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    public int g() {
        throw new UnsupportedOperationException();
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean j();

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
        return toArray(f2958a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        H2.m.n(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrC = c();
            if (objArrC != null) {
                return u.a(objArrC, h(), g(), objArr);
            }
            objArr = s.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        b(objArr, 0);
        return objArr;
    }
}
