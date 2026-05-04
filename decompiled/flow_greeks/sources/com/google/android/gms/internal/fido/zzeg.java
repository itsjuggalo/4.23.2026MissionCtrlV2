package com.google.android.gms.internal.fido;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzeg {
    private static String zza = "com.google.android.gms.internal.fido.zzel";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.fido.zzel", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzfm.zza();
    }

    public static long zzb() {
        return zzee.zza.zzc();
    }

    public static zzdp zzd(String str) {
        return zzee.zza.zze(str);
    }

    public static zzdr zzf() {
        return zzi().zza();
    }

    public static zzef zzg() {
        return zzee.zza.zzh();
    }

    public static zzev zzi() {
        return zzee.zza.zzj();
    }

    public static zzfi zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zzee.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z10) {
        zzi().zzd(str, level, z10);
        return false;
    }

    public long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    public abstract zzdp zze(String str);

    public abstract zzef zzh();

    public zzev zzj() {
        return zzev.zze();
    }

    public abstract String zzm();
}
