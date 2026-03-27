package com.google.android.gms.internal.measurement;

import Z1.r;
import Z1.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzqi implements r {
    private static final zzqi zza = new zzqi();
    private final r zzb = s.b(new zzqk());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static long zzb() {
        return zza.get().zzb();
    }

    public static double zzc() {
        return zza.get().zzc();
    }

    public static long zzd() {
        return zza.get().zzd();
    }

    public static long zze() {
        return zza.get().zze();
    }

    public static String zzf() {
        return zza.get().zzf();
    }

    @Override // Z1.r
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzqj get() {
        return (zzqj) this.zzb.get();
    }
}
