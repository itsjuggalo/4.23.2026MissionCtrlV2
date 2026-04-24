package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzmf extends zzkt implements RandomAccess, zzml, zzns {
    private static final int[] zza;
    private static final zzmf zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        zzb = new zzmf(iArr, 0, false);
    }

    public zzmf() {
        this(zza, 0, true);
    }

    public static zzmf zzd() {
        return zzb;
    }

    private static int zzj(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final void zzk(int i4) {
        if (i4 < 0 || i4 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzl(i4));
        }
    }

    private final String zzl(int i4) {
        return zzkv.zza(this.zzd, i4, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        int iIntValue = ((Integer) obj).intValue();
        zzcF();
        if (i4 < 0 || i4 > (i5 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i4));
        }
        int i6 = i4 + 1;
        int[] iArr = this.zzc;
        int length = iArr.length;
        if (i5 < length) {
            System.arraycopy(iArr, i4, iArr, i6, i5 - i4);
        } else {
            int[] iArr2 = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr2, 0, i4);
            System.arraycopy(this.zzc, i4, iArr2, i6, this.zzd - i4);
            this.zzc = iArr2;
        }
        this.zzc[i4] = iIntValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmo.zzb;
        collection.getClass();
        if (!(collection instanceof zzmf)) {
            return super.addAll(collection);
        }
        zzmf zzmfVar = (zzmf) collection;
        int i4 = zzmfVar.zzd;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzd;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        int[] iArr = this.zzc;
        if (i6 > iArr.length) {
            this.zzc = Arrays.copyOf(iArr, i6);
        }
        System.arraycopy(zzmfVar.zzc, 0, this.zzc, this.zzd, zzmfVar.zzd);
        this.zzd = i6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmf)) {
            return super.equals(obj);
        }
        zzmf zzmfVar = (zzmf) obj;
        if (this.zzd != zzmfVar.zzd) {
            return false;
        }
        int[] iArr = zzmfVar.zzc;
        for (int i4 = 0; i4 < this.zzd; i4++) {
            if (this.zzc[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzk(i4);
        return Integer.valueOf(this.zzc[i4]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzd; i5++) {
            i4 = (i4 * 31) + this.zzc[i5];
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i4 = this.zzd;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzc[i5] == iIntValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zzcF();
        zzk(i4);
        int[] iArr = this.zzc;
        int i5 = iArr[i4];
        if (i4 < this.zzd - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (r2 - i4) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i4, int i5) {
        zzcF();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzc;
        System.arraycopy(iArr, i5, iArr, i4, this.zzd - i5);
        this.zzd -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzcF();
        zzk(i4);
        int[] iArr = this.zzc;
        int i5 = iArr[i4];
        iArr[i4] = iIntValue;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* JADX INFO: renamed from: zze */
    public final zzml zzg(int i4) {
        if (i4 >= this.zzd) {
            return new zzmf(i4 == 0 ? zza : Arrays.copyOf(this.zzc, i4), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzf(int i4) {
        zzk(i4);
        return this.zzc[i4];
    }

    public final void zzh(int i4) {
        zzcF();
        int i5 = this.zzd;
        int length = this.zzc.length;
        if (i5 == length) {
            int[] iArr = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr, 0, this.zzd);
            this.zzc = iArr;
        }
        int[] iArr2 = this.zzc;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        iArr2[i6] = i4;
    }

    public final void zzi(int i4) {
        int length = this.zzc.length;
        if (i4 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new int[Math.max(i4, 10)];
            return;
        }
        while (length < i4) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzmf(int[] iArr, int i4, boolean z4) {
        super(z4);
        this.zzc = iArr;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
