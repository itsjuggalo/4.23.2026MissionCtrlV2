package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzoj {
    private static final zzoj zza = new zzoj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoj() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzoj zza() {
        return zza;
    }

    public static zzoj zzb() {
        return new zzoj(0, new int[8], new Object[8], true);
    }

    public static zzoj zzc(zzoj zzojVar, zzoj zzojVar2) {
        int i8 = zzojVar.zzb + zzojVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzojVar.zzc, i8);
        System.arraycopy(zzojVar2.zzc, 0, iArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzojVar.zzd, i8);
        System.arraycopy(zzojVar2.zzd, 0, objArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        return new zzoj(i8, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzm(int i8) {
        int[] iArr = this.zzc;
        if (i8 > iArr.length) {
            int i9 = this.zzb;
            int i10 = i9 + (i9 / 2);
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i8);
            this.zzd = Arrays.copyOf(this.zzd, i8);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzojVar = (zzoj) obj;
        int i8 = this.zzb;
        if (i8 == zzojVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzojVar.zzc;
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzojVar.zzd;
                    int i10 = this.zzb;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (objArr[i11].equals(objArr2[i11])) {
                        }
                    }
                    return true;
                }
                if (iArr[i9] != iArr2[i9]) {
                    break;
                }
                i9++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.zzb;
        int i9 = i8 + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i8; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = ((i9 * 31) + i10) * 31;
        Object[] objArr = this.zzd;
        int i13 = this.zzb;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return i12 + iHashCode;
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

    public final void zzf(zzov zzovVar) {
        for (int i8 = 0; i8 < this.zzb; i8++) {
            zzovVar.zzv(this.zzc[i8] >>> 3, this.zzd[i8]);
        }
    }

    public final void zzg(zzov zzovVar) {
        if (this.zzb != 0) {
            for (int i8 = 0; i8 < this.zzb; i8++) {
                int i9 = this.zzc[i8];
                Object obj = this.zzd[i8];
                int i10 = i9 & 7;
                int i11 = i9 >>> 3;
                if (i10 == 0) {
                    zzovVar.zzc(i11, ((Long) obj).longValue());
                } else if (i10 == 1) {
                    zzovVar.zzj(i11, ((Long) obj).longValue());
                } else if (i10 == 2) {
                    zzovVar.zzn(i11, (zzlh) obj);
                } else if (i10 == 3) {
                    zzovVar.zzt(i11);
                    ((zzoj) obj).zzg(zzovVar);
                    zzovVar.zzu(i11);
                } else {
                    if (i10 != 5) {
                        throw new RuntimeException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    zzovVar.zzk(i11, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i8 = this.zze;
        if (i8 != -1) {
            return i8;
        }
        int iZzz = 0;
        for (int i9 = 0; i9 < this.zzb; i9++) {
            int i10 = this.zzc[i9] >>> 3;
            zzlh zzlhVar = (zzlh) this.zzd[i9];
            int iZzz2 = zzlm.zzz(8);
            int iZzz3 = zzlm.zzz(16) + zzlm.zzz(i10);
            int iZzz4 = zzlm.zzz(24);
            int iZzc = zzlhVar.zzc();
            iZzz += iZzz2 + iZzz2 + iZzz3 + iZzz4 + zzlm.zzz(iZzc) + iZzc;
        }
        this.zze = iZzz;
        return iZzz;
    }

    public final int zzi() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i8 = this.zze;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.zzb; i10++) {
            int i11 = this.zzc[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.zzd[i10]).longValue();
                    iZzz2 = zzlm.zzz(i12 << 3) + 8;
                } else if (i13 == 2) {
                    int i14 = i12 << 3;
                    zzlh zzlhVar = (zzlh) this.zzd[i10];
                    int iZzz3 = zzlm.zzz(i14);
                    int iZzc = zzlhVar.zzc();
                    iZzz2 = iZzz3 + zzlm.zzz(iZzc) + iZzc;
                } else if (i13 == 3) {
                    int iZzz4 = zzlm.zzz(i12 << 3);
                    iZzz = iZzz4 + iZzz4;
                    iZzA = ((zzoj) this.zzd[i10]).zzi();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i10]).intValue();
                    iZzz2 = zzlm.zzz(i12 << 3) + 4;
                }
                i9 += iZzz2;
            } else {
                int i15 = i12 << 3;
                long jLongValue = ((Long) this.zzd[i10]).longValue();
                iZzz = zzlm.zzz(i15);
                iZzA = zzlm.zzA(jLongValue);
            }
            iZzz2 = iZzz + iZzA;
            i9 += iZzz2;
        }
        this.zze = i9;
        return i9;
    }

    public final void zzj(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.zzb; i9++) {
            zzno.zzb(sb, i8, String.valueOf(this.zzc[i9] >>> 3), this.zzd[i9]);
        }
    }

    public final void zzk(int i8, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i9 = this.zzb;
        iArr[i9] = i8;
        this.zzd[i9] = obj;
        this.zzb = i9 + 1;
    }

    public final zzoj zzl(zzoj zzojVar) {
        if (zzojVar.equals(zza)) {
            return this;
        }
        zze();
        int i8 = this.zzb + zzojVar.zzb;
        zzm(i8);
        System.arraycopy(zzojVar.zzc, 0, this.zzc, this.zzb, zzojVar.zzb);
        System.arraycopy(zzojVar.zzd, 0, this.zzd, this.zzb, zzojVar.zzb);
        this.zzb = i8;
        return this;
    }

    private zzoj(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.zze = -1;
        this.zzb = i8;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z7;
    }
}
