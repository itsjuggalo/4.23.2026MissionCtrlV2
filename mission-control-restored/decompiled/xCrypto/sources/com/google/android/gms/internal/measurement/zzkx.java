package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzkx extends zzkt implements RandomAccess, zzmg, zzns {
    private static final boolean[] zza;
    private boolean[] zzb;
    private int zzc;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        new zzkx(zArr, 0, false);
    }

    public zzkx() {
        this(zza, 0, true);
    }

    private static int zzh(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final void zzi(int i4) {
        if (i4 < 0 || i4 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzj(i4));
        }
    }

    private final String zzj(int i4) {
        return zzkv.zza(this.zzc, i4, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzcF();
        if (i4 < 0 || i4 > (i5 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzj(i4));
        }
        int i6 = i4 + 1;
        boolean[] zArr = this.zzb;
        int length = zArr.length;
        if (i5 < length) {
            System.arraycopy(zArr, i4, zArr, i6, i5 - i4);
        } else {
            boolean[] zArr2 = new boolean[zzh(length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, i4);
            System.arraycopy(this.zzb, i4, zArr2, i6, this.zzc - i4);
            this.zzb = zArr2;
        }
        this.zzb[i4] = zBooleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmo.zzb;
        collection.getClass();
        if (!(collection instanceof zzkx)) {
            return super.addAll(collection);
        }
        zzkx zzkxVar = (zzkx) collection;
        int i4 = zzkxVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        boolean[] zArr = this.zzb;
        if (i6 > zArr.length) {
            this.zzb = Arrays.copyOf(zArr, i6);
        }
        System.arraycopy(zzkxVar.zzb, 0, this.zzb, this.zzc, zzkxVar.zzc);
        this.zzc = i6;
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
        if (!(obj instanceof zzkx)) {
            return super.equals(obj);
        }
        zzkx zzkxVar = (zzkx) obj;
        if (this.zzc != zzkxVar.zzc) {
            return false;
        }
        boolean[] zArr = zzkxVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (this.zzb[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzi(i4);
        return Boolean.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzb = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            iZzb = (iZzb * 31) + zzmo.zzb(this.zzb[i4]);
        }
        return iZzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == zBooleanValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zzcF();
        zzi(i4);
        boolean[] zArr = this.zzb;
        boolean z4 = zArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(zArr, i4 + 1, zArr, i4, (r2 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i4, int i5) {
        zzcF();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i5, zArr, i4, this.zzc - i5);
        this.zzc -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzcF();
        zzi(i4);
        boolean[] zArr = this.zzb;
        boolean z4 = zArr[i4];
        zArr[i4] = zBooleanValue;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* JADX INFO: renamed from: zzd */
    public final zzmg zzg(int i4) {
        if (i4 >= this.zzc) {
            return new zzkx(i4 == 0 ? zza : Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zze(int i4) {
        zzi(i4);
        return this.zzb[i4];
    }

    public final void zzf(boolean z4) {
        zzcF();
        int i4 = this.zzc;
        int length = this.zzb.length;
        if (i4 == length) {
            boolean[] zArr = new boolean[zzh(length)];
            System.arraycopy(this.zzb, 0, zArr, 0, this.zzc);
            this.zzb = zArr;
        }
        boolean[] zArr2 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        zArr2[i5] = z4;
    }

    private zzkx(boolean[] zArr, int i4, boolean z4) {
        super(z4);
        this.zzb = zArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Boolean) obj).booleanValue());
        return true;
    }
}
