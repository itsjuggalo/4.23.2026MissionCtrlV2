package com.google.android.gms.internal.measurement;

import v2.AbstractC2854t;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes.dex */
public final class zzqm implements InterfaceC2853s {
    private static final zzqm zza = new zzqm();
    private final InterfaceC2853s zzb = AbstractC2854t.b(new zzqo());

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

    @Override // v2.InterfaceC2853s
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzqn get() {
        return (zzqn) this.zzb.get();
    }
}
