package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zznx extends zzkr implements RandomAccess, zznj, zzor {
    private static final long[] zza;
    private static final zznx zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zznx(jArr, 0, false);
    }

    public zznx() {
        this(zza, 0, true);
    }

    public static zznx zzf() {
        return zzb;
    }

    private static int zzi(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String zzj(int i4) {
        return "Index:" + i4 + ", Size:" + this.zzd;
    }

    private final void zzk(int i4) {
        if (i4 < 0 || i4 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzj(i4));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i4 < 0 || i4 > (i5 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzj(i4));
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

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zznl.zzb;
        collection.getClass();
        if (!(collection instanceof zznx)) {
            return super.addAll(collection);
        }
        zznx zznxVar = (zznx) collection;
        int i4 = zznxVar.zzd;
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
        System.arraycopy(zznxVar.zzc, 0, this.zzc, this.zzd, zznxVar.zzd);
        this.zzd = i6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zznx)) {
            return super.equals(obj);
        }
        zznx zznxVar = (zznx) obj;
        if (this.zzd != zznxVar.zzd) {
            return false;
        }
        long[] jArr = zznxVar.zzc;
        for (int i4 = 0; i4 < this.zzd; i4++) {
            if (this.zzc[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzk(i4);
        return Long.valueOf(this.zzc[i4]);
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzd; i5++) {
            long j4 = this.zzc[i5];
            byte[] bArr = zznl.zzb;
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

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zza();
        zzk(i4);
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
        zza();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i5, jArr, i4, this.zzd - i5);
        this.zzd -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        zzk(i4);
        long[] jArr = this.zzc;
        long j4 = jArr[i4];
        jArr[i4] = jLongValue;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.recaptcha.internal.zznk
    public final /* bridge */ /* synthetic */ zznk zzd(int i4) {
        if (i4 >= this.zzd) {
            return new zznx(i4 == 0 ? zza : Arrays.copyOf(this.zzc, i4), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i4) {
        zzk(i4);
        return this.zzc[i4];
    }

    public final void zzg(long j4) {
        zza();
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

    private zznx(long[] jArr, int i4, boolean z4) {
        super(z4);
        this.zzc = jArr;
        this.zzd = i4;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}
