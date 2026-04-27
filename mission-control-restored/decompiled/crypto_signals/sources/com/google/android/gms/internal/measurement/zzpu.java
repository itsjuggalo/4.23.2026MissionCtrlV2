package com.google.android.gms.internal.measurement;

import U1.l;
import U1.o;

/* JADX INFO: loaded from: classes.dex */
public final class zzpu implements l {
    private static final zzpu zza = new zzpu();
    private final l zzb = new o(new zzpw());

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

    @Override // U1.l
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzpv get() {
        return (zzpv) this.zzb.get();
    }
}
