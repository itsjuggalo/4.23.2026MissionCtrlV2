package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class V extends AbstractC1101c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final V f11179d = new V(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f11180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11181c;

    public V(Object[] objArr, int i8, boolean z7) {
        super(z7);
        this.f11180b = objArr;
        this.f11181c = i8;
    }

    public static Object[] d(int i8) {
        return new Object[i8];
    }

    public static V e() {
        return f11179d;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        int i9;
        a();
        if (i8 < 0 || i8 > (i9 = this.f11181c)) {
            throw new IndexOutOfBoundsException(h(i8));
        }
        Object[] objArr = this.f11180b;
        if (i9 < objArr.length) {
            System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
        } else {
            Object[] objArrD = d(((i9 * 3) / 2) + 1);
            System.arraycopy(this.f11180b, 0, objArrD, 0, i8);
            System.arraycopy(this.f11180b, i8, objArrD, i8 + 1, this.f11181c - i8);
            this.f11180b = objArrD;
        }
        this.f11180b[i8] = obj;
        this.f11181c++;
        ((AbstractList) this).modCount++;
    }

    public final void f(int i8) {
        if (i8 < 0 || i8 >= this.f11181c) {
            throw new IndexOutOfBoundsException(h(i8));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        f(i8);
        return this.f11180b[i8];
    }

    public final String h(int i8) {
        return "Index:" + i8 + ", Size:" + this.f11181c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1118u.b
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public V i(int i8) {
        if (i8 >= this.f11181c) {
            return new V(Arrays.copyOf(this.f11180b, i8), this.f11181c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1101c, java.util.AbstractList, java.util.List
    public Object remove(int i8) {
        a();
        f(i8);
        Object[] objArr = this.f11180b;
        Object obj = objArr[i8];
        if (i8 < this.f11181c - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (r2 - i8) - 1);
        }
        this.f11181c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        a();
        f(i8);
        Object[] objArr = this.f11180b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11181c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i8 = this.f11181c;
        Object[] objArr = this.f11180b;
        if (i8 == objArr.length) {
            this.f11180b = Arrays.copyOf(objArr, ((i8 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f11180b;
        int i9 = this.f11181c;
        this.f11181c = i9 + 1;
        objArr2[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
