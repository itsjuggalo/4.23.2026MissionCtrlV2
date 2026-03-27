package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class V extends AbstractC0932c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final V f7367d = new V(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f7368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7369c;

    public V(Object[] objArr, int i7, boolean z7) {
        super(z7);
        this.f7368b = objArr;
        this.f7369c = i7;
    }

    public static Object[] b(int i7) {
        return new Object[i7];
    }

    public static V c() {
        return f7367d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i7 = this.f7369c;
        Object[] objArr = this.f7368b;
        if (i7 == objArr.length) {
            this.f7368b = Arrays.copyOf(objArr, ((i7 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f7368b;
        int i8 = this.f7369c;
        this.f7369c = i8 + 1;
        objArr2[i8] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void g(int i7) {
        if (i7 < 0 || i7 >= this.f7369c) {
            throw new IndexOutOfBoundsException(h(i7));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i7) {
        g(i7);
        return this.f7368b[i7];
    }

    public final String h(int i7) {
        return "Index:" + i7 + ", Size:" + this.f7369c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0949u.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public V e(int i7) {
        if (i7 >= this.f7369c) {
            return new V(Arrays.copyOf(this.f7368b, i7), this.f7369c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0932c, java.util.AbstractList, java.util.List
    public Object remove(int i7) {
        a();
        g(i7);
        Object[] objArr = this.f7368b;
        Object obj = objArr[i7];
        if (i7 < this.f7369c - 1) {
            System.arraycopy(objArr, i7 + 1, objArr, i7, (r2 - i7) - 1);
        }
        this.f7369c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i7, Object obj) {
        a();
        g(i7);
        Object[] objArr = this.f7368b;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f7369c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i7, Object obj) {
        int i8;
        a();
        if (i7 >= 0 && i7 <= (i8 = this.f7369c)) {
            Object[] objArr = this.f7368b;
            if (i8 < objArr.length) {
                System.arraycopy(objArr, i7, objArr, i7 + 1, i8 - i7);
            } else {
                Object[] objArrB = b(((i8 * 3) / 2) + 1);
                System.arraycopy(this.f7368b, 0, objArrB, 0, i7);
                System.arraycopy(this.f7368b, i7, objArrB, i7 + 1, this.f7369c - i7);
                this.f7368b = objArrB;
            }
            this.f7368b[i7] = obj;
            this.f7369c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(h(i7));
    }
}
