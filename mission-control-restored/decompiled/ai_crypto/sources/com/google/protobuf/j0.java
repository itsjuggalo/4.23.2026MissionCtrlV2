package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class j0 extends AbstractC1233c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j0 f12711d = new j0(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f12712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12713c;

    public j0(Object[] objArr, int i7, boolean z7) {
        super(z7);
        this.f12712b = objArr;
        this.f12713c = i7;
    }

    public static Object[] b(int i7) {
        return new Object[i7];
    }

    public static j0 c() {
        return f12711d;
    }

    private void g(int i7) {
        if (i7 < 0 || i7 >= this.f12713c) {
            throw new IndexOutOfBoundsException(h(i7));
        }
    }

    private String h(int i7) {
        return "Index:" + i7 + ", Size:" + this.f12713c;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i7 = this.f12713c;
        Object[] objArr = this.f12712b;
        if (i7 == objArr.length) {
            this.f12712b = Arrays.copyOf(objArr, ((i7 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f12712b;
        int i8 = this.f12713c;
        this.f12713c = i8 + 1;
        objArr2[i8] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i7) {
        g(i7);
        return this.f12712b[i7];
    }

    @Override // com.google.protobuf.C.e
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public j0 e(int i7) {
        if (i7 >= this.f12713c) {
            return new j0(Arrays.copyOf(this.f12712b, i7), this.f12713c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.List
    public Object remove(int i7) {
        a();
        g(i7);
        Object[] objArr = this.f12712b;
        Object obj = objArr[i7];
        if (i7 < this.f12713c - 1) {
            System.arraycopy(objArr, i7 + 1, objArr, i7, (r2 - i7) - 1);
        }
        this.f12713c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i7, Object obj) {
        a();
        g(i7);
        Object[] objArr = this.f12712b;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f12713c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i7, Object obj) {
        int i8;
        a();
        if (i7 >= 0 && i7 <= (i8 = this.f12713c)) {
            Object[] objArr = this.f12712b;
            if (i8 < objArr.length) {
                System.arraycopy(objArr, i7, objArr, i7 + 1, i8 - i7);
            } else {
                Object[] objArrB = b(((i8 * 3) / 2) + 1);
                System.arraycopy(this.f12712b, 0, objArrB, 0, i7);
                System.arraycopy(this.f12712b, i7, objArrB, i7 + 1, this.f12713c - i7);
                this.f12712b = objArrB;
            }
            this.f12712b[i7] = obj;
            this.f12713c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(h(i7));
    }
}
