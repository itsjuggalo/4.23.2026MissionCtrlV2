package com.google.android.gms.internal.measurement;

import v2.AbstractC2854t;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpl implements InterfaceC2853s {
    private static final zzpl zza = new zzpl();
    private final InterfaceC2853s zzb = AbstractC2854t.b(new zzpn());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // v2.InterfaceC2853s
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpm get() {
        return (zzpm) this.zzb.get();
    }
}
