package com.google.android.gms.internal.measurement;

import p6.s;
import p6.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpi implements s {
    private static final zzpi zza = new zzpi();
    private final s zzb = t.b(new zzpk());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // p6.s
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpj get() {
        return (zzpj) this.zzb.get();
    }
}
