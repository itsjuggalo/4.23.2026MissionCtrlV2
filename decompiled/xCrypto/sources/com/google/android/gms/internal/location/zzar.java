package com.google.android.gms.internal.location;

import P1.AbstractBinderC0512x;
import com.google.android.gms.common.api.internal.C0909m;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: loaded from: classes.dex */
final class zzar extends AbstractBinderC0512x {
    private final C0909m zza;

    public zzar(C0909m c0909m) {
        this.zza = c0909m;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    @Override // P1.InterfaceC0514z
    public final void zzd(LocationResult locationResult) {
        this.zza.c(new zzap(this, locationResult));
    }

    @Override // P1.InterfaceC0514z
    public final void zze(LocationAvailability locationAvailability) {
        this.zza.c(new zzaq(this, locationAvailability));
    }
}
