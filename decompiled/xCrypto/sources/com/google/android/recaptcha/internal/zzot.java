package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzot extends zzkr implements RandomAccess {
    private static final Object[] zza;
    private static final zzot zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzot(objArr, 0, false);
    }

    public zzot() {
        this(zza, 0, true);
    }

    public static zzot zze() {
        return zzb;
    }

    private static int zzg(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String zzh(int i4) {
        return "Index:" + i4 + ", Size:" + this.zzd;
    }

    private final void zzi(int i4) {
        if (i4 < 0 || i4 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzh(i4));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        int i5;
        zza();
        if (i4 < 0 || i4 > (i5 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzh(i4));
        }
        int i6 = i4 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i5 < length) {
            System.arraycopy(objArr, i4, objArr, i6, i5 - i4);
        } else {
            Object[] objArr2 = new Object[zzg(length)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i4);
            System.arraycopy(this.zzc, i4, objArr2, i6, this.zzd - i4);
            this.zzc = objArr2;
        }
        this.zzc[i4] = obj;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        zzi(i4);
        return this.zzc[i4];
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final Object remove(int i4) {
        zza();
        zzi(i4);
        Object[] objArr = this.zzc;
        Object obj = objArr[i4];
        if (i4 < this.zzd - 1) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, (r2 - i4) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        zza();
        zzi(i4);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.recaptcha.internal.zznk
    public final /* bridge */ /* synthetic */ zznk zzd(int i4) {
        if (i4 >= this.zzd) {
            return new zzot(i4 == 0 ? zza : Arrays.copyOf(this.zzc, i4), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(int i4) {
        int length = this.zzc.length;
        if (i4 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i4, 10)];
            return;
        }
        while (length < i4) {
            length = zzg(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzot(Object[] objArr, int i4, boolean z4) {
        super(z4);
        this.zzc = objArr;
        this.zzd = i4;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i4 = this.zzd;
        int length = this.zzc.length;
        if (i4 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzg(length));
        }
        Object[] objArr = this.zzc;
        int i5 = this.zzd;
        this.zzd = i5 + 1;
        objArr[i5] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
