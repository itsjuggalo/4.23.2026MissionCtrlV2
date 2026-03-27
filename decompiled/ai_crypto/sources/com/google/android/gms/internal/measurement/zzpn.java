package com.google.android.gms.internal.measurement;

import H2.r;
import H2.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpn implements r {
    private static final zzpn zza = new zzpn();
    private final r zzb = s.b(new zzpp());

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

    @Override // H2.r
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzpo get() {
        return (zzpo) this.zzb.get();
    }
}
