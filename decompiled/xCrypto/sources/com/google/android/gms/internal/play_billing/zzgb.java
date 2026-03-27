package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzgb extends zzfx implements RandomAccess, zzho, zzit {
    private static final boolean[] zza;
    private boolean[] zzb;
    private int zzc;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        new zzgb(zArr, 0, false);
    }

    public zzgb() {
        this(zza, 0, true);
    }

    private static int zzg(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String zzh(int i4) {
        return "Index:" + i4 + ", Size:" + this.zzc;
    }

    private final void zzi(int i4) {
        if (i4 < 0 || i4 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i4));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i4 < 0 || i4 > (i5 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i4));
        }
        int i6 = i4 + 1;
        boolean[] zArr = this.zzb;
        int length = zArr.length;
        if (i5 < length) {
            System.arraycopy(zArr, i4, zArr, i6, i5 - i4);
        } else {
            boolean[] zArr2 = new boolean[zzg(length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, i4);
            System.arraycopy(this.zzb, i4, zArr2, i6, this.zzc - i4);
            this.zzb = zArr2;
        }
        this.zzb[i4] = zBooleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzhp.zzb;
        collection.getClass();
        if (!(collection instanceof zzgb)) {
            return super.addAll(collection);
        }
        zzgb zzgbVar = (zzgb) collection;
        int i4 = zzgbVar.zzc;
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
        System.arraycopy(zzgbVar.zzb, 0, this.zzb, this.zzc, zzgbVar.zzc);
        this.zzc = i6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgb)) {
            return super.equals(obj);
        }
        zzgb zzgbVar = (zzgb) obj;
        if (this.zzc != zzgbVar.zzc) {
            return false;
        }
        boolean[] zArr = zzgbVar.zzb;
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

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            iZza = (iZza * 31) + zzhp.zza(this.zzb[i4]);
        }
        return iZza;
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

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zza();
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
        zza();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i5, zArr, i4, this.zzc - i5);
        this.zzc -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
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

    @Override // com.google.android.gms.internal.play_billing.zzho
    public final /* bridge */ /* synthetic */ zzho zzd(int i4) {
        if (i4 >= this.zzc) {
            return new zzgb(i4 == 0 ? zza : Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z4) {
        zza();
        int i4 = this.zzc;
        int length = this.zzb.length;
        if (i4 == length) {
            boolean[] zArr = new boolean[zzg(length)];
            System.arraycopy(this.zzb, 0, zArr, 0, this.zzc);
            this.zzb = zArr;
        }
        boolean[] zArr2 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        zArr2[i5] = z4;
    }

    public final boolean zzf(int i4) {
        zzi(i4);
        return this.zzb[i4];
    }

    private zzgb(boolean[] zArr, int i4, boolean z4) {
        super(z4);
        this.zzb = zArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
