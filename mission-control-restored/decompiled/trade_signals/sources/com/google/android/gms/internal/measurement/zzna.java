package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzna extends zzku implements RandomAccess, zzmn, zznt {
    private static final long[] zza;
    private static final zzna zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zzna(jArr, 0, false);
    }

    public zzna() {
        this(zza, 0, true);
    }

    public static zzna zze() {
        return zzb;
    }

    private static int zzi(int i8) {
        return Math.max(((i8 * 3) / 2) + 1, 10);
    }

    private final void zzj(int i8) {
        if (i8 < 0 || i8 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i8));
        }
    }

    private final String zzk(int i8) {
        return zzkw.zza(this.zzd, i8, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        long jLongValue = ((Long) obj).longValue();
        zzcF();
        if (i8 < 0 || i8 > (i9 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i8));
        }
        int i10 = i8 + 1;
        long[] jArr = this.zzc;
        int length = jArr.length;
        if (i9 < length) {
            System.arraycopy(jArr, i8, jArr, i10, i9 - i8);
        } else {
            long[] jArr2 = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, i8);
            System.arraycopy(this.zzc, i8, jArr2, i10, this.zzd - i8);
            this.zzc = jArr2;
        }
        this.zzc[i8] = jLongValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmp.zzb;
        collection.getClass();
        if (!(collection instanceof zzna)) {
            return super.addAll(collection);
        }
        zzna zznaVar = (zzna) collection;
        int i8 = zznaVar.zzd;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzd;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        long[] jArr = this.zzc;
        if (i10 > jArr.length) {
            this.zzc = Arrays.copyOf(jArr, i10);
        }
        System.arraycopy(zznaVar.zzc, 0, this.zzc, this.zzd, zznaVar.zzd);
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
        if (!(obj instanceof zzna)) {
            return super.equals(obj);
        }
        zzna zznaVar = (zzna) obj;
        if (this.zzd != zznaVar.zzd) {
            return false;
        }
        long[] jArr = zznaVar.zzc;
        for (int i8 = 0; i8 < this.zzd; i8++) {
            if (this.zzc[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzj(i8);
        return Long.valueOf(this.zzc[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzd; i9++) {
            long j8 = this.zzc[i9];
            byte[] bArr = zzmp.zzb;
            i8 = (i8 * 31) + ((int) (j8 ^ (j8 >>> 32)));
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i8 = this.zzd;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzc[i9] == jLongValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        zzcF();
        zzj(i8);
        long[] jArr = this.zzc;
        long j8 = jArr[i8];
        if (i8 < this.zzd - 1) {
            System.arraycopy(jArr, i8 + 1, jArr, i8, (r3 - i8) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        zzcF();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i9, jArr, i8, this.zzd - i9);
        this.zzd -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzcF();
        zzj(i8);
        long[] jArr = this.zzc;
        long j8 = jArr[i8];
        jArr[i8] = jLongValue;
        return Long.valueOf(j8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn
    public final long zzc(int i8) {
        zzj(i8);
        return this.zzc[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    /* JADX INFO: renamed from: zzd */
    public final zzmn zzg(int i8) {
        if (i8 >= this.zzd) {
            return new zzna(i8 == 0 ? zza : Arrays.copyOf(this.zzc, i8), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(long j8) {
        zzcF();
        int i8 = this.zzd;
        int length = this.zzc.length;
        if (i8 == length) {
            long[] jArr = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr, 0, this.zzd);
            this.zzc = jArr;
        }
        long[] jArr2 = this.zzc;
        int i9 = this.zzd;
        this.zzd = i9 + 1;
        jArr2[i9] = j8;
    }

    public final void zzh(int i8) {
        int length = this.zzc.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new long[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = zzi(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzna(long[] jArr, int i8, boolean z7) {
        super(z7);
        this.zzc = jArr;
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
