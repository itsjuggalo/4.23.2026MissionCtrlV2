package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzmz extends zzkt implements RandomAccess, zzmm, zzns {
    private static final long[] zza;
    private static final zzmz zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zzmz(jArr, 0, false);
    }

    public zzmz() {
        this(zza, 0, true);
    }

    public static zzmz zze() {
        return zzb;
    }

    private static int zzi(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final void zzj(int i4) {
        if (i4 < 0 || i4 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i4));
        }
    }

    private final String zzk(int i4) {
        return zzkv.zza(this.zzd, i4, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        long jLongValue = ((Long) obj).longValue();
        zzcF();
        if (i4 < 0 || i4 > (i5 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i4));
        }
        int i6 = i4 + 1;
        long[] jArr = this.zzc;
        int length = jArr.length;
        if (i5 < length) {
            System.arraycopy(jArr, i4, jArr, i6, i5 - i4);
        } else {
            long[] jArr2 = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, i4);
            System.arraycopy(this.zzc, i4, jArr2, i6, this.zzd - i4);
            this.zzc = jArr2;
        }
        this.zzc[i4] = jLongValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmo.zzb;
        collection.getClass();
        if (!(collection instanceof zzmz)) {
            return super.addAll(collection);
        }
        zzmz zzmzVar = (zzmz) collection;
        int i4 = zzmzVar.zzd;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzd;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        long[] jArr = this.zzc;
        if (i6 > jArr.length) {
            this.zzc = Arrays.copyOf(jArr, i6);
        }
        System.arraycopy(zzmzVar.zzc, 0, this.zzc, this.zzd, zzmzVar.zzd);
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
        if (!(obj instanceof zzmz)) {
            return super.equals(obj);
        }
        zzmz zzmzVar = (zzmz) obj;
        if (this.zzd != zzmzVar.zzd) {
            return false;
        }
        long[] jArr = zzmzVar.zzc;
        for (int i4 = 0; i4 < this.zzd; i4++) {
            if (this.zzc[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzj(i4);
        return Long.valueOf(this.zzc[i4]);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzd; i5++) {
            long j4 = this.zzc[i5];
            byte[] bArr = zzmo.zzb;
            i4 = (i4 * 31) + ((int) (j4 ^ (j4 >>> 32)));
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i4 = this.zzd;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzc[i5] == jLongValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zzcF();
        zzj(i4);
        long[] jArr = this.zzc;
        long j4 = jArr[i4];
        if (i4 < this.zzd - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (r3 - i4) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i4, int i5) {
        zzcF();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i5, jArr, i4, this.zzd - i5);
        this.zzd -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzcF();
        zzj(i4);
        long[] jArr = this.zzc;
        long j4 = jArr[i4];
        jArr[i4] = jLongValue;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final long zzc(int i4) {
        zzj(i4);
        return this.zzc[i4];
    }

    @Override // com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzmg
    /* JADX INFO: renamed from: zzd */
    public final zzmm zzg(int i4) {
        if (i4 >= this.zzd) {
            return new zzmz(i4 == 0 ? zza : Arrays.copyOf(this.zzc, i4), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(long j4) {
        zzcF();
        int i4 = this.zzd;
        int length = this.zzc.length;
        if (i4 == length) {
            long[] jArr = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr, 0, this.zzd);
            this.zzc = jArr;
        }
        long[] jArr2 = this.zzc;
        int i5 = this.zzd;
        this.zzd = i5 + 1;
        jArr2[i5] = j4;
    }

    public final void zzh(int i4) {
        int length = this.zzc.length;
        if (i4 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new long[Math.max(i4, 10)];
            return;
        }
        while (length < i4) {
            length = zzi(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzmz(long[] jArr, int i4, boolean z4) {
        super(z4);
        this.zzc = jArr;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
