package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import e6.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzar extends x {
    private final l zza;

    public zzar(l lVar) {
        this.zza = lVar;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    @Override // e6.z
    public final void zzd(LocationResult locationResult) {
        this.zza.c(new zzap(this, locationResult));
    }

    @Override // e6.z
    public final void zze(LocationAvailability locationAvailability) {
        this.zza.c(new zzaq(this, locationAvailability));
    }
}
