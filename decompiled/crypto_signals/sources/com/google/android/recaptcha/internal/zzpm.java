package com.google.android.recaptcha.internal;

import a3.d;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzpm {
    private static final zzpm zza = new zzpm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzpm(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z6;
    }

    public static zzpm zzc() {
        return zza;
    }

    public static zzpm zze(zzpm zzpmVar, zzpm zzpmVar2) {
        int i = zzpmVar.zzb + zzpmVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzpmVar.zzc, i);
        System.arraycopy(zzpmVar2.zzc, 0, iArrCopyOf, zzpmVar.zzb, zzpmVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzpmVar.zzd, i);
        System.arraycopy(zzpmVar2.zzd, 0, objArrCopyOf, zzpmVar.zzb, zzpmVar2.zzb);
        return new zzpm(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzpm zzf() {
        return new zzpm(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
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
        if (obj == null || !(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpmVar = (zzpm) obj;
        int i = this.zzb;
        if (i == zzpmVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzpmVar.zzc;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzpmVar.zzd;
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
        int i9 = ((i6 * 31) + i7) * 31;
        Object[] objArr = this.zzd;
        int i10 = this.zzb;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return i9 + iHashCode;
    }

    public final int zza() {
        int iZzA;
        int iZzB;
        int iZzA2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzA3 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).getClass();
                    iZzA2 = zzln.zzA(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = i8 << 3;
                    zzle zzleVar = (zzle) this.zzd[i6];
                    int iZzA4 = zzln.zzA(i10);
                    int iZzd = zzleVar.zzd();
                    iZzA3 = zzln.zzA(iZzd) + iZzd + iZzA4 + iZzA3;
                } else if (i9 == 3) {
                    int iZzA5 = zzln.zzA(i8 << 3);
                    iZzA = iZzA5 + iZzA5;
                    iZzB = ((zzpm) this.zzd[i6]).zza();
                } else {
                    if (i9 != 5) {
                        throw new IllegalStateException(new zznm("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i6]).getClass();
                    iZzA2 = zzln.zzA(i8 << 3) + 4;
                }
                iZzA3 = iZzA2 + iZzA3;
            } else {
                int i11 = i8 << 3;
                long jLongValue = ((Long) this.zzd[i6]).longValue();
                iZzA = zzln.zzA(i11);
                iZzB = zzln.zzB(jLongValue);
            }
            iZzA3 = iZzB + iZzA + iZzA3;
        }
        this.zze = iZzA3;
        return iZzA3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iT = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6] >>> 3;
            zzle zzleVar = (zzle) this.zzd[i6];
            int iZzA = zzln.zzA(8);
            int iZzA2 = zzln.zzA(i7) + zzln.zzA(16);
            int iZzA3 = zzln.zzA(24);
            int iZzd = zzleVar.zzd();
            iT += iZzA + iZzA + iZzA2 + d.t(iZzd, iZzd, iZzA3);
        }
        this.zze = iT;
        return iT;
    }

    public final zzpm zzd(zzpm zzpmVar) {
        if (zzpmVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzpmVar.zzb;
        zzm(i);
        System.arraycopy(zzpmVar.zzc, 0, this.zzc, this.zzb, zzpmVar.zzb);
        System.arraycopy(zzpmVar.zzd, 0, this.zzd, this.zzb, zzpmVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzok.zzb(sb, i, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    public final void zzk(zzpy zzpyVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzpyVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzpy zzpyVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i6 = this.zzc[i];
                Object obj = this.zzd[i];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    zzpyVar.zzt(i8, ((Long) obj).longValue());
                } else if (i7 == 1) {
                    zzpyVar.zzm(i8, ((Long) obj).longValue());
                } else if (i7 == 2) {
                    zzpyVar.zzd(i8, (zzle) obj);
                } else if (i7 == 3) {
                    zzpyVar.zzF(i8);
                    ((zzpm) obj).zzl(zzpyVar);
                    zzpyVar.zzh(i8);
                } else {
                    if (i7 != 5) {
                        throw new RuntimeException(new zznm("Protocol message tag had invalid wire type."));
                    }
                    zzpyVar.zzk(i8, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzpm() {
        this(0, new int[8], new Object[8], true);
    }
}
