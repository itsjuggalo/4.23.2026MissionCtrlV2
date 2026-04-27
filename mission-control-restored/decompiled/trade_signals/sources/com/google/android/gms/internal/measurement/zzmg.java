package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzmg extends zzku implements RandomAccess, zzmm, zznt {
    private static final int[] zza;
    private static final zzmg zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        zzb = new zzmg(iArr, 0, false);
    }

    public zzmg() {
        this(zza, 0, true);
    }

    public static zzmg zzd() {
        return zzb;
    }

    private static int zzj(int i8) {
        return Math.max(((i8 * 3) / 2) + 1, 10);
    }

    private final void zzk(int i8) {
        if (i8 < 0 || i8 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzl(i8));
        }
    }

    private final String zzl(int i8) {
        return zzkw.zza(this.zzd, i8, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        int iIntValue = ((Integer) obj).intValue();
        zzcF();
        if (i8 < 0 || i8 > (i9 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i8));
        }
        int i10 = i8 + 1;
        int[] iArr = this.zzc;
        int length = iArr.length;
        if (i9 < length) {
            System.arraycopy(iArr, i8, iArr, i10, i9 - i8);
        } else {
            int[] iArr2 = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr2, 0, i8);
            System.arraycopy(this.zzc, i8, iArr2, i10, this.zzd - i8);
            this.zzc = iArr2;
        }
        this.zzc[i8] = iIntValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmp.zzb;
        collection.getClass();
        if (!(collection instanceof zzmg)) {
            return super.addAll(collection);
        }
        zzmg zzmgVar = (zzmg) collection;
        int i8 = zzmgVar.zzd;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzd;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            this.zzc = Arrays.copyOf(iArr, i10);
        }
        System.arraycopy(zzmgVar.zzc, 0, this.zzc, this.zzd, zzmgVar.zzd);
        this.zzd = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmg)) {
            return super.equals(obj);
        }
        zzmg zzmgVar = (zzmg) obj;
        if (this.zzd != zzmgVar.zzd) {
            return false;
        }
        int[] iArr = zzmgVar.zzc;
        for (int i8 = 0; i8 < this.zzd; i8++) {
            if (this.zzc[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzk(i8);
        return Integer.valueOf(this.zzc[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzd; i9++) {
            i8 = (i8 * 31) + this.zzc[i9];
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i8 = this.zzd;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzc[i9] == iIntValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        zzcF();
        zzk(i8);
        int[] iArr = this.zzc;
        int i9 = iArr[i8];
        if (i8 < this.zzd - 1) {
            System.arraycopy(iArr, i8 + 1, iArr, i8, (r2 - i8) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        zzcF();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzc;
        System.arraycopy(iArr, i9, iArr, i8, this.zzd - i9);
        this.zzd -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzcF();
        zzk(i8);
        int[] iArr = this.zzc;
        int i9 = iArr[i8];
        iArr[i8] = iIntValue;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    /* JADX INFO: renamed from: zze */
    public final zzmm zzg(int i8) {
        if (i8 >= this.zzd) {
            return new zzmg(i8 == 0 ? zza : Arrays.copyOf(this.zzc, i8), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzf(int i8) {
        zzk(i8);
        return this.zzc[i8];
    }

    public final void zzh(int i8) {
        zzcF();
        int i9 = this.zzd;
        int length = this.zzc.length;
        if (i9 == length) {
            int[] iArr = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr, 0, this.zzd);
            this.zzc = iArr;
        }
        int[] iArr2 = this.zzc;
        int i10 = this.zzd;
        this.zzd = i10 + 1;
        iArr2[i10] = i8;
    }

    public final void zzi(int i8) {
        int length = this.zzc.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new int[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzmg(int[] iArr, int i8, boolean z7) {
        super(z7);
        this.zzc = iArr;
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
