package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzlo extends zzku implements RandomAccess, zzmi, zznt {
    private static final double[] zza;
    private double[] zzb;
    private int zzc;

    static {
        double[] dArr = new double[0];
        zza = dArr;
        new zzlo(dArr, 0, false);
    }

    public zzlo() {
        this(zza, 0, true);
    }

    private static int zzi(int i8) {
        return Math.max(((i8 * 3) / 2) + 1, 10);
    }

    private final void zzj(int i8) {
        if (i8 < 0 || i8 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzk(i8));
        }
    }

    private final String zzk(int i8) {
        return zzkw.zza(this.zzc, i8, (byte) 13, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        double dDoubleValue = ((Double) obj).doubleValue();
        zzcF();
        if (i8 < 0 || i8 > (i9 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzk(i8));
        }
        int i10 = i8 + 1;
        double[] dArr = this.zzb;
        int length = dArr.length;
        if (i9 < length) {
            System.arraycopy(dArr, i8, dArr, i10, i9 - i8);
        } else {
            double[] dArr2 = new double[zzi(length)];
            System.arraycopy(this.zzb, 0, dArr2, 0, i8);
            System.arraycopy(this.zzb, i8, dArr2, i10, this.zzc - i8);
            this.zzb = dArr2;
        }
        this.zzb[i8] = dDoubleValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmp.zzb;
        collection.getClass();
        if (!(collection instanceof zzlo)) {
            return super.addAll(collection);
        }
        zzlo zzloVar = (zzlo) collection;
        int i8 = zzloVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        double[] dArr = this.zzb;
        if (i10 > dArr.length) {
            this.zzb = Arrays.copyOf(dArr, i10);
        }
        System.arraycopy(zzloVar.zzb, 0, this.zzb, this.zzc, zzloVar.zzc);
        this.zzc = i10;
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
        if (!(obj instanceof zzlo)) {
            return super.equals(obj);
        }
        zzlo zzloVar = (zzlo) obj;
        if (this.zzc != zzloVar.zzc) {
            return false;
        }
        double[] dArr = zzloVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (Double.doubleToLongBits(this.zzb[i8]) != Double.doubleToLongBits(dArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzj(i8);
        return Double.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzb[i9]);
            byte[] bArr = zzmp.zzb;
            i8 = (i8 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == dDoubleValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        zzcF();
        zzj(i8);
        double[] dArr = this.zzb;
        double d8 = dArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(dArr, i8 + 1, dArr, i8, (r3 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        zzcF();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzb;
        System.arraycopy(dArr, i9, dArr, i8, this.zzc - i9);
        this.zzc -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzcF();
        zzj(i8);
        double[] dArr = this.zzb;
        double d8 = dArr[i8];
        dArr[i8] = dDoubleValue;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    /* JADX INFO: renamed from: zzd */
    public final zzmi zzg(int i8) {
        if (i8 >= this.zzc) {
            return new zzlo(i8 == 0 ? zza : Arrays.copyOf(this.zzb, i8), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i8) {
        zzj(i8);
        return this.zzb[i8];
    }

    public final void zzf(double d8) {
        zzcF();
        int i8 = this.zzc;
        int length = this.zzb.length;
        if (i8 == length) {
            double[] dArr = new double[zzi(length)];
            System.arraycopy(this.zzb, 0, dArr, 0, this.zzc);
            this.zzb = dArr;
        }
        double[] dArr2 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        dArr2[i9] = d8;
    }

    public final void zzh(int i8) {
        int length = this.zzb.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.zzb = new double[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = zzi(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzlo(double[] dArr, int i8, boolean z7) {
        super(z7);
        this.zzb = dArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
