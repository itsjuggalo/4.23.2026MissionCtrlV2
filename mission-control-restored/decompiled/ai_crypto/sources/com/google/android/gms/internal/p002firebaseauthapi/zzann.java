package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzann {
    private static final zzann zza = new zzann(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzann() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzann zzc() {
        return zza;
    }

    public static zzann zzd() {
        return new zzann();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzann)) {
            return false;
        }
        zzann zzannVar = (zzann) obj;
        int i7 = this.zzb;
        if (i7 == zzannVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzannVar.zzc;
            int i8 = 0;
            while (true) {
                if (i8 >= i7) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzannVar.zzd;
                    int i9 = this.zzb;
                    for (int i10 = 0; i10 < i9; i10++) {
                        if (objArr[i10].equals(objArr2[i10])) {
                        }
                    }
                    return true;
                }
                if (iArr[i8] != iArr2[i8]) {
                    break;
                }
                i8++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i7 = this.zzb;
        int i8 = (i7 + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i9 = 17;
        for (int i10 = 0; i10 < i7; i10++) {
            i9 = (i9 * 31) + iArr[i10];
        }
        int i11 = (i8 + i9) * 31;
        Object[] objArr = this.zzd;
        int i12 = this.zzb;
        for (int i13 = 0; i13 < i12; i13++) {
            iHashCode = (iHashCode * 31) + objArr[i13].hashCode();
        }
        return i11 + iHashCode;
    }

    public final int zza() {
        int iZze;
        int i7 = this.zze;
        if (i7 != -1) {
            return i7;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.zzb; i9++) {
            int i10 = this.zzc[i9];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                iZze = zzakg.zze(i11, ((Long) this.zzd[i9]).longValue());
            } else if (i12 == 1) {
                iZze = zzakg.zza(i11, ((Long) this.zzd[i9]).longValue());
            } else if (i12 == 2) {
                iZze = zzakg.zza(i11, (zzajp) this.zzd[i9]);
            } else if (i12 == 3) {
                iZze = (zzakg.zzi(i11) << 1) + ((zzann) this.zzd[i9]).zza();
            } else {
                if (i12 != 5) {
                    throw new IllegalStateException(zzalf.zza());
                }
                iZze = zzakg.zzc(i11, ((Integer) this.zzd[i9]).intValue());
            }
            i8 += iZze;
        }
        this.zze = i8;
        return i8;
    }

    public final int zzb() {
        int i7 = this.zze;
        if (i7 != -1) {
            return i7;
        }
        int iZzb = 0;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            iZzb += zzakg.zzb(this.zzc[i8] >>> 3, (zzajp) this.zzd[i8]);
        }
        this.zze = iZzb;
        return iZzb;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzann(int i7, int[] iArr, Object[] objArr, boolean z7) {
        this.zze = -1;
        this.zzb = i7;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z7;
    }

    public final void zzb(zzaof zzaofVar) {
        if (this.zzb == 0) {
            return;
        }
        if (zzaofVar.zza() == 1) {
            for (int i7 = 0; i7 < this.zzb; i7++) {
                zza(this.zzc[i7], this.zzd[i7], zzaofVar);
            }
            return;
        }
        for (int i8 = this.zzb - 1; i8 >= 0; i8--) {
            zza(this.zzc[i8], this.zzd[i8], zzaofVar);
        }
    }

    public final zzann zza(zzann zzannVar) {
        if (zzannVar.equals(zza)) {
            return this;
        }
        zzf();
        int i7 = this.zzb + zzannVar.zzb;
        zza(i7);
        System.arraycopy(zzannVar.zzc, 0, this.zzc, this.zzb, zzannVar.zzb);
        System.arraycopy(zzannVar.zzd, 0, this.zzd, this.zzb, zzannVar.zzb);
        this.zzb = i7;
        return this;
    }

    public static zzann zza(zzann zzannVar, zzann zzannVar2) {
        int i7 = zzannVar.zzb + zzannVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzannVar.zzc, i7);
        System.arraycopy(zzannVar2.zzc, 0, iArrCopyOf, zzannVar.zzb, zzannVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzannVar.zzd, i7);
        System.arraycopy(zzannVar2.zzd, 0, objArrCopyOf, zzannVar.zzb, zzannVar2.zzb);
        return new zzann(i7, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zza(int i7) {
        int[] iArr = this.zzc;
        if (i7 > iArr.length) {
            int i8 = this.zzb;
            int i9 = i8 + (i8 / 2);
            if (i9 >= i7) {
                i7 = i9;
            }
            if (i7 < 8) {
                i7 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i7);
            this.zzd = Arrays.copyOf(this.zzd, i7);
        }
    }

    public final void zza(StringBuilder sb, int i7) {
        for (int i8 = 0; i8 < this.zzb; i8++) {
            zzamh.zza(sb, i7, String.valueOf(this.zzc[i8] >>> 3), this.zzd[i8]);
        }
    }

    public final void zza(int i7, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i8 = this.zzb;
        iArr[i8] = i7;
        this.zzd[i8] = obj;
        this.zzb = i8 + 1;
    }

    public final void zza(zzaof zzaofVar) {
        if (zzaofVar.zza() == 2) {
            for (int i7 = this.zzb - 1; i7 >= 0; i7--) {
                zzaofVar.zza(this.zzc[i7] >>> 3, this.zzd[i7]);
            }
            return;
        }
        for (int i8 = 0; i8 < this.zzb; i8++) {
            zzaofVar.zza(this.zzc[i8] >>> 3, this.zzd[i8]);
        }
    }

    private static void zza(int i7, Object obj, zzaof zzaofVar) {
        int i8 = i7 >>> 3;
        int i9 = i7 & 7;
        if (i9 == 0) {
            zzaofVar.zzb(i8, ((Long) obj).longValue());
            return;
        }
        if (i9 == 1) {
            zzaofVar.zza(i8, ((Long) obj).longValue());
            return;
        }
        if (i9 == 2) {
            zzaofVar.zza(i8, (zzajp) obj);
            return;
        }
        if (i9 != 3) {
            if (i9 == 5) {
                zzaofVar.zzb(i8, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzalf.zza());
        }
        if (zzaofVar.zza() == 1) {
            zzaofVar.zzb(i8);
            ((zzann) obj).zzb(zzaofVar);
            zzaofVar.zza(i8);
        } else {
            zzaofVar.zza(i8);
            ((zzann) obj).zzb(zzaofVar);
            zzaofVar.zzb(i8);
        }
    }
}
