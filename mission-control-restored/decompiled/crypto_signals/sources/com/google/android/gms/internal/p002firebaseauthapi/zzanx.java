package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzanx {
    private static final zzanx zza = new zzanx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzanx() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzanx zzc() {
        return zza;
    }

    public static zzanx zzd() {
        return new zzanx();
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
        if (obj == null || !(obj instanceof zzanx)) {
            return false;
        }
        zzanx zzanxVar = (zzanx) obj;
        int i = this.zzb;
        if (i == zzanxVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzanxVar.zzc;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzanxVar.zzd;
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
        int i6 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i6 + i7) * 31;
        Object[] objArr = this.zzd;
        int i10 = this.zzb;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return i9 + iHashCode;
    }

    public final int zza() {
        int iZze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZza = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 == 0) {
                iZze = zzakn.zze(i8, ((Long) this.zzd[i6]).longValue());
            } else if (i9 == 1) {
                iZze = zzakn.zza(i8, ((Long) this.zzd[i6]).longValue());
            } else if (i9 == 2) {
                iZze = zzakn.zza(i8, (zzajv) this.zzd[i6]);
            } else if (i9 == 3) {
                iZza = ((zzanx) this.zzd[i6]).zza() + (zzakn.zzh(i8) << 1) + iZza;
            } else {
                if (i9 != 5) {
                    throw new IllegalStateException(zzall.zza());
                }
                iZze = zzakn.zzb(i8, ((Integer) this.zzd[i6]).intValue());
            }
            iZza = iZze + iZza;
        }
        this.zze = iZza;
        return iZza;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzb = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            iZzb += zzakn.zzb(this.zzc[i6] >>> 3, (zzajv) this.zzd[i6]);
        }
        this.zze = iZzb;
        return iZzb;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzanx(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z6;
    }

    public final void zzb(zzaol zzaolVar) {
        if (this.zzb == 0) {
            return;
        }
        if (zzaolVar.zza() == 1) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzaolVar);
            }
            return;
        }
        for (int i6 = this.zzb - 1; i6 >= 0; i6--) {
            zza(this.zzc[i6], this.zzd[i6], zzaolVar);
        }
    }

    public final zzanx zza(zzanx zzanxVar) {
        if (zzanxVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzanxVar.zzb;
        zza(i);
        System.arraycopy(zzanxVar.zzc, 0, this.zzc, this.zzb, zzanxVar.zzb);
        System.arraycopy(zzanxVar.zzd, 0, this.zzd, this.zzb, zzanxVar.zzb);
        this.zzb = i;
        return this;
    }

    public static zzanx zza(zzanx zzanxVar, zzanx zzanxVar2) {
        int i = zzanxVar.zzb + zzanxVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzanxVar.zzc, i);
        System.arraycopy(zzanxVar2.zzc, 0, iArrCopyOf, zzanxVar.zzb, zzanxVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzanxVar.zzd, i);
        System.arraycopy(zzanxVar2.zzd, 0, objArrCopyOf, zzanxVar.zzb, zzanxVar2.zzb);
        return new zzanx(i, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zza(int i) {
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

    public final void zza(StringBuilder sb, int i) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzamn.zza(sb, i, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    public final void zza(zzaol zzaolVar) {
        if (zzaolVar.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzaolVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzaolVar.zza(this.zzc[i6] >>> 3, this.zzd[i6]);
        }
    }

    private static void zza(int i, Object obj, zzaol zzaolVar) {
        int i6 = i >>> 3;
        int i7 = i & 7;
        if (i7 == 0) {
            zzaolVar.zzb(i6, ((Long) obj).longValue());
            return;
        }
        if (i7 == 1) {
            zzaolVar.zza(i6, ((Long) obj).longValue());
            return;
        }
        if (i7 == 2) {
            zzaolVar.zza(i6, (zzajv) obj);
            return;
        }
        if (i7 != 3) {
            if (i7 == 5) {
                zzaolVar.zzb(i6, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzall.zza());
        }
        if (zzaolVar.zza() == 1) {
            zzaolVar.zzb(i6);
            ((zzanx) obj).zzb(zzaolVar);
            zzaolVar.zza(i6);
        } else {
            zzaolVar.zza(i6);
            ((zzanx) obj).zzb(zzaolVar);
            zzaolVar.zzb(i6);
        }
    }
}
