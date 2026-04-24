package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0481p0 extends AbstractC0452b implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0481p0 f5779d = new C0481p0(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f5780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5781c;

    public C0481p0(Object[] objArr, int i, boolean z6) {
        super(z6);
        this.f5780b = objArr;
        this.f5781c = i;
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.f5781c;
        Object[] objArr = this.f5780b;
        if (i == objArr.length) {
            this.f5780b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f5780b;
        int i6 = this.f5781c;
        this.f5781c = i6 + 1;
        objArr2[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.f5781c) {
            StringBuilder sbO = a3.d.o("Index:", i, ", Size:");
            sbO.append(this.f5781c);
            throw new IndexOutOfBoundsException(sbO.toString());
        }
    }

    @Override // com.google.protobuf.L
    public final L d(int i) {
        if (i >= this.f5781c) {
            return new C0481p0(Arrays.copyOf(this.f5780b, i), this.f5781c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.f5780b[i];
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.f5780b;
        Object obj = objArr[i];
        if (i < this.f5781c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f5781c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.f5780b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5781c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        a();
        if (i >= 0 && i <= (i6 = this.f5781c)) {
            Object[] objArr = this.f5780b;
            if (i6 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i6 - i);
            } else {
                Object[] objArr2 = new Object[a3.d.d(i6, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.f5780b, i, objArr2, i + 1, this.f5781c - i);
                this.f5780b = objArr2;
            }
            this.f5780b[i] = obj;
            this.f5781c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbO = a3.d.o("Index:", i, ", Size:");
        sbO.append(this.f5781c);
        throw new IndexOutOfBoundsException(sbO.toString());
    }
}
