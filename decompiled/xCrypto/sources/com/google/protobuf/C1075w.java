package com.google.protobuf;

import com.google.protobuf.C;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1075w extends AbstractC1054c implements C.f, RandomAccess, h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1075w f11244d = new C1075w(new float[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f11245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11246c;

    public C1075w(float[] fArr, int i4, boolean z4) {
        super(z4);
        this.f11245b = fArr;
        this.f11246c = i4;
    }

    public static C1075w m() {
        return f11244d;
    }

    private void n(int i4) {
        if (i4 < 0 || i4 >= this.f11246c) {
            throw new IndexOutOfBoundsException(q(i4));
        }
    }

    private String q(int i4) {
        return "Index:" + i4 + ", Size:" + this.f11246c;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        c();
        C.a(collection);
        if (!(collection instanceof C1075w)) {
            return super.addAll(collection);
        }
        C1075w c1075w = (C1075w) collection;
        int i4 = c1075w.f11246c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f11246c;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        float[] fArr = this.f11245b;
        if (i6 > fArr.length) {
            this.f11245b = Arrays.copyOf(fArr, i6);
        }
        System.arraycopy(c1075w.f11245b, 0, this.f11245b, this.f11246c, c1075w.f11246c);
        this.f11246c = i6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1075w)) {
            return super.equals(obj);
        }
        C1075w c1075w = (C1075w) obj;
        if (this.f11246c != c1075w.f11246c) {
            return false;
        }
        float[] fArr = c1075w.f11245b;
        for (int i4 = 0; i4 < this.f11246c; i4++) {
            if (Float.floatToIntBits(this.f11245b[i4]) != Float.floatToIntBits(fArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i4, Float f4) {
        l(i4, f4.floatValue());
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i4 = 0; i4 < this.f11246c; i4++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f11245b[i4]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f4) {
        k(f4.floatValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f11245b[i4] == fFloatValue) {
                return i4;
            }
        }
        return -1;
    }

    public void k(float f4) {
        c();
        int i4 = this.f11246c;
        float[] fArr = this.f11245b;
        if (i4 == fArr.length) {
            float[] fArr2 = new float[((i4 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i4);
            this.f11245b = fArr2;
        }
        float[] fArr3 = this.f11245b;
        int i5 = this.f11246c;
        this.f11246c = i5 + 1;
        fArr3[i5] = f4;
    }

    public final void l(int i4, float f4) {
        int i5;
        c();
        if (i4 < 0 || i4 > (i5 = this.f11246c)) {
            throw new IndexOutOfBoundsException(q(i4));
        }
        float[] fArr = this.f11245b;
        if (i5 < fArr.length) {
            System.arraycopy(fArr, i4, fArr, i4 + 1, i5 - i4);
        } else {
            float[] fArr2 = new float[((i5 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i4);
            System.arraycopy(this.f11245b, i4, fArr2, i4 + 1, this.f11246c - i4);
            this.f11245b = fArr2;
        }
        this.f11245b[i4] = f4;
        this.f11246c++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Float get(int i4) {
        return Float.valueOf(p(i4));
    }

    public float p(int i4) {
        n(i4);
        return this.f11245b[i4];
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float remove(int i4) {
        c();
        n(i4);
        float[] fArr = this.f11245b;
        float f4 = fArr[i4];
        if (i4 < this.f11246c - 1) {
            System.arraycopy(fArr, i4 + 1, fArr, i4, (r2 - i4) - 1);
        }
        this.f11246c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i4, int i5) {
        c();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f11245b;
        System.arraycopy(fArr, i5, fArr, i4, this.f11246c - i5);
        this.f11246c -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Float set(int i4, Float f4) {
        return Float.valueOf(t(i4, f4.floatValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11246c;
    }

    public float t(int i4, float f4) {
        c();
        n(i4);
        float[] fArr = this.f11245b;
        float f5 = fArr[i4];
        fArr[i4] = f4;
        return f5;
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    public C.f a(int i4) {
        if (i4 >= this.f11246c) {
            return new C1075w(Arrays.copyOf(this.f11245b, i4), this.f11246c, true);
        }
        throw new IllegalArgumentException();
    }
}
