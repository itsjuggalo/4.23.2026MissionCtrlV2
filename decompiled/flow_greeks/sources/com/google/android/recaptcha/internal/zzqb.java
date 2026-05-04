package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqb {
    private static final ThreadLocal zza;

    static {
        zzph zzphVarZzi = zzpj.zzi();
        zzphVarZzi.zzf(-62135596800L);
        zzphVarZzi.zze(0);
        zzph zzphVarZzi2 = zzpj.zzi();
        zzphVarZzi2.zzf(253402300799L);
        zzphVarZzi2.zze(999999999);
        zzph zzphVarZzi3 = zzpj.zzi();
        zzphVarZzi3.zzf(0L);
        zzphVarZzi3.zze(0);
        zza = new zzqa();
        zzd("now");
        zzd("getEpochSecond");
        zzd("getNano");
    }

    public static zzpj zza(zzpj zzpjVar) {
        long jZzg = zzpjVar.zzg();
        boolean zZze = zze(jZzg);
        int iZzf = zzpjVar.zzf();
        if (!zZze || iZzf < 0 || iZzf >= 1000000000) {
            throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(jZzg), Integer.valueOf(iZzf)));
        }
        return zzpjVar;
    }

    public static zzpj zzb(long j10) {
        long jZza = j10 / 1000;
        if (!zze(jZza)) {
            throw new IllegalArgumentException(String.format("Timestamp is not valid. Input seconds is too large. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. ", Long.valueOf(jZza)));
        }
        int i10 = (int) ((j10 % 1000) * 1000000);
        if (i10 <= -1000000000 || i10 >= 1000000000) {
            jZza = zzkk.zza(jZza, i10 / 1000000000);
            i10 %= 1000000000;
        }
        if (i10 < 0) {
            i10 += 1000000000;
            jZza = zzkk.zzb(jZza, 1L);
        }
        zzph zzphVarZzi = zzpj.zzi();
        zzphVarZzi.zzf(jZza);
        zzphVarZzi.zze(i10);
        zzpj zzpjVar = (zzpj) zzphVarZzi.zzk();
        zza(zzpjVar);
        return zzpjVar;
    }

    public static String zzc(zzpj zzpjVar) {
        zza(zzpjVar);
        long jZzg = zzpjVar.zzg();
        int iZzf = zzpjVar.zzf();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((SimpleDateFormat) zza.get()).format(new Date(jZzg * 1000)));
        if (iZzf != 0) {
            sb2.append(".");
            sb2.append(iZzf % 1000000 == 0 ? String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(iZzf / 1000000)) : iZzf % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(iZzf / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(iZzf)));
        }
        sb2.append("Z");
        return sb2.toString();
    }

    private static Method zzd(String str) {
        try {
            return Class.forName("j$.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean zze(long j10) {
        return j10 >= -62135596800L && j10 <= 253402300799L;
    }
}
