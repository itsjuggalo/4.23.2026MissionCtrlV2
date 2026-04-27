package com.google.android.gms.internal.measurement;

import a3.d;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzoj {
    private static final zzoj zza = new zzoj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoj(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z6;
    }

    public static zzoj zza() {
        return zza;
    }

    public static zzoj zzb() {
        return new zzoj(0, new int[8], new Object[8], true);
    }

    public static zzoj zzc(zzoj zzojVar, zzoj zzojVar2) {
        int i = zzojVar.zzb + zzojVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzojVar.zzc, i);
        System.arraycopy(zzojVar2.zzc, 0, iArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzojVar.zzd, i);
        System.arraycopy(zzojVar2.zzd, 0, objArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        return new zzoj(i, iArrCopyOf, objArrCopyOf, true);
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
        if (obj == null || !(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzojVar = (zzoj) obj;
        int i = this.zzb;
        if (i == zzojVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzojVar.zzc;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzojVar.zzd;
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
        for (int i = 0; i < this.zzb; i++) {
            zzovVar.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzov zzovVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i6 = this.zzc[i];
                Object obj = this.zzd[i];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    zzovVar.zzc(i8, ((Long) obj).longValue());
                } else if (i7 == 1) {
                    zzovVar.zzj(i8, ((Long) obj).longValue());
                } else if (i7 == 2) {
                    zzovVar.zzn(i8, (zzlh) obj);
                } else if (i7 == 3) {
                    zzovVar.zzt(i8);
                    ((zzoj) obj).zzg(zzovVar);
                    zzovVar.zzu(i8);
                } else {
                    if (i7 != 5) {
                        throw new RuntimeException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    zzovVar.zzk(i8, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iC = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6] >>> 3;
            zzlh zzlhVar = (zzlh) this.zzd[i6];
            int iZzz = zzlm.zzz(8);
            int iZzz2 = zzlm.zzz(i7) + zzlm.zzz(16);
            int iZzz3 = zzlm.zzz(24);
            int iZzc = zzlhVar.zzc();
            iC += iZzz + iZzz + iZzz2 + d.c(iZzc, iZzc, iZzz3);
        }
        this.zze = iC;
        return iC;
    }

    public final int zzi() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzz3 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).getClass();
                    iZzz2 = zzlm.zzz(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = i8 << 3;
                    zzlh zzlhVar = (zzlh) this.zzd[i6];
                    int iZzz4 = zzlm.zzz(i10);
                    int iZzc = zzlhVar.zzc();
                    iZzz3 = zzlm.zzz(iZzc) + iZzc + iZzz4 + iZzz3;
                } else if (i9 == 3) {
                    int iZzz5 = zzlm.zzz(i8 << 3);
                    iZzz = iZzz5 + iZzz5;
                    iZzA = ((zzoj) this.zzd[i6]).zzi();
                } else {
                    if (i9 != 5) {
                        throw new IllegalStateException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i6]).getClass();
                    iZzz2 = zzlm.zzz(i8 << 3) + 4;
                }
                iZzz3 = iZzz2 + iZzz3;
            } else {
                int i11 = i8 << 3;
                long jLongValue = ((Long) this.zzd[i6]).longValue();
                iZzz = zzlm.zzz(i11);
                iZzA = zzlm.zzA(jLongValue);
            }
            iZzz3 = iZzA + iZzz + iZzz3;
        }
        this.zze = iZzz3;
        return iZzz3;
    }

    public final void zzj(StringBuilder sb, int i) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzno.zzb(sb, i, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final void zzk(int i, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    public final zzoj zzl(zzoj zzojVar) {
        if (zzojVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzojVar.zzb;
        zzm(i);
        System.arraycopy(zzojVar.zzc, 0, this.zzc, this.zzb, zzojVar.zzb);
        System.arraycopy(zzojVar.zzd, 0, this.zzd, this.zzb, zzojVar.zzb);
        this.zzb = i;
        return this;
    }

    private zzoj() {
        this(0, new int[8], new Object[8], true);
    }
}
