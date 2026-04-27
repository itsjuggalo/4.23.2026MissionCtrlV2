package com.google.android.gms.internal.measurement;

import v2.AbstractC2854t;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes.dex */
public final class zzrb implements InterfaceC2853s {
    private static final zzrb zza = new zzrb();
    private final InterfaceC2853s zzb = AbstractC2854t.b(new zzrd());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // v2.InterfaceC2853s
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzrc get() {
        return (zzrc) this.zzb.get();
    }
}
