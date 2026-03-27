package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzmi extends zzkr implements RandomAccess, zznk, zzor {
    private static final double[] zza;
    private double[] zzb;
    private int zzc;

    static {
        double[] dArr = new double[0];
        zza = dArr;
        new zzmi(dArr, 0, false);
    }

    public zzmi() {
        this(zza, 0, true);
    }

    private static int zzh(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String zzi(int i4) {
        return "Index:" + i4 + ", Size:" + this.zzc;
    }

    private final void zzj(int i4) {
        if (i4 < 0 || i4 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i4));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        if (i4 < 0 || i4 > (i5 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i4));
        }
        int i6 = i4 + 1;
        double[] dArr = this.zzb;
        int length = dArr.length;
        if (i5 < length) {
            System.arraycopy(dArr, i4, dArr, i6, i5 - i4);
        } else {
            double[] dArr2 = new double[zzh(length)];
            System.arraycopy(this.zzb, 0, dArr2, 0, i4);
            System.arraycopy(this.zzb, i4, dArr2, i6, this.zzc - i4);
            this.zzb = dArr2;
        }
        this.zzb[i4] = dDoubleValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zznl.zzb;
        collection.getClass();
        if (!(collection instanceof zzmi)) {
            return super.addAll(collection);
        }
        zzmi zzmiVar = (zzmi) collection;
        int i4 = zzmiVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        double[] dArr = this.zzb;
        if (i6 > dArr.length) {
            this.zzb = Arrays.copyOf(dArr, i6);
        }
        System.arraycopy(zzmiVar.zzb, 0, this.zzb, this.zzc, zzmiVar.zzc);
        this.zzc = i6;
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
        if (!(obj instanceof zzmi)) {
            return super.equals(obj);
        }
        zzmi zzmiVar = (zzmi) obj;
        if (this.zzc != zzmiVar.zzc) {
            return false;
        }
        double[] dArr = zzmiVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (Double.doubleToLongBits(this.zzb[i4]) != Double.doubleToLongBits(dArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzj(i4);
        return Double.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzb[i5]);
            byte[] bArr = zznl.zzb;
            i4 = (i4 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == dDoubleValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        zza();
        zzj(i4);
        double[] dArr = this.zzb;
        double d4 = dArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(dArr, i4 + 1, dArr, i4, (r3 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i4, int i5) {
        zza();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzb;
        System.arraycopy(dArr, i5, dArr, i4, this.zzc - i5);
        this.zzc -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        zzj(i4);
        double[] dArr = this.zzb;
        double d4 = dArr[i4];
        dArr[i4] = dDoubleValue;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zznk
    public final /* bridge */ /* synthetic */ zznk zzd(int i4) {
        if (i4 >= this.zzc) {
            return new zzmi(i4 == 0 ? zza : Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i4) {
        zzj(i4);
        return this.zzb[i4];
    }

    public final void zzf(double d4) {
        zza();
        int i4 = this.zzc;
        int length = this.zzb.length;
        if (i4 == length) {
            double[] dArr = new double[zzh(length)];
            System.arraycopy(this.zzb, 0, dArr, 0, this.zzc);
            this.zzb = dArr;
        }
        double[] dArr2 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        dArr2[i5] = d4;
    }

    public final void zzg(int i4) {
        int length = this.zzb.length;
        if (i4 <= length) {
            return;
        }
        if (length == 0) {
            this.zzb = new double[Math.max(i4, 10)];
            return;
        }
        while (length < i4) {
            length = zzh(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzmi(double[] dArr, int i4, boolean z4) {
        super(z4);
        this.zzb = dArr;
        this.zzc = i4;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
