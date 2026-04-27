package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class V extends AbstractC0790c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final V f6959d = new V(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f6960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6961c;

    public V(Object[] objArr, int i4, boolean z4) {
        super(z4);
        this.f6960b = objArr;
        this.f6961c = i4;
    }

    public static Object[] f(int i4) {
        return new Object[i4];
    }

    public static V i() {
        return f6959d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        c();
        int i4 = this.f6961c;
        Object[] objArr = this.f6960b;
        if (i4 == objArr.length) {
            this.f6960b = Arrays.copyOf(objArr, ((i4 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f6960b;
        int i5 = this.f6961c;
        this.f6961c = i5 + 1;
        objArr2[i5] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i4) {
        k(i4);
        return this.f6960b[i4];
    }

    public final void k(int i4) {
        if (i4 < 0 || i4 >= this.f6961c) {
            throw new IndexOutOfBoundsException(l(i4));
        }
    }

    public final String l(int i4) {
        return "Index:" + i4 + ", Size:" + this.f6961c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0807u.b
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public V a(int i4) {
        if (i4 >= this.f6961c) {
            return new V(Arrays.copyOf(this.f6960b, i4), this.f6961c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0790c, java.util.AbstractList, java.util.List
    public Object remove(int i4) {
        c();
        k(i4);
        Object[] objArr = this.f6960b;
        Object obj = objArr[i4];
        if (i4 < this.f6961c - 1) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, (r2 - i4) - 1);
        }
        this.f6961c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i4, Object obj) {
        c();
        k(i4);
        Object[] objArr = this.f6960b;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6961c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i4, Object obj) {
        int i5;
        c();
        if (i4 >= 0 && i4 <= (i5 = this.f6961c)) {
            Object[] objArr = this.f6960b;
            if (i5 < objArr.length) {
                System.arraycopy(objArr, i4, objArr, i4 + 1, i5 - i4);
            } else {
                Object[] objArrF = f(((i5 * 3) / 2) + 1);
                System.arraycopy(this.f6960b, 0, objArrF, 0, i4);
                System.arraycopy(this.f6960b, i4, objArrF, i4 + 1, this.f6961c - i4);
                this.f6960b = objArrF;
            }
            this.f6960b[i4] = obj;
            this.f6961c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(l(i4));
    }
}
