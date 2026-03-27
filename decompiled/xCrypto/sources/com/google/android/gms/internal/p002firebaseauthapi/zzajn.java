package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzajn extends zzajj<Boolean> implements zzalc<Boolean>, RandomAccess {
    private static final boolean[] zza;
    private boolean[] zzb;
    private int zzc;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        new zzajn(zArr, 0, false);
    }

    public zzajn() {
        this(zza, 0, true);
    }

    private static int zzc(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String zzd(int i4) {
        return "Index:" + i4 + ", Size:" + this.zzc;
    }

    private final void zze(int i4) {
        if (i4 < 0 || i4 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzd(i4));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i4 < 0 || i4 > (i5 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzd(i4));
        }
        boolean[] zArr = this.zzb;
        if (i5 < zArr.length) {
            System.arraycopy(zArr, i4, zArr, i4 + 1, i5 - i4);
        } else {
            boolean[] zArr2 = new boolean[zzc(zArr.length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, i4);
            System.arraycopy(this.zzb, i4, zArr2, i4 + 1, this.zzc - i4);
            this.zzb = zArr2;
        }
        this.zzb[i4] = zBooleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zza();
        zzalb.zza(collection);
        if (!(collection instanceof zzajn)) {
            return super.addAll(collection);
        }
        zzajn zzajnVar = (zzajn) collection;
        int i4 = zzajnVar.zzc;
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
        System.arraycopy(zzajnVar.zzb, 0, this.zzb, this.zzc, zzajnVar.zzc);
        this.zzc = i6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzajn)) {
            return super.equals(obj);
        }
        zzajn zzajnVar = (zzajn) obj;
        if (this.zzc != zzajnVar.zzc) {
            return false;
        }
        boolean[] zArr = zzajnVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (this.zzb[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        return Boolean.valueOf(zzb(i4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            iZza = (iZza * 31) + zzalb.zza(this.zzb[i4]);
        }
        return iZza;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.zzb[i4] == zBooleanValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        zza();
        zze(i4);
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        zze(i4);
        boolean[] zArr = this.zzb;
        boolean z4 = zArr[i4];
        zArr[i4] = zBooleanValue;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalc
    public final /* synthetic */ zzalc<Boolean> zza(int i4) {
        if (i4 >= this.zzc) {
            return new zzajn(i4 == 0 ? zza : Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zzb(int i4) {
        zze(i4);
        return this.zzb[i4];
    }

    private zzajn(boolean[] zArr, int i4, boolean z4) {
        super(z4);
        this.zzb = zArr;
        this.zzc = i4;
    }

    public final void zza(boolean z4) {
        zza();
        int i4 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i4 == zArr.length) {
            boolean[] zArr2 = new boolean[zzc(zArr.length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, this.zzc);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        zArr3[i5] = z4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Boolean) obj).booleanValue());
        return true;
    }
}
