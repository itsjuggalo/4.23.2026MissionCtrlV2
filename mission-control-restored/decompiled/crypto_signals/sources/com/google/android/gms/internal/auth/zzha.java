package com.google.android.gms.internal.auth;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzha {
    private static final zzha zza = new zzha(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzha(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z6;
    }

    public static zzha zza() {
        return zza;
    }

    public static zzha zzc(zzha zzhaVar, zzha zzhaVar2) {
        int i = zzhaVar.zzb + zzhaVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhaVar.zzc, i);
        System.arraycopy(zzhaVar2.zzc, 0, iArrCopyOf, zzhaVar.zzb, zzhaVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhaVar.zzd, i);
        System.arraycopy(zzhaVar2.zzd, 0, objArrCopyOf, zzhaVar.zzb, zzhaVar2.zzb);
        return new zzha(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzha zzd() {
        return new zzha(0, new int[8], new Object[8], true);
    }

    private final void zzi(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i6 = this.zzb;
            int i7 = (i6 / 2) + i6;
            if (i7 >= i) {
                i = i7;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzha)) {
            return false;
        }
        zzha zzhaVar = (zzha) obj;
        int i = this.zzb;
        if (i == zzhaVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhaVar.zzc;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhaVar.zzd;
                    int i7 = this.zzb;
                    for (int i8 = 0; i8 < i7; i8++) {
                        if (objArr[i8].equals(objArr2[i8])) {
                        }
                    }
                    return true;
                }
                if (iArr[i6] != iArr2[i6]) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i6 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i6 * 31) + i7;
        Object[] objArr = this.zzd;
        int i10 = this.zzb;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return (i9 * 31) + iHashCode;
    }

    public final zzha zzb(zzha zzhaVar) {
        if (zzhaVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzhaVar.zzb;
        zzi(i);
        System.arraycopy(zzhaVar.zzc, 0, this.zzc, this.zzb, zzhaVar.zzb);
        System.arraycopy(zzhaVar.zzd, 0, this.zzd, this.zzb, zzhaVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zze() {
        if (!this.zze) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf() {
        if (this.zze) {
            this.zze = false;
        }
    }

    public final void zzg(StringBuilder sb, int i) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzfz.zzb(sb, i, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final void zzh(int i, Object obj) {
        zze();
        zzi(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    private zzha() {
        this(0, new int[8], new Object[8], true);
    }
}
