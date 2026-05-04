package com.google.android.gms.internal.fido;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzep extends zzev {
    private static final zzep zza = new zzep(zzev.zze());
    private final AtomicReference zzb;

    public zzep(zzev zzevVar) {
        this.zzb = new AtomicReference(zzevVar);
    }

    public static final zzep zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.fido.zzev
    public final zzdr zza() {
        return ((zzev) this.zzb.get()).zza();
    }

    @Override // com.google.android.gms.internal.fido.zzev
    public final zzfi zzc() {
        return ((zzev) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.fido.zzev
    public final boolean zzd(String str, Level level, boolean z10) {
        ((zzev) this.zzb.get()).zzd(str, level, z10);
        return false;
    }
}
