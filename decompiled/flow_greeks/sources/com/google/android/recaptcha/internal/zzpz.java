package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpz {
    static {
        zzmj zzmjVarZzi = zzml.zzi();
        zzmjVarZzi.zzf(-315576000000L);
        zzmjVarZzi.zze(-999999999);
        zzmj zzmjVarZzi2 = zzml.zzi();
        zzmjVarZzi2.zzf(315576000000L);
        zzmjVarZzi2.zze(999999999);
        zzmj zzmjVarZzi3 = zzml.zzi();
        zzmjVarZzi3.zzf(0L);
        zzmjVarZzi3.zze(0);
    }

    public static zzml zza(long j10) {
        int i10 = (int) (j10 % 1000000000);
        long jZza = j10 / 1000000000;
        if (i10 <= -1000000000 || i10 >= 1000000000) {
            jZza = zzkk.zza(jZza, i10 / 1000000000);
            i10 %= 1000000000;
        }
        if (jZza > 0 && i10 < 0) {
            i10 += 1000000000;
            jZza--;
        }
        if (jZza < 0 && i10 > 0) {
            i10 -= 1000000000;
            jZza++;
        }
        zzmj zzmjVarZzi = zzml.zzi();
        zzmjVarZzi.zzf(jZza);
        zzmjVarZzi.zze(i10);
        zzml zzmlVar = (zzml) zzmjVarZzi.zzk();
        long jZzg = zzmlVar.zzg();
        int iZzf = zzmlVar.zzf();
        if (jZzg < -315576000000L || jZzg > 315576000000L || iZzf < -999999999 || iZzf >= 1000000000 || ((jZzg < 0 || iZzf < 0) && (jZzg > 0 || iZzf > 0))) {
            throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(jZzg), Integer.valueOf(iZzf)));
        }
        return zzmlVar;
    }
}
