package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zznv extends zzku implements RandomAccess {
    private static final Object[] zza;
    private static final zznv zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zznv(objArr, 0, false);
    }

    public zznv() {
        this(zza, 0, true);
    }

    public static zznv zzd() {
        return zzb;
    }

    private static int zzf(int i8) {
        return Math.max(((i8 * 3) / 2) + 1, 10);
    }

    private final void zzh(int i8) {
        if (i8 < 0 || i8 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzi(i8));
        }
    }

    private final String zzi(int i8) {
        return zzkw.zza(this.zzd, i8, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        zzcF();
        if (i8 < 0 || i8 > (i9 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzi(i8));
        }
        int i10 = i8 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i9 < length) {
            System.arraycopy(objArr, i8, objArr, i10, i9 - i8);
        } else {
            Object[] objArr2 = new Object[zzf(length)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i8);
            System.arraycopy(this.zzc, i8, objArr2, i10, this.zzd - i8);
            this.zzc = objArr2;
        }
        this.zzc[i8] = obj;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        zzh(i8);
        return this.zzc[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        zzcF();
        zzh(i8);
        Object[] objArr = this.zzc;
        Object obj = objArr[i8];
        if (i8 < this.zzd - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (r2 - i8) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        zzcF();
        zzh(i8);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    public final void zze(int i8) {
        int length = this.zzc.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = zzf(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ zzmo zzg(int i8) {
        if (i8 >= this.zzd) {
            return new zznv(i8 == 0 ? zza : Arrays.copyOf(this.zzc, i8), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zznv(Object[] objArr, int i8, boolean z7) {
        super(z7);
        this.zzc = objArr;
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzcF();
        int i8 = this.zzd;
        int length = this.zzc.length;
        if (i8 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzf(length));
        }
        Object[] objArr = this.zzc;
        int i9 = this.zzd;
        this.zzd = i9 + 1;
        objArr[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
