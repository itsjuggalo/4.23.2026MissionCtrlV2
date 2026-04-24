package com.google.android.gms.internal.measurement;

import H2.r;
import H2.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpq implements r {
    private static final zzpq zza = new zzpq();
    private final r zzb = s.b(new zzps());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    public static boolean zzc() {
        return zza.get().zzc();
    }

    public static boolean zzd() {
        return zza.get().zzd();
    }

    @Override // H2.r
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzpr get() {
        return (zzpr) this.zzb.get();
    }
}
