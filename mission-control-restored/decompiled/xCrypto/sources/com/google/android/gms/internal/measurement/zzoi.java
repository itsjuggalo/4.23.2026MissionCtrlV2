package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzoi {
    private static final zzoi zza = new zzoi(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoi(int i4, int[] iArr, Object[] objArr, boolean z4) {
        this.zze = -1;
        this.zzb = i4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z4;
    }

    public static zzoi zza() {
        return zza;
    }

    public static zzoi zzb() {
        return new zzoi(0, new int[8], new Object[8], true);
    }

    public static zzoi zzc(zzoi zzoiVar, zzoi zzoiVar2) {
        int i4 = zzoiVar.zzb + zzoiVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzoiVar.zzc, i4);
        System.arraycopy(zzoiVar2.zzc, 0, iArrCopyOf, zzoiVar.zzb, zzoiVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzoiVar.zzd, i4);
        System.arraycopy(zzoiVar2.zzd, 0, objArrCopyOf, zzoiVar.zzb, zzoiVar2.zzb);
        return new zzoi(i4, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzm(int i4) {
        int[] iArr = this.zzc;
        if (i4 > iArr.length) {
            int i5 = this.zzb;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i4);
            this.zzd = Arrays.copyOf(this.zzd, i4);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzoi)) {
            return false;
        }
        zzoi zzoiVar = (zzoi) obj;
        int i4 = this.zzb;
        if (i4 == zzoiVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzoiVar.zzc;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzoiVar.zzd;
                    int i6 = this.zzb;
                    for (int i7 = 0; i7 < i6; i7++) {
                        if (objArr[i7].equals(objArr2[i7])) {
                        }
                    }
                    return true;
                }
                if (iArr[i5] != iArr2[i5]) {
                    break;
                }
                i5++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zzb;
        int i5 = i4 + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i6 = 17;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        int i8 = ((i5 * 31) + i6) * 31;
        Object[] objArr = this.zzd;
        int i9 = this.zzb;
        for (int i10 = 0; i10 < i9; i10++) {
            iHashCode = (iHashCode * 31) + objArr[i10].hashCode();
        }
        return i8 + iHashCode;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf(zzou zzouVar) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzouVar.zzv(this.zzc[i4] >>> 3, this.zzd[i4]);
        }
    }

    public final void zzg(zzou zzouVar) {
        if (this.zzb != 0) {
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                Object obj = this.zzd[i4];
                int i6 = i5 & 7;
                int i7 = i5 >>> 3;
                if (i6 == 0) {
                    zzouVar.zzc(i7, ((Long) obj).longValue());
                } else if (i6 == 1) {
                    zzouVar.zzj(i7, ((Long) obj).longValue());
                } else if (i6 == 2) {
                    zzouVar.zzn(i7, (zzlg) obj);
                } else if (i6 == 3) {
                    zzouVar.zzt(i7);
                    ((zzoi) obj).zzg(zzouVar);
                    zzouVar.zzu(i7);
                } else {
                    if (i6 != 5) {
                        throw new RuntimeException(new zzmp("Protocol message tag had invalid wire type."));
                    }
                    zzouVar.zzk(i7, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int iZzz = 0;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            int i6 = this.zzc[i5] >>> 3;
            zzlg zzlgVar = (zzlg) this.zzd[i5];
            int iZzz2 = zzll.zzz(8);
            int iZzz3 = zzll.zzz(16) + zzll.zzz(i6);
            int iZzz4 = zzll.zzz(24);
            int iZzc = zzlgVar.zzc();
            iZzz += iZzz2 + iZzz2 + iZzz3 + iZzz4 + zzll.zzz(iZzc) + iZzc;
        }
        this.zze = iZzz;
        return iZzz;
    }

    public final int zzi() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).getClass();
                    iZzz2 = zzll.zzz(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = i8 << 3;
                    zzlg zzlgVar = (zzlg) this.zzd[i6];
                    int iZzz3 = zzll.zzz(i10);
                    int iZzc = zzlgVar.zzc();
                    iZzz2 = iZzz3 + zzll.zzz(iZzc) + iZzc;
                } else if (i9 == 3) {
                    int iZzz4 = zzll.zzz(i8 << 3);
                    iZzz = iZzz4 + iZzz4;
                    iZzA = ((zzoi) this.zzd[i6]).zzi();
                } else {
                    if (i9 != 5) {
                        throw new IllegalStateException(new zzmp("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i6]).getClass();
                    iZzz2 = zzll.zzz(i8 << 3) + 4;
                }
                i5 += iZzz2;
            } else {
                int i11 = i8 << 3;
                long jLongValue = ((Long) this.zzd[i6]).longValue();
                iZzz = zzll.zzz(i11);
                iZzA = zzll.zzA(jLongValue);
            }
            iZzz2 = iZzz + iZzA;
            i5 += iZzz2;
        }
        this.zze = i5;
        return i5;
    }

    public final void zzj(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zznn.zzb(sb, i4, String.valueOf(this.zzc[i5] >>> 3), this.zzd[i5]);
        }
    }

    public final void zzk(int i4, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i5 = this.zzb;
        iArr[i5] = i4;
        this.zzd[i5] = obj;
        this.zzb = i5 + 1;
    }

    public final zzoi zzl(zzoi zzoiVar) {
        if (zzoiVar.equals(zza)) {
            return this;
        }
        zze();
        int i4 = this.zzb + zzoiVar.zzb;
        zzm(i4);
        System.arraycopy(zzoiVar.zzc, 0, this.zzc, this.zzb, zzoiVar.zzb);
        System.arraycopy(zzoiVar.zzd, 0, this.zzd, this.zzb, zzoiVar.zzb);
        this.zzb = i4;
        return this;
    }

    private zzoi() {
        this(0, new int[8], new Object[8], true);
    }
}
