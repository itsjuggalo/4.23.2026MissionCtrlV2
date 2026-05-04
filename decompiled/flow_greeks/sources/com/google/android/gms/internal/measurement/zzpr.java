package com.google.android.gms.internal.measurement;

import p6.s;
import p6.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpr implements s {
    private static final zzpr zza = new zzpr();
    private final s zzb = t.b(new zzpt());

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

    @Override // p6.s
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzps get() {
        return (zzps) this.zzb.get();
    }
}
