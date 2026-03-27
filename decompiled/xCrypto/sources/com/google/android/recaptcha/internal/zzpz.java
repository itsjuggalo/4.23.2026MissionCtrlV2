package com.google.android.recaptcha.internal;

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

    public static zzml zza(long j4) {
        int i4 = (int) (j4 % 1000000000);
        long jZza = j4 / 1000000000;
        if (i4 <= -1000000000 || i4 >= 1000000000) {
            jZza = zzkk.zza(jZza, i4 / 1000000000);
            i4 %= 1000000000;
        }
        if (jZza > 0 && i4 < 0) {
            i4 += 1000000000;
            jZza--;
        }
        if (jZza < 0 && i4 > 0) {
            i4 -= 1000000000;
            jZza++;
        }
        zzmj zzmjVarZzi = zzml.zzi();
        zzmjVarZzi.zzf(jZza);
        zzmjVarZzi.zze(i4);
        zzml zzmlVar = (zzml) zzmjVarZzi.zzk();
        long jZzg = zzmlVar.zzg();
        int iZzf = zzmlVar.zzf();
        if (jZzg < -315576000000L || jZzg > 315576000000L || iZzf < -999999999 || iZzf >= 1000000000 || ((jZzg < 0 || iZzf < 0) && (jZzg > 0 || iZzf > 0))) {
            throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(jZzg), Integer.valueOf(iZzf)));
        }
        return zzmlVar;
    }
}
