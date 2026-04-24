package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.f;
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

    private static int zzi(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final void zzj(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i));
        }
    }

    private final String zzk(int i) {
        return zzkw.zza(this.zzd, i, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i6;
        long jLongValue = ((Long) obj).longValue();
        zzcF();
        if (i < 0 || i > (i6 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i));
        }
        int i7 = i + 1;
        long[] jArr = this.zzc;
        int length = jArr.length;
        if (i6 < length) {
            System.arraycopy(jArr, i, jArr, i7, i6 - i);
        } else {
            long[] jArr2 = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, i);
            System.arraycopy(this.zzc, i, jArr2, i7, this.zzd - i);
            this.zzc = jArr2;
        }
        this.zzc[i] = jLongValue;
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
        int i = zznaVar.zzd;
        if (i == 0) {
            return false;
        }
        int i6 = this.zzd;
        if (f.API_PRIORITY_OTHER - i6 < i) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i;
        long[] jArr = this.zzc;
        if (i7 > jArr.length) {
            this.zzc = Arrays.copyOf(jArr, i7);
        }
        System.arraycopy(zznaVar.zzc, 0, this.zzc, this.zzd, zznaVar.zzd);
        this.zzd = i7;
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
        for (int i = 0; i < this.zzd; i++) {
            if (this.zzc[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzj(i);
        return Long.valueOf(this.zzc[i]);
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.zzd; i6++) {
            long j4 = this.zzc[i6];
            byte[] bArr = zzmp.zzb;
            i = (i * 31) + ((int) (j4 ^ (j4 >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.zzd;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.zzc[i6] == jLongValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzcF();
        zzj(i);
        long[] jArr = this.zzc;
        long j4 = jArr[i];
        if (i < this.zzd - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        zzcF();
        if (i6 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i6, jArr, i, this.zzd - i6);
        this.zzd -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzcF();
        zzj(i);
        long[] jArr = this.zzc;
        long j4 = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmn
    public final long zzc(int i) {
        zzj(i);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    /* JADX INFO: renamed from: zzd */
    public final zzmn zzg(int i) {
        if (i >= this.zzd) {
            return new zzna(i == 0 ? zza : Arrays.copyOf(this.zzc, i), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(long j4) {
        zzcF();
        int i = this.zzd;
        int length = this.zzc.length;
        if (i == length) {
            long[] jArr = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr, 0, this.zzd);
            this.zzc = jArr;
        }
        long[] jArr2 = this.zzc;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        jArr2[i6] = j4;
    }

    public final void zzh(int i) {
        int length = this.zzc.length;
        if (i <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new long[Math.max(i, 10)];
            return;
        }
        while (length < i) {
            length = zzi(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzna(long[] jArr, int i, boolean z6) {
        super(z6);
        this.zzc = jArr;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
