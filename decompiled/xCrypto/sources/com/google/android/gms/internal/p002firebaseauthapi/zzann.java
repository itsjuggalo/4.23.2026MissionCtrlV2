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
        int i4 = this.zzb;
        if (i4 == zzannVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzannVar.zzc;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzannVar.zzd;
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
        int i5 = (i4 + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i6 = 17;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        int i8 = (i5 + i6) * 31;
        Object[] objArr = this.zzd;
        int i9 = this.zzb;
        for (int i10 = 0; i10 < i9; i10++) {
            iHashCode = (iHashCode * 31) + objArr[i10].hashCode();
        }
        return i8 + iHashCode;
    }

    public final int zza() {
        int iZze;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 == 0) {
                iZze = zzakg.zze(i8, ((Long) this.zzd[i6]).longValue());
            } else if (i9 == 1) {
                iZze = zzakg.zza(i8, ((Long) this.zzd[i6]).longValue());
            } else if (i9 == 2) {
                iZze = zzakg.zza(i8, (zzajp) this.zzd[i6]);
            } else if (i9 == 3) {
                iZze = (zzakg.zzi(i8) << 1) + ((zzann) this.zzd[i6]).zza();
            } else {
                if (i9 != 5) {
                    throw new IllegalStateException(zzalf.zza());
                }
                iZze = zzakg.zzc(i8, ((Integer) this.zzd[i6]).intValue());
            }
            i5 += iZze;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int iZzb = 0;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            iZzb += zzakg.zzb(this.zzc[i5] >>> 3, (zzajp) this.zzd[i5]);
        }
        this.zze = iZzb;
        return iZzb;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzann(int i4, int[] iArr, Object[] objArr, boolean z4) {
        this.zze = -1;
        this.zzb = i4;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z4;
    }

    public final void zzb(zzaof zzaofVar) {
        if (this.zzb == 0) {
            return;
        }
        if (zzaofVar.zza() == 1) {
            for (int i4 = 0; i4 < this.zzb; i4++) {
                zza(this.zzc[i4], this.zzd[i4], zzaofVar);
            }
            return;
        }
        for (int i5 = this.zzb - 1; i5 >= 0; i5--) {
            zza(this.zzc[i5], this.zzd[i5], zzaofVar);
        }
    }

    public final zzann zza(zzann zzannVar) {
        if (zzannVar.equals(zza)) {
            return this;
        }
        zzf();
        int i4 = this.zzb + zzannVar.zzb;
        zza(i4);
        System.arraycopy(zzannVar.zzc, 0, this.zzc, this.zzb, zzannVar.zzb);
        System.arraycopy(zzannVar.zzd, 0, this.zzd, this.zzb, zzannVar.zzb);
        this.zzb = i4;
        return this;
    }

    public static zzann zza(zzann zzannVar, zzann zzannVar2) {
        int i4 = zzannVar.zzb + zzannVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzannVar.zzc, i4);
        System.arraycopy(zzannVar2.zzc, 0, iArrCopyOf, zzannVar.zzb, zzannVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzannVar.zzd, i4);
        System.arraycopy(zzannVar2.zzd, 0, objArrCopyOf, zzannVar.zzb, zzannVar2.zzb);
        return new zzann(i4, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zza(int i4) {
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

    public final void zza(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzamh.zza(sb, i4, String.valueOf(this.zzc[i5] >>> 3), this.zzd[i5]);
        }
    }

    public final void zza(int i4, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i5 = this.zzb;
        iArr[i5] = i4;
        this.zzd[i5] = obj;
        this.zzb = i5 + 1;
    }

    public final void zza(zzaof zzaofVar) {
        if (zzaofVar.zza() == 2) {
            for (int i4 = this.zzb - 1; i4 >= 0; i4--) {
                zzaofVar.zza(this.zzc[i4] >>> 3, this.zzd[i4]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzaofVar.zza(this.zzc[i5] >>> 3, this.zzd[i5]);
        }
    }

    private static void zza(int i4, Object obj, zzaof zzaofVar) {
        int i5 = i4 >>> 3;
        int i6 = i4 & 7;
        if (i6 == 0) {
            zzaofVar.zzb(i5, ((Long) obj).longValue());
            return;
        }
        if (i6 == 1) {
            zzaofVar.zza(i5, ((Long) obj).longValue());
            return;
        }
        if (i6 == 2) {
            zzaofVar.zza(i5, (zzajp) obj);
            return;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                zzaofVar.zzb(i5, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzalf.zza());
        }
        if (zzaofVar.zza() == 1) {
            zzaofVar.zzb(i5);
            ((zzann) obj).zzb(zzaofVar);
            zzaofVar.zza(i5);
        } else {
            zzaofVar.zza(i5);
            ((zzann) obj).zzb(zzaofVar);
            zzaofVar.zzb(i5);
        }
    }
}
