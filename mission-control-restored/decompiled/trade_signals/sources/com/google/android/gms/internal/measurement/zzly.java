package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzly extends zzku implements RandomAccess, zzml, zznt {
    private static final float[] zza;
    private float[] zzb;
    private int zzc;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        new zzly(fArr, 0, false);
    }

    public zzly() {
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
        float fFloatValue = ((Float) obj).floatValue();
        zzcF();
        if (i8 < 0 || i8 > (i9 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzk(i8));
        }
        int i10 = i8 + 1;
        float[] fArr = this.zzb;
        int length = fArr.length;
        if (i9 < length) {
            System.arraycopy(fArr, i8, fArr, i10, i9 - i8);
        } else {
            float[] fArr2 = new float[zzi(length)];
            System.arraycopy(this.zzb, 0, fArr2, 0, i8);
            System.arraycopy(this.zzb, i8, fArr2, i10, this.zzc - i8);
            this.zzb = fArr2;
        }
        this.zzb[i8] = fFloatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmp.zzb;
        collection.getClass();
        if (!(collection instanceof zzly)) {
            return super.addAll(collection);
        }
        zzly zzlyVar = (zzly) collection;
        int i8 = zzlyVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        float[] fArr = this.zzb;
        if (i10 > fArr.length) {
            this.zzb = Arrays.copyOf(fArr, i10);
        }
        System.arraycopy(zzlyVar.zzb, 0, this.zzb, this.zzc, zzlyVar.zzc);
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
        if (!(obj instanceof zzly)) {
            return super.equals(obj);
        }
        zzly zzlyVar = (zzly) obj;
        if (this.zzc != zzlyVar.zzc) {
            return false;
        }
        float[] fArr = zzlyVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (Float.floatToIntBits(this.zzb[i8]) != Float.floatToIntBits(fArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzj(i8);
        return Float.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzb[i8]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == fFloatValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        zzcF();
        zzj(i8);
        float[] fArr = this.zzb;
        float f8 = fArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(fArr, i8 + 1, fArr, i8, (r2 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f8);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        zzcF();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i9, fArr, i8, this.zzc - i9);
        this.zzc -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzcF();
        zzj(i8);
        float[] fArr = this.zzb;
        float f8 = fArr[i8];
        fArr[i8] = fFloatValue;
        return Float.valueOf(f8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    /* JADX INFO: renamed from: zzd */
    public final zzml zzg(int i8) {
        if (i8 >= this.zzc) {
            return new zzly(i8 == 0 ? zza : Arrays.copyOf(this.zzb, i8), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zze(int i8) {
        zzj(i8);
        return this.zzb[i8];
    }

    public final void zzf(float f8) {
        zzcF();
        int i8 = this.zzc;
        int length = this.zzb.length;
        if (i8 == length) {
            float[] fArr = new float[zzi(length)];
            System.arraycopy(this.zzb, 0, fArr, 0, this.zzc);
            this.zzb = fArr;
        }
        float[] fArr2 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        fArr2[i9] = f8;
    }

    public final void zzh(int i8) {
        int length = this.zzb.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.zzb = new float[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = zzi(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzly(float[] fArr, int i8, boolean z7) {
        super(z7);
        this.zzb = fArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Float) obj).floatValue());
        return true;
    }
}
