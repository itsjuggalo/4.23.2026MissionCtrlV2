package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u0 f1917d = new u0(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f1918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1919c;

    public u0(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f1918b = objArr;
        this.f1919c = i10;
    }

    public static Object[] c(int i10) {
        return new Object[i10];
    }

    public static u0 d() {
        return f1917d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i10 = this.f1919c;
        Object[] objArr = this.f1918b;
        if (i10 == objArr.length) {
            this.f1918b = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1918b;
        int i11 = this.f1919c;
        this.f1919c = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void e(int i10) {
        if (i10 < 0 || i10 >= this.f1919c) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    public final String f(int i10) {
        return "Index:" + i10 + ", Size:" + this.f1919c;
    }

    @Override // androidx.datastore.preferences.protobuf.u.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public u0 i(int i10) {
        if (i10 >= this.f1919c) {
            return new u0(Arrays.copyOf(this.f1918b, i10), this.f1919c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        e(i10);
        return this.f1918b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.List
    public Object remove(int i10) {
        a();
        e(i10);
        Object[] objArr = this.f1918b;
        Object obj = objArr[i10];
        if (i10 < this.f1919c - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f1919c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        a();
        e(i10);
        Object[] objArr = this.f1918b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1919c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        int i11;
        a();
        if (i10 >= 0 && i10 <= (i11 = this.f1919c)) {
            Object[] objArr = this.f1918b;
            if (i11 < objArr.length) {
                System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
            } else {
                Object[] objArrC = c(((i11 * 3) / 2) + 1);
                System.arraycopy(this.f1918b, 0, objArrC, 0, i10);
                System.arraycopy(this.f1918b, i10, objArrC, i10 + 1, this.f1919c - i10);
                this.f1918b = objArrC;
            }
            this.f1918b[i10] = obj;
            this.f1919c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(f(i10));
    }
}
