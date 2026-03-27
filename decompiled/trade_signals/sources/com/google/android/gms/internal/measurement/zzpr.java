package com.google.android.gms.internal.measurement;

import v2.AbstractC2854t;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpr implements InterfaceC2853s {
    private static final zzpr zza = new zzpr();
    private final InterfaceC2853s zzb = AbstractC2854t.b(new zzpt());

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

    @Override // v2.InterfaceC2853s
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzps get() {
        return (zzps) this.zzb.get();
    }
}
