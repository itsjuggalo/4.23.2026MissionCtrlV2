package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;
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

    private static int zze(int i7) {
        return Math.max(((i7 * 3) / 2) + 1, 10);
    }

    private final String zzf(int i7) {
        return "Index:" + i7 + ", Size:" + this.zzc;
    }

    private final void zzg(int i7) {
        if (i7 < 0 || i7 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i7));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i7, Object obj) {
        int i8;
        int iIntValue = ((Integer) obj).intValue();
        zza();
        if (i7 < 0 || i7 > (i8 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i7));
        }
        int[] iArr = this.zzb;
        if (i8 < iArr.length) {
            System.arraycopy(iArr, i7, iArr, i7 + 1, i8 - i7);
        } else {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, i7);
            System.arraycopy(this.zzb, i7, iArr2, i7 + 1, this.zzc - i7);
            this.zzb = iArr2;
        }
        this.zzb[i7] = iIntValue;
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
        int i7 = zzakzVar.zzc;
        if (i7 == 0) {
            return false;
        }
        int i8 = this.zzc;
        if (a.e.API_PRIORITY_OTHER - i8 < i7) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i7;
        int[] iArr = this.zzb;
        if (i9 > iArr.length) {
            this.zzb = Arrays.copyOf(iArr, i9);
        }
        System.arraycopy(zzakzVar.zzb, 0, this.zzb, this.zzc, zzakzVar.zzc);
        this.zzc = i9;
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
        for (int i7 = 0; i7 < this.zzc; i7++) {
            if (this.zzb[i7] != iArr[i7]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i7) {
        return Integer.valueOf(zzb(i7));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i7 = 1;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            i7 = (i7 * 31) + this.zzb[i8];
        }
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (this.zzb[i7] == iIntValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i7) {
        zza();
        zzg(i7);
        int[] iArr = this.zzb;
        int i8 = iArr[i7];
        if (i7 < this.zzc - 1) {
            System.arraycopy(iArr, i7 + 1, iArr, i7, (r2 - i7) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i7, int i8) {
        zza();
        if (i8 < i7) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i8, iArr, i7, this.zzc - i8);
        this.zzc -= i8 - i7;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i7, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zza();
        zzg(i7);
        int[] iArr = this.zzb;
        int i8 = iArr[i7];
        iArr[i7] = iIntValue;
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalc
    public final /* synthetic */ zzalc<Integer> zza(int i7) {
        if (i7 >= this.zzc) {
            return new zzakz(i7 == 0 ? zza : Arrays.copyOf(this.zzb, i7), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzb(int i7) {
        zzg(i7);
        return this.zzb[i7];
    }

    public final void zzc(int i7) {
        zza();
        int i8 = this.zzc;
        int[] iArr = this.zzb;
        if (i8 == iArr.length) {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, this.zzc);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        iArr3[i9] = i7;
    }

    public final void zzd(int i7) {
        int[] iArr = this.zzb;
        if (i7 <= iArr.length) {
            return;
        }
        if (iArr.length == 0) {
            this.zzb = new int[Math.max(i7, 10)];
            return;
        }
        int length = iArr.length;
        while (length < i7) {
            length = zze(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzakz(int[] iArr, int i7, boolean z7) {
        super(z7);
        this.zzb = iArr;
        this.zzc = i7;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Integer) obj).intValue());
        return true;
    }
}
