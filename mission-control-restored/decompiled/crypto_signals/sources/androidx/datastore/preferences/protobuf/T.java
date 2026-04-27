package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class T extends AbstractC0320b implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final T f4512d = new T(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f4513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4514c;

    public T(Object[] objArr, int i, boolean z6) {
        this.f4536a = z6;
        this.f4513b = objArr;
        this.f4514c = i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.f4514c;
        Object[] objArr = this.f4513b;
        if (i == objArr.length) {
            this.f4513b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f4513b;
        int i6 = this.f4514c;
        this.f4514c = i6 + 1;
        objArr2[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.f4514c) {
            StringBuilder sbO = a3.d.o("Index:", i, ", Size:");
            sbO.append(this.f4514c);
            throw new IndexOutOfBoundsException(sbO.toString());
        }
    }

    public final T c(int i) {
        if (i >= this.f4514c) {
            return new T(Arrays.copyOf(this.f4513b, i), this.f4514c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.f4513b[i];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0320b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.f4513b;
        Object obj = objArr[i];
        if (i < this.f4514c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f4514c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.f4513b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4514c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        a();
        if (i >= 0 && i <= (i6 = this.f4514c)) {
            Object[] objArr = this.f4513b;
            if (i6 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i6 - i);
            } else {
                Object[] objArr2 = new Object[a3.d.d(i6, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.f4513b, i, objArr2, i + 1, this.f4514c - i);
                this.f4513b = objArr2;
            }
            this.f4513b[i] = obj;
            this.f4514c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbO = a3.d.o("Index:", i, ", Size:");
        sbO.append(this.f4514c);
        throw new IndexOutOfBoundsException(sbO.toString());
    }
}
