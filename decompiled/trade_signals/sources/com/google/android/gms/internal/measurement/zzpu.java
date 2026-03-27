package com.google.android.gms.internal.measurement;

import v2.AbstractC2854t;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpu implements InterfaceC2853s {
    private static final zzpu zza = new zzpu();
    private final InterfaceC2853s zzb = AbstractC2854t.b(new zzpw());

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

    @Override // v2.InterfaceC2853s
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzpv get() {
        return (zzpv) this.zzb.get();
    }
}
