package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzakz extends zzajj<Integer> implements zzalc<Integer>, RandomAccess {
    private static final int[] zza;
    private int[] zzb;
    private int zzc;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        new zzakz(iArr, 0, false);
    }

    public zzakz() {
        this(zza, 0, true);
    }

    private static int zze(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String zzf(int i4) {
        return "Index:" + i4 + ", Size:" + this.zzc;
    }

    private final void zzg(int i4) {
        if (i4 < 0 || i4 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i4));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        int iIntValue = ((Integer) obj).intValue();
        zza();
        if (i4 < 0 || i4 > (i5 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i4));
        }
        int[] iArr = this.zzb;
        if (i5 < iArr.length) {
            System.arraycopy(iArr, i4, iArr, i4 + 1, i5 - i4);
        } else {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, i4);
            System.arraycopy(this.zzb, i4, iArr2, i4 + 1, this.zzc - i4);
            this.zzb = iArr2;
        }
        this.zzb[i4] = iIntValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zza();
        zzalb.zza(collection);
        if (!(collection instanceof zzakz)) {
            return super.addAll(collection);
        }
        zzakz zzakzVar = (zzakz) collection;
        int i4 = zzakzVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        int[] iArr = this.zzb;
        if (i6 > iArr.length) {
            this.zzb = Arrays.copyOf(iArr, i6);
        }
        System.arraycopy(zzakzVar.zzb, 0, this.zzb, this.zzc, zzakzVar.zzc);
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
        if (!(obj instanceof zzakz)) {
            return super.equals(obj);
        }
        zzakz zzakzVar = (zzakz) obj;
        if (this.zzc != zzakzVar.zzc) {
            return false;
        }
        int[] iArr = zzakzVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (this.zzb[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        return Integer.valueOf(zzb(i4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + this.zzb[i5];
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.zzb[i4] == iIntValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        zza();
        zzg(i4);
        int[] iArr = this.zzb;
        int i5 = iArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (r2 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i4, int i5) {
        zza();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i5, iArr, i4, this.zzc - i5);
        this.zzc -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zza();
        zzg(i4);
        int[] iArr = this.zzb;
        int i5 = iArr[i4];
        iArr[i4] = iIntValue;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalc
    public final /* synthetic */ zzalc<Integer> zza(int i4) {
        if (i4 >= this.zzc) {
            return new zzakz(i4 == 0 ? zza : Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzb(int i4) {
        zzg(i4);
        return this.zzb[i4];
    }

    public final void zzc(int i4) {
        zza();
        int i5 = this.zzc;
        int[] iArr = this.zzb;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, this.zzc);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        iArr3[i6] = i4;
    }

    public final void zzd(int i4) {
        int[] iArr = this.zzb;
        if (i4 <= iArr.length) {
            return;
        }
        if (iArr.length == 0) {
            this.zzb = new int[Math.max(i4, 10)];
            return;
        }
        int length = iArr.length;
        while (length < i4) {
            length = zze(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzakz(int[] iArr, int i4, boolean z4) {
        super(z4);
        this.zzb = iArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Integer) obj).intValue());
        return true;
    }
}
